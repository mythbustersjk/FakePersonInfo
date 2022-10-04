package org.Phoebej.provinces;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Phoebej
 * @date 2022/10/3
 * @since v0.2.0
 */
public class BeiJing extends ProvincesInfo implements ProvinceInfoGenerator{
    private static String provinceName;
    // 省份内包含的城市名称
    private static String[] cityName;
    // 城市对应的区名称
    private static LinkedHashMap<String,String[]> districtName = new LinkedHashMap<>();
    // 区对应的街道名称
    // static Map<String,String[]> blockName;
    /*
    身份证号地址码信息
     */
    // 省份名称对应代码
    private static Integer provinceId;
    // 城市名称对应的代码
    private static LinkedHashMap<String,String> cityId = new LinkedHashMap<>();
    // 区所对应的代码
    private static LinkedHashMap<String,String> districtId = new LinkedHashMap<>();
    static{
        provinceName = "北京市";
        cityName = new String[]{"北京市"};
        districtName.put("北京市",new String[]{"东城区","西城区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区"
                            ,"通州区","顺义区","昌平区","大兴区","怀柔区","平谷区","密云区","延庆区"});
        provinceId = 11;
        cityId.put("北京市","01");
        districtId.put("东城区","01");
        districtId.put("西城区","02");
        districtId.put("朝阳区","05");
        districtId.put("丰台区","06");
        districtId.put("石景山区","07");
        districtId.put("海淀区","08");
        districtId.put("门头沟区","09");
        districtId.put("房山区","11");
        districtId.put("通州区","12");
        districtId.put("顺义区","13");
        districtId.put("昌平区","14");
        districtId.put("大兴区","15");
        districtId.put("怀柔区","16");
        districtId.put("平谷区","17");
        districtId.put("密云区","18");
        districtId.put("延庆区","19");

    }

    @Override
    public Map<String, String> generateInfo() {
        Map<String,String> info = new HashMap<>();
        Random rand = new Random();
        String city = cityName[rand.nextInt(cityName.length)];
        String district = districtName.get(city)[rand.nextInt(districtName.get(city).length)];
        String id = provinceId+cityId.get(city)+districtId.get(district);
        info.put("province",provinceName);
        info.put("city",city);
        info.put("district",district);
        info.put("id",id);
        return info;
    }
}
