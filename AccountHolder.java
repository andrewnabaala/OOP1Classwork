import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class AccountHolder {
    public static int users;
    public static double bankTotalDeposits,bankTotalWithdrawals,bankTotalLoanAmount;
    final static DateTimeFormatter FORMATTED_DATE = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String dateOpened = LocalDateTime.now().format(FORMATTED_DATE);
    public static Scanner input = new Scanner(System.in);
    private String accountName, kraPin;
    private double totalDeposit,totalWithdrawal,loansAmount;
    private int loansPending;
    final static  double loansIndex = 2.25;

    public AccountHolder()
    {

    }
    public AccountHolder(int userID,String accountName,String accountKRAPin,double totalDeposit)
    {
        this.accountName = accountName;
        kraPin = accountKRAPin;
        this.totalDeposit = totalDeposit;
        updateDeposits(totalDeposit);
        totalWithdrawal = 0.00;
        users++;
        
    }
    public void updateDeposits(double newDeposit)
    {
        totalDeposit = newDeposit + totalDeposit;
        bankTotalDeposits= bankTotalDeposits+ newDeposit;
    }
    public void updateWithdrawals(double newWithdrawal)
    {
        totalWithdrawal += newWithdrawal;
        updateBankWithdrawals(newWithdrawal);
    }
    public double currentBalance()
    {
        double balance =  totalDeposit - totalWithdrawal;
        return balance;
    }
    public void updateLoansPending(int updateInt)
    {
        if (updateInt == 1)
        {
            if (loansPending >= 4 )
            {
                    return; 
            }
            else
            {
                loansPending++;
            }
        }
        else if (updateInt == -1)
        {
            loansPending--;
        }
        else
        {
            System.out.println("Oops, something went wrong");
            return;
        }
    }
    public int getLoansPending()
    {
        return loansPending;
    }
    public String getAccountName()
    {
        return accountName;
    }
    public String getKraPin()
    {
        return kraPin;
    }
    public double getLoansAmount()
    {
        return loansAmount;
    }
    public double getTotalDeposit()
    {
        return totalDeposit;
    }
    public double getTotalWithdrawal()
    {
        return totalWithdrawal;
    }
    public double getLoansIndex()
    {
        return loansIndex;
    }
    public boolean preProcessLoans(double newLoan)
    {
        boolean loanProcessed = false;
        if ((loansAmount + newLoan) >= loansIndex*currentBalance())
        {
            System.out.println("Kindly await futher processing "+newLoan);

            loanProcessed =  false;
        }
        else if ((loansAmount + newLoan) < loansIndex*currentBalance())
        {
            updateLoansAmount(newLoan);
            updateBankLoanAmount(newLoan);
            loanProcessed = true;
            updateLoansPending(1);
            System.out.println("Your amount "+newLoan+" has been approved");
        }
        return loanProcessed;
    }
    public void updateLoansAmount(double newLoan)
    {
        loansAmount +=newLoan;
    }
    public static int getBankUsers()
    {
        return users;
    }
    public  double getBankBalance()
    {
        double bankBalance = bankTotalDeposits - bankTotalWithdrawals;
        return bankBalance;
    }
    public double getBankLoanAmounts()
    {
        return bankTotalLoanAmount;
    }
    public void updateBankLoanAmount(double loanAmount)
    {
        bankTotalLoanAmount += loanAmount; 
    }
    public void updateBankDeposits(double deposit)
    {
        bankTotalDeposits += deposit;
    }
    public void updateBankWithdrawals(double withdrawal)
    {
        bankTotalWithdrawals += withdrawal;
    }

}
