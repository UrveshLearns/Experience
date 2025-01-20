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
        //Counting the number of steps clara takes
        int num_step = 0;
        //Counting the number of leafs clara eats
        int leafs = 0;
        //Clara moves untill she is at the end of the maze 
        while (!treeFront())
        {
            //Whenever clara moves she adds one to the count of her steps
            num_step = num_step + 1;
            if (onLeaf())
            {
                removeLeaf();
                //Whenever clara eats a leaf she adds one to her count
                leafs = leafs + 1;
            }

            move();
            //If clara bumps into a tree she takes a right turn and continues moving
            if (treeFront() && !treeRight())
                turnRight();
        }
        //After stopping if there is a leaf at the end clara eats that leaf and adds it to her counter
        if (treeFront() && onLeaf())
        {
            removeLeaf();
            leafs++;
        }
        //Outputs to the console the amount of leaves clara ate and the number steps clara took
        System.out.println(leafs + " leaves, " + num_step + " steps");
    }
}