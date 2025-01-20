/* PERMITTED COMMANDS
   move, stop, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, else, &&, ||, !
   
   To use this code in Greenfoot copy everything below to */

class MyClara extends Clara {
    /**
     * In the 'act()' function you can write your program for Clara 
     */
    void act() {
        // TODO: Write your code below
        move();
        if (treeLeft() && treeRight())
        {
            putLeaf();
            move();
            stop();
        }
    }
}