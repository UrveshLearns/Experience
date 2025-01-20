/**
 * MyClara is a subclass of Clara. Therefore, it inherits all methods of Clara: <p>
 * 
 * 
 * PERMITTED COMMANDS
 * Actions:     move(), turnLeft(), turnRight(), putLeaf(), removeLeaf()
 *              mushroomFront(), canPushMushroom(), setNumberOfMoves(),
 *              testLevelComplete(), setDirectionUp(), setDirectionDown(),
 *              setDirectionLeft(), setDirectionRight(), getKey()
 * Sensors:     onLeaf(), treeFront(), mushroomFront()
 * JAVA:        if, else, while, for, !, &&, ||
 */
class MyClara extends Clara
{
    String key = "";
    int moves = 0;
    int count = 0;
    /**
     * In the 'act()' method you can write your program for Clara
     */
    public void act()
    {
        movement();
        setNumberOfMoves(moves);
        if (count == 0) {
            if (testLevelComplete()) {
                count++;
                levelComplete();

            }
        }
    }


    public void levelComplete()
    {
        showWarning("Level Complete!");

    }

    void movement() {
        key = getKey();
        if (key == "up")
        {
            setDirectionUp();
            safe_moves();
        }
        if (key == "left")
        {
            setDirectionLeft();
            safe_moves();
        }
        if (key == "down")
        {
            setDirectionDown();
            safe_moves();
        }
        if (key == "right")
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