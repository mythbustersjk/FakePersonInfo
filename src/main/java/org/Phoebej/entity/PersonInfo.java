package org.Phoebej.entity;

import java.sql.Date;

/**
 * 所有承接所生成的人员信息父类
 * @author Phoebej
 * @date 2022/10/2
 * @since v0.2.0
 */
public class PersonInfo {


    private String name;
    private String gender;
    private Date birthDate;
    private String address;
    private String id;
    private String phoneNum;

    public PersonInfo(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
