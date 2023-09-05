import AccountManagement.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {


    Account account = new Account("John Doe", "123456", 1000.0, 500.0, -500.0);


    @Test
    public void testGetHolder(){
        assertEquals("John Doe", account.getHolderName());
    }

    @Test
    public void testGetAccountNumber(){
        assertEquals("123456", account.getAccountNumber());
    }

    @Test
    public void testGetBalance(){
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    public void testGetWithdrawLimit(){
        assertEquals(500.0, account.getWithdrawLimit());
    }

    @Test
    public void testGetNegativeLimit(){
        assertEquals(-500.0, account.getNegativeLimit());
    }

    @Test
    public void testDeposit(){
        account.deposit(100.0);
        assertEquals(1100.0, account.getBalance());
    }

    @Test
    public void testWithdraw(){
        account.withdraw(100.0);
        assertEquals(900.0, account.getBalance());
    }

    @Test
    public void testWithdrawFail(){
        account.withdraw(10000.0);
        assertEquals(1000.0, account.getBalance());
    }

}