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
        //Remembering the longest step clara takes
        int longest_step = 0;
        //Clara counts the amount of steps she takes before going up the staris
        int count = 0;
        //Clara moves untill she is at the top of the staircase shown by the leaf
        while (!onLeaf())
        {
            //Clara moves untill she reaches in front of the tree while counting the steps she takes
            while (!treeFront())
            {
                count++;
                move();

            }
            //Clara moves up the stair case
            stepping_up();
            /*Clara compares the amount of steps she takes if the count is higher then her
             current longest steps she remembers the count */
            if (count > longest_step)
                longest_step = count;
            /* Clara rests the counter before going up the staircase*/
            count = 0;
        }
        //Clara removes the leaf after reaching the top of the staircase
        removeLeaf();
        //Clara shows the longest step she remember
        System.out.println("longest step = " + longest_step);
    }
    //This function allows clara to move up the staircase
    void stepping_up() {
        if (treeFront() && !treeLeft())
        {
            turnLeft();
            move();
            turnRight();
        }

    }
}