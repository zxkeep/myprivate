package com.scxinglin.service;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * Designer: jack
 * Date: 2018/3/2
 * Version: 1.0.0
 */

public interface BaseService<T> {

    /**
     * 通过Entity插入数据，如果字段为null则插入null
     * @param t Entity
     * @return 是否插入成功
     */
    Boolean insertEntity(T t);

    /**
     * 通过Entity插入数据，如果字段为null则是用默认值
     * @param t Entity
     * @return 是否插入成功
     */
    Boolean insertEntitySelective(T t);

    /**
     * 通过Entity更新数据，如果字段为null则更新为null
     * @param t Entity
     * @return 是否更新成功
     */
    Boolean updateEntity(T t);

    /**
     * 通过Entity更新数据，如果字段为null则不更新
     * @param t Entity
     * @return 是否更新成功
     */
    Boolean updateEntitySelective(T t);

    /**
     * 通过主键Id删除数据
     * @param id 主键Id
     * @return 是否删除成功
     */
    Boolean deleteEntityById(Serializable id);

    /**
     * 查询表中所有数据
     * @return Entity对象列表
     */
    List<T> selectAll();

    /**
     * 根据Entity中的有效字段筛选符合条件的所有数据
     * @param t Entity
     * @return 结果列表
     */
    List<T> select(T t);

    /**
     * 根据Entity中的有效字段筛选符合条件的一条数据
     * @param t Entity
     * @return Entity
     */
    T selectOne(T t);

    /**
     * 根据主键Id筛选符合条件的数据
     * @param id 主键Id
     * @return Entity
     */
    T selectEntityById(Serializable id);

    /**
     * 分页查询所有的数据
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Page<T> selectAllByPage(Integer pageIndex, Integer pageSize);

}

