Lookup a definition
Narrative:
In order to talk better
As an English student
I want to look up word definitions

Scenario: написать письмо 'vo1k@list.ru'
Given зайти на почту рамблер по данными логин 'testramjav' и пароль 'testramjav'
When зайти в настройки, изменить подпись на дату '$datas' потом проверить эту подпись в письме
When зайти в форму написать письмо, заполнить поля и отправить 'vo1k@list.ru'
Then если не дает отправить, выйти из аккаунта
