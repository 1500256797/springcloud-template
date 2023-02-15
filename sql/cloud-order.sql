/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : localhost:3306
 Source Schema         : heima

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;



    -- ----------------------------
-- t_users 表：存储用户的信息。
-- ----------------------------
DROP TABLE IF EXISTS t_users;
CREATE TABLE t_users (
                         id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
                         name VARCHAR(255) NOT NULL COMMENT '用户名',
                         email VARCHAR(255) NOT NULL COMMENT '用户邮箱',
                         password VARCHAR(255) NOT NULL COMMENT '用户密码',
                         created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         status TINYINT NOT NULL DEFAULT 1 COMMENT '状态，1代表正常，2代表删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';





-- ----------------------------
-- t_products 表：存储商品的信息。
-- ----------------------------
DROP TABLE IF EXISTS t_products;
CREATE TABLE t_products (
                            id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '商品ID',
                            name VARCHAR(255) NOT NULL COMMENT '商品名称',
                            description TEXT NOT NULL COMMENT '商品描述',
                            image_url VARCHAR(255) NOT NULL COMMENT '商品图片URL',
                            price DECIMAL(10, 2) NOT NULL COMMENT '商品价格',
                            created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            status TINYINT NOT NULL DEFAULT 1 COMMENT '状态，1代表正常，2代表删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';


-- ----------------------------
-- t_orders 表：存储订单的信息。
-- ----------------------------
DROP TABLE IF EXISTS t_orders;
CREATE TABLE t_orders (
                          id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '订单ID',
                          user_id INT UNSIGNED NOT NULL COMMENT '用户ID',
                          total DECIMAL(10, 2) NOT NULL COMMENT '订单总金额',
                          address TEXT NOT NULL COMMENT '送货地址',
                          payment_method VARCHAR(255) NOT NULL COMMENT '支付方式',
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          status TINYINT NOT NULL DEFAULT 1 COMMENT '状态，1代表正常，2代表删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';




-- ----------------------------
-- t_fx_distributors 表：存储分销商的信息。
-- ----------------------------
DROP TABLE IF EXISTS t_fx_distributors;
CREATE TABLE t_fx_distributors (
                                   id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '分销商ID',
                                   user_id INT UNSIGNED NOT NULL COMMENT '关联的用户ID',
                                   parent_id INT UNSIGNED DEFAULT NULL COMMENT '上级分销商ID',
                                   level INT NOT NULL DEFAULT 0 COMMENT '分销商层级',
                                   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                   status TINYINT NOT NULL DEFAULT 1 COMMENT '状态，1代表正常，2代表删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分销商表';

-- ----------------------------
-- t_fx_relations 表：存储分销关系的信息。
-- ----------------------------
DROP TABLE IF EXISTS t_fx_relations;
CREATE TABLE t_fx_relations (
                                id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '关系ID',
                                user_id INT UNSIGNED NOT NULL COMMENT '下线用户ID',
                                distributor_id INT UNSIGNED NOT NULL COMMENT '分销商ID',
                                level INT NOT NULL DEFAULT 1 COMMENT '下线用户对应分销商的层级',
                                created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                status TINYINT NOT NULL DEFAULT 1 COMMENT '状态，1代表正常，2代表删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分销关系表';

-- ----------------------------
-- t_fx_levels 表：存储分销商等级的信息。
-- ----------------------------
DROP TABLE IF EXISTS t_fx_levels;
CREATE TABLE t_fx_levels (
                             id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '等级ID',
                             name VARCHAR(255) NOT NULL COMMENT '等级名称',
                             commission_rate DECIMAL(4,2) NOT NULL COMMENT '佣金比例',
                             created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             status TINYINT NOT NULL DEFAULT 1 COMMENT '状态，1代表正常，2代表删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分销商等级表';

-- ----------------------------
-- t_fx_orders 表：存储分销订单的信息。
-- ----------------------------
DROP TABLE IF EXISTS t_fx_orders;
CREATE TABLE t_fx_orders (
                             id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '订单ID',
                             order_id INT UNSIGNED NOT NULL COMMENT '订单ID',
                             distributor_id INT UNSIGNED NOT NULL COMMENT '分销商ID',
                             commission DECIMAL(10, 2) NOT NULL COMMENT '佣金金额',
                             created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             status TINYINT NOT NULL DEFAULT 1 COMMENT '状态，1代表正常，2代表删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分销订单表';


-- ----------------------------
-- t_fx_order_details 表：存储分销订单详情的信息。
-- ----------------------------
DROP TABLE IF EXISTS t_fx_order_details;
CREATE TABLE t_fx_order_details (
                                    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '订单详情ID',
                                    order_id INT UNSIGNED NOT NULL COMMENT '订单ID',
                                    product_id INT UNSIGNED NOT NULL COMMENT '商品ID',
                                    quantity INT NOT NULL COMMENT '商品数量',
                                    price DECIMAL(10, 2) NOT NULL COMMENT '商品单价',
                                    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    status TINYINT NOT NULL DEFAULT 1 COMMENT '状态，1代表正常，2代表删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分销订单详情表';



INSERT INTO t_users (name, email, password) VALUES
                                                ('Alice', 'alice@example.com', 'password1'),
                                                ('Bob', 'bob@example.com', 'password2'),
                                                ('Charlie', 'charlie@example.com', 'password3'),
                                                ('David', 'david@example.com', 'password4'),
                                                ('Eve', 'eve@example.com', 'password5');

INSERT INTO t_products (name, description, image_url, price) VALUES
                                                                 ('Product A', 'This is product A', 'https://picsum.photos/200/300?random=1', 10.00),
                                                                 ('Product B', 'This is product B', 'https://picsum.photos/200/300?random=2', 20.00),
                                                                 ('Product C', 'This is product C', 'https://picsum.photos/200/300?random=3', 30.00),
                                                                 ('Product D', 'This is product D', 'https://picsum.photos/200/300?random=4', 40.00),
                                                                 ('Product E', 'This is product E', 'https://picsum.photos/200/300?random=5', 50.00),
                                                                 ('Product F', 'This is product F', 'https://picsum.photos/200/300?random=6', 60.00),
                                                                 ('Product G', 'This is product G', 'https://picsum.photos/200/300?random=7', 70.00),
                                                                 ('Product H', 'This is product H', 'https://picsum.photos/200/300?random=8', 80.00),
                                                                 ('Product I', 'This is product I', 'https://picsum.photos/200/300?random=9', 90.00),
                                                                 ('Product J', 'This is product J', 'https://picsum.photos/200/300?random=10', 100.00);


INSERT INTO t_orders (user_id, total, address, payment_method) VALUES
                                                                   (1, 100.00, '123 Main St, Anytown USA', 'Credit Card'),
                                                                   (1, 50.00, '456 Oak St, Anytown USA', 'PayPal'),
                                                                   (2, 200.00, '789 Maple St, Anytown USA', 'Credit Card'),
                                                                   (2, 75.00, '321 Pine St, Anytown USA', 'PayPal'),
                                                                   (3, 300.00, '654 Cedar St, Anytown USA', 'Credit Card'),
                                                                   (3, 100.00, '987 Elm St, Anytown USA', 'PayPal'),
                                                                   (4, 400.00, '246 Birch St, Anytown USA', 'Credit Card'),
                                                                   (4, 125.00, '864 Willow St, Anytown USA', 'PayPal'),
                                                                   (5, 500.00, '369 Oakwood St, Anytown USA', 'Credit Card'),
                                                                   (5, 150.00, '951 Maplewood St, Anytown USA', 'PayPal');


INSERT INTO t_fx_distributors (user_id, parent_id, level, created_at, updated_at, status)
VALUES
    (1, NULL, 0, now(), now(), 1),
    (2, 1, 1, now(), now(), 1),
    (3, 2, 2, now(), now(), 1),
    (4, 1, 1, now(), now(), 1),
    (5, 4, 2, now(), now(), 1);


INSERT INTO t_fx_relations (user_id, distributor_id, level, created_at, updated_at, status)
VALUES
    (2, 1, 1, now(), now(), 1),
    (3, 2, 1, now(), now(), 1),
    (4, 1, 1, now(), now(), 1),
    (5, 4, 1, now(), now(), 1),
    (3, 1, 2, now(), now(), 1);

-- t_fx_levels 表测试数据
INSERT INTO t_fx_levels (name, commission_rate) VALUES
                                                    ('普通会员', 0),
                                                    ('银牌会员', 0.05),
                                                    ('金牌会员', 0.1),
                                                    ('钻石会员', 0.15),
                                                    ('至尊会员', 0.2);
-- t_fx_orders 表测试数据
INSERT INTO t_fx_orders (order_id, distributor_id, commission) VALUES
                                                                   (1001, 1, 20),
                                                                   (1002, 2, 30),
                                                                   (1003, 3, 50),
                                                                   (1004, 4, 40),
                                                                   (1005, 5, 25);

-- t_fx_order_details 表测试数据
INSERT INTO t_fx_order_details (order_id, product_id, quantity, price) VALUES
                                                                           (1001, 1, 2, 50),
                                                                           (1002, 2, 3, 20),
                                                                           (1003, 3, 1, 100),
                                                                           (1004, 4, 4, 10),
                                                                           (1005, 5, 2, 15);
