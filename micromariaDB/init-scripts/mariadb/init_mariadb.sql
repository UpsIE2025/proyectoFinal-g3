-- Crear base de datos y tabla para MariaDB
CREATE DATABASE IF NOT EXISTS auto_db;

USE auto_db;

CREATE TABLE IF NOT EXISTS Auto (
    auto_id INT AUTO_INCREMENT PRIMARY KEY,
    auto_marca VARCHAR(100),
    auto_modelo VARCHAR(100),
    auto_anio VARCHAR(4)
    );

-- Habilitar el binlog para replicación
SET GLOBAL binlog_format = 'ROW';
SET GLOBAL server_id = 1;