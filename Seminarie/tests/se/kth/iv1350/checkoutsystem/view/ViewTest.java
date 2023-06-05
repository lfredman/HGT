package se.kth.iv1350.checkoutsystem.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.checkoutsystem.controller.Controller;
import se.kth.iv1350.checkoutsystem.integration.FileLogManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    View view;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void View() {
        Controller contr = new Controller(new FileLogManager("log.txt"));
        view = new View(contr);
        assertTrue(outputStreamCaptor.toString().contains("Scan the first item:"), "View not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("The total price for this sale is: 57"), "View not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("The change to the customer is: 443"), "View not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("------- NEW SALE -------"), "View not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("The total price for this sale is: 118"), "View not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("The change to the customer is: 382"), "View not printed properly");

        assertTrue(outputStreamCaptor.toString().contains("!!! Could not parse item information, invalid item identifier: 293847 !!!\n"), "Error not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("System inventory error have occurred. Contact support!\n"), "Error not printed properly");

        assertTrue(outputStreamCaptor.toString().contains("Current Sale:\n" + "Description:  Price: "), "Layout not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("Egg             5\n" + "Potato             3\n" +   "Running Total: 118"), "View not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("Milk             20\n" + "Potato             3\n" + "Running Total: 57"), "View not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("The total store sales is currently at 175"), "View not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("The change to the customer is: 382"), "View not printed properly");
        assertTrue(outputStreamCaptor.toString().contains("--------------------------"), "Layout not printed properly");

    }

}