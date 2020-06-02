-- 1
select * 
from books
where author_lname = "Eggers" or author_lname = "Chabon";

-- 2
select title, pages
from books
where released_year < 1980 and pages <= 500;

-- 3
select sum(pages)
from books
where author_lname = "Eggers" or author_lname = "Lahiri";

-- 4
select min(released_year)
from books
where stock_quantity between 60 and 100;

select released_year
from books
where stock_quantity between 60 and 100
order by released_year asc limit 1;

-- 5 
select count(*), sum(stock_quantity)
from books
where char_length(title) >= 30;

-- 6
select released_year as year, count(*) as cnt, sum(pages) as pages
from books
group by released_year;














