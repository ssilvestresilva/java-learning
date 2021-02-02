package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class App {

    public static void main(String [] args) {

        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // Upcasting example
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // Downcasting examples
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

        // Error because acc3 is SavingsAccount and will throw cast exception
        // BusinessAccount acc5 = (BusinessAccount) acc3;

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

        // Superposition examples
        // For acc6 we expect 795.0 because of the tax of 5.0
        Account acc6 = new Account(1006, "Marley", 1000.0);
        acc6.withdraw(200.0);
        System.out.println(acc6.getBalance());

        // For acc7 we except 800.0 because of the Superposition of the method withdraw without the 5.0 tax
        Account acc7 = new SavingsAccount(1007, "Joseph", 1000.0, 0.01);
        acc7.withdraw(200.0);
        System.out.println(acc7.getBalance());

        // For acc8 we except 793.0 because of the tax of the superclass and the businessAccount Superposition of the method withdraw
        Account acc8 = new BusinessAccount(1008, "Ana", 1000.0, 500.0);
        acc8.withdraw(200.0);
        System.out.println(acc8.getBalance());
    }
}
