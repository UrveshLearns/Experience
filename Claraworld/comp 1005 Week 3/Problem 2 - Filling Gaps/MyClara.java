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
        //Stopping condition when in front of a tree
        while (!treeFront())
        {
            move();
            // Cheking for holes
            if (!treeRight())
                filling_gaps();
        }
    }
    //filling the holes with leaves
    void filling_gaps() {
        turnRight();
        move();
        //Incase theres already a leaf in the hole
        if (onLeaf())
            reverse();
        else
        {
            putLeaf();
            reverse();
        }
    }


    //Getting out of the hole
    void reverse() {
        turnRight();
        turnRight();
        move();
        turnRight();
    }
}