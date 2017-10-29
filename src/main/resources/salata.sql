CREATE TABLE IF NOT EXISTS `course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `teacher` VARCHAR(45) NOT NULL,
  `hours` INT NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;
INSERT INTO `course` (`id`,`title`,`teacher`,`hours`) VALUES (NULL,'Courses1','Teacher1',10);
INSERT INTO `course` (`id`,`title`,`teacher`,`hours`) VALUES (NULL,'Courses2','Teacher2',20);
INSERT INTO `course` (`id`,`title`,`teacher`,`hours`) VALUES (NULL,'Courses3','Teacher3',30);
INSERT INTO `course` (`id`,`title`,`teacher`,`hours`) VALUES (NULL,'Courses4','Teacher4',40);
INSERT INTO `course` (`id`,`title`,`teacher`,`hours`) VALUES (NULL,'Courses5','Teacher5',50);