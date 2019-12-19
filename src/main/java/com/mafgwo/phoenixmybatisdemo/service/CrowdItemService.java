package com.mafgwo.phoenixmybatisdemo.service;

import com.mafgwo.phoenixmybatisdemo.entity.CrowdItem;

public interface CrowdItemService {

    int insert(CrowdItem crowdItem);

    CrowdItem findByAccountId(String accountId);

}
