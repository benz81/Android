-- 1
select replace(title, " ", "->") as title
from books;

-- 2
select author_lname as forwards ,   
		reverse(author_lname) as backwards
from books;

-- 3
select  upper( concat(author_fname, " ", author_lname) )
as "full name in caps"
from books;
-- 4
select  concat(title," was released in ",released_year)
as blurb
from books;

-- 5
select title,  char_length(title) as "character count"
from books;

-- 6
select  concat( substring(title, 1, 10) , "...") 
		as "short title",
concat(author_lname,",", author_fname ) as author, 
concat(stock_quantity, " in stock") as quantity
from books;










