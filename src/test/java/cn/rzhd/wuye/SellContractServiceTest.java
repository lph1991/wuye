package cn.rzhd.wuye;

import cn.rzhd.wuye.common.WebService;
import cn.rzhd.wuye.service.ISellContractService;
import cn.rzhd.wuye.utils.JsonUtils;
import cn.rzhd.wuye.vo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by hasee on 2017/5/26.
 */

public class SellContractServiceTest extends BaseTest {
	@Autowired
	ISellContractService service;

	@Test
	public void getSellContractTest() {
		List<SignVO> sellContract = service.getSellContract(LiandoServiceConstant.DATA_TYPE_SIGN, "1031");
		for (SignVO signVO : sellContract) {
			System.out.println(signVO);
		}

	}

	@Test
	public void testGetSell() throws Exception {
		String pk_customerid = "1004XX100000002EINE1";
		String pk_sign = "1077XX10000000011KPD";
		List<SignVO> signVOs = service.getSellContractByCustomer(pk_customerid, pk_sign);
		for (SignVO signVO : signVOs) {
			System.out.println(signVO);
		}
	}

	@Test
	public void getSellContractTest1() {
		List<SignVO> backAll = service.getBackAll();
		System.out.println(backAll.size());
	}

	@Test
	public void getCompanyId() {
		RequesterVO vo = new RequesterVO();
		vo.setBilltype("CORP");
		String baseData = WebService.getBaseData(vo);
		System.out.println(baseData);
	}

	/**
	 * 此测试用于测试存入数据,并尝试将ERP中测试数据存放入本地数据库
	 */
	@Test
	public void addTest() {
		RequesterVO vo = new RequesterVO();
		vo.setKey("liando");
		vo.setBilltype("CORP");
		String baseData = WebService.getBaseData(vo);
		ResponseVO responseVO = JsonUtils.jsonToPojo(baseData, ResponseVO.class);
		if (responseVO != null) {
			if ("Y".equals(responseVO.getIssuccess())) {
				for (CorpVO corpVO : responseVO.getCorpdata()) {
					String pk_corp = corpVO.getPk_corp();
					if (!pk_corp.isEmpty()) {
						List<SignVO> list = service.getSellContract(LiandoServiceConstant.DATA_TYPE_SIGN, pk_corp);
						if (list != null) {
							for (SignVO signVO : list) {
								service.addSellContract(signVO);
							}
						}

					}
				}

			}
		}
	}
}
