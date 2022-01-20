INSERT INTO user_role (role_name) VALUES
	('user'),
	('admin');

INSERT INTO portfolio (portfolio_name) VALUES 
	('Bretts'),
	('Kims'),
	('Daniels'),
	('Andrews');

INSERT INTO user_table (first_name, last_name, username, passwrd, email, phone_number, role_id, portfolio_id) VALUES
	('Brett', 'Dixon', 'bdixon', 'pass', 'bdixon@fake.com', '(123)456-7890', 1, 1),
	('Kim', 'KohelHayes', 'kkh', 'pass', 'kkh@fake.com', '(234)567-8901', 1, 2),
	('Daniel', 'Joseph', 'djoseph', 'pass', 'djoseph@fake.com', '(345)678-9012', 1, 3),
	('Andrew', 'Wisdom', 'awisdom', 'pass', 'awisdom@fake.com', '(456)789-0123', 2, 4);
	
INSERT INTO post (post_title, post_content, creation_date, creation_time, user_id, portfolio_id) VALUES
	('3M Rocks', 'I think this stock is going to the moon!', '2021-01-11', '01:02:03', 1, 1),
	('3M Does Not Rock', 'I think this stock is going to tank!', '2021-01-11', '04:05:06', 3, 1),
	('I Love Money', 'I love my stocks; they are so profitable!', '2021-01-12', '02:03:04', 2, 2),
	('Abbot is Great', 'This reminds me of buying into Apple back in 2008!', '2021-01-13', '03:04:05', 3, 3),
	('Shoot to Late', 'I wish I bought into this stock earlier!', '2021-01-14', '04:05:06', 4, 4);

INSERT INTO user_post (user_id, post_id) VALUES 
	(1, 1),
	(3, 2),
	(2, 3),
	(3, 4),
	(4, 5);

INSERT INTO post_portfolio (post_id,portfolio_id) VALUES 
	(1, 1),
	(2, 1),
	(3, 2),
	(4, 3),
	(5, 4);	

INSERT INTO stock_portfolio (portfolio_id, stock_string_id) VALUES 
	(1, 23),
	(2, 24),
	(3, 25),
	(4, 26);