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


        //This loops untill clara is at the end of the maxe infront of the mushroom
        while (!mushroomFront())
        {
            //Sets up the flag and resets the flag after reaching the end of the corridor
            boolean Flag = false;
            /*At the start of the corridor clara checks whether she is standing on a leaf or not if there is a
            leaf clara raises the flag and removes the leaf if there is no leaf clara lowers the flag*/
            if (onLeaf())
            {
                Flag = true;
                removeLeaf();
            }

            //Clara moves untill she reaches at the end of the corridor
            while (!treeFront() && !mushroomFront()) {
                move();
            }
            //Clara checks her flag ,if the flag is raised clara turns right otherwise clara turns left 
            if (treeFront()) {
                if (Flag)
                    turnRight();
                else
                    turnLeft();
            }

        }

    }

}