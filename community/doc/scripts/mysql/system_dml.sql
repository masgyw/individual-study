-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO sys_role
    (role_id, role_name, role_status, created_time, modified_time)
VALUES (1, 'admin', 0, '2020-07-16 10:38:36.0', '2020-07-16 10:38:36.0');

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user
(uid, user_name, user_name_cn, password, age, hobby, role_id, status, created_time, modified_time)
VALUES (1002, 'admin', '管理员', '111111', 23, 'ball', 1, 0, '2020-07-16 10:38:47.0', '2020-07-16 15:27:20.0');
