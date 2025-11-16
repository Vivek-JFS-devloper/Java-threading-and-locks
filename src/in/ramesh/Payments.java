package in.ramesh;

public class Payments {
	String dueDate;
	double dueAmount;

	public Payments(String dueDate, double dueAmount) {

		this.dueDate = dueDate;
		this.dueAmount = dueAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	@Override
	public String toString() {
		return "Payments [dueDate=" + dueDate + ", dueAmount=" + dueAmount + "]";
	}

}
