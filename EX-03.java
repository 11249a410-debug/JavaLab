// Ex 3(a): user-defined interface and two implementations
interface Shape {
    double area();
}

class Circle implements Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return 3.14159 * r * r;
    }
}

class Rect implements Shape {
    double l, b;

    Rect(double l, double b) {
        this.l = l;
        this.b = b;
    }

    @Override
    public double area() {
        return l * b;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] s = {
            new Circle(5),
            new Rect(4, 6)
        };

        for (Shape x : s) {
            System.out.printf(
                "%-8s area = %.2f%n",
                x.getClass().getSimpleName(),
                x.area()
            );
        }
    }
}

// Ex 3(b): using the predefined interface Comparable
import java.util.Arrays;

class Player implements Comparable<Player> {
    String name;
    int runs;

    Player(String n, int r) {
        name = n;
        runs = r;
    }

    @Override
    public int compareTo(Player p) {
        return Integer.compare(p.runs, this.runs); // High to low
    }

    @Override
    public String toString() {
        return name + "(" + runs + ")";
    }
}

// Case Study 3: one interface, three payment methods
interface Payment {
    double charge(double amount);
    String name();
}

class Upi implements Payment {
    @Override
    public double charge(double a) {
        return 0;
    }

    @Override
    public String name() {
        return "UPI";
    }
}

class Card implements Payment {
    @Override
    public double charge(double a) {
        return a * 0.02;
    }

    @Override
    public String name() {
        return "Card";
    }
}

class Cash implements Payment {
    @Override
    public double charge(double a) {
        return 20;
    }

    @Override
    public String name() {
        return "Cash";
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        double fee = 75000;

        Payment[] modes = {
            new Upi(),
            new Card(),
            new Cash()
        };

        for (Payment m : modes) {
            double charge = m.charge(fee);

            System.out.printf(
                "%-5s charge %8.2f total %10.2f%n",
                m.name(),
                charge,
                fee + charge
            );
        }
    }
}
