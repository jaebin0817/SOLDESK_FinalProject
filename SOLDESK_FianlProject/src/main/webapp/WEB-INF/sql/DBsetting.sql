-- DB생성
CREATE DATABASE soldesk_final;

-- 사용자 생성
CREATE USER 'sol01'@'localhost' IDENTIFIED BY '1234';

-- 사용자 권한 부여
GRANT ALL PRIVILEGES ON soldesk_final.* TO 'sol01'@'localhost';

-- 사용자 권한 확인하기
SHOW GRANTS FOR 'sol01'@'localhost';soldesk_final

-- DB 사용
USE soldesk_final;

COMMIT;

-- 테이블 생성 테스트
CREATE TABLE tb_bbs (
       bbsno        INT           NOT NULL AUTO_INCREMENT PRIMARY KEY
       ,wname       VARCHAR(20)   NOT NULL
       ,subject     VARCHAR(100)  NOT NULL
       ,content     TEXT          NOT NULL
       ,grpno       TINYINT       NOT NULL
       ,indent      TINYINT       DEFAULT 0    NOT NULL
       ,ansnum      TINYINT       DEFAULT 0    NOT NULL
       ,regdt       DATETIME      NOT NULL
       ,passwd      VARCHAR(15)   NOT NULL
       ,readcnt     INT           DEFAULT 0    NOT NULL
       ,ip          VARCHAR(15)   NOT NULL
  );

-- 행 추가 테스트
INSERT INTO tb_bbs(wname,subject,content,grpno,passwd,ip,regdt)
VALUES(12, 34, 56, (SELECT ifnull(max(bbsno),0)+1 FROM tb_bbs as TB),78,98,NOW());

SELECT * FROM tb_bbs;