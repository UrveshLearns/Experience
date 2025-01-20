/* PERMITTED COMMANDS
   move(); turnLeft(); putLeaf(); removeLeaf();
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        // TODO: Write your code below
       for(int i=0;i<5;i++){
       alternatleafs();
       }
        move();
        move();
    }
    void alternatleafs()
    {
        move();
        putLeaf();
        move();

    }
}