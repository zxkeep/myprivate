package com.scxinglin.mapper.business;

import com.scxinglin.domain.bean.UserSignInfo;
import org.springframework.stereotype.Repository;
@Repository
public interface UserSearchHistoryBeanMapper  {
    UserSignInfo selectLatelySearchMecicineByUseIdAndMedId(UserSignInfo userSearchHistoryBean);
}