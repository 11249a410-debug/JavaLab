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
