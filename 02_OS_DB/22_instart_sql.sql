use instar;
-- 회원 중에서, 가입한지 가장 오래된 회원들 5명을 조회하시오.
select * 
from users 
order by created_at
limit 5;
-- 회원가입이 가장 많이 일어난 요일 , 그 요일과 가입회원수를 조회하시오.
desc users;
select dayname("2020-06-01 11:23:44");

select dayname(created_at) as day, count(*) as total
from users
group by day
order by total desc
limit 1;

-- 회원들 중에서, 사진이 없는 회원들의 이름을 조회하시오.
-- ( inactive user vs active user )
select u.username, p.image_url
from users as u
left join photos as p
on u.id = p.user_id
where p.image_url is null;

-- 가장 좋아요(인기가 많은)를 많이 받은 사진의,  
-- 사진작성자, 사진url, 좋아요수 를 조회하시오.
select u.username, p.image_url, count(*) as likes
from photos as p
join likes as l
on l.photo_id = p.id
join users as u
on p.user_id = u.id
group by p.id
order by likes desc limit 1;















