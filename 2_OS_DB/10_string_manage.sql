use mydb;

create table books (
	book_id int not null auto_increment,
    title varchar(100),
    author_fname varchar(100),
    author_lname varchar(100),
    released_year int,
    stock_quantity int, 
    pages int,
    primary key(book_id)
);


INSERT INTO books (title, author_fname, author_lname, released_year, stock_quantity, pages)
VALUES
('The Namesake', 'Jhumpa', 'Lahiri', 2003, 32, 291),
('Norse Mythology', 'Neil', 'Gaiman',2016, 43, 304),
('American Gods', 'Neil', 'Gaiman', 2001, 12, 465),
('Interpreter of Maladies', 'Jhumpa', 'Lahiri', 1996, 97, 198),
('A Hologram for the King: A Novel', 'Dave', 'Eggers', 2012, 154, 352),
('The Circle', 'Dave', 'Eggers', 2013, 26, 504),
('The Amazing Adventures of Kavalier & Clay', 'Michael', 'Chabon', 2000, 68, 634),
('Just Kids', 'Patti', 'Smith', 2010, 55, 304),
('A Heartbreaking Work of Staggering Genius', 'Dave', 'Eggers', 2001, 104, 437),
('Coraline', 'Neil', 'Gaiman', 2003, 100, 208),
('What We Talk About When We Talk About Love: Stories', 'Raymond', 'Carver', 1981, 23, 176),
("Where I'm Calling From: Selected Stories", 'Raymond', 'Carver', 1989, 12, 526),
('White Noise', 'Don', 'DeLillo', 1985, 49, 320),
('Cannery Row', 'John', 'Steinbeck', 1945, 95, 181),
('Oblivion: Stories', 'David', 'Foster Wallace', 2004, 172, 329),
('Consider the Lobster', 'David', 'Foster Wallace', 2005, 92, 343);

select * from books;

-- concat 함수 : 문자열 합치기
select author_fname, author_lname from books;

-- concat(컬럼이름, 컬럼이름, 컬럼이름 ,,,, )
select concat("Hello", "World", "Bye");

-- 두개의 분리된 컬럼을, 하나의 컬럼으로 합쳐서 조회
select concat(author_fname," ", author_lname) as author 
from books;

--  "책제목-작가이름-작가의성" 이 나오도록 조회하되, 
-- 컬럼명은 title_author 로 나오도록 하세요.
select concat(title, "-", author_fname, "-", author_lname)
as title_author
from books;

select concat_ws(" / ", title, author_fname, author_lname)
as title_author
from books;

-- substring() 함수 : 문자열의 일부분을 가져오는 함수.
select substring("Hello World", 3);
select substring("Hello World", 1, 4);
select substring("Hello World", -3);
select substring("Hello World", 4, 2);
-- 책 제목을 조회하시오.
select title 
from books;

-- 책 제목을 조회하되, 제목이 처음부터 10글자 까지만 나오도록 조회.
select substring(title, 1, 10) 
from books;
-- 조회 결과가 아래처럼 나오도록 하시오.
-- The Namesa...
-- Norse Myth...
-- American G...
-- Interprete...
select concat( substring(title, 1, 10) , "..." )
as title
from books;

-- replace() 함수 : 문자열에서 원하는 문자열을 바꾼다.
select replace("Hello World", "Hell", "Heaven");

select replace("Hello World", "l", "7");

select replace("cheese bread coffee milk", " ", " and ");

-- 타이틀에서 e 가 들어있으면, e를 3으로 변경하여서, 타이틀을 조회하시오.
select replace(title, "e", "3") as title
from books;

-- reverse() 함수 : 문자열의 순서를 역순으로 바꿔준다.
select reverse("Hello World");

-- 작가의 이름과 성을 조회하되,  성 부분만 역순으로 바꿔서 조회하시오.
select author_fname, reverse(author_lname)
from books;

-- char_length() 함수 : 문자열의 수를 세주는 함수.
select char_length("Hello World");

-- 작가의 성, 작가 성 이름의 갯수  이렇게 두개를 조회하시오.
-- 단, 작가 성 이름의 갯수는, 컬럼명을 length 로 바꿔서 표시하세요.
select author_lname, char_length(author_lname) as length
from books;
-- 위의 두 컬럼을 하나로 합치되, 다음처럼 조회하시오.
-- Lahiri is 6
-- Gaiman is 6 
select concat( author_lname , " is ", char_length(author_lname)   )
as author_len
from books;

-- upper() , lower() : 대문자로 변경, 소문자로 변경.

use mydb;
select * from books;

-- 타이틀에 저장된 문자열을 대문자로 바꿔서 조회.
select upper(title) from books;

-- 책 제목을 소문자로 가져와서, My favorite book is 책제목(소문자)
select  concat( "My favorite book is ", lower(title))
from books;

















