package cn.gyw.springboot.webmvc.common;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private Long total;
    private Integer totalPages;
    private Integer pageSize;
    private Integer pageNumber;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(List<T> rows, Long total, Integer pageSize, Integer pageNumber) {
        this.rows = rows;
        this.total = total;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public static <T> PageResult of(List<T> rows, Long total, Integer pageSize, Integer pageNumber) {
        return new PageResult(rows, total, pageSize, pageNumber);
    }
}
