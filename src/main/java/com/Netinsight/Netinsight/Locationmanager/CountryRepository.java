package com.Netinsight.Netinsight.Locationmanager;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends JpaRepository<Country, Long> {

	@Procedure(procedureName = "CreateCountry")
	void insertCountry(@Param("Countryname") String Countryname, @Param("Notes") String Notes);

	// If you want to retrieve the latest country separately:
	Country findTopByOrderByIdDesc();

	@Query(value = "select * from country where country_name= :countryName", nativeQuery = true)
	public Country findByCountry(@Param("countryName") String countryName);

	@Query(value = "select * from country", nativeQuery = true)
	public ArrayList<Country> getAllcountry();

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM country WHERE country_name = :countryName", nativeQuery = true)
	void deleteByCountry(@Param("countryName") String countryName);

}
