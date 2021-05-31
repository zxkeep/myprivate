package com.keepzx.mapper.base;

import com.keepzx.domain.entity.Account;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface AccountMapper extends Mapper<Account>, MySqlMapper<Account> {
}