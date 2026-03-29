import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class NokiaSystemBox extends Canvas implements Runnable {

    private MIDlet midlet;

    public NokiaSystemBox(MIDlet m) {
        this.midlet = m;
        new Thread(this).start();
    }

    protected void paint(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        // серый фон
        g.setColor(0xCCCCCC);
        g.fillRect(0, 0, w, h);

        // рамка
        g.setColor(0x000000);
        g.drawRect(10, 10, w - 20, h - 20);

        // текст
        g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        g.drawString("Java Powered", w / 2, h / 2 - 20, Graphics.HCENTER | Graphics.BASELINE);

        g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        g.drawString("Запуск приложения...", w / 2, h / 2 + 10, Graphics.HCENTER | Graphics.BASELINE);
    }

    public void run() {
        try { Thread.sleep(1500); } catch (Exception e) {}
        Display.getDisplay(midlet).setCurrent(new ReactionGame(midlet));
    }
}
