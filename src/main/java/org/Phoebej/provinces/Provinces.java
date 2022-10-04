package org.Phoebej.provinces;

import java.util.ArrayList;
import java.util.List;

/**
 * 身份信息集合对象
 * @author Phoebej
 * @date 2022/10/2
 * @since v0.2.0
 */
public class Provinces {
    private static ArrayList<ProvinceInfoGenerator> provincesList = new ArrayList<>();

    static{
        ProvinceInfoGenerator tj = new TianJin();
        ProvinceInfoGenerator bj = new BeiJing();
        provincesList.add(tj);
        provincesList.add(bj);
    }


    public static ArrayList<ProvinceInfoGenerator> getProvincesList() {
        return provincesList;
    }
}
