package pkgCore;

import org.apache.poi.ss.formula.functions.Finance;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	//TODO: Build the contructor, getters and setters for the attributes above.
	public int getiYearsToWork()
	{return this.iYearsToWork;}
	public void setiYearsToWork(int value)
	{this.iYearsToWork = value;}
	
	public double getdAnnualReturnWorking()
	{return this.dAnnualReturnWorking;}
	public void setidAnnualReturnWorking(double value)
	{this.dAnnualReturnWorking = value;}
	
	public int getiYearsRetired()
	{return this.iYearsRetired;}
	public void setiYearsRetired(int value)
	{this.iYearsRetired = value;}
	
	public double getdAnnualReturnRetired()
	{return this.dAnnualReturnRetired;}
	public void setdAnnualReturnRetired(double value)
	{this.dAnnualReturnRetired = value;}
	
	public double getdRequiredIncome()
	{return this.dRequiredIncome;}
	public void setdRequiredIncome(double value)
	{this.dRequiredIncome = value;}
	
	public double getdMonthlySSI()
	{return this.dMonthlySSI;}
	public void setdMonthlySSI(double value)
	{this.dMonthlySSI = value;}
	
	

	public double TotalAmountSaved()
	{
		//	TODO: Determine amount to be saved based on Monthly SSI, Required Income, Annual return during retirement
		//		and number of years retired.
		//
		return ((getdRequiredIncome() - getdMonthlySSI()) / (getdAnnualReturnRetired() / 12) * (1 - Math.pow(1 + (getdAnnualReturnRetired() / 12), - (getiYearsRetired() * 12))));
	}
	
	public double AmountToSave()
	{
		//TODO: Determine the amount to save each month based on TotalAmountSaved, YearsToWork
		//		and Annual return while working
		
		double TAS = TotalAmountSaved();
		return -(Finance.pmt((getdAnnualReturnWorking() /12), (getiYearsToWork() *12), 0, TAS));
	}
}
