package com.bins.bean;

import java.util.List;

public class PageInfo<O> {

    private int currentPage;    //当前页编号（从1开始）
    private int totalPage;      //总页数
    private int totalCount;     //显示数目的总数量
    private int size;           //每页数据量
    private List<O> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<O> getList() {
        return list;
    }

    public int getSize() {
        return size;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setList(List<O> list) {
        this.list = list;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", list=" + list +
                ", size=" + size +
                '}';
    }
}
