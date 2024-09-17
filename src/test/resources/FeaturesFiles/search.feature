@search
Feature: search functionality

@validsearch
Scenario: verify user is able to search items
Given open application url
And go to login page
When enter emailid "pramesh.kumar@gmail.com"
And enter password "demo"
And click on signin button
When enter text "HP" in text area
And click ENTER button or click on search icon
Then Search result should be displayed

@Invalidsearch
Scenario: verify user is not able to find invalid items
Given open application url
And go to login page
When enter emailid "pramesh.kumar@gmail.com"
And enter password "demo"
And click on signin button
When enter text "HOX" in text area
And click ENTER button or click on search icon
Then item should not be found