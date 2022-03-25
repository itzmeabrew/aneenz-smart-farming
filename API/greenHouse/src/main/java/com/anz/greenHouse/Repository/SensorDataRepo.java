package com.anz.greenHouse.Repository;

import com.anz.greenHouse.Model.SensorData;
import com.anz.greenHouse.Service.ServiceImpl.SensorDataService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepo extends JpaRepository<SensorData,Integer>
{

}
