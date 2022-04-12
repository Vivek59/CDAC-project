package DoorServe.com.Ref;

public class ServiceproviderRef {

  private String sname;
  private String username;
  private String  password;
  private double  sphone;
  private String staddress;
  private int areapin;
  private String cityname;
  private int scode;
  private int pin1,pin2,pin3,pin4;
  


public ServiceproviderRef() {
	super();
	// TODO Auto-generated constructor stub
}
public ServiceproviderRef(String sname, String username, String password, double sphone, String staddress, int areapin,
		String cityname, int scode, int pin1, int pin2, int pin3, int pin4) {
	super();
	this.sname = sname;
	this.username = username;
	this.password = password;
	this.sphone = sphone;
	this.staddress = staddress;
	this.areapin = areapin;
	this.cityname = cityname;
	this.scode = scode;
	this.pin1 = pin1;
	this.pin2 = pin2;
	this.pin3 = pin3;
	this.pin4 = pin4;
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
public int getPin1() {
	return pin1;
}
public void setPin1(int pin1) {
	this.pin1 = pin1;
}
public int getPin2() {
	return pin2;
}
public void setPin2(int pin2) {
	this.pin2 = pin2;
}
public int getPin3() {
	return pin3;
}
public void setPin3(int pin3) {
	this.pin3 = pin3;
}
public int getPin4() {
	return pin4;
}
public void setPin4(int pin4) {
	this.pin4 = pin4;
}
@Override
public String toString() {
	return "Serviceprovider [sname=" + sname + ", username=" + username + ", password=" + password + ", sphone="
			+ sphone + ", staddress=" + staddress + ", areapin=" + areapin + ", cityname=" + cityname + ", scode="
			+ scode + ", pin1=" + pin1 + ", pin2=" + pin2 + ", pin3=" + pin3 + ", pin4=" + pin4 + "]";
}
	

}
