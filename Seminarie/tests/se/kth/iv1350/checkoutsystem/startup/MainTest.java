package se.kth.iv1350.checkoutsystem.startup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.checkoutsystem.controller.Controller;
import se.kth.iv1350.checkoutsystem.integration.FileLogManager;
import se.kth.iv1350.checkoutsystem.integration.Log;
import se.kth.iv1350.checkoutsystem.view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void main() {
        Log systemLog = new FileLogManager("log.txt");
        Controller contr = new Controller(systemLog);
        View view = new View(contr);

        assertTrue(outputStreamCaptor.toString().contains("Scan the first item:"), "View not printed properly");
    }
}