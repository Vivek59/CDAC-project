package DoorServe.com.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="serviceprovider")
public class Serviceprovider {
@Id	
int  spid;
String sname;
String username;
String  password;
double  sphone;
String staddress;
int areapin;
String cityname;
int scode;
boolean status;
public int getSpid() {
	return spid;
}
public void setSpid(int spid) {
	this.spid = spid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
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
public double getSphone() {
	return sphone;
}
public void setSphone(double sphone) {
	this.sphone = sphone;
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
public int getScode() {
	return scode;
}
public void setScode(int scode) {
	this.scode = scode;
}
public boolean getStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public Serviceprovider(int spid, String sname, String username, String password, double sphone, String staddress,
		int areapin, String cityname, int scode , boolean status) {
	super();
	this.spid = spid;
	this.sname = sname;
	this.username = username;
	this.password = password;
	this.sphone = sphone;
	this.staddress = staddress;
	this.areapin = areapin;
	this.cityname = cityname;
	this.scode = scode;
	this.status = status;
}

public Serviceprovider( String sname, String username, String password, double sphone, String staddress,
	int areapin, String cityname, int scode) {
	this.sname = sname;
	this.username = username;
	this.password = password;
	this.sphone = sphone;
	this.staddress = staddress;
	this.areapin = areapin;
	this.cityname = cityname;
	this.scode = scode;
}




public Serviceprovider() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Serviceprovider [spid=" + spid + ", sname=" + sname + ", username=" + username + ", password=" + password
			+ ", sphone=" + sphone + ", staddress=" + staddress + ", areapin=" + areapin + ", cityname=" + cityname
			+ ", scode=" + scode + ", status=" + status + "]";
}


}
