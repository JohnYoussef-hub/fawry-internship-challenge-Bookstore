class DemoBook extends Book {
    public DemoBook(String ISBN, String title, int publicationYear, double price) {
        super(ISBN, title, publicationYear, price);
    }

    @Override
    double BuyBook(int quantity, String email, String address, UserAccount account) {
        System.out.println("Error: Demo book '" + getTitle() + "' is not for sale.");
        return 0.0;
    }
}