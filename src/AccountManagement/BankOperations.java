package AccountManagement;
import java.util.ArrayList;
import java.util.List;

public class BankOperations {
    public List<Account> accounts = new ArrayList<Account>();

    public void addAccount(String holderName, String accountNumber, double balance, double withdrawLimit, double negativeLimit){
        Account account = new Account(holderName, accountNumber, balance, withdrawLimit, negativeLimit);
        accounts.add(account);
    }

    public void deleteAccount(String accountNumber){
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                accounts.remove(i);
            }
        }
    }
    public void transfer(String AccountFrom, String AccountTo, double Amount){
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountNumber() == AccountFrom && accounts.get(i).getBalance() >= Amount){
                for (int j = 0; j < accounts.size(); j++){
                    if (accounts.get(j).getAccountNumber() == AccountTo){
                        accounts.get(i).withdraw(Amount);
                        accounts.get(j).deposit(Amount);
                    }
                }
            } else {
                System.out.println("Transfer error");
            }
        }
    }
}
