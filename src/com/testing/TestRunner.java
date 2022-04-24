package com.testing;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BankAccountTest.class);
        for(Failure failure: result.getFailures()){
            System.out.println(failure.getDescription());
        }
        System.out.println("runner completed");
    }
}