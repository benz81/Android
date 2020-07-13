const connection = require('./mysql_connection.js')

// 작가의 fname 과 lname 을 합쳐서,  full_name 이라는 컬럼으로 조회하시오.
let query = 'select concat(author_fname, " ", author_lname) as full_name \
            from books;'

query = 'select concat( substring(title, 1, 10)  , "..." ) \
        as "short title"  \
        from books;'

query = 'select concat(title, " was released in ", released_year) \
        as blurb \
        from books;'

query = 'select title, char_length(title) as "character count" \
        from books;'


query = 'select title, released_year  \
from books \
order by released_year desc \
limit 5;'


query = 'select title, pages \
from books \
order by pages desc limit 1;'


query = 'select count(*) as cnt \
from books \
where title like "%the%";'


query = 'select released_year, count(*) as cnt \
from books \
group by released_year;'

query = 'select released_year, count(*) as cnt, avg(pages) as "avg pages" \
from books \
group by released_year;'

connection.query(query, function(error, results, fields){
    console.log(results)
})

connection.end()


