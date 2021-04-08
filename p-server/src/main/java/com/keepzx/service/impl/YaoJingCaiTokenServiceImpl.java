package com.scxinglin.service.impl;

import com.scxinglin.domain.entity.YaoJingCaiToken;
import com.scxinglin.mapper.base.YaoJingCaiTokenMapper;
import com.scxinglin.service.YaoJingCaiTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class YaoJingCaiTokenServiceImpl extends BaseServiceImpl<YaoJingCaiToken> implements YaoJingCaiTokenService {

    @Autowired
    private YaoJingCaiTokenMapper yaoJingCaiTokenMapper;

    @Override
    public void setBaseMapper() {
        super.setBaseMapper(yaoJingCaiTokenMapper);
    }


}
