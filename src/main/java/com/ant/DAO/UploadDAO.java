package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Files;

public interface UploadDAO {
    Files findFileByFilesName(String fileName) throws SqlException;    // 根据文件名查找文件
}
