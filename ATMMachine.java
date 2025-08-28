
    import java.util.*;

    interface ATMOperations {
        void viewBalance();
        void deposit(double amount);
        void withdraw(double amount);
        void exit();
    }

    class User{
        private String accountNumber;
        private String pin;
        private double balance;
      //constructor
        public User(String accountNumber, String pin, double balance) {
            this.accountNumber = accountNumber;
            this.pin = pin;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getPin() {
            return pin;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }

    class ATMOperationsImpl implements ATMOperations {
        private User user;

        public ATMOperationsImpl(User user) {
            this.user = user;
        }

        @Override
        public void viewBalance() {
            System.out.println("Your Balance: ₹" + user.getBalance());
        }

        @Override
        public void deposit(double amount) {
            if (amount > 0) {
                user.setBalance(user.getBalance() + amount);
                System.out.println("₹" + amount + " deposited successfully.");
                viewBalance();
            } else {
                System.out.println("Invalid deposit amount!");
            }
        }

        @Override
        public void withdraw(double amount) {
            if (amount > 0 && amount <= user.getBalance()) {
                user.setBalance(user.getBalance() - amount);
                System.out.println("₹" + amount + " withdrawn successfully.");
                viewBalance();
            } else {
                System.out.println("Insufficient balance or invalid amount!");
            }
        }

        @Override
        public void exit() {
            System.out.println("Thank you for using the ATM. Goodbye!");
        }
    }

         public class ATM {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Predefined User
            User user = new User("12345678", "1234", 10000.0);

            System.out.println("......... Welcome to ATM ......... G");
            System.out.print("Enter Account Number: ");
            String accNumber = sc.nextLine();

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();

            if (accNumber.equals(user.getAccountNumber()) && pin.equals(user.getPin())) {
                ATMOperations operations = new ATMOperationsImpl(user);

                while (true) {
                    System.out.println("\nChoose an option:");
                    System.out.println("1. View Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Exit");
                    System.out.print("Enter choice: ");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            operations.viewBalance();
                            break;
                        case 2:
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = sc.nextDouble();
                            operations.deposit(depositAmount);
                            break;
                        case 3:
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = sc.nextDouble();
                            operations.withdraw(withdrawAmount);
                            break;
                        case 4:
                            operations.exit();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                }
            } else {
                System.out.println("Invalid Account Number or PIN!");
            }

            sc.close();
        }
    }



