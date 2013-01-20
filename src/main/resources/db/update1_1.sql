DROP TABLE IF EXISTS `app_config`;

CREATE TABLE `app_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(16) DEFAULT NULL,
  `web_title` varchar(20) DEFAULT NULL COMMENT '标题',
  `sub_title` varchar(100) DEFAULT NULL COMMENT '子标题',
  `host_url` varchar(50) DEFAULT NULL COMMENT '地址',
  `meta_keywords` varchar(100) DEFAULT NULL COMMENT 'meta keywords',
  `meta_description` varchar(200) DEFAULT NULL COMMENT 'meta description',
  `board_source` text COMMENT '公告',
  `hidden_source` text COMMENT '底部隐藏-统计代码',
  `registable` tinyint(1) DEFAULT '1' COMMENT '是否开放注册',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `app_config`(`id`,`version`,`web_title`,`sub_title`,`host_url`,`meta_keywords`,`meta_description`,`board_source`,`hidden_source`,`registable`) values (1,'1.1','域猫','come on','http://runcat.org',NULL,NULL,NULL,NULL,1);

DROP TABLE IF EXISTS `domain`;

CREATE TABLE `domain` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL COMMENT '域名',
  `password` varchar(44) NOT NULL COMMENT '密码',
  `salt` varchar(16) NOT NULL COMMENT '密码盐',
  `email` varchar(100) default NULL COMMENT '邮箱',
  `status` tinyint(4) NOT NULL default '1' COMMENT '状态',
  `dnspod_domain_id` varchar(11) NOT NULL default '' COMMENT 'dnspod中的域名id',
  `regist_time` timestamp NULL default CURRENT_TIMESTAMP COMMENT '注册时间',
  `regist_ip` varchar(32) default NULL COMMENT '注册ip',
  `last_time` timestamp NULL default NULL COMMENT '最后修改时间',
  `last_ip` varchar(32) default NULL COMMENT '最后修改ip',
  `description` text COMMENT '说明',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `domain`(`name`,`password`,`salt`,`dnspod_domain_id`) values('runcat.org','K50paAp6XRU6xMt5VmmQvEVfe33hfgxHDRx1gYYxNTU=','0VSG15LOUN4=','2723144');

DROP TABLE IF EXISTS `subdomain`;

CREATE TABLE `subdomain` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL COMMENT '域名',
  `fullname` varchar(80) NOT NULL COMMENT '全域名',
  `password` varchar(44) NOT NULL COMMENT '密码',
  `salt` varchar(16) NOT NULL default '' COMMENT '密码盐',
  `email` varchar(100) default NULL COMMENT '邮箱',
  `status` tinyint(4) NOT NULL default '1' COMMENT '状态',
  `dnspod_domain_id` int(11) default NULL COMMENT 'dnspod域名id',
  `regist_time` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '注册时间',
  `regist_ip` varchar(32) default NULL COMMENT '注册ip',
  `last_time` timestamp NULL default NULL COMMENT '最后修改时间',
  `last_ip` varchar(32) default NULL COMMENT '最后修改ip',
  `description` text COMMENT '说明',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `dnsrecord`;

CREATE TABLE `dnsrecord` (
  `id` int(11) NOT NULL auto_increment,
  `sub_domain` varchar(50) NOT NULL COMMENT '主机记录',
  `record_type` tinyint(4) NOT NULL COMMENT '记录类型A,CNAME,TXT,NS,AAAA,MX,URL,SRV',
  `record_line` tinyint(4) NOT NULL COMMENT '线路类型',
  `value` varchar(50) NOT NULL COMMENT '记录值',
  `mx` varchar(10) NOT NULL default '-' COMMENT 'mx优先级',
  `ttl` int(11) NOT NULL default '600' COMMENT 'TTL',
  `stopable` tinyint(1) NOT NULL default '0' COMMENT '暂停使用',
  `subdomain_id` int(11) NOT NULL COMMENT '二级域名id',
  `dnspod_record_id` varchar(11) NOT NULL COMMENT 'dnspod记录id',
  `dnspod_domain_id` varchar(11) NOT NULL COMMENT 'dnspod域名id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;