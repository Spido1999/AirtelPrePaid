package com.prepaid.portal.Airtel.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prepaid.portal.Airtel.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
