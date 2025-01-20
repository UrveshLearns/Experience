/**
 * MyClara is a subclass of Clara. Therefore, it inherits all methods of Clara: <p>
 * 
 * 
 * PERMITTED COMMANDS
 * Actions:     move(), turnLeft(), turnRight(), putLeaf(), removeLeaf()
 *              mushroomFront(), canPushMushroom(), setNumberOfMoves(),
 *              testLevelComplete(), setDirectionUp(), setDirectionDown(),
 *              setDirectionLeft(), setDirectionRight(), getKey()
 * Sensors:     onLeaf(), treeFront(), mushroomFront(), loadLevel()
 * JAVA:        if, else, while, for, !, &&, ||
 */
class MyClara extends Clara 
{
    
    public char[][] level1 = {
		{'#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' '},
        {'#', ' ', '|', '#', ' ', ' ', ' ', ' ', ' ', ' '},
        {'#', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' '},
        {'#', ' ', '@', ' ', ' ', '#', ' ', ' ', ' ', ' '},
        {'#', ' ', ' ', '$', ' ', '#', ' ', ' ', ' ', ' '},
        {'#', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' '},
        {'#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' '},
    };
    
    public char[][] level2 = {
        {'#', '#', '#', '#', '#', ' ', ' ', ' ', ' '},
        {'#', '@', ' ', ' ', '#', ' ', ' ', ' ', ' '},
        {'#', ' ', '$', '$', '#', ' ', '#', '#', '#'},
        {'#', ' ', '$', ' ', '#', ' ', '#', '|', '#'},
        {'#', '#', '#', ' ', '#', '#', '#', '|', '#'},
        {' ', '#', '#', ' ', ' ', ' ', ' ', '|', '#'},
        {' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'},
        {' ', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
        {' ', '#', '#', '#', '#', '#', ' ', ' ', ' '},
    };
    
    public char[][] level3 = {
        {'#', '#', '#', '#', '#', '#', ' '},
        {'#', ' ', ' ', ' ', ' ', '#', ' '},
        {'#', ' ', '#', '@', ' ', '#', ' '},
        {'#', ' ', '$', '*', ' ', '#', ' '},
        {'#', ' ', '|', '*', ' ', '#', ' '},
        {'#', ' ', ' ', ' ', ' ', '#', ' '},
        {'#', '#', '#', '#', '#', '#', ' '},
    };

    public char[][] level4 = {
        {'#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {'#', ' ', '$', '$', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '$', ' ', ' ', ' ', ' ', '|', '#'},
        {'#', '#', ' ', ' ', ' ', ' ', ' ', '|', '#'},
        {' ', '#', ' ', ' ', ' ', ' ', ' ', '|', '#'},
        {' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {' ', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
        {' ', '#', '#', '#', '#', '#', ' ', ' ', ' '},
    };


    /*
     * In the 'act()' method you can write your program for Clara
     */
    static  int count = 0 ;
     int moves = 0;
    static char [][]current_level = level1; 
    

    public void act() 
    {
    movement();
     setNumberOfMoves(moves);
      if(testLevelComplete()){
          levelComplete();
       }
     }
     

    public void levelComplete()
     {
        if(count == 0){
          count++;
           showWarning("Level complete");
          loadLevel(level1);
      
        }
        if(count == 1){
                count++;
               showWarning("Level complete");
              loadLevel(level2);
        }

        if( count == 2){
        count++;
         showWarning("Level complete");
        loadLevel(level3);
        }
        if(count ==  3){
            count++;
             showWarning("Level complete");
            loadLevel(level4);
        }
        if(count == 4){
            count++;
            showWarning("Level complete");
        }
     }



   void storing_current_level(){
       for(int i = 0; i < level1.length; i++){
           for(int j = 0 ; j< level1[i].length; j++){
               current_level[i][j] = level1[i][j];
           }

       }
   }


   void movement() {
        if (Keyboard.isKeyDown("up"))
        {
            setDirectionUp();
            safe_moves();
        }
        if (Keyboard.isKeyDown("left"))
        {
            setDirectionLeft();
            safe_moves();
        }
        if (Keyboard.isKeyDown("down"))
        {
            setDirectionDown();
            safe_moves();
        }
        if (Keyboard.isKeyDown("right"))
        {
            setDirectionRight();
            safe_moves();
        }

    }
    public void safe_moves() {
        if ((!treeFront() && !mushroomFront()) || (mushroomFront() && canPushMushroom())) {
            move();
            moves++;
        }

    }
}