import AccountManagement.BankOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankOperationsTest {

    BankOperations b = new BankOperations();

    @Test
    public void AddAccountTest(){
        b.addAccount("John Doe", "123456", 1000.0, 500.0, -500.0);
        assertEquals(1, b.accounts.size());
    }

    @Test
    public void AddAccount2Test(){
        b.addAccount("John Doe", "123456", 1000.0, 500.0, -500.0);
        b.addAccount("Jane Doe", "654321", 1000.0, 500.0, -500.0);
        assertEquals(2, b.accounts.size());
    }

    @Test
    public void TransferTest(){
        b.addAccount("John Doe", "123456", 1000.0, 500.0, -500.0);
        b.addAccount("Jane Doe", "654321", 1000.0, 500.0, -500.0);
        b.transfer("123456", "654321", 500.0);
        assertEquals(500.0, b.accounts.get(0).getBalance());
        assertEquals(1500.0, b.accounts.get(1).getBalance());
    }

    @Test
    public void FailedTransferTest(){
        b.addAccount("John Doe", "123456", 1000.0, 500.0, -500.0);
        b.addAccount("Jane Doe", "654321", 1000.0, 500.0, -500.0);
        b.transfer("123456", "654321", 10000.0);
        assertEquals(1000.0, b.accounts.get(0).getBalance());
        assertEquals(1000.0, b.accounts.get(1).getBalance());
    }

    @Test
    public void deleteAccountTest(){
        b.addAccount("John Doe", "123456", 1000.0, 500.0, -500.0);
        b.addAccount("Jane Doe", "654321", 1000.0, 500.0, -500.0);
        b.deleteAccount("123456");
        assertEquals(1, b.accounts.size());
    }
}
