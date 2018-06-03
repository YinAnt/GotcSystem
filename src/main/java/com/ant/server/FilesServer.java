package com.ant.server;

import com.ant.DAOImpl.UploadDAOImpl;
import com.ant.exception.SqlException;
import com.ant.models.Files;
import com.ant.util.Tools;

import java.util.List;

public class FilesServer {

    public static List<Files> showAllFiles() throws SqlException {
        UploadDAOImpl uploadDAO = new UploadDAOImpl();
        List<Files> list = uploadDAO.doFindAll();
        return list;
    }

    public static Files uploadFiles(Files files) throws SqlException {
        UploadDAOImpl uploadDAO = new UploadDAOImpl();
        // 判断是否存在同名文件
        List<Files> list = uploadDAO.doFindAll();
        for (Files f : list) {
            if (Tools.isEquals(f.getFilesName(), files.getFilesName())) {
                throw new SqlException("Files name was exists !");
            }
        }
        if (files != null) {
            uploadDAO.doSave(files);
        }
        return files;
    }

    /**
     * 检查文件名是否重名
     * @param files
     * @return
     * @throws SqlException
     */
    public static Files checkFileName(Files files) throws SqlException {
        UploadDAOImpl uploadDAO = new UploadDAOImpl();
        files = uploadDAO.findFileByFilesName(files.getFilesName());
        return files;
    }
}
