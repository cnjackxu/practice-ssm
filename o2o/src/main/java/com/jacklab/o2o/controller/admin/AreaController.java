package com.jacklab.o2o.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jacklab.o2o.entity.Area;
import com.jacklab.o2o.service.AreaService;


@Controller
@RequestMapping("/admin")
public class AreaController {

	Logger logger= LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "/listarea", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listArea() {
		logger.info("===start===");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<>();
		List<Area> list = new ArrayList<>();
		try {
			list = areaService.getAreaList();
			modelMap.put("success", Boolean.TRUE);
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", Boolean.FALSE);
			modelMap.put("errMsg", e.toString());
		}
		long endTime=System.currentTimeMillis();
		logger.debug("cost time:{}ms",(endTime-startTime));
		logger.info("===end===");
		return modelMap;
	}
}
