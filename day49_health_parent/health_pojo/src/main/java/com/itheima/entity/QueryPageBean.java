package com.itheima.entity;

import java.io.Serializable;

public class QueryPageBean implements Serializable {

    /**
     * 封装前端查询条件， controller就可以用这个实体类来接收前端过来的参数
     */

        private Integer currentPage;//页码
        private Integer pageSize;//每页记录数
        private String queryString;//查询条件

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public String getQueryString() {
            return queryString;
        }

        public void setQueryString(String queryString) {
            this.queryString = queryString;
        }
    }
