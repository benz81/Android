select author_lname from books;
-- 작가이름에 중복된 이름 제거하고 유니크하게 만들어서 조회.
select distinct author_lname from books;

select concat(author_fname, " ",author_lname) 
from books;
-- full name을 중복 제거해서 조회.
select distinct concat(author_fname, " ",author_lname) 
from books;

-- 정렬, 순서
-- 작가의 라스트이름으로 정렬해서 라스트이름 조회
select author_lname 
from books
order by author_lname;
-- 책의 이름을 조회하되, 알파벳 반대 순으로 조회.
select title 
from books
order by title desc;
-- 출판년도의 오름차순으로 책제목과 출판년도를 조회.
select title, released_year
from books
order by released_year asc;
-- 정렬 조건이 두개인 경우
select title, author_fname, author_lname 
from books 
order by author_lname asc, author_fname desc;

-- limit, offset   
-- => limit 3     : 3은 갯수
-- => limit 3, 10 : 3은 offset, 10은 갯수
-- 제목을 3개만 조회하시오.
select title 
from books
limit 3;

select title from books limit 1;

select * from books limit 5;
-- 3번째 데이터부터 4개의 데이터를 가져와서, 책 제목만 조회하시오.
select * from books;
select title from books limit 2, 4;

-- 아래 두 sql은 같은 문장. 처음부터 데이터를 6개 가져와라.
select title from books limit 0, 6;
select title from books limit 6;
-- 실무에서 페이징할때 사용한다.
-- select title from books limit 0, 30;
-- select title from books limit 30, 30;
-- select title from books limit 60, 30;
-- select title from books limit 90, 30;

-- 책 발행년도가 최신인 책 5권의 책 제목과 발행년도로 조회하시오.
select title, released_year
from books
order by released_year desc
limit 5;

-- 가장 발행된지 오래된 책 찾아서 제목과 발행년도, 작가lname 조회
select title, released_year, author_lname
from books
order by released_year
limit 1;

-- 책 제목을 조회하되,  5번째 책부터 전부 가져오시오.
select title
from books
limit 4, 9999999999 ;

-- like  (search 검색)
-- da 로 시작하는 작가의 이름을 찾아서, 책 제목과 작가명을 조회.
select title, author_fname
from books
where author_fname like "da%";
-- da 가 들어있는 작가의 이름을 찾아서, 책 제목과 작가명을 조회.
select title, author_fname
from books where author_fname like "%da%";
-- 제목에, the 로 시작하는것, the 가 들어있는것, the로 끝나는것.
select title from books where title like "the%";
select title from books where title like "%the%";
select title from books where title like "%the";
















































