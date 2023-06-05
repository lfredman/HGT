package se.kth.iv1350.checkoutsystem.view;

import se.kth.iv1350.checkoutsystem.model.TotalRevenue;

/**
 * Class for generating a view output of current total sales amount
 */
public class TotalRevenueView extends TotalRevenue {

    /**
     * Constructor for the TotalRevenueView
     */
    public TotalRevenueView(){}
    /**
     * Method for printing total revenue
     * @param totalSale Int representing the total price for recent sale
     * @throws Exception Thrown in case of printing error
     */
    @Override
    protected void doShowTotalIncome(int totalSale) throws Exception {
        System.out.println("The total store sales is currently at " + totalSale + "\n");
    }

    /**
     * Method for handling exceptions
     * @param e The exception thrown
     */
    @Override
    protected void handleErrors(Exception e) {
        throw new RuntimeException(e);
    }

}
