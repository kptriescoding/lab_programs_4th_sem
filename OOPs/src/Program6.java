package OOPS;

import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to D Banking,Let's create account for u");
        System.out.println("What's your name");
        String name = s.nextLine();
        new Customer(name);

    }
}

class DemonitisationException extends Exception {
    long money;

    public DemonitisationException(long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("Deposit of Old currency of (Rs. %s) crosses Rs. 5,000 and cannot be Deposited", money);
    }
}

class Account {
    long money;

    Account(long money) {
        this.money = money;
    }

    void deposit(long money, String currencyType) throws DemonitisationException {
        if (currencyType.equals("OLD")) {
            if (money > 5000) {
                throw new DemonitisationException(money);
            } else {
                this.money += money;
            }
        } else {
            this.money += money;
        }
    }

    void getCurBalance() {
        System.out.println("Current balance is " + this.money);
    }

    boolean withdraw(long money) {
        if (this.money - money < 500) return false;
        this.money -= money;
        return true;
    }
}

class Customer {
    Account a;
    Scanner s = new Scanner(System.in);
    String name;

    Customer(String name) {
        this.name = name;
        System.out.println("Enter the initial money");
        long m = s.nextLong();
        while (m < 500) {
            System.out.println("Min init deposit shld be 500 try again");
            m = s.nextLong();
        }
        a = new Account(m);
        startTrans();
    }

    void startTrans() {

        System.out.println("Enter\n1:To deposit\n2:check balance\n3:To withdraw\n4:To exit");
        int c = 0;
        while (c != 4) {
            System.out.println("Enter the choice");
            c = s.nextInt();
            switch (c) {
                case (1):
                    System.out.println("Enter the money you want to deposit");
                    long m = s.nextLong();
                    System.out.println("Enter 1 if the money is off old currency else 0");
                    int isOld = s.nextInt();

                    if (isOld == 1) {
                        try {
                            a.deposit(m, "OLD");
                            System.out.println("Money deposited successfully");
                            a.getCurBalance();
                        } catch (DemonitisationException e) {
                            System.out.println("" + e);
                        }
                    } else {
                        try {
                            a.deposit(m, "NEW");
                            System.out.println("Money deposited successfully");
                            a.getCurBalance();
                        } catch (DemonitisationException ignored) {
                        }
                    }
                    break;
                case (2):
                    a.getCurBalance();
                    break;
                case (3):
                    System.out.println("Enter the money you want to withdraw");
                    m = s.nextLong();
                    boolean success = a.withdraw(m);
                    if (success) System.out.println("Money withdrawn successfully");
                    else
                        System.out.println("Unsuccessful transaction!!You will not be left with minimum balance after the witdraw");
                default:
                    break;
            }
        }
    }
}

