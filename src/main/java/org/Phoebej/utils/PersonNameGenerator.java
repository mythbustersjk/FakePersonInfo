package org.Phoebej.utils;

import org.Phoebej.constant.consist.PersonName;

import java.util.Random;

/**
 * 生成人员姓名
 * @author Phoebej
 * @date 2022/10/4
 * @since v0.3.0
 */
public abstract class PersonNameGenerator {

    /**
     * 随机生成姓名方法
     * @return 姓名
     */
    public static String generateName() {
        String name = null;
        String[] famlyNameArrayOne = PersonName.getFamlyNameArrayOne();
        String[] famlyNameArrayTwo = PersonName.getFamlyNameArrayTwo();
        String[] givenNameArray = PersonName.getGivenNameArray();
        Random rand = new Random();
        int tmp = rand.nextInt(100000);
        if (tmp % 2 == 0) {
            name = famlyNameArrayOne[rand.nextInt(famlyNameArrayOne.length)] + givenNameArray[rand.nextInt(givenNameArray.length)];
        } else {
            name = famlyNameArrayTwo[rand.nextInt(famlyNameArrayOne.length)] + givenNameArray[rand.nextInt(givenNameArray.length)] + givenNameArray[rand.nextInt(givenNameArray.length)];
        }
        return name;
    }
}
