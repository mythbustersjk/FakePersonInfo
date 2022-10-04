package org.Phoebej.utils;

import org.Phoebej.provinces.ProvinceInfoGenerator;
import org.Phoebej.provinces.Provinces;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

/**
 * 生成人员身份证
 * @author Phoebej
 * @date 2022/10/4
 * @since v0.3.0
 */
public abstract class PersonIdGenerator {
    /**
     * 随机生成身份证号
     *
     * @return 随机身份证号
     * @throws ParseException 时间格式化异常
     */
    public static String generateId() throws Exception {
        String id;
        String[] maleId = new String[]{"0", "2", "4", "6", "8"};
        String[] femaleId = new String[]{"1", "3", "5", "7", "9"};
        // 校验码计算参数
        int[] verificationParameters = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        Random rand = new Random();
        List<ProvinceInfoGenerator> pgList =  Provinces.getProvincesList();
        ProvinceInfoGenerator pg = (ProvinceInfoGenerator) pgList.get(rand.nextInt(pgList.size()));
        // 获取身份证地区码
        String localId = pg.generateInfo().get("id");
        // 获取身份证生日码
        java.util.Date date = PersonBirthdayGenerator.generateBirthday();
        String birthdayId = date.toString().replaceAll("-", "");
        // 获取身份证顺序码
        String orderId = "" + rand.nextInt(10) + rand.nextInt(10);
        //生成性别码
        String genderId;
        String gender = PersonGenderGenerator.generateGender(0);
        if (gender.equals("male")) {
            genderId = maleId[rand.nextInt(maleId.length)];
        } else if (gender.equals("female")) {
            genderId = femaleId[rand.nextInt(femaleId.length)];
        } else {
            genderId = "3";
        }
        //计算最后一位校验码
        char[] idChar = (localId + birthdayId + orderId + genderId).toCharArray();
        int[] tmp = new int[idChar.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = idChar[i] - '0';
        }
        int sum = 0;
        for (int j = 0; j < tmp.length; j++) {
            sum = sum + tmp[j] * verificationParameters[j];
        }
        if (sum % 11 != 10) {
            id = localId + birthdayId + orderId + genderId + (sum % 11);
        } else {
            id = localId + birthdayId + orderId + genderId + "X";
        }

        return id;
    }

    /**
     * 根据地址、生日、性别生成身份证号
     * @param localId 利用ProvinceInfoGenerator生成
     * @param birthday java.util.Date对象
     * @param gender male或者female
     * @return 身份证号
     */
    public static String generateId(String localId, java.util.Date birthday, String gender) {
        String id;
        String[] maleId = new String[]{"0", "2", "4", "6", "8"};
        String[] femaleId = new String[]{"1", "3", "5", "7", "9"};
        // 校验码计算参数
        int[] verificationParameters = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        Random rand = new Random();
        // 获取身份证生日码
        String birthdayId = birthday.toString().replaceAll("-", "");
        // 获取身份证顺序码
        String orderId = "" + rand.nextInt(10) + rand.nextInt(10);
        //生成性别码
        String genderId;
        if (gender.equals("male")) {
            genderId = maleId[rand.nextInt(maleId.length)];
        } else if (gender.equals("female")) {
            genderId = femaleId[rand.nextInt(femaleId.length)];
        } else {
            genderId = "3";
        }
        //计算最后一位校验码
        char[] idChar = (localId + birthdayId + orderId + genderId).toCharArray();
        int[] tmp = new int[idChar.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = idChar[i] - '0';
        }
        int sum = 0;
        for (int j = 0; j < tmp.length; j++) {
            sum = sum + tmp[j] * verificationParameters[j];
        }
        if (sum % 11 != 10) {
            id = localId + birthdayId + orderId + genderId + (sum % 11);
        } else {
            id = localId + birthdayId + orderId + genderId + "X";
        }

        return id;
    }


}
