import java.util.Scanner;
public class LoanProcessing {
    
    private double bankLiquidity;
    public final static double LOAN_WAIVER_INDEX = 0.10;
    private boolean loanAllowed = false;
    private int loansPending;
    private double currentLoans;
    double currentBalance ;
    public static Scanner input = new Scanner(System.in);
    public LoanProcessing(AccountHolder account,double amountRequested)
    {
        loanAllowed = account.preProcessLoans(amountRequested);
        loansPending = account.getLoansPending();
        currentLoans = account.getLoansAmount();
        currentBalance = account.currentBalance();
        if(loanAllowed == false)
        {
            double differenceDivisor = (currentBalance - amountRequested)/currentBalance;
            if (differenceDivisor >= LOAN_WAIVER_INDEX)
            {
                System.out.println("Sorry you may not apply for this waiver at the time");
            }
            else if (differenceDivisor >= LOAN_WAIVER_INDEX/2)
            {
                System.out.println("Enter 1 to apply the waiver and 0 to reject the loan application");
                int option = input.nextInt();
                if(option == 1)
                {
                    account.updateLoansAmount(amountRequested);
                }
                else{
                    System.out.println("Sorry you are not viable for a waiver at the time");
                }
            }
            else 
            {
                System.out.println("You are not viable for the waiver,enjoy your money wisely");
            }
        }
    }
    
}
