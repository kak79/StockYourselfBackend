DROP table IF EXISTS stock_portfolio CASCADE;
DROP table IF EXISTS post_portfolio CASCADE;
DROP table IF EXISTS user_post CASCADE;
DROP table IF EXISTS post CASCADE;
DROP table IF EXISTS user_table CASCADE;
DROP table IF EXISTS portfolio CASCADE;
DROP table IF EXISTS stock_string CASCADE;
DROP table IF EXISTS user_role CASCADE;


CREATE table IF NOT EXISTS user_role (
	role_id serial UNIQUE PRIMARY KEY,
	role_name varchar(40)
);

CREATE TABLE IF NOT EXISTS stock_string (
stock_string_id serial UNIQUE PRIMARY KEY,
stock_name varchar(6)
);

CREATE table IF NOT EXISTS portfolio (
portfolio_id serial UNIQUE PRIMARY key,
portfolio_name varchar(10)
);

CREATE table IF NOT EXISTS user_table (
user_id serial UNIQUE UNIQUE PRIMARY KEY,
first_name varchar(40) NOT NULL,
last_name varchar(40) NOT NULL,
username varchar(40) UNIQUE NOT NULL,
passwrd varchar(40) NOT NULL,
email varchar(70) UNIQUE NOT NULL,
phone_number varchar(15),
role_id integer REFERENCES user_role NOT NULL,
portfolio_id integer REFERENCES portfolio
);

create table IF NOT EXISTS post (
post_id serial UNIQUE PRIMARY KEY,
	post_title varchar(50),
	post_content varchar(200),
	creation_date DATE NOT NULL,
	creation_time TIME NOT NULL,
	user_id integer REFERENCES user_table,
	portfolio_id integer REFERENCES portfolio
);

CREATE table IF NOT EXISTS user_post (
	post_id integer REFERENCES post,
	user_id integer REFERENCES user_table
);

CREATE table IF NOT EXISTS post_portfolio (
	portfolio_id integer REFERENCES portfolio,
	post_id integer REFERENCES post
);

CREATE table IF NOT EXISTS stock_portfolio (
	portfolio_id integer REFERENCES portfolio,
	stock_string_id integer REFERENCES stock_string
);

