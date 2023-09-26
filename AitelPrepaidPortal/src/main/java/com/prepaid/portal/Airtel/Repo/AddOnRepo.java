package com.prepaid.portal.Airtel.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prepaid.portal.Airtel.Model.AddOn;


@Repository
public interface AddOnRepo extends JpaRepository<AddOn, Long> {
	
    Optional<AddOn> findByFetuName(String fetuName);

}
