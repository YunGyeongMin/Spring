CREATE TABLE `user` (
	`no` INT NOT NULL AUTO_INCREMENT,
	`id` VARCHAR(30) NOT NULL,
	`pwd` VARCHAR(16) NOT NULL,
	`nm` VARCHAR(30) NULL,
	`delYn` VARCHAR(1) NULL DEFAULT 'N',
	PRIMARY KEY (`no`)
);

CREATE TABLE `notice` (
	`no` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(50) NOT NULL,
	`content` VARCHAR(255) NULL,
	`uNo` INT NOT NULL,
	`regDate` datetime NULL DEFAULT NOW(),
	`delYn` VARCHAR(1) NULL DEFAULT 'N',
	PRIMARY KEY (`no`),
	INDEX `FK_notice_user` (`uId`),
	CONSTRAINT `FK_notice_user` FOREIGN KEY (`uId`) REFERENCES `user` (`no`)
);

INSERT INTO `user` (`id`, `pwd`, `nm`) VALUES ('admin','1','관리자');
INSERT INTO `user` (`id`, `pwd`, `nm`) VALUES ('user','2','일반');

