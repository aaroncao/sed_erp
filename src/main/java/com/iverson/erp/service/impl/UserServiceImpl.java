package com.iverson.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.erp.enums.UserStatusEnum;
import com.iverson.erp.form.LoginForm;
import com.iverson.erp.form.UserForm;
import com.iverson.erp.mapper.UserMapper;
import com.iverson.erp.pojo.Role;
import com.iverson.erp.pojo.User;
import com.iverson.erp.service.RoleService;
import com.iverson.erp.service.UserService;
import com.iverson.erp.util.NoGenerateUtil;
import com.iverson.erp.util.PasswordUtil;
import com.iverson.erp.vo.UserMVO;
import com.iverson.erp.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;

    @Override
    public UserVO login(LoginForm loginForm) {
        UserVO userVO = new UserVO();
        User user = userMapper.getByUP(loginForm.getUserName(),PasswordUtil.getPassword(loginForm.getPassword()));
        if(user == null) {
            return null;
        }
        Role role = roleService.getRoleNameByNo(user.getRoleNo());
        BeanUtils.copyProperties(user,userVO);
        userVO.setRoleName(role.getRoleName());
        userVO.setModule(role.getModule());
        return userVO;
    }

    @Override
    public int add(UserForm userForm) {
        User user = new User();
        user.setUserNo(NoGenerateUtil.getUserNo());
        user.setUserName(userForm.getUserName());
        user.setNickName(userForm.getNickName());
        user.setRoleNo(userForm.getRoleNo());
        user.setStatus(UserStatusEnum.NORMAL.getCode());
        user.setPassword(PasswordUtil.getPassword(userForm.getPassword()));
        return userMapper.add(user);
    }

    @Override
    public PageInfo<UserMVO> getList(String userNo, String nickName, Integer status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserMVO> userMVOS = userMapper.getList(userNo,nickName,status);
        PageInfo<UserMVO> userPageInfo = new PageInfo<>(userMVOS);
        return userPageInfo;
    }

    @Override
    public int update(UserForm userForm) {
        User user = new User();
        user.setUserNo(userForm.getUserNo());
        user.setRoleNo(userForm.getRoleNo());
        user.setUserName(userForm.getUserName());
        user.setNickName(userForm.getNickName());
        user.setPassword(PasswordUtil.getPassword(userForm.getPassword()));
        user.setStatus(userForm.getStatus());
        return userMapper.update(user);
    }
}
