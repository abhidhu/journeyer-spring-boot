package com.journeyer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.journeyer.modal.Customer;

@Repository
public interface Customerrepo extends JpaRepository<Customer, Long>{
	
	@Query(value = "from Customer c where Cust_Id=?1")
	public List<Customer> findBycustomerid(int sectormasterid);
	
	@Query(value = "from Customer c where Cust_Id=?1")
	public Customer findBycustomercid(int cid);

	@Query(value = "from Customer c where Email=?1")
	Optional<Customer> findByEmail(String email);

//	@Modifying
//	@Query(value = "update Customer c set c.Password=?1 where c.Cust_Id = ?2")
//	public int setPassword(String password, int Cust_Id);

	Boolean existsByMobile(String mobile);
	Boolean existsByEmail(String email);
	
	//SELECT u FROM User u
	//@Query(value = "select * from Customer")
	//List<Customer> getAll();
	
	

}