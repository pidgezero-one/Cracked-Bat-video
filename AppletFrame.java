import java.awt.*;

public class AppletFrame {
  public static void main(String[] args) {
    Example1Applet myApplet = new Example1Applet(); // define applet of interest
    Frame myFrame = new Frame("lumine hall? more like lumine lol"); // create frame with title

    // Call applet's init method (since Java App does not
    // call it as a browser automatically does)
    myFrame.setSize(264, 251);
    myFrame.add(myApplet, BorderLayout.CENTER);
    
    myApplet.init();
    myApplet.start();
    myApplet.run();	

    // add applet to the frame
    myFrame.setVisible(true); // usual step to make frame visible

  } // end main
} // end class