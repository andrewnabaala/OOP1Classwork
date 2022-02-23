public class UserStatus {
    private String accountName;
    private String accountKRAPin;
    private double loansAmount;
    private int loansPending;
    private double totalDeposit;
    public UserStatus(AccountHolder account)
    {
        
        varInitialization(account);

    }
    public UserStatus(EnterpriseAccount account)
    {
        varInitialization(account);       

    }
    public <T> void varInitialization(T account)
    {
        if (account instanceof EnterpriseAccount == true){ 
            EnterpriseAccount ent = (EnterpriseAccount) account;
            double insuredAmount;
            double overdraftLimit;
            double securitiesTotal;
            accountName = ent.getAccountName();
            accountKRAPin = ent.getKraPin();
            loansAmount = ent.getLoansAmount();
            loansPending = ent.getLoansPending();
            totalDeposit = ent.getTotalDeposit();
            overdraftLimit = ent.getoverdraftLimit();
            System.out.println("Account name:"+accountName);
            System.out.println("KRA PIn:"+accountKRAPin);
            System.out.println("TotalDeposit: "+totalDeposit);
            System.out.println("Pending loans: "+loansPending);
            System.out.println("Total Loans owed: "+loansAmount);
            if (ent.getInsuarance() == true)
            {
                System.out.println("Insured amount ="+ent.getInsuredAmount());
            }
            else 
            {
                System.out.println("Securities total ="+ent.getSecuritiesTotal());
            }

    }
    else if (account instanceof AccountHolder== true){
        AccountHolder ah = (AccountHolder) account;
        accountName = ah.getAccountName();
        accountKRAPin = ah.getKraPin();
        loansAmount = ah.getLoansAmount();
        loansPending = ah.getLoansPending();
        totalDeposit = ah.getTotalDeposit();
        System.out.println("Account name:"+accountName);
        System.out.println("KRA PIn:"+accountKRAPin);
        System.out.println("TotalDeposit: "+totalDeposit);
        System.out.println("Pending loans: "+loansPending);
        System.out.println("Total Loans owed: "+loansAmount);


    }

    }

}

   
