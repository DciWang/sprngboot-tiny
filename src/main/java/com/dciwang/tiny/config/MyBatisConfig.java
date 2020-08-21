package com.dciwang.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.dciwang.tiny.mbg.mapper","com.dciwang.tiny.dao"})
public class MyBatisConfig {
}
