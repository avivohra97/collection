package com.testing;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;

public class BankAccountTest {

    @BeforeClass
    public static void actionBeforeClassstep(){
        System.out.println("before class" );
    }

    @Before
    public void actionBefore(){
        System.out.println("before case");
    }

    @AfterClass
    public static void actionAfterClassstep(){
        System.out.println("After class");
    }

    @After
    public void actionAfter(){
        System.out.println("After case");
    }

    @Test
    public void deposit() {
        BankAccount account = new BankAccount("avi","vohra",0.18);
        double balance = account.deposit(200.0, true);
        assertEquals(200.18, balance, 0);
        assertEquals(200.18, account.getBalance(), 0);
    }

    @org.junit.Test
    public void withdraw() {
    }

    @org.junit.Test
    public void getBalance() {
    }


}