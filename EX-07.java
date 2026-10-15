// Ex 7: writing to a text file
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("student.txt")) {
            fw.write("101,Aravind,78\n");
            fw.write("102,Divya,91\n");
            fw.write("103,Karthik,45\n");

            System.out.println("File written successfully.");

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}

// Ex 7: reading the same file back and processing it
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try (BufferedReader br =
                 new BufferedReader(new FileReader("student.txt"))) {

            String line;

            System.out.println("ROLL  NAME      MARKS");

            while ((line = br.readLine()) != null) {
                String[] f = line.split(",");

                if (f.length == 3) {
                    System.out.printf(
                        "%-6s %-10s %s%n",
                        f[0], f[1], f[2]
                    );
                } else {
                    System.out.println("Invalid record: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}

// Case Study 7: read a file, process it, write a report
import java.io.*;

public class ResultReport {
    public static void main(String[] args) {
        int pass = 0;
        int fail = 0;
        int total = 0;
        int n = 0;

        try (
            BufferedReader br = new BufferedReader(
                new FileReader("student.txt")
            );
            PrintWriter pw = new PrintWriter("result.txt")
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] f = line.split(",");

                if (f.length != 3) {
                    System.out.println("Invalid record: " + line);
                    continue;
                }

                int m;

                try {
                    m = Integer.parseInt(f[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid marks: " + line);
                    continue;
                }

                total += m;
                n++;

                if (m >= 50) {
                    pass++;
                    pw.println(f[1] + " PASS");
                } else {
                    fail++;
                    pw.println(f[1] + " FAIL");
                }
            }

            pw.println("Passed : " + pass);
            pw.println("Failed : " + fail);

            if (n > 0) {
                pw.printf("Average : %.2f%n", (double) total / n);
            } else {
                pw.println("Average : 0.00");
            }

            System.out.println(
                "result.txt created. Passed " + pass + ", failed " + fail
            );

        } catch (IOException e) {
            System.out.println("File error : " + e.getMessage());
        }
    }
}
