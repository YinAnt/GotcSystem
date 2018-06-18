package com.ant.server;


import com.ant.DAOImpl.AnnounceDAOImpl;
import com.ant.exception.SqlException;
import com.ant.models.Announce;
import com.ant.util.Tools;

import java.util.List;

public class AnnounceServer {

    public static List<Announce> showAllGuideForTimeDesc() throws SqlException {
        AnnounceDAOImpl announceDAO = new AnnounceDAOImpl();
        List<Announce> list = announceDAO.findAllGuideForTimeDesc();
        return list;
    }

    public static Announce showLastestAnnounceButGuide() throws SqlException {
        AnnounceDAOImpl announceDAO = new AnnounceDAOImpl();
        Announce announce = announceDAO.findLastestAnnounceButGuide();
        return announce;
    }

    public static List<Announce> showAnnounce() throws SqlException {
        AnnounceDAOImpl announceDAO = new AnnounceDAOImpl();
        List<Announce> list = announceDAO.findAllForTimeDesc();
        return list;
    }

    /**
     * 根据流水号查找公告
     *
     * @param announce
     * @return
     * @throws SqlException
     */
    public static Announce showAnnounceByAncNo(Announce announce) throws SqlException {
        AnnounceDAOImpl announceDAO = new AnnounceDAOImpl();
        announce = announceDAO.findAncByAncNo(announce.getAncNo());
        return announce;
    }

    public static void addAnnounce(Announce anc) throws SqlException {
        AnnounceDAOImpl announceDAO = new AnnounceDAOImpl();
        announceDAO.doSave(anc);
    }

    public static void updataAnnounce(Announce anc) throws SqlException {
        AnnounceDAOImpl announceDAO = new AnnounceDAOImpl();
        announceDAO.doUpdate(anc);
    }
}
