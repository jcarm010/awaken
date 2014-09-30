package awaken;

import java.awt.AWTException;

/**
 * Runs the awaken program to keep machine awake
 * @author javier
 */
public class Awaken {
    private static int timeout = 60000;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MouseHandler mhandler = null;
        try{
            mhandler = new MouseHandler();
            SystemTrayHandler shandler = new SystemTrayHandler();
            shandler.showIcon();
        }catch(AWTException err){
            err.printStackTrace(System.err);
            System.exit(0);
        }
        while(true){
            mhandler.invisibleMouseMove();
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
    
}
