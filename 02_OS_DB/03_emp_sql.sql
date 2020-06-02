-- 사번, 이름, 직급, 매니저정보,입사일,
-- 연봉,커미션(보너스),부서번호 
select * from dept;
select * from emp;
select * from salgrade;
-- 사원 이름순으로 정렬하시오.
select * from emp 
		order by  ename ;
-- 급여 내림차순으로 정렬하시오.
select * from emp	
		order by sal desc;
-- 급여 내림차순으로, 사원이름, 급여, 부서코드를
-- 조회하시오. 
select ename, sal, deptno from emp 
	order by sal desc;



-- 부서코드 오름차순, 급여 내림차순으로
-- 사원이름, 급여,부서코드를 조회하시오.
select ename, sal, deptno 
from emp
order by deptno asc, sal desc;

-- 이름, 입사일자, 부서코드를 
-- 부서코드 오름차순, 입사일자 오름차순으로 조회
select ename, hiredate, deptno
from emp
order by deptno asc, HIREDATE asc;

-- 직급 칼럼의 중복을 제거하고
-- 하나씩만 나오도록 하시오.
select distinct job from emp;

-- emp테이블의 job 오름차순, sal 내림차순정렬하여
-- ename은 이름, job은 직급, sal은 급여
-- 로 컬럼명 변경해서 조회하시오.
select ename as 이름, job as 직급, 
	sal as 급여
from emp
order by job asc, sal desc;

-- 급여가 1000보다 많/고 4000보다 작은 직원 조회
-- 하되, 급여 내림차순으로 정리.
select * from emp
where sal > 1000 and sal < 4000
order by sal desc;

-- 급여가 1000 이하이거나 4000이상인 직원 검색
select * from emp
where sal <= 1000 or sal >= 4000;

select * from emp;

-- 직책이 ANALYST 이거나 MANAGER 인 직원들을
-- 이름순으로 조회하세요.
select * from emp
where job = "ANALYST" or job="MANAGER"
order by ename;

-- 부서코드가 30인 직원들을 조회하시오.
select * from emp
where deptno = 30;

-- 부서코드 종류가 몇개인지 확인
select distinct deptno from emp;
select  deptno from emp group by deptno;

-- 부서코드가 10이거나 20이거나 30 인 직원 조회.
select * from emp
where deptno=10 or deptno=20 or deptno=30;
select * from emp
where deptno in (10, 20, 30);

-- 급여가 3000~5000 인 직원을 조회하세요.
select * from emp
where sal >= 3000 and sal <= 5000;

select * from emp
where sal between 3000 and 5000;


-- 커미션이 300, 500, 1400 이 모두 아닌 사원의
-- 사번, 이름, 커미션을 조회하세요.
select empno, ename, comm from emp
where comm!=300 && comm!=500 && comm!=1400;

select empno, ename, comm from emp
where comm not in (300, 500, 1400);

-- 총 사원수를 구하시오.
select count(*) from emp;

-- 이 emp 테이블에 있는 직책(job)의 목록을 조회.
select distinct job from emp;

-- 이름이 KING 인 사원을 조회하시오.
select * from emp
	where ename = "KING";
-- 이름이 King 인 사원도 조회하시오.
select * from emp
	where ename = "King";

-- 사원 이름중에서, S로 시작하는 사원의
-- 사원번호와 이름을 조회.
select empno, ename 
from emp
where ename like "S%";

-- 사원 이름에 T 가 포함된 사원의 사원번호와 이름 조회
select empno, ename from emp
where ename like "%T%";

-- 직급에 매니저이고 부서번호가 30인 사원의 
-- 이름, 사번, 직급, 부서번호를 조회하시오.
select ename, empno, job, deptno from emp
where job = "MANAGER" and deptno = 30;
-- 부서번호가 30이 아닌 사원의 사번,이름,부서번호 조회.
select empno, ename, deptno from emp
where deptno != 30;

select empno, ename, deptno from emp
where not deptno = 30;

select empno, ename, deptno from emp
where deptno not in (30);

-- 이름에 S가 포함되지 않은 사원의 사번, 이름 조회.
select empno, ename from emp
where ename not like "%S%";

-- 직속상사가 NULL 인 사원의 이름과 직급 조회.
select * from emp
where MGR is NULL;

-- 부서별 평균급여(평균연봉)를 구하시오.
select avg(sal), deptno from emp
group by deptno;

-- sal이 2000이상인 사원들을 대상으로,
-- 부서별 sal 평균을 구하세요. 
select avg(sal) , sum(sal), deptno from emp
where sal >= 2000 
group by deptno;

-- 부서별 전체 사원수와, 커미션을 받는 사원수를 구하세요.
select deptno as 부서, count(*) as 전체사원수, 
		count(comm) as 커미션사원수
from emp
group by deptno ;

-- 부서별 최대 급여와 최소 급여를 구해서 표시하세요.
select deptno , max(sal), min(sal), sum(sal)        
from emp
group by deptno;


-- 급여가 높은 순으로 조회하되, 급여가 같을 경우는
-- 이름의 철자가 빠른순으로 사번,이름,급여를 조회하세요.
select empno, ename, sal from emp
order by sal desc , ename asc;

select * from emp;
select * from dept;

-- join  여러개의 테이블을 하나로 합치는것.
select emp.*, dept.*
from emp, dept
where emp.deptno = dept.deptno;























































