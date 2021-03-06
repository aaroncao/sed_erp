package com.iverson.sed_erp.mapper;

import com.iverson.erp.enums.StaffSexEnum;
import com.iverson.erp.mapper.StaffMapper;
import com.iverson.erp.pojo.Staff;
import com.iverson.erp.util.NoGenerateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffMapperTest {

    @Autowired
    private StaffMapper staffMapper;

    @Test
    public void addOne() {
        Staff staff = new Staff();
        staff.setStaffNo(NoGenerateUtil.getStaffNo());
        staff.setName("Stephen Curry");
        staff.setPhoneNumber("13822528775");
        staff.setAge(30);
        staff.setSex(StaffSexEnum.MAN.getValue());
        staff.setBirth("1987-08-16");
        staff.setAddress("广东省深圳市南山区粤海街道桑达科技大厦10楼(桑达商用机器有限公司)");
        staff.setDepartmentNo("DN20190702102837810737");
        int result = staffMapper.addOne(staff);
        System.out.println("结果: " + result);
    }

    @Test
    public void update() {
    }

    @Test
    public void getList() {
//        List<StaffVo> staffVos = staffMapper.getList(null,null,null,null,null,null,"DN20190702102837810737");
//        Assert.assertNotNull(staffVos);
    }
}