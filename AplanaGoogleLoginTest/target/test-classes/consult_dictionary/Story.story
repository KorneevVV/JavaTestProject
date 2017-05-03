


Scenario: scenario description
Given пользователь на домашней странице Гугл
When пользователь переходит на страницу аутентификации почты
When вводим почту 'pankovtestaplana@gmail.com'
When вводим пароль от почты 'kracoz13' и авторизуемся
Then пишем письмо - адрессат: 'pankovtestaplana@gmail.com', текст письма : 'Serenity test'