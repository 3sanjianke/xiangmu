/*
 Navicat Premium Data Transfer

 Source Server         : wrent
 Source Server Type    : MySQL
 Source Server Version : 50172
 Source Host           : localhost:3308
 Source Schema         : wrent

 Target Server Type    : MySQL
 Target Server Version : 50172
 File Encoding         : 65001

 Date: 14/01/2019 14:03:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_type_id` int(11) NULL DEFAULT 0,
  `goods_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_name` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_price` double NULL DEFAULT 0,
  `goods_yj` double NULL DEFAULT NULL,
  `goods_price2` double NULL DEFAULT NULL,
  `goods_count` int(11) NULL DEFAULT NULL,
  `goods_pic` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `goods_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 1, 'G001', '婚庆礼服1', 150, 300, 50, 101, '20190114111440931.png', '&lt;p align=\"center\"&gt;\r\n	&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt; \r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&lt;br /&gt;\r\n&lt;/p&gt;', '2019-01-12 15:41:49');
INSERT INTO `goods` VALUES (2, 1, 'G002', '婚庆礼服2', 200, 300, 50, 100, '20180508215132.jpg', '&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt;\r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n&lt;/p&gt;', '2019-01-12 15:41:49');
INSERT INTO `goods` VALUES (3, 1, 'G003', '婚庆礼服3', 250, 300, 50, 100, '20180508215133.jpg', '&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt;\r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n&lt;/p&gt;', '2019-01-12 15:41:49');
INSERT INTO `goods` VALUES (4, 1, 'G004', '婚庆礼服4', 200, 300, 50, 100, '20180508215134.jpg', '&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt;\r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n&lt;/p&gt;', '2019-01-12 15:41:49');
INSERT INTO `goods` VALUES (5, 1, 'G005', '婚庆礼服5', 300, 300, 50, 100, '20180508215131.jpg', '&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt;\r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n&lt;/p&gt;', '2019-01-12 15:41:49');
INSERT INTO `goods` VALUES (6, 1, 'G006', '婚庆礼服6', 350, 300, 50, 100, '20180508215132.jpg', '&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt;\r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n&lt;/p&gt;', '2019-01-12 15:41:49');
INSERT INTO `goods` VALUES (7, 1, 'G007', '婚庆礼服7', 400, 300, 50, 98, '20180508215133.jpg', '&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt;\r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n&lt;/p&gt;', '2019-01-12 15:41:49');
INSERT INTO `goods` VALUES (8, 1, 'G008', '婚庆礼服8', 200, 300, 50, 100, '20180508215134.jpg', '&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt;\r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n&lt;/p&gt;', '2019-01-12 15:41:49');
INSERT INTO `goods` VALUES (9, 1, 'G009', '婚庆礼服9', 150, 300, 50, 100, '20180508215131.jpg', '&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt;\r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n&lt;/p&gt;', '2019-01-12 15:41:49');
INSERT INTO `goods` VALUES (10, 1, 'G010', '婚庆礼服10', 200, 300, 50, 100, '20180508215132.jpg', '&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;img width=\"798\" height=\"800\" style=\"width:439px;height:407px;\" alt=\"\" src=\"/wrent/images/infos/image/20180510/20180508215131.jpg\" /&gt;\r\n&lt;/p&gt;\r\n&lt;p align=\"center\"&gt;\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n&lt;/p&gt;', '2019-01-12 15:41:49');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type`  (
  `goods_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_type_name` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goods_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES (1, '礼服');
INSERT INTO `goods_type` VALUES (5, '阿斯蒂芬');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orders_id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orders_date` date NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_address` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_id` int(11) NULL DEFAULT 0,
  `goods_name` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_price` double NULL DEFAULT NULL,
  `goods_yj` double NULL DEFAULT NULL,
  `goods_price2` double NULL DEFAULT NULL,
  `goods_count` int(11) NULL DEFAULT 1,
  `orders_date1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orders_date2` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_money` double NULL DEFAULT NULL,
  `orders_date3` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_money2` double NULL DEFAULT NULL,
  `orders_flag` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`orders_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2019011066666666', '2019-01-10', 2, '代长甲', '青岛大学', '13266666666', 7, '婚庆礼服7', 400, 300, 50, 2, '2019-01-10', '2019-01-11', 2000, NULL, 0, 2);
INSERT INTO `orders` VALUES (2, '2019011188888888', '2019-01-11', 2, '代长甲', '青岛大学', '13266666666', 2, '婚庆礼服2', 200, 300, 50, 2, '2019-01-11', '2019-01-12', 2000, NULL, 0, 5);
INSERT INTO `orders` VALUES (3, '20190113233355151', '2019-01-13', 15, '123', '3213', '12312312311', 1, '婚庆礼服1', 150, 50, 50, 1, '2019-01-14', '2019-01-15', 300, NULL, 0, 1);
INSERT INTO `orders` VALUES (4, '20190114113518153', '2019-01-14', 15, '123', '发送到', '12312312311', 3, '婚庆礼服3', 250, 50, 50, 1, '2019-01-17', '2019-01-31', 3750, NULL, 0, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_pass` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_sex` int(11) NULL DEFAULT 0 COMMENT '1：男 0：女',
  `user_address` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_photo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reg_date` datetime NULL DEFAULT NULL,
  `user_type` int(11) NULL DEFAULT 1 COMMENT '1：注册用户 2：管理员 ',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '4cb0a5502e9aa44a0ca99e96742f2e788aad875a', '李华', NULL, 1, NULL, 'admin@163.com', '15088888888', NULL, '2019-01-10 23:08:39', 2);
INSERT INTO `user` VALUES (2, 'weijiawei', '59b375b5b7e3ef30871298e90709fcbae62a7845', '魏家炜', '魏家炜', 1, '青岛大学', 'weijiawei@163.com', '17866666666', '20190114110545657.png', '2019-01-11 23:08:44', 1);
INSERT INTO `user` VALUES (3, 'daichangjia', '59b375b5b7e3ef30871298e90709fcbae62a7845', '代长甲', '代长甲', 1, '青岛大学', 'daichangjia@163.com', '13266666666', '20190114110554084.png', '2019-01-12 23:08:46', 1);
INSERT INTO `user` VALUES (4, 'hubaojin', '59b375b5b7e3ef30871298e90709fcbae62a7845', '胡宝进', '胡宝进', 1, '青岛大学', 'hubaojin@163.com', '13500000000', '20190114110536350.png', '2019-01-13 23:08:44', 1);
INSERT INTO `user` VALUES (14, 'daichangjia1', '82452809890492868a1ba38346b2e595147e658a', '代长甲', '帅', 1, '', '', '13266666666', 'default.jpg', '2019-01-13 23:20:17', 1);
INSERT INTO `user` VALUES (15, '123', '59b375b5b7e3ef30871298e90709fcbae62a7845', '123', '123', 1, '', '', '12312312311', '20190113232324691.png', '2019-01-13 23:21:41', 1);
INSERT INTO `user` VALUES (16, '沃尔特瓦尔塔', '4cb0a5502e9aa44a0ca99e96742f2e788aad875a', '大概', '反倒是', 1, '', '', '435345345', 'default.jpg', '2019-01-14 11:25:58', 1);
INSERT INTO `user` VALUES (17, '而是发生大', '4cb0a5502e9aa44a0ca99e96742f2e788aad875a', '士大夫', ' 是的撒', 1, '', '', '2332423', 'default.jpg', '2019-01-14 11:26:19', 1);

SET FOREIGN_KEY_CHECKS = 1;
