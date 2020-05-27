-- 갯수세기  count() 
select count(*) from books;

-- author_fname 전부 몇개??
select count(author_fname) from books;
-- 문제는? 중복된 사람이 존재.
select count( distinct author_fname ) from books;

-- author_lname 전부 몇개??
select count( distinct author_lname ) from books;

-- 책제목에 the 라고 들어있는 책은, 몇권인가???
select count(*)
from books
where title like "%the%";

-- 작가의 lname, fname 둘다 중복 제거한 갯수를 구하시오.
select count(distinct author_lname, author_fname )
from books;

select author_lname, count(*)
from books 
group by author_lname;
-- 연도별 책 몇권이 있는지 조회.
select released_year, count(*) 
from books
group by released_year;

select  released_year, count(*) 
from books
group by released_year;
-- 책 발간년도가 가장 최소인 발간연도를 구하시오.
select min(released_year)
from books;

-- 책이 페이지가 가장 많은 책은 몇페이지짜리 책이냐?
select max(pages)
from books;
-- 페이지가 가장 많은 책의 책 제목은 무엇입니까?
select max(pages), title
from books;
-- 위의 쿼리는 문제가 있습니다. 책 제목이 다릅니다.
-- 첫번째 해결책 : 서브쿼리 (subquery)
select title, pages from books
where pages = ( select max(pages) from books);
-- 두번째 해결책 : 정렬 + limit
select title, pages
from books
order by pages desc limit 1;

-- 페이지수가 가장 작은 책의 제목과 페이지수를 조회하시오.
select title, pages
from books
where pages = ( select min(pages) from books );

select title, pages
from books 
order by pages asc limit 1;
-- 작가별로, 각 작가의 최초 책 발간년도를 조회하시오.
-- 조회시, 작가의 이름도 나오도록 조회하시오.
-- author_fname, author_lname
select author_fname, author_lname, min(released_year)
from books
group by author_fname, author_lname;

-- 각 작가별로, 자신이 쓴 책의 페이지수가 가장 많은 책의
-- 페이지수를 조회하시오. 작가 이름도 같이 나오도록 조회.
select author_fname, author_lname, max(pages) as longest
from books
group by author_fname, author_lname
order by longest desc;

-- 북 테이블에 있는 모든 책의 페이지수를 다 더하면 몇페이지 입니까?
select sum(pages) from books;

-- 각 작가별로, 자신이 지금까지 쓴 책의 총 페이지수는 얼마인지 조회하시오.
-- 작가 이름도 같이 나오도록 조회.

select author_fname, author_lname, sum(pages)
from books
group by author_fname, author_lname
order by sum(pages) desc;

-- 책 출간년도의 평균을 알고싶습니다. 
select avg(released_year)
from books;

-- 출간년도가 같은 책들의 , stock_quantity 의 평균은 얼마인지 조회하시오.
-- 출간년도도 같이 조회되도록 하시오.
select released_year, avg(stock_quantity)
from books
group by released_year
order by released_year desc;

-- 각 발간년도마다 몇권의 책이 발간되었는지 조회하세요.
-- 년도도 같이 나오도록 조회하세요.
select released_year, count(*)
from books
group by released_year
order by count(*) desc;

-- 이 테이블에 있는 stock_quantity 는 전부 몇입니까?
select sum(stock_quantity)
from books;

-- 각 발간년도별로, 책의 갯수와, 평균 페이지수를 조회하세요.
-- 년도도 같이 조회되도록 하세요.
select released_year, count(*) as cnt, avg(pages) as avg
from books
group by released_year;

-- date : "YYYY-MM-DD" 이런 형식으로 저장. "2020-05-28"
-- time : "HH:MM:SS" 이런 형식으로 저장. "23:11:23"
-- datetime : "YYYY-MM-DD HH:MM:SS" , "2020-05-28 23:11:16"
create table people2 
(
	name varchar(100),
    birthdate Date,
    birthtime Time,
    birthdt datetime
);

insert into people2 (name, birthdate, birthtime, birthdt)
values ("Padma", "1989-11-11", "20:07:35", "1989-11-11 20:07:35");

insert into people2 (name, birthdate, birthtime, birthdt)
values ("Larry", "1992-10-21", "13:17:30", "1992-10-21 13:17:30");

select * from people2;
-- curdate() : 현재 날짜를 가져오는 함수
select curdate();

-- curtime() : 현재 시간을 가져오는 함수
select curtime();

-- now() : 현재 날짜 + 시간 
select now();

insert into people2 (name, birthdate, birthtime, birthdt)
values ("Mike", curdate(), curtime(), now());

select * from people2;
select name, birthdate from people2;
-- 날짜만 조회
select name, day(birthdate) from people2;
-- 요일로 조회
select name, dayname(birthdate) from people2;
-- 1:일요일,,, 수요일 :4  ,, 7:토요일
select name, dayofweek(birthdate) from people2;
-- 해당년도의 날자 수
select name, dayofyear(birthdate) from people2;
-- 해당 월만 조회
select name, month(birthdt) from people2;
-- 해당 월을 영문으로 조회.
select name, monthname(birthdt) from people2;
-- 시간 조회
select name, hour(birthdt) from people2;
-- 분 조회
select name, minute(birthdt) from people2;
-- 초
select name, second(birthdt) from people2;
-- 년도
select name, year(birthdt) from people2;

select date_format(birthdt, "Was born on a %W") from people2;
select date_format(birthdt, "%Y/%m/%d") from people2;
select date_format(birthdt, "%Y/%m/%d at %h:%i") from people2;

-- 두 날짜의 차이를 구해달라. 날짜수.
select datediff( now() , birthdate  ) from people2;

select  birthdt, date_add(birthdt, interval 1 month) 
from people2;

select  birthdt, date_add(birthdt, interval 10 second) 
from people2;

select  birthdt, date_add(birthdt, interval 15 day) 
from people2;

select  birthdt, date_add(birthdt, interval 3 year) 
from people2;

select birthdt, birthdt + interval 1 month from people2;
select birthdt, birthdt - interval 5 month from people2;
select birthdt, birthdt + interval 15 month + interval 10 hour
from people2;

select * from people2;
select name 
from people2
where day(birthdt) = 27;

-- timestamp
create table comments (
	content varchar(100),
    created_at timestamp default now()
);
insert into comments (content)
		values ("I found");
select * from comments;


create table comments (
	content varchar(100),
    created_at timestamp default now(),
    changed_at timestamp default now() on update current_timestamp
);
insert into comments (content)
		values ("Hello");
insert into comments (content)
		values ("I found");
insert into comments (content)
		values ("Bye");
select * from comments;

update comments set content = "Hi"
where content = "Hello";

select * from comments;

select * from comments
order by changed_at desc;



























































