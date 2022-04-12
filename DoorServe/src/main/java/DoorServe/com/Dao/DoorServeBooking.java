package DoorServe.com.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import DoorServe.com.Entity.Booking;

public interface DoorServeBooking extends JpaRepository<Booking, Integer> {

	@Modifying
    @Transactional
	@Query(value = "Delete from booking where sphone= ?1" , nativeQuery = true )
	void deletebooking (double sphone);
	@Query(value = "select * from booking where cphone= ?1" , nativeQuery = true )
	List<Booking> FindBooking(double cphone);
	@Query(value = "select * from booking where bid= ?1" , nativeQuery = true )
	Booking FindBookingbyID(int bookingId);
	@Query(value = "select * from booking where sphone= ?1" , nativeQuery = true )
	List<Booking> FindBookingServiceProvider(double sphone);
    
}
