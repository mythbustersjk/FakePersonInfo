# FakePersonInfo
本项目用于解决在项目测试中需要生成大量的个人信息数据的业务场景。简化数据生成代码量。



## 一、依赖引入

1. 在[[Releases](https://github.com/mythbustersjk/FakePersonInfo/releases)]中下载项目最新Jar包；
2. 在你的工程项目中引入该Jar包。

## 二、如何使用

本工具包所有功能均由**FakePersonUtils**类的中提供的方法实现，该类中主要提供以下方法：

- **generatePersonInfoMap(int genderModel)**

  调用该方法会返回包含个人信息的Map<String,String>

  其中genderModel：包含"0"和"1"

  0：生成的性别为“男”或“女”；

  1：除了“男”或“女”还会生成“unknown”。

  函数返回示例：

  ```java
  {name=齐仪, gender=male, birthday=2007-07-29, address=天津市津南区侵渐核苑10号楼7门169, id=120112200707296343, phoneNum=13297843493}
  ```

  

- **generatePersonInfoObject(int genderModel)**

  调用该方法会返回包含个人信息的PersonInfo对象，该对象中的生日日期已经格式为java.sql.Date，可直接向数据库中导入。因此，如想想数据库中直接导入生成数据建议使用该方法。

  生成对象成员变量示例如下：

  ```java
  ps = {PersonInfo@1789} 
   name = "弓魂多"
   gender = "male"
   birthDate = {Date@1792} "1985-04-05"
   address = "北京市朝阳区北京市密云区蜡滑偿债府3号楼1门273"
   id = "110105198504057283"
   phoneNum = "18191948432"
  ```

  

## MyBatis使用示例

示例代码：

```java
public class Main {
    public static void main(String[] args) {

        FakePersonUtils fakePerson = new FakePersonUtils();
        SqlSession sq = MyBatisUtils.openSession();
        List<PersonInfo> personList = new ArrayList<PersonInfo>();
        try {

            for(int i = 0; i < 10; i++) {
                PersonInfo pi = fakePerson.generatePersonInfoObject(0);
                personList.add(pi);
            }
            sq.insert("info", personList);
            sq.commit();

        }catch (Exception e) {
            sq.rollback();
            e.printStackTrace();
        }finally {
            MyBatisUtils.closeSession(sq);
        }

    }
}
```

Mapper.xml示例：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="personinfo">
    <insert id="info" parameterType="java.util.List">
        INSERT INTO fk_personinfo(name, gender, birth_date, address, id, phone_num)
        VALUES
        <foreach collection="list" item="item" index="index" separator=",">
            (#{item.name},#{item.gender}, #{item.birthDate}, #{item.address}, #{item.id}, #{item.phoneNum})
        </foreach>
    </insert>
</mapper>
```

运行结果：

![Screenshot 2022-10-07 at 19.30.00](/Users/phoebej/Library/Application Support/typora-user-images/Screenshot 2022-10-07 at 19.30.00.png)
