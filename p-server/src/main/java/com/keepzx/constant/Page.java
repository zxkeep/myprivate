package com.keepzx.constant;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8.
 */
@Data
public class Page<T> implements Serializable{

    private static final long serialVersionUID = -5758859328430957938L;
    private int pageIndex ; //当前第几页
   private int pageSize;  //当前页的大小
   private long totalElements ;  //查询的总数
   private List<T> data;

    public Page() {
    }

    public Page(Page p,List<T> data){
        this.pageIndex = p.getPageIndex();
        this.pageSize = p.getPageSize();
        this.totalElements = p.getTotalElements();
        this.data = data;
    }



    public Page(int pageIndex,int pageSize,int totalElements,List<T> data){
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.data = data;
        this.totalElements = totalElements;
    }



    public Page(com.github.pagehelper.Page<T> passPage) {
        this.pageIndex = passPage.getPageNum();
        this.pageSize = passPage.getPageSize();
        this.totalElements = passPage.getTotal();
        this.data = passPage.getResult();
    }

    public Page(com.github.pagehelper.Page<?> passPage,List<T> data){
        this.pageIndex = passPage.getPageNum();
        this.pageSize = passPage.getPageSize();
        this.totalElements = passPage.getTotal();
        this.data = data;
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        throw new java.io.NotSerializableException("com.scxinglin.constant.Page");
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        throw new java.io.NotSerializableException("com.scxinglin.constant.Page");
    }
}
