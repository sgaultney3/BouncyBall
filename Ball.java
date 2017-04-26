package com.SamuelGaultney;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Samuel on 4/20/2017.
 */

@SuppressWarnings("serial")
public class Ball extends JPanel {

        int x = 0;
        int y = 0;
        private boolean xBackwards = false;
        private boolean yBackwards = false;
        Dimension dimension;

    public Ball(Dimension dimension) {
        this.dimension = dimension;
    }

    public void moveBallRight() {
            if (x <= (dimension.getxDimension() - 45) && x >= 0) {
                x = x + 1;
            } else {
                x = x - 1;
                xBackwards = true;
            }
        }

        public void moveBallLeft() {
            if (x <= (dimension.getxDimension() - 45) && x >= 0) {
                x = x - 1;
            } else {
                x = x + 1;
                xBackwards = false;
            }
        }

        public void moveBallUp() {
            if (y <= (dimension.getyDimension() - 70) && y >= 0) {
                y = y + 1;
            } else {
                y = y - 1;
                yBackwards = true;
            }
        }

        public void moveBallDown() {
            if (y <= (dimension.getyDimension() - 70) && y >= 0) {
                y = y - 1;
            } else {
                y = y + 1;
                yBackwards = false;
            }
        }

        public boolean isXBackwards() {
            return xBackwards;
        }

        public boolean isYBackwards() {
            return yBackwards;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.fillOval(x, y, 30, 30);
        }
    }

