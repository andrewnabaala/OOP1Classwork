import java.util.*;

/*
Class that manages all the users of the two different types.
Each user type is stored on its own hashmap with the user id as the key 

*/
public class Maps extends HashMap 
{
    //Defining my hashmap 
    public Map<Integer, AccountHolder> accounts = new HashMap<>();
    public Map<Integer, EnterpriseAccount> eAccounts = new HashMap<>();

    /*
        Method to add a map to the hashmap accounts
        Instantiates AccountHolder 
    */
    public void addAccount(int userID, String accountName,String accountKRAPin,double deposit)
    {
        int bankUsers = AccountHolder.getBankUsers();
        AccountHolder account = new AccountHolder(bankUsers +1, accountName, accountKRAPin,deposit);
        accounts.put(userID, account);
    } 
    /*
        Method to add a map to the hashmap eAccounts
        Instantiates EnterpriseAccount
        The added variable int n is to differentiate the two methods
        
    */

    public void addAccount(int userID, String accountName,String accountKRAPin,double deposit,int n)
    {
        int bankUsers = AccountHolder.getBankUsers();
        EnterpriseAccount account = new EnterpriseAccount(bankUsers +1, accountName, accountKRAPin,deposit);
        eAccounts.put(userID, account);
    }



}