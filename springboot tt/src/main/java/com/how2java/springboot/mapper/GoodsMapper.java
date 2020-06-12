package com.how2java.springboot.mapper;
 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.how2java.springboot.pojo.Goods;
 
@Mapper
public interface GoodsMapper {
    public int add(Goods good); 
    
    public void delete(int id); 
        
    public Goods get(int id); 
       
    public List<Goods> list();
}