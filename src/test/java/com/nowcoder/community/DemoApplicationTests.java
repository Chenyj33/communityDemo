package com.nowcoder.community;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(3);
        System.out.println(user);

        User user1 = userMapper.selectByName("liubei");
        System.out.println(user1);

        User user2 = userMapper.selectByEmail("nowcoder25@sina.com");
        System.out.println(user2);
    }
@Test
    public void testInsertUser(){
    User user = new User();
    user.setUsername("cheng");
    user.setPassword("jjjj");
    user.setEmail("163@qq.com");
    user.setSalt("hhh");
    //user.setStatus(2);
    user.setHeaderUrl("http://www.nowcodeer.com/101.png");
    user.setCreateTime(new Date());

    int row = userMapper.insertUser(user);
    System.out.println(row);

    System.out.println(user.getId());
}

@Test
    public void testUpdateStatus(){
    int i = userMapper.updateStatus(151, 55);
    System.out.println(i);
}

@Test
    public void testUpdatePassword(){
    int i = userMapper.updatePassword(151, "9999999");
    System.out.println(i);
}
@Test
    public void testUpdateHeaderurl(){
    int i = userMapper.updateHeader(151, "http://www.nowcodeer.com/10999.png");
    System.out.println(i);
}


}
