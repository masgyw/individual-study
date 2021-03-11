package cn.gyw.gbatis.session;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.gyw.gbatis.config.Configuration;
import cn.gyw.gbatis.config.MappedStatement;
import cn.gyw.gbatis.mapper.UserMapper;

/**
 *
 * 1.实例化的时候，加载配置信息到Configuration
 * 2.生产 SqlSession
 *
 * Created by guanyw on 2019/3/1.
 */
public class SqlSessionFactory {

    // final 全局唯一
    private final Configuration configuration = new Configuration();

    // 记录mapper xml 文件存放的位置
    public static final String MAPPER_CONFIG_LOCATION = "sqlmapper";

    // 记录数据库连接信息文件存放位置
    public static final String DATABASE_CONFIG_FILE = "database.properties";

    public static final String MAPPER_PACKAGE = "cn.gyw.gbatis.mapper";

    // 初始化配置
    public SqlSessionFactory() {
        try {
            // 1.加载数据库配置信息
            loadDatabaseProperties();
            // 2.初始化 Mapper.xml
            loadMapperLocations();
            // 3.初始化 Mapper 接口
            loadMapperInterface();

            System.out.println("----------init success----------");
            System.out.println(configuration.getMappedStatementMap());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    // 加载数据库配置信息
    private void loadDatabaseProperties() throws IOException {
        // 加载数据库信息配置文件
        InputStream inputStream = SqlSessionFactory.class.getClassLoader().getResourceAsStream(DATABASE_CONFIG_FILE);
        Properties properties = new Properties();
        // 将配置信息写入 Properties 对象
        properties.load(inputStream);
        // 将数据库配置信息写入到Configuration 对象
        configuration.setDriverClass(properties.getProperty("driverClass"));
        configuration.setDriverUrl(properties.getProperty("driverUrl"));
        configuration.setUsername(properties.getProperty("username"));
        configuration.setPassword(properties.getProperty("password"));
    }

    // 加载指定文件夹下的所有 Mapper XML 文件
    private void loadMapperLocations() throws DocumentException {
        URL mappersURL = SqlSessionFactory.class.getClassLoader().getResource(MAPPER_CONFIG_LOCATION);
        // 获取指定文件夹信息
        File mappers = new File(mappersURL.getFile());
        if (mappers.isDirectory()) {
            File[] files = mappers.listFiles();
            // 遍历所有的mapper.xml ，解析信息后，注册到Configuration 对象种
            for (File file : files) {
                loadMapperInfo(file);
            }
        }
    }

    // 加载指定的Mapper XMl 信息，注册到全局配置
    private void loadMapperInfo(File file) throws DocumentException {
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                loadMapperInfo(file);
            }
        } else {
            String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            if (!"xml".equalsIgnoreCase(suffix)) {
                return;
            }
            // 解析 XML 注册 Configuration
            resolveMapper(file);
        }
    }

    private void resolveMapper(File mapperFile) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(mapperFile);

        Element root = document.getRootElement();
        String namespace = root.attributeValue("namespace");

        List<Element> curdEles = root.elements("select");
        for (int i = 0; i < curdEles.size(); i++) {
            Element curdEle = curdEles.get(i);
            MappedStatement mappedStatement = new MappedStatement(namespace);
            mappedStatement.setId(curdEle.attributeValue("id"));
            mappedStatement.setResultType(curdEle.attributeValue("resultType"));
            mappedStatement.setSql(curdEle.getText());
            configuration.addMappedStatement(namespace + "." + mappedStatement.getId(), mappedStatement);
        }
    }

    // TODO : 添加 Mapper 接口解析方式
    private void loadMapperInterface() {
        configuration.registerMapper(UserMapper.class);
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
