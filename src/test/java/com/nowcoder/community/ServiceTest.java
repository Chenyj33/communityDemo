package com.nowcoder.community;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author CHEN YANJIN
 * @date 2022/6/18 11:48
 */
@SpringBootTest
public class ServiceTest {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        List<DiscussPost> posts = discussPostService.findDiscussPosts(15, 0, 10);
        for (DiscussPost post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void test2(){
        User user = userService.findUserById(11);
        System.out.println(user);
    }

}
