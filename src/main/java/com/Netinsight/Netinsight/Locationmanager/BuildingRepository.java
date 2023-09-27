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
public interface BuildingRepository extends JpaRepository<Building, Long> {
	@Procedure(procedureName = "CreateBuilding")
	void createBuilding(@Param("Cityname") String Cityname, @Param("Buildingname") String Buildingname);

	@Query(value = "select * from building where building_name= :buildingName", nativeQuery = true)
	public Building findByBuilding(@Param("buildingName") String buildingName);

	@Query(value = "select * from building", nativeQuery = true)
	ArrayList<Building> findAllBuilding();

	@Query(value = "select * from building where city_name= :cityName", nativeQuery = true)
	ArrayList<Building> findAllBuldingincity(@Param("cityName") String cityName);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM building WHERE building_name = :buildingName", nativeQuery = true)
	void deleteByBuilding(@Param("buildingName") String buildingName);

	Building findTopByOrderByIdDesc();

}
