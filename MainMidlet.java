import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MainMidlet extends MIDlet {

    protected void startApp() {
        Display.getDisplay(this).setCurrent(new JavaSplash(this));
    }

    protected void pauseApp() {}

    protected void destroyApp(boolean unconditional) {}
}
