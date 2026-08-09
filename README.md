# Fortune Telling Game
## A game for those in need of quick (not necessarily accurate) divination

The project that I intend to design this term is a fortune telling game. Users will be able to make a fortune and then add it to a fortune log. The player will add a topic and then the program will flip a coin. This project is designed to be a fun little game for those who like fortune telling. It is of interest to me as I really enjoy fortune telling and game design.  


## User stories: 
- I want to be able to make a game and add it to a list of previous games
- I want to be able to specify a topic for the fortune and receive a result fortune
- I want to be able to rate a fortune
- I want to be able to see a list of fortunes with a good rating
- I want to be able to see a list of fortunes with a bad rating
- I want to be able to see a list of all fortunes and their results.
- I want to be able to select a fortune and remove it from the list.

- I want to have the option to save the Fortune Log
- I want to have the option to reload the previous Fotune Log on start
- I want to be reminded to save my progress on quit and have the option to go back instead of quitting

- I want to be able to choose between a card reading and coin flip when having my fortune read.

## Instructions for End User
How to view the panel that displays fortunes that have already been added to the fortune log:
- It is the panel in the center.
- If no fortunes are there, click the load button

How to view all of the fortunes in the log:
- click the "All Fortunes" button
- if no fortunes appear, press the "Load Game" button or the "Add Fortune Button"

How to view all of the good rated fortunes:
- click the Good Fortunes button
- If there are no fortunes displayed, click the "Load Game" button, then try again

How to view all of the bad rated fortunes:
- Click the "Bad Fortunes" button
- if there are no fortunes displated, click the "Load Game" button, then try again

How to load the state of the application from file:
- Click the "Load Game" button

How to save the state of the application to file:
- Click the "Save Game" button

How to view the visual component:
- Any Coin Flip reading will have a coin image below it, indicating the result.

## Phase 4: Tesk 2
Event Log Sample:

Event: All fortunes were retrieved
Event: Save data loading process has started:
Event: A fortune was added to the log
Event: A fortune was added to the log
Event: A fortune was added to the log
Event: A fortune was added to the log
Event: A fortune was added to the log
Event: A fortune was added to the log
Event: A fortune was added to the log
Event: A fortune was added to the log
Event: All fortunes were retrieved
Event: Save data loading process has ended.
Event: All fortunes were retrieved
Event: All fortunes with a good rating were retrieved
Event: All fortunes with a bad rating were retrieved
Event: A Coin Flip was instantiated
Event: A result was added to the fortune.
Event: A fortune was added to the log
Event: A rating was added to the fortune
Event: All fortunes were retrieved
Event: Data was saved to file

## Phase 4: Task 3
If I had more time to work on this project I would take the time to refactor the FortuneGameApp.java class to only handle the UI and not the functionality of running the game. I would then add a class that handles the fortune log and all associated functions to reduce the responsibilities placed on ForuneGameApp.java. Then, I would either remove the implementation of FortuneGame.java, or move the implementation in FortuneGameApp.java to FortuneGame.java and remove the FortuneGameApp.java class. I would also try to refactor my event handling so that only FortuneLog.java and FortuneGameApp.java needs to have a reference to EventLog.

My reasoning for these changes is that currently, the FortuneGameApp handles too much and I believe it violates the Single Responsibility Principle. Additionally, FortuneGame.java is not instantiated in Main.java and is out of date with regards to nessesary changes that were made as the project progressed. Thus, FortuneGame.java is unnessesary and could be removed. Lastly, for the event handling changes, my reasoning for this is wanting to remove a potentially unnessecary reference to EventLog.java in Fortune.java. 


## Citations
Basic Teller App: https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
JSON Serialization App: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
SimpleDrawingPlayer - Complete: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git
Alarm System: https://github.students.cs.ubc.ca/CPSC210/AlarmSystem.git