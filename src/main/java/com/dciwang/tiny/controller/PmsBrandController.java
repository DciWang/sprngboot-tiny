package com.dciwang.tiny.controller;

import com.dciwang.tiny.common.api.CommonPage;
import com.dciwang.tiny.common.api.CommonResult;
import com.dciwang.tiny.mbg.model.PmsBrand;
import com.dciwang.tiny.service.PmsBtandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author DciWang
 * @Description TODO  品牌管理controller
 * @Date 2020/8/19 上午10:06
 * @Version 1.0
 */
@Api(tags ="PmsBrandController",description = "商品管理平台")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    private static final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);
    @Autowired
    private PmsBtandService pmsBtandService;

    /**
     * 商品列表
     *
     * @return
     */
    @ApiOperation("获取所有品牌列表")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<List<PmsBrand>> branList() {
        return CommonResult.success(pmsBtandService.brandList());
    }

    /**
     * 商品分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("分页查询品牌列表")
    @GetMapping("/page")
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> brandPage(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") @ApiParam("每页数量") Integer pageSize) {
        List<PmsBrand> list = pmsBtandService.brandPage(pageNum, pageSize);
        list.stream().forEach(item -> System.out.println(item));
        return CommonResult.success(CommonPage.restPage(pmsBtandService.brandPage(pageNum, pageSize)));
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @ApiOperation("获取指定id的品牌详情")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<PmsBrand> getById(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBtandService.getById(id));
    }

    /**
     * 添加商品
     * @param pmsBrand
     * @return
     */
    @ApiOperation("添加品牌")
    @PostMapping("/create")
    @ResponseBody
    public CommonResult  creatBran(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBtandService.creatBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            logger.debug(" create Brand success :{} ", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            logger.debug("create Brand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    /**
     * 修改商品
     * @param id
     * @param pmsBrand
     * @return
     */
    @ApiOperation("更新指定id品牌信息")
    @PutMapping("/update/{id}")
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,@RequestBody PmsBrand pmsBrand){/*
        CommonResult<PmsBrand> commonResult;
        int count =pmsBtandService.updateBrand(id,pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            logger.debug(" update Brand success :{} ", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            logger.debug("update Brand failed:{}", pmsBrand);
        }
        return commonResult;*/
        return pmsBtandService.updateBrand(id,pmsBrand);
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @ApiOperation("删除指定id的品牌")
    @PutMapping("/delete/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id){
        CommonResult commonResult;
        int count=pmsBtandService.deleteBrand(id);
        if (count == 1) {
            commonResult = CommonResult.success(id);
            logger.debug(" delete Brand success :{} ", id);
        } else {
            commonResult = CommonResult.failed("操作失败");
            logger.debug("delete Brand failed:{}", id);
        }
        return commonResult;
    }
}
