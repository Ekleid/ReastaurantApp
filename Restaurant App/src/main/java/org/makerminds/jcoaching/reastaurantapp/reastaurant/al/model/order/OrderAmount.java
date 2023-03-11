package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order;

public class OrderAmount {
	
	private double totalOrderAmount;
	private double totalOrderAmountVAT;
	private double totalOrderAmountWithVAT;
	
		
		//bejme konstruktoret
    public OrderAmount(double totalOrderAmount, double totalOrderAmountVAT, double totalOrderAmountWithVAT) {
    	this.totalOrderAmount = totalOrderAmount;
    	this.totalOrderAmountVAT = totalOrderAmountVAT;
    	this.totalOrderAmountWithVAT = totalOrderAmountWithVAT;
    	
    }
		
	
		// bejme getters dhe setters
    public double getTotalOrderAmount() {	
        return totalOrderAmount;
	}
	public void setTotalOrderAmount(double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}
	public double getTotalOrderAmountVAT() {
		return totalOrderAmountVAT;
	}
	public void setTotalOrderAmounVAT(double totalOrderAmountVAT) {
		this.totalOrderAmountVAT = totalOrderAmountVAT;
	}
	public double getTotalOrderAmountWithVAT() {
		return totalOrderAmountWithVAT;
	}
	public void setTotalOrderAmountWithVAT(double totalOrderAmountWithVAT) {
		this.totalOrderAmountWithVAT = totalOrderAmountWithVAT;
	}

	
	
}
