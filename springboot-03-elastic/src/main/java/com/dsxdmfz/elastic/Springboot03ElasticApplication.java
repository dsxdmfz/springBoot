package com.dsxdmfz.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot默认支持两种技术来和es交互
 * 1、Jest（默认不生效）
 * 需要导入jest工具包（io.searchbox.client.JestClient）
 * 2、springdata elasticSearch
 *      1）、client 节点信息clusterNodes、clusterName
 *      2）、elasticsearchTemplate 操作es
 *      3）、编写一个elasticsearchRepository的子接口来操作es
 */
@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
