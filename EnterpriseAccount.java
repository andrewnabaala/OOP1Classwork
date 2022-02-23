public class EnterpriseAccount extends AccountHolder {
    private boolean trusted;
    private double overdraftLimitIndex; 
    private boolean insuarance,securities;
    private double securitiesTotal,insuredAmount,bankSecuritiesTotal,bankInsuredTotal;
    private int enterpriseUsers;
    public EnterpriseAccount()
    {}
    public EnterpriseAccount(int userID,String accountName,String accountKRAPin,double totalDeposit)
    {
        super(userID,accountName,accountKRAPin,totalDeposit);
        overdraftLimitIndex = 3.00;
        enterpriseUsers++;
    }
    @Override
    public void updateLoansPending(int updateInt)
    {
        if (updateInt == 1)
        {
            if (getLoansPending() >= 10 )
            {
                    return; 
            }
            else
            {
                super.updateLoansPending(1);
            }
        }
        else if (updateInt == -1)
        {
            super.updateLoansPending(-1);
        }
        else
        {
            System.out.println("Oops something went wrong ");
        }

    }
    @Override
    public double currentBalance()
    {
        double balance =  overdraftLimitIndex * (getTotalDeposit() - getTotalWithdrawal());
        return balance;
    }
    
    public void updateInsuarance(boolean insured)
    {
        if(insured == true)
        {
            securities = false;
            securitiesTotal = 0.00;
            System.out.println("Enter the insured amount");
            insuredAmount = input.nextDouble();
            updateBankInsuredTotal(insuredAmount);
        }
        else if (insured == false)
        {
            securities = true;
            insuredAmount = 0.00;
            System.out.println("Enter the Securities amount");
            securitiesTotal = input.nextDouble();
            updateBankSecuritiesTotal(securitiesTotal);
        }
        else
        {
            System.out.println("Oops, something went wrong");
            return;
        }
    }
    public void updateTrusted(boolean trusted)
    {
        if (trusted == true)
        {
            this.trusted = trusted;
            overdraftLimitIndex++;
            
        }
        else if (trusted == false)
        {
            this.trusted = trusted;
            overdraftLimitIndex--;
        }
        else
        {
            System.out.println("Oops, something went wrong");
        }
    }
    public double getInsuredAmount()
    {
        return insuredAmount;
    }
    public double getSecuritiesTotal()
    {
        return securitiesTotal;
    }
    public boolean getTrusted()
    {
        return trusted;
    }
    public double getoverdraftLimit()
    {
        double overdraft = overdraftLimitIndex * (getTotalDeposit() -getTotalWithdrawal());
        return overdraft;
    }
    public boolean getInsuarance()
    {
        return insuarance;
    }
    public boolean getSecurities()
    {
        return securities;
    }
    public void updateBankInsuredTotal(double insuranceAmount)
    {
        bankInsuredTotal +=insuranceAmount;
    }
    public void updateBankSecuritiesTotal(double TotalLoanAmount)
    {
        bankTotalLoanAmount +=TotalLoanAmount;
    }
    public double getBankInsuredTotal()
    {
        return bankInsuredTotal; 
    }
    public double getBankSecuritiesTotal()
    {
        return bankSecuritiesTotal;
    }
    @Override
    public boolean preProcessLoans(double newLoan)
    {
        boolean processedLoan = false;
        if ( (getLoansAmount() + newLoan) >= getLoansIndex()*currentBalance() +securitiesTotal || (getLoansAmount() + newLoan) >= getLoansIndex()*currentBalance() +insuredAmount )
        {
            System.out.println("Sorry you cannot get a loan of this size at the time "+newLoan);

            processedLoan = false;
        }
        else if ((getLoansAmount() + newLoan) < getLoansIndex()*currentBalance())
        {
            updateLoansAmount(newLoan);
            updateBankLoanAmount(newLoan);
            updateLoansPending(1);
            System.out.println("You have been approved for the loan:"+newLoan);
            processedLoan = true;
        }
        else{

            System.out.println("Oops something went wrong ");
        }
        return processedLoan;
    }
    
}
