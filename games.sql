/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.17-log : Database - games
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`games` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `games`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proimg` varchar(255) DEFAULT NULL,
  `profullname` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `users` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `users` (`users`),
  KEY `product` (`product`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`users`) REFERENCES `user` (`id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

insert  into `cart`(`id`,`proimg`,`profullname`,`price`,`num`,`users`,`product`) values (5,'hy2.jpg','R星GTA5后2大团队合力打造-2018最受期待游戏之一',560,1,5,16),(6,'shwj6.jpg','生化危机第6部(部分平台)',300,1,5,12),(8,'mgmr.jpg','美国末日PS3独占2016年-IGN满分神作(PS独占)',400,1,4,10),(9,'lzcyz.jpg','龙珠超宇宙PS独占2017',300,1,4,8);

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `users` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `users` (`users`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`users`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`id`,`users`,`sn`,`totalPrice`,`createdate`,`status`) values (1,4,'201910251557',4060,'2019-10-25 16:52:22',100),(2,4,'201910251557',2160,'2019-10-28 10:35:31',100),(3,4,'201910251557',3900,'2020-09-27 09:05:22',100);

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orders` (`orders`),
  KEY `product` (`product`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`orders`) REFERENCES `order` (`id`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

insert  into `orderitem`(`id`,`orders`,`product`,`num`,`price`) values (1,1,10,8,400),(2,1,12,1,300),(3,1,16,1,560),(4,2,14,2,280),(5,2,10,4,400),(6,3,8,13,300);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proname` varchar(255) DEFAULT NULL,
  `prosn` varchar(255) DEFAULT NULL,
  `proprice` double DEFAULT NULL,
  `pronum` int(11) DEFAULT NULL,
  `proimg` varchar(255) DEFAULT NULL,
  `desc` text,
  `profullname` varchar(255) DEFAULT NULL,
  `unit` varchar(5) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`proname`,`prosn`,`proprice`,`pronum`,`proimg`,`desc`,`profullname`,`unit`,`createdate`,`status`) values (8,'龙珠超','P122',300,86,'lzcyz.jpg',NULL,'龙珠超宇宙PS独占2017','个','2018-05-22 10:04:30',100),(10,'美国末日','P123',400,87,'mgmr.jpg',NULL,'美国末日PS3独占2016年-IGN满分神作(PS独占)','个','2018-03-07 10:08:49',100),(11,'神秘海域3','P124',300,99,'sh3.jpg',NULL,'神秘海域第三部-德雷克的谎言(PS独占)','个','2017-11-15 10:08:54',100),(12,'生化危机6','P125',300,98,'shwj6.jpg',NULL,'生化危机第6部(部分平台)','个','2017-11-15 10:08:54',100),(13,'杀戮地带','P126',300,99,'sldd.jpg',NULL,'杀戮地带3(全平台)','个','2017-11-15 10:08:54',100),(14,'最终幻想','P127',280,97,'zzhx.jpg',NULL,'最终幻想14(全平台)','个','2017-11-15 10:08:54',100),(15,'战神4','P128',480,99,'zs4.jpg',NULL,'北欧篇章全新启程(战神4 无副标题)','个','2018-04-21 16:39:05',100),(16,'荒野大镖客2','P129',560,98,'hy2.jpg',NULL,'R星GTA5后2大团队合力打造-2018最受期待游戏之一','个','2018-10-18 16:44:16',100),(17,'蜘蛛侠','P130',470,99,'zzx.jpg',NULL,'漫威官方授权索尼独占大作','个','2018-09-27 16:46:52',100),(18,'神秘海域4','P131',300,99,'sh4_new.jpg',NULL,'神秘海域第四部盗贼末路','个','2016-02-26 16:47:59',100);

/*Table structure for table `proimg` */

DROP TABLE IF EXISTS `proimg`;

CREATE TABLE `proimg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgsrc` varchar(255) DEFAULT NULL,
  `proid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `proimg` */

insert  into `proimg`(`id`,`imgsrc`,`proid`) values (1,'1.jpg',15),(2,'2.jpg',15),(3,'3.jpg',15),(4,'4.jpg',15);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`loginname`,`pwd`,`username`,`phone`,`address`) values (4,'aaa','aaa','你妹','123456789','北京市'),(5,'bbb','bbb','hello','','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
