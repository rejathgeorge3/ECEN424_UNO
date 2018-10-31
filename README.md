# ECEN424_UNO


## Reese
Server


## Kyle
Game-Master

- Make draw card function
  - no input args, return card
	
- Make Play card function
  - input card as argument, manipulate game state


## Rejath
-Client (meet to talk about specifics)
 - connect to specified IP and port (fine to use main thread like MP2)
 - setup input stream reader, output print writer, and scanner (keyboard input) objects
   - get reader and writer from port
 - parse input from reader for game state and player's hand; display to console
   - activate scanner whenever it is users turn (contained w/i game state)
     - provide user input to server via writer
 - listen to from server for acceptance of card player
   - if refused, reopen scanner and send again
   - if accepted, wait for next normal game state
