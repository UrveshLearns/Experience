/**
 * Dot Class
 * 
 * Available methods (see Assignment document for explanations on what each method does):
 * onEarth
 * setDirection,
 * move(speed),
 * animate, animateInvisible,
 * intersects(Character), intersectsWithName(String)
 * moveToClara
 * wrapAroundWorld
 * playShotSound
 */
 
class Dot extends Character {
    //Add and initialise bullet's variables here

      //counter to make sure u can only fire every 7 seconds
    public static int reload_timer = 50;
    //counter to make sure bullet dies after 4 seconds
    public static int bulet_life = 80;
     
    int n = 0;
    int counting_dying = 0;
    int counting_reload = reload_timer;
    boolean bulletshot = false;
    public void act()
    {
        //collision with earth not working 
        //starting condition
        if(onEarth()){
             animateInvisible();
             MyClara.isBulletAlive = false;
             counting_dying = 0;
        }
        if (n == 0) {
            MyClara.isBulletAlive = false;
            animateInvisible();
            n++;
        }
        // counting to kill bullet
        if (bulletshot == true) {
            counting_dying++;
        }
        //to make sure bullet dies after 4 seconds
        if (counting_dying ==bulet_life) {
            MyClara.isBulletAlive = false;
            animateInvisible();
            System.out.println("Bullet is dead");
            counting_dying = 0;
        }
        //to start counting after the bullet is shot
        if (bulletshot == true) {
            counting_reload++; 
            if(counting_reload == reload_timer){
                bulletshot = false;
                System.out.println("Bullet ready");
            }  
        }
        //condition for reload 
        if (counting_reload == reload_timer) {
            if (Keyboard.isKeyDown("s") && !MyClara.dead) {
                //storing the state of bullet for reloading
                bulletshot = true;
                //storing the state of bullet for ghost
                MyClara.isBulletAlive = true;
                playShotSound();
                //reset counter for reload
                counting_reload = 0;
                //set direction for bullet movement
                if (MyClara.Direction_for_bullet == false)
                    setDirection("right");
                else
                    setDirection("left");
                //teleporting bullet to fire from claras position
                moveToClara();
                //animate the dot
                animate();
            }

        }

        if (getDirection() == "right" || getDirection() == "left")
            move(15);
    }
}