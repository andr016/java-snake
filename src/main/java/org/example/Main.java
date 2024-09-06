package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);

        //int snakeGame.fieldWidth = 10;
        //int fieldHeight = 10;

        SnakeGame snakeGame = new SnakeGame((byte) 25, (byte) 25);
        JPanel[][] squares = new JPanel[snakeGame.fieldWidth][snakeGame.fieldHeight];
        GridLayout grid = new GridLayout(snakeGame.fieldWidth,snakeGame.fieldHeight);

        JPanel panel = new JPanel();
        panel.setLayout(grid);

        // refactor?
        panel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
        panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
        panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
        panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
        panel.getActionMap().put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeGame.setDirection(SnakeGame.Direction.UP);
            }
        });
        panel.getActionMap().put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeGame.setDirection(SnakeGame.Direction.DOWN);
            }
        });
        panel.getActionMap().put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeGame.setDirection(SnakeGame.Direction.LEFT);
            }
        });
        panel.getActionMap().put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeGame.setDirection(SnakeGame.Direction.RIGHT);
            }
        });

        for(int i = 0; i < snakeGame.fieldWidth; i++)
            for(int j = 0; j < snakeGame.fieldHeight; j++) {
                squares[i][j] = new JPanel();
                squares[i][j].setBackground(Color.BLUE);
                panel.add(squares[i][j]);
            }

        Timer timer = new Timer(100, arg0 -> {
            if(snakeGame.move())
            for(int i = 0; i < snakeGame.fieldWidth; i++)
                for(int j = 0; j < snakeGame.fieldHeight; j++) {
                    if(snakeGame.field[i][j] > 0) {
                        squares[j][i].setBackground(Color.CYAN);
                    } else if (i == snakeGame.fruitX && j == snakeGame.fruitY){
                        squares[j][i].setBackground(Color.GREEN);
                    } else {
                        squares[j][i].setBackground(Color.BLUE);
                    }

                }
            else System.exit(0);
        });
        timer.setRepeats(true);
        timer.start();

        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

    }
}