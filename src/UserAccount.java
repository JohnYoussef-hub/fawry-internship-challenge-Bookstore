class UserAccount {
    private String name;
    private double balance;
    private String email;
    private String address;

    public UserAccount(String name, double initialBalance, String email, String address) {
        this.name = name;
        this.balance = initialBalance;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void deductBalance(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance to deduct " + amount);
        }
    }

    public void displayAccountInfo() {
        System.out.println("User Account Info:");
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }
}