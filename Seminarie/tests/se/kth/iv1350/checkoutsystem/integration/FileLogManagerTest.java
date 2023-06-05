package se.kth.iv1350.checkoutsystem.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;


import static org.junit.jupiter.api.Assertions.*;

class FileLogManagerTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Log systemLog;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void FileLogManager() {
        try {
            systemLog = new FileLogManager("");
            fail();
        } catch (RuntimeException e) {
            assertEquals("Could not generate logfile", outputStreamCaptor.toString().trim(), "Method not printing properly");
        }
    }
}