package com.dciwang.tiny.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author DciWang
 * @Description TODO
 * @Date 2020/8/18 下午4:16
 * @Version 1.0
 */

public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     * PageHelper.startPage(pageNum, pageSize);
     * //之后进行查询操作将自动进行分页
     * List<PmsBrand> brandList = brandMapper.selectByExample(new PmsBrandExample());
     * //通过构造PageInfo对象获取分页信息，如当前页码，总页数，总条数
     * PageInfo<PmsBrand> pageInfo = new PageInfo<PmsBrand>(list);
     *
     * @param list
     * @param <T>
     * @return
     */

    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
