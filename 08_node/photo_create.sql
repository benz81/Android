create table photo_user (
	id int not null auto_increment primary key,
    email varchar(30),
    passwd varchar(100),
    created_at timestamp default current_timestamp
);

create table photo_token(
	id int not null auto_increment primary key,
    user_id int,
    token varchar(256)
);

create table photo_follow (
	id int not null auto_increment primary key,
    user_id int,
    friend_user_id int,
    created_at timestamp default current_timestamp
);

create table photo_post (
	id int not null auto_increment primary key,
    user_id int,
    photo_url varchar(100),
    content varchar(200)
);
