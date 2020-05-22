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






