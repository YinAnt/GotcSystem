package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Employee;
import com.ant.models.Files;
import com.ant.param.Parm;
import com.ant.server.FilesServer;
import com.ant.util.Tools;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.List;

public class FilisAction extends BaseAction{

//    在jsp中上传 file字段对应的name是"doc"，所以在action中，必须准备3个属性， 属性名字不能使用其他的，必须基于“doc”
//    File doc; // 文件对象
//    String docFileName;   // 文件名
//    String docContentType; // 类型

    private File doc;// 文件对象(存放路径)
    private String docFileName;// 文件名（文件名）
    private String docContentType;// 类型（文件类型）
    private String filesTitle; // 标题
    private String filesDescribe; // 描述
    private Integer filesPoster; // 发布者
    private Long filesTime; // 发布时间

    private String savePath; // 指定文件保存的相对路径
    private String fn;  // 表示指定下载的文件
    private String tip; // 上传的tip提示文件名是否重复

    /**
     * 检查是否重名
     * @return
     */
    public String checkFileName(){
        System.out.println("checkFileName()");
        Files files = init();
        try {
            files = FilesServer.checkFileName(files);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("files", files);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 下载文件
     * @return
     */
    public String downloadFiles(){
        System.out.println("downloadFiles()");
        if (!Tools.isEmpty(fn)){
            File file = new File(getSavePath()+File.separator+getFn());
            if (!file.exists()){
                return ERROR;
            }
        }else {
            return ERROR;
        }
        return SUCCESS;
    }


    public InputStream getFileInputStream() throws Exception {
        //获得路径和文件名
        String file = getSavePath() + File.separator + getFn();
        System.out.println("downloadFile ="+file);
//        return ServletActionContext.getServletContext().getResourceAsStream(file);
        InputStream is = new FileInputStream(file);
        return is;

    }

    /**
     * 上传文件
     * @return
     */
    public String uploadFiles(){
        System.out.println("upload");
        System.out.println("doc" + doc);
        System.out.println("filename" + docFileName);
        System.out.println("content type" + docContentType);
        System.out.println("savePath" + savePath);

        // 文件缓存不处理的话会被删除掉
        // 缓存被删除之前，手动保存文件至指定路径 savePath
        // 不会上传同名文件

        Files f = init();
        Files files = init();

        // TODO 检查同名文件
        try {
            f = FilesServer.checkFileName(files);
            if (f != null){
                // 文件重名
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "文件名已重复");
//                return ERROR;
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
//            return ERROR;
        }

        // TODO 判断文件大小？
        File filePath = new File(getSavePath());
        if(!filePath.exists()){
            filePath.mkdirs();//若文件不存在，则创建
        }
        File saveFile = null;
        try {
            saveFile = new File(filePath,getDocFileName()); // 路径
            FileOutputStream  fos = new FileOutputStream(saveFile);
            FileInputStream fis=new FileInputStream(getDoc());  // 缓存文件
            byte[] buffer = new byte[1024];
            int len = 0;
            while( (len = fis.read(buffer) ) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            if (saveFile.exists()){
                saveFile.delete();
                saveFile = null;
            }
        }

        // 保存相关信息至数据库
        if (saveFile != null){
            files.setFilesPath(getSavePath());  // 路径
            try {
                files = FilesServer.uploadFiles(files);
                getResponseMsgMap().clear();
                getResponseMsgMap().put("files", files);
            } catch (SqlException e) {
                e.printStackTrace();
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
//                return ERROR;
            }
        }
        return  SUCCESS;
    }

    public String showAllFiles() {
        try {
            List<Files> list = FilesServer.showAllFiles();
            if (list!=null && !list.isEmpty()) {
                getResponseMsgMap().clear();
                getResponseMsgMap().put("files",list);
            }else {
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "No files !");
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    private Files init(){
        Files files = new Files();
        Employee emp = (Employee) ServletActionContext.getContext().getSession().get("employee");
        if (emp != null){
            files.setFilesPoster(emp.getEmpNo());
            files.setFilesPosterName(emp.getEmpName());
        }
        files.setFilesTitle(getFilesTitle());
        files.setFilesDescribe(getFilesDescribe());
        files.setFilesName(docFileName);
        files.setFilesType(docContentType);
        files.setFilesTime(System.currentTimeMillis());
        System.out.println("init:"+files);
        return files;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        // 处理中文问题
        this.fn = fn;
        if(fn != null){
            try {
                this.fn = new String(fn.getBytes(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public String getSavePath(){
        return ServletActionContext.getServletContext()
                .getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public File getDoc() {
        return doc;
    }

    public void setDoc(File doc) {
        this.doc = doc;
    }

    public String getDocFileName() {
        return docFileName;
    }

    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }

    public String getDocContentType() {
        return docContentType;
    }

    public void setDocContentType(String docContentType) {
        this.docContentType = docContentType;
    }

    public String getFilesDescribe() {
        return filesDescribe;
    }

    public void setFilesDescribe(String filesDescribe) {
        this.filesDescribe = filesDescribe;
    }

    public Integer getFilesPoster() {
        return filesPoster;
    }

    public void setFilesPoster(Integer filesPoster) {
        this.filesPoster = filesPoster;
    }



    public String getFilesTitle() {
        return filesTitle;
    }

    public void setFilesTitle(String filesTitle) {
        this.filesTitle = filesTitle;
    }

    public Long getFilesTime() {
        return filesTime;
    }

    public void setFilesTime(Long filesTime) {
        this.filesTime = filesTime;
    }


}
