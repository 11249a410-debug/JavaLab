// Ex 9(a): BorderLayout - five regions
import javax.swing.*;
import java.awt.*;

public class BorderDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("BorderLayout");

            f.setLayout(new BorderLayout());

            f.add(new JButton("NORTH"), BorderLayout.NORTH);
            f.add(new JButton("SOUTH"), BorderLayout.SOUTH);
            f.add(new JButton("EAST"), BorderLayout.EAST);
            f.add(new JButton("WEST"), BorderLayout.WEST);
            f.add(new JButton("CENTER"), BorderLayout.CENTER);

            f.setSize(350, 220);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}

// Ex 9(A): GridLayout - a 4 x 3 keypad, all boxes equal
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GridDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("GridLayout 4 x 3");

            f.setLayout(new GridLayout(4, 3, 5, 5));

            String[] keys = {
                "1", "2", "3",
                "4", "5", "6",
                "7", "8", "9",
                "*", "0", "#"
            };

            for (String k : keys) {
                f.add(new JButton(k));
            }

            f.setSize(260, 300);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}

// Ex 9(A): FlowLayout - a row that wraps

import javax.swing.*;
import java.awt.*;

public class FlowDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("FlowLayout");

        f.setLayout(new FlowLayout());

        String[] b = {"New", "Open", "Save", "Print", "Exit"};

        for (String s : b) {
            f.add(new JButton(s));
        }

        f.setSize(300, 120);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}



// Ex 9(b): swing controls with an event listener

import javax.swing.*;
import java.awt.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login");
        f.setLayout(new FlowLayout());

        JTextField user = new JTextField(12);
        JPasswordField pass = new JPasswordField(12);

        JButton ok = new JButton("Login");
        JLabel msg = new JLabel(" ");

        f.add(new JLabel("User Name"));
        f.add(user);
        f.add(new JLabel("Password"));
        f.add(pass);
        f.add(ok);
        f.add(msg);

        ok.addActionListener(e -> {
            String pwd = new String(pass.getPassword());

            if (user.getText().equals("cse") &&
                pwd.equals("java")) {
                msg.setText("Login successful");
            } else {
                msg.setText("Invalid user or password");
            }
        });

        f.setSize(260, 180);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


//CASE STUDY:

import javax.swing.*;
import java.awt.*;

public class RegisterForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Student Registration");
        f.setLayout(new FlowLayout());

        JTextField name = new JTextField(14);

        JComboBox<String> br = new JComboBox<>(
            new String[]{"CSE", "IT", "ECE"}
        );

        JRadioButton m = new JRadioButton("Male", true);
        JRadioButton fe = new JRadioButton("Female");

        ButtonGroup g = new ButtonGroup();
        g.add(m);
        g.add(fe);

        JButton sub = new JButton("Submit");
        JLabel out = new JLabel(" ");

        f.add(new JLabel("Name"));
        f.add(name);
        f.add(new JLabel("Branch"));
        f.add(br);
        f.add(m);
        f.add(fe);
        f.add(sub);
        f.add(out);

        sub.addActionListener(e -> {
            if (name.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    f, "Name cannot be empty"
                );
            } else {
                out.setText(
                    name.getText().trim() + " | "
                    + br.getSelectedItem() + " | "
                    + (m.isSelected() ? "Male" : "Female")
                );
            }
        });

        f.setSize(300, 220);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

