//experiment -2a
// File: MathUtil.java (the package member)
package com.scsvmv.util;

public class MathUtil {

    public static int square(int n) {
        return n * n;
    }

    public static int cube(int n) {
        return n * n * n;
    }
}

//experiment -2b
// File: UseMath.java (uses the package)
import com.scsvmv.util.MathUtil;

public class UseMath {
    public static void main(String[] args) {
        System.out.println("Square of 7 = " + MathUtil.square(7));
        System.out.println("Cube of 3 = " + MathUtil.cube(3));
    }
}

//experiment -case study
package com.scsvmv.fee.model;

public class Student {
    public String name;
    public String course;

    public Student(String n, String c) {
        name = n;
        course = c;
    }
}
//2. FeeRule.java
//File path: com/scsvmv/fee/service/FeeRule.java
package com.scsvmv.fee.service;

public class FeeRule {
    public static double fee(String course) {
        if (course.equals("BE")) {
            return 75000;
        }

        if (course.equals("ME")) {
            return 60000;
        }

        return 40000;
    }
}
//3. FeeApp.java
//File path: FeeApp.java (project root)
import com.scsvmv.fee.model.Student;
import com.scsvmv.fee.service.FeeRule;

public class FeeApp {
    public static void main(String[] args) {
        Student[] s = {
            new Student("Meena", "BE"),
            new Student("Ravi", "ME"),
            new Student("Anu", "BSc")
        };

        double total = 0;

        for (Student x : s) {
            double f = FeeRule.fee(x.course);

            System.out.printf(
                "%-8s %-5s %10.2f%n",
                x.name, x.course, f
            );

            total = total + f;
        }

        System.out.printf("Total fee = %.2f%n", total);
    }
}
