/* PERMITTED COMMANDS
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf();
   JAVA
   if, else, for, while, do, !, ||, && 
   variables
*/

class MyClara extends Clara {
    int treesX;
    int bufferX;
    int bufferY;
    int treesY;
    int gapX = 0;
    int gapY = 0;
    int mushroomX = 0;
    int mushroomY = 0;

    void run() {
        finding_bounds_of_chambers();
        bufferX = treesX;
        bufferY = treesY;
        while (!mushroomFront())
            streetwise_search();
        reset();
        reposition_to_fix_x();
        reset();
        reposition_to_fix_y();
        going_thru_tunnel();
        reset();
        moving_to_the_end();


        System.out.println(treesX);
        System.out.println(treesY);
        System.out.println(gapX + " . " + gapY);
        System.out.println(mushroomX + " . " + mushroomY);

    }
    void reset() {
        bufferX = 0;
        bufferY = 0;
    }

    void moving_to_the_end() {
        bufferX = 1;
        bufferY = gapY;
        if (bufferY < treesY) {
            turnLeft();
            move();
            turnRight();
            move();
            turnRight();
        }


        while (bufferY < treesY) {
            move();
            bufferY++;
        }

        if (bufferX < treesX) {
            turnRight();
            move();
            turnLeft();
            move();
            turnLeft();
        }
        while (bufferX < treesX)
        {
            move();
            bufferX++;
        }


    }
    void going_thru_tunnel() {
        turnRight();
        move();
        turnLeft();
        move();
        turnLeft();
        for (int i = 0; i <= 6; i++) {
            move();
        }
    }
    void reposition_to_fix_x() {
        if (mushroomX < gapX)
        {
            turnLeft();
            move();
            turnRight();
            move();
            move();
            turnRight();
            move();
            turnRight();
        }
        bufferX = mushroomX;
        while (bufferX < gapX)
        {
            move();
            bufferX++;

        }

    }
    void reposition_to_fix_y() {
        if (mushroomY < gapY) {
            turnLeft();
            move();
            turnRight();
            move();
            turnRight();
        }
        else
        {
            turnRight();
            move();
            turnLeft();
            move();
            turnLeft();
        }
        bufferY = mushroomY;
        if (bufferY > gapY)
        {
            while (bufferY > gapY)
            {
                move();
                bufferY--;
            }
        }
        else {
            while (bufferY < gapY)
            {
                move();
                bufferY++;
            }
        }


    }
    void safe_moves() {
        if (!treeFront() && !mushroomFront())
            move();
    }

    void streetwise_search() {


        while (!treeFront() && !mushroomFront()) {
            bufferX = bufferX - 1;
            safe_moves();

        }
        if (treeFront())
            reverse();
        while (bufferX < treesX) {
            safe_moves();
            bufferX++;
        }
        if (!mushroomFront()) {
            turnLeft();
            safe_moves();
            turnLeft();
            bufferY = bufferY - 1;
        }
        if (mushroomFront()) {
            mushroomX = bufferX;
            mushroomX = mushroomX - 1;
            mushroomY = bufferY;
        }
    }
    void reverse() {
        turnLeft();
        turnLeft();
    }

    void finding_bounds_of_chambers() {
        while (!treeFront()) {
            treesX++;
            move();
        }


        turnRight();
        while (!treeFront())
        {
            treesY++;
            move();

            if (!treeLeft()) {
                gapX = treesX;
                gapY = treesY;
            }

        }
        turnRight();
    }
}