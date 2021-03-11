SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE community_system DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use community_system;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `uid`           int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
    `user_name`     varchar(20)  DEFAULT NULL COMMENT '用户名',
    `user_name_cn`  varchar(20)  DEFAULT NULL COMMENT '用户姓名',
    `password`      varchar(40)  DEFAULT NULL COMMENT '用户密码',
    `age`           int(3)       DEFAULT NULL COMMENT '年龄',
    `hobby`         varchar(100) DEFAULT NULL COMMENT '爱好',
    `role_id`       int(1)       DEFAULT '0' COMMENT '用户角色',
    `status`        int(1)       DEFAULT '0' COMMENT '用户状态：0 启用；1 禁用；',
    `avatar`		varchar(40)  DEFAULT NULL COMMENT '用户头像',
    `created_time`  datetime     DEFAULT CURRENT_TIMESTAMP,
    `modified_time` datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`uid`),
    KEY `role_id` (`role_id`),
    CONSTRAINT `sys_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `role_id`       int(1)                   NOT NULL AUTO_INCREMENT COMMENT '角色编号',
    `role_name`     varchar(50) DEFAULT NULL COMMENT '角色名称',
    `role_status`   int(1) unsigned zerofill NOT NULL COMMENT '角色状态 0 启用 1 禁用',
    `created_time`  datetime    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_time` datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`role_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for `configuration`
-- ----------------------------
DROP TABLE IF EXISTS `configuration`;
CREATE TABLE `configuration`
(
    `section`         varchar(255) DEFAULT '' COMMENT '项',
    `parameter_key`   varchar(255) DEFAULT '' COMMENT '键',
    `parameter_value` varchar(255) DEFAULT '' COMMENT '值',
    `init_value`      varchar(255) DEFAULT '' COMMENT '初始值',
    PRIMARY KEY (`section`, `parameter_key`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for `apilog{}`
-- ----------------------------
DELIMITER //
CREATE PROCEDURE generateApiLogs(IN tableCnt int)
BEGIN
    DECLARE i int;
    DECLARE tableName varchar(64);

    set i = 0;

    while i < tableCnt
        do
            set tableName = concat('apilog', i);
            set @SQLScript = concat('DROP TABLE IF EXISTS ',
                                    tableName);
            prepare stmt from @SQLScript;
            EXECUTE stmt;
            DEALLOCATE PREPARE stmt;

            set @SQLScript = concat('CREATE TABLE ',
                                    tableName,
                                    '(id int(11) not null auto_increment comment \'唯一编号\',
                                    sequenceNum varchar(255) default \'\' comment \'全局序列号\',
                                    loginAccount varchar(255) default \'\' comment \'当前操作人id\',
                                    host varchar(255) default \'\' comment \'接口主机地址\',
                                    port varchar(16) default \'\' comment \'接口主机端口\',
                                    actionUrl varchar(255) default \'\' comment \'操作请求的链接\',
                                    module varchar(255) default \'\' comment \'执行模块\',
                                    method varchar(255) default \'\' comment \'执行方法\',
                                    description varchar(255) default \'\' comment \'描述\',
                                    requestdata text comment \'请求数据\',
                                    responsecode varchar(16) comment \'响应码\',
                                    responsedata text comment \'响应数据\',
                                    gmtCreate timestamp default current_timestamp comment \'执行时间\',
                                    primary key (id)
                                    ) ENGINE = InnoDB default CHARSET = utf8');
            prepare stmt from @SQLScript;
            EXECUTE stmt;
            DEALLOCATE PREPARE stmt;
            set i = i + 1;
        end while;
END //
DELIMITER ;
CALL generateApiLogs(3);
DROP PROCEDURE generateApiLogs;

-- ----------------------------
-- Table structure for `file_info`
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info`
(
    `uid`          bigint(20) NOT NULL COMMENT '唯一标识',
    `file_id`      varchar(255) DEFAULT NULL COMMENT '文件UUID',
    `file_name`    varchar(255) DEFAULT NULL COMMENT '文件名称',
    `expire`       bigint       DEFAULT -1 COMMENT '过期时长（min）',
    `file_type`    varchar(2)   DEFAULT NULL COMMENT '文件类型',
    `file_dir`     varchar(255) DEFAULT NULL COMMENT '文件存放目录',
    `info_dir`     varchar(255) DEFAULT NULL COMMENT '信息文件存放目录',
    `uploader`     int(11)    NOT NULL DEFAULT -1 COMMENT '文件上传者ID',
    `status`       varchar(64)  DEFAULT NULL COMMENT '文件状态 upload:上传, delete:删除',
    `created_time` datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`uid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

ALTER sys_user ADD CONSTRAINT `sys_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`);
