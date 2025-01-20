/* PERMITTED COMMANDS
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf();
   JAVA
   if, else, for, while, do, !, ||, && 
   variables
*/

class MyClara extends Clara {
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        //Clara sets her flag at the start of the street
        boolean flag = false;
        //Clara moves to the end of the street while creating the checkboard patten
        while (!treeFront()) {

            pattern();
            //After reaching the end of the street clara checks her flag and repositions according to her flag and change the flag 
            if (treeFront() && !flag) {
                reposition_to_west();
                flag = true;
            }
            if (!treeLeft() && treeFront() && flag)
            {
                repoisiton_to_east();
                flag = false;
            }

        }
    }
    //Function to make clara only move when there is no tree infront of her
    void safe_moves() {
        if (!treeFront())
            move();
    }
    //Function to make clara reposition to the east
    void repoisiton_to_east() {
        if (!treeRight() && treeFront()) {
            turnRight();
            safe_moves();
            turnRight();
        }
    }
    //Function to make clara reposition to the west
    void reposition_to_west() {
        if (!treeLeft() && treeFront())
        {
            turnLeft();
            safe_moves();
            turnLeft();
        }

    }
    //Function to make sure clara moves in the  pattern required for the checkboard
    void pattern() {
        putLeaf();
        safe_moves();
        safe_moves();
    }
}