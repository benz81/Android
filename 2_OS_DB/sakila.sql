use sakila;

select first_name, last_name 
from actor;

-- 퍼스트네임과 라스트네임을 붙여서, 'Actor Name' 별칭으로 출력
select concat(first_name," " ,last_name) as "Actor Name"
from actor;

select lower(concat(first_name," " ,last_name)) as "Actor Name"
from actor;

select upper(concat(first_name," " ,last_name)) as "Actor Name"
from actor;

select lower(first_name)
from actor;

-- 퍼스트네임이 Joe인 배우의 액터아이디, 퍼스트네임, 라스트네임 조회.
select actor_id, first_name, last_name
from actor
where first_name = "Joe";



-- 컨트리 테이블을 조회해 보시고,
-- 컨트리 테이블에서 컨트리가 
-- Afghanistan, Bangladesh, China 인  
-- 컨트리 아이디와 컨트리를  조회하시오.
select country_id, country 
from country
where country in ("Afghanistan", "Bangladesh", "China");

-- 액터 테이블에 middle_name 컬럼을 추가할 겁니다.
-- 이 컬럼의 위치는 , 퍼스트네임 다음에 위치합니다.
-- 이 컬럼의 데이터는 문자열 20개 까지 저장하는 컬럼입니다.
alter table actor
add column middle_name varchar(20)
after first_name;
-- middle_name 컬럼 삭제하는 SQL
alter table actor
drop column middle_name;
-- 우리는 테이블과 컬럼 조작은 마우스로 합니다.

-- 라스트네임렬로 묶되, 같은 라스트네임이 몇개씩이었는지 세어서 출력.
-- 라스트네임과 카운팅한 숫자를 조회합니다.

select last_name, count(last_name)
from actor
group by last_name;
-- 위의 결과에서, 사람수가 3명 이상인 데이터만 조회
select last_name, count(last_name) as cnt
from actor
group by last_name having cnt >= 3;

-- 퍼스트네임이 GROUCHO 이고, 라스트네임이 WILLIAMS 인  
-- 이 사람의 퍼스트네임을 HARPO 로 변경하세요.
update actor 
set  first_name = "HARPO" 
where first_name = "GROUCHO" and last_name = "WILLIAMS";

select * 
from actor 
where first_name = "HARPO" and last_name = "WILLIAMS";

















