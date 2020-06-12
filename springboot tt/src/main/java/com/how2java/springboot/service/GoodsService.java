package com.how2java.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.springboot.mapper.GoodsMapper;
import com.how2java.springboot.pojo.Goods;
@Service
public class GoodsService {
    @Autowired GoodsMapper goodsMapper;
    public void add(Goods good)
    {
    	goodsMapper.add(good);
    }
    public void delete(int id)
    {
    	goodsMapper.delete(id);
    }
    public void get(int id)
    {
    	goodsMapper.get(id);
    }
}
