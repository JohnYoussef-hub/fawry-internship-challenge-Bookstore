class EBook extends Book {
    private String fileType;

    public EBook(String ISBN, String title, int publicationYear, double price, String fileType) {
        super(ISBN, title, publicationYear, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    double BuyBook(int quantity, String email, String address, UserAccount account) {
        if (quantity > 1) {
            System.out.println("Only one EBook allowed per purchase.");
            quantity = 1;
        }
        double total = getPrice();
        account.deductBalance(total);
        MailService.send(email);
        System.out.println("EBook sent: " + getTitle() + " to " + email);
        return total;
    }
}