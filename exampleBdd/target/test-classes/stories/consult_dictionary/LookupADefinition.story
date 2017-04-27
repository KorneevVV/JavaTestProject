Lookup a definition
Narrative:
In order to talk better
As an English student
I want to look up word definitions

Scenario: Add collaborator 'nzvonilov'
Given the user is on the Github Login page and input login 'fortestproject12@gmail.com' and password 'fortestproject12'
When a user add a collaborator 'nzvonilov' to the second project in his Github
Then he should see the user name of collaborator 'nzvonilov' in the list of collaborators and exit the account
