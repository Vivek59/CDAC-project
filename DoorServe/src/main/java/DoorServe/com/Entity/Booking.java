 package DoorServe.com.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="booking")
public class Booking {

@Id
int bid;
String cadd;
double cphone;
String cname;
double sphone;
String sname;
String service;
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getCadd() {
	return cadd;
}
public void setCadd(String cadd) {
	this.cadd = cadd;
}
public double getCphone() {
	return cphone;
}
public void setCphone(double cphone) {
	this.cphone = cphone;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public double getSphone() {
	return sphone;
}
public void setSphone(double sphone) {
	this.sphone = sphone;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getService() {
	return service;
}
public void setService(String service) {
	this.service = service;
}
public Booking(int bid, String cadd, double cphone, String cname, double sphone, String sname, String service) {
	super();
	this.bid = bid;
	this.cadd = cadd;
	this.cphone = cphone;
	this.cname = cname;
	this.sphone = sphone;
	this.sname = sname;
	this.service = service;
}

public Booking(String cadd, double cphone, String cname, double sphone, String sname, String service) {
	super();
	this.cadd = cadd;
	this.cphone = cphone;
	this.cname = cname;
	this.sphone = sphone;
	this.sname = sname;
	this.service = service;
}



public Booking() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Booking [bid=" + bid + ", cadd=" + cadd + ", cphone=" + cphone + ", cname=" + cname + ", sphone=" + sphone
			+ ", sname=" + sname + ", service=" + service + "]";
}

}
