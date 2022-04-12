package DoorServe.com.Ref;

public class Billingref {

private int bookingId;
private double amount;

public int getBookingId() {
	return bookingId;
}
public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Billingref(int bookingId, double amount) {
	super();
	this.bookingId = bookingId;
	this.amount = amount;
}
@Override
public String toString() {
	return "Billingref [bookingId=" + bookingId + ", amount=" + amount + "]";
}

	
}
