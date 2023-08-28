use myDatabase;
CREATE TABLE TEST(
rec_ID INT,
name VARCHAR(50) 
)

drop table TEST;

update passwords
set pass_word = 'RandPass'
WHERE Account = 'PlanetFitness';

select * From passwords;
/*Just some code I found reresenting the basics of sql */