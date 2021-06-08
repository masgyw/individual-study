package cn.gyw.platform.common.web.model;

import java.io.Serializable;

public class PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 是否更多
     */
    private Boolean hasMore;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public static final class Builder {
        private Integer pageNum;
        private Integer pageSize;
        private Integer totalPage;
        private Long total;
        private Boolean hasMore;

        private Builder() {
        }

        public static Builder aPageInfo() {
            return new Builder();
        }

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder totalPage(Integer totalPage) {
            this.totalPage = totalPage;
            return this;
        }

        public Builder total(Long total) {
            this.total = total;
            return this;
        }

        public Builder hasMore(Boolean hasMore) {
            this.hasMore = hasMore;
            return this;
        }

        public PageInfo build() {
            PageInfo pageInfo = new PageInfo();
            pageInfo.setPageNum(pageNum);
            pageInfo.setPageSize(pageSize);
            pageInfo.setTotalPage(totalPage);
            pageInfo.setTotal(total);
            pageInfo.setHasMore(hasMore);
            return pageInfo;
        }
    }
}
