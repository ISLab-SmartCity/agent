CREATE USER 'islab'@'%' IDENTIFIED BY "islab";

GRANT ALL PRIVILEGES ON *.* TO 'islab'@'%';

FLUSH PRIVILEGES;