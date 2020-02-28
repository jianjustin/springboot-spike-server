package org.janine.jian.service;

import java.math.BigDecimal;
import java.util.List;

import org.janine.jian.domain.SaleGoods;
import org.janine.jian.domain.SeckillGoods;
import org.janine.jian.mapper.SaleGoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleGoodsService {
	
	@Autowired
	public SaleGoodMapper mapper;
	
	public List<SeckillGoods> queryAll(){
		return mapper.queryAll();
	}
	
	public SeckillGoods queryOne(BigDecimal id) {
		return mapper.queryOne(id);
	}
	
	public boolean updateGoodsStock(BigDecimal id, int stock) {
		return mapper.updateGoodsStock(id, stock);
	}

}
