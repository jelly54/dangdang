/*
Navicat MySQL Data Transfer

Source Server         : Mysql_localhost
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : dangdang

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-01-13 13:14:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `book_price` double(10,2) DEFAULT NULL,
  `book_discount` float DEFAULT NULL,
  `book_author` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `book_bpublic` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `book_count` int(11) DEFAULT NULL,
  `book_cover` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `book_info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type_id` int(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '可爱的鼠小弟', '138.00', '55', '(日)中江嘉男', '江南出版社', '999', 'cover/shu.jpg', '早期阅读是儿童身心成长的关键，选择合适的图书并以正确的方式阅读，孩子就能在快乐中全面发展心智。“可爱的鼠小弟”是日本著名绘本作家 中嘉男和上野纪子合作的不朽经典，被誉为“日本绘本史上不可……”', '1');
INSERT INTO `book` VALUES ('2', '摆渡人', '120.00', '46', '克莱儿·麦克福尔', '中国建材出版社', '998', 'cover/baiduren.jpg', '从少年人的角度洞悉人性的温情，通过男女主人公的所见所感，道出所有人对亲情、友情和爱情终极幸福的向往。', '2');
INSERT INTO `book` VALUES ('3', 'Java编程思想', '320.00', '55', '埃克尔，译者是陈昊鹏', '机械工业出版社', '886', 'cover/javabiancheng.jpg', '本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性', '3');
INSERT INTO `book` VALUES ('4', 'Java入门到精通', '262.00', '45', '国家863中部软件孵化器 ', '人民邮电出版社', '366', 'cover/javarumen.jpg', '以零基础讲解为宗旨，深入浅出地讲解Java的各项技术及实战技能。本书从初学者角度出发，通过通俗易懂的语言、丰富多彩的实例，详细介绍了使用Java语言进行程序开发应该掌握的各方面技术。', '3');
INSERT INTO `book` VALUES ('5', '未来简史', '138.00', '88', '(法)雅克·阿塔利所著', '上海社会科学院出版社', '564', 'cover/weilaijianshi.jpg', '该书内容包括：悠长的过往；资本主义简史；美帝国的终结；未来第一次浪潮：超级帝国；未来第二次浪潮：超级冲突等。', '4');
INSERT INTO `book` VALUES ('6', '白夜行', '213.00', '75', '（日）东野圭吾著', '日本出版社', '664', 'cover/baiyexing.jpg', '。故事围绕着一对有着不同寻常情愫的小学生展开。1973年，大阪的一栋废弃建筑内发现了一具男尸，此后19年，嫌疑人之女雪穗与被害者之子桐原亮司走上截然不同的人生道路，一个跻身上流社会，一个却在底层游走，而他们身边的人，却接二连三地离奇死去，警察经过19年的艰苦追踪，终于使真相大白。', '2');

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('1', '儿童文学');
INSERT INTO `booktype` VALUES ('2', '都市文学');
INSERT INTO `booktype` VALUES ('3', 'java学习');
INSERT INTO `booktype` VALUES ('4', '科幻世界');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_Id` int(11) DEFAULT NULL,
  `book_sum` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('10', '4', '2', '1');
INSERT INTO `cart` VALUES ('14', '2', '2', '1');
INSERT INTO `cart` VALUES ('16', '1', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_pass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_add` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'tom', '123', '山西省临汾市');
INSERT INTO `user` VALUES ('2', 'cat', '123', '山东省潍坊市');
INSERT INTO `user` VALUES ('3', '张三', '123', '地球上');
INSERT INTO `user` VALUES ('4', '李四', '123', '地球上中国');
INSERT INTO `user` VALUES ('5', 'user', '123', '哈尔滨');
