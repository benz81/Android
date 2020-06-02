-- 티비 쇼 제목과 별점을 조회하시오.
select s.title, r.rating
from series as s
join reviews as r
on s.id = r.series_id;
-- 티비쇼의 제목별, 별점평균을 조회하시오.
select s.title, avg(r.rating) as average
from series as s
join reviews as r
on s.id = r.series_id
group by s.title ;

-- 리뷰어의 이름(2개다)과, 그 사람이 준 별점을 조회하세요.
select r.first_name, r.last_name, rv.rating
from reviewers as r
join reviews as rv
on r.id = rv.reviewer_id;

-- 티비쇼 중에서 별점이 없는것들을, 제목으로 조회하시오.
select s.title
from series as s
left join reviews as rv
on s.id = rv.series_id
where rv.rating is null;
-- 각 장르별로 , 장르와 장르의 별점평균을 조회하세요. 
-- (단, 별점평균은 소수점 2자리까지만 나오도록 하세요.)
select s.genre, round( avg(rv.rating) , 2) as average
from series as s
join reviews as rv
on s.id = rv.series_id
group by s.genre;

use mydb;


-- 리뷰 작성을 안한 사람도 표시하되(0으로), 사람별로 각 리뷰의 갯수,
-- 리뷰의 최소별점(rating), 최대별점, 평균별점을 조회하고,
-- 리뷰 갯수가 0보다 크면, "ACTIVE", 그렇지 않으면 "INACTIVE"로 
-- 표시 ( 컬럼명은 status) 

-- first_name, lst_name, count, min, max, avg, status
select r.first_name, r.last_name, count(rv.rating) as count,
	round(min( ifnull(rv.rating,0)),2) as min, 
    round(max(ifnull(rv.rating,0)),2) as max, 
    round(avg( ifnull(rv.rating,0)) , 2) as avg,
    if( count(rv.rating) > 0, "ACTIVE", "INACTIVE") as status
from reviewers as r
left join reviews as rv
on r.id = rv.reviewer_id
group by r.id ;

select first_name, last_name, 
	count(rv.rating) as count,
	round(ifnull( min(rv.rating), 0), 2) as min,
    round(ifnull( max(rv.rating), 0), 2) as max,
    round( ifnull(avg(rv.rating), 0), 2) as avg,
    case
		when count(rv.rating) >= 10 then "POWER USER"
		when count(rv.rating) > 0 then "ACTIVE"
        else "INACTIVE"
    end as status
from reviewers as r
left join reviews as rv
on r.id = rv.reviewer_id
group by r.id;
    




-- 영화제목으로 알파벳 오름차순 정렬해서, 
-- 영화제목, 별점, 리뷰작성자이름(합쳐서) 조회하시오.
select s.title, rv.rating, 
	concat( r.first_name, " ",r.last_name) as reviewer
from reviewers as r
join reviews as rv
on r.id = rv.reviewer_id
join series as s
on s.id = rv.series_id
order by s.title;





