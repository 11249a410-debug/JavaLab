// Ex 8(a): simple applet that draws text and shapes
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HelloApplet extends JPanel {

    public HelloApplet() {
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.drawString("Welcome to SCSVMV", 30, 25);

        g.setColor(Color.RED);
        g.fillOval(30, 45, 60, 60);

        g.setColor(Color.GREEN);
        g.fillRect(110, 45, 80, 60);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hello Applet Demo");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new HelloApplet());
            frame.setSize(260, 160);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

// Ex 8(a): watch the order of the life-cycle methods on the console
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LifeCycle extends JPanel {

    public LifeCycle() {
        System.out.println("init()");
    }

    public void start() {
        System.out.println("start()");
    }

    public void stop() {
        System.out.println("stop()");
    }

    public void destroy() {
        System.out.println("destroy()");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println("paint()");
        g.drawString("Minimise and restore this window", 20, 30);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Life Cycle Demo");
            LifeCycle panel = new LifeCycle();

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(panel);
            frame.setSize(350, 150);
            frame.setLocationRelativeTo(null);

            panel.start();
            frame.setVisible(true);

            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    panel.stop();
                }

                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    panel.destroy();
                }
            });
        });
    }
}

// Ex 8(b): click a colour box, the big box below changes
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Palette extends JPanel {

    private final Color[] c = {
        Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW
    };

    private int sel = 0;

    public Palette() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (y >= 20 && y <= 60) {
                    int i = (x - 20) / 60;

                    if (x >= 20 && i >= 0 && i < c.length) {
                        sel = i;
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the four color boxes
        for (int i = 0; i < c.length; i++) {
            g.setColor(c[i]);
            g.fillRect(20 + i * 60, 20, 50, 40);
        }

        // Draw the selected color in the large box
        g.setColor(c[sel]);
        g.fillRect(20, 90, 230, 60);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Color Palette");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Palette());
            frame.setSize(310, 210);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

//case study
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BarChart extends JPanel {

    private final int[] marks = {78, 91, 45, 66, 88};
    private String msg = "Click a bar";

    public BarChart() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                for (int i = 0; i < marks.length; i++) {
                    int barX = 20 + i * 50;
                    int barY = 150 - marks[i];
                    int barWidth = 40;
                    int barHeight = marks[i];

                    if (x >= barX && x <= barX + barWidth
                            && y >= barY && y <= barY + barHeight) {
                        msg = "Subject " + (i + 1) + " = " + marks[i];
                        repaint();
                        return;
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString(msg, 20, 20);

        for (int i = 0; i < marks.length; i++) {
            g.setColor(marks[i] >= 50 ? Color.GREEN : Color.RED);

            int x = 20 + i * 50;
            int y = 150 - marks[i];

            g.fillRect(x, y, 40, marks[i]);

            g.setColor(Color.BLACK);
            g.drawString("S" + (i + 1), x + 10, 170);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Marks Bar Chart");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new BarChart());
            frame.setSize(330, 230);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
