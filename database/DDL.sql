drop table if exists user;
drop table if exists user_role;
drop table if exists portfolio;

CREATE table user (
user_id serial PRIMARY KEY,
username varchar(40)unique not null,
passwrd varchar(40) not null,
email varchar(70) unique not null,
phone_number integer unique,
role_id integer REFERENCES role not null,
portfolio_id integer REFERENCES portfolio
);

CREATE table user_role (
	role_id serial PRIMARY KEY,
	role_name varchar(40)
);

CREATE table portfolio (
portfolio_id serial PRIMARY key
);


create table stock_owner (
	portfolio_id integer references portfolio,
	stock_id varchar(5)
);


