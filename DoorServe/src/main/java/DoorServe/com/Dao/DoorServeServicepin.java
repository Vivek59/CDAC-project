package DoorServe.com.Dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import DoorServe.com.Entity.Servicepin;

@Repository
public interface DoorServeServicepin extends JpaRepository<Servicepin, Integer> {
	@Modifying
    @Transactional
	@Query(value = "delete from servicepin where spin = 0;" , nativeQuery = true )
	void deletenull();
	@Modifying
    @Transactional
	@Query(value = "update servicepin set status = true where spid = ?1" , nativeQuery = true )
	void statusbookedpin(int spid);
	@Modifying
    @Transactional
	@Query(value = "update servicepin set status = false where spid = ?1" , nativeQuery = true )
	void statusunbooked(int spid);
//	@Query(value = "select * from servicepin where spid = ?1" , nativeQuery = true )
//	List<Servicepin> spinFindbySpid(int spid);
	@Modifying
    @Transactional
	@Query(value = "delete from servicepin where spid = ?1" , nativeQuery = true )
	void deleteServicepin(int spid);
	@Query(value = "select * from servicepin where spid = ?1" , nativeQuery = true )
	Servicepin[] findServicepinbySid(int spid);
	
	
}