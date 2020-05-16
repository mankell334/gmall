package org.mankell.gmall.ums;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mankell.gmall.ums.entity.Admin;
import org.mankell.gmall.ums.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallUmsApplicationTests {

    @Autowired
    AdminService adminService;

    @Test
    public void contextLoads() {
        Admin admin = adminService.login("admin", "123456");
        log.info(admin.toString());
    }

}
