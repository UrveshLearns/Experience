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
        while (!mushroomFront()) {
            //Clara puts leaf while moving
            moving_putting_leaf();
            //When there is a tree infront of clara and there is no tree to the left of her she moves to the left also when there is no tree either left or right she still moves left
            if ((!treeLeft() && !treeRight()) || (treeFront() && !treeLeft())){
                turnLeft();
            }
            //When clara is infront of a tree and there is no tree to the right of her she moves to the right
            if (treeFront() && !treeRight()){
                turnRight();
            }
            //When clara is surrounded by trees she turns around and goes back to her previous trail
            if (treeFront() && treeRight() && treeLeft()){
                turnaround();
            }

        }
        //To put a leaf when she is infront of the mushroom
        putLeaf();
    }
    //Function to make sure clara puts leaves while she is moving if she has already placed a leaf she moves over it
    void moving_putting_leaf() {
        if (!onLeaf()) {
            putLeaf();
            move();
        }
        else
            move();
    }
    //Function to make clara turnaround by turn right twice
    void turnaround() {
        turnRight();
        turnRight();
    }
}