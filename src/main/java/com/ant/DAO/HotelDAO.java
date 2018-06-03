package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Hotel;

public interface HotelDAO {
    Hotel doFindOrderByHtlNo(Integer htlNo) throws SqlException; // 根据编号查询
}
