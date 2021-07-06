package com.itheima.dao;

import com.itheima.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * @author Liuhl
 */
public interface CheckItemDao {
    /**
     * 新增检查项
     * @param checkItem
     * @return
     */
    int add(CheckItem checkItem);

    /**
     * 查询表的总记录数,但不能盲目的认为就是整张表的总记录数，因为可能会有附带的查询条件。
     * @param queryPageBean
     * @return
     */
    long findCount(QueryPageBean queryPageBean);

    List<CheckItem> findPage(QueryPageBean queryPageBean);


    /**
     * 根据检查项的id值查询是否又被检查组是用
     * @param id
     * @return  被检查组使用的总数
     */
    long findCountById(int id);


    /**
     * 根据id删除检查项
     * @param id
     * @return
     */
    int delete(int id);


    /**
     * 更新呢检查项(编辑检查项)
     *
     * @param checkItem
     * @return
     */
    int update(CheckItem checkItem);

    /**
     * 查询所有的检查项
     * @return
     */
    List<CheckItem>findAll();


}
