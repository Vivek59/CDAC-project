package DoorServe.com.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import DoorServe.com.Entity.Billing;

@Repository
public interface DoorServeBilling extends JpaRepository<Billing, Integer> {
    @Query(value ="select * from bill where sno = ?1" , nativeQuery = true )
	Billing FindbillById(int billId);
    @Modifying
    @Transactional    
    @Query(value ="update bill set status = true where sno = ?1" , nativeQuery = true )
	void PaidstatusFrombill(int sno);
    @Query(value ="select * from bill where cphone = ?1 and status = false" , nativeQuery = true )
	List<Billing> findMybill(double cphone);
    @Query(value ="select * from bill where cphone = ?1 or sphone= ?1" , nativeQuery = true )
	List<Billing> FindHistory(double csphone);

}
