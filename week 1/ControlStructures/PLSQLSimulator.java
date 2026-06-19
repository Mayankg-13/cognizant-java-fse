import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PLSQLSimulator {

    static class Customer {
        int customerId;
        String name;
        LocalDate dob;
        double balance;
        String isVip;

        Customer(int customerId, String name, String dobStr, double balance, String isVip) {
            this.customerId = customerId;
            this.name = name;
            this.dob = LocalDate.parse(dobStr);
            this.balance = balance;
            this.isVip = isVip;
        }

        int getAge(LocalDate now) {
            return now.getYear() - dob.getYear() - (now.getDayOfYear() < dob.getDayOfYear() ? 1 : 0);
        }
    }

    static class Loan {
        int loanId;
        int customerId;
        double loanAmount;
        double interestRate;
        LocalDate dueDate;

        Loan(int loanId, int customerId, double loanAmount, double interestRate, int dueDaysFromNow, LocalDate now) {
            this.loanId = loanId;
            this.customerId = customerId;
            this.loanAmount = loanAmount;
            this.interestRate = interestRate;
            this.dueDate = now.plusDays(dueDaysFromNow);
        }
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Seed data
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John Doe", "1955-05-12", 5000.0, "FALSE"));
        customers.add(new Customer(2, "Jane Smith", "1985-08-20", 12000.0, "FALSE"));
        customers.add(new Customer(3, "Bob Johnson", "1945-11-30", 15000.0, "FALSE"));

        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan(101, 1, 50000.0, 8.5, 15, now));
        loans.add(new Loan(102, 2, 20000.0, 6.0, 45, now));
        loans.add(new Loan(103, 3, 30000.0, 7.5, 10, now));

        System.out.println("====================================================");
        System.out.println("       PL/SQL CONTROL STRUCTURES SIMULATOR          ");
        System.out.println("====================================================");
        System.out.println("\n--- [INIT] Database Tables Initialized ---");
        printTables(customers, loans, dtf);

        // Scenario 1: Apply 1% discount to loan interest rates for customers above 60 years old.
        System.out.println("\n--- [RUN] Scenario 1: Applying 1% discount for age > 60 ---");
        System.out.println("Executing Scenario1.sql...");
        int count1 = 0;
        for (Customer c : customers) {
            int age = c.getAge(now);
            if (age > 60) {
                for (Loan l : loans) {
                    if (l.customerId == c.customerId) {
                        l.interestRate -= 1.0;
                        count1++;
                        System.out.printf("  > Customer %s (Age %d): Updated Loan %d Interest Rate to %.1f%%\n",
                                c.name, age, l.loanId, l.interestRate);
                    }
                }
            }
        }
        System.out.printf("PL/SQL block execution complete. %d rows updated.\n", count1);

        // Scenario 2: Promoted to VIP status based on balance > 10,000.
        System.out.println("\n--- [RUN] Scenario 2: Promoting to VIP for balance > $10,000 ---");
        System.out.println("Executing Scenario2.sql...");
        int count2 = 0;
        for (Customer c : customers) {
            if (c.balance > 10000) {
                c.isVip = "TRUE";
                count2++;
                System.out.printf("  > Customer %s (Balance $%.2f): Promoted to VIP\n", c.name, c.balance);
            }
        }
        System.out.printf("PL/SQL block execution complete. %d rows updated.\n", count2);

        // Print tables after updates
        System.out.println("\n--- [DATABASE STATE] After Scenario 1 & 2 Execution ---");
        printTables(customers, loans, dtf);

        // Scenario 3: Send reminders for loans due within the next 30 days.
        System.out.println("\n--- [RUN] Scenario 3: Generating Loan Due Reminders (Next 30 Days) ---");
        System.out.println("SQL> SET SERVEROUTPUT ON;");
        System.out.println("SQL> @Scenario3.sql");
        for (Loan l : loans) {
            long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(now, l.dueDate);
            if (daysBetween >= 0 && daysBetween <= 30) {
                String customerName = "Unknown";
                for (Customer c : customers) {
                    if (c.customerId == l.customerId) {
                        customerName = c.name;
                        break;
                    }
                }
                System.out.printf("Reminder: Customer %s has loan %d due on %s.\n",
                        customerName, l.loanId, l.dueDate.format(dtf));
            }
        }
        System.out.println("\nPL/SQL procedure successfully completed.");
        System.out.println("====================================================");
    }

    private static void printTables(List<Customer> customers, List<Loan> loans, DateTimeFormatter dtf) {
        System.out.println("\nCUSTOMERS TABLE:");
        System.out.println("+------------+--------------+------------+------------+-------+");
        System.out.println("| CustomerID | Name         | DOB        | Balance    | IsVIP |");
        System.out.println("+------------+--------------+------------+------------+-------+");
        for (Customer c : customers) {
            System.out.printf("| %-10d | %-12s | %-10s | %-10.2f | %-5s |\n",
                    c.customerId, c.name, c.dob.format(dtf), c.balance, c.isVip);
        }
        System.out.println("+------------+--------------+------------+------------+-------+");

        System.out.println("\nLOANS TABLE:");
        System.out.println("+--------+------------+------------+--------------+------------+");
        System.out.println("| LoanID | CustomerID | LoanAmount | InterestRate | DueDate    |");
        System.out.println("+--------+------------+------------+--------------+------------+");
        for (Loan l : loans) {
            System.out.printf("| %-6d | %-10d | %-10.2f | %-12.2f | %-10s |\n",
                    l.loanId, l.customerId, l.loanAmount, l.interestRate, l.dueDate.format(dtf));
        }
        System.out.println("+--------+------------+------------+--------------+------------+");
    }
}
