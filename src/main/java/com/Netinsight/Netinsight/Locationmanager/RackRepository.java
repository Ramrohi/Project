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
public interface RackRepository extends JpaRepository<Rack, Long> {
	@Procedure(name = "CreateRack")
	void createRack(@Param("BuildingName") String buildingName, @Param("RackName") String rackName);

	@Query(value = "select * from rack where rack_name= :rackName", nativeQuery = true)
	ArrayList<Rack> findByRack(@Param("rackName") String rackName);

	@Query(value = "select * from rack", nativeQuery = true)
	ArrayList<Rack> findAllRack();

	@Query(value = "select * from rack where building_name= :buildingName", nativeQuery = true)
	ArrayList<Rack> findAllRackinbuilding(@Param("buildingName") String buildingName);

	@Query(value = "select * from rack where building_name= :buildingName and rack_name= :rackName", nativeQuery = true)
	ArrayList<Rack> findRackinbuilding(@Param("buildingName") String buildingName, @Param("rackName") String rackName);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM rack WHERE building_name = :buildingName and rack_name= :rackName", nativeQuery = true)
	void deleteRackBybuilding(@Param("buildingName") String buildingName, @Param("rackName") String rackName);

	Rack findTopByOrderByIdDesc();

}
