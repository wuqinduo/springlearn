package cn.wqd.transactional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by dell on 2019/10/24.
 */

@Mapper
//@Repository
public interface UserMapper {

    @Insert("insert into user( name, age) " +
            "values(#{user.name}, #{user.age})")
    void save(@Param("user") User user);


    @Select("select * from user where id=#{id}")
    User getById(@Param("id")String id);
}
