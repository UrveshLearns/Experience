/* PERMITTED COMMANDS
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, while, for
*/

class MyClara extends Clara {
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    int cake_height = 0;
    int cake_width = 0;
    void run() {
        int border = 0;
        // TODO: Write your code below
        cake_height = readInt("Enter the height of the cake: ");
        cake_width = readInt("Enter the  width of the cake: ");
        move();
        while (cake_width > 18) {
            System.out.println("Invalid width");
            cake_width = readInt("ReEnter the width of the cake");
        }
        while (cake_height > 10) {
            System.out.println("Invalid height");
            cake_height = readInt("ReEnter the height of the cake");

        }
        cake_completion();
        for(int u = 0 ; u < cake_width; u = u+2){
            candles();
            reversing_candle();
        }
        
    }
    void cake_completion() {
        for (int i = 0; i < cake_height; i++) {
            cake_width_maker();
            turnLeft();
            move();
            turnRight();
            move();
        }
    }
    void cake_width_maker() {
        for (int p = 0; p < cake_width; p++)
        {
            putLeaf();
            move();
        }
        reverse_turn();
        move();
        while (onLeaf())
            move();
        reverse_turn();
    }
    void reverse_turn() {
        turnLeft();
        turnLeft();
    }
    void candles(){
        turnLeft();
        for(int k = 0 ; k <3;k++){
            putLeaf();
            move();
        }
    }
    void reversing_candle(){
        reverse_turn();
        for(int l = 0 ; l <3 ; l++){
            move();
        }
        turnLeft();
        move();
        move();
    }


   
}