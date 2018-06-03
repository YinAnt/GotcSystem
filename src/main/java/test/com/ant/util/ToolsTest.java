package test.com.ant.util;

import com.ant.util.Tools;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.util.Calendar;

/**
 * Tools Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>06/03/2018</pre>
 */
public class ToolsTest extends TestCase {
    public ToolsTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: isEmpty(String s)
     */
    public void testIsEmpty() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: isEquals(Object a, Object b)
     */
    public void testIsEquals() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: formatDateTime(long time)
     */
    public void testFormatDateTime() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: formatTime(long time)
     */
    public void testFormatTime() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: formatDate(long time)
     */
    public void testFormatDate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: differentDaysByMillisecond(final long ms1, final long ms2)
     */
    public void testDifferentDaysByMillisecond() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: isSameDay(long time1, long time2)
     */
    public void testIsSameDayForTime1Time2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: isSameDay(Date date1, Date date2)
     */
    public void testIsSameDayForDate1Date2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: isSameDay(Calendar cal1, Calendar cal2)
     */
    public void testIsSameDayForCal1Cal2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getTheSameDayZore(long time)
     */
    public void testGetTheSameDayZore() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getTheSameDayFinal(long time)
     */
    public void testGetTheSameDayFinal() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getMonthFirstDay()
     */
    public void testGetMonthFirstDay() throws Exception {
//TODO: Test goes here...
        System.out.println("测试2");
        long now = System.currentTimeMillis();
        for (int i = 0; i < 120; i++) {
            System.out.println("i=" + i + ",now:" + Tools.formatDateTime(now - i * 15 * 60 * 1000));
            Tools.getMonthFirstDay(now - i * 15 * 60 * 1000);
        }
    }

    /**
     * Method: getNextMonthFirstDay()
     */
    public void testGetNextMonthFirstDay() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: getMonthDay()
     */
    public void testGetMonthDay() throws Exception {
//TODO: Test goes here... 
    }


    public static Test suite() {
        return new TestSuite(ToolsTest.class);
    }
} 
