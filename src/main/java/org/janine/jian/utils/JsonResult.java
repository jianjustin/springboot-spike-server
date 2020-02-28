package org.janine.jian.utils;

import java.util.List;
import java.io.Serializable;
import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * 数据结果集
 * @author jian
 *
 */
public class JsonResult<T> implements Serializable {
	private static final long serialVersionUID = 6848818775356922585L;
	
	private HttpStatus code;
	private String msg;
	private T data;
	private List<T> dataList;
	private Map<String, Object> dataMap;
	
	public HttpStatus getCode() {
		return code;
	}
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void  setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}
