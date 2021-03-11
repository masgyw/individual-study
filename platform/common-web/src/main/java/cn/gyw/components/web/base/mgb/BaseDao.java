package cn.gyw.components.web.base.mgb;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<Record, Example> {

	long countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExampleWithBLOBs(Example example);

    List<Record> selectByExample(Example example);

    Record selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example);

    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKeyWithBLOBs(Record record);

    int updateByPrimaryKey(Record record);

    default Record selectOne(Example example) {
    	List<Record> list = selectByExample(example);
    	if (list.size() == 1) {
    		return list.get(0);
    	}
    	return null;
    }
}
