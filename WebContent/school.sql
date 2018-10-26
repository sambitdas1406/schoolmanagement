/*
SQLyog - Free MySQL GUI v5.02
Host - 5.1.69-community : Database - school
*********************************************************************
Server version : 5.1.69-community
*/


create database if not exists `school`;

USE `school`;

/*Table structure for table `studentregd` */

DROP TABLE IF EXISTS `studentregd`;

CREATE TABLE `studentregd` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) DEFAULT NULL,
  `email` varchar(400) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `addressLine` varchar(400) DEFAULT NULL,
  `city` varchar(400) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `registereddate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `studentregd` */

insert into `studentregd` values 
(1,'sam','sam@gmail.com','123456','male',NULL,'bbsr','bbsr','odisha','India','8217394739','2018-10-26');
