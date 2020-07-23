package com.jingxiaocun.service.impl;

import java.util.List;

import com.jingxiaocun.dal.GoodsDao;
import com.jingxiaocun.dal.impl.GoodsDaoImpl;
import com.jingxiaocun.domain.Goods;
import com.jingxiaocun.domain.GoodsStoreNum;
import com.jingxiaocun.service.GoodsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDao dao;
	
	protected Logger logger = Logger.getLogger(getClass());
	
	@Override
	public List<GoodsStoreNum> queryStoreNum(GoodsStoreNum goodsStoreNum) throws Exception {
		try {
			List<GoodsStoreNum> list = dao.queryStoreNum(goodsStoreNum);
			return list;
		} catch (Exception e) {
			logger.info("查询库存，异常！" + e);
			throw new Exception(e);
		}
	}

	@Override
	public void inOrOutStore(Goods goods) throws Exception{
		try {
			dao.insertGoods(goods);
		} catch (Exception e) {
			logger.info("入/出库，异常" + e);
			throw new Exception(e);
		}
	}

	@Override
	public List<Goods> queryGoodsList(Goods goods) throws Exception {
		try {
			List<Goods> goodsList = dao.queryGoodsList(goods);
			return goodsList;
		} catch (Exception e) {
			logger.info("查询库存记录，异常！" + e);
			throw new Exception(e);
		}
	}

	@Override
	public void updateStore(Goods goods) throws Exception {
		try {
			dao.updateStore(goods);
		} catch (Exception e) {
			logger.info("修改库存记录，异常！" + e);
			throw new Exception(e);
		}
		
	}

	@Override
	public void deleteStore(String id) throws Exception {
		try {
			dao.deleteStore(id);
		} catch (Exception e) {
			logger.info("删除，异常" + e);
			throw new Exception(e);
		}
	}

}
