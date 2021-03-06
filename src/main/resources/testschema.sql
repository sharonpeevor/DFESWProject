DROP TABLE IF EXISTS `camper`;

CREATE TABLE `camper` (
		`id` BIGINT AUTO_INCREMENT,
		`last_name` VARCHAR(255) NOT NULL,
		`email` VARCHAR(255) UNIQUE NOT NULL,
		`unit` VARCHAR(255) NOT NULL,
		`arrival_date` VARCHAR(255) NOT NULL,
		`no_of_nights` INT NOT NULL,
		PRIMARY KEY(`id`)
);