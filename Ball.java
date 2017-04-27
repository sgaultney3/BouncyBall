package com.SamuelGaultney;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Samuel on 4/20/2017.
 */

@SuppressWarnings("serial")
public class Ball extends JPanel { //implements KeyListener

//======================================================================================================================

        private int x = 0;
        private int y = 0;
        private int xRect = 35;
        private int yRect = 35;
        private int xRect2 = 425;
        private int yRect2 = 35;
        private boolean xBackwards = false;
        private boolean yBackwards = false;
        private Dimension dimension;

        enum VerticalKey {UP, DOWN, NONE;}
        enum HorizontalKey {LEFT, RIGHT, NONE;}

        private VerticalKey verticalKeyState = VerticalKey.NONE;
        private HorizontalKey horizontalKeyState = HorizontalKey.NONE;
        private VerticalKey verticalKeyState2 = VerticalKey.NONE;
        private HorizontalKey horizontalKeyState2 = HorizontalKey.NONE;

//======================================================================================================================
    //CONSTRUCTOR
//======================================================================================================================

    public Ball(Dimension dimension) {
        this.dimension = dimension;
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "pressed.down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), new VerticalAction(VerticalKey.DOWN));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "released.down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), new VerticalAction(VerticalKey.NONE));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "pressed.up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), new VerticalAction(VerticalKey.UP));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "released.up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), new VerticalAction(VerticalKey.NONE));

        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "pressed.left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), new HorizontalAction(HorizontalKey.LEFT));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "released.left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), new HorizontalAction(HorizontalKey.NONE));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "pressed.right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), new HorizontalAction(HorizontalKey.RIGHT));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "released.right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), new HorizontalAction(HorizontalKey.NONE));

        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "pressed.down2", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), new VerticalAction2(VerticalKey.DOWN));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "released.down2", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), new VerticalAction2(VerticalKey.NONE));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "pressed.up2", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), new VerticalAction2(VerticalKey.UP));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "released.up2", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), new VerticalAction2(VerticalKey.NONE));

        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "pressed.left2", KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), new HorizontalAction2(HorizontalKey.LEFT));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "released.left2", KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), new HorizontalAction2(HorizontalKey.NONE));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "pressed.right2", KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), new HorizontalAction2(HorizontalKey.RIGHT));
        bindKeyStrokeTo(WHEN_IN_FOCUSED_WINDOW, "released.right2", KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), new HorizontalAction2(HorizontalKey.NONE));

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    switch (verticalKeyState) {
                        case UP:
                            yRect -= 10;
                            break;
                        case DOWN:
                            yRect += 10;
                            break;
                    }
                if (yRect + 100 > getHeight()) {
                    yRect = getHeight() - 100;
                } else if (yRect < 0) {
                    yRect = 0;
                }
                    switch (horizontalKeyState) {
                        case LEFT:
                            xRect -= 5;
                            break;
                        case RIGHT:
                            xRect += 5;
                            break;
                    }
                if (xRect + 400 > getWidth()) {
                    xRect = getWidth() - 400;
                } else if (xRect < 0) {
                        xRect = 0;
                }
                switch (verticalKeyState2) {
                    case UP:
                        yRect2 -= 10;
                        break;
                    case DOWN:
                        yRect2 += 10;
                        break;
                }
                if (yRect2 + 100 > getHeight()) {
                    yRect2 = getHeight() - 100;
                } else if (yRect2 < 0) {
                    yRect2 = 0;
                }
                switch (horizontalKeyState2) {
                    case LEFT:
                        xRect2 -= 5;
                        break;
                    case RIGHT:
                        xRect2 += 5;
                        break;
                }
                if (xRect2 + 110 < getWidth()) {
                    xRect2 = getWidth() - 110;
                } else if (xRect2 > 460) {
                    xRect2 = 460;
                }
                    repaint();
            }
        });
        timer.start();
    }

//======================================================================================================================

    //Moves ball right if ball is between max and min x-range or panel
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

            // draw Rectangle2D.Double
            g2d.fillRect(xRect, yRect, 25, 100);
            g2d.fillRect(xRect2, yRect2, 25, 100);
        }

    public void bindKeyStrokeTo(int condition, String name, KeyStroke keyStroke, Action action) {
        InputMap inputMap = getInputMap(condition);
        ActionMap actionMap = getActionMap();

        inputMap.put(keyStroke, name);
        actionMap.put(name, action);
    }
//-----------------Player 1 Setter for Key States-----------------------------------------------------------------------
    public void setVerticalKeyState(VerticalKey verticalKeyState) {
        this.verticalKeyState = verticalKeyState;
        System.out.println(verticalKeyState);
    }

    public void setHorizontalKeyState(HorizontalKey horizontalKeyState) {
        this.horizontalKeyState = horizontalKeyState;
    }
//-----------------Player 2 Setter for Key States-----------------------------------------------------------------------
    public void setVerticalKeyState2(VerticalKey verticalKeyState2) {
        this.verticalKeyState2 = verticalKeyState2;
        System.out.println(verticalKeyState2);
    }

    public void setHorizontalKeyState2(HorizontalKey horizontalKeyState2) {
        this.horizontalKeyState2 = horizontalKeyState2;
    }
//----------------------------------------------------------------------------------------------------------------------
//        //Called just after the user presses a key while the listened-to component has the focus.
//        @Override
//        public void keyPressed(KeyEvent e) {
//            if(e.getKeyCode() == KeyEvent.VK_DOWN) {
//                yRect = yRect + 10;
//               repaint();
//            }
//            if(e.getKeyCode() == KeyEvent.VK_UP) {
//                yRect = yRect - 10;
//                repaint();
//            }
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//        }
//        @Override
//        public void keyTyped(KeyEvent e) {
//        }

    public class VerticalAction extends AbstractAction{
        private VerticalKey verticalKey;

        public VerticalAction(VerticalKey verticalKeys) {
            this.verticalKey = verticalKeys;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setVerticalKeyState(verticalKey);
        }
    }

    public class HorizontalAction extends AbstractAction{
        private HorizontalKey horizontalKey;

        public HorizontalAction(HorizontalKey horizontalKeys) {
            this.horizontalKey = horizontalKeys;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setHorizontalKeyState(horizontalKey);
        }
    }
//---------------------------------Player 2 Action Class----------------------------------------------------------------
    public class VerticalAction2 extends AbstractAction{
        private VerticalKey verticalKey2;

        public VerticalAction2(VerticalKey verticalKeys2) {
            this.verticalKey2 = verticalKeys2;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setVerticalKeyState2(verticalKey2);
        }
    }

    public class HorizontalAction2 extends AbstractAction{
        private HorizontalKey horizontalKey2;

        public HorizontalAction2(HorizontalKey horizontalKeys2) {
            this.horizontalKey2 = horizontalKeys2;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setHorizontalKeyState2(horizontalKey2);
        }
    }


    }

