package com.iverson.sed_erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.StaffForm;
import com.iverson.sed_erp.mapper.StaffMapper;
import com.iverson.sed_erp.pojo.Staff;
import com.iverson.sed_erp.service.StaffService;
import com.iverson.sed_erp.vo.StaffVo;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    @Transactional
    public int addOne(StaffForm staffForm) {
        Staff staff = new Staff();
        staff.setName(staffForm.getName());
        staff.setPhoneNumber(staffForm.getPhoneNumber());
        staff.setAge(staffForm.getAge());
        staff.setSex(staffForm.getSex());
        staff.setBirth(staffForm.getBirth());
        staff.setAddress(staffForm.getAddress());
        return staffMapper.addOne(staff);
    }

    @Override
    @Transactional
    public int update(StaffForm staffForm) {
        Staff staff = new Staff();
        staff.setStaffNo(staffForm.getStaffNo());
        staff.setName(staffForm.getName());
        staff.setPhoneNumber(staffForm.getPhoneNumber());
        staff.setAge(staffForm.getAge());
        staff.setSex(staffForm.getSex());
        staff.setBirth(staffForm.getBirth());
        staff.setAddress(staffForm.getAddress());
        return staffMapper.addOne(staff);
    }

    @Override
    public PageInfo<StaffVo> getList(String staffNo, String name, String phoneNumber, Integer sex, Date birth, String address,String departmentNo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<StaffVo> staffVos = staffMapper.getList(staffNo,name,phoneNumber,sex,birth,address,departmentNo);
        PageInfo<StaffVo> staffVoPageInfo = new PageInfo<>(staffVos);
        return staffVoPageInfo;
    }
}