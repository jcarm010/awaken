package awaken;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.net.URL;

/**
 * Handles the system tray activities
 * @author javier
 */
public class SystemTrayHandler {
    private final SystemTray tray;
    private final TrayIcon trayIcon;
    private final PopupMenu menu;
    /**
     * Instantiates the system tray handler
     */
    public SystemTrayHandler(){
        tray = SystemTray.getSystemTray();
        menu = new PopupMenu();
        Image trayIconImage = getMouseIcon();
        int trayIconWidth = new TrayIcon(trayIconImage).getSize().width;
        trayIcon = new TrayIcon(trayIconImage.getScaledInstance(trayIconWidth, -1, Image.SCALE_SMOOTH),"Awaken",menu);
    }
    /**
     * Gets the default mouse icon
     * @return An image with the default mouse icon
     */
    private static Image getMouseIcon(){
        URL url = System.class.getResource("/images/sleep_moon.png");
        return Toolkit.getDefaultToolkit().getImage(url);
    }
    /**
     * Shows the icon in the System Tray
     * @throws AWTException An exception if the system tray is not supported
     */
    public void showIcon() throws AWTException{
        MenuItem closeItem = new MenuItem("Close");
        closeItem.addActionListener(event -> System.exit(0));
        menu.add(closeItem);
        tray.add(trayIcon);
    }
}
