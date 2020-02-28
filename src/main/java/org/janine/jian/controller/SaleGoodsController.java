package org.janine.jian.controller;

import java.math.BigDecimal;
import java.util.List;

import org.janine.jian.domain.SaleGoods;
import org.janine.jian.domain.SeckillGoods;
import org.janine.jian.domain.StockVo;
import org.janine.jian.service.SaleGoodsService;
import org.janine.jian.utils.JsonResult;
import org.janine.jian.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 商品API服务
 * @author jian
 *
 */
@Controller
public class SaleGoodsController {
	@Autowired
	public SaleGoodsService saleGoodsService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/index");
		List<SeckillGoods> list = saleGoodsService.queryAll();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
	
	@GetMapping("/goods")
	@ResponseBody
	public JsonResult<SeckillGoods> queryAll() {
		List<SeckillGoods> list = saleGoodsService.queryAll();
		return ResponseUtils.getResponse(HttpStatus.OK, "查询商品列表成功", null, list, null);
	}
	
	@GetMapping("/goods/{id}")
	@ResponseBody
	public JsonResult<SeckillGoods> queryOne(
			@PathVariable("id") BigDecimal id) {
		SeckillGoods goods = saleGoodsService.queryOne(id);
		return ResponseUtils.getResponse(HttpStatus.OK, "查询商品成功", goods, null, null);
	}
	
	@RequestMapping("/updateStock")
	@ResponseBody
	public JsonResult<SaleGoods> updateGoodsStock(
			@RequestBody StockVo stockVo){
		saleGoodsService.updateGoodsStock(stockVo.id, stockVo.stock);
		return ResponseUtils.getResponse(HttpStatus.OK, "查询商品成功", null, null, null);
		
	}
	
	

}
