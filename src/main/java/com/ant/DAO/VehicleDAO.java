package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Vehicle;

public interface VehicleDAO {
    Vehicle findMinVehicleByNum(Integer num) throws SqlException;
}
