

DROP table IF EXISTS post;
DROP table IF EXISTS stock_portfolio;
DROP table IF EXISTS us_r;
DROP table IF EXISTS portfolio;
DROP table IF EXISTS user_role;


CREATE table IF NOT EXISTS user_role (
	role_id serial UNIQUE PRIMARY KEY,
	role_name varchar(40)
);

CREATE table IF NOT EXISTS portfolio (
portfolio_id serial UNIQUE PRIMARY key,
portfolio_name varchar(10)
);

CREATE table IF NOT EXISTS us_r (
user_id serial UNIQUE PRIMARY KEY,
first_name varchar(40) NOT NULL,
last_name varchar(40) NOT NULL,
username varchar(40) UNIQUE NOT NULL,
passwrd varchar(40) NOT NULL,
email varchar(70) UNIQUE NOT NULL,
phone_number varchar(15),
role_id integer REFERENCES user_role NOT NULL,
portfolio_id integer REFERENCES portfolio
);


CREATE table IF NOT EXISTS stock_portfolio (
	portfolio_id integer REFERENCES portfolio,
	stock_id varchar(5)
);

CREATE table IF NOT EXISTS post (
	post_id serial UNIQUE PRIMARY KEY,
	post_title varchar(50),
	post_content varchar(200),
	creation_date DATE NOT NULL,
	creation_time TIME NOT NULL,
	user_id integer REFERENCES us_r,
	portfolio_id integer REFERENCES portfolio
);