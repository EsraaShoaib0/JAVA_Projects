package Model;

import java.util.ArrayList;
import java.util.List;

public class EWallet {
    private String name = "EraaSoft";
    private List<UserAccount> Accounts = new ArrayList<>();
    public void addAccount(UserAccount account){
        Accounts.add(account);
    }
    public UserAccount findAccountByUserName(String userName)
    {
        for (UserAccount account:Accounts)
        {
            if (account.getUserName().equals(userName))
            {
                return account;
            }
        }
        return null;
    }
}
