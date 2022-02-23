import java.util.Scanner;
import java.io.*;
/*
Main class ManagerClass
Methods: main method
        :userInput

    String[] userInput
    {
        **Called to get input from the user about a new client
        Used for both EnterpriseAccount and AccountHolder instances
    }
    main
    {
        Gives the user options for manipulating the banking system
        Creates instances of EnterpriseAccount and AccountHolder classes 
    }
*/
public class ManagerClass {
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        //Variable declaration
        int bankUsers = AccountHolder.getBankUsers();
        Maps newMaps = new Maps();
        int n = -1;//while loop counter

        /*
        Used to give the system user options for manipulating the banking system.
        It constantly gives back the oprions to the user after a section has been completed
        The system exits when 0 is entered

        */
        while (n != 0)
        {
            //Variable declarations
            String accountName ;
            String accountKRAPin;
            double deposit =0.0;//initializing 

            //User options 
            System.out.println("\nEnter 0 to exit,any other number to continue");
            System.out.println("Enter 1 to create a new normal account holder");
            System.out.println("Enter 2 to create a new enterprise account");
            System.out.println("Enter 3 to see the user stats");
            System.out.println("Enter 4 to process a loan for a user");
            System.out.println("Enter 5 to top up one's loan");
            System.out.println("Enter 6 to see the bank stats");
    
            n = input.nextInt();//Getting the user option

            //Allows the user to create a new user of type AccountHolder
            if (n == 1)
            {
                String [] accInput = userAccInput();
                accountName = accInput[0];
                accountKRAPin = accInput[1];
                deposit = Double.parseDouble(accInput[2]);
                newMaps.addAccount(bankUsers+1, accountName,accountKRAPin,deposit); //new user instance is saved in the instance of Maps            
                System.out.println(accountName+" Officially added");
                bankUsers++;
            }

            //Allows the user to create a new user of type EnterpriseAccount
            else if (n == 2)
            {
                
                String [] accInput = userAccInput();
                System.out.println("Enter 1 for securities and 0 for insuarance");
                int secOption = input.nextInt();
                accountName = accInput[0];
                accountKRAPin = accInput[1];
                deposit = Double.parseDouble(accInput[2]);
                newMaps.addAccount(bankUsers+1,accInput[0],accInput[1],deposit,1);  
                EnterpriseAccount ent = newMaps.eAccounts.get(bankUsers+1);
                if (secOption == 0)
                {
                    ent.updateInsuarance(true);
                }
                else if (secOption == 1)
                {
                    ent.updateInsuarance(false);
                }
                else
                {
                    System.out.println("Oops, something went wrong");
                    continue;
                }
                System.out.println(accountName+" Officially added");
                bankUsers++;
            }
            //Displays the status of a user whose userID is provided
            else if (n == 3)
            {
                    System.out.println("Enter the userID of client");
                    int user = input.nextInt();

                    //checks what kind of user the userid belongs to 
                    if(newMaps.accounts.containsKey(user) == true)
                    {
                        UserStatus userStatus = new UserStatus(newMaps.accounts.get(user));
                    }
                    else if (newMaps.eAccounts.containsKey(user) == true) 
                    {
                        System.out.println("Hi");
                        UserStatus userStatus = new UserStatus(newMaps.eAccounts.get(user));
                    }
                    else
                    {
                        System.out.println("Oops, something went wrong!");
                        continue;
                    }
                    
            }
            //Checks if a user can access a loan based on the amount requested
            else if(n == 4)
            {
                System.out.println("Enter the user id ");
                int user = input.nextInt();
                System.out.println("Enter the amount requested");
                double amountRequested = input.nextDouble();

                //Checks which type of user the userid parsed belongs to 

                if(newMaps.accounts.containsKey(user) == true)
                    {
                        //creates an instance of the class LoanProcessing to check if the user can obtain the requested loan 
                        LoanProcessing loan = new LoanProcessing(newMaps.accounts.get(user),amountRequested);
                    }
                else if (newMaps.eAccounts.containsKey(user) == true) 
                    {
                        
                       LoanProcessing loan = new LoanProcessing(newMaps.eAccounts.get(user),amountRequested);
                    }
                
            }

            //Displays the stats of the user whose userid has been entered 
            else if (n == 5)
            {
                System.out.println("Enter the user id");
                int user = input.nextInt();
                double currentLoan = newMaps.accounts.get(user).getLoansAmount();
                System.out.println("Current loan amount is :"+currentLoan+"How much do you want to top up");
                double loanTopUp = input.nextDouble();
                newMaps.accounts.get(user).updateLoansAmount(loanTopUp);
            }
            //creates an instance of BankStatus to display details about the bank books 
            else if (n == 6)
            {
                BankStatus bankStatus = new BankStatus();
            }

            //Exit statement
            else if (n ==0)
            {
                System.out.println("Goodbye");
            }

            else
            {
                System.out.println("You entered "+n+" It is not one of the available options");
                continue;
            }


        }
        
    }
    private static String[] userAccInput()
    {
        
        String accountName,accountKRAPin;
        int option;
        double deposits = 0.0 ;
        System.out.println("Enter the accountName\n");
        input.nextLine();
        accountName = input.nextLine();
        System.out.println("Enter the KRA Pin\n");
        accountKRAPin = input.nextLine();
        System.out.println("Does the client want to deposit at the time?\n");
        System.out.println("Enter 0 for no, 1 for yes\n");
        option = input.nextInt();
        //Checks if the client wants to deposit at the time 
        if (option == 0)
        {
            deposits = 0.0;
        }
        else if (option ==1)
        {
            System.out.println("How much does he want to deposit");
            deposits = input.nextDouble();
        }

        //Appends the data to an array and returns it.
        String[] arr = new String[3];
        arr[0] = accountName;
        arr[1] = accountKRAPin;
        arr[2] = Double.toString(deposits);
        return arr;
        

    }
    
}
