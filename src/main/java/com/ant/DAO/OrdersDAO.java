package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Orders;

import java.util.List;

public interface OrdersDAO {
    List<Orders> doFindAllDesc() throws SqlException; // 查询所有订单记录（时间降序）
    List<Orders> doFindHldedDesc() throws SqlException; // 查询所有 已处理的  订单记录（时间降序）
    List<Orders> doFindWaitAllDesc() throws SqlException; // 查询所有 待处理 订单记录（时间降序）
    List<Orders> doFindMonthWaitAllDesc() throws SqlException; // 查询 本月 所有 待处理 订单记录（时间降序）
    List<Orders> doFindMonthHldedAllDesc() throws SqlException; // 查询 本月 所有 已处理 订单记录（时间降序）
    Orders doFindOrderByOrdNo(Long ordNo) throws SqlException; // 根据订单号查询订单
    List<Orders> doFindOrdByUserNameDesc(String userName) throws SqlException; // 根据用户名查询名下所有订单（时间降序）
    Orders setOrdAgentByOrdNo(Long ordNo,Integer ordAgentNo,String ordAgentName) throws SqlException; // 为订单设置导游
    Orders freshTotalPay(Long ordNo,float pay) throws SqlException; // 为订单设置总价
    Orders setOrdHlded(Long ordNo) throws SqlException; // 设置订单为已处理状态
    Orders setOrdPayed(Long ordNo) throws SqlException; // 设置订单为已付款状态
}
