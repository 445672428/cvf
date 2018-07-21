CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `CLAIM_TIME_` datetime DEFAULT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DUE_DATE_` datetime DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `area_backup` (
  `AREAID` varchar(128) NOT NULL,
  `AREACODE` varchar(128) DEFAULT NULL,
  `AREANAME` varchar(128) NOT NULL,
  `AREALEVEL` varchar(1) NOT NULL,
  `AREAFULLNAME` varchar(200) DEFAULT NULL,
  `PARENTID` varchar(128) NOT NULL,
  `VCHAR1` varchar(32) DEFAULT NULL,
  `VCHAR2` varchar(32) DEFAULT NULL,
  `VCHAR3` varchar(32) DEFAULT NULL,
  `ISUSED` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`AREAID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `basicinfo` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `VALUE` varchar(512) NOT NULL,
  `TYPE` varchar(20) NOT NULL,
  `TAG` varchar(30) DEFAULT NULL,
  `ISALIVE` varchar(1) NOT NULL,
  `VCHAR1` varchar(32) DEFAULT NULL,
  `VCHAR3` varchar(60) DEFAULT NULL,
  `VCHAR2` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bookratings` (
  `User-ID` int(11) NOT NULL DEFAULT '0',
  `ISBN` varchar(13) NOT NULL DEFAULT '',
  `Book-Rating` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`User-ID`,`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_area` (
  `AREAID` varchar(32) NOT NULL,
  `AREANAME` varchar(128) NOT NULL,
  `AREALEVEL` int(11) NOT NULL,
  `AREAFULLNAME` varchar(200) DEFAULT NULL,
  `PARENTID` varchar(32) DEFAULT NULL,
  `SHORTNAME` varchar(32) DEFAULT NULL,
  `ISUNIT` varchar(1) DEFAULT NULL,
  `LASTUPDATE` varchar(14) DEFAULT NULL,
  `YZCODE` varchar(32) DEFAULT NULL,
  `VCHAR1` varchar(300) DEFAULT NULL,
  `VCHAR2` varchar(300) DEFAULT NULL,
  `VCHAR3` varchar(300) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  `VCHAR6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`AREAID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_deploynode` (
  `NODEID` varchar(32) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `SYSID` varchar(32) NOT NULL,
  `URL` varchar(200) NOT NULL,
  `ICON` varchar(500) DEFAULT NULL,
  `SHOWORDER` int(11) NOT NULL,
  `VCHAR1` varchar(200) DEFAULT NULL,
  `VCHAR6` varchar(500) DEFAULT NULL,
  `VCHAR2` varchar(200) DEFAULT NULL,
  `VCHAR3` varchar(200) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`NODEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_log` (
  `LOGID` varchar(32) NOT NULL,
  `USERNAME` varchar(64) NOT NULL,
  `TRUENAME` varchar(20) NOT NULL,
  `CLIENTIP` varchar(32) DEFAULT NULL,
  `OPERTYPE` varchar(32) NOT NULL,
  `MODULENAME` varchar(32) NOT NULL,
  `OPERCONTENT` varchar(600) DEFAULT NULL,
  `OPERDATE` varchar(14) NOT NULL,
  `VCHAR1` varchar(300) DEFAULT NULL,
  `VCHAR2` varchar(300) DEFAULT NULL,
  `VCHAR3` varchar(300) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  `VCHAR6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`LOGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_module` (
  `MODULEID` varchar(32) NOT NULL,
  `SYSID` varchar(32) NOT NULL,
  `NAME` varchar(64) NOT NULL,
  `PARENTID` varchar(32) NOT NULL,
  `URL` varchar(200) DEFAULT NULL,
  `ICON` varchar(500) DEFAULT NULL,
  `SHOWORDER` int(11) NOT NULL,
  `ISUSED` varchar(1) NOT NULL,
  `VCHAR1` varchar(300) DEFAULT NULL,
  `VCHAR2` varchar(300) DEFAULT NULL,
  `VCHAR3` varchar(300) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  `VCHAR6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`MODULEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_operate` (
  `OPERATEID` varchar(32) NOT NULL,
  `OPERATENAME` varchar(100) NOT NULL,
  `OPERATECODE` varchar(64) DEFAULT NULL,
  `METHOD` varchar(200) DEFAULT NULL,
  `MODULEID` varchar(32) DEFAULT NULL,
  `ICON` varchar(500) DEFAULT NULL,
  `SHOWORDER` int(11) NOT NULL,
  `VCHAR1` varchar(300) DEFAULT NULL,
  `VCHAR2` varchar(300) DEFAULT NULL,
  `VCHAR3` varchar(300) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  `VCHAR6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`OPERATEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_role` (
  `ROLEID` varchar(32) NOT NULL,
  `ROLENAME` varchar(128) NOT NULL,
  `ROLEDES` varchar(200) DEFAULT NULL,
  `VCHAR1` varchar(300) DEFAULT NULL,
  `VCHAR2` varchar(300) DEFAULT NULL,
  `VCHAR3` varchar(300) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  `VCHAR6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_rolemodule` (
  `RMID` varchar(32) NOT NULL,
  `RNID` varchar(32) NOT NULL,
  `MODULEID` varchar(32) NOT NULL,
  `VCHAR1` varchar(100) DEFAULT NULL,
  `VCHAR2` varchar(100) DEFAULT NULL,
  `VCHAR3` varchar(200) DEFAULT NULL,
  `VCHAR4` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RMID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_rolenode` (
  `RNID` varchar(32) NOT NULL,
  `RSID` varchar(32) NOT NULL,
  `NODEID` varchar(32) NOT NULL,
  `VCHAR1` varchar(100) DEFAULT NULL,
  `VCHAR2` varchar(100) DEFAULT NULL,
  `VCHAR3` varchar(200) DEFAULT NULL,
  `VCHAR4` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RNID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_roleoperate` (
  `ROID` varchar(32) NOT NULL,
  `RMID` varchar(32) NOT NULL,
  `OPERATEID` varchar(32) NOT NULL,
  `VCHAR1` varchar(100) DEFAULT NULL,
  `VCHAR2` varchar(100) DEFAULT NULL,
  `VCHAR3` varchar(200) DEFAULT NULL,
  `VCHAR4` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ROID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_rolesys` (
  `RSID` varchar(32) NOT NULL,
  `ROLEID` varchar(32) NOT NULL,
  `SYSID` varchar(32) NOT NULL,
  `VCHAR1` varchar(100) DEFAULT NULL,
  `VCHAR2` varchar(100) DEFAULT NULL,
  `VCHAR3` varchar(200) DEFAULT NULL,
  `VCHAR4` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bss_sys_system` (
  `SYSID` varchar(32) NOT NULL,
  `SYSNAME` varchar(64) NOT NULL,
  `URL` varchar(200) DEFAULT NULL,
  `ICON` varchar(500) NOT NULL,
  `SHOWORDER` int(11) DEFAULT NULL,
  `VCHAR1` varchar(300) DEFAULT NULL,
  `VCHAR2` varchar(300) DEFAULT NULL,
  `VCHAR3` varchar(300) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  `VCHAR6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`SYSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bx-book-ratings` (
  `User-ID` int(11) NOT NULL DEFAULT '0',
  `ISBN` varchar(13) NOT NULL DEFAULT '',
  `Book-Rating` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`User-ID`,`ISBN`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `bx-books` (
  `ISBN` varchar(13) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `Book-Title` varchar(255) DEFAULT NULL,
  `Book-Author` varchar(255) DEFAULT NULL,
  `Year-Of-Publication` int(10) unsigned DEFAULT NULL,
  `Publisher` varchar(255) DEFAULT NULL,
  `Image-URL-S` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Image-URL-M` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Image-URL-L` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `bx-users` (
  `User-ID` int(11) NOT NULL DEFAULT '0',
  `Location` varchar(250) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  PRIMARY KEY (`User-ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `china` (
  `name` varchar(80) DEFAULT NULL,
  `code` varchar(12) DEFAULT NULL,
  `parentcode` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全国省市街道';

CREATE TABLE `cms_article` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `category_id` varchar(64) NOT NULL COMMENT '��Ŀ���',
  `title` varchar(255) NOT NULL COMMENT '����',
  `link` varchar(255) DEFAULT NULL COMMENT '��������',
  `color` varchar(50) DEFAULT NULL COMMENT '������ɫ',
  `image` varchar(255) DEFAULT NULL COMMENT '����ͼƬ',
  `keywords` varchar(255) DEFAULT NULL COMMENT '�ؼ���',
  `description` varchar(255) DEFAULT NULL COMMENT '������ժҪ',
  `weight` int(11) DEFAULT '0' COMMENT 'Ȩ�أ�Խ��Խ��ǰ',
  `weight_date` datetime DEFAULT NULL COMMENT 'Ȩ������',
  `hits` int(11) DEFAULT '0' COMMENT '�����',
  `posid` varchar(10) DEFAULT NULL COMMENT '�Ƽ�λ����ѡ',
  `custom_content_view` varchar(255) DEFAULT NULL COMMENT '�Զ���������ͼ',
  `view_config` text COMMENT '��ͼ����',
  `create_by` varchar(64) DEFAULT NULL COMMENT '������',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) DEFAULT NULL COMMENT '������',
  `update_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `cms_article_create_by` (`create_by`),
  KEY `cms_article_title` (`title`),
  KEY `cms_article_keywords` (`keywords`),
  KEY `cms_article_del_flag` (`del_flag`),
  KEY `cms_article_weight` (`weight`),
  KEY `cms_article_update_date` (`update_date`),
  KEY `cms_article_category_id` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���±�';

CREATE TABLE `cms_article_data` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `content` text COMMENT '��������',
  `copyfrom` varchar(255) DEFAULT NULL COMMENT '������Դ',
  `relation` varchar(255) DEFAULT NULL COMMENT '�������',
  `allow_comment` char(1) DEFAULT NULL COMMENT '�Ƿ���������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������';

CREATE TABLE `cms_category` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `parent_id` varchar(64) NOT NULL COMMENT '�������',
  `parent_ids` varchar(2000) NOT NULL COMMENT '���и������',
  `site_id` varchar(64) DEFAULT '1' COMMENT 'վ����',
  `office_id` varchar(64) DEFAULT NULL COMMENT '��������',
  `module` varchar(20) DEFAULT NULL COMMENT '��Ŀģ��',
  `name` varchar(100) NOT NULL COMMENT '��Ŀ����',
  `image` varchar(255) DEFAULT NULL COMMENT '��ĿͼƬ',
  `href` varchar(255) DEFAULT NULL COMMENT '����',
  `target` varchar(20) DEFAULT NULL COMMENT 'Ŀ��',
  `description` varchar(255) DEFAULT NULL COMMENT '����',
  `keywords` varchar(255) DEFAULT NULL COMMENT '�ؼ���',
  `sort` int(11) DEFAULT '30' COMMENT '��������',
  `in_menu` char(1) DEFAULT '1' COMMENT '�Ƿ��ڵ�������ʾ',
  `in_list` char(1) DEFAULT '1' COMMENT '�Ƿ��ڷ���ҳ����ʾ�б�',
  `show_modes` char(1) DEFAULT '0' COMMENT 'չ�ַ�ʽ',
  `allow_comment` char(1) DEFAULT NULL COMMENT '�Ƿ���������',
  `is_audit` char(1) DEFAULT NULL COMMENT '�Ƿ���Ҫ���',
  `custom_list_view` varchar(255) DEFAULT NULL COMMENT '�Զ����б���ͼ',
  `custom_content_view` varchar(255) DEFAULT NULL COMMENT '�Զ���������ͼ',
  `view_config` text COMMENT '��ͼ����',
  `create_by` varchar(64) DEFAULT NULL COMMENT '������',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) DEFAULT NULL COMMENT '������',
  `update_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `cms_category_parent_id` (`parent_id`),
  KEY `cms_category_module` (`module`),
  KEY `cms_category_name` (`name`),
  KEY `cms_category_sort` (`sort`),
  KEY `cms_category_del_flag` (`del_flag`),
  KEY `cms_category_office_id` (`office_id`),
  KEY `cms_category_site_id` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ŀ��';

CREATE TABLE `cms_comment` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `category_id` varchar(64) NOT NULL COMMENT '��Ŀ���',
  `content_id` varchar(64) NOT NULL COMMENT '��Ŀ���ݵı��',
  `title` varchar(255) DEFAULT NULL COMMENT '��Ŀ���ݵı���',
  `content` varchar(255) DEFAULT NULL COMMENT '��������',
  `name` varchar(100) DEFAULT NULL COMMENT '��������',
  `ip` varchar(100) DEFAULT NULL COMMENT '����IP',
  `create_date` datetime NOT NULL COMMENT '����ʱ��',
  `audit_user_id` varchar(64) DEFAULT NULL COMMENT '�����',
  `audit_date` datetime DEFAULT NULL COMMENT '���ʱ��',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `cms_comment_category_id` (`category_id`),
  KEY `cms_comment_content_id` (`content_id`),
  KEY `cms_comment_status` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���۱�';

CREATE TABLE `cms_guestbook` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `type` char(1) NOT NULL COMMENT '���Է���',
  `content` varchar(255) NOT NULL COMMENT '��������',
  `name` varchar(100) NOT NULL COMMENT '����',
  `email` varchar(100) NOT NULL COMMENT '����',
  `phone` varchar(100) NOT NULL COMMENT '�绰',
  `workunit` varchar(100) NOT NULL COMMENT '��λ',
  `ip` varchar(100) NOT NULL COMMENT 'IP',
  `create_date` datetime NOT NULL COMMENT '����ʱ��',
  `re_user_id` varchar(64) DEFAULT NULL COMMENT '�ظ���',
  `re_date` datetime DEFAULT NULL COMMENT '�ظ�ʱ��',
  `re_content` varchar(100) DEFAULT NULL COMMENT '�ظ�����',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `cms_guestbook_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���԰�';

CREATE TABLE `cms_link` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `category_id` varchar(64) NOT NULL COMMENT '��Ŀ���',
  `title` varchar(255) NOT NULL COMMENT '��������',
  `color` varchar(50) DEFAULT NULL COMMENT '������ɫ',
  `image` varchar(255) DEFAULT NULL COMMENT '����ͼƬ',
  `href` varchar(255) DEFAULT NULL COMMENT '���ӵ�ַ',
  `weight` int(11) DEFAULT '0' COMMENT 'Ȩ�أ�Խ��Խ��ǰ',
  `weight_date` datetime DEFAULT NULL COMMENT 'Ȩ������',
  `create_by` varchar(64) DEFAULT NULL COMMENT '������',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) DEFAULT NULL COMMENT '������',
  `update_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `cms_link_category_id` (`category_id`),
  KEY `cms_link_title` (`title`),
  KEY `cms_link_del_flag` (`del_flag`),
  KEY `cms_link_weight` (`weight`),
  KEY `cms_link_create_by` (`create_by`),
  KEY `cms_link_update_date` (`update_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��������';

CREATE TABLE `cms_site` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `name` varchar(100) NOT NULL COMMENT 'վ������',
  `title` varchar(100) NOT NULL COMMENT 'վ�����',
  `logo` varchar(255) DEFAULT NULL COMMENT 'վ��Logo',
  `domain` varchar(255) DEFAULT NULL COMMENT 'վ������',
  `description` varchar(255) DEFAULT NULL COMMENT '����',
  `keywords` varchar(255) DEFAULT NULL COMMENT '�ؼ���',
  `theme` varchar(255) DEFAULT 'default' COMMENT '����',
  `copyright` text COMMENT '��Ȩ��Ϣ',
  `custom_index_view` varchar(255) DEFAULT NULL COMMENT '�Զ���վ����ҳ��ͼ',
  `create_by` varchar(64) DEFAULT NULL COMMENT '������',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) DEFAULT NULL COMMENT '������',
  `update_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `cms_site_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='վ���';

CREATE TABLE `core_admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` int(10) unsigned DEFAULT NULL,
  `deleted_flag` tinyint(3) unsigned NOT NULL,
  `sort` int(10) unsigned NOT NULL,
  `status` tinyint(3) unsigned NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` int(10) unsigned DEFAULT NULL,
  `fullname` varchar(30) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `core_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `password` varchar(32) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `deleted_flag` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `created_by` int(10) unsigned DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` int(10) unsigned DEFAULT NULL,
  `sort` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

CREATE TABLE `crawlerurl` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `url` varchar(254) NOT NULL COMMENT '保存爬虫下载了的url',
  PRIMARY KEY (`id`,`url`)
) ENGINE=InnoDB AUTO_INCREMENT=72556 DEFAULT CHARSET=utf8 COMMENT='保存爬虫下载了的url数据';

CREATE TABLE `crawlerurlssq` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `issue` varchar(10) NOT NULL COMMENT '双色球期号',
  `number1` int(2) NOT NULL,
  `number2` int(2) NOT NULL,
  `number3` int(2) NOT NULL,
  `number4` int(2) NOT NULL,
  `number5` int(2) NOT NULL,
  `number6` int(2) NOT NULL,
  `number7` int(2) NOT NULL,
  `url` varchar(254) NOT NULL COMMENT '保存爬虫下载了的url',
  PRIMARY KEY (`id`,`url`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8 COMMENT='双色球保存爬虫下载了的url数据';

CREATE TABLE `dbs` (
  `id` varchar(32) NOT NULL,
  `user` varchar(32) NOT NULL,
  `dbname` varchar(200) NOT NULL,
  `type` varchar(64) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `port` int(11) NOT NULL,
  `url` varchar(254) NOT NULL,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `commont` varchar(254) DEFAULT NULL,
  `driver` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dbname` (`dbname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `dictinfo` (
  `ID` varchar(32) NOT NULL,
  `DICTCODE` varchar(32) DEFAULT NULL,
  `TYPECODE` varchar(32) NOT NULL,
  `INFO` varchar(64) NOT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `UPDATETIME` varchar(16) DEFAULT NULL,
  `DICTSORT` decimal(22,0) DEFAULT NULL,
  `ISENABLE` varchar(1) NOT NULL,
  `VALUETYPE` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `dicttype` (
  `TYPECODE` varchar(32) NOT NULL,
  `TYPENAME` varchar(64) NOT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `TYPESORT` decimal(22,0) DEFAULT NULL,
  `CODELENGTH` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`TYPECODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `fileinfo` (
  `fileName` varchar(100) DEFAULT NULL,
  `md5` varchar(32) DEFAULT NULL,
  `uploadDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='上传文件数据';

CREATE TABLE `filetable` (
  `id` varchar(32) DEFAULT NULL COMMENT '文件id',
  `userid` varchar(32) DEFAULT NULL COMMENT '文件对应用户',
  `filename` varchar(250) DEFAULT NULL COMMENT '文件名称',
  `level` int(11) DEFAULT NULL COMMENT '文件夹等级',
  `ishidden` tinyint(1) DEFAULT NULL COMMENT '是否隐藏',
  `parentid` varchar(32) DEFAULT NULL,
  `description` text COMMENT '文件描述',
  `subName` text COMMENT '拼接上层文件夹名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件夹表结构';

CREATE TABLE `gen_scheme` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `name` varchar(200) DEFAULT NULL COMMENT '����',
  `category` varchar(2000) DEFAULT NULL COMMENT '����',
  `package_name` varchar(500) DEFAULT NULL COMMENT '���ɰ�·��',
  `module_name` varchar(30) DEFAULT NULL COMMENT '����ģ����',
  `sub_module_name` varchar(30) DEFAULT NULL COMMENT '������ģ����',
  `function_name` varchar(500) DEFAULT NULL COMMENT '���ɹ�����',
  `function_name_simple` varchar(100) DEFAULT NULL COMMENT '���ɹ���������д��',
  `function_author` varchar(100) DEFAULT NULL COMMENT '���ɹ�������',
  `gen_table_id` varchar(200) DEFAULT NULL COMMENT '���ɱ���',
  `create_by` varchar(64) DEFAULT NULL COMMENT '������',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) DEFAULT NULL COMMENT '������',
  `update_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�0��������1��ɾ����',
  PRIMARY KEY (`id`),
  KEY `gen_scheme_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���ɷ���';

CREATE TABLE `gen_table` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `name` varchar(200) DEFAULT NULL COMMENT '����',
  `comments` varchar(500) DEFAULT NULL COMMENT '����',
  `class_name` varchar(100) DEFAULT NULL COMMENT 'ʵ��������',
  `parent_table` varchar(200) DEFAULT NULL COMMENT '��������',
  `parent_table_fk` varchar(100) DEFAULT NULL COMMENT '�����������',
  `create_by` varchar(64) DEFAULT NULL COMMENT '������',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) DEFAULT NULL COMMENT '������',
  `update_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�0��������1��ɾ����',
  PRIMARY KEY (`id`),
  KEY `gen_table_name` (`name`),
  KEY `gen_table_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ҵ���';

CREATE TABLE `gen_table_column` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `gen_table_id` varchar(64) DEFAULT NULL COMMENT '��������',
  `name` varchar(200) DEFAULT NULL COMMENT '����',
  `comments` varchar(500) DEFAULT NULL COMMENT '����',
  `jdbc_type` varchar(100) DEFAULT NULL COMMENT '�е��������͵��ֽڳ���',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA����',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA�ֶ���',
  `is_pk` char(1) DEFAULT NULL COMMENT '�Ƿ�����',
  `is_null` char(1) DEFAULT NULL COMMENT '�Ƿ��Ϊ��',
  `is_insert` char(1) DEFAULT NULL COMMENT '�Ƿ�Ϊ�����ֶ�',
  `is_edit` char(1) DEFAULT NULL COMMENT '�Ƿ�༭�ֶ�',
  `is_list` char(1) DEFAULT NULL COMMENT '�Ƿ��б��ֶ�',
  `is_query` char(1) DEFAULT NULL COMMENT '�Ƿ��ѯ�ֶ�',
  `query_type` varchar(200) DEFAULT NULL COMMENT '��ѯ��ʽ�����ڡ������ڡ����ڡ�С�ڡ���Χ����LIKE����LIKE������LIKE��',
  `show_type` varchar(200) DEFAULT NULL COMMENT '�ֶ����ɷ������ı����ı��������򡢸�ѡ�򡢵�ѡ���ֵ�ѡ����Աѡ�񡢲���ѡ������ѡ��',
  `dict_type` varchar(200) DEFAULT NULL COMMENT '�ֵ�����',
  `settings` varchar(2000) DEFAULT NULL COMMENT '�������ã���չ�ֶ�JSON��',
  `sort` decimal(10,0) DEFAULT NULL COMMENT '��������',
  `create_by` varchar(64) DEFAULT NULL COMMENT '������',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) DEFAULT NULL COMMENT '������',
  `update_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�0��������1��ɾ����',
  PRIMARY KEY (`id`),
  KEY `gen_table_column_table_id` (`gen_table_id`),
  KEY `gen_table_column_name` (`name`),
  KEY `gen_table_column_sort` (`sort`),
  KEY `gen_table_column_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ҵ����ֶ�';

CREATE TABLE `gen_template` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `name` varchar(200) DEFAULT NULL COMMENT '����',
  `category` varchar(2000) DEFAULT NULL COMMENT '����',
  `file_path` varchar(500) DEFAULT NULL COMMENT '�����ļ�·��',
  `file_name` varchar(200) DEFAULT NULL COMMENT '�����ļ���',
  `content` text COMMENT '����',
  `create_by` varchar(64) DEFAULT NULL COMMENT '������',
  `create_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) DEFAULT NULL COMMENT '������',
  `update_date` datetime DEFAULT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�0��������1��ɾ����',
  PRIMARY KEY (`id`),
  KEY `gen_template_del_falg` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='����ģ���';

CREATE TABLE `gysypml` (
  `ID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `USERGYSID` varchar(64) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK487508178973E2D1` (`YPXXID`),
  CONSTRAINT `FK487508178973E2D1` FOREIGN KEY (`YPXXID`) REFERENCES `ypxx` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `gysypml_control` (
  `ID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `USERGYSID` varchar(64) NOT NULL,
  `CONTROL` varchar(1) NOT NULL,
  `ADVICE` varchar(128) DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK692599158973E2D1` (`YPXXID`),
  CONSTRAINT `FK692599158973E2D1` FOREIGN KEY (`YPXXID`) REFERENCES `ypxx` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `hotle` (
  `name` varchar(120) DEFAULT NULL,
  `CardNo` varchar(10) DEFAULT NULL,
  `Descriot` varchar(150) DEFAULT NULL,
  `CtfTp` varchar(6) DEFAULT NULL,
  `card` varchar(60) DEFAULT NULL,
  `Gender` varchar(8) DEFAULT NULL,
  `birthday` varchar(9) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `Zip` varchar(32) DEFAULT NULL,
  `Dirty` varchar(56) DEFAULT NULL,
  `District1` varchar(6) DEFAULT NULL,
  `District2` varchar(12) DEFAULT NULL,
  `District3` varchar(6) DEFAULT NULL,
  `District4` varchar(18) DEFAULT NULL,
  `District5` varchar(21) DEFAULT NULL,
  `District6` varchar(19) DEFAULT NULL,
  `FirstNm` varchar(40) DEFAULT NULL,
  `LastNm` varchar(40) DEFAULT NULL,
  `Duty` varchar(48) DEFAULT NULL,
  `Mobile` varchar(64) DEFAULT NULL,
  `Tel` varchar(50) DEFAULT NULL,
  `Fax` varchar(70) DEFAULT NULL,
  `EMail` varchar(84) DEFAULT NULL,
  `Nation` text,
  `Taste` varchar(140) DEFAULT NULL,
  `Education` varchar(48) DEFAULT NULL,
  `Company` varchar(92) DEFAULT NULL,
  `CTel` varchar(60) DEFAULT NULL,
  `CAddress` varchar(108) DEFAULT NULL,
  `CZip` varchar(8) DEFAULT NULL,
  `Family` varchar(12) DEFAULT NULL,
  `version` varchar(20) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  KEY `id` (`id`),
  KEY `index_name` (`name`),
  KEY `index_card` (`card`),
  KEY `index_birthday` (`birthday`),
  KEY `index_address` (`address`),
  KEY `index_version` (`version`)
) ENGINE=MyISAM AUTO_INCREMENT=20050146 DEFAULT CHARSET=utf8;

CREATE TABLE `images` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '图片名称',
  `url` varchar(100) DEFAULT NULL,
  `code` smallint(1) DEFAULT NULL COMMENT '1代表女0代表男2代表人妖',
  `tag` smallint(1) DEFAULT NULL COMMENT '1-16(1),17-26(2),27-35(3),36-42(4),43-50(5),50-60(6),60以上(7)',
  `appname` varchar(40) DEFAULT NULL COMMENT '链接到的应用',
  `flag` tinyint(1) DEFAULT NULL COMMENT '是否可用',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `oldurl` varchar(250) DEFAULT NULL,
  `width` int(4) DEFAULT NULL,
  `height` int(4) DEFAULT NULL,
  `uindex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片信息';

CREATE TABLE `memory` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(32) DEFAULT NULL COMMENT '用户',
  `data_scale` varchar(4) DEFAULT NULL COMMENT '旋转',
  `data_y` varchar(6) DEFAULT NULL COMMENT 'y轴值',
  `data_x` varchar(6) DEFAULT NULL COMMENT 'x轴值',
  `tag` varchar(6) DEFAULT NULL COMMENT 'tag为div的id',
  `year` varchar(4) DEFAULT NULL COMMENT '年',
  `time` varchar(5) DEFAULT NULL COMMENT '日期',
  `item_title1` varchar(100) DEFAULT NULL COMMENT 'H2——1标题',
  `item_title2` varchar(100) DEFAULT NULL COMMENT 'H2——2标题',
  `show_img1` varchar(254) DEFAULT NULL COMMENT 'img——1图片',
  `show_img2` varchar(254) DEFAULT NULL COMMENT 'img——2图片',
  `music` varchar(254) DEFAULT NULL COMMENT '背景音乐',
  `show_p` varchar(255) DEFAULT NULL COMMENT '文本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='记录轴数据';

CREATE TABLE `oa_leave` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `process_instance_id` varchar(64) DEFAULT NULL COMMENT '����ʵ�����',
  `start_time` datetime DEFAULT NULL COMMENT '��ʼʱ��',
  `end_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `leave_type` varchar(20) DEFAULT NULL COMMENT '�������',
  `reason` varchar(255) DEFAULT NULL COMMENT '�������',
  `apply_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `reality_start_time` datetime DEFAULT NULL COMMENT 'ʵ�ʿ�ʼʱ��',
  `reality_end_time` datetime DEFAULT NULL COMMENT 'ʵ�ʽ���ʱ��',
  `create_by` varchar(64) NOT NULL COMMENT '������',
  `create_date` datetime NOT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) NOT NULL COMMENT '������',
  `update_date` datetime NOT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `oa_leave_create_by` (`create_by`),
  KEY `oa_leave_process_instance_id` (`process_instance_id`),
  KEY `oa_leave_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������̱�';

CREATE TABLE `oa_notify` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `type` char(1) DEFAULT NULL COMMENT '����',
  `title` varchar(200) DEFAULT NULL COMMENT '����',
  `content` varchar(2000) DEFAULT NULL COMMENT '����',
  `files` varchar(2000) DEFAULT NULL COMMENT '����',
  `status` char(1) DEFAULT NULL COMMENT '״̬',
  `create_by` varchar(64) NOT NULL COMMENT '������',
  `create_date` datetime NOT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) NOT NULL COMMENT '������',
  `update_date` datetime NOT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `oa_notify_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='֪ͨͨ��';

CREATE TABLE `oa_notify_record` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `oa_notify_id` varchar(64) DEFAULT NULL COMMENT '֪ͨͨ��ID',
  `user_id` varchar(64) DEFAULT NULL COMMENT '������',
  `read_flag` char(1) DEFAULT '0' COMMENT '�Ķ����',
  `read_date` date DEFAULT NULL COMMENT '�Ķ�ʱ��',
  PRIMARY KEY (`id`),
  KEY `oa_notify_record_notify_id` (`oa_notify_id`),
  KEY `oa_notify_record_user_id` (`user_id`),
  KEY `oa_notify_record_read_flag` (`read_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='֪ͨͨ�淢�ͼ�¼';

CREATE TABLE `oa_test_audit` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `PROC_INS_ID` varchar(64) DEFAULT NULL COMMENT '����ʵ��ID',
  `USER_ID` varchar(64) DEFAULT NULL COMMENT '�䶯�û�',
  `OFFICE_ID` varchar(64) DEFAULT NULL COMMENT '��������',
  `POST` varchar(255) DEFAULT NULL COMMENT '��λ',
  `AGE` char(1) DEFAULT NULL COMMENT '�Ա�',
  `EDU` varchar(255) DEFAULT NULL COMMENT 'ѧ��',
  `CONTENT` varchar(255) DEFAULT NULL COMMENT '����ԭ��',
  `OLDA` varchar(255) DEFAULT NULL COMMENT '���б�׼ н�굵��',
  `OLDB` varchar(255) DEFAULT NULL COMMENT '���б�׼ �¹��ʶ�',
  `OLDC` varchar(255) DEFAULT NULL COMMENT '���б�׼ ��н�ܶ�',
  `NEWA` varchar(255) DEFAULT NULL COMMENT '�������׼ н�굵��',
  `NEWB` varchar(255) DEFAULT NULL COMMENT '�������׼ �¹��ʶ�',
  `NEWC` varchar(255) DEFAULT NULL COMMENT '�������׼ ��н�ܶ�',
  `ADD_NUM` varchar(255) DEFAULT NULL COMMENT '������',
  `EXE_DATE` varchar(255) DEFAULT NULL COMMENT 'ִ��ʱ��',
  `HR_TEXT` varchar(255) DEFAULT NULL COMMENT '������Դ�������',
  `LEAD_TEXT` varchar(255) DEFAULT NULL COMMENT '�ֹ��쵼���',
  `MAIN_LEAD_TEXT` varchar(255) DEFAULT NULL COMMENT '������Ҫ�쵼���',
  `create_by` varchar(64) NOT NULL COMMENT '������',
  `create_date` datetime NOT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) NOT NULL COMMENT '������',
  `update_date` datetime NOT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `OA_TEST_AUDIT_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������̲��Ա�';

CREATE TABLE `personal` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `information` text,
  `introduction` text,
  `birthday` varchar(8) DEFAULT NULL COMMENT '出生日期',
  `place` varchar(40) DEFAULT NULL COMMENT '出生地',
  `age` tinyint(1) DEFAULT NULL COMMENT '年龄',
  `nationality` varchar(40) DEFAULT NULL,
  `nativePlace` varchar(60) DEFAULT NULL,
  `flag` smallint(1) DEFAULT NULL COMMENT '是否可用',
  `role` varchar(80) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人信息';

CREATE TABLE `post` (
  `id` varchar(6) DEFAULT NULL,
  `postNumber` varchar(24) DEFAULT NULL,
  `province` varchar(36) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `district` varchar(240) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `jd` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全国邮政数据';

CREATE TABLE `prediction` (
  `product_id` int(5) NOT NULL,
  `product_month` date NOT NULL COMMENT '产品日期',
  `ciiquantity_month` int(6) DEFAULT NULL COMMENT '质量日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品数据';

CREATE TABLE `product_info` (
  `product_id` varchar(14) NOT NULL,
  `district_id1` varchar(40) DEFAULT NULL,
  `district_id2` varchar(40) DEFAULT NULL,
  `district_id3` varchar(40) DEFAULT NULL,
  `district_id4` varchar(40) DEFAULT NULL,
  `lat` varchar(40) DEFAULT NULL,
  `lon` varchar(40) DEFAULT NULL,
  `railway` varchar(40) DEFAULT NULL,
  `airport` varchar(40) DEFAULT NULL,
  `citycenter` varchar(40) DEFAULT NULL,
  `railway2` varchar(40) DEFAULT NULL,
  `airport2` varchar(40) DEFAULT NULL,
  `citycenter2` varchar(40) DEFAULT NULL,
  `eval` varchar(40) DEFAULT NULL,
  `eval2` varchar(40) DEFAULT NULL,
  `eval3` varchar(40) DEFAULT NULL,
  `eval4` varchar(40) DEFAULT NULL,
  `voters` varchar(40) DEFAULT NULL,
  `startdate` varchar(40) DEFAULT NULL,
  `upgradedate` varchar(40) DEFAULT NULL,
  `cooperatedate` varchar(40) DEFAULT NULL,
  `maxstock` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品线路数据';

CREATE TABLE `product_quantity` (
  `product_id` varchar(20) NOT NULL,
  `product_date` varchar(30) DEFAULT NULL COMMENT '生产日期',
  `orderattribute1` varchar(14) DEFAULT NULL COMMENT '商品属性1',
  `orderattribute2` varchar(14) DEFAULT NULL COMMENT '商品属性2',
  `orderattribute3` varchar(14) DEFAULT NULL COMMENT '商品属性3',
  `orderattribute4` varchar(14) DEFAULT NULL COMMENT '商品属性4',
  `ciiquantity` varchar(14) DEFAULT NULL COMMENT '质量1',
  `ordquantity` varchar(14) DEFAULT NULL COMMENT '质量2',
  `price` varchar(14) DEFAULT NULL COMMENT '价格'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品质量数据';

CREATE TABLE `region_station` (
  `name` varchar(20) NOT NULL,
  `code` varchar(10) DEFAULT NULL,
  `west` double NOT NULL,
  `east` double NOT NULL,
  `south` double NOT NULL,
  `north` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `relationship` (
  `auth` varchar(80) DEFAULT NULL,
  `relation` varchar(80) DEFAULT NULL,
  `target` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关系图';

CREATE TABLE `reports` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `alt` varchar(100) DEFAULT NULL COMMENT '图片文字提示',
  `height` int(11) DEFAULT NULL COMMENT '图片高度',
  `width` int(11) DEFAULT NULL COMMENT '图片宽度',
  `src1` varchar(254) DEFAULT NULL COMMENT '预览图片路径',
  `src2` text COMMENT '预览图片路径按照;@@;分割多张图片路径',
  `classify` varchar(20) DEFAULT NULL COMMENT '分类',
  `ctime` varchar(20) DEFAULT NULL COMMENT '时间',
  `heat` varchar(32) DEFAULT NULL COMMENT '热度',
  `content` text COMMENT '内容',
  `lastupdate` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42789 DEFAULT CHARSET=utf8 COMMENT='娱乐新闻数据';

CREATE TABLE `shop_address` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `area_id` varchar(64) DEFAULT NULL,
  `is_default` char(1) DEFAULT NULL,
  `cookie_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_cart` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `cookie_id` varchar(64) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `app_cart_cookie_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_cart_item` (
  `id` varchar(64) NOT NULL,
  `cart_id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` tinyint(3) unsigned NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `count` int(10) unsigned NOT NULL DEFAULT '0',
  `product_id` varchar(64) NOT NULL,
  `is_ordered` char(1) NOT NULL DEFAULT '0',
  `is_selected` char(1) NOT NULL DEFAULT '1',
  `user_id` char(64) DEFAULT NULL,
  `cookie_id` char(64) DEFAULT NULL,
  `app_cart_cookie_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`,`cart_id`),
  KEY `FKCADACD250FB5F39` (`cart_id`),
  KEY `FKCADACD25CDF5619` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_cart_item_attribute` (
  `id` varchar(64) NOT NULL,
  `item_id` varchar(64) DEFAULT NULL,
  `attribute_item_id` varchar(64) DEFAULT NULL,
  `attribute_item_value_id` varchar(64) DEFAULT NULL,
  `attribute_idstring` varchar(130) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_category` (
  `id` varchar(64) NOT NULL,
  `featured` char(1) DEFAULT '0',
  `image` varchar(255) DEFAULT NULL,
  `featured_image` varchar(255) DEFAULT NULL,
  `image_small` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` varchar(64) NOT NULL DEFAULT '0',
  `sort` int(10) unsigned NOT NULL DEFAULT '999',
  `del_flag` char(1) NOT NULL DEFAULT '0',
  `create_date` date DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `short_description` varchar(255) DEFAULT NULL,
  `app_featured_home` char(1) DEFAULT '0',
  `app_featured_home_sort` int(10) unsigned DEFAULT '999',
  `parent_ids` varchar(2000) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `is_audit` char(1) DEFAULT '1',
  `meta_keywords` varchar(255) DEFAULT NULL,
  `meta_description` varchar(255) DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL COMMENT '�����ӵ�ַ�����ȼ����ߡ�',
  `href_target` char(7) DEFAULT '_blank' COMMENT '�����Ӵ򿪵�Ŀ�괰�ڣ��´��ڴ򿪣�����д����_blank��, Ŀ�꣨_blank��_self��_parent��_top��',
  `image_medium` varchar(1000) DEFAULT NULL,
  `image_large` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_collect_product` (
  `id` varchar(64) NOT NULL,
  `product_id` varchar(64) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_cookie` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_coupon` (
  `id` varchar(64) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `duration_day` int(10) unsigned DEFAULT NULL,
  `duration_day_desc` varchar(20) DEFAULT NULL,
  `count_per_user` int(10) unsigned DEFAULT NULL,
  `used_type` char(1) DEFAULT NULL,
  `used_type_desc` varchar(255) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `type_desc` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_coupon_user` (
  `id` varchar(64) NOT NULL,
  `coupon_id` varchar(64) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `has_used` char(1) DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `type_desc` varchar(255) DEFAULT NULL,
  `duration_day` int(11) DEFAULT NULL,
  `duration_day_desc` varchar(255) DEFAULT NULL,
  `used_type` char(1) DEFAULT NULL,
  `used_type_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_history_product` (
  `id` varchar(64) NOT NULL,
  `product_id` varchar(64) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  `count` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_order` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `address_detail` varchar(255) DEFAULT NULL,
  `address_fullname` varchar(255) NOT NULL,
  `address_telephone` varchar(255) NOT NULL,
  `area_id` varchar(64) NOT NULL,
  `area_name` varchar(255) NOT NULL,
  `area_parent_id` varchar(64) NOT NULL,
  `area_path_ids` varchar(2000) NOT NULL,
  `area_path_names` varchar(2000) NOT NULL,
  `area_simple_name` varchar(2000) DEFAULT NULL,
  `area_zip_code` varchar(255) DEFAULT NULL,
  `cart_id` varchar(64) DEFAULT NULL,
  `cookie_id` varchar(64) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `serial_no` varchar(255) DEFAULT NULL,
  `preorder_id` varchar(64) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `total_count` int(10) unsigned NOT NULL,
  `print_count` int(10) unsigned NOT NULL DEFAULT '0',
  `coupon_user_id` varchar(64) DEFAULT NULL,
  `coupon_user_total_price` decimal(10,2) DEFAULT NULL,
  `origin_total_price` decimal(10,2) DEFAULT NULL,
  `address_id` varchar(64) DEFAULT NULL,
  `has_paid` char(1) DEFAULT NULL,
  `pay_type` char(1) DEFAULT NULL,
  `notice` varchar(1000) DEFAULT NULL,
  `rough_pay_type` char(1) DEFAULT NULL,
  `status_id` varchar(64) DEFAULT NULL,
  `op_transaction_id` varchar(64) DEFAULT NULL,
  `status_union` varchar(255) DEFAULT NULL,
  `min_total_price_label` varchar(50) DEFAULT NULL,
  `paid_date` datetime DEFAULT NULL,
  `store_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8B9C26AE8C28AB7B` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_order_item` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `count` int(10) unsigned NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `featured_image` char(1) DEFAULT NULL,
  `image_small` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `product_id` varchar(64) NOT NULL,
  `cart_item_id` varchar(64) DEFAULT NULL,
  `order_id` varchar(64) DEFAULT NULL,
  `preorder_item_id` varchar(64) DEFAULT NULL,
  `subtotal_price` decimal(10,2) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2D110D643AE5AF1C` (`cart_item_id`),
  KEY `FK2D110D64D4FAFCF2` (`preorder_item_id`),
  KEY `FK2D110D645206E979` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_order_item_attribute` (
  `id` varchar(64) NOT NULL,
  `item_id` varchar(64) DEFAULT NULL,
  `attribute_item_id` varchar(64) DEFAULT NULL,
  `attribute_item_value_id` varchar(64) DEFAULT NULL,
  `attribute_idstring` varchar(130) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0',
  `attribute_item_name` varchar(20) DEFAULT NULL,
  `attribute_item_print_name` varchar(20) DEFAULT NULL,
  `attribute_item_sort` int(10) unsigned DEFAULT NULL,
  `attribute_item_value_name` varchar(20) DEFAULT NULL,
  `attribute_item_value_print_name` varchar(20) DEFAULT NULL,
  `attribute_item_value_sort` int(10) unsigned DEFAULT NULL,
  `attribute_item_value_price` decimal(10,0) DEFAULT NULL,
  `attribute_item_value_is_standard` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_order_status` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  `order_id` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `rough_pay_type` char(1) DEFAULT NULL,
  `status_union` varchar(20) DEFAULT NULL COMMENT 'pay_type-status',
  `label` varchar(255) DEFAULT NULL,
  `pending_label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_order_status_process` (
  `id` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  `status_union` char(10) DEFAULT NULL,
  `label` varchar(20) DEFAULT NULL,
  `is_finished` char(1) DEFAULT NULL,
  `step` tinyint(3) unsigned DEFAULT NULL,
  `css_class` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_preorder` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `cart_id` varchar(64) DEFAULT NULL,
  `cookie_id` varchar(64) DEFAULT NULL,
  `total_count` int(10) unsigned NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `is_ordered` char(1) NOT NULL DEFAULT '0',
  `coupon_user_id` varchar(64) DEFAULT NULL,
  `coupon_user_total_price` decimal(10,2) DEFAULT NULL,
  `origin_total_price` decimal(10,2) DEFAULT NULL,
  `area_id` varchar(64) DEFAULT NULL,
  `area_name` varchar(50) DEFAULT NULL,
  `area_parent_id` varchar(64) DEFAULT NULL,
  `area_path_ids` varchar(1000) DEFAULT NULL,
  `area_path_names` varchar(1000) DEFAULT NULL,
  `area_simple_name` varchar(50) DEFAULT NULL,
  `area_zip_code` varchar(10) DEFAULT NULL,
  `address_fullname` varchar(255) DEFAULT NULL,
  `address_telephone` char(11) DEFAULT NULL,
  `address_detail` varchar(255) DEFAULT NULL,
  `address_id` varchar(64) DEFAULT NULL,
  `pay_type` char(1) DEFAULT NULL,
  `product_type` char(1) DEFAULT NULL,
  `rough_pay_type` char(1) DEFAULT NULL,
  `min_total_price_label` varchar(50) DEFAULT NULL,
  `store_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB3B5028B8C28AB7B` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_preorder_item` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `count` int(10) unsigned NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `image_small` varchar(255) DEFAULT NULL,
  `featured_image` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `product_id` varchar(64) NOT NULL,
  `cart_item_id` varchar(64) DEFAULT NULL,
  `preorder_id` varchar(64) DEFAULT NULL,
  `subtotal_price` decimal(10,2) NOT NULL,
  `type` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB1BA10473AE5AF1C` (`cart_item_id`),
  KEY `FKB1BA10473CCC7AFB` (`preorder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_preorder_item_attribute` (
  `id` varchar(64) NOT NULL,
  `item_id` varchar(64) DEFAULT NULL,
  `attribute_item_id` varchar(64) DEFAULT NULL,
  `attribute_item_value_id` varchar(64) DEFAULT NULL,
  `attribute_idstring` varchar(130) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0',
  `attribute_item_name` varchar(20) DEFAULT NULL,
  `attribute_item_print_name` varchar(20) DEFAULT NULL,
  `attribute_item_sort` int(10) unsigned DEFAULT NULL,
  `attribute_item_value_name` varchar(20) DEFAULT NULL,
  `attribute_item_value_print_name` varchar(20) DEFAULT NULL,
  `attribute_item_value_sort` int(10) unsigned DEFAULT NULL,
  `attribute_item_value_price` decimal(10,2) DEFAULT NULL,
  `attribute_item_value_is_standard` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_product` (
  `id` varchar(64) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `featured_image` varchar(255) DEFAULT NULL,
  `image_small` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(10) unsigned DEFAULT '999',
  `del_flag` char(1) DEFAULT '0',
  `create_date` date DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `featured_price` decimal(10,2) DEFAULT NULL,
  `featured_position` varchar(255) DEFAULT NULL,
  `featured_position_sort` int(10) unsigned DEFAULT '999',
  `app_featured_home` char(1) DEFAULT '0',
  `app_featured_home_sort` int(10) unsigned DEFAULT '999',
  `app_featured_image` varchar(255) DEFAULT NULL,
  `short_description` varchar(255) DEFAULT NULL,
  `meta_keywords` varchar(255) DEFAULT NULL,
  `meta_description` varchar(255) DEFAULT NULL,
  `is_audit` char(1) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `featured` char(1) DEFAULT '0',
  `description` text,
  `category_id` varchar(64) DEFAULT NULL,
  `image_medium` varchar(1000) DEFAULT NULL,
  `image_large` varchar(1000) DEFAULT NULL,
  `app_featured_topic` char(1) DEFAULT NULL,
  `app_featured_topic_sort` int(10) unsigned DEFAULT '99',
  `app_long_image1` varchar(1000) DEFAULT NULL,
  `app_long_image2` varchar(1000) DEFAULT NULL,
  `app_long_image3` varchar(1000) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `app_long_image4` varchar(255) DEFAULT NULL,
  `app_long_image5` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT '1' COMMENT 'çŠ¶æ€ï¼Œ0:éšè—ï¼Œ1:æ˜¾ç¤º',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_product_attribute` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '1',
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `item_id` varchar(64) NOT NULL,
  `product_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC1C0E2AC5CDF5619` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_product_attribute_item` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  `sort` int(10) unsigned NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `print_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_product_attribute_item_value` (
  `id` varchar(64) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  `sort` int(10) unsigned NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `item_id` varchar(64) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `print_name` varchar(20) DEFAULT NULL,
  `is_standard` char(1) NOT NULL DEFAULT '0' COMMENT '�Ƿ��׼������ֵ�����������ǰ̨����ӡ����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_sezi` (
  `id` varchar(64) NOT NULL,
  `num` char(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0',
  `user_id` varchar(64) DEFAULT NULL,
  `is_max_in_day` char(1) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shop_store` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `sort` int(11) NOT NULL DEFAULT '999',
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `del_flag` char(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `stockday` (
  `times` varchar(10) NOT NULL COMMENT '日期',
  `vprice` float(10,3) DEFAULT NULL COMMENT '价格',
  `hprice` float(10,3) DEFAULT NULL COMMENT '价格',
  `xprice` float(10,3) DEFAULT NULL COMMENT '价格',
  `yprice` float(10,3) DEFAULT NULL COMMENT '价格',
  `eprice` decimal(15,2) DEFAULT NULL COMMENT '价格',
  `tprice` decimal(24,2) DEFAULT NULL COMMENT '价格'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='每日股票数据';

CREATE TABLE `stockmin` (
  `times` varchar(10) NOT NULL COMMENT '日期',
  `min` varchar(8) DEFAULT NULL COMMENT '分钟',
  `vprice` float(10,3) DEFAULT NULL COMMENT '价格',
  `hprice` float(10,3) DEFAULT NULL COMMENT '价格',
  `xprice` float(10,3) DEFAULT NULL COMMENT '价格',
  `yprice` float(10,3) DEFAULT NULL COMMENT '价格',
  `eprice` decimal(15,2) DEFAULT NULL COMMENT '价格',
  `tprice` decimal(24,2) DEFAULT NULL COMMENT '价格'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='每5分钟股票数据';

CREATE TABLE `sys_app` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(96) NOT NULL COMMENT '应用名称',
  `aliasname` varchar(96) NOT NULL COMMENT '应用别名',
  `urlFunctionName` varchar(96) NOT NULL COMMENT '功能名称',
  `urlName` varchar(254) NOT NULL COMMENT '应用绝对url地址',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`,`name`),
  UNIQUE KEY `uq_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用信息表';

CREATE TABLE `sys_area` (
  `id` varchar(64) NOT NULL,
  `parent_id` varchar(64) NOT NULL,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `simple_name` varchar(30) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  `area_number` varchar(10) DEFAULT NULL,
  `level` tinyint(3) unsigned NOT NULL,
  `path_ids` varchar(2000) DEFAULT NULL,
  `path_names` varchar(2000) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `parent_ids` varchar(2000) DEFAULT NULL,
  `type` char(1) DEFAULT NULL COMMENT '��������',
  `sort` int(11) DEFAULT '9999',
  `shipping_group` char(1) DEFAULT NULL COMMENT '1:��������,',
  `store_id` varchar(64) DEFAULT NULL COMMENT '����id��һ����ַ����һ�����̣����ݵ�������ӡ����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_area_origin` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `parent_id` varchar(64) NOT NULL COMMENT '�������',
  `parent_ids` varchar(2000) NOT NULL COMMENT '���и������',
  `name` varchar(100) NOT NULL COMMENT '����',
  `sort` decimal(10,0) NOT NULL COMMENT '����',
  `code` varchar(100) DEFAULT NULL COMMENT '�������',
  `type` char(1) DEFAULT NULL COMMENT '��������',
  `create_by` varchar(64) NOT NULL COMMENT '������',
  `create_date` datetime NOT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) NOT NULL COMMENT '������',
  `update_date` datetime NOT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����';

CREATE TABLE `sys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL COMMENT '����',
  `key` varchar(64) NOT NULL COMMENT '��',
  `value` varchar(1000) NOT NULL COMMENT 'ֵ',
  `code` varchar(64) DEFAULT NULL COMMENT '����',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '����',
  `sort` int(11) NOT NULL DEFAULT '10' COMMENT '�����',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ϵͳ���ñ�';

CREATE TABLE `sys_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT '0' COMMENT '�ϼ�����',
  `name` varchar(32) NOT NULL COMMENT '����/11111',
  `code` varchar(128) DEFAULT NULL COMMENT '��������',
  `sort` int(11) DEFAULT '0' COMMENT '���',
  `linkman` varchar(64) DEFAULT NULL COMMENT '��ϵ��',
  `linkman_no` varchar(32) DEFAULT NULL COMMENT '��ϵ�˵绰',
  `remark` varchar(128) DEFAULT NULL COMMENT '��������',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='����';

CREATE TABLE `sys_dict` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `dict_name` varchar(256) NOT NULL COMMENT '����',
  `dict_type` varchar(64) NOT NULL COMMENT '����',
  `dict_remark` varchar(256) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `UK_SYS_DICT_TYPE` (`dict_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����ֵ�����';

CREATE TABLE `sys_dict_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `dict_type` varchar(64) NOT NULL COMMENT '�����ֵ�����',
  `detail_name` varchar(256) DEFAULT NULL COMMENT '����',
  `detail_code` varchar(32) DEFAULT NULL COMMENT '����',
  `detail_sort` varchar(32) DEFAULT NULL COMMENT '�����',
  `detail_type` varchar(32) DEFAULT NULL COMMENT '����',
  `detail_state` varchar(32) DEFAULT NULL COMMENT '״̬',
  `detail_content` varchar(256) DEFAULT NULL COMMENT '����',
  `detail_remark` varchar(256) DEFAULT NULL COMMENT '��ע',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='�����ֵ�';

CREATE TABLE `sys_element` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(96) NOT NULL COMMENT '要素名称',
  `pid` varchar(96) NOT NULL COMMENT '要素所属',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`,`name`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='要素信息表';

CREATE TABLE `sys_file_upload` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(256) NOT NULL DEFAULT '' COMMENT '����',
  `path` varchar(512) NOT NULL DEFAULT '' COMMENT '�ļ�·��',
  `factpath` varchar(512) NOT NULL COMMENT 'ʵ��·��',
  `ext` varchar(32) NOT NULL COMMENT '��׺',
  `originalname` varchar(256) NOT NULL COMMENT 'ԭ����',
  `type` int(11) NOT NULL DEFAULT '9' COMMENT '����',
  `size` int(11) NOT NULL DEFAULT '0' COMMENT '��С',
  `remark` varchar(256) DEFAULT NULL COMMENT '����',
  `business_type` int(11) NOT NULL DEFAULT '1' COMMENT 'ҵ������',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�ļ��ϴ���¼';

CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `log_type` int(11) NOT NULL COMMENT '����',
  `oper_object` varchar(64) DEFAULT NULL COMMENT '��������',
  `oper_table` varchar(64) NOT NULL COMMENT '������',
  `oper_id` int(11) DEFAULT '0' COMMENT '��������',
  `oper_type` varchar(64) DEFAULT NULL COMMENT '��������',
  `oper_remark` varchar(100) DEFAULT NULL COMMENT '������ע',
  `create_time` varchar(64) NOT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��־';

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parentid` int(11) NOT NULL DEFAULT '0' COMMENT '��id',
  `name` varchar(200) NOT NULL DEFAULT '' COMMENT '����/11111',
  `urlkey` varchar(256) DEFAULT NULL COMMENT '�˵�key',
  `url` varchar(256) DEFAULT NULL COMMENT '���ӵ�ַ',
  `status` int(11) DEFAULT '1' COMMENT '״̬//radio/2,����,1,��ʾ',
  `type` int(11) DEFAULT '1' COMMENT '����//select/1,��Ŀ¼,2,a��ǩ,3,a��ǩ_blank,4,�ⲿurl',
  `sort` int(11) DEFAULT '1' COMMENT '����',
  `level` int(11) DEFAULT '1' COMMENT '����',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�˵�';

CREATE TABLE `sys_office` (
  `id` varchar(64) NOT NULL COMMENT '���',
  `parent_id` varchar(64) NOT NULL COMMENT '�������',
  `parent_ids` varchar(2000) NOT NULL COMMENT '���и������',
  `name` varchar(100) NOT NULL COMMENT '����',
  `sort` decimal(10,0) NOT NULL COMMENT '����',
  `area_id` varchar(64) NOT NULL COMMENT '��������',
  `code` varchar(100) DEFAULT NULL COMMENT '�������',
  `type` char(1) NOT NULL COMMENT '��������',
  `grade` char(1) NOT NULL COMMENT '�����ȼ�',
  `address` varchar(255) DEFAULT NULL COMMENT '��ϵ��ַ',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '��������',
  `master` varchar(100) DEFAULT NULL COMMENT '������',
  `phone` varchar(200) DEFAULT NULL COMMENT '�绰',
  `fax` varchar(200) DEFAULT NULL COMMENT '����',
  `email` varchar(200) DEFAULT NULL COMMENT '����',
  `USEABLE` varchar(64) DEFAULT NULL COMMENT '�Ƿ�����',
  `PRIMARY_PERSON` varchar(64) DEFAULT NULL COMMENT '��������',
  `DEPUTY_PERSON` varchar(64) DEFAULT NULL COMMENT '��������',
  `create_by` varchar(64) NOT NULL COMMENT '������',
  `create_date` datetime NOT NULL COMMENT '����ʱ��',
  `update_by` varchar(64) NOT NULL COMMENT '������',
  `update_date` datetime NOT NULL COMMENT '����ʱ��',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע��Ϣ',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ�����',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_del_flag` (`del_flag`),
  KEY `sys_office_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������';

CREATE TABLE `sys_organize` (
  `id` varchar(64) NOT NULL,
  `name` varchar(200) NOT NULL,
  `code` varchar(64) NOT NULL,
  `brief` varchar(254) NOT NULL,
  `instruction` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `parentid` varchar(64) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织信息';

CREATE TABLE `sys_organize_relation` (
  `id` varchar(64) NOT NULL,
  `relationid` varchar(64) NOT NULL,
  `level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织关系表';

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) NOT NULL DEFAULT '' COMMENT '����/11111/',
  `status` int(11) DEFAULT '1' COMMENT '״̬//radio/2,����,1,��ʾ',
  `sort` int(11) DEFAULT '1' COMMENT '����',
  `remark` text COMMENT '˵��//textarea',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɫ';

CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleid` int(11) NOT NULL COMMENT '��ɫid',
  `menuid` int(11) NOT NULL COMMENT '�˵�id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɫ�Ͳ˵�����';

CREATE TABLE `sys_role_office` (
  `role_id` varchar(64) NOT NULL COMMENT '��ɫ���',
  `office_id` varchar(64) NOT NULL COMMENT '�������',
  PRIMARY KEY (`role_id`,`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɫ-����';

CREATE TABLE `sys_sms` (
  `id` varchar(64) DEFAULT NULL,
  `mobile` char(11) DEFAULT NULL,
  `msg` varchar(1000) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0',
  `is_received` char(1) DEFAULT '0',
  `sync_return_result` varchar(1000) DEFAULT NULL,
  `code` char(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `sys_social` (
  `id` varchar(64) NOT NULL,
  `name` varchar(200) NOT NULL,
  `code` varchar(64) NOT NULL,
  `x` float DEFAULT NULL,
  `y` float DEFAULT NULL,
  `z` float DEFAULT NULL,
  `size` double DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社会信息';

CREATE TABLE `sys_source` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `cid` varchar(32) NOT NULL COMMENT '当前节点代码',
  `pid` varchar(32) DEFAULT NULL COMMENT '当前父节点代码',
  `type` varchar(32) NOT NULL COMMENT '自然资源社会资源分类',
  `name` varchar(96) NOT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`id`,`cid`),
  UNIQUE KEY `uq_cid` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='所有资源信息表';

CREATE TABLE `sys_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `username` varchar(70) DEFAULT NULL,
  `password` varchar(32) NOT NULL COMMENT '����',
  `realname` varchar(32) DEFAULT NULL COMMENT '��ʵ����',
  `departid` int(11) DEFAULT '0' COMMENT '����/11111/dict',
  `usertype` int(11) DEFAULT '2' COMMENT '����//select/1,����Ա,2,��ͨ�û�,3,ǰ̨�û�,4,�������û�,5,API�û�',
  `state` int(11) DEFAULT '10' COMMENT '״̬',
  `thirdid` varchar(200) DEFAULT NULL COMMENT '������ID',
  `endtime` varchar(32) DEFAULT NULL COMMENT '����ʱ��',
  `email` varchar(64) DEFAULT NULL COMMENT 'email',
  `tel` varchar(42) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `title_url` varchar(200) DEFAULT NULL COMMENT 'ͷ���ַ',
  `remark` varchar(1000) DEFAULT NULL COMMENT '˵��',
  `theme` varchar(64) DEFAULT 'default' COMMENT '����',
  `back_site_id` int(11) DEFAULT '0' COMMENT '��̨ѡ��վ��ID',
  `create_site_id` int(11) DEFAULT '1' COMMENT '����վ��ID',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  `birthday` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=17425675 DEFAULT CHARSET=utf8 COMMENT='�û�';

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(11) NOT NULL COMMENT '�û�id',
  `roleid` int(11) NOT NULL COMMENT '��ɫid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û��ͽ�ɫ����';

CREATE TABLE `syslog` (
  `ID` varchar(64) NOT NULL,
  `USERID` varchar(32) DEFAULT NULL,
  `OPERATEDATE` datetime DEFAULT NULL,
  `USERIP` varchar(20) DEFAULT NULL,
  `USERNAME` varchar(64) DEFAULT NULL,
  `LOGTYPE` varchar(1) DEFAULT NULL,
  `MESSAGES` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sysmodule` (
  `MODULEID` varchar(32) NOT NULL,
  `MODULENAME` varchar(64) NOT NULL,
  `PARENTID` varchar(32) NOT NULL,
  `URL` varchar(200) DEFAULT NULL,
  `ICON` varchar(128) DEFAULT NULL,
  `SHOWORDER` int(11) NOT NULL,
  `ISUSED` varchar(1) NOT NULL,
  `VCHAR1` varchar(300) DEFAULT NULL,
  `VCHAR2` varchar(300) DEFAULT NULL,
  `VCHAR3` varchar(300) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  `VCHAR6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`MODULEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sysoperation` (
  `OPERATEID` varchar(32) NOT NULL,
  `MODULEID` varchar(32) DEFAULT NULL,
  `OPERATENAME` varchar(64) NOT NULL,
  `URL` varchar(200) DEFAULT NULL,
  `ICON` varchar(128) DEFAULT NULL,
  `SHOWORDER` int(11) NOT NULL,
  `VCHAR1` varchar(300) DEFAULT NULL,
  `VCHAR2` varchar(300) DEFAULT NULL,
  `VCHAR3` varchar(300) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  `VCHAR6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`OPERATEID`),
  KEY `FK7F1D553A97B2F638` (`MODULEID`),
  CONSTRAINT `FK7F1D553A97B2F638` FOREIGN KEY (`MODULEID`) REFERENCES `sysmodule` (`MODULEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sysrole` (
  `ID` varchar(32) NOT NULL,
  `ROLENAME` varchar(64) NOT NULL,
  `GROUPID` varchar(1) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sysrolemodule` (
  `ROLEID` varchar(32) NOT NULL,
  `MODULEID` varchar(32) NOT NULL,
  PRIMARY KEY (`ROLEID`,`MODULEID`),
  KEY `FKE8CDF0CF97B2F638` (`MODULEID`),
  CONSTRAINT `FKE8CDF0CF97B2F638` FOREIGN KEY (`MODULEID`) REFERENCES `sysmodule` (`MODULEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sysuser` (
  `ID` varchar(32) NOT NULL,
  `USERID` varchar(20) NOT NULL,
  `USERNAME` varchar(128) NOT NULL,
  `GROUPID` varchar(1) NOT NULL,
  `PWD` varchar(64) NOT NULL,
  `CONTACT` varchar(128) DEFAULT NULL,
  `ADDR` varchar(256) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `USERSTATE` varchar(1) NOT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `SEX` varchar(4) DEFAULT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `MOVEPHONE` varchar(11) DEFAULT NULL,
  `FAX` varchar(20) DEFAULT NULL,
  `LASTUPDATE` varchar(14) DEFAULT NULL,
  `VCHAR1` varchar(300) DEFAULT NULL,
  `VCHAR2` varchar(300) DEFAULT NULL,
  `VCHAR3` varchar(300) DEFAULT NULL,
  `VCHAR4` varchar(300) DEFAULT NULL,
  `VCHAR5` varchar(300) DEFAULT NULL,
  `SYSID` varchar(64) DEFAULT NULL,
  `BIRTH` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERID` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL COMMENT '管理员名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `memberId` bigint(20) DEFAULT NULL COMMENT '用户ID（仅限专家）(t_member)',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `status` smallint(1) DEFAULT '1' COMMENT '是否可用： 0否 1是',
  `is_del` smallint(1) DEFAULT '0' COMMENT '是否删除：0否 1是',
  `last_login_ip` varchar(255) DEFAULT NULL COMMENT '最后登录IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `login_count` int(11) DEFAULT '0' COMMENT '登录次数',
  `addId` bigint(20) DEFAULT NULL COMMENT '操作人ID',
  `add_name` varchar(255) DEFAULT NULL COMMENT '操作人名',
  `add_time` datetime DEFAULT NULL COMMENT '操作时间',
  `area` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

CREATE TABLE `t_admin_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adminId` bigint(20) NOT NULL COMMENT '菜单ID(t_admin)',
  `roleId` bigint(20) NOT NULL COMMENT '角色ID (t_role)',
  PRIMARY KEY (`id`),
  KEY `adminId` (`adminId`) USING BTREE,
  KEY `roleId` (`roleId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员角色';

CREATE TABLE `t_person_base_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL COMMENT '登录表的id',
  `nick_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '头像地址',
  `gender` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别 0.男性/1.女性',
  `birthday` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '生日(1995年1月)',
  `age` varchar(3) CHARACTER SET utf8 DEFAULT NULL COMMENT '年龄',
  `habit_hand` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '习惯用手  0.左手/1.右手',
  `height` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '身高',
  `weight` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '体重',
  `waist` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '腰围',
  `is_diabetes` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否患有糖尿病  0.无,  1.一型糖尿病,  2.二型糖尿病',
  `is_hypertension` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否患有高血压 0否 1是',
  `diabetes_year` varchar(3) CHARACTER SET utf8 DEFAULT '0' COMMENT '患糖尿病年限(年)',
  `diabetes_relatives` varchar(3) CHARACTER SET utf8 DEFAULT NULL COMMENT '直系亲属中患糖尿病人数',
  `glycosylated_blood` varchar(5) CHARACTER SET utf8 DEFAULT '0' COMMENT '糖化血红蛋白含量(%)',
  `smoking_year` varchar(3) CHARACTER SET utf8 DEFAULT NULL COMMENT '抽烟年限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='个人基本信息';

CREATE TABLE `t_person_friends_group` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL COMMENT '登录表的id',
  `group_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '分组的名字',
  `create_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '添加时间',
  `is_default` smallint(1) DEFAULT NULL COMMENT '是否是默认分组  0否  1是',
  `is_del` smallint(1) DEFAULT '0' COMMENT '是否删除   1是  0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COMMENT='个人的好友分组';

CREATE TABLE `t_person_friends_members` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `groupId` bigint(11) DEFAULT NULL COMMENT '分组Id   对应t_person_friend_group表的id (好友分组等于-1,家人分组等于-2)',
  `friend_id` bigint(11) DEFAULT NULL COMMENT '对应 登录表的id',
  `add_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COMMENT='好友成员';

CREATE TABLE `t_person_friends_right` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL COMMENT '对应登录表的id',
  `friend_id` bigint(11) DEFAULT NULL COMMENT '对应登录表的id',
  `right_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限id(多个用逗号隔开)',
  `nick_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注名(昵称)',
  `img` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '图像',
  `status` smallint(2) DEFAULT NULL COMMENT '好友添加状态   1申请添加中  2已添加  3已删除 ',
  `add_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COMMENT='好友权限';

CREATE TABLE `t_person_message` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `type` smallint(1) DEFAULT NULL COMMENT '类型: 1健康通知  2消费通知 3系统通知 4好友健康通知  5邮箱消息   6短信信息',
  `user_id` bigint(11) DEFAULT NULL COMMENT '登录表的id',
  `title` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '推送消息的标题',
  `content` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '消息(内容)',
  `check_status` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '检测状态',
  `value` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '值',
  `abnormity_description` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '异常描述',
  `check_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '检测时间',
  `push_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '推送时间',
  `is_del` smallint(1) DEFAULT '0' COMMENT '1删除  0没删除',
  `equipment_id` bigint(11) DEFAULT NULL COMMENT 't_setting_equipment表的id',
  `is_push_success` smallint(1) DEFAULT '1' COMMENT '是否推送成功 1成功  0没成功',
  `blood_type` smallint(1) DEFAULT NULL COMMENT '1 血糖  2血氧 3血压  4心率  5呼吸率',
  `friend_id` bigint(11) DEFAULT '-1' COMMENT '申请添加好友的id,对应user表的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1 COMMENT='用户收到的消息通知列表';

CREATE TABLE `t_right` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `right_name` varchar(255) DEFAULT NULL COMMENT '功能名称',
  `description` varchar(255) DEFAULT NULL COMMENT '功能描述',
  `action_url` varchar(255) DEFAULT NULL COMMENT '访问链接',
  `parentId` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
  `enable` smallint(1) DEFAULT '1' COMMENT '标志是否使用该权限',
  `indexs` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限菜单';

CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL COMMENT '角色名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `status` smallint(1) DEFAULT '1' COMMENT '是否启用： 0否 1是',
  `addId` bigint(20) DEFAULT NULL COMMENT '操作人ID',
  `add_name` varchar(255) DEFAULT NULL COMMENT '操作人名',
  `add_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

CREATE TABLE `t_role_right` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) NOT NULL COMMENT '角色ID(t_role)',
  `rightId` bigint(20) NOT NULL COMMENT '菜单ID(t_right)',
  PRIMARY KEY (`id`),
  KEY `roleId` (`roleId`) USING BTREE,
  KEY `rightId` (`rightId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限';

CREATE TABLE `t_test` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
  `time` varchar(100) DEFAULT NULL COMMENT '时间',
  `enable` tinyint(4) DEFAULT '1' COMMENT '0不显示 1显示',
  `content` text COMMENT '文章内容',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user_login` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '昵称',
  `phone` varchar(15) CHARACTER SET utf8 DEFAULT '' COMMENT '手机',
  `email` varchar(30) CHARACTER SET utf8 DEFAULT '' COMMENT '邮箱',
  `status` smallint(1) DEFAULT '1' COMMENT '是否能登录  1正常  2禁用  3删除',
  `login_password` varchar(100) CHARACTER SET utf8 DEFAULT '' COMMENT '密码',
  `last_login_ip` varchar(20) DEFAULT '' COMMENT '上次登录Ip',
  `create_time` varchar(20) CHARACTER SET utf8 DEFAULT '' COMMENT '注册时间',
  `create_time_stamp` bigint(20) DEFAULT NULL COMMENT '创建时间戳',
  `last_login_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '上次登录时间',
  `equipment_number` varchar(30) CHARACTER SET utf8 DEFAULT '' COMMENT '设备号(测血压的设备)',
  `app_number` varchar(100) DEFAULT '' COMMENT '手机设备号',
  `wechat` varchar(30) DEFAULT '' COMMENT '微信',
  `QQ` varchar(30) DEFAULT '',
  `weblog` varchar(30) DEFAULT '' COMMENT '微博',
  `is_accept_push` smallint(1) DEFAULT '0' COMMENT '是的接受血糖检测推送提醒  0不接受  1接受',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1 COMMENT='登录信息';

CREATE TABLE `tables` (
  `id` varchar(32) NOT NULL,
  `dbname` varchar(200) NOT NULL,
  `tablename` varchar(32) NOT NULL,
  `user` varchar(32) NOT NULL,
  `type` varchar(64) NOT NULL,
  `isnull` varchar(64) NOT NULL,
  `commont` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_advice_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `userid` int(11) NOT NULL COMMENT '�û�ID',
  `username` varchar(32) NOT NULL COMMENT '�û���',
  `qq` varchar(32) DEFAULT NULL COMMENT 'qq',
  `email` varchar(64) DEFAULT NULL COMMENT 'email',
  `telphone` varchar(32) DEFAULT NULL COMMENT '�ֻ���',
  `content` varchar(2000) DEFAULT NULL COMMENT '�����������',
  `remark` varchar(2000) DEFAULT NULL COMMENT '��ע',
  `is_read` int(11) DEFAULT NULL COMMENT '�Ƿ��Ѷ�',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������';

CREATE TABLE `tb_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `folder_id` int(11) DEFAULT '1' COMMENT 'Ŀ¼id',
  `title` varchar(200) DEFAULT '' COMMENT '��������',
  `content` longtext COMMENT '�ļ�����',
  `count_view` int(11) DEFAULT '0' COMMENT '�����',
  `count_comment` int(11) DEFAULT '0' COMMENT '������',
  `type` int(11) DEFAULT '1' COMMENT '���ͣ�1 ���� 2 Ԥ��չʾ���� 3 ������ô���',
  `status` varchar(20) DEFAULT '1' COMMENT '״̬//radio/2,����,1,��ʾ',
  `is_comment` int(11) DEFAULT '1' COMMENT '�Ƿ����ۣ�2 �� 1 ��',
  `is_recommend` int(11) DEFAULT '2' COMMENT '�Ƿ��Ƽ���2 �� 1 ��',
  `sort` int(11) DEFAULT '1' COMMENT '����',
  `jump_url` varchar(256) DEFAULT NULL COMMENT '��ת��ַ',
  `image_url` varchar(256) DEFAULT NULL COMMENT 'ͼƬ·��',
  `image_net_url` varchar(256) DEFAULT NULL COMMENT '����ͼƬ·��',
  `file_url` varchar(256) DEFAULT NULL,
  `file_name` varchar(256) DEFAULT NULL,
  `approve_status` int(11) DEFAULT NULL COMMENT '���״̬',
  `publish_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `publish_user` varchar(64) DEFAULT '1' COMMENT '������',
  `start_time` varchar(64) DEFAULT NULL COMMENT '��ʼʱ��',
  `end_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='����';

CREATE TABLE `tb_articlelike` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `article_id` int(11) DEFAULT NULL COMMENT '����ID',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ϲ��������';

CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `fatherId` int(11) DEFAULT NULL COMMENT '������ID',
  `article_id` int(11) DEFAULT NULL COMMENT '����ID',
  `content` text NOT NULL COMMENT '����',
  `status` int(11) DEFAULT '11' COMMENT '״̬//select/11,����δ��,12,�����Ѷ�,21,�ظ�δ��,22,�ظ��Ѷ�',
  `reply_userid` int(11) DEFAULT NULL,
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������ ������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='����';

CREATE TABLE `tb_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(256) NOT NULL COMMENT '����',
  `phone` varchar(32) DEFAULT NULL COMMENT '�ֻ���',
  `email` varchar(32) DEFAULT NULL COMMENT 'Email',
  `addr` varchar(256) DEFAULT NULL COMMENT '��ַ',
  `birthday` varchar(32) DEFAULT NULL COMMENT '����',
  `remark` varchar(256) DEFAULT NULL COMMENT '˵��',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ϵ��';

CREATE TABLE `tb_error` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `type` int(11) DEFAULT NULL COMMENT '����',
  `ip` varchar(64) NOT NULL COMMENT 'IP��ַ',
  `userid` int(11) DEFAULT NULL COMMENT '�û�ID',
  `content` text COMMENT '����',
  `remark` text COMMENT '��ע',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�쳣����';

CREATE TABLE `tb_folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Ŀ¼id',
  `parent_id` int(11) DEFAULT '0' COMMENT '��ID',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '������',
  `key` varchar(100) DEFAULT '' COMMENT 'URL KEY',
  `path` varchar(200) DEFAULT '' COMMENT 'ģ��·��',
  `content` text COMMENT '����',
  `sort` int(11) DEFAULT '1' COMMENT '����',
  `status` int(11) DEFAULT '1' COMMENT '״̬//radio/2,����,1,��ʾ',
  `type` int(11) DEFAULT '1' COMMENT '���� 1 ��ͨĿ¼ 2 a��ǩ 3 a��ǩ_blank 4 ֱ�Ӽ���url��Ϣ',
  `jump_url` varchar(200) DEFAULT NULL COMMENT '��ת��ַ',
  `material_type` int(11) DEFAULT NULL COMMENT '�ز�����',
  `site_id` int(11) DEFAULT NULL COMMENT 'վ��ID',
  `seo_title` varchar(200) DEFAULT NULL COMMENT 'SEO title',
  `seo_keywords` varchar(200) DEFAULT NULL COMMENT 'SEO keywords',
  `seo_description` varchar(200) DEFAULT NULL COMMENT 'SEO description',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8 COMMENT='Ŀ¼';

CREATE TABLE `tb_folder_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `folder_id` int(11) NOT NULL COMMENT 'Ŀ¼id',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '����',
  `icon` varchar(255) DEFAULT NULL COMMENT 'ͼ��',
  `content` varchar(2000) DEFAULT NULL COMMENT '����',
  `url` varchar(255) DEFAULT NULL COMMENT '���ӵ�ַ',
  `sort` int(11) DEFAULT NULL COMMENT '����',
  `status` int(11) DEFAULT '1' COMMENT '״̬//radio/2,����,1,��ʾ',
  `is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '�Ƿ���ɾ��',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ŀ����';

CREATE TABLE `tb_folder_roll_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `folder_id` int(11) NOT NULL COMMENT 'Ŀ¼id',
  `title` varchar(200) DEFAULT '' COMMENT '��Ŀ',
  `content` varchar(2000) DEFAULT NULL COMMENT '����',
  `sort` int(11) DEFAULT '1' COMMENT '����',
  `status` int(11) DEFAULT '1' COMMENT '״̬//radio/2,����,1,��ʾ',
  `image_url` varchar(256) DEFAULT NULL COMMENT 'ͼƬ·��',
  `image_net_url` varchar(256) DEFAULT NULL COMMENT '����ͼƬ·��',
  `url` varchar(255) DEFAULT NULL COMMENT '���ӵ�ַ',
  `is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '�Ƿ���ɾ��',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ŀ�ֲ�ͼ';

CREATE TABLE `tb_friendlylink` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(256) NOT NULL COMMENT '����/11111/',
  `url` varchar(256) NOT NULL COMMENT 'URL',
  `sort` int(11) NOT NULL COMMENT '�����',
  `state` int(11) DEFAULT '0' COMMENT '�Ƿ���ʾ//radio/1,��ʾ,2,����ʾ',
  `type` int(11) DEFAULT '21' COMMENT '����//select/1,�������ֵ�',
  `remark` varchar(256) DEFAULT NULL COMMENT '��ע//textarea',
  `site_id` int(11) DEFAULT '0' COMMENT 'վ��ID',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������ӱ�';

CREATE TABLE `tb_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `album_id` int(11) DEFAULT '1' COMMENT '���ID',
  `album_name` varchar(200) DEFAULT '' COMMENT '�������',
  `name` varchar(200) DEFAULT '' COMMENT 'ͼƬ����',
  `linkurl` varchar(400) DEFAULT '' COMMENT '���ӵ�ַ',
  `cdnurl` varchar(400) DEFAULT '' COMMENT 'CDN��ַ',
  `image_url` varchar(256) DEFAULT NULL COMMENT 'ͼƬ·��',
  `image_net_url` varchar(256) DEFAULT NULL COMMENT '����ͼƬ·��',
  `ext` varchar(20) DEFAULT '' COMMENT '��չ��',
  `width` varchar(20) DEFAULT '' COMMENT '��',
  `height` varchar(20) DEFAULT '' COMMENT '��',
  `status` int(11) DEFAULT '1' COMMENT '״̬//radio/2,����,1,��ʾ',
  `is_comment` int(11) DEFAULT '1' COMMENT '�Ƿ�����//radio/2,��,1,��',
  `is_recommend` int(11) DEFAULT '2' COMMENT '�Ƿ��Ƽ���2 �� 1 ��',
  `sort` int(11) DEFAULT '1' COMMENT '����',
  `remark` varchar(400) DEFAULT NULL COMMENT '��ע',
  `publish_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `publish_user` varchar(64) DEFAULT '1' COMMENT '������',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ͼƬ';

CREATE TABLE `tb_image_album` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `parent_id` int(11) DEFAULT '0' COMMENT '��ID',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '�������',
  `remark` text COMMENT '����',
  `sort` int(11) DEFAULT '1' COMMENT '����',
  `status` int(11) DEFAULT '1' COMMENT '״̬//radio/2,����,1,��ʾ',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���';

CREATE TABLE `tb_image_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `image_id` int(11) DEFAULT NULL COMMENT 'ͼƬID',
  `tagname` varchar(200) DEFAULT '' COMMENT '��ǩ����',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='��ǩ';

CREATE TABLE `tb_pageview` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `ip` varchar(64) NOT NULL COMMENT 'IP��ַ',
  `userid` int(11) DEFAULT NULL COMMENT '�û�ID',
  `create_day` varchar(64) NOT NULL COMMENT '����ʱ�䵽��',
  `create_time` varchar(64) NOT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 COMMENT='������ͳ��';

CREATE TABLE `tb_site` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) NOT NULL COMMENT '����',
  `template` varchar(32) DEFAULT NULL COMMENT 'ģ������',
  `template_mobile` varchar(32) DEFAULT NULL,
  `domain_pc` varchar(64) DEFAULT NULL COMMENT 'pc������',
  `domain_mobile` varchar(64) DEFAULT NULL COMMENT '�ƶ�������',
  `domain_others` varchar(400) DEFAULT NULL COMMENT '��������',
  `site_title` varchar(256) DEFAULT NULL COMMENT '����',
  `site_folder_id` int(11) DEFAULT NULL COMMENT 'Ĭ�ϱ���ID',
  `site_article_id` int(11) DEFAULT NULL COMMENT 'Ĭ������ID',
  `thumbnail` varchar(256) DEFAULT NULL COMMENT '����ͼ',
  `db_url` varchar(200) DEFAULT NULL COMMENT '���ݿ�',
  `db_user` varchar(64) DEFAULT NULL COMMENT '���ݿ��û�',
  `db_pwd` varchar(64) DEFAULT NULL COMMENT '���ݿ�����',
  `db_driver` varchar(64) DEFAULT NULL COMMENT '���ݿ�����',
  `sort` int(11) DEFAULT '10' COMMENT '���',
  `status` int(2) DEFAULT '1' COMMENT '״̬//radio/2,����,1,����',
  `site_defalut` int(2) DEFAULT '2' COMMENT 'Ĭ��վ�㣺1,��,2,��',
  `remark` varchar(1000) DEFAULT NULL COMMENT '��ע',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='վ��';

CREATE TABLE `tb_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `article_id` int(11) DEFAULT NULL COMMENT '����ID',
  `tagname` varchar(200) DEFAULT '' COMMENT '��ǩ����',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4740 DEFAULT CHARSET=utf8 COMMENT='��ǩ';

CREATE TABLE `tb_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `album_id` int(11) DEFAULT '1' COMMENT 'ר��ID',
  `album_name` varchar(200) DEFAULT '' COMMENT 'ר������',
  `name` varchar(200) DEFAULT '' COMMENT '��Ƶ����',
  `video_url` varchar(256) DEFAULT NULL COMMENT '�㲥��Ƶ·��',
  `video_net_url` varchar(256) DEFAULT NULL COMMENT '������Ƶ·��',
  `thumbnail` varchar(256) DEFAULT '' COMMENT '����ͼ',
  `ext` varchar(20) DEFAULT '' COMMENT '��չ��',
  `resolution` varchar(20) DEFAULT '' COMMENT '�ֱ���',
  `status` int(11) DEFAULT '1' COMMENT '״̬//ra dio/2,����,1,��ʾ',
  `is_comment` int(11) DEFAULT '1' COMMENT '�Ƿ�����//radio/2,��,1,��',
  `is_recommend` int(11) DEFAULT '2' COMMENT '�Ƿ��Ƽ���2 �� 1 ��',
  `sort` int(11) DEFAULT '1' COMMENT '����',
  `remark` varchar(400) DEFAULT NULL COMMENT '��ע',
  `publish_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `publish_user` varchar(64) DEFAULT '1' COMMENT '������',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ƶ';

CREATE TABLE `tb_video_album` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `parent_id` int(11) DEFAULT '0' COMMENT '��ID',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT 'ר������',
  `remark` text COMMENT '����',
  `sort` int(11) DEFAULT '1' COMMENT '����',
  `status` int(11) DEFAULT '1' COMMENT '״̬//radio/2,����,1,��ʾ',
  `update_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `update_id` int(11) DEFAULT '0' COMMENT '������',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ר��';

CREATE TABLE `tb_video_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `video_id` int(11) DEFAULT NULL COMMENT '��ƵID',
  `tagname` varchar(200) DEFAULT '' COMMENT '��ǩ����',
  `create_time` varchar(64) DEFAULT NULL COMMENT '����ʱ��',
  `create_id` int(11) DEFAULT '0' COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ƶ��ǩ';

CREATE TABLE `test_data` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `user_id` varchar(64) DEFAULT NULL COMMENT '归属用户',
  `office_id` varchar(64) DEFAULT NULL COMMENT '归属部门',
  `area_id` varchar(64) DEFAULT NULL COMMENT '归属区域',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `in_date` date DEFAULT NULL COMMENT '加入日期',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `test_data_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务数据表';

CREATE TABLE `test_data_child` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `test_data_main_id` varchar(64) DEFAULT NULL COMMENT '业务主表ID',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `test_data_child_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务数据子表';

CREATE TABLE `test_data_main` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `user_id` varchar(64) DEFAULT NULL COMMENT '归属用户',
  `office_id` varchar(64) DEFAULT NULL COMMENT '归属部门',
  `area_id` varchar(64) DEFAULT NULL COMMENT '归属区域',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `in_date` date DEFAULT NULL COMMENT '加入日期',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `test_data_main_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务数据表';

CREATE TABLE `test_tree` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `test_tree_del_flag` (`del_flag`),
  KEY `test_data_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='树结构表';

CREATE TABLE `uploadinfo` (
  `md5` varchar(6) DEFAULT NULL,
  `chunks` varchar(24) DEFAULT NULL,
  `chunk` varchar(36) DEFAULT NULL,
  `path` varchar(45) DEFAULT NULL,
  `fileName` varchar(240) DEFAULT NULL,
  `ext` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分块上传文件数据';

CREATE TABLE `userarea` (
  `USERID` varchar(32) NOT NULL,
  `AREAID` varchar(32) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`USERID`,`AREAID`),
  KEY `FK1EC9CED8FF20B276` (`USERID`),
  CONSTRAINT `FK1EC9CED8FF20B276` FOREIGN KEY (`USERID`) REFERENCES `sysuser` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usergys` (
  `ID` varchar(64) NOT NULL,
  `MC` varchar(128) NOT NULL,
  `LB` varchar(32) DEFAULT NULL,
  `XKZ` varchar(128) DEFAULT NULL,
  `XKZYXQ` varchar(128) DEFAULT NULL,
  `LXR` varchar(64) DEFAULT NULL,
  `DH` varchar(64) DEFAULT NULL,
  `JYFW` varchar(256) DEFAULT NULL,
  `ZCDZ` varchar(128) DEFAULT NULL,
  `LXDZ` varchar(128) DEFAULT NULL,
  `YZBM` varchar(32) DEFAULT NULL,
  `ZZC` varchar(32) DEFAULT NULL,
  `CZ` varchar(64) DEFAULT NULL,
  `FRMC` varchar(16) DEFAULT NULL,
  `FRSFZ` varchar(64) DEFAULT NULL,
  `ZCZJ` varchar(32) DEFAULT NULL,
  `XSE` varchar(32) DEFAULT NULL,
  `DZYX` varchar(128) DEFAULT NULL,
  `WZ` varchar(256) DEFAULT NULL,
  `DMZH` varchar(128) DEFAULT NULL,
  `DMZHYXQ` varchar(128) DEFAULT NULL,
  `YYZZ` varchar(64) DEFAULT NULL,
  `YYZZYXQ` varchar(128) DEFAULT NULL,
  `XYZ` varchar(1) DEFAULT NULL,
  `XYZBM` varchar(64) DEFAULT NULL,
  `XYZYXQ` varchar(128) DEFAULT NULL,
  `GDZC` varchar(32) DEFAULT NULL,
  `JJ` varchar(255) DEFAULT NULL,
  `BZ` varchar(200) DEFAULT NULL,
  `VCHAR1` varchar(128) DEFAULT NULL,
  `VCHAR2` varchar(128) DEFAULT NULL,
  `VCHAR3` varchar(128) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `MC` (`MC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usergysarea` (
  `USERGYSID` varchar(64) NOT NULL,
  `AREAID` varchar(32) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`USERGYSID`,`AREAID`),
  KEY `FK28BB7783A46DFFFF` (`USERGYSID`),
  CONSTRAINT `FK28BB7783A46DFFFF` FOREIGN KEY (`USERGYSID`) REFERENCES `usergys` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `userjd` (
  `ID` varchar(64) NOT NULL,
  `MC` varchar(128) NOT NULL,
  `DZ` varchar(256) DEFAULT NULL,
  `YZBM` varchar(32) DEFAULT NULL,
  `XLR` varchar(64) DEFAULT NULL,
  `DH` varchar(64) DEFAULT NULL,
  `CZ` varchar(64) DEFAULT NULL,
  `DZYX` varchar(128) DEFAULT NULL,
  `WZ` varchar(128) DEFAULT NULL,
  `VCHAR1` varchar(128) DEFAULT NULL,
  `VCHAR2` varchar(128) DEFAULT NULL,
  `VCHAR3` varchar(128) DEFAULT NULL,
  `DQ` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `MC` (`MC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `userrole` (
  `USERID` varchar(32) NOT NULL,
  `USERROLE` varchar(32) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`USERID`,`USERROLE`),
  KEY `FK1ED17EC1211FA3BC` (`USERROLE`),
  CONSTRAINT `FK1ED17EC1211FA3BC` FOREIGN KEY (`USERROLE`) REFERENCES `sysrole` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `useryy` (
  `ID` varchar(64) NOT NULL,
  `MC` varchar(128) NOT NULL,
  `DZ` varchar(256) DEFAULT NULL,
  `YZBM` varchar(32) DEFAULT NULL,
  `DQ` varchar(128) DEFAULT NULL,
  `JB` varchar(32) DEFAULT NULL,
  `CWS` varchar(64) DEFAULT NULL,
  `FYLJG` varchar(1) DEFAULT NULL,
  `DH` varchar(64) DEFAULT NULL,
  `YJKDH` varchar(64) DEFAULT NULL,
  `LB` varchar(64) DEFAULT NULL,
  `YPSR` varchar(32) DEFAULT NULL,
  `YWSR` varchar(32) DEFAULT NULL,
  `CZ` varchar(64) DEFAULT NULL,
  `VCHAR1` varchar(128) DEFAULT NULL,
  `VCHAR2` varchar(128) DEFAULT NULL,
  `VCHAR3` varchar(128) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `MC` (`MC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yppmbackup` (
  `ID` varchar(32) NOT NULL,
  `BM` varchar(10) NOT NULL,
  `MC` varchar(128) NOT NULL,
  `JX` varchar(32) NOT NULL,
  `DW` varchar(64) DEFAULT NULL,
  `ZHXS` varchar(16) NOT NULL,
  `LB` varchar(32) DEFAULT NULL,
  `ZT` varchar(1) DEFAULT NULL,
  `ZL` varchar(16) DEFAULT NULL,
  `HL` varchar(16) DEFAULT NULL,
  `YB` varchar(1) DEFAULT NULL,
  `YBBM` varchar(128) DEFAULT NULL,
  `BZ` varchar(200) DEFAULT NULL,
  `VCHAR1` varchar(768) DEFAULT NULL,
  `VCHAR2` varchar(128) DEFAULT NULL,
  `VCHAR3` varchar(128) DEFAULT NULL,
  `GG` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BM` (`BM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ypxx` (
  `ID` varchar(32) NOT NULL,
  `BM` varchar(32) NOT NULL,
  `SCQYMC` varchar(128) NOT NULL,
  `SPMC` varchar(64) NOT NULL,
  `ZBJG` double NOT NULL,
  `ZPDZ` varchar(128) DEFAULT NULL,
  `PZWH` varchar(64) DEFAULT NULL,
  `PZWHYXQ` datetime DEFAULT NULL,
  `JKY` varchar(1) DEFAULT NULL,
  `BZCZ` varchar(64) DEFAULT NULL,
  `BZDW` varchar(64) DEFAULT NULL,
  `LSJG` double DEFAULT NULL,
  `LSJGCC` varchar(64) DEFAULT NULL,
  `ZLCC` varchar(32) DEFAULT NULL,
  `ZLCCSM` varchar(200) DEFAULT NULL,
  `YPJYBG` varchar(1) DEFAULT NULL,
  `YPJYBGBM` varchar(128) DEFAULT NULL,
  `YPJYBGYXQ` datetime DEFAULT NULL,
  `CPSM` varchar(255) DEFAULT NULL,
  `JYZT` varchar(1) NOT NULL,
  `VCHAR1` varchar(128) DEFAULT NULL,
  `VCHAR2` varchar(128) DEFAULT NULL,
  `VCHAR3` varchar(128) DEFAULT NULL,
  `DW` varchar(32) DEFAULT NULL,
  `MC` varchar(128) DEFAULT NULL,
  `JX` varchar(32) DEFAULT NULL,
  `GG` varchar(128) DEFAULT NULL,
  `ZHXS` varchar(16) DEFAULT NULL,
  `PINYIN` varchar(768) DEFAULT NULL,
  `LB` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BM` (`BM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yybusiness` (
  `ID` varchar(32) NOT NULL,
  `USERYYID` varchar(64) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `ZBJG` double NOT NULL,
  `JYJG` double NOT NULL,
  `CGL` decimal(22,0) NOT NULL,
  `CGJE` double NOT NULL,
  `CGZT` varchar(1) NOT NULL,
  `RKL` decimal(22,0) DEFAULT NULL,
  `RKJE` double DEFAULT NULL,
  `RKDH` varchar(32) DEFAULT NULL,
  `YPPH` varchar(32) DEFAULT NULL,
  `YPYXQ` double DEFAULT NULL,
  `RKTIME` datetime DEFAULT NULL,
  `FHTIME` datetime DEFAULT NULL,
  `YYTHDID` varchar(32) DEFAULT NULL,
  `THL` varchar(32) DEFAULT NULL,
  `THJE` double DEFAULT NULL,
  `THZT` varchar(1) DEFAULT NULL,
  `THYY` varchar(100) DEFAULT NULL,
  `YYJSDID` varchar(32) DEFAULT NULL,
  `JSL` decimal(22,0) DEFAULT NULL,
  `JSJE` double DEFAULT NULL,
  `JSZT` varchar(1) DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `USERGYSID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK639D9AE0D3C9AB79` (`USERYYID`),
  KEY `FK639D9AE08973E2D1` (`YPXXID`),
  CONSTRAINT `FK639D9AE08973E2D1` FOREIGN KEY (`YPXXID`) REFERENCES `ypxx` (`ID`),
  CONSTRAINT `FK639D9AE0D3C9AB79` FOREIGN KEY (`USERYYID`) REFERENCES `useryy` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yybusiness2014` (
  `ID` varchar(32) NOT NULL,
  `USERYYID` varchar(64) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `ZBJG` double NOT NULL,
  `JYJG` double NOT NULL,
  `CGL` decimal(22,0) NOT NULL,
  `CGJE` double NOT NULL,
  `CGZT` varchar(1) NOT NULL,
  `RKL` decimal(22,0) DEFAULT NULL,
  `RKJE` double DEFAULT NULL,
  `RKDH` varchar(32) DEFAULT NULL,
  `YPPH` varchar(32) DEFAULT NULL,
  `YPYXQ` double DEFAULT NULL,
  `RKTIME` datetime DEFAULT NULL,
  `FHTIME` datetime DEFAULT NULL,
  `YYTHDID` varchar(32) DEFAULT NULL,
  `THL` varchar(32) DEFAULT NULL,
  `THJE` double DEFAULT NULL,
  `THZT` varchar(1) DEFAULT NULL,
  `THYY` varchar(100) DEFAULT NULL,
  `YYJSDID` varchar(32) DEFAULT NULL,
  `JSL` decimal(22,0) DEFAULT NULL,
  `JSJE` double DEFAULT NULL,
  `JSZT` varchar(1) DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `USERGYSID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKD3AC9FC1D3C9AB79` (`USERYYID`),
  KEY `FKD3AC9FC18973E2D1` (`YPXXID`),
  CONSTRAINT `FKD3AC9FC18973E2D1` FOREIGN KEY (`YPXXID`) REFERENCES `ypxx` (`ID`),
  CONSTRAINT `FKD3AC9FC1D3C9AB79` FOREIGN KEY (`USERYYID`) REFERENCES `useryy` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yybusiness2015` (
  `ID` varchar(32) NOT NULL,
  `USERYYID` varchar(64) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `ZBJG` double NOT NULL,
  `JYJG` double NOT NULL,
  `CGL` decimal(22,0) NOT NULL,
  `CGJE` double NOT NULL,
  `CGZT` varchar(1) NOT NULL,
  `RKL` decimal(22,0) DEFAULT NULL,
  `RKJE` double DEFAULT NULL,
  `RKDH` varchar(32) DEFAULT NULL,
  `YPPH` varchar(32) DEFAULT NULL,
  `YPYXQ` double DEFAULT NULL,
  `RKTIME` datetime DEFAULT NULL,
  `FHTIME` datetime DEFAULT NULL,
  `YYTHDID` varchar(32) DEFAULT NULL,
  `THL` varchar(32) DEFAULT NULL,
  `THJE` double DEFAULT NULL,
  `THZT` varchar(1) DEFAULT NULL,
  `THYY` varchar(100) DEFAULT NULL,
  `YYJSDID` varchar(32) DEFAULT NULL,
  `JSL` decimal(22,0) DEFAULT NULL,
  `JSJE` double DEFAULT NULL,
  `JSZT` varchar(1) DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `USERGYSID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKD3AC9FC2D3C9AB79` (`USERYYID`),
  KEY `FKD3AC9FC28973E2D1` (`YPXXID`),
  CONSTRAINT `FKD3AC9FC28973E2D1` FOREIGN KEY (`YPXXID`) REFERENCES `ypxx` (`ID`),
  CONSTRAINT `FKD3AC9FC2D3C9AB79` FOREIGN KEY (`USERYYID`) REFERENCES `useryy` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yycgd` (
  `ID` varchar(32) NOT NULL,
  `USERYYID` varchar(64) NOT NULL,
  `BM` varchar(10) NOT NULL,
  `MC` varchar(128) NOT NULL,
  `LXR` varchar(64) DEFAULT NULL,
  `LXDH` varchar(64) DEFAULT NULL,
  `CJR` varchar(64) DEFAULT NULL,
  `CJTIME` datetime NOT NULL,
  `TJTIME` datetime DEFAULT NULL,
  `BZ` varchar(256) DEFAULT NULL,
  `ZT` varchar(1) NOT NULL,
  `SHYJ` varchar(256) DEFAULT NULL,
  `SHTIME` datetime DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  `XGTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BM` (`BM`),
  KEY `FK50FA540D3C9AB79` (`USERYYID`),
  CONSTRAINT `FK50FA540D3C9AB79` FOREIGN KEY (`USERYYID`) REFERENCES `useryy` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yycgd2014` (
  `ID` varchar(32) NOT NULL,
  `BM` varchar(10) NOT NULL,
  `MC` varchar(128) NOT NULL,
  `USERYYID` varchar(64) NOT NULL,
  `LXR` varchar(64) DEFAULT NULL,
  `LXDH` varchar(64) DEFAULT NULL,
  `CJR` varchar(64) DEFAULT NULL,
  `CJTIME` datetime NOT NULL,
  `TJTIME` datetime DEFAULT NULL,
  `XGTIME` datetime DEFAULT NULL,
  `BZ` varchar(256) DEFAULT NULL,
  `KSGHDATE` datetime DEFAULT NULL,
  `JSGHDATE` datetime DEFAULT NULL,
  `ZT` varchar(1) NOT NULL,
  `SHYJ` varchar(256) DEFAULT NULL,
  `SHTIME` datetime DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BM` (`BM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yycgdmx` (
  `ID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `USERGYSID` varchar(64) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `ZBJG` double DEFAULT NULL,
  `JYJG` double DEFAULT NULL,
  `CGL` decimal(22,0) DEFAULT NULL,
  `CGJE` double DEFAULT NULL,
  `CGZT` varchar(1) DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKFFBB5EEB8973E2D1` (`YPXXID`),
  KEY `FKFFBB5EEBA46DFFFF` (`USERGYSID`),
  CONSTRAINT `FKFFBB5EEB8973E2D1` FOREIGN KEY (`YPXXID`) REFERENCES `ypxx` (`ID`),
  CONSTRAINT `FKFFBB5EEBA46DFFFF` FOREIGN KEY (`USERGYSID`) REFERENCES `usergys` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yycgdmx2014` (
  `ID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `USERGYSID` varchar(64) NOT NULL,
  `ZBJG` double NOT NULL,
  `JYJG` double DEFAULT NULL,
  `CGL` decimal(22,0) DEFAULT NULL,
  `CGJE` double DEFAULT NULL,
  `CGZT` varchar(1) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKE3E3664C8973E2D1` (`YPXXID`),
  KEY `FKE3E3664CB0EE0AF4` (`YYCGDID`),
  CONSTRAINT `FKE3E3664C8973E2D1` FOREIGN KEY (`YPXXID`) REFERENCES `ypxx` (`ID`),
  CONSTRAINT `FKE3E3664CB0EE0AF4` FOREIGN KEY (`YYCGDID`) REFERENCES `yycgd2014` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yycgdrk` (
  `ID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  `RKL` decimal(22,0) NOT NULL,
  `RKJE` double NOT NULL,
  `RKDH` varchar(32) NOT NULL,
  `YPPH` varchar(32) NOT NULL,
  `YPYXQ` double NOT NULL,
  `RKTIME` datetime NOT NULL,
  `CGZT` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yycgdrk2014` (
  `ID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  `RKL` decimal(22,0) NOT NULL,
  `CGZT` varchar(1) NOT NULL,
  `RKJE` double NOT NULL,
  `RKDH` varchar(32) NOT NULL,
  `YPPH` varchar(32) NOT NULL,
  `YPYXQ` double NOT NULL,
  `RKTIME` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yyjsd` (
  `ID` varchar(32) NOT NULL,
  `BM` varchar(10) NOT NULL,
  `MC` varchar(128) NOT NULL,
  `USERYYID` varchar(64) NOT NULL,
  `LXR` varchar(64) DEFAULT NULL,
  `LXDH` varchar(64) DEFAULT NULL,
  `CJR` varchar(64) DEFAULT NULL,
  `CJTIME` datetime NOT NULL,
  `XGTIME` datetime DEFAULT NULL,
  `TJTIME` datetime NOT NULL,
  `BZ` varchar(256) DEFAULT NULL,
  `ZT` varchar(1) DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BM` (`BM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yyjsd2014` (
  `ID` varchar(32) NOT NULL,
  `BM` varchar(10) NOT NULL,
  `MC` varchar(128) NOT NULL,
  `USERYYID` varchar(64) NOT NULL,
  `LXR` varchar(64) DEFAULT NULL,
  `LXDH` varchar(64) DEFAULT NULL,
  `CJR` varchar(64) DEFAULT NULL,
  `CJTIME` datetime NOT NULL,
  `TJTIME` datetime DEFAULT NULL,
  `XGTIME` datetime DEFAULT NULL,
  `BZ` varchar(256) DEFAULT NULL,
  `ZT` varchar(1) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BM` (`BM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yyjsdmx` (
  `ID` varchar(32) NOT NULL,
  `YYJSDID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `JSL` decimal(22,0) NOT NULL,
  `JSJE` double NOT NULL,
  `JSZT` varchar(1) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yyjsdmx2014` (
  `ID` varchar(32) NOT NULL,
  `YYJSDID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `JSL` decimal(22,0) NOT NULL,
  `JSJE` double NOT NULL,
  `JSZT` varchar(1) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yythd` (
  `ID` varchar(32) NOT NULL,
  `BM` varchar(10) DEFAULT NULL,
  `MC` varchar(128) DEFAULT NULL,
  `USERYYID` varchar(64) DEFAULT NULL,
  `LXR` varchar(64) DEFAULT NULL,
  `LXDH` varchar(64) DEFAULT NULL,
  `CJR` varchar(64) DEFAULT NULL,
  `CJTIME` datetime DEFAULT NULL,
  `XGTIME` datetime DEFAULT NULL,
  `TJTIME` datetime DEFAULT NULL,
  `BZ` varchar(256) DEFAULT NULL,
  `ZT` varchar(1) DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BM` (`BM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yythd2014` (
  `ID` varchar(32) NOT NULL,
  `BM` varchar(10) NOT NULL,
  `MC` varchar(128) NOT NULL,
  `USERYYID` varchar(64) NOT NULL,
  `LXR` varchar(64) DEFAULT NULL,
  `LXDH` varchar(64) DEFAULT NULL,
  `CJR` varchar(64) DEFAULT NULL,
  `CJTIME` datetime NOT NULL,
  `TJTIME` datetime DEFAULT NULL,
  `XGTIME` datetime DEFAULT NULL,
  `BZ` varchar(256) DEFAULT NULL,
  `ZT` varchar(1) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BM` (`BM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yythdmx` (
  `ID` varchar(32) NOT NULL,
  `YYTHDID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `THL` decimal(22,0) NOT NULL,
  `THJE` double NOT NULL,
  `THZT` varchar(1) NOT NULL,
  `THYY` varchar(100) DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yythdmx2014` (
  `ID` varchar(32) NOT NULL,
  `YYTHDID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `YYCGDID` varchar(32) NOT NULL,
  `THL` decimal(22,0) NOT NULL,
  `THJE` double NOT NULL,
  `THZT` varchar(1) NOT NULL,
  `THYY` varchar(100) DEFAULT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  `VCHAR3` varchar(64) DEFAULT NULL,
  `VCHAR4` varchar(128) DEFAULT NULL,
  `VCHAR5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yyypml` (
  `ID` varchar(32) NOT NULL,
  `YPXXID` varchar(32) NOT NULL,
  `USERYYID` varchar(64) NOT NULL,
  `USERGYSID` varchar(64) NOT NULL,
  `VCHAR1` varchar(64) DEFAULT NULL,
  `VCHAR2` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK9CEF26168973E2D1` (`YPXXID`),
  CONSTRAINT `FK9CEF26168973E2D1` FOREIGN KEY (`YPXXID`) REFERENCES `ypxx` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
