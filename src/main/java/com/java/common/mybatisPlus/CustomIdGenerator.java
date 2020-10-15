//package com.java.common.mybatisPlus;
//
//import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomIdGenerator implements IdentifierGenerator {
//
//    @Bean
//    public IdentifierGenerator idGenerator() {
//        return new CustomIdGenerator();
//    }
//
//    @Override
//    public Long nextId(Object entity) {
//        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
////        String bizKey = entity.getClass().getName()+SnowflakeIdHelper.getId();;
//        String bizKey = entity.getClass().getName();;
//        //根据bizKey调用分布式ID生成
//        long id =Long.valueOf(bizKey.hashCode());
//        //返回生成的id值即可.
//        return id;
//    }
//
//
//}