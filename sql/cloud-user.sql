/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50737
Source Host           : localhost:3306
Source Database       : cloud-user

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2023-02-17 20:50:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_permissions
-- ----------------------------
DROP TABLE IF EXISTS `t_permissions`;
CREATE TABLE `t_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `resource` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_permissions
-- ----------------------------
INSERT INTO `t_permissions` VALUES ('1', 'create_post', '发布帖子', '/posts/create', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_permissions` VALUES ('2', 'edit_post', '编辑帖子', '/posts/{id}/edit', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_permissions` VALUES ('3', 'delete_post', '删除帖子', '/posts/{id}/delete', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_permissions` VALUES ('4', 'view_post', '查看帖子', '/posts/{id}', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');

-- ----------------------------
-- Table structure for t_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_roles`;
CREATE TABLE `t_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` int(11) DEFAULT '1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_roles
-- ----------------------------
INSERT INTO `t_roles` VALUES ('1', 'admin', '管理员', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_roles` VALUES ('2', 'user', '普通用户', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_roles` VALUES ('3', 'uservip', '付费用户', '1', '2023-02-17 19:58:12', '2023-02-17 19:58:36');

-- ----------------------------
-- Table structure for t_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permissions`;
CREATE TABLE `t_role_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `status` int(11) DEFAULT '1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_role_permissions
-- ----------------------------
INSERT INTO `t_role_permissions` VALUES ('1', '1', '1', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_role_permissions` VALUES ('2', '1', '2', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_role_permissions` VALUES ('3', '1', '3', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_role_permissions` VALUES ('4', '1', '4', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_role_permissions` VALUES ('5', '2', '4', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '微信用户头像',
  `nickname` varchar(255) DEFAULT NULL COMMENT '微信用户昵称',
  `openid` varchar(255) DEFAULT NULL COMMENT '微信用户OpenId',
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', 'admin', null, null, null, 'admin', 'admin@example.com', '1', '2023-02-10 17:19:03', '2023-02-17 20:39:51');
INSERT INTO `t_users` VALUES ('2', 'user', null, null, null, 'user_password', 'test@example.com', '1', '2023-02-10 17:19:03', '2023-02-17 20:40:29');
INSERT INTO `t_users` VALUES ('9', 'useroP_iE', 'https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132', '微信用户', 'oP_iE5HlfAct1WEWxa5bPs5wfI_A', 'password_iE5HlfA', null, '1', '2023-02-17 20:16:34', '2023-02-17 20:16:34');

-- ----------------------------
-- Table structure for t_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_user_roles`;
CREATE TABLE `t_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_user_roles
-- ----------------------------
INSERT INTO `t_user_roles` VALUES ('1', '1', '1', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_user_roles` VALUES ('2', '2', '2', '1', '2023-02-10 17:19:03', '2023-02-10 17:19:03');
INSERT INTO `t_user_roles` VALUES ('6', '9', '2', '1', '2023-02-17 20:16:34', '2023-02-17 20:16:34');
