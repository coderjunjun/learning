package cn.junwork.learning.jmw.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author coderjunjun@gmail.com
 * @date 2020/10/21
 */
@Mapper
public interface TestMapper {

    @Select("update test_unique_index set a = #{value} where id = 20")
    void update(int value);
}
