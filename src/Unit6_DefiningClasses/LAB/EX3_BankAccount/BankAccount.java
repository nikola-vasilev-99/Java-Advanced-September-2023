package Unit6_DefiningClasses.LAB.EX3_BankAccount;

public class BankAccount {
    //static - принадлежи на конкредтния клас - BankAccount
    private static double interestRate = 0.02;
    private static int idCounter = 1;
    private int id;
    private double balance;

    // конструктор
    public BankAccount () {
        this.id = idCounter;
        idCounter++;
    }
    //getter
    public double getInterest(int years) {
        return interestRate * years * balance;
    }
    //метод, който ще добавя пари към депозита - void, защото извършва действие, без да връща стойност
    public void deposit (double amount) {
        balance += amount;
    }
    //setter
    public static void setInterestRate (double interestRate) {
        //достъпваме го чрез името на класа, защото е статичен метод
        BankAccount.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

}
