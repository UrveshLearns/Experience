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
        //Moving uptill infront of a mushroom
        while (!mushroomFront())
        {

            /*When clara is in front of a tree we want clara to move from her current street to 
            the street to the left of her this condition makes sure she moves in the street to 
            the left of her while removing any potential leafs*/
            if (treeFront() && !treeLeft())
            {
                removing_leaves();
                turnLeft();
                safemoves();
                removing_leaves();
                turnRight();
                safemoves();
            }
            /*When clara is not in the street she is supposed to be this condition makes sure she 
            comes back into the street while removing any potential leafs*/
            if (!treeRight())
            {
                removing_leaves();
                turnRight();
                safemoves();
                removing_leaves();
                turnLeft();
            }
            /*Makes sure she only moves when there is no tree in front of her or she is not in b j front
            of a mushroom*/
            safemoves();

        }
    }
    /*Function  to make sure clara moves only when there is no tree in front of her or she is not
    infront of a tree */
    void safemoves()
    {
        if (!treeFront() && !mushroomFront())
            move();
    }
    //Function to make sure clara checks and removes any leafs
    void removing_leaves() {
        if (onLeaf())
            removeLeaf();
    }
}