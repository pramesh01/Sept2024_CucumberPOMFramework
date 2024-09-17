@login
Feature: login
validate login feature

@validuser
Scenario: verify user is able to login with valid credentials
Given open application url
And go to login page
When enter emailid "pramesh.kumar@gmail.com"
And enter password "demo"
And click on signin button
Then user should be able to login

@Invaliduser
Scenario: verify user is not able to login with Invalid credentials
Given open application url
And go to login page
When enter emailid "abc@gmail.com"
And enter password "xyz"
And click on signin button
Then user should Not be able to login and proper warning text should displayed

@blankcredentials
Scenario: verify user is not able to login with Blank credentials
Given open application url
And go to login page
And click on signin button
Then user should Not be able to login and proper warning text should displayed

@validateformultipleusers
Scenario Outline: verify scenario for multiple sets of data i.e DataDriven
Given open application url
And go to login page
When enter emailid <useremailid> for multiple users
And enter password <password> for multiple users
And click on signin button
Then user should be able to login
Examples:
|    useremailid           |password |
| pramesh.kumar@gmail.com  |  demo   |
| amotooricap1@gmail.com   | 12345   |
| amotooricap3@gmail.com   | 12345   |
|amotooricap9@gmail.com|12345|