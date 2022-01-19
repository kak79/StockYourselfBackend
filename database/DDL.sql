drop table if exists user_role cascade;
drop table if exists stock_string cascade;
drop table if exists portfolio cascade;
drop table if exists user_table cascade;
drop table if exists post cascade;
drop table if exists stock_portfolio cascade;


CREATE table user_role (
	role_id serial PRIMARY KEY,
	role_name varchar(40)
);

CREATE TABLE stock_string (
stock_string_id serial PRIMARY KEY,
stock_name varchar(6)
);

CREATE table portfolio (
portfolio_id serial PRIMARY key
);



CREATE table user_table (
user_id serial PRIMARY KEY,
username varchar(40)unique not null,
passwrd varchar(40) not null,
email varchar(70) unique not null,
phone_number integer unique,
role_id integer REFERENCES user_role not null,
portfolio_id integer REFERENCES portfolio
);


create table post(
post_id serial primary key,
post_content varchar(250),
creation_date date,
creation_time time,
creator_id integer REFERENCES user_table
);

create table user_post(
	post_id integer REFERENCES post,
	user_id integer REFERENCES user_table
);

create table  stock_portfolio(
	portfolio_id integer REFERENCES portfolio,
	stock_string_id integer REFERENCES stock_string
);

