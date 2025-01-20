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
        move();
        move();
        move();
        turnLeft();
        move();
        move();
    }
    void right(){
    turnLeft();
    turnLeft();
    turnLeft();
    }
    
}