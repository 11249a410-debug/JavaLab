// Ex 6(a): catching the three most common exceptions
public class PredefinedDemo {
    public static void main(String[] args) {

        // Example 1: ArrayIndexOutOfBoundsException
        try {
            int[] a = new int[3];
            a[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array error : index " + e.getMessage());
        }

        // Example 2: ArithmeticException
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Math error : " + e.getMessage());
        }

        // Example 3: NullPointerException
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Null error : the object was never created");
        } finally {
            System.out.println("finally : always runs");
        }

        System.out.println("Program continued normally.");
    }
}

// Ex 6(b): our own exception class

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

public class UserDefinedDemo {

    static void verify(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is below 18");
        }

        System.out.println("Age " + age + " accepted");
    }

    public static void main(String[] args) {
        try {
            verify(21);
            verify(15);
        } catch (InvalidAgeException e) {
            System.out.println("Rejected : " + e.getMessage());
        }
    }
}

// Case Study 6: two user-defined exceptions
class InvalidAmountException extends Exception {
    InvalidAmountException(String m) {
        super(m);
    }
}

class LowBalanceException extends Exception {
    LowBalanceException(String m) {
        super(m);
    }
}

public class Atm {
    static double balance = 5000;

    static void withdraw(double amt)
            throws InvalidAmountException, LowBalanceException {

        if (amt % 100 != 0) {
            throw new InvalidAmountException(
                amt + " is not a multiple of 100"
            );
        }

        if (amt > balance) {
            throw new LowBalanceException(
                "Balance is only " + balance
            );
        }

        balance = balance - amt;

        System.out.println(
            "Dispensed " + amt + ", balance " + balance
        );
    }

    public static void main(String[] args) {
        double[] tries = {2000, 350, 9000, 1500};

        for (double a : tries) {
            try {
                withdraw(a);
            } catch (InvalidAmountException | LowBalanceException e) {
                System.out.println("Refused : " + e.getMessage());
            }
        }
    }
}
