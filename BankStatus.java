public class BankStatus {

    public BankStatus()
    {
        AccountHolder bankdeets = new AccountHolder();
        double loanAmount = bankdeets.getBankLoanAmounts();
        int users = bankdeets.getBankUsers();
        double bankBalance = bankdeets.getBankBalance();
        EnterpriseAccount enterpriseDetails = new EnterpriseAccount();
        double insuredTotal = enterpriseDetails.getBankInsuredTotal();
        double securitiesTotal = enterpriseDetails.getBankSecuritiesTotal();
        System.out.println("The total loan amount is :"+loanAmount);
        System.out.println("The total number of users is :"+users);
        System.out.println("The Bank balance is :"+bankBalance);
        System.out.println("The insured total is :"+insuredTotal);
        System.out.println("The total securities are"+securitiesTotal);
    }
  
    
}
