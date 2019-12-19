package com.mafgwo.phoenixmybatisdemo.entity;

import lombok.Data;

@Data
public class CrowdItem {

    private String crowdId;

    private String serialNumber;
    /**
     * 用户ID
     */
    private String accountId;
    private String buyUserId;
    private String mobilePhone;
}
