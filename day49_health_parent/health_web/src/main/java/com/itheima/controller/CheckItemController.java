package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
    @Controller :
        1. 表示这个是一个组件，会被spring管理起来
        2. 默认所有的方法返回值都会被当成是页面的名字

    @RestController ：
        1. 等于 @Controller + @ResponseBody。
        2. 在类身上加上@RestController，即表示给所有的方法都加上了@ResponseBody
            等于告诉springmvc，所有的方法返回值都是字符串，不是页面的名字。
 */
//@Controller +  @ResponseBody  =  @RestController
@RequestMapping("/checkItem")
@RestController
public class CheckItemController {

    @Autowired
    private CheckItemService cs;

    /**
     * 添加检查项
     *
     * @param checkItem
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem) {
        System.out.println(checkItem);

        //调用service就可以
        int row = cs.add(checkItem);

        //2.判断结果
        Result result = null;

        if (row > 0) {//添加成功
            result = new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
        } else {
            result = new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }

        //把result对象给页面放返回

        return result;
    }

    /**
     * localhost:83/checkItem/findPage.do
     * 分页查询
     *
     * @param queryPageBean 封装了我们分页查询的条件：包含3个：  currentPage , pageSize , queryString
     * @return
     */

    @RequestMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean) {
        Result result = null;

        try {
            //1. 调用service
            PageResult<CheckItem> pageResult = cs.findPage(queryPageBean);

            //2. 给页面响应
            result = new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }

        return result;
    }


    /**
     * 删除检查项
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(int id) {

        //调用service
        int row = cs.delete(id);


        //给页面响应
        Result result = null;

        if (row > 0) {
            result = new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS);
        } else {
            result = new Result(false, MessageConstant.DELETE_CHECKITEM_SUCCESS);
        }
        return result;
    }


    /**
     * 更新检查项
     *
     * @param checkItem
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody CheckItem checkItem) {
        System.out.println("controller = " + checkItem);

        //调用service方法
        int row = cs.update(checkItem);

        //给页面响应
        Result result=null;

        if (row>0){
            result =new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
        }else {
            result=new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
        }
        return result;
    }

    /**
     * 查询所有的检查项   ,这里使用了RestFul的风格
     *
     * @return
     */
    @GetMapping("/checkItem")
    public Result findAll(){

        try {
            //调用service
            List<CheckItem>list= cs.findAll();

            //给页面响应
            return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }


}
