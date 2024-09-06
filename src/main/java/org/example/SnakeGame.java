package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class SnakeGame {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public byte fieldWidth, fieldHeight;

    char[][] field;

    public Direction direction = Direction.UP;
    public byte fruitX, fruitY;
    public byte snakeX, snakeY;
    char snakeLength = 5;
    public void setDirection(Direction dir) {
        if(dir == Direction.LEFT && direction == Direction.RIGHT) return;
        if(dir == Direction.RIGHT && direction == Direction.LEFT) return;
        if(dir == Direction.DOWN && direction == Direction.UP) return;
        if(dir == Direction.UP && direction == Direction.DOWN) return;
        direction = dir;
    }
    public SnakeGame(byte fW, byte fH) {
        fieldWidth = fW;
        fieldHeight = fH;

        field = new char[fW][fH];
        generateFruit();
        snakeX = (byte) (fieldWidth/2);
        snakeY = (byte) (fieldHeight/2);
        // refactor idk
        for(int i = 0; i < fieldWidth; i++){
            for(int j = 0; j < fieldHeight; j++){
                field[i][j] = 0;
            }
        }
    }

    private void generateFruit() {
        fruitX = (byte) ThreadLocalRandom.current().nextInt(0, fieldWidth);
        fruitY = (byte) ThreadLocalRandom.current().nextInt(0, fieldHeight);
    }

    public boolean move() {
        switch(direction){
            case UP:
                snakeY -= 1; break;
            case DOWN:
                snakeY += 1; break;
            case LEFT:
                snakeX -= 1; break;
            case RIGHT:
                snakeX += 1; break;
        }

        if(snakeX < 0 || snakeX == fieldWidth
            || snakeY < 0 || snakeY == fieldHeight)
            return false; // true == continue

        // refactor idk
        for(int i = 0; i < fieldWidth; i++){
            for(int j = 0; j < fieldHeight; j++){
                if(field[i][j] > 0)
                    field[i][j] -= 1;
                System.out.println(field[0][0]);
                System.out.println("fd");
            }
        }
        if(snakeX == fruitX && snakeY == fruitY){
            generateFruit();
            snakeLength += 1;
        }
        field[snakeX][snakeY] = snakeLength;

        return true; // true == continue
    }
}
