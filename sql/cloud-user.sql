SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


-- ----------------------------
-- t_users 表：存储用户的信息。
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE t_users (
     id INT PRIMARY KEY AUTO_INCREMENT, -- 主键
     username VARCHAR(255) NOT NULL UNIQUE, -- 用户名
     password VARCHAR(255) NOT NULL, -- 密码
     email VARCHAR(255) NOT NULL UNIQUE, -- 邮箱
     status INT DEFAULT 1, -- 状态，1代表启用，0代表删除
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 创建时间
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 更新时间
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- t_roles 表：存储角色的信息。
-- ----------------------------
DROP TABLE IF EXISTS `t_roles`;
CREATE TABLE t_roles (
     id INT PRIMARY KEY AUTO_INCREMENT, -- 主键
     name VARCHAR(255) NOT NULL UNIQUE, -- 角色名
     description VARCHAR(255) NOT NULL, -- 描述
     status INT DEFAULT 1, -- 状态，1代表启用，0代表删除
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 创建时间
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 更新时间
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


-- ----------------------------
-- t_user_roles 表：存储用户与角色之间的映射关系。
-- ----------------------------
DROP TABLE IF EXISTS `t_user_roles`;
CREATE TABLE t_user_roles (
  id INT PRIMARY KEY AUTO_INCREMENT, -- 主键
  user_id INT NOT NULL, -- 用户 ID
  role_id INT NOT NULL, -- 角色 ID
  status INT DEFAULT 1, -- 状态，1代表启用，0代表删除
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 创建时间
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 更新时间
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
-- ----------------------------
-- t_permissions 表：存储权限的信息。
-- ----------------------------
DROP TABLE IF EXISTS `t_permissions`;
CREATE TABLE t_permissions (
   id INT PRIMARY KEY AUTO_INCREMENT, --
   name VARCHAR(255) NOT NULL UNIQUE, -- 权限名
   description VARCHAR(255) NOT NULL, -- 描述
   resource VARCHAR(255), -- 资源
   status INT DEFAULT 1, -- 状态，1代表启用，0代表删除
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 创建时间
   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 更新时间
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- t_role_permissions 表：存储角色与权限之间的映射关系。
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permissions`;
CREATE TABLE t_role_permissions (
    id INT PRIMARY KEY AUTO_INCREMENT, -- 主键
    role_id INT NOT NULL, -- 角色 ID
    permission_id INT NOT NULL, -- 权限 ID
    status INT DEFAULT 1, -- 状态，1代表启用，0代表删除
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 创建时间
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 更新时间
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


-- ----------------------------
-- 测试语句
-- ----------------------------
INSERT INTO t_users (username, password, email, status) VALUES
                                                            ('admin', 'password', 'admin@example.com', 1),
                                                            ('test', 'password', 'test@example.com', 1);
INSERT INTO t_roles (name, description, status) VALUES
                                                    ('admin', '管理员', 1),
                                                    ('user', '普通用户', 1);
INSERT INTO t_user_roles (user_id, role_id, status) VALUES
                                                        (1, 1, 1),
                                                        (2, 2, 1);
INSERT INTO t_permissions (name, description, resource, status) VALUES
                                                                    ('create_post', '发布帖子', '/posts/create', 1),
                                                                    ('edit_post', '编辑帖子', '/posts/{id}/edit', 1),
                                                                    ('delete_post', '删除帖子', '/posts/{id}/delete', 1),
                                                                    ('view_post', '查看帖子', '/posts/{id}', 1);
INSERT INTO t_role_permissions (role_id, permission_id, status) VALUES
                                                                    (1, 1, 1),
                                                                    (1, 2, 1),
                                                                    (1, 3, 1),
                                                                    (1, 4, 1),
                                                                    (2, 4, 1);






INSERT INTO `tb_user` VALUES (1, '柳岩', '湖南省衡阳市');
INSERT INTO `tb_user` VALUES (2, '文二狗', '陕西省西安市');
INSERT INTO `tb_user` VALUES (3, '华沉鱼', '湖北省十堰市');
INSERT INTO `tb_user` VALUES (4, '张必沉', '天津市');
INSERT INTO `tb_user` VALUES (5, '郑爽爽', '辽宁省沈阳市大东区');
INSERT INTO `tb_user` VALUES (6, '范兵兵', '山东省青岛市');

SET FOREIGN_KEY_CHECKS = 1;
