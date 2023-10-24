# Assignment 3 - Black Jack Game

## Participants
Maria Fredriksson (mf223wk)
Maddelen Hedenström (mh222vu)

## How to build
./gradlew build

## How to run the application
./gradlew run -q --console=plain

## How to play the game
Commands:
Type 'p' to Play.<br>
Type 'h' to Hit.<br>
Type 's' to Stand.<br>
Type 'q' to Quit.<br>

## Rules of the game
Closest to 21 winns.<br>
Cards 2-9 is of its own value.<br>
Cards 10, J, Q, K is of value 10.<br>
Cards A, are value of 1 or 11.<br>

## The soft 17 rule
Soft 17 means that the dealer has 17 but in a combination of Ace and 6 (for example Ace, two, two, two). This means that the Dealer can get another card valued at 10 but still have 17 as the value of the ace is reduced to 1. Using the soft 17 rule the dealer should take another card (compared to the original rule when the dealer only takes cards on a score of 16 or lower).

## Winning when equal score
Who wins on an equal score? In one implementation the Dealer wins, in the other the Player. Its up to you.
