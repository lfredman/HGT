package se.kth.iv1350.checkoutsystem.integration;
import se.kth.iv1350.checkoutsystem.model.TotalRevenue;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for generating a total revenue file from the sales system
 */
public class TotalRevenueFileOutput extends TotalRevenue implements Log {
    private FileWriter logFile;
    private int salesCounter = 0;

    /**
     * Constructor which sets up the output file
     * @param logPath Destination path of the file
     */
    public TotalRevenueFileOutput(String logPath) {
        try {
            logFile = new FileWriter(logPath);
        } catch (IOException e) {
            System.out.println("Could not generate logfile");
            throw new RuntimeException(e);
        }
    }

    /**
     * Method for writing the message to the file
     * @param logMessage The message getting logged.
     */
    public void write(String logMessage){
        try {
            logFile.write(logMessage);
            logFile.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method for generating logstring
     * @param totalSale Int representing the total price for recent sale
     * @throws Exception Thrown when writing could not be done
     */
    @Override
    protected void doShowTotalIncome(int totalSale) throws Exception {
        salesCounter += 1;
        String message = "The total after " + salesCounter + " sales is at: " + totalSale + "\n";
        write(message);
    }

    /**
     * Method for handling Exceptions
     * @param e The exception thrown
     */
    @Override
    protected void handleErrors(Exception e) {
        throw new RuntimeException(e);
    }
}

