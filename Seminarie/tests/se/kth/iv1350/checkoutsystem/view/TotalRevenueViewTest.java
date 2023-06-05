package se.kth.iv1350.checkoutsystem.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TotalRevenueViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    TotalRevenueView view;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        view = new TotalRevenueView();
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void doShowTotalIncome() {
        try{
            view.doShowTotalIncome(2938);
        }catch (Exception e){
            fail();
        }
        assertEquals("The total store sales is currently at 2938", outputStreamCaptor.toString().trim(), "Method not printing properly");
    }

}