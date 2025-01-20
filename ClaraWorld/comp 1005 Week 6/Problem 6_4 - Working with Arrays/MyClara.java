/* PERMITTED COMMANDS 
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront,
   addTree(x, y),
   JAVA
   if, while, for, do, &&, !, ||, variables, arrays
*/

class MyClara extends Clara {
    /**
     * In the 'run()' function you can write your program for Clara 
     */
     int[][] position_of_tree = {{0,0,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,1,0,0,0,0,0},
                                 {0,0,0,0,1,1,1,0,0,0,0},
                                 {0,0,0,1,1,1,1,1,0,0,0},
                                 {0,0,1,1,1,1,1,1,1,0,0},
                                 {0,1,1,1,1,1,1,1,1,1,0},
                                 {1,1,1,1,1,1,1,1,1,1,1} };

    int checker = 0;                            
         
    void run() {

        drawtriangle();
       for( int j = 0 ; j <5 ;j++){
           turnLeft();
           move();
           turnRight();
           move();
       }
     removeLeaf();
     reverse();
     for(int i = 0 ; i < 5; i++)
     {
         move();
         turnLeft();
         move();
         turnRight();
     }                   
    }
    void drawtriangle(){
        for(int y = 0; y < position_of_tree.length ; y++)
        {
            for(int x = 0; x < position_of_tree[y].length; x++){
               checker = position_of_tree[y][x];
               if(checker == 1)
               addTree(x,y);
            }
        }
    }
    void reverse(){
        turnRight();
        turnRight();
            }
}