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




















