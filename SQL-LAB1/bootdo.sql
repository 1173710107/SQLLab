/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.28 : Database - bootdo112
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bootdo112` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bootdo112`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '学生id',
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '学生名字',
  `sex` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '学生性别',
  `address` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '地址',
  `dept` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '系别',
  `age` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '年龄',
  `class` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`sex`,`address`,`dept`,`age`,`class`) values ('HIT_ST0000000001','张三','男','黑龙江省','计算机科学与技术','20','0000000'),('HIT_ST0000000002','李四','女','北京','软件工程','21','0000000'),('HIT_ST0000000003','王五','女','四川省','计算机科学与技术','20','1737101'),('HIT_ST1173710107','任永鹏','男','山西省','软件工程','21','1737102');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
