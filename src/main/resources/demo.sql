DROP DATABASE IF EXISTS `db_tranmanagement`;
CREATE DATABASE `db_tranmanagement`;

USE `db_tranmanagement`;

#
# Table structure for table tb_criticism
#

CREATE TABLE `tb_criticism` (
  `criticismID` int(11) NOT NULL auto_increment,
  `criticismContent` text,
  `employeeID` int(11) default NULL,
  `criticismTime` datetime default NULL,
  `messageID` int(11) default NULL,
  PRIMARY KEY  (`criticismID`),
  KEY `employeeID` (`employeeID`),
  KEY `messageID` (`messageID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 ;
INSERT INTO `tb_criticism` VALUES (3,'Very Good£¡So stupid this job is£¡',3052,'2014-07-25 15:08:16',14);
INSERT INTO `tb_criticism` VALUES (4,'Test Criticism A',3052,'2014-07-26 20:52:46',14);
INSERT INTO `tb_criticism` VALUES (5,'Test Criticism B',3052,'2014-07-26 20:52:46',14);
INSERT INTO `tb_criticism` VALUES (6,'Never! Go back to work!',3052,'2014-07-26 20:52:46',19);

#
# Table structure for table tb_employee
#

CREATE TABLE `tb_employee` (
  `employeeID` int(11) NOT NULL default '0',
  `employeeName` varchar(20) default NULL,
  `employeeSex` bit(1) default NULL,
  `employeeBirth` date default NULL,
  `employeePhone` varchar(20) default NULL,
  `employeePlace` varchar(50) default NULL,
  `joinTime` date default NULL,
  `password` varchar(20) default NULL,
  `isLead` bit(1) default NULL,
  PRIMARY KEY  (`employeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='Employee List';
INSERT INTO `tb_employee` VALUES (3052,'DONG Chuan',b'1','1990-01-19','333333333','Paris','2014-07-30','123456',b'1');

#
# Table structure for table tb_message
#

CREATE TABLE `tb_message` (
  `messageID` int(11) NOT NULL auto_increment,
  `messageTitle` varchar(50) default NULL,
  `messageContent` text,
  `employeeID` int(11) default NULL,
  `publishTime` datetime default NULL,
  PRIMARY KEY  (`messageID`),
  KEY `employeeID` (`employeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=gb2312 COMMENT='Message List';
INSERT INTO `tb_message` VALUES (14,'Maintance Announce','',3052,'2014-07-25 14:18:59');
INSERT INTO `tb_message` VALUES (16,'Meeting Announce','',3052,'2014-07-25 14:27:54');
INSERT INTO `tb_message` VALUES (17,'Leader Announce','',3052,'2014-07-25 14:33:51');
INSERT INTO `tb_message` VALUES (18,'Meeting Cancel Announce','',3052,'2014-07-25 14:35:35');
INSERT INTO `tb_message` VALUES (19,'Request for a one-year holiday','',3052,'2014-07-25 14:37:02');
INSERT INTO `tb_message` VALUES (20,'Test the message£¡','',3052,'2014-07-26 20:53:57');
INSERT INTO `tb_message` VALUES (21,'Again Test the message£¡','',3052,'204-07-26 20:53:57');

#
# Table structure for table tb_reply
#

CREATE TABLE `tb_reply` (
  `replyID` int(11) NOT NULL auto_increment,
  `replyContent` text,
  `employeeID` int(11) default NULL,
  `replyTime` datetime default NULL,
  `messageID` int(11) default NULL,
  PRIMARY KEY  (`replyID`),
  KEY `employeeID` (`employeeID`),
  KEY `messageID` (`messageID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312 COMMENT='Reply List';
INSERT INTO `tb_reply` VALUES (9,'Test reply A',3052,'2014-07-25 15:03:23',14);
INSERT INTO `tb_reply` VALUES (10,'Test reply B ',3052,'2014-07-25 15:03:49',14);

#
#  Foreign keys for table tb_criticism
#

ALTER TABLE `tb_criticism`
ADD CONSTRAINT `tb_criticism_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `tb_employee` (`employeeID`),
  ADD CONSTRAINT `tb_criticism_ibfk_2` FOREIGN KEY (`messageID`) REFERENCES `tb_message` (`messageID`);

#
#  Foreign keys for table tb_message
#

ALTER TABLE `tb_message`
ADD CONSTRAINT `tb_message_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `tb_employee` (`employeeID`);

#
#  Foreign keys for table tb_reply
#

ALTER TABLE `tb_reply`
ADD CONSTRAINT `tb_reply_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `tb_employee` (`employeeID`),
  ADD CONSTRAINT `tb_reply_ibfk_2` FOREIGN KEY (`messageID`) REFERENCES `tb_message` (`messageID`);