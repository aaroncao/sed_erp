package com.iverson.sed_erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.enums.ResultEnum;
import com.iverson.sed_erp.exception.MarketException;
import com.iverson.sed_erp.form.GoodsForm;
import com.iverson.sed_erp.service.GoodsService;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.GoodsVo;
import com.iverson.sed_erp.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/create")
    public ResultVo create(@Valid @RequestBody GoodsForm goodsForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建商品】 参数不正确 goodsForm = {}",goodsForm);
            throw new MarketException(ResultEnum.PARAM_ERROR);
        }
        int result = goodsService.addOne(goodsForm);
        if(result == 1){
            log.info("【创建商品】插入成功,result = {}", result);
            return ResultVoUtil.success();
        }
        log.error("【创建商品】插入失败,result = {}",result);
        return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(),ResultEnum.INSERT_ERROR.getMessage());
    }

    @PostMapping("/update")
    public ResultVo updateByNo(@RequestBody GoodsForm goodsForm){
        int result = goodsService.update(goodsForm);
        if(result == 1){
            log.info("【创建商品】更新成功,result = {}", result);
            return ResultVoUtil.success();
        }
        log.error("【创建商品】更新失败,result = {}", result);
        return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(),ResultEnum.UPDATE_ERROR.getMessage());
    }

    @GetMapping("/list")
    public ResultVo getList(@RequestParam(name = "goodsNo",required = false) String goodsNo,
                            @RequestParam(name = "name",required = false) String name,
                            @RequestParam(name = "barcode",required = false) String barcode,
                            @RequestParam(name = "categoryNo",required = false) String categoryNo,
                            @RequestParam(name = "brandNo",required = false) String brandNo,
                            @RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<GoodsVo> goodsVoPageInfo = goodsService.getList(goodsNo,name,barcode,categoryNo,brandNo,pageNum,pageSize);
        return ResultVoUtil.success(goodsVoPageInfo);
    }
}
