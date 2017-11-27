# Round Robin Meal Picker

[See end for Final Project Proposal](#for-sure-in-final-project)

Ever been stuck with a group of people all asking what they want to eat and no one is able to pick or come to consensus? This app aims to fix that! Introducing <Round Robin Meal Picker> the innovative new app that allows all involved parties to signup and register their preferred eating establishments and forces a single individual to make the decision (or group vote if you're into that).

Don't really care where the group eats, but it's your turn? No problem! Select up to three places and let the group battle it out. If the vote ends in a tie, one random choice will be chosen. 

## Features
* When you signup, you'll be presented with a list of nearby eateries which will you will have to say yay or nay so we can build your optimal pool of places (hard we know, but it's worth it we promise!)
	* Worried you'll end up liking something you said nah to? Don't worry! We know your tastes will change over time so we added a handy dandy "Add Place To My Pool" button
* Create a group of your friends and pool together all the places you guys like to eat.
	* Got a big group and not everyone can make it everytime? No problemo! Just deselect them from the main group and select away!
* It's not exactly round robin because that's boring! Instead we do this cool thing where we pick a random person out of the pool of eligible singles-er we mean choosers and they get to pick where you guys will eat
* After you've chosen a place, you'll be removed from the pool until everyone else in the group has chosen and then it starts all over
* No longer will you sit there with your significant other asking "Where do you want to go?" and receiving "I don't care you pick" because we'll force one of you to pick (or at least narrow it down to 3 choices)
* Don't know what to pick, but also don't want to put it to a vote? Use our super neat randomizer, don't worry if you get a random you don't like; you can reject it and be presented with a new random choice. The icky one will be removed from current choices so you don't have to deal with it again! Well until you have to pick again...
* Look back at all the yummy (or not so yummy) places you've gone with your friends using our time machine! Just kidding, we don't actually have a time machine that'd be pretty cool though, instead you'll just have to settle for our super cool History Tracker. Not a fan of big brother? Don't worry you can turn it off with a tap of a button


## Integrations
* Add friends through Facebook and other social media
* Add events directly to your calendar
* Sync across devices


***********************
## For sure in final project
* Local signup process only, no reaching out to an api
* Hard code a bunch of different local places
	* Give user ability to choice add additional choices
* Give user a list of their groups and create new groups
* Hard code other users and their choices, only the real user will actually do picking (unless it ends up being easier to simulate extra users)
* User will be presented with a list of possible restaurants to choose from

## Likely, but no promises (These may actually get done, but I don't want to commit to doing too much work)
* Store choices in sqlite db
* Implement the randomizers
* Implement group vote

## Future plans/Stretch Goals
* Firebase/other api for device to device communication
* Calendar integration
* Facebook integration
* Filter out food allergies/food preferences (vegans, gluten, lactose, etc)
