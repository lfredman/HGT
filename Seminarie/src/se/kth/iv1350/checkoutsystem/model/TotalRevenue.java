package se.kth.iv1350.checkoutsystem.model;

/**
 * Parent class for the totalRevenue observer classes
 */
public abstract class TotalRevenue implements SaleObserver{
    int totalSale = 0;

    protected TotalRevenue(){}

    /**
     * Method called from observer and prints current total sales amount.
     * @param sale The sales object
     */
    @Override
    public void completedSale(Sale sale) {
        calculateTotalIncome(sale);
        showTotalIncome ();
    }
    private void showTotalIncome() {
        try {
        doShowTotalIncome (totalSale);
        } catch (Exception e) {
        handleErrors(e); }
    }

    private void calculateTotalIncome(Sale sale){
        totalSale += sale.getRunningTotal();
    }

    /**
     * Method for child-classes to create and to take action when new sale is made
     * @param totalSale Int representing the total price for recent sale
     * @throws Exception Thrown when actions could not be preformed
     */
    protected abstract void doShowTotalIncome(int totalSale) throws Exception;

    /**
     * Method for childclasses to handle exceptions thrown
     * @param e The exception thrown
     */
    protected abstract void handleErrors(Exception e);
}
