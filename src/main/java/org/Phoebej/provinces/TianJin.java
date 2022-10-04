package org.Phoebej.provinces;

import java.util.*;

/**
 * 天津市城市信息类
 * @author Phoebej
 * @date 2022/9/28
 * @since v0.1.0
 */
public class TianJin extends ProvincesInfo implements ProvinceInfoGenerator {
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

    static {
        provinceName = "天津市";
        cityName = new String[]{"天津市"};
        districtName.put("天津市",new String[]{"和平区","河东区","河西区","南开区","河北区","红桥区","滨海新区","东丽区","西青区","津南区","北辰区","武清区","宝坻区","宁河区","静海区","蓟州区"});
        /*
        blockName = new HashMap<>();
        blockName.put("和平区", new String[] {"劝业场街","小白楼街","五大道街","新兴街","南营门街","南市街"});
        blockName.put("河东区", new String[] {"大王庄街","大直沽街","中山门街","富民路街","二号桥街","春华街","唐家口街","向阳楼街","常州道街","上杭路街","东新街","鲁山道街","天津铁厂街"});
        blockName.put("河西区",
                new String[] {"大营门街","下瓦房街","桃园街","挂甲寺街","马场街","越秀路街","友谊路街","天塔街","尖山街","陈塘庄街",
                                "柳林街","东海街","梅江街","太湖路街"}
                );

         */
        provinceId = 12;
        cityId.put("天津市","01");
        districtId.put("和平区","01");
        districtId.put("河东区","02");
        districtId.put("河西区","03");
        districtId.put("南开区","04");
        districtId.put("河北区","05");
        districtId.put("红桥区","06");
        districtId.put("滨海新区","16");
        districtId.put("东丽区","10");
        districtId.put("西青区","11");
        districtId.put("津南区","12");
        districtId.put("北辰区","13");
        districtId.put("武清区","14");
        districtId.put("宝坻区","15");
        districtId.put("宁河区","17");
        districtId.put("静海区","18");
        districtId.put("蓟州区","19");
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
