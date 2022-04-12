package DoorServe.com.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Billing {
@Id
int sno;
double cphone;
String service;
double sphone;
double amount;
boolean status = false;

public Billing() {
	super();
	// TODO Auto-generated constructor stub
}
public Billing(int sno, double cphone, String service, double sphone, double amount, boolean status) {
	super();
	this.sno = sno;
	this.cphone = cphone;
	this.service = service;
	this.sphone = sphone;
	this.amount = amount;
	this.status = status;
}
public Billing( double cphone, String service, double sphone, double amount) {
	this.cphone = cphone;
	this.service = service;
	this.sphone = sphone;
	this.amount = amount;
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public double getCphone() {
	return cphone;
}
public void setCphone(double cphone) {
	this.cphone = cphone;
}
public String getService() {
	return service;
}
public void setService(String service) {
	this.service = service;
}
public double getSphone() {
	return sphone;
}
public void setSphone(double sphone) {
	this.sphone = sphone;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
@Override
public String toString() {
	return "Billing [sno=" + sno + ", cphone=" + cphone + ", service=" + service + ", sphone=" + sphone + ", amount="
			+ amount + ", status=" + status + "]";
}



}
