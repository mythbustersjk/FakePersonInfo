package org.Phoebej.provinces;

import java.util.Map;

/**
 * 所有省份类的父类，定义子类中需要初始化的成员属性
 * @author Phoebej
 * @date 2022/10/1
 */
public abstract class ProvincesInfo {
    /*
    省份信息
     */
    // 省份名称
    static String provinceName;
    // 省份内包含的城市名称
    static String[] cityName;
    // 城市对应的区名称
    static Map<String,String[]> districtName;
    // 区对应的街道名称
    // static Map<String,String[]> blockName;
    /*
    身份证号地址码信息
     */
    // 省份名称对应代码
    static Integer provinceId;
    // 城市名称对应的代码
    static Map<String,String> cityId;
    // 区所对应的代码
    static Map<String,String> districtId;

}
