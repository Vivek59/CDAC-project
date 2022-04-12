package DoorServe.com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import DoorServe.com.Entity.Customer;



@Repository
public interface DoorServeCustomer extends JpaRepository<Customer,Integer >{
	
@Query(value = "select * from customer where username =?1 and password = ?2 " , nativeQuery = true )
Customer FindCustomer(String username, String password);
@Query(value = "select * from customer where password = ?1 " , nativeQuery = true )
Customer ByPassword(String password);
@Query(value = "select * from customer where username = ?1 " , nativeQuery = true )
Customer ByUsername(String username);
@Query(value = "select * from customer where cphone = ?1 " , nativeQuery = true )
Customer ByPhone(double phone);
@Query(value = "select * from customer where username =?1 and password = ?2 " , nativeQuery = true )
Customer login(String username, String password);






}
