-- 테이블 이름 : pastries 
-- 컬럼은 2개 
-- name 컬럼 : 문자50개까지만 저장
-- quantity 컬럼 : 정수

-- 데이터베이스를 먼저 선택. 
-- mydb 우리 실습용 데이터베이스 먼저 생성합니다.
create database mydb;
-- 해당 db로 이동
use mydb;
create table pastries
(
	name varchar(50),
    quantity int
);
show tables;
-- 테이블의 컬럼 확인
desc pastries;
-- 테이블 삭제
drop table pastries;
-- 고양이 정보 저장 테이블 생성
-- 테이블명 : cats
-- 컬럼은 2개
-- name : 문자 50개까지 저장
-- age : 나이저장. 정수로 저장.
create table cats
(
	name varchar(50),
    age int
);
-- 데이터를 넣겠습니다. 
-- 이름은 Blue 나이는 1
insert into cats (name, age) values ("Blue",1);

select * from cats;

insert into cats (age, name) values (11, "Draco");

select * from cats;
-- 위에서는 데이터를 1개씩 넣었다.

-- 데이터를 여러행으로 한번에 저장하는 방법
insert into cats (name, age)
		values ('Charlie', 10),
				('Sadie', 3),
                ('Lazy Bear', 1);
                
select * from cats;

-- people 테이블 생성
-- 컬럼 first_name : 문자20개까지
-- 컬럼 last_name : 문자 20개까지
-- 컬럼 age  :  정수 

-- Tina  ,  Belcher ,  13
-- Bob , Belcher , 42
create table people (
	first_name varchar(20),
    last_name varchar(20),
    age int
);
insert into people (first_name, last_name, age)
		values	("Tina", "Belcher", 13) ,
				("Bob", "Belcher", 42);
select * from people;
insert into people (first_name, last_name, age)
		values 	("Linda", "Belcher", 45),
				("Phillip", "Frond", 38),
                ("Calvin", "Fischoeder", 70);
                
select * from people;
show databases;
show tables;
desc people;
-- 텍스트를 저장하려고 하는데, "I'm your farther."
-- first_name : "I'm your farther."
-- last_name : "hello"
-- age : 30
insert into people (first_name, last_name, age)
		values	("I'm your farther.", "hello", 30);

select * from people;
-- first_name : "He said "Hi"."
-- last_name : "hello"
-- age : 30
-- 문자열 안에 작은따옴표나 큰따옴표가 들어갈 경우. \(역슬래시)를 써준다
insert into people (first_name, last_name, age)
		values	( "He said \"Hi\".", "hello", 30);

select * from people;


















