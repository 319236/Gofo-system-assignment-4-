package gofo.system.playground;

import java.util.Scanner;

/**
 *
 * @author ASD
 */
public class eWalletClass {

    Scanner scanner = new Scanner(System.in);
    private double currentBalance;

    /**
     *
     */
    public eWalletClass() {
        currentBalance = 0;
    }

    /**
     *
     * @param Amount
     * @return
     */
    public boolean depositMoney(double Amount) {
        if (Amount <= 0) {
            return false;
        }
        currentBalance += Amount;
        return true;
    }

    /**
     *
     * @param Amount
     * @return
     */
    public boolean withdrawMoney(double Amount) {
        if (Amount > currentBalance || Amount <= 0) {
            return false;
        }
        currentBalance -= Amount;
        return true;
    }

    /**
     *
     * @param Amount
     * @param user
     * @return
     */
    public boolean transferMoney(double Amount, UserClass user) {
        if (Amount > currentBalance || Amount <= 0) {
            return false;
        }
        user.getEwallet().depositMoney(Amount);
        currentBalance -= Amount;
        return true;
    }

    /**
     *
     * @return
     */
    public double getBalance() {
        return currentBalance;
    }

    /**
     *
     */
    public void eWalletMenu() {
        String Choice = "";
        double amount;

        System.out.println("Enter your choice");
        while (true) {
            System.out.println("\n1- View your Balance"
                    + "\n2- DepositMoney"
                    + "\n3- WithdrawMoney"
                    + "\n4- Exit");
            Choice = scanner.nextLine();
            if (Choice.equalsIgnoreCase("1")) {
                getBalance();
            } else if (Choice.equalsIgnoreCase("2")) {
                System.out.println("Enter amount you want to deposit");
                amount = scanner.nextDouble();
                depositMoney(amount);
            } else if (Choice.equalsIgnoreCase("3")) {
                System.out.println("Enter amount you want to withdraw");
                amount = scanner.nextDouble();
                withdrawMoney(amount);
            } else if (Choice.equalsIgnoreCase("4")) {
                break;
            } else {
                System.out.println("Plz Enter valid option\n");
            }
        }
        System.out.println("\n Now Exiting ...");
    }

}
