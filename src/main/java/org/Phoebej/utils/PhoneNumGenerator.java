package org.Phoebej.utils;

import org.Phoebej.constant.consist.PhoneNum;

import java.util.HashMap;
import java.util.Random;

/**
 * 生成人员手机号
 * @author Phoebej
 * @date 2022/10/4
 * @since v0.3.0
 */
public abstract class PhoneNumGenerator {
    private static final Random rand = new Random();
    private static final int phoneNumberLength = 11;
    private static HashMap<String, String[]> phoneNumberMap = new HashMap<String, String[]>();
    private static String[] tmpPhoneNumbersArray;

    static {
        phoneNumberMap = PhoneNum.getPhoneNumber();
    }

    /**
     * 手机号生成主方法
     * @param phoneNumbersArray 运营商号段列表
     * @return 随机手机号
     */
    private static String createPhoneNum(String[] phoneNumbersArray){
        StringBuilder phBody = new StringBuilder();
        // 获取手机头3-4位
        String phHead = phoneNumbersArray[rand.nextInt(phoneNumbersArray.length)];
        // 计算剩余需要生成的位数
        int tmp = phoneNumberLength - phHead.length();
        // 生成剩余位数的手机号
        for(int i = 0; i < tmp; i++){
            phBody.append(String.valueOf(rand.nextInt(10)));
        }
        return (phHead + phBody);
    }

    /**
     * 随机生成各运营商手机号
     * @return 随机手机号
     */
    public static String generatePhoneNumber(){
        String phoneNumber = null;
        String[] operators = new String[]{"cmcc","cucc","ctcc","cbn"};
        tmpPhoneNumbersArray = phoneNumberMap.get(operators[rand.nextInt(operators.length)]);
        phoneNumber = createPhoneNum(tmpPhoneNumbersArray);
        return phoneNumber;
    }

    /**
     * 随机生成指定运营商号段的手机号
     * @param modelNum 指定运营商
     * @return 指定运营商号段的手机号
     * @throws Exception 模式错误
     */
    public static String generatePhoneNumber (int modelNum) throws Exception {
        String phoneNumber = null;
        switch (modelNum){
            case 0:
                tmpPhoneNumbersArray = phoneNumberMap.get("cmcc");
                phoneNumber = createPhoneNum(tmpPhoneNumbersArray);
                break;
            case 1:
                tmpPhoneNumbersArray = phoneNumberMap.get("cucc");
                phoneNumber = createPhoneNum(tmpPhoneNumbersArray);
                break;
            case 2:
                tmpPhoneNumbersArray = phoneNumberMap.get("ctcc");
                phoneNumber = createPhoneNum(tmpPhoneNumbersArray);
                break;
            case 3:
                tmpPhoneNumbersArray = phoneNumberMap.get("cbn");
                phoneNumber = createPhoneNum(tmpPhoneNumbersArray);
                break;
            default:
                throw new Exception("模式错误");
        }

        return phoneNumber;
    }
}
