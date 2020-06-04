-- 本檔案必須用UTF-8編碼存檔
-- 請在SQLYog中執行本Script
-- 
-- 
-- 
-- 刪除資料庫jspdb，如果它已存在
DROP DATABASE IF EXISTS jspdb;
-- 
-- 建立資料庫
CREATE DATABASE IF NOT EXISTS jspdb CHARACTER SET UTF8 COLLATE utf8_unicode_ci ;
-- 
-- 挑選資料庫
USE  jspdb;
-- 建立 example 專案所需之表格
DROP TABLE IF EXISTS  MemberExample;
-- 
CREATE TABLE MemberExample 
  ( PK int auto_increment, 
	account varchar(32), 
	password varchar(32), 
	name varchar(32), 
	email varchar(64), 
	tel  varchar(15), 
	experience int, 
	primary key(PK)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci;
  
-- 建立 jspExercise 專案所需之表格
DROP TABLE IF EXISTS  Member42;

CREATE TABLE  Member42 (
  memberId   	  VARCHAR(32) PRIMARY KEY NOT NULL,
  PASSWORD   	  VARCHAR(32) NOT NULL,  
  NAME            VARCHAR(32) NOT NULL,
  address         VARCHAR(64),
  phone           VARCHAR(15),
  birthday        DATETIME,
  registerdate 	  DATETIME NOT NULL DEFAULT NOW(),
  picture         MEDIUMBLOB,
  weight          FLOAT  
) ENGINE=INNODB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci;

INSERT INTO Member42 (memberId, PASSWORD, NAME, address, phone, birthday,  registerdate, weight)
VALUES ('mickey', '123', '米小薯', '台中市文心南路三段５８巷２２０號', '04-67891234', '1975-02-17', NOW(), 60);
