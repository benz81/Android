-- reviewers
create table reviewers (
	id int not null auto_increment primary key,
    first_name varchar(100),
    last_name varchar(100)
);
-- series 
create table series (
	id int not null auto_increment primary key,
    title varchar(100),
    released_year year(4),
    genre varchar(100)
);
-- reviews
create table reviews (
	id int not null auto_increment primary key,
    rating float,
    series_id int,
    reviewer_id int,
    foreign key(series_id) references series(id),
    foreign key(reviewer_id) references reviewers(id)
);












