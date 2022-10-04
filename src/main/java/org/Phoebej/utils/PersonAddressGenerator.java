package org.Phoebej.utils;

import org.Phoebej.provinces.ProvinceInfoGenerator;
import org.Phoebej.provinces.Provinces;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 生成人员信息
 * @author Phoebej
 * @date 2022/10/4
 * @since v0.3.0
 */
public abstract class PersonAddressGenerator {
    private static Random rand = new Random();
    private static String address;
    /**
     * 随机生成地址信息
     * @return 随机地址
     */
    public static String generateAddress(){
        List<ProvinceInfoGenerator> pgList =  Provinces.getProvincesList();
        ProvinceInfoGenerator pg = (ProvinceInfoGenerator) pgList.get(rand.nextInt(pgList.size()));
        Map<String,String> infoMap = pg.generateInfo();
        if(infoMap.get("province").equals(infoMap.get("city"))){
            address = infoMap.get("city")+infoMap.get("district");
        }else{
            address = infoMap.get("province")+infoMap.get("city")+infoMap.get("district");
        }
        return address;
    }

    /**
     * 生成指定省份地址信息
     * @return 随机地址
     */
    public static String generateAddress(ProvinceInfoGenerator pg){
        Map<String,String> infoMap = pg.generateInfo();
        if(infoMap.get("province").equals(infoMap.get("city"))){
            address = infoMap.get("city")+infoMap.get("district");
        }else{
            address = infoMap.get("province")+infoMap.get("city")+infoMap.get("district");
        }
        return address;
    }
}
