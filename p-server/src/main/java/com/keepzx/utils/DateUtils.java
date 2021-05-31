package com.keepzx.utils;

import com.keepzx.constant.DateRange;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static Logger logger = Logger.getLogger(DateUtils.class);
    private static final long ONE_DAY_MILLISECONDS = 24 * 60 * 60 * 1000;
    public static final String DEFAULT_DATE_ALL_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DAY_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_ALL_PATTERN = "HH:mm:ss";
    public static final String CRON_TIME_ALL_PATTERN = "ss mm HH dd * ? yyyy";
    public static final String DATE_NUMBER_PATTERN = "yyyyMMdd";

    /**
     * 格式:yyyyMMdd
     */
    public static final FastDateFormat DATE_NUMBER_FORMAT = FastDateFormat.getInstance(DATE_NUMBER_PATTERN);
    public static final FastDateFormat DATE_DEFAULT_FORMAT = FastDateFormat.getInstance(DEFAULT_DATE_ALL_PATTERN);

    public static Date parseDate(String str, String pattern) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        Date dt = null;
        DateFormat dtFmt = new SimpleDateFormat(pattern, Locale.US);
        try {
            new Date();
            dt = new Date(dtFmt.parse(str).getTime());
        } catch (Exception ex) {
            logger.error(str);
            logger.error("Parser Exception: Invalid Date or pattern!");
        }
        return dt;
    }

    public static String getDefaultFormatDateStr(Date date) {
        return getFormatDateStr(date, DEFAULT_TIME_ALL_PATTERN);
    }

    public static String getFormatDateStr(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        DateFormat dtFmt = new SimpleDateFormat(pattern, Locale.US);
        return dtFmt.format(date);
    }

    public static Calendar getOffsetDateForGivenDate(Date givenDate, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.add(Calendar.DATE, offset);
        return cal;
    }

    public static Calendar getOffsetMinuteForGivenDate(Date givenDate, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.add(Calendar.MINUTE, offset);
        return cal;
    }

    public static Calendar getOffsetDayForGivenDate(Date givenDate, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.add(Calendar.DATE, offset);
        return cal;
    }

    public static long convertTimeStamp(Date date) {
        if (date == null) {
            return 0;
        }
        return date.getTime() / 1000;
    }

    public static Date convertDate(long millSec) {
        return new Date(millSec * 1000);
    }

    public static String getDateStrByFormat(Date date, String format) {
        if (date == null)
            return "";
        DateFormat dtFmt = new SimpleDateFormat(format);
        return dtFmt.format(date);
    }

    public static Date getDateByFormat(String date, String format) {
        if (date == null) {
            return null;
        }
        format = StringUtils.isEmpty(format) ? DEFAULT_DATE_ALL_PATTERN : format;
        DateFormat dtFmt = new SimpleDateFormat(format);
        Date dateTime = null;
        try {
            dateTime = dtFmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    public static Integer getAge(Date birthday) {
        if (birthday == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int yearNow = calendar.get(Calendar.YEAR);
        calendar.setTime(birthday);
        int yearBirth = calendar.get(Calendar.YEAR);
        if (yearNow - yearBirth < 0) {
            return null;
        }
        return yearNow - yearBirth;
    }

    public static boolean isToday(Date date) {
        // 当前时间
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        //获取今天的日期
        String nowDay = sf.format(now);
        //对比的时间
        String day = sf.format(date);
        return day.equals(nowDay);
    }

    public static Date getTodayStartTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date getTodayEndTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DAY_PATTERN);
        try {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
        } catch (ParseException e) {
            logger.error("Parser Exception: Invalid Date or pattern!");
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int daysBetween2(Date smdate, Date bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_ALL_PATTERN);
        try {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
        } catch (ParseException e) {
            logger.error("Parser Exception: Invalid Date or pattern!");
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 至少返回1天,不考虑负数情况
     *
     * @param smdate
     * @param bdate
     * @return
     */
    public static int daysBetweenAtLeastOneDay(Date smdate, Date bdate) {
        int i = daysBetween(smdate, bdate) + 1;
        return i > 0 ? i : 1;

    }

    /**
     * 添加指定的天并设置时间全部为0
     *
     * @param date 时间
     * @param day  天
     */
    public static Date addDayAndSetZero(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date plusDay(Date date, int... days) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        for (int day : days) {
            ca.add(Calendar.DATE, day);
        }
        return ca.getTime();
    }


    /**
     * 通过时间秒毫秒数判断两个时间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }


    public static int differentDaysByMillisecond2(Date date1, Date date2) {
        return (int) Math.ceil((date2.getTime() - date1.getTime()) / (double) (1000 * 3600 * 24));

    }

    public static Date getNowMinuteDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getLastMinuteDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -1);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    public static String getMinuteDateStr(Date date) {
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }


    public static Date getMonthStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 得到指定月开始时间
     *
     * @param month 指定的月
     * @return
     */
    public static Date getMonthStartDate(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getMonthEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));

        Date date2 = calendar.getTime();
        Date now = new Date();
        if (date2.after(now)) {
            return getTodayEndTime(now);
        }
        return date2;
    }


    /**
     * 得到指定月开始时间
     *
     * @param month 指定的月
     * @return
     */
    public static Date getMonthEndDate(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date addDate(Date date, int day) {
        if (date == null) {
            return null;
        }
        Calendar cd = Calendar.getInstance();
        cd.clear();
        cd.setTime(date);
        cd.add(Calendar.DATE, day);//增加一天
        Date date2 = cd.getTime();
        return date2;
    }

    /**
     * date1 与 date2 是否跨月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isCrossMonth(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        return c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH);
    }


    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;//每天毫秒数

        long nh = 1000 * 60 * 60;//每小时毫秒数

        long nm = 1000 * 60;//每分钟毫秒数

        long mm = 1000;

        long diff = endDate.getTime() - nowDate.getTime(); // 获得两个时间的毫秒时间差异

        long day = diff / nd;   // 计算差多少天

        long hour = diff % nd / nh; // 计算差多少小时

        long min = diff % nd % nh / nm;  // 计算差多少分钟

        long sec = diff % nd % nh % nm / mm;  // 计算差多少秒

        return day + "天" + hour + "小时" + min + "分钟" + sec + "秒";

    }

    private static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

    public static int getAge(String birthday) {
        int age = 0;
        try {
            SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DAY_PATTERN);
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(format.parse(birthday));

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR) && age != 0) {
                    age -= 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }


    public static int getWeekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(4);
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        if(month==0 && week>=52 ){
            --year;
        }
        if(month==11 && week==1 ){
            ++year;
        }
        return year * 100 + week;
    }

    /**
     * 根据当前周获取时间范围
     *
     * @param currentWeek 周 202001
     */
    public static DateRange getWeekDays(Integer currentWeek) {
        int year = currentWeek / 100;
        int week = currentWeek % 100;

        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(4);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        cal.set(Calendar.MILLISECOND, 0);
        Date beginDate = getTodayStartTime(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 7);

        Date endDate = getTodayStartTime(cal.getTime());
        return DateRange.createInstanse(beginDate, endDate);
    }

    public static void main(String[] args) {
        DateRange weekDays = getWeekDays(202001);
        System.out.println(weekDays.toString());
    }


    private static void println(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
