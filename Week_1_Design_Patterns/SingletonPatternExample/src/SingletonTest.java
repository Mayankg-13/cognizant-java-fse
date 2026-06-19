public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   Testing Singleton Pattern (Logger Implementation) ");
        System.out.println("=================================================");

        Logger logger1 = Logger.getInstance();
        System.out.println("Logger 1 reference obtained.");

        Logger logger2 = Logger.getInstance();
        System.out.println("Logger 2 reference obtained.");

        System.out.println("\nLogger 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger 2 HashCode: " + logger2.hashCode());

        System.out.print("Verifying if both references are identical: ");
        if (logger1 == logger2) {
            System.out.println("SUCCESS (Same memory instance)\n");
        } else {
            System.out.println("FAILURE (Different instances created)\n");
        }

        System.out.println("--- Testing Logging Functionality ---");
        logger1.log("Application started successfully.");
        logger2.log("Performing system configuration check...");
        logger1.log("All systems are nominal.");
        System.out.println("-------------------------------------");
    }
}
