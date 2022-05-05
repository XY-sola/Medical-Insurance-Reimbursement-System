package org.xy.medicare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: SpringBoot项目启动类
 * @author: XY-GYL
 * @time: 2022/5/4 10:11
 */

@SpringBootApplication
@MapperScan("org.xy.medicare.dao")
public class MedicareApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicareApplication.class, args);
    }
}
