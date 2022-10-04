package org.Phoebej.constant.consist;

import java.util.HashMap;

/**
 * 运营商手机号段
 * @author Phoebej
 * @date 2022/10/4
 * @since v0.3.0
 */
public abstract class PhoneNum {

    private static final HashMap<String, String[]> phoneNumber = new HashMap<String, String[]>();

    static {
        phoneNumber.put("cucc", new String[]{"130","131","132","140","145","146","155","156","166","167","1704","1707","1708","1709","171","175","176","185","186","196"});
        phoneNumber.put("cmcc", new String[]{"134","135","136","137","138","139","144","147","148","150","151","152","157","158","159","165","1703","1705","1706","172","178","182","183","184","187","188","195","197","198"});
        phoneNumber.put("ctcc", new String[]{"133","1349","141","149","153","162","1700","1701","1702","173","1740","177","180","181","189","190","191","193","199"});
        phoneNumber.put("cbn", new String[]{"192"});
    }

    public static HashMap<String, String[]> getPhoneNumber(){
        return phoneNumber;
    }
}
