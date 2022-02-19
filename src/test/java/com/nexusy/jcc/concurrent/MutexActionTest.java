package com.nexusy.jcc.concurrent;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author lanhuidong
 * @since 2022-02-19
 */
public class MutexActionTest {

    private static MutexAction<String> action;

    @BeforeAll
    public static void before() {
        action = new MutexAction<>();
    }

    private void slowPrint() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + ": Well done!");
    }

    private void conflict() {
        System.out.println(Thread.currentThread().getName() + ": I'v done nothing!");
    }

    @Test
    void testCheckAndDo() {
        Thread t1 = new Thread(() -> action.checkAndDo("1", this::slowPrint));
        Thread t2 = new Thread(() -> action.checkAndDo("1", this::slowPrint));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCheckAndDoWhenConflict() {
        Thread t1 = new Thread(() -> action.checkAndDo("1", this::slowPrint, this::conflict));
        Thread t2 = new Thread(() -> action.checkAndDo("1", this::slowPrint, this::conflict));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
