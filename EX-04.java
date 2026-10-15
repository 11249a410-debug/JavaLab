// Ex 4: multilevel inheritance, super and overriding
class Person {
    String name;

    Person(String n) {
        name = n;
    }

    void show() {
        System.out.println("Name : " + name);
    }
}

class Employee extends Person {
    double salary;

    Employee(String n, double s) {
        super(n);
        salary = s;
    }

    @Override
    void show() {
        super.show();
        System.out.println("Salary : " + salary);
    }
}

class Manager extends Employee {
    String dept;

    Manager(String n, double s, String d) {
        super(n, s);
        dept = d;
    }

    @Override
    void show() {
        super.show();
        System.out.println("Dept : " + dept);
    }
}

public class InheritDemo {
    public static void main(String[] args) {
        Person p = new Manager("Meena", 75000, "CSE");
        p.show();
    }
}

// Ex 4: one parent, three children, one array
class Staff {
    String name;

    Staff(String n) {
        name = n;
    }

    String role() {
        return "Staff";
    }
}

class Teacher extends Staff {
    Teacher(String n) {
        super(n);
    }

    @Override
    String role() {
        return "Teacher";
    }
}

class Driver extends Staff {
    Driver(String n) {
        super(n);
    }

    @Override
    String role() {
        return "Driver";
    }
}

public class RoleDemo {
    public static void main(String[] args) {
        Staff[] all = {
            new Teacher("Kumar"),
            new Driver("Selvam"),
            new Staff("Raj")
        };

        for (Staff s : all) {
            System.out.println(s.name + " -> " + s.role());
        }
    }
}

//case study
abstract class Emp {
    String name;
    double basic;

    Emp(String n, double b) {
        name = n;
        basic = b;
    }

    abstract double pay();
}

class Manager extends Emp {
    Manager(String n, double b) {
        super(n, b);
    }

    @Override
    double pay() {
        return basic + 0.40 * basic;
    }
}

class Engineer extends Emp {
    Engineer(String n, double b) {
        super(n, b);
    }

    @Override
    double pay() {
        return basic + 0.20 * basic;
    }
}

class Intern extends Emp {
    Intern(String n, double b) {
        super(n, b);
    }

    @Override
    double pay() {
        return basic;
    }
}

public class SalarySlip {
    public static void main(String[] args) {
        Emp[] e = {
            new Manager("Meena", 50000),
            new Engineer("Ravi", 40000),
            new Intern("Anu", 12000)
        };

        System.out.println("NAME          SALARY");

        for (Emp x : e) {
            System.out.printf("%-8s %10.2f%n", x.name, x.pay());
        }
    }
}
