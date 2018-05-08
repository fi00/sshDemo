package cn.coolwind.ssh.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author coolwind
 */
public class DateUtil {

    /**
     * Date 转换为 String
     * @param date      日期
     * @param format    格式
     * @return Date
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * String 转换为 Date
     * @param date      日期
     * @param format    格式
     * @return String
     * @throws ParseException
     */
    public static Date stringToDate(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    /**
     * 根据指定格式获取当前天
     * @param format    格式
     * @return String
     */
    public static String today(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 获取年
     * @param date 日期
     * @return String
     */
    public static String getYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    /**
     * 获取月
     * @param date 日期
     * @return String
     */
    public static String getMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(date);
    }

    /**
     * 获取日
     * @param date 日期
     * @return String
     */
    public static String getDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(date);
    }

    /**
     * 获取几天后的日期
     * @param date  日期
     * @param day   天数
     * @return Date
     */
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 获取该月的第一天
     * @param date 日期
     * @return Date
     */
    public static Date monthFirstDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 判断是否是工作日
     * @param date 日期
     * @return true/false
     */
    public static boolean isWorkdate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Date date = addDay(new Date(), -2);
        System.out.println(date);
        System.out.println(isWorkdate(date));
    }

}
