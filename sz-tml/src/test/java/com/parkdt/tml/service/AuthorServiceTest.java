package com.parkdt.tml.service;

import com.parkdt.tml.taskService.WeChatTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * AuthorService 测试
 * Created by guojianhua on 2017/11/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorServiceTest {



    @Test
    public void addAuthorTest() {
        String content = WeChatTokenService.getSubscribeText();
        System.out.println(content);
    }
}
