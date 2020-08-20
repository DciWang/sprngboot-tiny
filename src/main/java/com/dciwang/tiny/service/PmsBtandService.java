package com.dciwang.tiny.service;

import com.dciwang.tiny.common.api.CommonResult;
import com.dciwang.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @Author DciWang
 * @Description TODO brand业务接口
 * @Date 2020/8/19 上午10:01
 * @Version 1.0
 */

public interface PmsBtandService {
    /**
     * 商品列表
     * @return
     */
    List<PmsBrand> brandList();

    /**
     * 商品分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> brandPage(Integer pageNum,Integer pageSize);

    /**
     * 根据id查找商品
     * @param id
     * @return
     */
    PmsBrand getById(Long id);

    /**
     * 新增 商品
     * @param pmsBrand
     * @return
     */
    int creatBrand (PmsBrand pmsBrand);

    /**
     * 根据id修改商品
     * @param id
     * @return
     */
    CommonResult updateBrand(Long id, PmsBrand brand);

    /**
     * 根据id删除商品
     * @param id
     * @return
     */
    int deleteBrand(Long id);
}
