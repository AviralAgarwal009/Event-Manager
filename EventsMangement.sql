                                                   -- Uncomment These Lines for creating user
                                                   -- if you are running this script for the first time 
                                                   
CREATE USER if not exists 'event_data'@'localhost' IDENTIFIED BY 'event_data';
GRANT ALL PRIVILEGES ON * . * TO 'event_data'@'localhost';
ALTER USER 'event_data'@'localhost' IDENTIFIED WITH mysql_native_password BY 'data_info_event';

DROP DATABASE IF EXISTS `event_info`;
CREATE DATABASE `event_info`;
USE `event_info`;

 DROP TABLE IF EXISTS `participants`;
 CREATE TABLE `participants` (
  `reg_id` int(12) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(60) NOT NULL,
  `mobile_number`int(10) NOT NULL,
  `email_id`varchar(60) NOT NULL,
  `id_card`blob NOT NULL,
  `reg_type`varchar(10) NOT NULL,
  `tickets_qty`int(3) NOT NULL,
  `date_time`datetime NOT NULL,
  PRIMARY KEY (`reg_id`)
);

