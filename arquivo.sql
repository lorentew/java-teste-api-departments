
DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `id_board` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'São Paulo',1,'Comercial','Centro','SP'),(2,'São Paulo',1,'Departamento 2','Santo Amaro','SP'),(3,'Florianópolis',2,'Departamento 3','Florianópolis','SC'),(4,'Natal',3,'Suporte','Pedra Alta','RN');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

