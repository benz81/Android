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















