package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.health.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 检查组的控制器
 */
@RestController
//@RequestMapping("/checkgroup")
public class CheckGroupController {

    //注入service
    @Autowired
    private CheckGroupService cgs;

    /**
     * /**
     * * 新增检查组 localhost:83/checkgroup
     * * 1. 新增检查组除了要提交检查组的基本信息之外，还要提交选中的检查项的id值。
     * * 2. 由于参数位置只有一个，我们也不想封装它，所以检查项的id数据就被放到了地址里面去写了。
     * * 3. 如果放到地址里面去写，那么咱们这个方法的地址应该是这样！ localhost:83/checkgroup/检查项的id数据
     * * @param checkGroup
     * * @return
     */

    @PostMapping("/checkgroup/{checkitemIds}")
    public Result add(@RequestBody CheckGroup checkGroup, @PathVariable("checkitemIds") int[] checkitemIds) {

        System.out.println("接收到的数据: ");
        System.out.println("checkGroup = " + checkGroup);
        System.out.println("checkitemIds" + Arrays.toString(checkitemIds));

        //调用service
        int row = cgs.add(checkGroup, checkitemIds);

        //给页面响应
        Result result = null;
        if (row > 0) {
            result = new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
        } else {
            result = new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
        return result;

    }

    @GetMapping("/checkgroup")
    public Result findPage(QueryPageBean queryPageBean) {
        System.out.println("queryPageBean = " + queryPageBean);

        try {
            //调用service
            PageResult<CheckGroup> pr = cgs.findPage(queryPageBean);

            //给页面响应
            return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
        }
    }


}
