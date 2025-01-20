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
        starting_case();
        while (!treeFront() || onLeaf())
        {
            if (onLeaf())
                finding_center();
            move();

        }


    }

    void finding_center() {
        if (onLeaf()) {
            //When clara is standing on a leaf she removes the current leaf turns around moves one space and puts a leaf again
            removeLeaf();
            reverse();
            move();
            if (!onLeaf())
                putLeaf();
            else
                reverse();
        }
    }
    //Reversing
    void reverse() {
        turnRight();
        turnRight();
    }
    //Setting up the starting case by putting a leaf at the edge of the street
    void starting_case() {
        putLeaf();
        move();
        while (!treeFront() && !onLeaf())
            move();
        putLeaf();
        reverse();
        move();

    }
}