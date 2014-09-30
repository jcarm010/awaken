package awaken;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

/**
 * Handles mouse movement
 * @author javier
 */
public class MouseHandler {
    private final Robot robby;
    /**
     * Instantiates a mouse handler
     * @throws AWTException If mouse is not supported by the system
     */
    public MouseHandler() throws AWTException{
        robby = new Robot();
    }
    /**
     * Move mouse to the same place where it is.
     */
    public void invisibleMouseMove(){
        Point p = MouseInfo.getPointerInfo().getLocation();
        robby.mouseMove(p.x, p.y);
    }
}
