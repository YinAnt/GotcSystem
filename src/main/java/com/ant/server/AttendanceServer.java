package com.ant.server;

import com.ant.DAO.SigninDAO;
import com.ant.DAOImpl.EmployeeDAOImpl;
import com.ant.DAOImpl.HolidayDAOImpl;
import com.ant.DAOImpl.JournalDAOImpl;
import com.ant.DAOImpl.SigninDAOImpl;
import com.ant.exception.SqlException;
import com.ant.models.Employee;
import com.ant.models.Holiday;
import com.ant.models.Journal;
import com.ant.models.Signin;
import com.ant.param.State;
import com.ant.util.Tools;
import org.hibernate.dialect.SybaseAnywhereDialect;

import java.util.List;

public class AttendanceServer {

    /**
     * 签到
     * 必备字段：员工号 empNo
     *
     * @param signin
     * @return
     * @throws SqlException
     */
    public static Signin signIn(Signin signin) throws SqlException {
        SigninDAOImpl signinDAO = new SigninDAOImpl();
        if (signin.getSignEmpName().isEmpty() || signin.getSignEmpName() == "") {
            // 根据员工号填写员工名字段
            EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
            Employee emp = employeeDAO.getEmpByEmpNo(signin.getSignEmpNo());
            if (emp != null) {
                signin.setSignEmpName(emp.getEmpName());
            }
        }

        // TODO 签到签退控制
        Signin stmp = signinDAO.doFindByEmpAndSignDay(signin.getSignEmpNo(), signin.getSignInTime()); // 获取该员工当天的签到记录
        if (stmp != null) {
            // 已有记录，不断更新签退时间
            stmp.setSignOutTime(signin.getSignInTime());
            stmp.setSignOutIp(signin.getSignInIp());
            signinDAO.doUpdate(stmp);
        } else {
            // 新签到
            stmp = signin;
            signinDAO.doSave(stmp);
        }
        return stmp;
    }


    /**
     * 根据 工号查询一个人所有的签到记录
     *
     * @param signEmpNo
     * @return
     * @throws SqlException
     */
    public static List<Signin> showAllSignInByEmpNo(Integer signEmpNo) throws SqlException {
        SigninDAOImpl announceDAO = new SigninDAOImpl();
        List<Signin> list = announceDAO.doFindAllByEmpNo(signEmpNo);
        return list;
    }

    /**
     * 根据 工号查询一个人 当月的签到记录
     *
     * @param signEmpNo
     * @return
     * @throws SqlException
     */
    public static List<Signin> showMonthSignInByEmpNo(Integer signEmpNo) throws SqlException {
        SigninDAOImpl announceDAO = new SigninDAOImpl();
        List<Signin> list = announceDAO.doFindMonthSignOutByEmpNo(signEmpNo);
        return list;
    }

    /**
     * 查询所有的签到记录
     *
     * @return
     * @throws SqlException
     */
    public static List<Signin> showAllSignIn() throws SqlException {
        SigninDAOImpl announceDAO = new SigninDAOImpl();
        List<Signin> list = announceDAO.doFindAll();
        return list;
    }

    /**
     * 查询所有的请假记录
     *
     * @return
     * @throws SqlException
     */
    public static List<Holiday> showAllHoliday() throws SqlException {
        HolidayDAOImpl holidayDAO = new HolidayDAOImpl();
        List<Holiday> list = holidayDAO.doFindAll();
        return list;
    }

    /**
     * 根据 工号查询一个人所有的请假记录
     *
     * @param hldEmpNo
     * @return
     * @throws SqlException
     */
    public static List<Holiday> showAllHolidayByEmpNo(Integer hldEmpNo) throws SqlException {
        HolidayDAOImpl holidayDAO = new HolidayDAOImpl();
        List<Holiday> list = holidayDAO.doFindAllByEmpNo(hldEmpNo);
        return list;
    }

    /**
     * 请假
     *
     * @param holiday
     * @return
     * @throws SqlException
     */
    public static Holiday AskForLeave(Holiday holiday) throws SqlException {
        HolidayDAOImpl holidayDAO = new HolidayDAOImpl();
        // 根据工号填写申请人姓名字段
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        Employee emp = employeeDAO.getEmpByEmpNo(holiday.getHldEmpNo());
        holiday.setHldEmpName(emp.getEmpName());
        // 根据工号填写处理人姓名字段
        emp = employeeDAO.getEmpByEmpNo(holiday.getHldHandle());
        holiday.setHldHandleName(emp.getEmpName());
        holidayDAO.doSave(holiday);
        return holiday;
    }


    /**
     * 根据处理人查询请假记录
     *
     * @param hldHandleName
     * @return
     * @throws SqlException
     */
    public static List<Holiday> showMyHandleHoliday(String hldHandleName) throws SqlException {
        HolidayDAOImpl holidayDAO = new HolidayDAOImpl();
        List<Holiday> list = holidayDAO.dofindMyHandleHolidayByEmpNo(hldHandleName);
        return list;
    }

    /**
     * 根据处理人查询 待处理的 请假记录
     *
     * @param hldHandleName
     * @return
     * @throws SqlException
     */
    public static List<Holiday> showWaitForMyHandleHoliday(String hldHandleName) throws SqlException {
        HolidayDAOImpl holidayDAO = new HolidayDAOImpl();
        List<Holiday> list = holidayDAO.dofindWaitForMyHandleHolidayByEmpNo(hldHandleName);
        System.out.println("list server:" + list.toString());
        return list;
    }

    /**
     * 处理请假信息
     *
     * @param h
     * @return
     * @throws SqlException
     */
    public static Holiday handleLeave(Holiday h) throws SqlException {
        HolidayDAOImpl holidayDAO = new HolidayDAOImpl();
        Holiday holiday = holidayDAO.doFindByHldNo(h.getHldNo());
        holiday.setHldResult(h.getHldResult());
        holiday.setHldState(State.HLD_STATE_FINISH); // 设置为已处理
        holiday.setHldHandleTime(System.currentTimeMillis());
        holidayDAO.doUpdate(holiday);
        System.out.println("server:" + holiday.toString());
        return holiday;
    }


    /**
     * 根据员工号统计 当月 到今天为止 的请假天数
     *
     * @return
     */
    public static float calNowLeaveDays(Integer empNo) throws SqlException {
        float days = 0;
        long zoreTime = Tools.getTheSameDayFinal(System.currentTimeMillis()); // 获取今天 24点的毫秒数
        long firstTime = Tools.getMonthFirstDay();   // 获取今天 所在月1号的零点的毫秒数
        long lastTime = Tools.getNextMonthFirstDay();    // 获取今天所在月的 下个月1号的零点的毫秒数
        long end = 0;
        HolidayDAOImpl holidayDAO = new HolidayDAOImpl();
        List<Holiday> list = holidayDAO.doFindMonthByEmpNo(empNo);
        for (Holiday h : list) {
            if (h.getHldState() == State.HLD_STATE_WAIT || (h.getHldState() == State.HLD_STATE_FINISH && h.getHldResult() == State.HLD_FINISH_AGREE)) {
                // 已审批的才计数，未审批或者是不同意的不作数
                continue;
            }
            if (h.getHldStartTime() > zoreTime) {
                // 1 - today - start - end
                System.out.println("1:0天");
            } else if (h.getHldStartTime() >= firstTime) {
                // 1 - start - end - today,1 - start - today - end
                end = h.getHldEndTime() < System.currentTimeMillis() ? h.getHldEndTime() : zoreTime;
                // 计算 开始日期 到 end 之间的天数并累加
                days += Tools.differentDaysByMillisecond(h.getHldStartTime(), end);
                System.out.println("2:" + Tools.differentDaysByMillisecond(h.getHldStartTime(), end) + "天");
            } else {
                // start - 1 - end - today,start - 1 - today - end
                end = h.getHldEndTime() < System.currentTimeMillis() ? h.getHldEndTime() : zoreTime;
                // 计算 1号 到 end 之间的天数并累加
                days += Tools.differentDaysByMillisecond(firstTime, end);
                System.out.println("3:" + Tools.differentDaysByMillisecond(firstTime, end) + "天");
            }
            System.out.println("days:" + days + "," + h.toString());
        }

        return days;
    }

    /**
     * 根据员工号统计 当月 到今天为止 的签到信息（不含签退）
     *
     * @return
     */
    public static int calNowSignInCnt(Integer empNo) throws SqlException {
        int cnt = 0;
        long zoreTime = Tools.getTheSameDayFinal(System.currentTimeMillis()); // 获取今天 24点的毫秒数
        long firstTime = Tools.getMonthFirstDay();   // 获取今天 所在月1号的零点的毫秒数
        SigninDAOImpl signinDAO = new SigninDAOImpl();
        List<Signin> list = signinDAO.doFindAllSignInByEmpNo(empNo);
        System.out.println("sign in:" + list.toString());
        for (Signin s : list) {
            if (s.getSignInTime() >= firstTime && s.getSignInTime() <= zoreTime) {
                cnt++;
                System.out.println("cnt:" + s.toString());
            }
        }
        return cnt;
    }


    /**
     * 根据员工号统计 当月 到今天为止 的签退信息（不含签到）
     *
     * @return
     */
    public static int calNowSignOutCnt(Integer empNo) throws SqlException {
        int cnt = 0;
        long startTime = Tools.getMonthFirstDay();   // 获取今天 所在月1号的零点的毫秒数
        long endTime = Tools.getTheSameDayFinal(System.currentTimeMillis()); // 获取今天 24点的毫秒数
        SigninDAOImpl signinDAO = new SigninDAOImpl();
        List<Signin> list = signinDAO.doFindAllSignOutByEmpNo(empNo);
        System.out.println("sign out:" + list.toString());
        for (Signin s : list) {
            if (s.getSignOutTime() >= startTime && s.getSignOutTime() <= endTime) {
                cnt++;
                System.out.println("cnt:" + s.toString());
            }
        }
        return cnt;
    }


    /**
     * 填写日报
     *
     * @param journal
     * @return
     * @throws SqlException
     */
    public static Journal addJounal(Journal journal) throws SqlException {
        JournalDAOImpl journalDAO = new JournalDAOImpl();
        // 补充填写 员工号或员工名
        if (journal.getJnlEmpNo() == null) {
            EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
            Employee emp = employeeDAO.getEmpByEmpName(journal.getJnlEmpName());
            journal.setJnlEmpNo(emp.getEmpNo());
        } else if (Tools.isEmpty(journal.getJnlEmpName())) {
            EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
            Employee emp = employeeDAO.getEmpByEmpNo(journal.getJnlEmpNo());
            journal.setJnlEmpName(emp.getEmpName());
        }
        // TODO 如果已经写过日报
        journalDAO.doSave(journal);
        return journal;
    }

    /**
     * 返回所有日报记录
     *
     * @return
     * @throws SqlException
     */
    public static List<Journal> showAllJournal() throws SqlException {
        JournalDAOImpl journalDAO = new JournalDAOImpl();
        List<Journal> list = journalDAO.doFindAll();
        return list;
    }

    /**
     * 根据员工名或员工号查询日报记录
     *
     * @param journal
     * @return
     * @throws SqlException
     */
    public static List<Journal> showMyAllJournal(Journal journal) throws SqlException {
        JournalDAOImpl journalDAO = new JournalDAOImpl();
        List<Journal> list = null;
        if (!Tools.isEmpty(journal.getJnlEmpName())) {
            list = journalDAO.doFindJournalByEmpName(journal.getJnlEmpName());
        } else {
            list = journalDAO.doFindJournalByEmpNo(journal.getJnlEmpNo());
        }
        return list;
    }


    /**
     * 根据员工号统计 当月 到今天为止 的日报信息
     *
     * @return
     */
    public static int calNowJournalCnt(Integer empNo) throws SqlException {
        int cnt = 0;
        long firstTime = Tools.getMonthFirstDay();   // 获取今天 所在月1号的0点的毫秒数
        long zoreTime = Tools.getTheSameDayFinal(System.currentTimeMillis()); // 获取今天 24点的毫秒数
        System.out.println("firstTime:" + firstTime + ",zoreTime:" + zoreTime);
        System.out.println("firstTime:" + Tools.formatDateTime(firstTime) + ",zoreTime:" + Tools.formatDateTime(zoreTime));

        JournalDAOImpl journalDAO = new JournalDAOImpl();
        List<Journal> list = journalDAO.doFindJournalByEmpNo(empNo);
        System.out.println("journal:" + list.toString());
        for (Journal j : list) {
            System.out.println("time:" + j.getJnlCreateTime() + ",getJnlCreateTime:" + Tools.formatDateTime(j.getJnlCreateTime()));
            if (j.getJnlCreateTime() >= firstTime && j.getJnlCreateTime() <= zoreTime) {
                cnt++;
                System.out.println("cnt:" + j.toString());
            }
        }
        return cnt;
    }

}
