package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Scenic;

public interface ScenicDAO {
    Scenic doFindOrderByScnNo(Integer scnNo) throws SqlException; // 根据编号查询
}
