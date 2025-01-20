/**
 * MyClara
 * 
 * Available methods (see Assignment document for explanations on what each method does):
 * getDirection, setDirection,
 * move,
 * animate, animateDead, 
 * onLeaf, removeLeaf, 
 * onEarth,
 * allLeavesEaten,
 * isClaraDead,
 * playCollectLeafSound,
 * playIntro, isIntroStillPlaying,
 * playJumpSound, playLevelFinishedSound,
 * isLevelFinishedSoundStillPlaying
 * wrapAroundWorld,
 * getCurrentLevelNumber, advanceToLevel
 */
class MyClara extends Clara
{
    // Please leave this first level here,
    // until after you've completed Part 9 - "Making and Adding Levels"   
    public final char[][] LEVEL_1 = {
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','~',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ','.',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','.',' ','%',' ','~',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ','~','~','~',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','~','~','~','~','~','~',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','~','~','~',' ',' ','~','~',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','~',' ',' ',' ',' '},
    {'~','@','-','~','~',' ',' ','.',' ',' ',' ','%',' ','~','~','~','.','.','~','~',' ',' ','.',' ',' ',' ',' ',' ',' ',' ',' ',' ','%',' ',' ','~',' ',' ','$','~'},
    {'~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~','~'}
    };

    // Orientation constants
    public final String  UP = "up";    
    public final String  DOWN = "down";    
    public final String  LEFT = "left";    
    public final String  RIGHT = "right";

    final int JUMP_VELOCITY_X = 1;
    final int JUMP_VELOCITY_Y = 2;
    final int GRAVITY_X = 0;
    final int GRAVITY_Y = -1;
    //finding clara in the level
    public int claraX = 0 ;
    public int claraY = 0;
    public int level_counter = 0;
    
    //BOOLEAN TO get direction for bullets
    public static boolean Direction_for_bullet = false;
    //Defining clara death and stopping movement
    static boolean dead = false;
    //If the bullet is not alive the ghost wont die to it
    public static boolean isBulletAlive = false;

    void getting_direction_bullet(){
        if(getDirection() == "left"){
         Direction_for_bullet = true;
        }
        else if(getDirection() == "right"){
            Direction_for_bullet = false;
        }
    }
    public void act()
    {
        if(dead == false)
        playIntro();
        animate();
        //Make Clara do things here
        getting_direction_bullet();
        getCurrentLevelNumber();
     //   System.out.println(isClaraDead());
     if(mushroomFront() && allLeavesEaten()){
         playLevelFinishedSound();
     }
     if(isLevelFinishedSoundStillPlaying()){
         levelComplete();
         advanceToLevel(LEVEL_1);
         level_counter++;
     }

        //Death condition
        if(isClaraDead()){
            animateDead();
            dead = true;
        }
        forcegravity();
        if(!isClaraDead())
         movement();
    }
    
//trying to cook gravity
    void forcegravity(){
        if(!earthBelow()){
            setDirection(DOWN);
            collecting_leaves();
            move();
         if(earthBelow()){
         collecting_leaves();
         setDirection(RIGHT);
         }
            claraY = claraY-1;
        }
        
    }

    //collecing leaves
    void collecting_leaves(){
        if(onLeaf()){
            playCollectLeafSound();
            removeLeaf();


        }
    }

        //modified jump method almost works 
        /*need to fix her teleportation and not being able to jump on the platform
        not working shit*/
    int jump(int inOriginalX, int inVelocityX, int inVelocityY)
    {
        //finding claras initial position before the jump
        int posY = claraY;
        int posX = 0;
        do
        {     
        /* IF clara is facing the right we add to her initial x value and move one up*/
            if(getDirection() == "right"){
            posX += inVelocityX;
            }

        /*IF clara is facing the right we subtract from her initial x values and move one up*/
            if(getDirection() == "left"){
            posX = posX - inVelocityX;
            } 
            
            posY += inVelocityY;
        /*We use the inbuilt function to change her position*/
            changePosition(inOriginalX, posX, posY);
            collecting_leaves();
            
            inVelocityX = inVelocityX + GRAVITY_X;
            inVelocityY = inVelocityY + GRAVITY_Y;
            
        }

        //trying to wokr on the jump while on the platform
        while ( posY > 0 && !earthBelow() && !onEarth());
        //collecting leafs working half
        claraY = posY;
        //Returning the new claras position
        return inOriginalX + posX;
    }

    //Premade function for level complete not tampered yet
     public void levelComplete()
    {
        showWarning("Level Complete!");

    }

    void movement() {

        //taking input from keyboard and comparing to the corresponding movement needed
        if (Keyboard.isKeyDown("up"))
        {
            
            playJumpSound(); 
            //Jumping clara with the function
            collecting_leaves();
          claraX = jump(claraX,JUMP_VELOCITY_X,JUMP_VELOCITY_Y);
           
        }
        if (Keyboard.isKeyDown("left"))
        {
            //setting the direction and then moving while checking and removing any leafs
            collecting_leaves(); 
            setDirection(LEFT);
            move();
            collecting_leaves();    
            claraX = claraX-1;                
        }
        
        if (Keyboard.isKeyDown("right"))
        {
            collecting_leaves();
            setDirection(RIGHT);
            move();
            collecting_leaves();  
            claraX++;          
        }

    }
       

    
}