package DoorServe.com.Ref;

public class Paymentref {
private int billId;
private double amount;
public int getBillId() {
	return billId;
}
public void setBillId(int billId) {
	this.billId = billId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Paymentref(int billId, double amount) {
	super();
	this.billId = billId;
	this.amount = amount;
}
@Override
public String toString() {
	return "Paymentref [billId=" + billId + ", amount=" + amount + "]";
}



}
