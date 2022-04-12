package DoorServe.com.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import DoorServe.com.CustomerServiceproviderJwt.JwtUtil;
import DoorServe.com.Dao.DoorServerHibenateDao;
import DoorServe.com.Entity.Billing;
import DoorServe.com.Entity.Booking;
import DoorServe.com.Entity.Customer;
import DoorServe.com.Entity.Servicepin;
import DoorServe.com.Entity.Serviceprovider;
import DoorServe.com.Ref.Billingref;
import DoorServe.com.Ref.Login;
import DoorServe.com.Ref.Paymentref;
import DoorServe.com.Ref.ServiceproviderRef;

@Service
public class DoorserveService implements DoorserveServiceInterface  {
	
@Autowired
private JwtUtil csjwtUtil;

@Autowired
private AuthenticationManager authenticationManager;	
		
@Autowired
DoorServerHibenateDao DB;


@Override
public Object InsertCustomer(Customer cobj) {


if(DB.cfindByUsername(cobj.getUsername())!= null) {
return "Username already in use";	
}	
	
if(DB.cfindByPassword(cobj.getPassword())!= null) {
return "Invalid Password";	
}

if(DB.cfindByPhone(cobj.getCphone())!= null) {
return "Already register try another no";	
}		
 return DB.InsertCustomer(cobj);
}

@Override
public Object InsertServiceprovider(ServiceproviderRef sobj){

Serviceprovider sp = new Serviceprovider(sobj.getSname(), sobj.getUsername() ,sobj.getPassword(), sobj.getSphone(),sobj.getStaddress(), sobj.getAreapin(), sobj.getCityname(), sobj.getScode());

if(DB.sfindByUsername(sp.getUsername())!= null) {
return "Username already in use";	
}	
	
if(DB.sfindByPassword(sp.getPassword())!= null) {
return "Invalid Password";	
}

if(DB.cfindByPassword(sp.getPassword())!= null) {
return "Invalid Password";	
}

if(DB.sfindByPhone(sp.getSphone())!= null) {
return "Already register try another no";	
}		
 
DB.InsertServiceprovider(sp);

Serviceprovider refspobj = DB.ServiceproviderId(sp);

int spid = refspobj.getSpid();
int scode= refspobj.getScode();
boolean status = refspobj.getStatus();

int [] spinar = {refspobj.getAreapin() ,sobj.getPin1(),sobj.getPin2(),sobj.getPin3(),sobj.getPin4()};
	
for(int i = 0; i<spinar.length ; i++){ 
	Servicepin spin = new Servicepin(spid ,spinar[i], scode , status);
    DB.InsertServicepin(spin);
    DB.DeleteNullpin();
  }	
	
return true;
}

@Override
public boolean billing(Billingref brefobj) {
	
Booking bkobj = DB.FindBookingbyID(brefobj.getBookingId());	
Billing bobj = new Billing(bkobj.getCphone(),bkobj.getService(),bkobj.getSphone(),brefobj.getAmount());
	
DB.billing(bobj);
Serviceprovider spref = (Serviceprovider) DB.sfindByPhone(bobj.getSphone()) ;
 DB.Unbokedstatus(spref.getSpid());
 DB.statusunbookedpin(spref.getSpid());
 DB.deleteBooking(spref.getSphone());
 return true;
}

@Override
public Object cUpadte(Customer cobj) {
UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
Customer cref = DB.FindCustomer(userDetails.getUsername(),userDetails.getPassword());

cref.setCname(cobj.getCname());

Customer cref1 = DB.cfindByPhone(cobj.getCphone());

if(cref1.getUsername().equals(userDetails.getUsername())) {
cref.setCphone(cobj.getCphone());	
}

else {
return "Phone no already in use ";
}
cref.setStaddress(cobj.getStaddress());
cref.setAreapin(cobj.getAreapin());
cref.setCityname(cobj.getCityname());
return DB.InsertCustomer(cref);
}


@Override
public boolean servicebookjwt(String service) {
	
UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

Customer cref = DB.FindCustomer( userDetails.getUsername(),userDetails.getPassword());
Serviceprovider spref = DB.AvailableServiceprovider(service,cref.getAreapin());
if(spref != null ) {
Booking bk = new Booking (cref.getStaddress(),cref.getCphone(),cref.getCname(),spref.getSphone(),spref.getSname(),service);	
DB.servicebooking(bk);
DB.bookedstatus(spref.getSpid());
DB.statusbookedpin(spref.getSpid());
return true;
}
return false;

}

@Override
public Object sUpadte(ServiceproviderRef sup) {

	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	Serviceprovider sref = DB.FindServiceprovider(userDetails.getUsername(),userDetails.getPassword());

	sref.setSname(sup.getSname());

	Serviceprovider sref1 = (Serviceprovider) DB.sfindByPhone(sup.getSphone());

	if(sref1.getUsername().equals(userDetails.getUsername())) {
	sref.setSphone(sup.getSphone());	
	}

	else {
	return "Phone no already in use ";
	}
	sref.setStaddress(sup.getStaddress());
	sref.setAreapin(sup.getAreapin());
	sref.setCityname(sup.getCityname());
	DB.InsertServiceprovider(sref);	
    DB.deleteservicepin(sref.getSpid());
    
    int spid = sref.getSpid();
    int scode= sref.getScode();
    boolean status = sref.getStatus();
    int [] spinar = {sref.getAreapin() ,sup.getPin1(),sup.getPin2(),sup.getPin3(),sup.getPin4()};
	
    for(int i = 0; i<spinar.length ; i++){ 
    	Servicepin spin = new Servicepin(spid ,spinar[i], scode , status);
        DB.InsertServicepin(spin);
        DB.DeleteNullpin();
      }
	

	return true;
}

@Override
public String TOKEN(Login authRequest) {
	

	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	} catch (AuthenticationException e) {

		try {
			throw new Exception("Invalid Credentials");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
Object cs =  (DB.cfindByUsername(authRequest.getUsername())!=null)?DB.cfindByUsername(authRequest.getUsername()):DB.sfindByUsername(authRequest.getUsername());
	
	if( cs instanceof Customer ) {
	return csjwtUtil.generateToken(authRequest.getUsername(), "customer");	

	}
	else if( cs instanceof Serviceprovider ) {
	return csjwtUtil.generateToken(authRequest.getUsername(), "Serviceprovider");
	
	}
	else {
		return "Invalid user";
	}

}

@Override
public List<Booking>  Mybooking() {
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	Object csref = (DB.FindCustomer(userDetails.getUsername(),userDetails.getPassword())!= null)? DB.FindCustomer(userDetails.getUsername(),userDetails.getPassword()):DB.FindServiceprovider(userDetails.getUsername(),userDetails.getPassword());
	List<Booking> LB = null;
	if( csref instanceof Customer ) {
		LB= DB.FindBooking(((Customer) csref).getCphone());	
	}
	else if (csref instanceof Serviceprovider ) {
		LB = DB.FindBookingServiceProvider(((Serviceprovider) csref).getSphone());
	}
	else {
		try {
			throw new Exception("Please Login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return LB;
}

@Override
public String Payment(Paymentref pobj) {
Billing bobj = DB.FindbillById(pobj.getBillId());
if(bobj.getAmount()==pobj.getAmount()) {
DB.PaidstatusFrombill(bobj.getSno());
	return "Payment Sucessfull";
}

	return "Please enter the valid Amount";
}

@Override
public Customer cUpdatereq() {
UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
	return DB.FindCustomer(userDetails.getUsername(),userDetails.getPassword());
}

@Override
public ServiceproviderRef sUpadtereq() {
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	Serviceprovider sobj = DB.FindServiceprovider(userDetails.getUsername(),userDetails.getPassword());
	Servicepin [] spinobj= DB.findServicepinbySid(sobj.getSpid());	
	ServiceproviderRef srefobj = null;
    if(spinobj.length == 1) {
     srefobj = new ServiceproviderRef(sobj.getSname(),sobj.getUsername(),sobj.getPassword(),sobj.getSphone(),sobj.getStaddress(),sobj.getAreapin(),
    			sobj.getCityname(),sobj.getScode(),0,0,0,0);
    }
    
    else if( spinobj.length == 2 ) {
    srefobj = new ServiceproviderRef(sobj.getSname(),sobj.getUsername(),sobj.getPassword(),sobj.getSphone(),sobj.getStaddress(),sobj.getAreapin(),
    			sobj.getCityname(),sobj.getScode(),spinobj[1].getSpin(),0,0,0);
    }

   else if( spinobj.length == 3 ) {
	   srefobj = new ServiceproviderRef(sobj.getSname(),sobj.getUsername(),sobj.getPassword(),sobj.getSphone(),sobj.getStaddress(),sobj.getAreapin(),
   			sobj.getCityname(),sobj.getScode(),spinobj[1].getSpin(),spinobj[2].getSpin(),0,0);
    }
   else if( spinobj.length == 4 ) {
	   srefobj = new ServiceproviderRef(sobj.getSname(),sobj.getUsername(),sobj.getPassword(),sobj.getSphone(),sobj.getStaddress(),sobj.getAreapin(),
	   			sobj.getCityname(),sobj.getScode(),spinobj[1].getSpin(),spinobj[2].getSpin(),spinobj[3].getSpin(),0);
   }
   else if( spinobj.length == 5) {
	   srefobj = new ServiceproviderRef(sobj.getSname(),sobj.getUsername(),sobj.getPassword(),sobj.getSphone(),sobj.getStaddress(),sobj.getAreapin(),
   			sobj.getCityname(),sobj.getScode(),spinobj[1].getSpin(),spinobj[2].getSpin(),spinobj[3].getSpin(),spinobj[4].getSpin());	
   }
	
	return srefobj;
}

@Override
public List<Billing> Mybill() {
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
	Customer cref =  DB.FindCustomer(userDetails.getUsername(),userDetails.getPassword());
	return DB.findMybill(cref.getCphone());
}

@Override
public List<Billing> history() {
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
	Object csref = (DB.FindCustomer(userDetails.getUsername(),userDetails.getPassword())!= null)? DB.FindCustomer(userDetails.getUsername(),userDetails.getPassword()):DB.FindServiceprovider(userDetails.getUsername(),userDetails.getPassword());
	List<Billing> History = null;
	if( csref instanceof Customer ) {
		History	= DB.FindHistory(((Customer) csref).getCphone());	
	}
	else if (csref instanceof Serviceprovider ) {
		History= DB.FindHistory(((Serviceprovider) csref).getSphone());
	}

	return History;
}










}
