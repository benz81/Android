use mydb;

-- Schema
-- students table, papers table
create table students (
	id int not null auto_increment primary key,
    first_name varchar(100)
);
create table papers (
	id int not null auto_increment primary key,
    title varchar(100),
    grade int,
    student_id int,
    foreign key (student_id) references students(id) 
);
-- 만약에 students 테이블에서 데이터가 삭제(delete)될 경우에,
-- papers 테이블에 해당 id 값이 있으면, 같이 삭제하도록 할 수 있다.
-- 그 문법은 ?  on delete cascade 
create table papers (
	id int not null auto_increment primary key,
    title varchar(100),
    grade int,
    student_id int,
    foreign key (student_id) references students(id) 
		on delete cascade
);








