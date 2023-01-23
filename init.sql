CREATE USER 'root'@'%' IDENTIFIED BY 'root';
CREATE DATABASE customerapi;
GRANT ALL PRIVILEGES ON customerapi.* TO 'root'@'%';