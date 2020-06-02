-- not equal  : != 

select title from books
where released_year = 2013;

-- 2013년이 아닌 데이터들 타이틀만 조회하시오.
select title, author_fname from books
where released_year != 2013;

-- 책 제목에 W 가 들어있지 않은 책들만 제목으로 조회하시요.
select title from books
where title not like "%W%";

-- fname 이 Neil 이 아닌 사람들의 책 제목만 조회하시오.
select title from books
where author_fname != "Neil";

select * from books;

insert into books (title, author_fname, author_lname, 
released_year, stock_quantity, pages) 
values ("Hell", "Neil Mike", "Gaiman", 2020, 100, 742);

select * from books
order by book_id desc;

select author_fname, title from books
where author_fname not like "%Neil%"
order by book_id desc;

select author_fname, title from books
where author_fname != "Neil"
order by book_id desc;

-- greater than : ~ 보다 크다
-- 연도가 2000년 이후로 발간된 책의 제목과 년도를 조회하되, 발간년도가 최신순으로
-- 조회하시오.
select title, released_year 
from books
where released_year >= 2000 
order by released_year desc;

-- and : 여러 조건을 , 그리고 의미로 해석될때 사용.
-- 작가의 lname이 Eggers 이고 발간년도가 2010년 이상인 책들의 책 제목과
-- 작가 lname, 발간년도을 조회하라.
use mydb;
select title, author_lname, released_year
from books
where author_lname = "Eggers" and released_year >= 2010;

-- 작가이름이 Eggers이고 발간년도가 2010년 이상이고, 책제목에 novel 이
-- 포함된 책들의 모든 컬럼을 전부 조회하시오.
select *
from books
where author_lname = "Eggers" and released_year >= 2010 and
		title like "%novel%";

-- or : 또는 , 거나  이렇게 해석될때 사용
-- 작가이름이 Eggers 이거나 발간년도가 2010년 이상인 책들만 , 책제목과
-- 작가이름, 발간년도로 조회하시오.
select title, author_lname, released_year
from books
where author_lname = "Eggers" or released_year >=2010 ;

-- 작가이름이 Eggers 이거나 발간년도가 2010년 이상이거나 stock_quantity가 
-- 100 이상인 책들만, 모든컬럼 조회하시오.
select *
from books
where author_lname = "Eggers" or released_year >=2010 
		or stock_quantity > 100;

-- between :  뭐와 뭐 사이의 값으로 조회해달라. OO부터 ~ OO 까지

-- 발간년도가 2004년 이상이고 2015년 이하인 책 제목만 조회하시오
select title
from books
where released_year >= 2004 and released_year <= 2015;
-- 발간년도가 2004년 부터 2015년 사이에 나온 책 제목만 조회하시오.
select title
from books
where released_year between 2004 and 2015;

-- 책 발간년도가 2004년과 2015년 사이에 발간된 책이 아닌것들만, 책 제목을 조회.
select title
from books
where released_year not between 2004 and 2015;

-- people2 테이블에서, birthdt 가 1990년 부터 2010년 사이에 태어난 사람의
-- 이름과 birthdt를 조회하시오.
select name, birthdt 
from people2
where birthdt between "1990-01-01" and "2010-12-31";

select name, birthdt 
from people2
where birthdate between "1990-01-01" and "2010-12-31";

select name, birthdt 
from people2
where year(birthdt) between "1990" and "2010";

select name, birthdt
from people2
where birthdt between cast("1990-01-01" as datetime) and 
						cast("2010-12-31" as datetime);


select cast("1990-01-01" as datetime) ;

-- in / not in :  여러개 중에 포함되어 있는 것들 가져올때 / 가져오지 않을때

-- Carver, Lahiri, Smith 이 세명의 책 제목과 이름을 조회.
select title, author_lname
from books
where author_lname = "Carver" or author_lname = "Lahiri" or 
author_lname = "Smith";

select title, author_lname
from books
where author_lname in ("Carver", "Lahiri", "Smith");


































