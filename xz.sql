CREATE TABLE `xz_account` (
  `ACC_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ACC_LOGIN_NAME` varchar(255) NOT NULL COMMENT '账号',
  `ACC_PASSWORD` varchar(255) NOT NULL COMMENT '密码',
  `ACC_NAME` varchar(255) DEFAULT NULL COMMENT '登陆者姓名',
  `ACC_PHONE` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `DATA_DELETE` int(1) NOT NULL DEFAULT '2' COMMENT '数据是否删除（1==是2==否）',
  `CREATE_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_DATETIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `CREATE_USER` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_USER` int(11) DEFAULT NULL COMMENT '修改人',
  `ACC_IS_SUPER` int(1) DEFAULT '2' COMMENT '是否是超级账号',
  PRIMARY KEY (`ACC_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='账号信息表';

-- --------------------------------------------------------------------------------------------------------
CREATE TABLE `xz_material` (
   `MAT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '素材ID',
   `MAT_NAME` varchar(100) NOT NULL COMMENT '素材名称',
   `MAT_SUFFIX` varchar(10) NOT NULL COMMENT '素材后缀',
   `MAT_PATH` varchar(100) NOT NULL COMMENT '素材路径',
   `MAT_CHECKSUM` varchar(32) NOT NULL COMMENT '素材MD5校验和',
   `MAT_LEN` bigint(20) NOT NULL COMMENT '素材长度',
   `MAT_DEL` smallint(6) NOT NULL COMMENT '是否删除 1.是 2.否',
   `CREATE_DATETIME` datetime NOT NULL COMMENT '创建时间',
   `CREATE_USER` int(11) NOT NULL COMMENT '创建员工',
   `MAT_THM_PATH` varchar(100) DEFAULT NULL COMMENT '素材缩略图路径',
   PRIMARY KEY (`MAT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='素材表';

