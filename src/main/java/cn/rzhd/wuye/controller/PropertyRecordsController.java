package cn.rzhd.wuye.controller;

import cn.rzhd.wuye.service.IPropertyFeePayDetailsService;
import cn.rzhd.wuye.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hasee on 2017/6/22.
 */
@Controller
@RequestMapping("/propertyRecords")
public class PropertyRecordsController {
    @Autowired
    private IPropertyFeePayDetailsService propertyFeePayDetailsService;

    @RequestMapping("/index")
    public ModelAndView index(){
        Long userId = UserContext.getUser().getUserId();
        List<Map<String, Object>> result = new ArrayList<>();
        result.addAll(propertyFeePayDetailsService.getByProject(userId));
        ModelAndView mav = new ModelAndView();
        mav.addObject("propertyRecords",result);
        mav.setViewName("payment/wuye");
        return mav;
    }

    @RequestMapping("/payFeeRecords")
    public ModelAndView payFeeRecords(){
        Long userId = UserContext.getUser().getUserId();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("payment/wuyejiaofei");
        return mav;
    }
}
