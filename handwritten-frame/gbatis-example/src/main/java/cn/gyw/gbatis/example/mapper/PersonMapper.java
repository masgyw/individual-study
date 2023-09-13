package cn.gyw.gbatis.example.mapper;

import java.util.List;

import cn.gyw.gbatis.example.model.Person;
import cn.gyw.gbatis.annotations.Mapper;
import cn.gyw.gbatis.annotations.Select;

@Mapper
public interface PersonMapper {

    List<Person> queryAll();

    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    @Select(value = "select * from t_person where id=?")
    Person queryById(Integer id);
}
