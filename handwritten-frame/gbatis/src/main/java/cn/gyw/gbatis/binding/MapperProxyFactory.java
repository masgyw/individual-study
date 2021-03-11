package cn.gyw.gbatis.binding;

import cn.gyw.gbatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * Mapper 接口 工厂
 *
 * Created by guanyw on 2019/3/4.
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    protected T newInstance(MapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[]{this.mapperInterface}, mapperProxy);
    }

    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy(sqlSession, this.mapperInterface);
        return this.newInstance(mapperProxy);
    }

}
