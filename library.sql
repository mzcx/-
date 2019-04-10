/*
Navicat MySQL Data Transfer

Source Server         : localhost_
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-04-10 16:27:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookinfo`;
CREATE TABLE `tb_bookinfo` (
  `ISBN` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '图书编号',
  `typeId` int(11) NOT NULL COMMENT '类别编号',
  `bookname` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '图书名称',
  `writer` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '作者',
  `translator` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '译者',
  `publisher` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '出版社',
  `date` datetime NOT NULL COMMENT '出版日期',
  `price` decimal(10,0) NOT NULL COMMENT '书籍价格',
  PRIMARY KEY (`ISBN`),
  KEY `tb_bookinfo_ibfk_1` (`typeId`),
  CONSTRAINT `tb_bookinfo_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `tb_booktype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_bookinfo
-- ----------------------------
INSERT INTO `tb_bookinfo` VALUES ('2345788000221', '2', '??', '???', '?', '?????', '2018-04-17 00:00:00', '67');
INSERT INTO `tb_bookinfo` VALUES ('4444643513333', '2', '????', '??', '??', '?????', '2018-04-10 00:00:00', '100');
INSERT INTO `tb_bookinfo` VALUES ('6666666666666', '2', '?', '??', '???', '?????', '2018-03-28 00:00:00', '54');
INSERT INTO `tb_bookinfo` VALUES ('6784232144462', '1', '???', '???', '??', '?????', '2018-04-03 00:00:00', '65');
INSERT INTO `tb_bookinfo` VALUES ('77777777777777777777777777777', '1', '被拒绝', 'Buick', ' 教', 'Vuitton', '2018-03-27 21:28:33', '76');
INSERT INTO `tb_bookinfo` VALUES ('7827493333333', '2', '????', '???', '?', '?????', '2018-03-28 00:00:00', '43');

-- ----------------------------
-- Table structure for tb_booktype
-- ----------------------------
DROP TABLE IF EXISTS `tb_booktype`;
CREATE TABLE `tb_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书类别编号',
  `typeName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '图书类别名称',
  `days` int(11) NOT NULL COMMENT '可借天数',
  `fk` float NOT NULL COMMENT '迟还一天的罚款数目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_booktype
-- ----------------------------
INSERT INTO `tb_booktype` VALUES ('1', '??', '4', '1');
INSERT INTO `tb_booktype` VALUES ('2', '外语', '4', '2');
INSERT INTO `tb_booktype` VALUES ('3', 'wer', '3', '3.4');

-- ----------------------------
-- Table structure for tb_borrow
-- ----------------------------
DROP TABLE IF EXISTS `tb_borrow`;
CREATE TABLE `tb_borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '借阅编号',
  `bookISBN` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '书籍编号',
  `opertorId` int(11) NOT NULL COMMENT '操作员编号',
  `readerISBN` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '读者编号',
  `isback` int(11) NOT NULL DEFAULT '1' COMMENT '是否归还',
  `borrowDate` datetime NOT NULL COMMENT '借书日期',
  `backDate` datetime NOT NULL COMMENT '应还日期',
  PRIMARY KEY (`id`),
  KEY `opertorId` (`opertorId`),
  KEY `bookISBN` (`bookISBN`),
  KEY `readerISBN` (`readerISBN`),
  CONSTRAINT `tb_borrow_ibfk_2` FOREIGN KEY (`opertorId`) REFERENCES `tb_operator` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_borrow_ibfk_3` FOREIGN KEY (`bookISBN`) REFERENCES `tb_order` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_borrow_ibfk_4` FOREIGN KEY (`readerISBN`) REFERENCES `tb_reader` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_borrow
-- ----------------------------
INSERT INTO `tb_borrow` VALUES ('1', '2345788000221', '12', '2222222222222', '1', '2018-05-27 08:07:09', '2018-05-27 08:07:09');

-- ----------------------------
-- Table structure for tb_operator
-- ----------------------------
DROP TABLE IF EXISTS `tb_operator`;
CREATE TABLE `tb_operator` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作员编号',
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `sex` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '性别',
  `age` int(11) NOT NULL COMMENT '年龄',
  `identityCard` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '证件号码',
  `workdate` datetime NOT NULL COMMENT '工作时间',
  `tel` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '电话号码',
  `admin` int(11) NOT NULL DEFAULT '1' COMMENT '是否为管理员',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_operator
-- ----------------------------
INSERT INTO `tb_operator` VALUES ('12', 'lxj', '2', '22', '123', '2018-03-23 00:00:00', '15650439190', '1', '1234');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `ISBN` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '书籍编号',
  `orderdate` datetime NOT NULL COMMENT '订购日期',
  `number` int(11) NOT NULL COMMENT '订购数量',
  `operator` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '操作员',
  `checkAndAccept` int(11) NOT NULL COMMENT '是否验收',
  `zk` float NOT NULL COMMENT '书籍折扣',
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('2345788000221', '2018-05-27 00:00:00', '32', 'lxj', '0', '0.1');
INSERT INTO `tb_order` VALUES ('4444643513333', '2018-05-27 00:00:00', '43', 'lxj', '0', '0.4');
INSERT INTO `tb_order` VALUES ('6784232144462', '2018-05-27 00:00:00', '21', 'lxj', '1', '0.1');
INSERT INTO `tb_order` VALUES ('7827493333333', '2018-05-27 00:00:00', '43', 'lxj', '1', '0.5');

-- ----------------------------
-- Table structure for tb_reader
-- ----------------------------
DROP TABLE IF EXISTS `tb_reader`;
CREATE TABLE `tb_reader` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '读者姓名',
  `sex` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '读者性别',
  `age` int(11) NOT NULL COMMENT '读者年龄',
  `identityCard` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '证件号码',
  `date` datetime NOT NULL COMMENT '会员证有效日期',
  `maxNum` int(11) NOT NULL COMMENT '最大借书量',
  `tel` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '电话号码',
  `keepMoney` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '押金',
  `zj` int(11) NOT NULL COMMENT '证件类型',
  `zy` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '职业',
  `ISBN` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '读者编号',
  `bztime` datetime NOT NULL COMMENT '办证日期',
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_reader
-- ----------------------------
INSERT INTO `tb_reader` VALUES ('???', '2', '20', '1111111111111', '2019-05-23 00:00:00', '16', '15650439190', '50.0', '2', '??', '1111111111111', '2018-05-23 00:00:00');
INSERT INTO `tb_reader` VALUES ('??', '1', '23', '2222222222222', '2019-05-23 00:00:00', '22', '22222222222', '34.0', '3', '??', '2222222222222', '2018-05-23 00:00:00');
INSERT INTO `tb_reader` VALUES ('lk', '女', '4', '1234567891234', '2018-05-23 17:52:16', '34', '11111111111', '50', '8', 'ff', '23', '2018-05-23 17:52:16');
INSERT INTO `tb_reader` VALUES ('lk', '女', '4', '1234567891234', '2018-05-23 17:51:38', '34', '11111111111', '50', '8', 'ff', 'ac', '2018-05-23 17:51:38');
