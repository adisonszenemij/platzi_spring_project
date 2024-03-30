-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS `bd_platzi_spring_project`;

-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS `bd_platzi_spring_project` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;;

-- Eliminar la tabla si existe
DROP TABLE IF EXISTS `pc_client_phone`;
DROP TABLE IF EXISTS `pc_client_email`;
DROP TABLE IF EXISTS `pc_client_data`;