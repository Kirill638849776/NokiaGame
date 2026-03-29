import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class JavaSplash extends Canvas implements Runnable {

    private MIDlet midlet;
    private int alpha = 0; // прозрачность для плавного появления

    public JavaSplash(MIDlet m) {
        this.midlet = m;
        new Thread(this).start();
    }

    protected void paint(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        // чёрный фон
        g.setColor(0x000000);
        g.fillRect(0, 0, w, h);

        // белый текст с прозрачностью
        int color = (alpha << 24) | 0xFFFFFF;
        g.setColor(color);

        g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        g.drawString("Java", w / 2, h / 2 - 10, Graphics.HCENTER | Graphics.BASELINE);

        g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        g.drawString("powered", w / 2, h / 2 + 15, Graphics.HCENTER | Graphics.BASELINE);
    }

    public void run() {
        try {
            // плавное появление
            for (int i = 0; i <= 255; i += 15) {
                alpha = i;
                repaint();
                Thread.sleep(40);
            }

            Thread.sleep(800); // пауза

            // плавное исчезновение
            for (int i = 255; i >= 0; i -= 15) {
                alpha = i;
                repaint();
                Thread.sleep(40);
            }

        } catch (Exception e) {}

        // переход к окну Nokia
        Display.getDisplay(midlet).setCurrent(new NokiaSystemBox(midlet));
    }
}
