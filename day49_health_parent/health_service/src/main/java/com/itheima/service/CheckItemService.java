package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {
    /**
     * 新增检查项
     *
     * @return
     */
    int add(CheckItem checkItem);


    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return pageResult
     */
    PageResult<CheckItem> findPage(QueryPageBean queryPageBean);

    /**
     * 删除检查页
     * @param id  检查页的id
     * @return
     */
    int delete(int id);


    /**
     * 更新检查项(编辑检查项)
     *
     * @param checkItem
     * @return
     */
    int update(CheckItem checkItem);


    /**
     * 查询所有的检查项
     *
     * @return
     */
    List<CheckItem>findAll();
}
