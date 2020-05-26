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











