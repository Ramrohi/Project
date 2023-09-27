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
public interface CityRepository extends JpaRepository<City, Long> {
	@Procedure(procedureName = "CreateCity")
	void createCity(@Param("Statename") String Statename, @Param("Cityname") String Cityname);

	@Query(value = "select * from city where city_name= :cityName", nativeQuery = true)
	public City findByCity(@Param("cityName") String cityName);

	@Query(value = "select * from city", nativeQuery = true)
	ArrayList<City> findAllCity();

	@Query(value = "select * from city where state_name= :stateName", nativeQuery = true)
	ArrayList<City> findAllStateincity(@Param("stateName") String stateName);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM city WHERE city_name = :cityName", nativeQuery = true)
	void deleteByCity(@Param("cityName") String cityName);

	City findTopByOrderByIdDesc();

}
