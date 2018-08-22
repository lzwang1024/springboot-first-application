package com.lzwang.web;

import com.lzwang.bean.Account;
import com.lzwang.service.IAccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lzwang on 2018/6/29.
 */
@RestController
@RequestMapping(value="/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    /*
     @Api：修饰整个类，描述Controller的作用
     @ApiOperation：描述一个类的一个方法，或者说一个接口
     @ApiParam：单个参数描述
     @ApiModel：用对象来接收参数
     @ApiProperty：用对象接收参数时，描述对象的一个字段
     @ApiResponse：HTTP响应其中1个描述
     @ApiResponses：HTTP响应整体描述
     @ApiIgnore：使用该注解忽略这个API
     @ApiError ：发生错误返回的信息
     @ApiParamImplicitL：一个请求参数
     @ApiParamsImplicit 多个请求参数
     *
     */

    @ApiOperation(value="获取账户列表", notes="获取账户列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    @ApiOperation(value="获取账号详情", notes="根据Id获取账号详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Int",paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account findById(@PathVariable("id") int id) {
        return accountService.findAccountById(id);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name")String name,
                              @RequestParam(value = "money")double money) {

        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        int result = accountService.add(account);
        if (result ==1) {
            return "post save success";
        }
        return "fail";
    }

    @RequestMapping(value = "/execute", method = RequestMethod.GET)
    public void execute() {
        accountService.testTransaction();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateAccount(@PathVariable("id")int id , @RequestParam(value = "name",required = true)String name,
                                 @RequestParam(value = "money" ,required = true)double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountService.update(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }
    }

}
