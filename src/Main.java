public class Main {
    public static void main(String[] args) {
        // Initialize inventory and user account
        Inventory inventory = new Inventory();
        UserAccount user = new UserAccount("John Youssef", 100.0, "john@fawry.com", "123 Main St");

        // Test 1: Add books to inventory
        System.out.println("=== Adding Books ===");
        inventory.addBook(new PaperBook("123", "Java Programming", 2020, 25.0, 5, true));
        inventory.addBook(new EBook("456", "Python Guide", 2021, 15.0, "PDF"));
        inventory.addBook(new DemoBook("789", "Demo Book", 2018, 0.0));
        inventory.addBook(new PaperBook("101", "Old Novel", 2015, 10.0, 3, true));

        // Display initial inventory
        System.out.println("\n=== Initial Inventory ===");
        inventory.displayBooks();

        // Test 2: Buy books
        System.out.println("\n=== Buying Books ===");
        try {
            // Buy 2 paper books (valid)
            double cost = inventory.buyBook("123", 2, user.getEmail(), user.getAddress(), user);
            System.out.println("Paid: $" + cost);

            // Buy eBook with quantity 2 (should limit to 1)
            cost = inventory.buyBook("456", 2, user.getEmail(), user.getAddress(), user);
            System.out.println("Paid: $" + cost);

            // Try to buy demo book (should fail)
            cost = inventory.buyBook("789", 1, user.getEmail(), user.getAddress(), user);
            System.out.println("Paid: $" + cost);

            // Try to buy more paper books than in stock (should fail)
            cost = inventory.buyBook("123", 4, user.getEmail(), user.getAddress(), user);
            System.out.println("Paid: $" + cost);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUser balance after purchases: $" + user.getBalance());

        // Try to buy with insufficient balance
        System.out.println("\n=== Buying with Insufficient Balance ===");
        try {
            // Try to buy paper book with high cost
            double cost = inventory.buyBook("123", 3, user.getEmail(), user.getAddress(), user);
            System.out.println("Paid: $" + cost);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Try to buy non-existent book
        System.out.println("\n=== Buying Non-Existent Book ===");
        try {
            double cost = inventory.buyBook("999", 1, user.getEmail(), user.getAddress(), user);
            System.out.println("Paid: $" + cost);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display user account info
        System.out.println("\n=== User Account Info ===");
        user.displayAccountInfo();

        // Display inventory after purchases
        System.out.println("\n=== Inventory After Purchases ===");
        inventory.displayBooks();

        // Test 3: Remove outdated books (older than 5 years, i.e., published before 2020)
        System.out.println("\n=== Removing Outdated Books (Older than 5 Years) ===");
        inventory.removeBook(5);

        // Display final inventory
        System.out.println("\n=== Final Inventory ===");
        inventory.displayBooks();
    }
}