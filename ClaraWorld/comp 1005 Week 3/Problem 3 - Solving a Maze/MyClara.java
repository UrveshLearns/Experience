/* PERMITTED COMMANDS
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, while, for
*/

class MyClara extends Clara {
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        // TODO: Write your code below
        while (!onLeaf()) {
            right_hand();
            enclosed();
            one_way();
            move();
        }
        if (onLeaf())
            removeLeaf();
    }
    //Moves in the right space available to not get lost
    void right_hand() {
        if (!treeRight())
        {
            turnRight();
            move();
        }
    }
    //if Clara is trapped in a space with trees surrounding her
    void enclosed()
    {
        if (treeRight() && treeFront() && treeLeft())
        {
            turnRight();
            turnRight();
        }
    } 
    //For when theres no right space to move in
    void one_way() {
        if (treeFront() && !(treeRight() && treeLeft()))
            turnLeft();
    }
}