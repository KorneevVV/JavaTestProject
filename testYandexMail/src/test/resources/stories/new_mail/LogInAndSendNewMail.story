LogIn yandexmail
Create and send new mail

Scenario: User go to main Yandex page, login, send mail
Given the user enter main yandex page
When the user click on mail button
And the user type login and password and click enter
And user go to options
Then user change options
Scenario: User relogin
Given the user enter main yandex page
When the user click on mail button
And the user type login and password and click enter
When the user create new mail and check podpis
Then check podpis