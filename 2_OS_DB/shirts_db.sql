create database shirts_db;

use shirts_db;

create table shirts (
	shirt_id int not null auto_increment primary key,
    article varchar(30),
    color varchar(30),
    shirt_size varchar(5),
    last_worn int
);

insert into shirts (article, color, shirt_size,last_worn)
values ('t-shirt', 'white', 'S', 10),
		('t-shirt', 'green', 'S', 200),
        ('polo shirt', 'black' , 'M', 0),
        ('tank top', 'blue', 'S', 50),
        ('t-shirt', 'pink', 'S', 0),
        ('polo shirt', 'red', 'M', 5),
        ('tank top', 'white', 'S', 200),
        ('tank top', 'blue', 'M', 15);
select * from shirts;

-- 아티클과 컬러만 조회하시오.
select article, color from shirts;

-- 셔츠 사이즈가 M 인, 데이터에서 셔츠아이디만 제외하고 화면에 조회.
select article, color, shirt_size, last_worn
from shirts
where shirt_size = "M";

-- 아티클이 polo shirt 로 되어있는 셔츠의 사이즈를 L로 바꾸세요.
update shirts set shirt_size = "L"
where article="polo shirt";

select * from shirts where article="polo shirt";

-- last_worn 이 15인 데이터를 전부 10으로 바꿔주세요. 

update shirts set last_worn = 10
where last_worn = 15;

select * from shirts where last_worn = 10;

-- 컬러가 white 인 셔츠의, 컬러를 off white 로 바꾸고, 
-- 셔츠 사이즈도 XS 로 변경하세요.
update shirts set color = "off white", shirt_size="XS"
where color = "white";

desc shirts;

select * from shirts;

-- last_worn 이 200인 데이터를 삭제하세요. 
delete from shirts 
where last_worn = 200;

select * from shirts;

-- 아티클이 tank top 인 데이터를 삭제하세요.
delete from shirts 
where article = "tank top";

-- shirts 테이블 자체를 삭제하세요.
drop table shirts;

-- shirts_db에 있는 테이블의  리스트를 조회하세요.
-- use shirts_db;
show tables;




















