/*
 * triangle.c
 *
 *  Created on: Aug 28, 2017
 *      Author: Thumrongsak Kosiyatrakul
 */


#ifdef __APPLE__  // include Mac OS X verions of headers

#include <OpenGL/OpenGL.h>
#include <GLUT/glut.h>

#else // non-Mac OS X operating systems

#include <GL/glew.h>
#include <GL/freeglut.h>
#include <GL/freeglut_ext.h>

#endif  // __APPLE__

#include <stdio.h>
#include <stdlib.h>
#include "initShader.h"
#include "myLib.h"


#define BUFFER_OFFSET( offset )   ((GLvoid*) (offset))
#define TOTAL_VERTS 63

mat4 translate(GLfloat x, GLfloat y, GLfloat z)//moves objects by x,y,z
{
	mat4 result = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
	result.w.x = x;
	result.w.y = y;
	result.w.z = z;
	return result;
}

GLuint ctm_location;//handles currrent transformation matrix
mat4 ctm = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
GLfloat x_value = 0;//used for animation i think 

// top triangle
vec4 vertices[TOTAL_VERTS] = {//should be 63
    //triangle
    {-0.60f,  0.80f, 0.0f, 1.0f},  // top rainbow tri
    {-0.80f,  0.40f, 0.0f, 1.0f},  // BL
    {-0.40f,  0.40f, 0.0f, 1.0f},   // BR

{ 0.35f, 0.85f, 0.0f, 1.0f}, // TL. GREEN SQUARE 
{ 0.75f, 0.85f, 0.0f, 1.0f}, // TR 
{ 0.35f, 0.40f, 0.0f, 1.0f}, // BL 
{ 0.75f, 0.85f, 0.0f, 1.0f}, // TR
{ 0.75f, 0.40f, 0.0f, 1.0f}, // BR
{ 0.35f, 0.40f, 0.0f, 1.0f}  // BL
};

vec4 colors[TOTAL_VERTS] = {
    {1.0f, 0.0f, 0.0f, 1.0f},  // red
    {0.0f, 1.0f, 0.0f, 1.0f},  // green
    {0.0f, 0.0f, 1.0f, 1.0f},   // blue

    {0,1,0,1}, {0,1,0,1}, {0,1,0,1}, //per-vertex colors for rainbow tri
    {0,1,0,1}, {0,1,0,1}, {0,1,0,1}
};
//top triangle end
int num_vertices = 9;

// --- helper to append one upright triangle (BL, BR, TOP) into arrays ---
static int write_index = 9; // first free slot (we already used 0..8)

void push_triangle(vec4 bl, vec4 br, vec4 top, vec4 col)
{
    if (write_index + 3 > TOTAL_VERTS) return; // safety
    vertices[write_index + 0] = top;  colors[write_index + 0] = col;
    vertices[write_index + 1] = bl;   colors[write_index + 1] = col;
    vertices[write_index + 2] = br;   colors[write_index + 2] = col;
    write_index += 3;
}

void init(void)
{
    
    // generate the triangles
    const int rows = 3;
    const int cols = 6;

    const GLfloat startX = -1.0f;//start at left edge
    const GLfloat baseW  = 2.0f / 6.0f;//six columns to x = 1.0
    const GLfloat stepX  = baseW;
    const GLfloat height = (0.0f - (-1.0f)) / 3.0f;   // half the screen divided by 3 rows

    const vec4 rowColor[3] = {//set this up wrong. compensate by doing rows-1-r
        {1,0,0,1}, // r
        {0,1,0,1}, // gw
        {0,0,1,1}  // b
    };

    for (int r = 0; r < rows; ++r)
    {
        for (int c = 0; c < cols; ++c)
        {
                GLfloat x0 = startX + c * stepX;//left x of triangle
                GLfloat y0 = -1.0f + r * height;//base y of row
                vec4 bl  = { x0,y0,0, 1 };
                vec4 br  = { x0 + baseW,y0,0, 1 };
                vec4 top = { x0 + baseW*0.5f, y0 + height, 0, 1 };

            push_triangle(bl, br, top, rowColor[rows - 1 - r]);
        }
    }
     num_vertices = write_index;  //should be 63 but just in case

    GLuint program = initShader("vshader.glsl", "fshader.glsl");
    glUseProgram(program);

    GLuint vao;
    glGenVertexArraysAPPLE(1, &vao);
    glBindVertexArrayAPPLE(vao);

    GLuint buffer;
    glGenBuffers(1, &buffer);
   
    glBindBuffer(GL_ARRAY_BUFFER, buffer);
    GLsizeiptr verts_bytes = (GLsizeiptr)(num_vertices * sizeof(vec4));//calc bytes needed
    GLsizeiptr cols_bytes  = (GLsizeiptr)(num_vertices * sizeof(vec4));//calc bytes needed
    glBufferData(GL_ARRAY_BUFFER, verts_bytes + cols_bytes, NULL, GL_STATIC_DRAW);//allocate space static draw means use many times set once
    glBufferSubData(GL_ARRAY_BUFFER, 0,           verts_bytes, vertices);//upoload vert 
    glBufferSubData(GL_ARRAY_BUFFER, verts_bytes, cols_bytes,  colors);//uplodoads colors right after verts

    GLuint vPosition = glGetAttribLocation(program, "vPosition");
    glEnableVertexAttribArray(vPosition);
    glVertexAttribPointer(vPosition, 4, GL_FLOAT, GL_FALSE, 0, BUFFER_OFFSET(0));

    GLuint vColor = glGetAttribLocation(program, "vColor");
 
    glEnableVertexAttribArray(vColor);

    glVertexAttribPointer(vColor, 4, GL_FLOAT, GL_FALSE, 0, (GLvoid *) verts_bytes);

	ctm_location = glGetUniformLocation(program, "ctm");

	printf("ctm_location:%i\n", ctm_location);

    glEnable(GL_DEPTH_TEST);
    glClearColor(0.0, 0.0, 0.0, 1.0);
    glDepthRange(1,0);
}

void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

   // glPolygonMode(GL_FRONT, GL_FILL);
    //glPolygonMode(GL_BACK, GL_LINE);

	glUniformMatrix4fv(ctm_location, 1, GL_FALSE, (GLfloat *) &ctm);

    glDrawArrays(GL_TRIANGLES, 0, num_vertices);

    glutSwapBuffers();
}

void keyboard(unsigned char key, int mousex, int mousey)
{
    if(key == 'q')
    	exit(0);

    glutPostRedisplay();
}

void idle(void)
{
    //no need for animations yet
	/*if(isGoingRight)
	{
		x_value += 0.005;
		if(x_value > 1.0)
		{
			x_value = 1.0;
			isGoingRight = 0;
		}
	}
	else
	{
		x_value -= 0.005;
		if(x_value < -1.0)
		{
			x_value = -1.0;
			isGoingRight = 1;
		}
	}

	ctm = translate(x_value, 0.0, 0.0);
	glutPostRedisplay();*/
}

int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_DEPTH);
    glutInitWindowSize(1000, 1000);
    glutInitWindowPosition(100,100);
    glutCreateWindow("Lab 3");
    //glewInit();
    init();
    glutDisplayFunc(display);
    glutKeyboardFunc(keyboard);
	//glutIdleFunc(idle);
    glutMainLoop();

    return 0;
}
