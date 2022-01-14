INSERT INTO user_role (role_id, role_name) VALUES
	(DEFAULT, 'user'),
	(DEFAULT, 'admin');

INSERT INTO portfolio (portfolio_id) VALUES
	(DEFAULT),
	(DEFAULT),
	(DEFAULT),
	(DEFAULT);

INSERT INTO stock_portfolio (portfolio_id, stock_id) VALUES 
	(1, 'MMM'),
	(2, 'AOS'),
	(3, 'ABT'),
	(4, 'ABBV');

INSERT INTO USER (user_id, first_name, last_name, username, passwrd, email, phone_number, role_id, portfolio_id) VALUES
	(DEFAULT, 'Brett', 'Dixon', 'bdixon', 'pass', 'bdixon@fake.com', '(123)456-7890', 2, 1),
	(DEFAULT, 'Kim', 'KH', 'kkh', 'pass', 'kkh@fake.com', '(234)567-8901', 2, 2),
	(DEFAULT, 'Daniel', 'Joseph', 'djoseph', 'pass', 'djoseph@fake.com', '(345)678-9012', 2, 3),
	(DEFAULT, 'Andrew', 'Wisdom', 'awisdom', 'pass', 'awisdom@fake.com', '(456)789-0123', 1, 4);
	
INSERT INTO post (post_id, post_content, creation_date, creation_time, user_id) VALUES
	(DEFAULT, 'I think this stock is going to the moon!', '2021-01-11', '01:02:03', 1),
	(DEFAULT, 'I love my stocks; they are so profitable!', '2021-01-12', '02:03:04', 2),
	(DEFAULT, 'This reminds me of buying into Apple back in 2008!', '2021-01-13', '03:04:05', 3),
	(DEFAULT, 'I wish I bought into this stock earlier!', '2021-01-14', '04:05:06', 4);


	