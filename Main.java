package com.SamuelGaultney;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Dimension dimension = new Dimension();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please specify pixel width:");
        dimension.setxDimension(scanner.nextInt());
        System.out.println("Please specify pixel height:");
        dimension.setyDimension(scanner.nextInt());

        JFrame frame = new JFrame("Bouncy Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Ball ball = new Ball(dimension);
        ball.setBackground(Color.cyan);
        frame.add(ball);
        frame.setSize(dimension.getxDimension(), dimension.getyDimension());
        frame.setVisible(true);


        while (true) {
            if (ball.isXBackwards()) {
                ball.moveBallLeft();
            } else {
                ball.moveBallRight();
            }

            if(ball.isYBackwards()) {
                ball.moveBallDown();
            } else {
                ball.moveBallUp();
            }

            ball.repaint();
            Thread.sleep(5);
        }




    }
}
