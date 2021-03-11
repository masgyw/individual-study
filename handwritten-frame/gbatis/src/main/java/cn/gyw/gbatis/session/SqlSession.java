package cn.gyw.gbatis.session;

import java.util.List;

/**
 * Mybatis 暴露给外部的接口：实现增删改查的能力
 *
 * 1.对外提供数据访问api
 * 2.对内将请求转发给Executor
 *
 * Created by guanyw on 2019/3/1.
 */
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <E> List<E> selectList(String statement);

    <E> List<E> selectList(String statement, Object parameter);

    <T> T getMapper(Class<T> mapperClaz);
}
