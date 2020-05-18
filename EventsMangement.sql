                                                   -- Uncomment These Lines for creating user
                                                   -- if you are running this script for the first time 
                                                   
/*CREATE USER if not exists 'event_data'@'localhost' IDENTIFIED BY 'event_data';
GRANT ALL PRIVILEGES ON * . * TO 'event_data'@'localhost';
ALTER USER 'event_data'@'localhost' IDENTIFIED WITH mysql_native_password BY 'data_info_event';*/

DROP DATABASE IF EXISTS `event_info`;
CREATE DATABASE `event_info`;
USE `event_info`;

 DROP TABLE IF EXISTS `participants`;
 CREATE TABLE `participants` (
  `reg_id` int(12) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(60) NOT NULL,
  `mobile_number`long  NOT NULL,
  `email_id`varchar(60) NOT NULL,
  `id_card`blob(10000000) NOT NULL,
  `reg_type`varchar(10) NOT NULL,
  `tickets_qty`int(3) NOT NULL,
  `date_time`datetime NOT NULL,
  PRIMARY KEY (`reg_id`)
);

-- For Spring Security
-- Table structure for table `users`


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Dumping data for table `users`
-- Default password is : admin
INSERT INTO `users` 
VALUES 
('admin','{bcrypt}$2a$10$XsvZ5lOrIuQ0n4mc3NZ2v.nB6U66bczDjm4p9iOC5rKM57oTxdOSC',1);

-- Table structure for table `authorities`

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table `authorities`

INSERT INTO `authorities` 
VALUES 
('admin','ROLE_ADMIN');

SET GLOBAL max_allowed_packet = 1073741824;

