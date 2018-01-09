package com.aixin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dailin on 2018/1/9.
 */
@Configuration
@MapperScan("com.**.mapper")
public class MybatisConfig {
}
