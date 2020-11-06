CREATE TABLE `prod` (
  `prodname` mediumtext NOT NULL,
  `barcode` varchar(45) NOT NULL,
  `color` mediumtext,
  `description` longtext,
  PRIMARY KEY (`barcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
