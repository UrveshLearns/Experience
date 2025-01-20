/* PERMITTED COMMANDS
   Clara commands:
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf(); mushroomFront();
   JAVA commands:
   if, else, for, while, do, &&, ||, ! */

class MyClara extends Clara {
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        //Looping untill in front of the mushroom
        while (!mushroomFront())
        {
            //Checking whether clara is on a leaf if she isnt then she puts down a leaf
            if (!onLeaf())
                putLeaf();
            //Ensuring clara doesnt crash into a tree when theres a tree in front of her and she moves in the left space
            if (treeFront() && !treeLeft())
                turnLeft();
            move();

        }
        //Inorder to not forget the last leaf when clara is infront of the mushroom
        putLeaf();

    }
}