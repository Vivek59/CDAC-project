package DoorServe.com.Dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import DoorServe.com.Entity.Serviceprovider;

@Repository
public interface DoorServeDaoServiceProvider extends JpaRepository<Serviceprovider,Integer>{

	
	@Query(value = "select * from serviceprovider where sphone =?1" , nativeQuery = true )
	Serviceprovider Serviceprovider(double phoneno);
//	select * from serviceprovider where spid = (select  spid from servicepin where scode = (select scode from services where  sname = "CARPENTER")   and status = 0 and spin = 452013 limit 1);
	@Query(value =  "select * from serviceprovider where spid = (select  spid from servicepin where scode = (select scode from services where  sname = ?1 )   and status = 0 and spin = ?2 limit 1 );", nativeQuery = true )
    Serviceprovider AvailableServiceprovider(String service, int localareapin);
	
	@Modifying
    @Transactional
	@Query(value = "update serviceprovider set status = true where spid= ?1" , nativeQuery = true )
	void bookedstatus(int spid);
	
	@Query(value = "select * from serviceprovider where username = ?1" , nativeQuery = true )
	Serviceprovider ByUsername(String username);
	@Query(value = "select * from serviceprovider where password = ?1" , nativeQuery = true )
	Serviceprovider ByPassword(String password);
	@Query(value = "select * from serviceprovider where sphone = ?1" , nativeQuery = true )
	Serviceprovider ByPhone(double sphone);
	@Query(value = "select * from serviceprovider where username = ?1 and password = ?2 " , nativeQuery = true )
    Serviceprovider FindServiceprovider(String username, String password);
	@Modifying
    @Transactional
	@Query(value = "update serviceprovider set status = 0 where spid=?" , nativeQuery = true )
	void Unbokedstatus(int spid);
	
	
	
}
