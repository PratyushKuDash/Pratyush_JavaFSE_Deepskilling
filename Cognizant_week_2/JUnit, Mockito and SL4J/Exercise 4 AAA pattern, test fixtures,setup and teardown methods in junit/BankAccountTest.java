package junitdemo;

import org.junit.*;
import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(100.0); 
        System.out.println("Setup: Created account with $100");
    }

    @After
    public void tearDown() {
        account = null;
        System.out.println("Teardown: Cleaned up account");
    }

    @Test
    public void testDeposit() {
        
        double depositAmount = 50.0;

        account.deposit(depositAmount);

        assertEquals(150.0, account.getBalance(), 0.001);
    }

    
    @Test
    public void testWithdraw_InsufficientFunds() {
    
        double withdrawalAmount = 150.0;

        assertFalse("Withdrawal should fail", account.withdraw(withdrawalAmount));
        assertEquals(100.0, account.getBalance(), 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDeposit_NegativeAmount() {
        account.deposit(-10.0);
    }
}