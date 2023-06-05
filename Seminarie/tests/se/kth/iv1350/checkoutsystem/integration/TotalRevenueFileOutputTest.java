package se.kth.iv1350.checkoutsystem.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TotalRevenueFileOutputTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Log revenueLog;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void TotalRevenueFileOutput() {
        try {
            revenueLog = new TotalRevenueFileOutput("");
            fail();
        } catch (RuntimeException e) {
            assertEquals("Could not generate logfile", outputStreamCaptor.toString().trim(), "Method not printing error properly");
        }
    }

}