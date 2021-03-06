package org.mankell.gmall.pms;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.mankell.gmall.pms.mapper")
@EnableDubbo
@SpringBootApplication
public class GmallPmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallPmsApplication.class, args);
    }

}
