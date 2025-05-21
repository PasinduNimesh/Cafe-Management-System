package com.cafe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.POJO.Bill;

public interface BillDao extends JpaRepository<Bill, Integer>{

	List<Bill> getAllBills();

	List<Bill> getBillByUserName(String currentUser);
	
	

}
