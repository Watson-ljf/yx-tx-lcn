CREATE DATABASE tx_logger;

CREATE TABLE `t_logger` (
  `id`          bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id`    varchar(64) CHARACTER SET utf8
  COLLATE utf8_general_ci  NOT NULL,
  `unit_id`     varchar(32) CHARACTER SET utf8
  COLLATE utf8_general_ci  NOT NULL,
  `tag`         varchar(50) CHARACTER SET utf8
  COLLATE utf8_general_ci  NOT NULL,
  `content`     varchar(1024) CHARACTER SET utf8
  COLLATE utf8_general_ci  NOT NULL,
  `create_time` varchar(30) CHARACTER SET utf8
  COLLATE utf8_general_ci  NOT NULL,
  `app_name`    varchar(128) CHARACTER SET utf8
  COLLATE utf8_general_ci  NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 21
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC;