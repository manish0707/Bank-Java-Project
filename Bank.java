import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// main account class
class Account
{
    Scanner scr = new Scanner(System.in);
    private String name;

    private int accountNumber; 

    private String accountType;

    protected double accountBalance;

    public void setName()
    {
        System.out.print("Enter your name :");
        this.name = scr.nextLine();
    }
    public String getName()
    {
        return this.name;
    }
    public void setAccountNumber()
    {
        System.out.print("Enter the Account Number : ");
        this.accountNumber = scr.nextInt();
    }

    public int getAccountNumber()
    {
        System.out.println("Your account balance is : " + this.accountBalance);
        System.out.println("\n");
        return accountNumber;
    }

    public int setAccountType()
    {
        System.out.println("Choose Account Type :-");
        System.out.println("1. Current Account ");
        System.out.println("2. Saving Account ");
        System.out.println("\n");
        System.out.print("Enter your choice : ");
        int choice = scr.nextInt();
        if(choice == 1)
        {
            this.accountType = "Current";
            return 1;
        }
        else if(choice == 2)
        {
            this.accountType = "Saving";
            return 2;
        }
        else
        {
            System.out.println("Not a valid entry !!");
            System.out.println("\n");
            return 0;
        }
    }

    public void depositeAmount()
    {
        System.out.print("Enter the amount : ");
        double accountBalance = scr.nextDouble();
        this.accountBalance = this.accountBalance + accountBalance;
        System.out.println("Amount has been deposited successfully!!");
        System.out.println("\n");
        
    }
    public double getAccountBalance()
    {
        //TO know the account balance 

        System.out.println("Your account balance is : "+ this.accountBalance);
        System.out.println("\n");
        return accountBalance;
    }

    public void showProfile()
    {
        System.out.println("\n");
        System.out.println("Your Personal details are :-\n");
        System.out.println("Name  : " + this.name + "\n");
        System.out.println("Account Number  : " + this.accountNumber + "\n");
        System.out.println("Your Account Balanace is  : " + this.accountBalance + "\n");
    }
}

class CurrentAccount extends Account
{
    private double minimumBalance = 1000.0;

    private boolean checkBook = false;

    public boolean checkBookStatus()
    {
        if(checkBook == true)
        {
            System.out.println("Cheque book has been issued !!");  
            System.out.println("\n");
            return true;
        }
        else
        {
            System.out.println("Cheque book has not been issued !!");
            System.out.println("\n");
            return false;
        }   
    }

    public void issueCheckBook()
    {
        checkBook = true;
        System.out.println("Cheque Book issued successfully !!");
        System.out.println("\n");
    }

    public int checkPenality()
    {
        if(super.accountBalance<= this.minimumBalance)
        {
            return 100;
        }
        else
        {
            return 0;
        }
    }
}

class SavingAccount extends Account
{
    public double withdrawlMoney()
    {
        if(accountBalance<=0)
        {
            System.out.println("\nDo not have sufficient Balance!\n");
        }
        else
        {
            System.out.print("Enter the amount to withdrawl : ");
            double withdrawlAmount = scr.nextDouble();
            accountBalance = accountBalance - withdrawlAmount;
            System.out.println("Rs."+ withdrawlAmount + " has been debited !!");
            System.out.println("\n");
        }
        return accountBalance;
    }

    private double roi = 5.0f;
    public void calculateRoi()
    {
        double temp = (accountBalance * roi)/100;
        System.out.println("The ROI of this month is : " + temp);
        System.out.println("\n");
    }
}

public class Bank
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*made object of account class just to call setAccount type method */
        Account a1 = new Account();
        int choice = a1.setAccountType();
        if(choice == 1)
        {
            /*Object for current account  */
            CurrentAccount c1 = new CurrentAccount();
            c1.setName();
            c1.setAccountNumber();
            System.out.println("Thank you so much for the details !!");
            System.out.println("\n");
            //infinite loop for the 
            while(true)
            {
                System.out.println("Choose the following options : ");
                System.out.println("1. Deposite Money");
                System.out.println("2. Check Balance");
                System.out.println("3. Show ChequeBook Status");
                System.out.println("4. Issue a chequeBook");
                System.out.println("5. Show My Profile");
                System.out.println("6. Exit");
                System.out.println("\n");
                System.out.print("Please Enter your Choice : ");
                int userChoice = Integer.parseInt(br.readLine());
                switch(userChoice)
                {
                    case 1:
                    c1.depositeAmount();
                    break;
                    case 2:
                    c1.getAccountBalance();
                    break;
                    case 3:
                    c1.checkBookStatus();
                    break;
                    case 4:
                    c1.issueCheckBook();
                    break;
                    case 5:
                    c1.showProfile();
                    break;
                    case 6:
                    System.exit(0);
                    break;
                    default:
                    System.out.println("Not a valid Entry !!");
                }
            }

        }
        else if(choice == 2)
        {
            SavingAccount s1 = new SavingAccount();
            s1.setName();
            s1.setAccountNumber();
            System.out.println("Thank you so much for the details !!");
            System.out.println("\n");
            while(true)
            {
                System.out.println("Choose the following options : ");
                System.out.println("1. Deposite Money");
                System.out.println("2. Check Balance");
                System.out.println("3. Withdral Money");
                System.out.println("4. Calculate Roi");
                System.out.println("5. Show My Profile");
                System.out.println("6. Exit");
                System.out.println("\n");
                System.out.print("Please Enter your Choice : ");
                int userChoice2 = Integer.parseInt(br.readLine());
                switch(userChoice2)
                {
                    case 1:
                    s1.depositeAmount();
                    break;
                    case 2:
                    s1.getAccountBalance();
                    break;
                    case 3:
                    s1.withdrawlMoney();
                    break;
                    case 4:
                    s1.calculateRoi();
                    break;
                    case 5:
                    s1.showProfile();
                    break;
                    case 6:
                    System.exit(0);
                    default:
                    System.out.println("Not a valid Entry !!");
                }
            }
        }
    }

}