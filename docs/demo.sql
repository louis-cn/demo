USE demo;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id              Int          NOT NULL auto_increment,
  name            Varchar(40)  NOT NULL COMMENT '昵称',
  email           Varchar(60)  NOT NULL COMMENT '电子邮件',
  status          TinyInt      NOT NULL COMMENT '状态',
  registerTime    Datetime     NOT NULL COMMENT '注册时间',
  PRIMARY KEY  (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;