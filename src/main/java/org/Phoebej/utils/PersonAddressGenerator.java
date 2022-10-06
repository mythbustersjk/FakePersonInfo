package org.Phoebej.utils;

import org.Phoebej.constant.consist.PersonName;
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


    public static String generateElseAddress() {
        String tmpAddress=null;
        String[] addressNameArray = PersonName.getGivenNameArray();
        StringBuffer addressBuffer = new StringBuffer();
        String [] tmp = new String[]{"里","苑","府"};
        // 生成小区名称
        for (int i = 0; i < (rand.nextInt(2)+3); i++) {
            addressBuffer.append(addressNameArray[rand.nextInt(addressNameArray.length)]);
        }
        tmpAddress = addressBuffer+ tmp[rand.nextInt(tmp.length)]+(rand.nextInt(20)+1)+"号楼"+(rand.nextInt(8)+1)+"门"+(rand.nextInt(300)+100);
        return tmpAddress;
    }
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
        return address+generateElseAddress();
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
        return address+generateElseAddress();
    }
}
