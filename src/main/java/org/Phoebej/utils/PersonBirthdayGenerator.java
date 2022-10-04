package org.Phoebej.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * 生成人员生日
 * @author Phoebej
 * @date 2022/10/4
 * @since v0.3.0
 */
public abstract class PersonBirthdayGenerator {
    private final static String startDate;
    static {
        startDate = "1970-01-01";
    }

    /**
     * 随机生成生日日期（YY-MM-DD)
     *
     * @return java.sql.Date生日日期
     * @throws ParseException 时间格式化异常
     */
    public static Date generateBirthday() throws ParseException {
        Date randomDate = null;
        SimpleDateFormat sf = new SimpleDateFormat("YY-MM-DD");
        Random rand = new Random();
        long randomLd;
        long tmp = new java.util.Date().getTime() - sf.parse(startDate).getTime();
        boolean year100 = true;
        while (year100) {
            randomLd = (long) (sf.parse(startDate).getTime() + rand.nextFloat() * (tmp + 1));
            if (years(new java.util.Date(randomLd)) < 100 & years(new java.util.Date(randomLd)) > 10) {
                randomDate = new Date(randomLd);
                year100 = false;
            }
        }
        return randomDate;

    }
    /**
     * 计算随机生成的日期与系统当前日期所差年数
     * @param randomDate 随机生成的日期
     * @return 相差年数
     */

    private static int years(java.util.Date randomDate) {
        return (Calendar.getInstance().get(Calendar.YEAR) - (randomDate.getYear() + 1900));

    }
}
