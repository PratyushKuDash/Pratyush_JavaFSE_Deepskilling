import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {

    static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String getProductName() {
            return productName;
        }

        public void displayProduct() {
            System.out.println("ID: " + productId + ", Name: " + productName + ", Category: " + category);
        }
    }

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }


    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void sortProductsByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Phone", "Electronics"),
            new Product(3, "Shoes", "Fashion"),
            new Product(4, "Watch", "Fashion")
        };

        System.out.println("----- Linear Search -----");
        Product result1 = linearSearch(products, "Shoes");
        if (result1 != null) {
            System.out.print("Product found: ");
            result1.displayProduct();
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\n----- Binary Search -----");
        sortProductsByName(products);  // Sort before binary search
        Product result2 = binarySearch(products, "Watch");
        if (result2 != null) {
            System.out.print("Product found: ");
            result2.displayProduct();
        } else {
            System.out.println("Product not found.");
        }
    }
}
