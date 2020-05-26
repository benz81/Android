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

-- 프라이머리 키 ( Primary Key ) - 데이터 중복없이 유니크하게 처리하자.
create table unique_cats (
	cat_id int NOT NULL,
    name varchar(100),
    age int,
    primary key (cat_id)
);
desc unique_cats;
insert into unique_cats (cat_id, name, age)
	values (1, "Fred", 4 );
insert into unique_cats (cat_id, name, age)
	values (2, "Louise", 3);
select * from unique_cats;
-- 캣 아이디가 동일한 숫자로, 새로운 데이터를 저장하는 경우
insert into unique_cats (cat_id, name, age)
	values (1, "James", 5);
insert into unique_cats (name, age)
	values ("James", 5);
-- Duplicate entry '1' for key 'PRIMARY'
select * from unique_cats;
-- 프라이머리 키 값을, 내가 눈으로 확인해서 넣지 말고,
-- 데이터베이스가 자동으로 알아서 계산해서 넣어주는 방법.
-- AUTO_INCREMENT (소문자도 동일)
create table unique_cats2 (
	cat_id int not null auto_increment,
    name varchar(100),
    age int,
    primary key (cat_id)
);
desc unique_cats2;
-- cat_id 는 not null 이라서, insert할때 값을 꼭 써줘야 합니다.
-- 그런데, cat_id는 auto_increment 로 설정했으므로,
-- 디비가 알아서 값을 채워주니까, 우리가 인서트에 값 넣을 필요 없다.
insert into unique_cats2 (name, age)
	values ("Skippy", 4);
select * from unique_cats2;

insert into unique_cats2 (name, age)
	values ("Jiff", 3);
select * from unique_cats2;

-- 테이블 설계
-- 테이블 명 : employees
-- id : 숫자 ( 자동 증가 ), 필수, 프라이머리키
-- last_name : 문자(30개) , 필수
-- first_name : 문자(30개) , 필수
-- middle_name : 문자 (30개), 필수 아님
-- age : 숫자 , 필수
-- current_status : 문자(20자), 필수아님 , 디폴트로 "employed" 
-- 첫번째 방법
create table employees (
	id int not null auto_increment,
    last_name varchar(30) not null,
    first_name varchar(30) not null,
    middle_name varchar(30),
    age int not null,
    current_status varchar(20) default "employed",
    primary key (id)
);
-- 두번째 방법
create table employees (
	id int not null auto_increment primary key,
    last_name varchar(30) not null,
    first_name varchar(30) not null,
    middle_name varchar(30),
    age int not null,
    current_status varchar(20) default "employed"    
);

-- cats 테이블 삭제하고 새로 만듭니다.
drop table cats;

create table cats(
	cat_id int not null auto_increment primary key,
    name varchar(100),
    breed varchar(100),
    age int
);
desc cats;
-- 데이터를 한번에 여러개를 insert 
insert into cats (name, breed, age)
		values	("Ringo", "Tabby", 4),
				("Cindy", "Maine Coon", 11),
                ("Dumbleddore", "Maine Coon", 11),
                ("Egg", "Persian", 4),
                ("Misty", "Tabby", 13),
                ("George Michael", "Ragdoll", 9),
                ("Jackson", "Sphynx", 7);
                
select * from cats;

-- 저장되어 있는 값을, 다른 값으로 바꾸는 것이 update

-- 품종이 Tabby 인것들을, 품종을 Shorthair 로 변경한다.
-- update cats set breed = "Shorthair"  where breed = "Tabby"	
-- Error Code: 1175. You are using safe update mode and 
-- you tried to update a table without a WHERE 
-- that uses a KEY column To disable safe mode, 
-- toggle the option in 
-- Preferences -> SQL Editor and reconnect.	0.000 sec

update cats set breed = "Shorthair" 
where breed = "Tabby" and cat_id > 0;

select * from cats;

-- 이름이 Misty 인 고양이 나이를 14로 변경하세요.
update cats set age = 14
where name = "Misty" ;

select * from cats;













































