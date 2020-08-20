package com.dciwang.tiny.service.impl;

import com.dciwang.tiny.common.api.CommonResult;
import com.dciwang.tiny.controller.PmsBrandController;
import com.dciwang.tiny.mbg.mapper.PmsBrandMapper;
import com.dciwang.tiny.mbg.model.PmsBrand;
import com.dciwang.tiny.mbg.model.PmsBrandExample;
import com.dciwang.tiny.service.PmsBtandService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author DciWang
 * @Description TODO brand业务接口实现类
 * @Date 2020/8/19 上午10:01
 * @Version 1.0
 */
@Service
public class PmsBrandServiceImpl implements PmsBtandService {
    private static final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);


    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> brandList() {

        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public List<PmsBrand> brandPage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getById(Long id) {

        return pmsBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int creatBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.insert(pmsBrand);
    }

    @Override
    public CommonResult updateBrand(Long id, PmsBrand brand) {
       int count =pmsBrandMapper.updateByPrimaryKey(brand);
       brand.setId(id);
       if (count==1){
           logger.debug("update Brand failed:{}", brand);
           return CommonResult.success(brand,"更新成功");
       }else {
           logger.debug("update Brand success:{}", brand);
           return CommonResult.failed("操作失败");
       }
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }
}
