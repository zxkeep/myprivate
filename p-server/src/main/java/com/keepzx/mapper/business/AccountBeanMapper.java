package com.keepzx.mapper.business;

import com.keepzx.domain.bean.UserSignInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountBeanMapper {

    UserSignInfo selectLatelySearchMecicineByUseIdAndMedId(@Param("accId") Integer accId);
}