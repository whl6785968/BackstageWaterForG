package com.sandalen.water.bean;

import java.util.List;

public class CustomPage<T> {
    private int page;
    private int pageSize;
    private int totalPage;
    private List<T> list;
    private int totalCount;

    public CustomPage(int page,int pageSize,int totalCount){
        this.pageSize = pageSize;
        this.page = page;
        this.totalCount = totalCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getTotalPage(){
        return (int)Math.ceil(totalCount*1.0 / pageSize);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        if (isLastPage(page)){
            this.list = list.subList((page-1)*pageSize,list.size());
        }
        else {
            this.list = list.subList((page-1)*pageSize,page*pageSize);
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isLastPage(int page){
        if (page == getTotalPage()){
            return true;
        }
        return false;
    }
}
