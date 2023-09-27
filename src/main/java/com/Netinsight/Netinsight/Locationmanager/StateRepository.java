package com.Netinsight.Netinsight.Locationmanager;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
	@Procedure(procedureName = "CreateState")
	void createState(@Param("Countryname") String countryName, @Param("Statename") String stateName);

	@Query(value = "select * from state where state_name= :stateName", nativeQuery = true)
	public State findByState(@Param("stateName") String stateName);

	@Query(value = "select * from state", nativeQuery = true)
	ArrayList<State> findAllState();

	@Query(value = "select * from state where country_name= :countryName", nativeQuery = true)
	ArrayList<State> findAllStateincountry(@Param("countryName") String countryName);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM state WHERE state_name = :stateName", nativeQuery = true)
	void deleteByState(@Param("stateName") String stateName);

	State findTopByOrderByIdDesc();

	void save(StateDto state);

}
