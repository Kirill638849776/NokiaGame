package javax.microedition.lcdui;

public abstract class Canvas {
    public static final int FIRE = 8;

    protected abstract void paint(Graphics g);

    protected void keyPressed(int keyCode) {}
    protected void keyReleased(int keyCode) {}

    public int getGameAction(int keyCode) { return 0; }
    public int getWidth() { return 240; }
    public int getHeight() { return 320; }
}
