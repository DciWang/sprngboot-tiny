package com.dciwang.tiny.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author DciWang
 * @Description TODO MyBatis配置类,扫描mapper文件
 * @Date 2020/8/18 下午5:04
 * @Version 1.0
 */
@Configuration
@MapperScan("com.dciwang.tiny.mbg.mapper")
public class MybatisConfig {
}
