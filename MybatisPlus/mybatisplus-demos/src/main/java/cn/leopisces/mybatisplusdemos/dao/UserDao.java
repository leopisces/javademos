package cn.leopisces.mybatisplusdemos.dao;

import cn.leopisces.mybatisplusdemos.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserDao
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
