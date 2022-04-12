package DoorServe.com.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import DoorServe.com.Entity.Billing;
import DoorServe.com.Entity.Booking;
import DoorServe.com.Entity.Customer;
import DoorServe.com.Ref.Billingref;
import DoorServe.com.Ref.Login;
import DoorServe.com.Ref.Paymentref;
import DoorServe.com.Ref.ServiceproviderRef;
import DoorServe.com.Service.DoorserveServiceInterface;

@RestController
@CrossOrigin(origins ="http://localhost:3000")

public class DooreserveController {
	
@Autowired
DoorserveServiceInterface DSSI;


@PostMapping("/controller")
String Cont() {
return "Working";
}

@PostMapping("/insertcustomer")
Object InsertCustomer(@RequestBody Customer cobj ) {
return DSSI.InsertCustomer(cobj); 
}

@PostMapping("/insertserviceprovider")
Object InsertServiceprovider( @RequestBody ServiceproviderRef sobj  ) {
return DSSI.InsertServiceprovider(sobj);
}

@PostMapping("/authenticate")
public String generateTokenCustomer(@RequestBody Login authRequest) throws Exception {
return DSSI.TOKEN(authRequest);	
}

@PostMapping("/UpdateCustomerreq")
Customer cUpdatereq(){
return DSSI.cUpdatereq();
}

@PostMapping("/UpdateCustomer")
Object cUpdate(@RequestBody Customer cup ) {
return 	DSSI.cUpadte(cup);
}

@PostMapping("/UpdateServiceproviderreq")
ServiceproviderRef sUpdatereq() {
return 	DSSI.sUpadtereq();
}

@PostMapping("/UpdateServiceprovider")
Object sUpdate(@RequestBody ServiceproviderRef sup ) {
return 	DSSI.sUpadte(sup);
}


@PostMapping("/servicebook/{service}")
Object servicebooking(@PathVariable String service ) {
return DSSI.servicebookjwt(service);
}

@PostMapping("/mybooing")
public List<Booking>  Mybooking() {
return DSSI.Mybooking();
}


@PostMapping("/genratebilling")
boolean  billing (@RequestBody Billingref bobj ) {
return DSSI.billing( bobj );
}

@PostMapping("/mybill")
List<Billing> Mybill(){
return DSSI.Mybill();
}


@PostMapping("/payment")
public String payment(@RequestBody Paymentref pobj) {
return DSSI.Payment(pobj);
}

@PostMapping("/history")
public List<Billing> history() {
return DSSI.history();
}
}
