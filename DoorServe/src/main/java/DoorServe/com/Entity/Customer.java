package DoorServe.com.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
@Id
int cid;
String cname;
String username;
String password;
double cphone;
String staddress;
int areapin;
String cityname;

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public double getCphone() {
	return cphone;
}
public void setCphone(double cphone) {
	this.cphone = cphone;
}
public String getStaddress() {
	return staddress;
}
public void setStaddress(String staddress) {
	this.staddress = staddress;
}
public int getAreapin() {
	return areapin;
}
public void setAreapin(int areapin) {
	this.areapin = areapin;
}
public String getCityname() {
	return cityname;
}
public void setCityname(String cityname) {
	this.cityname = cityname;
}
public Customer(int cid, String cname, String username, String password, int cphone, String staddress, int areapin,
		String cityname) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.username = username;
	this.password = password;
	this.cphone = cphone;
	this.staddress = staddress;
	this.areapin = areapin;
	this.cityname = cityname;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Customer [cid=" + cid + ", cname=" + cname + ", username=" + username + ", password=" + password
			+ ", cphone=" + cphone + ", staddress=" + staddress + ", areapin=" + areapin + ", cityname=" + cityname
			+ "]";
}



}
