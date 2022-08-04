package com.caleb.mpdemo0803.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caleb.mpdemo0803.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
