package com.scxinglin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keepzx.config.db.DataSource;
import com.scxinglin.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

@Slf4j
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private Mapper<T> baseMapper;

    @Autowired
    public void setBaseMapper(Mapper<T> baseMapper){
        this.baseMapper = baseMapper;
    }

    public abstract void setBaseMapper();

    @Override
    @Transactional
    public Boolean insertEntity(T t) {
        return baseMapper.insert(t) > 0;
    }

    @Override
    @Transactional
    @DataSource("master")
    public Boolean insertEntitySelective(T t) {
        return baseMapper.insertSelective(t) > 0;
    }

    @Override
    @Transactional
    @DataSource("master")
    public Boolean updateEntity(T t) {
        return baseMapper.updateByPrimaryKey(t) != 0;
    }

    @Override
    @Transactional
    public Boolean updateEntitySelective(T t) {
        return baseMapper.updateByPrimaryKeySelective(t) != 0;
    }

    @Override
    @Transactional
    public Boolean deleteEntityById(Serializable id) {
        return baseMapper.deleteByPrimaryKey(id) != 0;
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public T selectEntityById(Serializable id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public T selectOne(T t) {
        Page<T> page = PageHelper.offsetPage(0,2,true);
        baseMapper.select(t);
        if(CollectionUtils.isNotEmpty(page)){
            if(CollectionUtils.isEmpty(page.getResult())){
                return null;
            }else if(CollectionUtils.isNotEmpty(page.getResult()) && page.getResult().size() == 1){
                return page.getResult().get(0);
            }else if(CollectionUtils.isNotEmpty(page.getResult()) && page.getResult().size() > 1){
                String errMapper = baseMapper.getClass().getInterfaces()[0].getName();
                String errorDomain = t.getClass().getName();
                String errMessage = String.format("guess best error mapper %s", null==t ? errMapper:errorDomain);
                log.error(errMessage+" select one but found more than one!");
                throw new RuntimeException("系统繁忙！");
            }
        }
        return null;
    }

    @Override
    public List<T> select(T t) {
        return baseMapper.select(t);
    }

    @Override
    public Page<T> selectAllByPage(Integer pageIndex, Integer pageSize) {
        Page<T> page = PageHelper.offsetPage((pageIndex-1)*pageSize,pageSize,true);
        baseMapper.selectAll();
        return page;
    }
}
