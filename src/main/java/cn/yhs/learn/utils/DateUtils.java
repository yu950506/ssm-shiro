package cn.yhs.learn.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.utils.DateUtils
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 15:15
 * @Description: todo
 **/
public class DateUtils {
    /**
     * 指定格式类型，将日期对象格式化成字符串形式
     *
     * @param source 日期格式
     * @param pattern 指定格式化的日期 比如：“yyy-MM-dd HH:mm:ss”
     * @return
     */
    public static String parseString(Date source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(source);
    }

    /**
     * 将日期对象格式化成字符串形式，默认yyy-MM-dd HH:mm:ss
     *
     * @param source 日期格式，默认“yyy-MM-dd HH:mm:ss”
     * @return
     */
    public static String parseString(Date source) {
        return parseString(source, "yyy-MM-dd HH:mm:ss");
    }

    public static void main(String[] args) {
        System.out.println(parseString(new Date()));
    }

}
