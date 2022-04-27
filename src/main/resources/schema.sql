drop table db.authorities;
drop table db.users;

create table db.users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
);

create table db.authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references db.users(username)
);
create unique index ix_auth_username on db.authorities (username,authority);