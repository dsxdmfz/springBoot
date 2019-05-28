package com.dsxdmfz.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot默认支持两种技术来和es交互
 * 1、Jest（默认不生效）
 * 需要导入jest工具包（io.searchbox.client.JestClient）
 * 2、springdata elasticSearch
 *     版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
 *     如果不适配：(springData:3.1.8  es:6.4.3)
 *         1）、升级SpringBoot版本
 *         2）、安装对应版本的ES
 *      1）、client 节点信息clusterNodes、clusterName
 *      2）、elasticsearchTemplate 操作es
 *      3）、编写一个elasticsearchRepository的子接口来操作es
 *
 *      两种用法：
 *      1）、编写一个elasticsearchRepository
 */
@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
