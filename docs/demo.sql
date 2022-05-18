USE demo;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id              Int          NOT NULL auto_increment,
  name            Varchar(40)  NOT NULL COMMENT '�ǳ�',
  email           Varchar(60)  NOT NULL COMMENT '�����ʼ�',
  status          TinyInt      NOT NULL COMMENT '״̬',
  registerTime    Datetime     NOT NULL COMMENT 'ע��ʱ��',
  PRIMARY KEY  (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;