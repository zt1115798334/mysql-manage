package com.example.mysqlmanage.quartz.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "custom.my-sql-backups")
public class MySqlBackupsProperties {
    private String mysqlHost;
    private String mysqlUsername;
    private String mysqlPassword;
    private String backupsTime;
}
