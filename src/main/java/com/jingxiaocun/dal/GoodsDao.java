package com.jingxiaocun.dal;

import com.jingxiaocun.domain.Goods;
import com.jingxiaocun.domain.GoodsStoreNum;
import com.jingxiaocun.exception.NoGoodsNumException;

import java.util.List;

public interface GoodsDao {

	// 插入数据
	public void insertGoods(Goods goods) throws Exception, NoGoodsNumException;

	// 查询库存
	public List<GoodsStoreNum> queryStoreNum(GoodsStoreNum goodsStoreNum) throws Exception;

	// 查询库存记录
	public List<Goods> queryGoodsList(Goods goods) throws Exception;

	// 修改库存记录
	public void updateStore(Goods goods) throws Exception;
	
	//根据id删除记录
	public void deleteStore(String id) throws Exception;
}
