/* PERMITTED COMMANDS
   Clara commands:
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf(); mushroomFront();
   JAVA commands:
   if, while, for, do, !, ||, &&
    */

class MyClara extends Clara {
    /**
     * In the 'run()' function you can write your program for Clara 
     */
    void run() {
        //With this function clara navigates thru the maze while staying on the leaf trail 
        moving_thru_maze();

        /*When clara goes off the trail this block helps her getting back on the trail where she turns around 
        and gets bacck on the trail */
        if (!onLeaf() && !mushroomFront()) {
            reverse();
            safe_moves();
            //Before turning back on the trail clara checks if the path is empty and there are no tree
            if (!treeRight()) {
                turnRight();
            }
            safe_moves();
            //After getting back on the trail clara continues moving on the  leaf trail
            moving_thru_maze();
        }

    }
    //This function helps clara navigate thru the maze while staying on the leaf trail
    void moving_thru_maze() {
        //To make sure clara only moves when she is standing on the leaf trail
        while (onLeaf()) {
            /*When there is a tree infront of clara and there is empty space to the right clara turns to the right 
            and continues on the leaf trail*/
            if (treeFront() && !treeRight()) {
                turnRight();
            }
            /*When there is a tree infront of clara and there is empty space to the left clara turns the left 
            and continues on the leaf trail*/
            if (treeFront() && !treeLeft()) {
                turnLeft();
            }
            //Clara removes the trail she moves 
            removeLeaf();
            //Clara moves only when there is no tree or mushroom infront of her
            safe_moves();

        }
    }
    //Function which makes sure clara only moves when there is no tree or mushroom infront of her
    void safe_moves() {
        if (!treeFront() && !mushroomFront())
            move();
    }
    //Function to make clara turnaround
    void reverse() {
        turnRight();
        turnRight();
    }
}