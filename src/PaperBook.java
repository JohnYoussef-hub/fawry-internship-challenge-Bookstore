class PaperBook extends Book {
    private int stock;
    private boolean shippable;

    public PaperBook(String ISBN, String title, int publicationYear, double price, int stock, boolean shippable) {
        super(ISBN, title, publicationYear, price);
        if(stock < 0){
            System.out.println("Stock cannot be negative. Setting stock to 0.");
            this.stock = 0;
        } else this.stock = stock;
        this.shippable = shippable;
    }

    public int getStock() {
        return stock;
    }
    public boolean isShippable() {
        return shippable;
    }

    public void reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient stock to reduce by " + quantity);
        }
    }

    @Override
    double BuyBook(int quantity, String email, String address, UserAccount account) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Not enough stock for book: " + getTitle());
        }

        if (!shippable) {
            throw new IllegalArgumentException("This paper book is not shippable.");
        }

        double total = getPrice() * quantity;
        account.deductBalance(total);
        reduceStock(quantity);
        ShippingService.send(address);
        System.out.println("Paper book bought: " + getTitle() + ", Quantity: " + quantity);
        return total;
    }
}