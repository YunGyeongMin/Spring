CREATE TABLE `message` (
	`no` INT(11) NOT NULL AUTO_INCREMENT,
	`msg` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`no`)
);

INSERT INTO `message` (`msg`) VALUES (#{msg});

SELECT `no`, `msg` FROM `message` WHERE `msg` LIKE '%${keyword}%';

UPDATE `message` SET `msg` = #{msg} WHERE `no` = #{no};

DELETE FROM `message` WHERE `no` = #{no};