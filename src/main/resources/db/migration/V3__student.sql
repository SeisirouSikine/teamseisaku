CREATE TABLE `student` (
	`id` SERIAL,
	`no` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`name` VARCHAR(10) DEFAULT NULL,
	`entyear` INT(10) DEFAULT NULL,
	`classnum` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
	`isattend` BOOLEAN DEFAULT NULL,
	`schoolcd` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
	PRIMARY KEY (`no`)
);