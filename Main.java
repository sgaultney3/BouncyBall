package com.SamuelGaultney;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Dimension dimension = new Dimension();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please specify pixel width:");
//        dimension.setxDimension(scanner.nextInt());
//        System.out.println("Please specify pixel height:");
//        dimension.setyDimension(scanner.nextInt());

        //Instantiates frame and makes the program quit on exit
        JFrame frame = new JFrame("Bouncy Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Instantiates ball panel to frame
        Ball ball = new Ball(dimension);

        //POTENTIAL CHALLENGE: Make the background color shift through the rainbow
        ball.setBackground(Color.cyan);

        //Allows component to receive focus, focus is when the keyboard will be utilizable in that component.
        ball.setFocusable(true);

        //ball.addKeyListener(ball);
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
