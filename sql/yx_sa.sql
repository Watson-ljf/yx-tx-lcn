CREATE DATABASE yx_sa;

CREATE TABLE `yx_sa_account` (
  `id`          bigint(10) NOT NULL
  COMMENT '主键',
  `create_time` timestamp  NOT NULL
  COMMENT '新建时间',
  `balance`     bigint(10) NOT NULL DEFAULT '0'
  COMMENT '金额',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
