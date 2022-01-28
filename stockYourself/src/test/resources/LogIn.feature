Feature: logging in as a user

Scenario Outline: logging in with correct credentials
	Given the user is on the stockYourself home page
	And the user clicks the Log In link
	When the user enters "<username>" and "<password>" to log in
	And the user clicks the login button
	Then the navbar says "<username>"
	
	Examples:
		|		username		|		password		|
		|		djoseph			|		pass				|
		|		bdixon			|		pass				|
		
Scenario Outline: logging in with incorrect passwords
	Given the user is on the stockYourself home page
	And the user clicks the Log In link
	When the user enters "<username>" and "<password>" to log in
	And the user clicks the login button
	Then the page says Incorrect Credentials
	
	Examples:
		|		username		|		password		|
		|		kkh					|		p4ss				|
		|		awisdom			|		1234				|
