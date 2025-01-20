/* PERMITTED COMMANDS
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, while, for
*/

class MyClara extends Clara {
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    int age = 0;
    int candles_height = 0;
    int no_of_candles = 0;
    void run() {
        // TODO: Write your code below
        age = readInt("Enter age ");
        while (age > 100) {
            age = readInt("Enter a valid age ");
        }
        cake();
        System.out.println("age :" + age);

        reposition_for_centre();
        candles();


    }
    void cake() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 18; j++) {
                putLeaf();
                move();
            }
            if (i % 2 == 0) {
                turnLeft();
                move();
                turnLeft();
                move();
            }
            else
            {
                turnRight();
                move();
                turnRight();
                move();
            }
        }
    }
    void reposition_for_centre() {
        no_of_candles = age / 10;
        int temp = 0;
        temp = no_of_candles * 2;

        temp = 18 - temp;

        for (int i = 0; i < temp; i = i + 2) {
            move();
        }

    }



    void candles() {

        candles_height = age % 10;
        if (candles_height == 0)
            candles_height = 1;

        for (int i = 0; i < no_of_candles; i++)
        {
            turnLeft();
            for (int j = 0; j < candles_height; j++) {
                putLeaf();
                move();
            }
            reverse_candle();
        }

    }
    void reverse_candle() {
        turnLeft();
        turnLeft();
        for (int i = 0; i < candles_height; i++)
            move();
        turnLeft();
        move();
        move();
    }

}