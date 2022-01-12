DROP table IF EXISTS user;
DROP table IF EXISTS user_role;
DROP table IF EXISTS portfolio;
DROP table IF EXISTS stock_portfolio;
DROP table IF EXISTS post;

CREATE table user (
user_id serial PRIMARY KEY,
first_name varchar(40) NOT NULL,
last_name varchar(40) NOT NULL,
username varchar(40) UNIQUE NOT NULL,
passwrd varchar(40) NOT NULL,
email varchar(70) UNIQUE NOT NULL,
phone_number integer UNIQUE,
role_id integer REFERENCES role NOT NULL,
portfolio_id integer REFERENCES portfolio
);

CREATE table user_role (
	role_id serial PRIMARY KEY,
	role_name varchar(40)
);

CREATE table portfolio (
portfolio_id serial PRIMARY KEY
);


CREATE table stock_portfolio (
	portfolio_id integer REFERENCES portfolio,
	stock_id varchar(5)
);

CREATE table post (
	post_id serial PRIMARY KEY,
	post_content varchar(200),
	creation_date DATE NOT NULL,
	creation_time TIME NOT NULL,
	user_id integer REFERENCES user
);

