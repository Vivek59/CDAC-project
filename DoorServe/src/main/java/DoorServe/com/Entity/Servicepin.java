package DoorServe.com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicepin")
public class Servicepin {
@Id
@GeneratedValue
int sno;
int spid;
int spin;
int scode;
boolean status;
public Servicepin() {
	super();
	// TODO Auto-generated constructor stub
}
public Servicepin(int sno, int spid, int spin, int scode, boolean status) {
	super();
	this.sno = sno;
	this.spid = spid;
	this.spin = spin;
	this.scode = scode;
	this.status = status;
}

public Servicepin( int spid, int spin, int scode, boolean status) {
	this.spid = spid;
	this.spin = spin;
	this.scode = scode;
	this.status = status;
}




public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getSpid() {
	return spid;
}
public void setSpid(int spid) {
	this.spid = spid;
}
public int getSpin() {
	return spin;
}
public void setSpin(int spin) {
	this.spin = spin;
}
public int getScode() {
	return scode;
}
public void setScode(int scode) {
	this.scode = scode;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
@Override
public String toString() {
	return "Servicepin [sno=" + sno + ", spid=" + spid + ", spin=" + spin + ", scode=" + scode + ", status=" + status
			+ "]";
}



}
