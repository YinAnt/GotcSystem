package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Announce;

import java.util.List;

public interface AnnounceDAO{
    List<Announce> findAllForTimeDesc() throws SqlException;
    List<Announce> findAllGuideForTimeDesc() throws SqlException;   // 加载所有 旅游攻略 类型的公告
    Announce findLastestAnnounceButGuide() throws SqlException; // 返回除了类型为“旅游攻略”的最新公告
}
