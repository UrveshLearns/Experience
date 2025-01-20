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

        int cake_height = readInt("Enter the height of the cake: ");
        int cake_width = readInt("Enter the  width of the cake: ");
        while (cake_width > 19) {
            System.out.println("Invalid width");
            cake_width = readInt("ReEnter the width of the cake");
        }
        while (cake_height > 15) {
            System.out.println("Invalid height");
            cake_height = readInt("ReEnter the height of the cake");

        }

        int border = 0;
        for (int i = 0; i < cake_height; i++)
        {
            while (border < cake_width)
            {
                putLeaf();
                move();
                border++;
            }
            if (i % 2 == 0)
                reposition_to_west();
            else
                repoisiton_to_east();
            border = 0;
        }
    }
    void repoisiton_to_east() {
        turnRight();
        move();
        turnRight();
        move();

    }
    void reposition_to_west() {
        turnLeft();
        move();
        turnLeft();
        move();

    }


}