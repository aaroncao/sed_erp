package com.iverson.erp.controller;

import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.form.MachineForm;
import com.iverson.erp.service.MachineService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/18
 */
@RestController
@RequestMapping("/shop/machine")
@Slf4j
public class MachineController {

    @Autowired
    private MachineService machineService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody MachineForm machineForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            log.error("【创建部门】参数不正确，departmentForm = {}", machineForm);
            return ResultVoUtil.error(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
            //throw new MarketException(ResultEnum.PARAM_ERROR);
        }
        int result = machineService.create(machineForm);
        return ResultVoUtil.success();
    }

    @GetMapping("/delete")
    public ResultVO delete(@RequestParam(name = "machineNo") String machineNo,
                           @RequestParam(name = "shopNo") String shopNo){
        if(StringUtils.isEmpty(machineNo) && StringUtils.isEmpty(shopNo)){
            return ResultVoUtil.error(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
        }
        int result = machineService.delete(machineNo,shopNo);
        return ResultVoUtil.success();
    }
}