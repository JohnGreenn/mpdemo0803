package com.caleb.mpdemo0803;

import com.caleb.mpdemo0803.entity.User;
import com.caleb.mpdemo0803.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mpdemo0803ApplicationTests {

    @Autowired(required = true)
    private UserMapper userMapper;
    //查询user表所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    //添加操作
    @Test
    public void addUser() {
        User user = new User();
        user.setName("lucy");
        user.setAge(30);
        user.setEmail("123@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert:"+insert);
    }

}
