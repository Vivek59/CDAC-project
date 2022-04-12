package DoorServe.com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DoorServe.com.Entity.Billing;
import DoorServe.com.Entity.Booking;
import DoorServe.com.Entity.Customer;
import DoorServe.com.Entity.Servicepin;
import DoorServe.com.Entity.Serviceprovider;
import DoorServe.com.Ref.Login;


@Component
public class DoorServerHibenateDao {
	
@Autowired
DoorServeCustomer cdb;
@Autowired
DoorServeDaoServiceProvider spdb;
@Autowired
DoorServeServicepin spsp;
@Autowired
DoorServeBooking dsb;
@Autowired
DoorServeBilling dsbill;

public boolean InsertCustomer(Customer cobj) {		
cdb.save(cobj);		
return true;
}

public Customer cfindByPassword(String password) {
return cdb.ByPassword(password);
}
public Customer cfindByUsername(String username) {
return cdb.ByUsername(username);		
}

public Customer cfindByPhone(double phone){
return cdb.ByPhone(phone);	

}
 public boolean InsertServiceprovider(Serviceprovider sobj) {
	spdb.save(sobj);
	return true;
	}

	public void InsertServicepin(Servicepin sp) {
	spsp.save(sp);
	}

	public Serviceprovider ServiceproviderId(Serviceprovider sobj) {
	return spdb.Serviceprovider (sobj.getSphone());
	}

	public void DeleteNullpin() {
     spsp.deletenull();		
	}

	public void servicebooking(Booking bk) {
	dsb.save(bk);		
	}
    
	public Customer FindCustomer(String username, String password) {
	return cdb.FindCustomer( username ,password);
	}

	public Serviceprovider AvailableServiceprovider(String service, int areapin) {
	return spdb.AvailableServiceprovider(service ,areapin);
	}

	public void bookedstatus(int spid) {
	spdb.bookedstatus(spid);
	}

	public void billing(Billing bobj) {
	dsbill.save(bobj);
	}

	public Serviceprovider sfindByUsername(String username) {
		
		return spdb.ByUsername(username);
	}

	public Object sfindByPassword(String password) {
		return spdb.ByPassword( password);
	}

	public Object sfindByPhone(double sphone) {
		return spdb.ByPhone(sphone);
	}

	public Customer loginCustomer(Login cs) {
	return cdb.login(cs.getUsername(),cs.getPassword());
	}

	public Serviceprovider loginService(Login cs) {
    return spdb.FindServiceprovider(cs.getUsername(),cs.getPassword());
	}

	public Object Unbokedstatus(int spid) {
	spdb.Unbokedstatus(spid);
	return true;
	}

	public void statusbookedpin(int spid) {
		spsp.statusbookedpin(spid);	
	}

	public void statusunbookedpin(int spid) {
		spsp.statusunbooked(spid);
	}
    
	public boolean deleteBooking(double sphone ) {
		dsb.deletebooking(sphone);
		return true;
	}
	
	public Serviceprovider FindServiceprovider(String username, String password) {
		return spdb.FindServiceprovider( username ,password);
		}

//	public List<Servicepin> FindServicepin(int spid) {
//		
//		return spsp.spinFindbySpid(spid);
//	}
	
	public void deleteservicepin(int spid) {
		spsp.deleteServicepin(spid);
	}

	public List<Booking> FindBooking(double cphone) {
		// TODO Auto-generated method stub
		return dsb.FindBooking(cphone);
	}

	public Booking FindBookingbyID(int bookingId) {
		return dsb.FindBookingbyID(bookingId);
	}

	public Billing FindbillById(int billId) {
		return dsbill.FindbillById(billId) ;
	}

	public void PaidstatusFrombill(int sno) {
	dsbill.PaidstatusFrombill(sno);
		
	}

	public Servicepin [] findServicepinbySid(int spid) {
		return spsp.findServicepinbySid(spid) ;
	}

	public List<Booking> FindBookingServiceProvider(double sphone) {
		return dsb.FindBookingServiceProvider(sphone);
	}

	public List<Billing> findMybill(double cphone) {
		return dsbill.findMybill(cphone) ;
	}

	public List<Billing> FindHistory(double csphone) {
		return dsbill.FindHistory(csphone);
	}

	
}
