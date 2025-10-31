•	Maze Game

This game has three main components: the player, the maze, and the hunter. The goal is to reach the end of the maze, overcoming all obstacles, and touch the portal before the hunter catches up with the player. The code for this program is written using JavaFX. What's interesting about this code is that the hunter searches for the shortest path to the player and follows it, using a wave algorithm for this.
Let's take a closer look. At the beginning of the game, we see a menu with different levels from one to nine. The player's score is also shown there, indicated by the number of stars in the upper right corner of the screen. 

<img width="468" height="335" alt="image" src="https://github.com/user-attachments/assets/1bcd7ce0-944d-4533-9afe-f80dd97dc46a" />

Here are some examples of the levels of this game: with each new level, the game becomes more difficult, the hunter becomes faster, and the labyrinth has more and more new paths that lead the player into a trap. 
 
<img width="468" height="336" alt="image" src="https://github.com/user-attachments/assets/6747e64f-6c59-4d7b-9d2b-1fd3cbbd4115" />

<img width="468" height="334" alt="image" src="https://github.com/user-attachments/assets/22ea5b80-eb4a-4c29-a95a-cc9abf6cde28" />

<img width="468" height="335" alt="image" src="https://github.com/user-attachments/assets/b18379f7-8a5b-48a3-96d3-601c9949476a" />

If the player is suddenly caught by the hunter before they touch the portal, they automatically lose and a new page opens with an animation and two buttons: one of them allows you to start the current level from the beginning, and the other takes the player back to the menu with all the levels. 

<img width="468" height="336" alt="image" src="https://github.com/user-attachments/assets/401f1a0c-97ab-47ba-963a-30bad6197979" />

Upon winning, the player will also be shown these buttons, and most importantly, the number of points they earned for the current level (from 1 to 3 stars). The number of points will depend on the time it took the player to complete the level. 

<img width="468" height="333" alt="image" src="https://github.com/user-attachments/assets/0ad4a214-47cd-4e2d-ac68-7802224df2d6" />
