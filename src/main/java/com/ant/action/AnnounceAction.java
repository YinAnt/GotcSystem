package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Announce;
import com.ant.param.Parm;
import com.ant.server.AnnounceServer;
import com.ant.server.AttendanceServer;

import java.util.List;

public class AnnounceAction extends BaseAction {

    private int id;
    private Long ancNo;    // 流水号
    private String ancTitle; // 公告标题
    private Long ancCreateTime; // 创建时间
    private Integer ancPoster; // 发布者
    private String ancPosterName; // 发布者姓名
    private String ancType; // 公告类型
    private String ancContent; // 公告内容

    /**
     * 加载类型为 旅游攻略 的公告
     *
     * @return
     */
    public String showAllGuideForTimeDesc() {
        try {
            List<Announce> list = AnnounceServer.showAllGuideForTimeDesc();
            if (list != null) {
                getResponseMsgMap().clear();
                getResponseMsgMap().put("announce", list);
            } else {
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "No announce !");
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载除了类型为 旅游攻略 以外的最新的公告
     *
     * @return
     */
    public String showLatestAnnounceButGuide() {
        try {
            Announce announce = AnnounceServer.showLastestAnnounceButGuide();
            if (announce != null) {
                getResponseMsgMap().clear();
                getResponseMsgMap().put("announce", announce);
            } else {
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "No announce !");
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 根据流水号加载公告信息
     *
     * @return
     */
    public String showAncByAncNo() {
        System.out.println("showAncByAncNo");
        Announce announce = new Announce();
        announce.setAncNo(ancNo);
        try {
           announce = AnnounceServer.showAnnounceByAncNo(announce);
            if (announce != null) {
                getResponseMsgMap().clear();
                getResponseMsgMap().put("announce", announce);
            } else {
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "No announce !");
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载所有公告信息
     *
     * @return
     */
    public String showAnnounce() {
        System.out.println("showAnnounce");
        try {
            List<Announce> list = AnnounceServer.showAnnounce();
            if (list != null && !list.isEmpty()) {
                getResponseMsgMap().clear();
                getResponseMsgMap().put("announce", list);
            } else {
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "No announce !");
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public String addAnnounce() {
        Announce anc = init();
        System.out.println("*addAnnounce" + anc.toString());
        try {
            AnnounceServer.addAnnounce(anc);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("announce", anc);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    private Announce init() {
        Announce anc = new Announce();
        anc.setAncTitle(ancTitle);
        anc.setAncNo(System.currentTimeMillis());   // 流水号
        anc.setAncCreateTime(System.currentTimeMillis());   // 创建时间
        anc.setAncPoster(ancPoster);
        anc.setAncPosterName(ancPosterName);
        anc.setAncType(ancType);
        anc.setAncContent(ancContent);
        System.out.println("*init" + anc.toString());
        return anc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getAncNo() {
        return ancNo;
    }

    public void setAncNo(Long ancNo) {
        this.ancNo = ancNo;
    }

    public String getAncTitle() {
        return ancTitle;
    }

    public void setAncTitle(String ancTitle) {
        this.ancTitle = ancTitle;
    }

    public Long getAncCreateTime() {
        return ancCreateTime;
    }

    public void setAncCreateTime(Long ancCreateTime) {
        this.ancCreateTime = ancCreateTime;
    }

    public Integer getAncPoster() {
        return ancPoster;
    }

    public void setAncPoster(Integer ancPoster) {
        this.ancPoster = ancPoster;
    }

    public String getAncType() {
        return ancType;
    }

    public void setAncType(String ancType) {
        this.ancType = ancType;
    }

    public String getAncContent() {
        return ancContent;
    }

    public void setAncContent(String ancContent) {
        this.ancContent = ancContent;
    }

    public String getAncPosterName() {
        return ancPosterName;
    }

    public void setAncPosterName(String ancPosterName) {
        this.ancPosterName = ancPosterName;
    }
}
