/*
 Navicat Premium Data Transfer

 Source Server         : zhangyou-mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : games

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 23/10/2020 13:44:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rolename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', '管理员');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `users` int(11) NULL DEFAULT NULL,
  `product` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `users`(`users`) USING BTREE,
  INDEX `product`(`product`) USING BTREE,
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`users`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`product`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (54, 'zzhx.jpg', '最终幻想14(全平台)', 280, 2, 5, 14);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `users` int(255) NULL DEFAULT NULL,
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `totalPrice` double NULL DEFAULT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `users`(`users`) USING BTREE,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`users`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (10, 4, 'a76d195cd9934eda9756016dc2fd4631', 1580, '2020-09-28 14:18:56', 0);
INSERT INTO `order` VALUES (11, 4, 'defde1b4fa1d497ba22c1964f5668120', 560, '2020-09-29 06:43:15', 0);
INSERT INTO `order` VALUES (12, 4, 'b30b1b5b4e5f4b348b31b024dbde8f1e', 1200, '2020-09-29 06:43:42', 1);
INSERT INTO `order` VALUES (13, 5, 'a0489b14c7a3451f9d4278870eda9f43', 300, '2020-09-29 07:07:44', 0);
INSERT INTO `order` VALUES (14, 6, '25366005f2ee415089d9f55f5f059b25', 900, '2020-09-29 07:41:51', 1);

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders` int(11) NULL DEFAULT NULL,
  `product` int(11) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `orders`(`orders`) USING BTREE,
  INDEX `product`(`product`) USING BTREE,
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`orders`) REFERENCES `order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`product`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES (7, 10, 11, 1, 300);
INSERT INTO `orderitem` VALUES (8, 10, 15, 1, 480);
INSERT INTO `orderitem` VALUES (9, 10, 10, 2, 800);
INSERT INTO `orderitem` VALUES (10, 11, 14, 2, 560);
INSERT INTO `orderitem` VALUES (11, 12, 10, 3, 1200);
INSERT INTO `orderitem` VALUES (12, 13, 13, 1, 300);
INSERT INTO `orderitem` VALUES (13, 14, 12, 2, 600);
INSERT INTO `orderitem` VALUES (14, 14, 13, 1, 300);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prosn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proprice` double NULL DEFAULT NULL,
  `pronum` int(11) NULL DEFAULT NULL,
  `proimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `profullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (8, '龙珠超', 'P122', 300, 99, 'lzcyz.jpg', NULL, '龙珠超宇宙PS独占2017', '个', '2018-05-22 10:04:30', 0);
INSERT INTO `product` VALUES (10, '美国末日', 'P123', 400, 99, 'mgmr.jpg', NULL, '美国末日PS3独占2016年-IGN满分神作(PS独占)', '个', '2018-03-07 10:08:49', 0);
INSERT INTO `product` VALUES (11, '神秘海域3', 'P124', 300, 99, 'sh3.jpg', NULL, '神秘海域第三部-德雷克的谎言(PS独占)', '个', '2017-11-15 10:08:54', 0);
INSERT INTO `product` VALUES (12, '生化危机6', 'P125', 300, 99, 'shwj6.jpg', NULL, '生化危机第6部(部分平台)', '个', '2017-11-15 10:08:54', 0);
INSERT INTO `product` VALUES (13, '杀戮地带', 'P126', 300, 99, 'sldd.jpg', NULL, '杀戮地带3(全平台)', '个', '2017-11-15 10:08:54', 0);
INSERT INTO `product` VALUES (14, '最终幻想', 'P127', 280, 99, 'zzhx.jpg', NULL, '最终幻想14(全平台)', '个', '2017-11-15 10:08:54', 0);
INSERT INTO `product` VALUES (15, '战神4', 'P128', 480, 99, 'zs4.jpg', NULL, '北欧篇章全新启程(战神4 无副标题)', '个', '2018-04-21 16:39:05', 0);
INSERT INTO `product` VALUES (16, '荒野大镖客2', 'P129', 560, 99, 'hy2.jpg', NULL, 'R星GTA5后2大团队合力打造-2018最受期待游戏之一', '个', '2018-10-18 16:44:16', 0);
INSERT INTO `product` VALUES (17, '蜘蛛侠', 'P130', 470, 99, 'zzx.jpg', NULL, '漫威官方授权索尼独占大作', '个', '2018-09-27 16:46:52', 0);
INSERT INTO `product` VALUES (18, '神秘海域4', 'P131', 300, 99, 'sh4_new.jpg', NULL, '神秘海域第四部盗贼末路', '个', '2016-02-26 16:47:59', 0);
INSERT INTO `product` VALUES (19, '王者', 'P000', 1314, 999, 'e91629c3135d4a7a86d215d7b0c09b77.png', NULL, '王者荣耀', '件', '2020-10-03 09:47:10', 0);
INSERT INTO `product` VALUES (20, '佑佑有话说', 'P0001', 1314, 521, '704004d6ff93485b80f5814e9a63caee.png', NULL, '佑佑有话说', '个', '2020-10-03 09:52:25', 0);

-- ----------------------------
-- Table structure for proimg
-- ----------------------------
DROP TABLE IF EXISTS `proimg`;
CREATE TABLE `proimg`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgsrc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of proimg
-- ----------------------------
INSERT INTO `proimg` VALUES (1, '1.jpg', 15);
INSERT INTO `proimg` VALUES (2, '2.jpg', 15);
INSERT INTO `proimg` VALUES (3, '3.jpg', 15);
INSERT INTO `proimg` VALUES (4, '4.jpg', 15);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (4, 'aaa', 'aaa', '佑佑', '123456789', '北京市');
INSERT INTO `user` VALUES (5, 'bbb', 'bbb', 'hello', '', '');
INSERT INTO `user` VALUES (6, 'ccc', 'ccc', '哈哈哈', NULL, NULL);
INSERT INTO `user` VALUES (7, 'ddd', 'ddd', '小明', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
