
## 该分支用于测试mybatis 功能

### 一对多

#### 1. 创建数据库表
```sql
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hellossm` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `hellossm`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `username` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `role` varchar(255) DEFAULT NULL COMMENT '用户身份',
  `status` int(1) DEFAULT NULL COMMENT '用户状态',
  `regTime` datetime DEFAULT NULL COMMENT '注册时间',
  `regIp` varchar(255) DEFAULT NULL COMMENT '注册IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1;
insert  into `user`(`id`,`email`,`password`,`username`,`role`,`status`,`regTime`,`regIp`) values (1,'hello@163.com','1223','helloKang','root',1,'2017-03-28 09:40:31','127.0.0.1');

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子ID',
  `userid` int(11) DEFAULT NULL COMMENT '发帖人ID',
  `title` varchar(255) DEFAULT NULL COMMENT '帖子标题',
  `content` varchar(1024) DEFAULT NULL COMMENT '帖子内容',
  `createdtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`post_id`),
  KEY `userid` (`userid`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `post`(`post_id`,`userid`,`title`,`content`,`createdtime`) values (1,1,'title1','content1','2017-03-29 09:40:31');

```

#### 2. 创建表对应的 JavaBean 对象

