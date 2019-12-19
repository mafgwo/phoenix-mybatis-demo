package com.mafgwo.phoenixmybatisdemo.mapper;

import com.mafgwo.phoenixmybatisdemo.entity.CrowdItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CrowdItemMapper {

    @Insert("upsert into crowd_item" +
        " (crowd_id, account_id, serial_number, buy_user_id, mobile_phone)" +
        " values" +
        " (#{crowdId,jdbcType=VARCHAR}, #{accountId,jdbcType=VARCHAR}," +
        " #{serialNumber,jdbcType=VARCHAR}, #{buyUserId,jdbcType=VARCHAR}, #{mobilePhone,jdbcType=VARCHAR})")
    int insert(CrowdItem crowdItem);

    @Select("select * from crowd_item where account_id = #{accountId}")
    CrowdItem findByAccountId(String accountId);
}
