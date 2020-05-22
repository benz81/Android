-- select 옆에, 테이블이 두개 이상일때는, * 을 쓰지 마시고, 
-- 테이블명.* 
select girl_group.* , song.*                
from girl_group
join song
on girl_group.hit_song_id = song._id;


select girl_group.* , song.*                
from girl_group , song
where girl_group.hit_song_id = song._id;

-- as 별칭을 사용하여 테이블 명칭 축소
select g.* , s.*                
from girl_group as g
join song as s
on g.hit_song_id = s._id;
-- 걸그룹 이름과 노래제목을 조회하시오.
-- 문제가 나오면,
-- 1. 관련된 전체 테이블을 확인한다. 전체 컬럼을 select 
select * from girl_group;
select * from song;
-- 2. 조회할 정보가, 하나의 테이블에 있는지 확인한다. 전체 컬럼select
-- 3. 하나의 테이블에 존재하면, 테이블 하나만 select 하고,
-- 4. 여러 테이블에 존재하면, join 을 사용하여 select 한다.
select g.name, s.title   
from girl_group as g
join song as s
on g.hit_song_id = s._id;

-- 가수 이름, 데뷔날짜를 조회하세요.
select name, debut from girl_group;

-- 데뷔날짜가 2008년1월17일인 그룹의 이름과 데뷔날짜를 조회하세요. 
select name, debut
from girl_group
where debut = "2008-01-17";

-- 데뷔년도가 2009년 1월 1일 이후에 데뷔한 그룹의 
-- 이름과, 데뷔날짜, 노래제목을 조회하세요.
select g.name, g.debut, s.title
from girl_group as g
join song as s
on g.hit_song_id = s._id
where g.debut > "2009-01-01";

-- 이름에 "스" 자가 들어가는 걸그룹의
-- 걸그룹이름과, 데뷔날짜, 타이틀을 조회하세요.
select g.name, g.debut, s.title
from girl_group as g
join song as s
on g.hit_song_id = s._id
where g.name like "%스%" ;

-- 데뷔년도가 2008년 5월 1일 이후에 데뷔한 그룹의 
-- 이름과, 데뷔날짜, 노래제목을 최근 데뷔한 걸그룹부터 조회하세요.
select g.name, g.debut, s.title
from girl_group as g
join song as s
on g.hit_song_id = s._id
where g.debut > "2008-05-01"
order by g.debut desc;


--

select g.*, s.* 
from girl_group as g
join song as s
on g.hit_song_id = s._id;

-- left outer join
select g.*, s.*
from girl_group as g
left join song as s
on g.hit_song_id = s._id;

select s.*, g.*
from song as s
left join girl_group as g
on  s._id = g.hit_song_id;

-- 걸그룹 중에서 히트곡(노래 타이틀)이 없는 걸그룹의 
-- 걸그룹 이름과 데뷔날짜를 조회하세요.
select g.name, g.debut
from girl_group as g
left join song as s
on  s._id = g.hit_song_id
where s.title is NULL;

-- 노래 피노키오를 부른 가수의 이름을 조회하세요.
select g.name
from song as s
left join girl_group as g
on  s._id = g.hit_song_id
where s.title = "피노키오";
-- 노래 기대해 를 부른 가수의, 노래제목과 이름을 조회하세요.
select s.title, g.name
from song as s
left join girl_group as g
on  s._id = g.hit_song_id
where s.title = "기대해";

-- emp_test 데이터베이스로 이동.
use emp_test;

-- DALLAS에서 근무하는 사원의 이름, 직위, 부서번호, 부서이름 조회
select e.ename, e.job, e.deptno, d.dname 
from emp as e
join dept as d
on e.deptno = d.deptno
where d.loc = "DALLAS";


-- 이름에 A 가 들어가는 사원들의 이름과 부서이름을 조회하세요.
select e.ename, d.dname 
from emp as e
join dept as d
on e.deptno = d.deptno
where e.ename like "%A%";

-- 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을 조회.
-- 단, 월급이 3000 이상인 사원 대상으로.
select  e.ename, d.dname, e.sal
from emp as e
join dept as d
on e.deptno = d.deptno
where e.sal >= 3000;

-- 직위가 SALESMAN 인 사원들의, 
-- 직위, 사원이름, 부서명 조회
select  e.job, e.ename, d.dname 
from emp as e
join dept as d
on e.deptno = d.deptno
where e.job = "SALESMAN";

-- 모든 사원들의 사원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 조회하되,
-- 각각의 컬럼명을, 한글로 사원번호, 사원이름, 연봉, 실급여, 급여등급
select e.empno as 사원번호, e.ename 사원이름, ifnull(e.comm,0),
	e.sal as 연봉, e.sal + ifnull(e.comm , 0) as 실급여 , 
    s.grade as 급여등급   
from emp as e
join salgrade as s
on e.sal between s.losal and s.hisal;

-- 커미션이 있는 사원만
select e.empno as 사원번호, e.ename 사원이름, 
	e.sal as 연봉, e.sal + e.comm as 실급여 , 
    s.grade as 급여등급   
from emp as e
join salgrade as s
on e.sal between s.losal and s.hisal
where e.comm is not null;

-- 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름, 
-- 월급, 급여등급을 출력하시오.
select e.empno, d.dname, e.ename, e.sal, s.grade
from emp as e
left join salgrade s
on e.sal between s.losal and s.hisal
join dept as d
on e.deptno = d.deptno
where e.deptno = 10;

-- 부서번호가 10번, 20번, 30번인 사원들의 부서번호, 부서이름,
-- 사원이름, 월급, 급여등급을 조회하시오.
-- 단, 부서번호가 낮은 순, 같은 부서면 월급이 높은 순으로 정렬.
select e.deptno, d.dname, e.ename, e.sal, s.grade
from emp as e
join dept as d
on e.deptno = d.deptno
join salgrade s
on e.sal between s.losal and s.hisal
where d.deptno in (10, 20, 30)
-- where d.deptno = 10 or d.deptno = 20 or d.deptno = 30
order by d.deptno asc, e.sal desc;















