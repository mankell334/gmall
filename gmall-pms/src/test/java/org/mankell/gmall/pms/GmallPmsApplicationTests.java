package org.mankell.gmall.pms;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mankell.gmall.pms.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallPmsApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test

    public void contextLoads() {
        stringRedisTemplate.opsForValue().set("hello", "world");
        String hello = stringRedisTemplate.opsForValue().get("hello");
        log.info("stringRedisTemplate获得的值：{}", hello);
    }

    @Test
    public void redisTemplate() {
        redisTemplate.opsForValue().set("brand4", new Brand().setName("尼玛的"));
        Brand brand = (Brand) redisTemplate.opsForValue().get("brand4");
        log.info("redisTemplate获得的值：{}", brand);
    }

}
