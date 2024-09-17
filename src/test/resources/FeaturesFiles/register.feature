@register
Feature: register

@withmandatoryfields
Scenario: register with all mandatory fields
Given open application url
And go to register page
And enter emailidwithtimestamp
And fill all the mandatory fields as below
| firstname  | lastname |  telephone |  password |  confirmpassword |
|  pramesh   |  kumar   |   76858345 |     demo  |     demo         |
And click policy checkbox
And click on continue button
Then register successful message displayed

@withduplicateemailid
Scenario: register with duplicate emailid
Given open application url
And go to register page
When enter duplicate emailid "pramesh.kumar@gmail.com"
And fill all the mandatory fields as below
| firstname  | lastname |  telephone |  password |  confirmpassword |
|  pramesh   |  kumar   |   76858345 |     demo  |     demo         |
And click policy checkbox
And click on continue button
Then duplicate email warning message should displayed
