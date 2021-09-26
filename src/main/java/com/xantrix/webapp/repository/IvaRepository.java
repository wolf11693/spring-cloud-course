package com.xantrix.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entity.Iva;

@Repository
public interface IvaRepository extends JpaRepository<Iva, Integer> {

	public Iva findByAliquota(int aliquota);
	
}
