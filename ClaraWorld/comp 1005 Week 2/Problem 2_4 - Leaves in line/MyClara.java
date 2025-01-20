/* PERMITTED COMMANDS
   move, stop, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, else, &&, ||, ! */

class MyClara extends Clara {
    /**
     * In the 'act()' function you can write your program for Clara 
     */
    void act() {
        if (!onLeaf())
            putLeaf();
        if (treeFront())
            stop();
        else
            move();
    }
}