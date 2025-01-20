/* PERMITTED COMMANDS
   move(); turnLeft(); putLeaf(); removeLeaf();
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        // TODO: Write your code below
        int i=0;
        int j =0;
        move();
        right();
        move();
        turnLeft();
        while(i<5)
        {
            move();
            i++;
        }
        turnLeft();
     move();
     move();
     move();
     removeLeaf();
     turnLeft();
     turnLeft();
     move();
     move();
     move();
     right();
     while(j<6)
     {
         move();
         j++;
     }
     turnLeft();
     move();
     putLeaf();
     turnLeft();
     turnLeft();
     move();
     move();


    }
    void right()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}