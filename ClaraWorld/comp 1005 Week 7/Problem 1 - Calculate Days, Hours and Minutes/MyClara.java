/* PERMITTED COMMANDS
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, while, for
*/

class MyClara extends Clara {
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        int input_in_seconds = readInt("Enter the amount in seconds:");
        int minutes = 0;
        int seconds = 0;
        int days = 0;
        int hours = 0;
        int bufffer = 0;
        days = input_in_seconds / 86400;
        bufffer = input_in_seconds % 86400;
        hours = bufffer / 3600;
        bufffer = bufffer % 3600;
        minutes = bufffer / 60;
        bufffer = bufffer % 60;
        seconds = bufffer;
        System.out.println("Number of Days :" + days);
        System.out.println("Number of hours :" + hours);
        System.out.println("Number of minutes :" + minutes);
        System.out.println("Number of seconds :" + seconds);
    }
}