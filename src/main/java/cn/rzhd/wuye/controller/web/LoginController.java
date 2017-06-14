package cn.rzhd.wuye.controller.web;

import cn.rzhd.wuye.bean.Customer;
import cn.rzhd.wuye.service.ICustomerService;
import cn.rzhd.wuye.service.IProjectInfoService;
import cn.rzhd.wuye.service.IRentContractService;
import cn.rzhd.wuye.service.ISellContractService;
import cn.rzhd.wuye.utils.JsonResult;
import cn.rzhd.wuye.vo.PactVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hasee on 2017/6/1.
 */
@RestController
@RequestMapping("/dist/customer")
public class LoginController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ISellContractService sellContractService;
    @Autowired
    IRentContractService rentContractService;
    @Autowired
    IProjectInfoService projectInfoService;

    /**
     *
     * @param customer 通过Customer对象将vccode账号,password密码(未加密)封装起来
     * @return json对象,包含房产id及房产名称
     */
    @RequestMapping("/login")
    public JsonResult login(Customer customer){
        List<Customer> customers = customerService.loginByPwd(customer);
        if (customers.isEmpty()){
            return new JsonResult("客户不存在!!!");
        }else{
            JsonResult result = new JsonResult();
            //只取租赁客户
            for (Customer cus : customers) {
                List<PactVO> pactVOS = rentContractService.queryByCustomer(cus.getPk_customerid());
                cus.getHouseInfos().addAll(pactVOS);
            }

            result.getData().add(customers);

//            for (Customer cus : customers) {
//                String customerid = cus.getPk_customerid();
//                List<SignVO> signVOS = sellContractService.queryByCustomer(cus.getPk_customerid());
//                //List<PactVO> pactVOS = rentContractService.queryByCustomer(cus.getPk_customerid());
//                if (!signVOS.isEmpty()){
//                    result.getData().add(signVOS);
//                }
////                if (!pactVOS.isEmpty()){
////                    result.getData().add(pactVOS);
////                }
//            }
            return result;
        }
    }
}
