import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class ReactionGame extends Canvas implements Runnable {

    private MIDlet midlet;
    private boolean active = true;
    private long startTime;

    public ReactionGame(MIDlet m) {
        this.midlet = m;
        startTime = System.currentTimeMillis();
        new Thread(this).start();
    }

    protected void paint(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        g.setColor(0x000000);
        g.fillRect(0, 0, w, h);

        g.setColor(0xFFFFFF);
        g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        g.drawString("OK", w / 2, h / 2, Graphics.HCENTER | Graphics.BASELINE);
    }

    protected void keyPressed(int keyCode) {
        if (!active) return;

        int gameKey = getGameAction(keyCode);

        if (gameKey == FIRE) {
            active = false;
            showSuccess();
        }
    }

    private void showSuccess() {
        Form f = new Form("Успех");
        f.append("Вы прошли Java проверку!");
        Display.getDisplay(midlet).setCurrent(f);
    }

    private void showFail() {
        // имитация выключения
        Display.getDisplay(midlet).setCurrent(new Canvas() {
            protected void paint(Graphics g) {
                g.setColor(0x000000);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });

        try { Thread.sleep(1200); } catch (Exception e) {}
        midlet.notifyDestroyed();
    }

    public void run() {
        while (active) {
            if (System.currentTimeMillis() - startTime > 600) {
                active = false;
                showFail();
                break;
            }
        }
    }
}
