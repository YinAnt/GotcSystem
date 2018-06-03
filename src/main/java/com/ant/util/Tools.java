package com.ant.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Tools {
    public static final long TIME_SIZE_SECOND = 1000;
    public static final long TIME_SIZE_MIN = 60 * TIME_SIZE_SECOND;
    public static final long TIME_SIZE_HOUR = 60 * TIME_SIZE_MIN;
    public static final long TIME_SIZE_DAY = 24 * TIME_SIZE_HOUR;

    public static boolean isEmpty(String s) {
        if (null == s)
            return true;
        if (s.length() == 0)
            return true;
        if (s.trim().length() == 0)
            return true;
        return false;
    }

    public static boolean isEquals(Object a, Object b) {
        if (a == null || b == null) {
            return false; //注意 都为null时还是不相等
        }
        return a.equals(b);
    }

    public static String formatDateTime(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(time));
    }

    public static String formatTime(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date(time));
    }

    public static String formatDate(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date(time));
    }

    /**
     * 比较两毫秒数相差的天数
     *
     * @param ms1
     * @param ms2
     * @return
     */
    public static float differentDaysByMillisecond(final long ms1, final long ms2) {
        if (ms1 == 0 || ms2 == 0) {
            return 0;
        }
        if (ms1 > ms2) {
            return (float) (ms1 - ms2) / TIME_SIZE_DAY;
        } else {
            return (float) (ms2 - ms1) / TIME_SIZE_DAY;
        }
    }

    /**
     * 毫秒数判断是否是同一天
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isSameDay(long time1, long time2) {
        return isSameDay(new Date(time1), new Date(time2));
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }


    /**
     * 获取当天零点的毫秒数
     *
     * @param time
     * @return
     */
    public static long getTheSameDayZore(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateFormat.format(new Date(time)));
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取当天的 第二天的零点的毫秒数
     *
     * @param time
     * @return
     */
    public static long getTheSameDayFinal(long time) {
        time = time + TIME_SIZE_DAY;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateFormat.format(new Date(time)));
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取当月1号的零点的毫秒数
     *
     * @return
     */
    public static long getMonthFirstDay() {
        System.out.println("getMonthFirstDay:");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);  // Calendar生成的begin毫秒位不是0，需要手动初始化
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.HOUR,24);  // 在中国上海时间11:00-12:00时 获取当月1号的零点的毫秒数:2018-05-31 12:00:00。原因，接近0点（24点）时无法判断
        calendar.set(Calendar.DATE, 1);
        long time = calendar.getTimeInMillis();
        System.out.println("获取当月1号的零点的毫秒数:" + Tools.formatDateTime(time));
        return time;
    }

    /**
     * 获取当月1号的零点的毫秒数
     *
     * @return
     */
    public static long getMonthFirstDay(long datetime) {
        System.out.println("getMonthFirstDay(long):");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(datetime);
        calendar.set(Calendar.MILLISECOND, 0);  // Calendar生成的begin毫秒位不是0，需要手动初始化
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.HOUR,24);  // 在中国上海时间11:00-12:00时 获取当月1号的零点的毫秒数:2018-05-31 12:00:00。原因，接近0点（24点）时无法判断
        calendar.set(Calendar.DATE, 1);
        long time = calendar.getTimeInMillis();
        System.out.println("获取当月1号的零点的毫秒数:" + Tools.formatDateTime(time));
        return time;
    }

    /**
     * 获取下个月1号的零点的毫秒数
     *
     * @return
     */
    public static long getNextMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR, 12);
//        calendar.set(Calendar.HOUR,24);  // 在中国上海时间11:00-12:00时 获取当月1号的零点的毫秒数:2018-05-31 12:00:00。原因，接近0点（24点）时无法判断
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);  // Calendar生成的begin毫秒位不是0，需要手动初始化
        long time = calendar.getTimeInMillis();
        System.out.println("获取下个月1号的零点的毫秒数:" + Tools.formatDateTime(time));
        return time;
    }

    /**
     * 返回现在是当月的第几天
     *
     * @return
     */
    public static int getMonthDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

}

