/* PERMITTED COMMANDS
   move(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf(); stop();
   JAVA
   if, else, &&, ||, ! */

class MyClara extends Clara {
    /**
     * In the 'act()' method you can write your program for Clara 
     */
    void act() {
        if ((treeLeft() || treeRight()) && !onLeaf())
            putLeaf();
        if (treeFront())
            stop();
        else
            move();
    }
}