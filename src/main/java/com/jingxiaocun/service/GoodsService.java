package com.jingxiaocun.service;

import com.jingxiaocun.domain.Goods;
import com.jingxiaocun.domain.GoodsStoreNum;

import java.util.List;

public interface GoodsService {

	// 库存查看
	public List<GoodsStoreNum> queryStoreNum(GoodsStoreNum goodsStoreNum) throws Exception;

	// 入/出库
	public void inOrOutStore(Goods goods) throws Exception;

	// 库存记录查看
	public List<Goods> queryGoodsList(Goods goods) throws Exception;

	// 修改库存记录
	public void updateStore(Goods goods) throws Exception;
	
	//根据id删除记录
	public void deleteStore(String id) throws Exception;
}
