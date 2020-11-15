package com.demo.empdept.service;

import com.demo.empdept.repository.IStockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    private Logger logger = LoggerFactory.getLogger(StockService.class);

    @Autowired
    private IStockRepository stockRepository;


    public void descStock(){

    }

    // 使用反射技术得到T的真实类型
//    public Class getRealType(){
//        // 获取当前new的对象的泛型的父类类型
//        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
//        // 获取第一个类型参数的真实类型
//        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
//        return clazz;
//    }


    public <T> int batchSave(List<T> list){
        // 获取当前new的对象的泛型的父类类型
//        ParameterizedType pt = (ParameterizedType) .getGenericSuperclass();
//        // 获取第一个类型参数的真实类型
//        Type type =  pt.getActualTypeArguments()[0];
        if(null == list) return 0;
        if(list.size() > 500){
            //List<List<T>> parList = Lists.partition();
            if(T.class.getTypeName().equals(String.class.getGenericSuperclass().getTypeName())){
                System.out.println("shi string");
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        StockService srv = new StockService();
        List<String> list = new ArrayList();
        srv.batchSave(list);
    }
}