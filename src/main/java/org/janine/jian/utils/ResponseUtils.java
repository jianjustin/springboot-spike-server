package org.janine.jian.utils;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ResponseUtils<T> {
	
	/**
	 * 获取返回页面及数据
	 * @param viewPage
	 * @param status
	 * @param data
	 * @return
	 */
	public static <T> JsonResult<T> getResponse(HttpStatus code, String msg, T data, List<T> dataList, Map<String, Object> dataMap) {
		JsonResult<T> result = new JsonResult<>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		result.setDataList(dataList);
		result.setDataMap(dataMap);
	    return result;
	}

}
