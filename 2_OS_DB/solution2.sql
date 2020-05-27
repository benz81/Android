-- 1
select title from books
where title like "%stories%";

-- 2
select title, pages from books
order by pages desc limit 1;

-- 3
select concat( title, " - ", released_year ) as summary
from books
order by released_year desc 
limit 3;

-- 4
select title, author_lname
from books
where author_lname like "% %";

-- 5
select title, released_year, stock_quantity
from books
order by stock_quantity 
limit 3;

-- 6
select title, author_lname
from books
order by author_lname, title;

select title, author_lname
from books
order by 2, 1;

-- 7
select concat("MY FAVORITE AUTHOR IS ",
		upper(author_fname), 
        " ",
        upper(author_lname) )    as yell
from books
order by author_lname;










