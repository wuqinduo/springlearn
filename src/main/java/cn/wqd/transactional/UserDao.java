package cn.wqd.transactional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.binding.MapperRegistry;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by dell on 2019/10/24.
 */

@Mapper
@Repository
public interface UserDao {

    @Insert("insert into user( name, age) " +
            "values(#{user.name}, #{user.age})")
    void save(@Param("user")User user);
}
