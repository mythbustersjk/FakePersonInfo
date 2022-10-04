package org.Phoebej.utils;

import java.util.Random;

/**
 * 生成人员性别
 * @author Phoebej
 * @date 2022/10/4
 * @since v0.3.0
 */
public abstract class PersonGenderGenerator {

    /**
     * 随机生成性别方法
     *
     * @param genderModel 模式参数：模式0则该方法只会生成male或female；模式1则会多生成unknown
     * @return 性别
     * @throws Exception 模式设置错误异常：当模式设置错误时会抛出模式错误异常
     */
    public static String generateGender(int genderModel) throws Exception {
        String gender = null;
        int model = genderModel;
        Random rand = new Random();
        if (model == 0 | genderModel == 1) {
            switch (model) {
                case 0:
                    if (rand.nextInt(5) % 2 == 0) {
                        gender = "male";
                    } else {
                        gender = "female";
                    }
                    break;
                case 1:
                    int tmp = rand.nextInt(3);
                    if (tmp == 0) {
                        gender = "male";
                    } else if (tmp == 1) {
                        gender = "female";
                    } else {
                        gender = "unknown";
                    }
                    break;
                default:
                    gender = "unknown";
                    break;
            }


        } else {
            throw new Exception("模式错误");
        }
        return gender;


    }
}
