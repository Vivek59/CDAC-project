package DoorServe.com.Service;

import java.util.List;
import DoorServe.com.Entity.Billing;
import DoorServe.com.Entity.Booking;
import DoorServe.com.Entity.Customer;
import DoorServe.com.Ref.Billingref;
import DoorServe.com.Ref.Login;
import DoorServe.com.Ref.Paymentref;
import DoorServe.com.Ref.ServiceproviderRef;



public interface DoorserveServiceInterface {

	Object InsertCustomer(Customer cobj);
	
	Object InsertServiceprovider(ServiceproviderRef sobj);
	
	boolean servicebookjwt(String service);

	boolean billing(Billingref bobj);

	Object cUpadte(Customer cup);

	Object sUpadte(ServiceproviderRef sup);

	String TOKEN(Login authRequest);

	List<Booking> Mybooking();

	String Payment(Paymentref pobj);

	Customer cUpdatereq();

	ServiceproviderRef sUpadtereq();

	List<Billing> Mybill();

	List<Billing> history();







}
