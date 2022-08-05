package com.caleb.mpdemo0803;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caleb.mpdemo0803.entity.User;
import com.caleb.mpdemo0803.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
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
        user.setName("obama");
        user.setAge(64);
        user.setEmail("798@twitter.com");

        int insert = userMapper.insert(user);
        System.out.println("insert:"+insert);
    }

    //修改操作
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(2L);
        user.setAge(100);

        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    //测试乐观锁
    @Test
    public void testOptimisticLocker() {
        //根据id查询数据
        User user = userMapper.selectById(2L);

        //进行修改
        user.setAge(82);
        userMapper.updateById(user);
    }

    //多个id批量查询
    public void testSelectDemo1() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    @Test
    public void testSelectByMap(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }

    //测试selectPage分页
    @Test
    public void testSelectPage() {

        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent()); //当前页
        System.out.println(page.getRecords()); //每页数据list集合
        System.out.println(page.getPages()); //总页数
        System.out.println(page.getSize()); //每页显示记录数
        System.out.println(page.getTotal()); //总记录数
        System.out.println(page.hasNext()); //下一页
        System.out.println(page.hasPrevious()); //上一页
    }

    //删除操作 物理删除
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1555468146268282882L);
        System.out.println(result);

    }

    //批量删除
    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(1555386104130166785L, 1555395869702893569L, 1555440708779786242L));
        System.out.println(result);
    }

}
