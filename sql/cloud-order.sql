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
-- t_order_details 表：存储订单详情的信息。
-- ----------------------------
DROP TABLE IF EXISTS t_order_details;
CREATE TABLE t_order_details (
                                 id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '订单详情ID',
                                 order_id INT UNSIGNED NOT NULL COMMENT '订单ID',
                                 product_id INT UNSIGNED NOT NULL COMMENT '商品ID',
                                 quantity INT NOT NULL COMMENT '商品数量',
                                 price DECIMAL(10, 2) NOT NULL COMMENT '商品单价',
                                 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 status TINYINT NOT NULL DEFAULT 1 COMMENT '状态，1代表正常，2代表删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';




-- ----------------------------
-- 插入测试数据
-- ----------------------------
INSERT INTO t_users(name, email, password) VALUES
                                               ('张三', 'zhangsan@example.com', '123456'),
                                               ('李四', 'lisi@example.com', '123456'),
                                               ('王五', 'wangwu@example.com', '123456'),
                                               ('赵六', 'zhaoliu@example.com', '123456'),
                                               ('钱七', 'qianqi@example.com', '123456'),
                                               ('孙八', 'sunba@example.com', '123456'),
                                               ('周九', 'zhoujiu@example.com', '123456'),
                                               ('吴十', 'wushi@example.com', '123456'),
                                               ('郑十一', 'zhengshiyi@example.com', '123456'),
                                               ('杨十二', 'yangshier@example.com', '123456');


-- ----------------------------
-- 插入测试数据
-- ----------------------------
INSERT INTO t_products(name, description, image_url, price) VALUES
                                                                ('商品A', '这是商品A的描述信息。', 'https://picsum.photos/id/1/200/300', 100.00),
                                                                ('商品B', '这是商品B的描述信息。', 'https://picsum.photos/id/2/200/300', 200.00),
                                                                ('商品C', '这是商品C的描述信息。', 'https://picsum.photos/id/3/200/300', 300.00),
                                                                ('商品D', '这是商品D的描述信息。', 'https://picsum.photos/id/4/200/300', 400.00),
                                                                ('商品E', '这是商品E的描述信息。', 'https://picsum.photos/id/5/200/300', 500.00),
                                                                ('商品F', '这是商品F的描述信息。', 'https://picsum.photos/id/6/200/300', 600.00),
                                                                ('商品G', '这是商品G的描述信息。', 'https://picsum.photos/id/7/200/300', 700.00),
                                                                ('商品H', '这是商品H的描述信息。', 'https://picsum.photos/id/8/200/300', 800.00),
                                                                ('商品I', '这是商品I的描述信息。', 'https://picsum.photos/id/9/200/300', 900.00),
                                                                ('商品J', '这是商品J的描述信息。', 'https://picsum.photos/id/10/200/300', 1000.00);



-- ----------------------------
-- 插入测试数据
-- ----------------------------
INSERT INTO t_orders(user_id, total, address, payment_method) VALUES
                                                                  (1, 1500.00, '北京市海淀区', '支付宝'),
                                                                  (1, 2800.00, '北京市朝阳区', '微信支付'),
                                                                  (2, 950.00, '上海市浦东新区', '银联支付'),
                                                                  (2, 1700.00, '上海市徐汇区', '支付宝'),
                                                                  (3, 2200.00, '广州市天河区', '微信支付'),
                                                                  (3, 4000.00, '广州市越秀区', '银联支付'),
                                                                  (4, 3200.00, '深圳市福田区', '支付宝'),
                                                                  (4, 2700.00, '深圳市宝安区', '微信支付'),
                                                                  (5, 1800.00, '成都市高新区', '银联支付'),
                                                                  (5, 900.00, '成都市锦江区', '支付宝');



-- 插入测试数据

INSERT INTO t_order_details(order_id, product_id, quantity, price) VALUES
                                                                       (1, 1, 5, 100.00),
                                                                       (1, 2, 10, 200.00),
                                                                       (2, 3, 2, 475.00),
                                                                       (2, 4, 6, 275.00),
                                                                       (3, 5, 3, 700.00),
                                                                       (3, 6, 2, 1200.00),
                                                                       (4, 7, 1, 400.00),
                                                                       (4, 8, 4, 450.00),
                                                                       (5, 9, 5, 540.00),
                                                                       (5, 10, 2, 280.00);

