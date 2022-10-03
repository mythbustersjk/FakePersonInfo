import org.Phoebej.provinces.ProvinceInfoGenerator;
import org.Phoebej.provinces.Provinces;
import org.Phoebej.provinces.TianJin;
import org.Phoebej.utils.FackePersonUtils;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;
import java.util.Random;


/**
 * @author Phoebej
 * @date 2022/9/26
 */
public class TmpTest {
    @Test
    public void testTmp() throws Exception {
        System.out.println(2%2);
    }
    @Test
    public void testGender() throws Exception {
        for (int i = 0; i<10; i++) {
            System.out.println(FackePersonUtils.generateGender(1));
        }
    }

    @Test
    public void testTime() throws ParseException {

        for (int i = 0; i<10; i++) {

            System.out.println(FackePersonUtils.generateBirthday());
        }

    }
    @Test
    public void testAddress1(){
        ProvinceInfoGenerator address = new TianJin();
        for (int i = 0; i<10; i++) {
            System.out.println(address.generateInfo());
        }
    }

    @Test
    public void test(){
        for (int i = 0; i<10; i++) {
            System.out.println(new Random().nextInt(100));
        }
    }

    @Test
    public void testId() throws Exception {
        for (int i = 0; i<100; i++) {
            System.out.println(FackePersonUtils.generateId());
        }
    }

    @Test
    public void testAddress() throws Exception {
        for (int i = 0; i<100; i++) {
            System.out.println(FackePersonUtils.generateAddress());
        }
    }

    @Test
    public void testGetPersonInfo() throws Exception {
        for (int i = 0; i<100; i++) {
            System.out.println(FackePersonUtils.generatePersonInfoMap(new TianJin(),0));
        }
    }

    @Test
    public void testGetPersonInfoPS() throws Exception {
        for (int i = 0; i<100; i++) {
            System.out.println(FackePersonUtils.generatePersonInfoMap(0));
        }
    }
    @Test
    public void testGetProvinces() throws Exception {
        List<ProvinceInfoGenerator> a = Provinces.getProvincesList();
        System.out.println(a.size());
    }

}
