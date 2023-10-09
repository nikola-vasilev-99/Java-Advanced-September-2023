package Unit6_DefiningClasses.LAB.EX3_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        HashMap<Integer, BankAccount> bank = new HashMap<>();
        while (!line.equals("End")) {
            String[] tokens = line.split(" ");
            String command = tokens[0];

            if (command.equals("Create")) {
                BankAccount account = new BankAccount();
                bank.put(account.getId(), account);
                System.out.println("Account ID" + account.getId() + " created");
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);
                BankAccount account = bank.get(id);
                if (account != null) {
                    account.deposit(amount);
                    System.out.println("Deposited " + amount + " to ID" + id);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command.equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
            } else {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);
                if (!checkAccountsExists(bank, id)) {
                    return;
                }
                BankAccount account = bank.get(id);
                System.out.printf("%.2f%n", account.getInterest(years) );
            }
            line = scanner.nextLine();
        }
    }
    public static boolean checkAccountsExists(Map<Integer, BankAccount> bank,int id) {
        if (!bank.containsKey(id)) {
            System.out.println("Account does not exist");
            return false;
        }
        return true;
    }
}
