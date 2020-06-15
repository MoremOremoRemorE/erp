package com.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author jcq
 * 配置redis缓存，允许缓存
 *@EnableScheduling
 *@EnableCaching
 */
@SpringBootApplication
@EnableScheduling
@EnableCaching
@MapperScan({"com.erp.mapper","com.baomidou.mybatisplus.samples.quickstart.mapper"})
public class ErpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
    }

}
