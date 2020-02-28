package org.janine.jian.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.janine.jian.domain.SaleGoods;
import org.janine.jian.domain.SeckillGoods;

@Mapper
public interface SaleGoodMapper {
	
	@Select("select t.id as id,s.id as goods_id,seckill_price,stock_count,start_date,end_date,version,goods_name,goods_title,goods_img,goods_detail,goods_price,goods_stock,create_date,update_date from sale_goods s left join seckill_goods t on s.id = t.goods_id;")
	public List<SeckillGoods> queryAll();
	
	@Select("select t.id as id,s.id as goods_id,seckill_price,stock_count,start_date,end_date,version,goods_name,goods_title,goods_img,goods_detail,goods_price,goods_stock,create_date,update_date from sale_goods s left join seckill_goods t on s.id = t.goods_id; where s.id = #{id}")
	public SeckillGoods queryOne(BigDecimal id);
	
	@Update("update sale_goods set goods_stock = #{stock} where id = #{id}")
	public boolean updateGoodsStock(BigDecimal id, int stock);

}
