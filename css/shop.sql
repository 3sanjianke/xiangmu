/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.1.49-community : Database - shop1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shop1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shop1`;

/*Table structure for table `chuku` */

DROP TABLE IF EXISTS `chuku`;

CREATE TABLE `chuku` (
  `chuku_id` int(12) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(20) DEFAULT NULL,
  `shop_fenlei` varchar(20) DEFAULT NULL,
  `chuku_shuliang` int(20) DEFAULT NULL,
  `chuku_date` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`chuku_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `chuku` */

insert  into `chuku`(`chuku_id`,`shop_name`,`shop_fenlei`,`chuku_shuliang`,`chuku_date`) values (1,'片片虾','鱼类',10,'2018-11-17'),(2,'片片虾','鱼类',2,'2018-11-17'),(3,'片片虾','鱼类',1,'2018-11-19'),(4,'牛肉','肉类',10,'2018-11-20'),(5,'小龙虾','鱼类',5,'2018-11-21');

/*Table structure for table `fenlei` */

DROP TABLE IF EXISTS `fenlei`;

CREATE TABLE `fenlei` (
  `sort_id` int(12) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(20) DEFAULT NULL,
  `sort_describe` varchar(100) DEFAULT NULL,
  `sort_remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sort_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `fenlei` */

insert  into `fenlei`(`sort_id`,`sort_name`,`sort_describe`,`sort_remark`) values (1,'鱼类','好吃','今天捕上来的'),(2,'肉类','好吃','这个月新货'),(3,'辣条','好吃','这个月新货'),(4,'甜果','好吃','这个月新货'),(5,'牛奶','保质期一年','这个月新货'),(6,'水果类','好吃','这个月新货'),(7,'蔬菜类','好吃','这个月新货');

/*Table structure for table `kucun` */

DROP TABLE IF EXISTS `kucun`;

CREATE TABLE `kucun` (
  `kucun_id` int(12) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(20) DEFAULT NULL,
  `shop_fenlei` varchar(20) DEFAULT NULL,
  `shop_shuliang` int(12) DEFAULT NULL,
  PRIMARY KEY (`kucun_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `kucun` */

insert  into `kucun`(`kucun_id`,`shop_name`,`shop_fenlei`,`shop_shuliang`) values (1,'片片鱼','鱼类',12),(3,'牛肉','肉类',10),(4,'小龙虾','鱼类',5),(5,'鲜猪肉','肉类',0),(6,'鲤鱼','鱼类',10),(8,'小白菜','蔬菜类',20),(9,'小鱼仔','辣条',20),(10,'饼干','甜果',NULL),(11,'秋刀鱼','鱼类',10),(12,'红烧鱼','鱼类',NULL);

/*Table structure for table `ruku` */

DROP TABLE IF EXISTS `ruku`;

CREATE TABLE `ruku` (
  `ruku_id` int(12) NOT NULL,
  `shop_name` varchar(20) DEFAULT NULL,
  `shop_fenlei` varchar(20) DEFAULT NULL,
  `ruku_shuliang` int(20) DEFAULT NULL,
  `ruku_data` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ruku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ruku` */

insert  into `ruku`(`ruku_id`,`shop_name`,`shop_fenlei`,`ruku_shuliang`,`ruku_data`) values (1,'片片鱼','鱼类',10,'2018-11-19'),(2,'片片虾','鱼类',10,'2018-11-19'),(3,'香辣鱼','鱼类',10,'2018-11-19'),(4,'片片鱼','鱼类',10,'2018-11-19'),(5,'片片鱼','鱼类',11,'2018-11-19'),(6,'片片虾','鱼类',20,'2018-12-19'),(7,'牛肉','肉类',20,'2018-12-19'),(8,'小龙虾','鱼类',10,'2018-12-19'),(9,'鲤鱼','鱼类',10,'2018-12-21'),(10,'小鱼仔','辣条',20,'2018-11-21'),(11,'小白菜','蔬菜类',20,'2018-11-21'),(12,'秋刀鱼','鱼类',10,'2018-11-25');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'admin','admin');

/*Table structure for table `yujin` */

DROP TABLE IF EXISTS `yujin`;

CREATE TABLE `yujin` (
  `yujin_id` int(12) NOT NULL,
  `shop_name` varchar(20) DEFAULT NULL,
  `shop_fenlei` varchar(20) DEFAULT NULL,
  `beizhu` varchar(100) DEFAULT NULL,
  `yujing_shuliang` int(12) DEFAULT NULL,
  PRIMARY KEY (`yujin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `yujin` */

insert  into `yujin`(`yujin_id`,`shop_name`,`shop_fenlei`,`beizhu`,`yujing_shuliang`) values (1,'片片鱼','鱼类','低于100进货',100),(2,'小白菜','蔬菜类','',100),(3,'鲤鱼','鱼类','',100);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
