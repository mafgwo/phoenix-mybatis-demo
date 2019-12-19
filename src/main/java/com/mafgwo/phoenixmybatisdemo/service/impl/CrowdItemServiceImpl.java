package com.mafgwo.phoenixmybatisdemo.service.impl;

import com.mafgwo.phoenixmybatisdemo.entity.CrowdItem;
import com.mafgwo.phoenixmybatisdemo.mapper.CrowdItemMapper;
import com.mafgwo.phoenixmybatisdemo.service.CrowdItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrowdItemServiceImpl implements CrowdItemService {

    @Autowired
    private CrowdItemMapper crowdItemMapper;

    @Override
    public int insert(CrowdItem crowdItem) {
        return crowdItemMapper.insert(crowdItem);
    }

    @Override
    public CrowdItem findByAccountId(String accountId) {
        return crowdItemMapper.findByAccountId(accountId);
    }
}
