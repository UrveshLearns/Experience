/* PERMITTED COMMANDS
   move, stop, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, else, &&, ||, ! */

class MyClara extends Clara {
    /**
     * In the 'act()' function you can write your program for Clara 
     */
    void act() {
        // TODO: Write your code below
        if (!treeRight())
            turnRight();
        if (treeFront() && !treeLeft())
            turnLeft();
        if (treeFront() && treeLeft() && treeRight())
        {
            turnRight();
            turnRight();
        }
        move();
        if (onLeaf()) {
            removeLeaf();
            stop();
        }
    }
}