/* PERMITTED COMMANDS 
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf(); mushroomFront();
   onLeaf(x, y); putLeaf(x,y); removeLeaf(x,y); for sensing, adding or removing a leaf at coordinate (x,y)
   onFire(x, y); putFire(x,y); removeFire(x,y); for sensing, adding or removing a leaf at coordinate (x,y)
   getX(); getY(); for obtaining the current coordinates of Clara
   JAVA
   if, while, for, do, &&, ||, !
   variables, arrays
*/

class MyClara extends Clara {
    // constants
    final int WORLD_HEIGHT = 30;
    final int WORLD_WIDTH = 40;

    // variables
    boolean[][] currentWorldState;
    boolean[][] nextWorldState;


    /**
     * Place leaves at random and then apply the game of life rules
     */
    void run()
    {
        // obtain the currentWorldState array by checking for leaves in the world
        currentWorldState = worldToArray();

        // play game of life if not running for the first time
        nextWorldState = applyGameOfLifeRules(currentWorldState);
        updateWorld(nextWorldState);
        currentWorldState = nextWorldState;
    }


    /**
     * Scan the world for leaves and put true as the value of the 
     * corresponding array element if a leaf is found
     */
    boolean[][] worldToArray()
    {
        boolean[][] retVal = new boolean[WORLD_WIDTH][WORLD_HEIGHT];

        for (int i = 0; i < WORLD_WIDTH; i++)
        {
            for (int k = 0; k < WORLD_HEIGHT; k++)
            {
                if ( onLeaf(i, k) )
                    retVal[i][k] = true;    
                else                
                    retVal[i][k] = false;
            }
        }

        return retVal;
    }


    /**
     * Go through the every element of inInitialArray and apply game of life rules to it
     * The results will be stored in the array that this method returns
     */
    boolean[][] applyGameOfLifeRules(boolean[][] inInitialArray)
    {
        boolean[][] resultingArray = new boolean[inInitialArray.length][inInitialArray[0].length];

        // go through all elements of the initial array and count neighbours
        // apply game of life rules based on the number of each cell's neighbours
        for (int i = 0; i < inInitialArray.length; i++)
        {
            for (int k = 0; k < inInitialArray[i].length; k++)
            {
                int neighbours = countNeighbours(inInitialArray, i, k);

                // Any live cell with fewer than two live neighbours dies, as if caused by under-population
                if (neighbours < 2)
                    resultingArray[i][k] = false;

                // Any live cell with two or three live neighbours lives on to the next generation
                if ((inInitialArray[i][k] == true) && (neighbours == 2 || neighbours == 3))
                    resultingArray[i][k] = true;

                // Any live cell with more than three live neighbours dies, as if by overcrowding
                if (neighbours > 3)
                    resultingArray[i][k] = false;

                // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
                if (neighbours == 3 && inInitialArray[i][k] == false)
                    resultingArray[i][k] = true;
            }
        }

        return resultingArray;
    }


    /**
     * Remove all the leaves in Clara's world
     */
    void cleanWorld()
    {
        for (int i = 0; i < WORLD_WIDTH; i++)
        {
            for (int k = 0; k < WORLD_HEIGHT; k++)
            {
                if ( onLeaf(i, k) )
                    removeLeaf(i, k);
            }
        }
    }


    /**
     * Given the array and the coordinates of a particular element of this array
     * count how many neighbors that are not false does this array have.
     */
    int countNeighbours(boolean[][] inArray, int x, int y)
    {
        int retVal = 0;

        // we need to check all 8 surrounding cells
        // including those on the diagonal 
        for (int i = -1; i <= 1; i++)
        {
            for (int k = -1; k <= 1; k++)
            {
                // do not count ourselves
                if (i == 0 && k == 0)
                    continue;

                // don't try to assign values outside of array bounds
                if ((x + i < 0) || (y + k < 0) || (x + i >= inArray.length) || (y + k >= inArray[0].length))
                    continue;

                // do the counting
                if (inArray[x + i][y + k] == true)
                    retVal++;
            }
        }

        return retVal;
    }


    /**
     * Receives an array as input and for evey element that is true in this array
     * puts a leaf in Clara's world at the corresponding coordinate.
     */
    void updateWorld(boolean[][] inArray)
    {
        cleanWorld();

        for (int i = 0; i < inArray.length; i++)
        {
            for (int k = 0; k < inArray[i].length; k++)
            {
                if (inArray[i][k] == true)
                    putLeaf(i, k);
            }
        }
    }

}