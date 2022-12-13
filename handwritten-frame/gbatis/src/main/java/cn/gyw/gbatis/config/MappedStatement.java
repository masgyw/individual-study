package cn.gyw.gbatis.config;

/**
 * Mapper SQL 信息封装
 */
public class MappedStatement {

    private String namespace;
    private String id;
    private String resultType;
    private String sql;

    public MappedStatement() {
    }

    public MappedStatement(String namespace) {
        this.namespace = namespace;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
