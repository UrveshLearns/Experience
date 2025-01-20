/**
 * Ghost Class
 * 
 * Available methods (see Assignment document for explanations on what each method does):
 * earthFront
 * getDirection, setDirection,
 * move(speed),
 * animate, animateDead,
 * intersects(Character), intersectsWithName(String)
 * getClara,
 * makeClaraDead,
 * wrapAroundWorld
 * playGameOverSound
 */

class Ghost extends Character
{
    public static int ghost_speed = Clara.getRandomNumber(15);
    public static int deciding_direction = Clara.getRandomNumber(2);
    String n;
    public static int ghost_Counter = 120;
    //Checking whther ghost is alive or dead
    public static boolean isGhostDead = false;

    int ressurection_time = 0;
    public void act()
    {
        if (ressurection_time == ghost_Counter) {
            isGhostDead = false;
            ressurection_time = 0;
            System.out.println("Ghost alive " + isGhostDead);
        }
        //  ressurecting ghosts
        if (!isGhostDead) {
            animate();
        }
        if (isGhostDead) {
            ressurection_time++;
        }


        if (intersectsWithName("Dot") && MyClara.isBulletAlive) {
            //boolean to check whether the ghost is alive using that information in Myclara to kill ghost
            isGhostDead = true;
            animateDead();
        }


        if (intersects(getClara()) && !isGhostDead) {
            makeClaraDead();
            if (MyClara.dead == false)
                playGameOverSound();
        }
        //Make the Ghost do things here
        //Starting the movement
        starting_case();

        //changing direction when bumped into a wall
        if (earthToRight() && earthBelow()) {

            setDirection("left");

        }
        if (earthToLeft() && earthBelow()) {

            setDirection("right");
        }
        //gravity for ghosts work in progress  
        if(getDirection() == " down" && earthBelow() ) {

            setDirection("right");
        }
        if (!earthBelow()) {
            setDirection("down");
            move(ghost_speed);
        }


        // continuous movement
        if (earthBelow() && !earthFront()) {
            move(ghost_speed);
        }

    }
    void starting_case() {
        if ((deciding_direction == 0 && getDirection() == "up") || earthFront()) {
            setDirection("right");
        }

        if ((deciding_direction == 1 && getDirection() == "up") || earthFront()) {
            setDirection("left");
        }
    }




}