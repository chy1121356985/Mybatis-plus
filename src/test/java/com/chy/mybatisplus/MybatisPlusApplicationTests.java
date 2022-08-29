package com.chy.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chy.mybatisplus.entity.User;
import com.chy.mybatisplus.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //查询全部
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //根据ID查询修改
    @Test
    public void selectUser(){
        User user = userMapper.selectById(1563092691057758210L);
        user.setAge(18);
        int i = userMapper.updateById(user);
        System.out.println(i);


    }

    //添加
    @Test
    public void addUser(){
        User user = new User();
        user.setName("qyl");
        user.setAge(25);
        user.setEmail("112132554");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    //修改
    @Test
    public  void updateUser(){
        User user = new User();
        user.setId(6L);
        user.setAge(25);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }


    //多个id批量查询
    @Test
    public void selectUsers(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        for (User user : users) {
            System.out.println(user
            );
        }
    }

    //删除
    @Test
    public void deleteUser(){
        User user = new User();
    }



    //分页查询
    @Test
    public void selectPage(){
        Page<User> userPage = new Page<>(1,3);
        Page<User> users = userMapper.selectPage(userPage, null);

        long pages = userPage.getPages(); //总页数
        long current = userPage.getCurrent(); //当前页
        List<User> records = userPage.getRecords(); //查询数据集合
        long total = userPage.getTotal(); //总记录数
        boolean hasNext = userPage.hasNext();  //下一页
        boolean hasPrevious = userPage.hasPrevious(); //上一页
    }

    //逻辑删除
    @Test
    public void deleted(){
        int i = userMapper.deleteById(1);
        System.out.println(i);
    }








}
