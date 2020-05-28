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







