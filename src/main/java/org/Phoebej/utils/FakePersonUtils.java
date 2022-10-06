package org.Phoebej.utils;


import org.Phoebej.entity.PersonInfo;
import org.Phoebej.provinces.ProvinceInfoGenerator;
import org.Phoebej.provinces.Provinces;


import java.sql.Date;
import java.text.ParseException;
import java.util.*;



/**
 * 人员信息生成工具类
 * @author Phoebej
 * @date 2022/9/26
 * @since v0.1.0
 */
public class FakePersonUtils {

    /**
     * 随机生成姓名方法
     * @return 姓名
     */
    public String generateName() {
        return PersonNameGenerator.generateName();
    }

    /**
     * 随机生成性别方法
     *
     * @param genderModel 模式参数：模式0则该方法只会生成male或female；模式1则会多生成unknown
     * @return 性别
     * @throws Exception 模式设置错误异常：当模式设置错误时会抛出模式错误异常
     */
    public String generateGender(int genderModel) throws Exception {
        return PersonGenderGenerator.generateGender(genderModel);
    }

    /**
     * 随机生成生日日期（YY-MM-DD)
     * @return java.sql.Date生日日期
     * @throws ParseException 时间格式化异常
     */
    public Date generateBirthday() throws ParseException {
        return PersonBirthdayGenerator.generateBirthday();

    }
    /**
     * 随机生成身份证号
     *
     * @return 随机身份证号
     * @throws ParseException 时间格式化异常
     */
    public  String generateId() throws Exception {
        return PersonIdGenerator.generateId();
    }

    /**
     * 根据地址、生日、性别生成身份证号
     * @param localId 利用ProvinceInfoGenerator生成
     * @param birthday java.util.Date对象
     * @param gender male或者female
     * @return 身份证号
     */
    public  String generateId(String localId, java.util.Date birthday, String gender) {
        return PersonIdGenerator.generateId(localId, birthday, gender);
    }

    /**
     * 随机生成地址信息
     * @return 随机地址
     */
    public  String generateAddress(){
        return PersonAddressGenerator.generateAddress();
    }

    /**
     * 生成指定省份地址信息
     * @return 随机地址
     */
    public  String generateAddress(ProvinceInfoGenerator pg){
        return PersonAddressGenerator.generateAddress(pg);
    }

    /**
     * 随机生成手机号
     * @return 手机号
     */
    public String generatePhoneNum(){
        return PhoneNumGenerator.generatePhoneNumber();
    }

    /**
     * 随机生成指定运营商号段的手机号
     *
     * @return 手机号
     * @throws Exception 模式错误
     */
    public String generatePhoneNumber(int modelNum) throws Exception {
        return PhoneNumGenerator.generatePhoneNumber(modelNum);
    }


    /**
     * 随机生成指定城市的个人信息Map
     * @param pg ProvinceInfoGenerator对象
     * @param genderModel 个人信息性别生成模式（0 或 1）
     * @return 包含个人信息的Map<String,String>
     * @throws Exception 个人信息性别生成模式错误以及时间格式或错误
     */
    public  Map<String,String> generatePersonInfoMap(ProvinceInfoGenerator pg, int genderModel) throws Exception {
        Map<String,String> personInfo = new LinkedHashMap<>();
        String name = generateName();
        String gender = generateGender(genderModel);
        java.util.Date birthday = generateBirthday();
        String address = generateAddress(pg);
        String phoneNum = generatePhoneNum();
        Map<String,String> infoMap = pg.generateInfo();
        String id =generateId(infoMap.get("id"),birthday,gender);
        personInfo.put("name",name);
        personInfo.put("gender",gender);
        personInfo.put("birthday",birthday.toString());
        personInfo.put("address",address);
        personInfo.put("id",id);
        personInfo.put("phoneNum",phoneNum);
        return personInfo;

    }

    /**
     * 随机生成个人信息Map
     * @param genderModel 个人信息性别生成模式（0 或 1）
     * @return 包含个人信息的Map<String,String>
     * @throws Exception 个人信息性别生成模式错误以及时间格式或错误
     */
    public  Map<String,String> generatePersonInfoMap(int genderModel) throws Exception {
        Random rand = new Random();
        Map<String,String> personInfo = new LinkedHashMap<>();
        String name = generateName();
        String gender = generateGender(genderModel);
        java.util.Date birthday = generateBirthday();
        String phoneNum = generatePhoneNum();
        String address;
        List<ProvinceInfoGenerator> pgList =  Provinces.getProvincesList();
        ProvinceInfoGenerator pg = (ProvinceInfoGenerator) pgList.get(rand.nextInt(pgList.size()));
        Map<String,String> infoMap = pg.generateInfo();
        if(infoMap.get("province").equals(infoMap.get("city"))){
            address = infoMap.get("city")+infoMap.get("district");
        }else{
            address = infoMap.get("province")+infoMap.get("city")+infoMap.get("district");
        }
        String id =generateId(infoMap.get("id"),birthday,gender);
        personInfo.put("name",name);
        personInfo.put("gender",gender);
        personInfo.put("birthday",birthday.toString());
        personInfo.put("address",address+PersonAddressGenerator.generateElseAddress());
        personInfo.put("id",id);
        personInfo.put("phoneNum",phoneNum);
        return personInfo;

    }

    /**
     * 随机生成指定城市的个人信息对象
     * @param pg ProvinceInfoGenerator对象
     * @param genderModel 个人信息性别生成模式（0 或 1）
     * @return 包含个人信息的PersonInfo对象
     * @throws Exception 个人信息性别生成模式错误以及时间格式或错误
     */
    public  PersonInfo generatePersonInfoObject(ProvinceInfoGenerator pg, int genderModel) throws Exception {
        PersonInfo personInfo = new PersonInfo();
        String name = generateName();
        String gender = generateGender(genderModel);
        java.sql.Date birthday = generateBirthday();
        String address = generateAddress(pg);
        String phoneNum = generatePhoneNum();
        Map<String,String> infoMap = pg.generateInfo();
        String id =generateId(infoMap.get("id"),birthday,gender);
        personInfo.setName(name);
        personInfo.setGender(gender);
        personInfo.setAddress(address);
        personInfo.setBirthDate(birthday);
        personInfo.setId(id);
        personInfo.setPhoneNum(phoneNum);
        return personInfo;

    }

    /**
     * 随机生成个人信息对象
     * @param genderModel 个人信息性别生成模式（0 或 1）
     * @return 包含个人信息的PersonInfo对象
     * @throws Exception 个人信息性别生成模式错误以及时间格式或错误
     */
    public  PersonInfo generatePersonInfoObject(int genderModel) throws Exception {
        Random rand = new Random();
        PersonInfo personInfo = new PersonInfo();
        String name = generateName();
        String gender = generateGender(genderModel);
        java.sql.Date birthday = generateBirthday();
        String phoneNum = generatePhoneNum();
        String address = null;
        List<ProvinceInfoGenerator> pgList =  Provinces.getProvincesList();
        ProvinceInfoGenerator pg = (ProvinceInfoGenerator) pgList.get(rand.nextInt(pgList.size()));
        Map<String,String> infoMap = pg.generateInfo();
        if(infoMap.get("province").equals(infoMap.get("city"))){
            address = infoMap.get("city")+infoMap.get("district");
        }else{
            address = infoMap.get("province")+infoMap.get("city")+infoMap.get("district");
        }
        String id =generateId(infoMap.get("id"),birthday,gender);
        personInfo.setName(name);
        personInfo.setGender(gender);
        personInfo.setAddress(address+PersonAddressGenerator.generateAddress());
        personInfo.setBirthDate(birthday);
        personInfo.setId(id);
        personInfo.setPhoneNum(phoneNum);
        return personInfo;

    }




}