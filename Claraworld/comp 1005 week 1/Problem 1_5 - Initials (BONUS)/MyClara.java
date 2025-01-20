/* PERMITTED COMMANDS
   move(); turnLeft(); putLeaf(); removeLeaf();
*/

class MyClara extends Clara {
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        move();
        right();
        move();
        straight();
        turnLeft();
        moving_eating();
        moving_eating();
        moving_eating();
        turnLeft();
        straight();
        removeLeaf();
        right();
        move();
        move();
        right();
        straight();
        removeLeaf();
        turnLeft();
        turnLeft();
        reverse();
        right();
        move();
        moving_eating();
        moving_eating();
        moving_eating();
        right();
        move();
        moving_eating();
        moving_eating();
        moving_eating();
        right();
        move();
        moving_eating();
        moving_eating();
        moving_eating();
    }
    void right()
    {
        turnLeft();
        turnLeft();
        turnLeft();

    }
    void straight()
    {
        for (int i = 0; i < 8; i++)
        {
            removeLeaf();
            move();
        }
    }
    void reverse()
    {
        for (int i = 0; i < 8; i++)
        {
            move();
        }
    }
    void moving_eating()
    {
        removeLeaf();
        move();

    }
}