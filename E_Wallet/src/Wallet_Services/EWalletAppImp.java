package Wallet_Services;

import Model.EWallet;
import Model.UserAccount;

import java.util.Scanner;

public class EWalletAppImp implements EWalletApp {
    private Scanner scanner = new Scanner(System.in);
    private EWallet eWallet = new EWallet();

    @Override
    public void Run() {
        System.out.println("Welcome to our E-Wallet Application :).... ");
        while (true) {
            System.out.println("Please choose: \n1. Login \n2. Register \n3. Exit App");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Exiting the app. Thank you!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void register() {
        System.out.println("To register, please enter \nUSER NAME:");
        String name = scanner.next();
        System.out.println("PASSWORD:");
        String password = scanner.next();

        UserAccount existingAccount = eWallet.findAccountByUserName(name);
        if (existingAccount == null) {
            UserAccount newAccount = new UserAccount(name, password);
            eWallet.addAccount(newAccount);
            System.out.println("Registration completed successfully!");
        } else {
            System.out.println("This username already exists. Try a different username.");
        }
    }

    private void login() {
        System.out.print("Please Enter USER NAME: -> ");
        String name = scanner.next();

        UserAccount account = eWallet.findAccountByUserName(name);
        if (account == null) {
            System.out.println("Invalid username. Please try again.");
            return;
        } else {
            System.out.print("PASSWORD: -> ");
            String password = scanner.next();
            if (account.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + name);
                // TODO: service_Details
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        }
    }
}
