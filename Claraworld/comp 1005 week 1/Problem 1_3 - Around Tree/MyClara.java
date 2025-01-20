/* PERMITTED COMMANDS
   move(); turnLeft(); putLeaf(); removeLeaf();
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        // TODO: Write your code below
        move();
        right();
        move();
        turnLeft();
        move();
        move();
        turnLeft();
        move();
        move();
        right();
        move();
        move();
        right();
        move();
        move();
        turnLeft();
        move();
        move();
        move();
        turnLeft();
        move();
        removeLeaf();
        right();
        move();
    }
    void right(){
        turnLeft();
        turnLeft();
        turnLeft();
    }
}