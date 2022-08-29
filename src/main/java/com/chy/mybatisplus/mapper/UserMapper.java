package com.chy.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chy.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 11213
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
