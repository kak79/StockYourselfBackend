

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

);


CREATE table IF NOT EXISTS stock_portfolio (
	portfolio_id integer REFERENCES portfolio,
	stock_id varchar(5)
);

CREATE table IF NOT EXISTS post (
	
);