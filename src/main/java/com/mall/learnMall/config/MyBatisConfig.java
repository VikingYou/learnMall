package com.mall.learnMall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2021/11/16.
 */
@Configuration
@MapperScan("com.mall.learnMall.mbg.mapper")
public class MyBatisConfig {
}
