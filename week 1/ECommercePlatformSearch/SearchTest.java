import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P103", "Laptop", "Electronics"),
            new Product("P101", "Smartphone", "Electronics"),
            new Product("P105", "Headphones", "Electronics"),
            new Product("P102", "Desk Chair", "Furniture"),
            new Product("P104", "Coffee Maker", "Appliances")
        };

        System.out.println("=================================================");
        System.out.println("   Testing Linear Search ");
        System.out.println("=================================================");
        String targetId = "P104";
        Product resultLinear = SearchAlgorithms.linearSearch(products, targetId);
        System.out.println("Searching for: " + targetId);
        if (resultLinear != null) {
            System.out.println("Found: " + resultLinear);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println();

        System.out.println("=================================================");
        System.out.println("   Testing Binary Search (Requires Sorted Array) ");
        System.out.println("=================================================");
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));
        System.out.println("Sorted products for binary search:");
        for (Product p : products) {
            System.out.println("  " + p);
        }
        System.out.println();

        Product resultBinary = SearchAlgorithms.binarySearch(products, targetId);
        System.out.println("Searching for: " + targetId);
        if (resultBinary != null) {
            System.out.println("Found: " + resultBinary);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("=================================================");
    }
}
