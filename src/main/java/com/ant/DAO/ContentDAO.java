package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Content;

import java.util.List;

public interface ContentDAO {
    List<Content> doFindAllByOrdNo(Long contOrdNo) throws SqlException; // 根据订单号查询所有订单内容

    List<Content> doFindAllWaitByOrdNo(Long contOrdNo) throws SqlException; // 根据订单号查询所有待处理订单内容

    List<Content> doFindAllWait() throws SqlException; // 查询所有待处理订单内容

    List<Content> doFindAllWaitForScn() throws SqlException; // 查询所有待处理订单内容（景区）

    List<Content> doFindAllWaitForHtl() throws SqlException; // 查询所有待处理订单内容（酒店）

    List<Content> doFindAllWaitForVhc() throws SqlException; // 查询所有待处理订单内容（车辆）

    void doChangeStateForScn(String contScnName, Long contScnDate) throws SqlException; // 预定门票

    void doChangeStateForHtl(Content content) throws SqlException; // 预定酒店

    void doChangeStateForVhc(Content content) throws SqlException; // 分配车辆

    List<Content> showAllFinishContent() throws SqlException; // 加载所有已处理的订单内容
}
