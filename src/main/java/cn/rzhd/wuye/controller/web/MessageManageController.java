package cn.rzhd.wuye.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.rzhd.wuye.bean.MessageManage;
import cn.rzhd.wuye.service.IMessageManageService;
import cn.rzhd.wuye.utils.JsonUtils;

/**
 * 
 * © 2017 RZHD.CN
 * 
 * @Package: cn.rzhd.wuye.controller.web
 * @ClassName: MessageManageController
 * @Description: 描述：通知管理
 * @author: an-wei.xie@rzhd.cn
 * @date: 2017年6月9日 上午11:38:48
 * @version: V1.0
 */
@RestController
@RequestMapping("/dist/messageManage")
public class MessageManageController {

	@Autowired
	private IMessageManageService messageManageService;

	/**
	 * 入驻通知
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findEnterMessage", method = RequestMethod.POST)
	public String findEnterMessage() {
		MessageManage findEnterMessage = messageManageService.findEnterMessage();
		return JsonUtils.objectToJson(findEnterMessage);
	}

	/**
	 * 通知列表
	 */
	@RequestMapping("/messageManageList")
	public List<MessageManage> MessageManage() {
		List<MessageManage> MessageManages = messageManageService.getAllMessage();
		return MessageManages;
	}

	/**
	 * 入住办理通知
	 */
	@RequestMapping("/messageManageNotice")
	public MessageManage MessageManageNotice(Long message_manage_id) {
		MessageManage messageManage = messageManageService.getMessageManage(message_manage_id);
		return messageManage;
	}

	@RequestMapping("/deleteMessageManages")
	public Map<String, Object> DeleteMessageManages(String[] message_manage_id) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			messageManageService.DeleteMessageManages(message_manage_id);
		} catch (Exception e) {
			result.put("message", "发生错误" + e.getMessage());
		}
		result.put("message", "删除成功");
		return result;
	}
}
