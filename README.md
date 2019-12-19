### hbase phoenix mybatis demo
#### application.yaml config
```yaml
spring:
  datasource:
    url: jdbc:phoenix:thin:url=http://172.24.30.35:8765;serialization=PROTOBUF

```

#### java code
```java
package com.mafgwo.phoenixmybatisdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.phoenix.queryserver.client.Driver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * hbase phoenix 扫描配置
 *
 * @author mafgwo
 * @since 2019/09/17
 */
@Configuration
@MapperScan(basePackages = "com.mafgwo.phoenixmybatisdemo.mapper")
public class PhoenixForMybatisConfiguration {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource phoenixDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(Driver.class.getName());
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        return druidDataSource;
    }
}

```

#### java mapper
```java
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

```
