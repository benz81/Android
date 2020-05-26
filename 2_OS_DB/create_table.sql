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

-- cats 테이블에 데이터 인서트, 이름은 아래 문자열.
-- "This cat is named Charlie which is also a human name. 
--  In fact I know a couple of Charlies. Fun Fact"
-- 나이는 10살.
insert into cats (name, age)
	values ("This cat is named Charlie which is also a human name. In fact I know a couple of Charlies. Fun Fact",
			10);
desc cats;

-- NULL 이란것, 값이 없다.
-- 0 이다 라는것과는 다른것이다.
-- NULL 이란것은, 공백 과도 다른것이다.
insert into cats (name)
		values ("Alabama");
select * from cats;

insert into cats ()
		values ();
        
select * from cats;

-- 컬럼 정의할때, NOT NULL 키워드를 사용하여 테이블 생성하는 경우
-- 테이블생성 . 테이블명 : cats2
-- 컬럼 name : 문자열100개까지, 그리고 NOT NULL
-- 컬럼 age : 정수, 그리고 NOT NULL
create table cats2 
(
	name varchar(100) not null,
    age int not null
);
desc cats2;
desc cats;
select * from cats;

-- cats2 ( Not NULL ) 테이블에 데이터를 인서트
insert into cats2 (name, age) 
		values ("Mit", 3);
select * from cats2;
insert into cats2 (name) 
		values  ("Young");
select * from cats2;

insert into cats2 (age)
		values  (10);
select * from cats2;

-- cats3 테이블 생성
create table cats3 
(
	name varchar(100) not null,
    age int 
);
insert into cats3 (name, age) values ("Hi", 3);
select * from cats3;
insert into cats3 (age) values (5);
select * from cats3;
insert into cats3 (name) values ("Momo");
select * from cats3;
select * from cats;

desc cats;

-- 회사의 정책이 바뀌어서, name이 없으면 null 이 아니라, "unnamed"로
-- age 가 없으면, null 이 아니라, 99 세로 설정하시오.
-- 라고 회사 정책이 정해졌다.
create table cats4 
(
	name varchar(100) default "unnamed",
    age int default 99
);
insert into cats4 (name, age) values ("Momo", 3);
select * from cats4;
insert into cats4 (name) values ("Kity");
select * from cats4;
insert into cats4 (age) values (10);
select * from cats4;
insert into cats4 () values ();
select * from cats4;












