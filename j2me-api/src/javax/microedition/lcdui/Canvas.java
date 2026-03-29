package javax.microedition.lcdui;

public abstract class Canvas extends Displayable {
    public static final int UP = 1;
    public static final int DOWN = 6;
    public static final int LEFT = 2;
    public static final int RIGHT = 5;

    protected abstract void paint(Graphics g);
    protected void keyPressed(int keyCode) {}
    protected void keyReleased(int keyCode) {}
}
