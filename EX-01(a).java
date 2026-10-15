// Ex 1(a): class, object and methods
class Student {
    int roll;
    String name;
    int marks;

    void set(int r, String n, int m) {
        roll = r;
        name = n;
        marks = m;
    }

    void show() {
        System.out.println(roll + " " + name + " " + marks);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        s1.set(101, "Aravind", 78);
        s2.set(102, "Divya", 91);

        System.out.println("ROLL NAME MARKS");
        s1.show();
        s2.show();
    }
}

// Ex 1(b): array + for loop + if-else + operators
public class MarksArray {
    public static void main(String[] args) {
        int[] m = {78, 91, 45, 66, 88};
        int total = 0;

        for (int i = 0; i < m.length; i++) {
            total = total + m[i];

            if (m[i] >= 50) {
                System.out.println(m[i] + " Pass");
            } else {
                System.out.println(m[i] + " Fail");
            }
        }

        double avg = total / (double) m.length;

        System.out.println("Total = " + total);
        System.out.println("Average = " + avg);
    }
}

// Ex 1(c): common String methods
public class StringDemo {
    public static void main(String[] args) {
        String s = "SCSVMV University";

        System.out.println("Length : " + s.length());
        System.out.println("Upper case : " + s.toUpperCase());
        System.out.println("First six : " + s.substring(0, 6));
        System.out.println("Position of U: " + s.indexOf('U'));
        System.out.println("Replace S->X: " + s.replace('S', 'X'));
        System.out.println("Original : " + s);

        String a = "madam";
        String b = new StringBuilder(a).reverse().toString();

        if (a.equals(b)) {
            System.out.println(a + " is a palindrome");
        } else {
            System.out.println(a + " is not a palindrome");
        }
    }
}

class Boarder {
    String name;
    int days;

    Boarder(String n, int d) {
        name = n;
        days = d;
    }

    double bill() {
        return days * 85.0;
    }
}

public class MessBill {
    public static void main(String[] args) {
        Boarder[] list = {
            new Boarder("Aravind", 28),
            new Boarder("Divya", 30),
            new Boarder("Karthik", 25)
        };

        double total = 0;

        System.out.println("NAME       DAYS     BILL");

        for (Boarder b : list) {
            System.out.printf(
                "%-10s %4d %8.2f%n",
                b.name, b.days, b.bill()
            );

            total = total + b.bill();
        }

        System.out.printf(
            "Total collection = Rs. %.2f%n",
            total
        );
    }
}
