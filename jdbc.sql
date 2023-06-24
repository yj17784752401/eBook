/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : yujiang

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2023-06-16 23:47:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `Bid` int(11) NOT NULL AUTO_INCREMENT,
  `BookName` varchar(50) DEFAULT NULL,
  `B_Price` varchar(10) DEFAULT NULL,
  `Image` varchar(100) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`Bid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', '泰戈尔诗集', '18', 'images/book/book_01.gif', '98');
INSERT INTO `books` VALUES ('2', '痕记', '22', 'images/book/book_02.gif', '81');
INSERT INTO `books` VALUES ('3', '天堂之旅', '25', 'images/book/book_03.gif', '977');
INSERT INTO `books` VALUES ('4', '钱钟书集（全10册）', '322', 'images/book/book_04.gif', '983');
INSERT INTO `books` VALUES ('5', '赵俪生高昭—夫妻回忆录', '38', 'images/book/book_05.gif', '987');
INSERT INTO `books` VALUES ('6', '无聊斋（张绍刚首部随笔杂文作品）', '28', 'images/book/book_06.gif', '997');
INSERT INTO `books` VALUES ('7', '一颗热土豆是一张温馨的床', '38', 'images/book/book_07.gif', '1001');
INSERT INTO `books` VALUES ('8', '李戡戡乱记', '22', 'images/book/book_08.gif', '997');
INSERT INTO `books` VALUES ('9', '生生世世未了缘', '17', 'images/book/book_09.gif', '998');
INSERT INTO `books` VALUES ('10', '一生有多少爱', '17.5', 'images/book/book_10.gif', '998');

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `Iid` int(11) NOT NULL AUTO_INCREMENT,
  `Oid` int(11) DEFAULT NULL,
  `Bid` int(11) DEFAULT NULL,
  `CreateDate` varchar(50) DEFAULT NULL,
  `Count` int(11) DEFAULT NULL,
  `Price` varchar(50) DEFAULT NULL,
  `Total_Price` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Iid`),
  KEY `Bid` (`Bid`),
  KEY `Oid` (`Oid`),
  CONSTRAINT `Bid` FOREIGN KEY (`Bid`) REFERENCES `books` (`Bid`),
  CONSTRAINT `Oid` FOREIGN KEY (`Oid`) REFERENCES `orders` (`Oid`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('83', '1', '4', '2023-06-10 :09:16:30', '1', '322', '360');
INSERT INTO `items` VALUES ('84', '2', '5', '2023-06-10 :09:16:30', '1', '38', '360');
INSERT INTO `items` VALUES ('85', '1', '1', '2023-06-10 :09:20:58', '1', '18', '40');
INSERT INTO `items` VALUES ('86', '2', '2', '2023-06-10 :09:20:58', '1', '22', '40');
INSERT INTO `items` VALUES ('87', '1', '1', '2023-06-10 :09:22:05', '2', '36', '36');
INSERT INTO `items` VALUES ('88', '1', '1', '2023-06-16 :10:27:05', '1', '18', '18');
INSERT INTO `items` VALUES ('89', '1', '1', '2023-06-16 :10:27:31', '2', '36', '36');
INSERT INTO `items` VALUES ('90', '1', '1', '2023-06-16 :10:50:48', '3', '54', '54');
INSERT INTO `items` VALUES ('91', '1', '2', '2023-06-16 :10:56:13', '3', '66', '66');
INSERT INTO `items` VALUES ('92', '1', '1', '2023-06-16 :10:57:17', '1', '18', '84');
INSERT INTO `items` VALUES ('93', '2', '2', '2023-06-16 :10:57:17', '3', '66', '84');
INSERT INTO `items` VALUES ('94', '1', '2', '2023-06-16 :10:58:15', '3', '66', '66');
INSERT INTO `items` VALUES ('95', '1', '2', '2023-06-16 :10:58:35', '1', '22', '22');
INSERT INTO `items` VALUES ('96', '1', '2', '2023-06-16 :10:58:47', '1', '22', '22');
INSERT INTO `items` VALUES ('97', '1', '2', '2023-06-16 :11:07:49', '2', '44', '44');
INSERT INTO `items` VALUES ('98', '1', '2', '2023-06-16 :11:10:54', '2', '44', '44');
INSERT INTO `items` VALUES ('99', '1', '2', '2023-06-16 :11:13:10', '2', '44', '44');
INSERT INTO `items` VALUES ('100', '1', '2', '2023-06-16 :11:14:06', '2', '44', '44');
INSERT INTO `items` VALUES ('101', '1', '2', '2023-06-16 :11:16:24', '2', '44', '44');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `Oid` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Oid`),
  KEY `Username` (`Username`),
  CONSTRAINT `Username` FOREIGN KEY (`Username`) REFERENCES `userinfo` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '余江');
INSERT INTO `orders` VALUES ('2', '余江');
INSERT INTO `orders` VALUES ('3', '余江');
INSERT INTO `orders` VALUES ('17', '石同鑫');
INSERT INTO `orders` VALUES ('18', '石同鑫');
INSERT INTO `orders` VALUES ('19', '石同鑫');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('余江', '123456', '1306879592@qq.com');
INSERT INTO `userinfo` VALUES ('朱云川', '12345678', '1306879592@qq.com');
INSERT INTO `userinfo` VALUES ('王振华', '12345678', '1306879592@qq.com');
INSERT INTO `userinfo` VALUES ('王毅', '12345678', '1306879592@qq.com');
INSERT INTO `userinfo` VALUES ('王艳红', '12345678', '1306879592@qq.com');
INSERT INTO `userinfo` VALUES ('石同鑫', '12345678', '1306879592@qq.com');
