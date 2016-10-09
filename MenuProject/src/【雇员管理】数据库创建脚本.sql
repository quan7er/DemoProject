-- һ��ɾ�����ݿ�
DROP DATABASE IF EXISTS emdb ;
-- �����������ݿ�
CREATE DATABASE emdb CHARACTER SET UTF8 ;
-- ����ʹ�����ݿ�
USE emdb ;
-- �ġ��������ݱ�
-- 1���û����ݱ�
CREATE TABLE member (
	mid					VARCHAR(50),
	password			VARCHAR(32),
	name				VARCHAR(20),
	sflag				INT,
	CONSTRAINT pk_mid PRIMARY KEY (mid)
) type = innodb;
-- 2����ɫ���ݱ�
CREATE TABLE role (
	rid					INT 	AUTO_INCREMENT ,
	title				VARCHAR(50),
	flag				VARCHAR(50),
	CONSTRAINT pk_rid PRIMARY KEY (rid)
) type = innodb;
-- 3���û�-��ɫ��ϵ��
CREATE TABLE member_role (
	mid					VARCHAR(50),
	rid 				INT ,
	CONSTRAINT fk_mid1 FOREIGN KEY(mid) REFERENCES member(mid) ,
	CONSTRAINT fk_rid1 FOREIGN KEY(rid) REFERENCES role(rid)
) type = innodb;
-- 4��Ȩ�ޱ�
CREATE TABLE action (
	actid 				INT 	AUTO_INCREMENT ,
	title 				VARCHAR(50),
	flag 				VARCHAR(50),
	CONSTRAINT pk_actid PRIMARY KEY (actid) 
) type = innodb;
-- 5����ɫ-Ȩ�޹�ϵ��
CREATE TABLE role_action (
	rid 				INT,
	actid 				INT,
	CONSTRAINT fk_rid6 FOREIGN KEY(rid) REFERENCES role(rid) ,
	CONSTRAINT fk_actid6 FOREIGN KEY(actid) REFERENCES action(actid)
) type = innodb;

-- 6��ְλ�ȼ���
CREATE TABLE level (
	lid					INT 	AUTO_INCREMENT ,
	losal 				DOUBLE,
	hisal 				DOUBLE,
	title 				VARCHAR(50),
	flag 				VARCHAR(10),
	CONSTRAINT pk_lid PRIMARY KEY (lid)
) type = innodb;

-- 7�����ű�
CREATE TABLE dept (
	deptno 				INT 	AUTO_INCREMENT ,
	dname 				VARCHAR(50),
	maxnum 				INT,
	currnum				INT	DEFAULT 0,
	CONSTRAINT pk_deptno PRIMARY KEY (deptno) 
) type = innodb;

-- 8��������Ա��
CREATE TABLE emp (
	empno 				INT 	AUTO_INCREMENT ,
	deptno 				INT,
	mid 				VARCHAR(50),
	lid 				INT,
	ename 				VARCHAR(50),
	job 				VARCHAR(50),
	sal 				DOUBLE,
	comm 				DOUBLE,
	hiredate 			DATE,
	photo				VARCHAR(200) ,
	flag				INT ,
	CONSTRAINT pk_empno PRIMARY KEY (empno) ,
	CONSTRAINT fk_deptno3 FOREIGN KEY(deptno) REFERENCES dept(deptno) ,
	CONSTRAINT fk_lid3 FOREIGN KEY(lid) REFERENCES level(lid)
) type = innodb;
-- 9����Ա���ʱ仯��¼��
CREATE TABLE elog (
	elid				INT 	AUTO_INCREMENT ,
	empno				INT,
	deptno				INT,
	mid					VARCHAR(50),
	lid					INT,
	job					VARCHAR(50),
	sal					DOUBLE,
	comm				DOUBLE,	
	sflag				INT,
	flag				INT,
	note				TEXT,
	CONSTRAINT pk_elid PRIMARY KEY (elid) ,
	CONSTRAINT fk_empno5 FOREIGN KEY(empno) REFERENCES emp(empno) ON DELETE CASCADE ,
	CONSTRAINT fk_lid5 FOREIGN KEY(lid) REFERENCES level(lid) ,
	CONSTRAINT fk_deptno5 FOREIGN KEY(deptno) REFERENCES dept(deptno)
) type = innodb;
-- �塢��������
-- 1�����ӽ�ɫ��Ϣ
INSERT INTO role(title,flag) VALUES ('����Ա','member') ;
INSERT INTO role(title,flag) VALUES ('���Ź���','dept') ;
INSERT INTO role(title,flag) VALUES ('��Ա����','emp') ;
-- 2������Ȩ����Ϣ
INSERT INTO action(title,flag) VALUES ('���ӹ���Ա','member:add') ;
INSERT INTO action(title,flag) VALUES ('����Ա�б�','member:list') ;
INSERT INTO action(title,flag) VALUES ('��������','dept:add') ;
INSERT INTO action(title,flag) VALUES ('�����б�','dept:list') ;
INSERT INTO action(title,flag) VALUES ('���ű༭','dept:edit') ;
INSERT INTO action(title,flag) VALUES ('Ա����ְ','emp:add') ;
INSERT INTO action(title,flag) VALUES ('Ա���б�','emp:list') ;
INSERT INTO action(title,flag) VALUES ('Ա���༭','emp:edit') ;
INSERT INTO action(title,flag) VALUES ('Ա����ְ','emp:remove') ;
-- 3�����ӽ�ɫ��Ȩ�޹�ϵ
INSERT INTO role_action(rid,actid) VALUES (1,1) ;
INSERT INTO role_action(rid,actid) VALUES (1,2) ;
INSERT INTO role_action(rid,actid) VALUES (2,3) ;
INSERT INTO role_action(rid,actid) VALUES (2,4) ;
INSERT INTO role_action(rid,actid) VALUES (2,5) ;
INSERT INTO role_action(rid,actid) VALUES (3,6) ;
INSERT INTO role_action(rid,actid) VALUES (3,7) ;
INSERT INTO role_action(rid,actid) VALUES (3,8) ;
INSERT INTO role_action(rid,actid) VALUES (3,9) ;

-- 4�����ӹ���Ա��Ϣ
-- salt : mldnjava,Base64 : ��bWxkbmphdmE=������ʽ������password({salt})
-- admin / hello
INSERT INTO member(mid,password,name,sflag) VALUES ('admin','FC2E402CBCAA21F3A0F078D1F181D74D','����Ա',1) ;
-- mermard / hello
INSERT INTO member(mid,password,name,sflag) VALUES ('mermaid','3E585791E7C446317AF238314843DDEB','����',0) ;
-- mldn / java
INSERT INTO member(mid,password,name,sflag) VALUES ('mldn','08FD48BA8B67F026CE01E4DD15BF717A','��������',0) ;

-- 5������Ա���ɫȨ��
INSERT INTO member_role(mid,rid) VALUES ('admin',1) ;
INSERT INTO member_role(mid,rid) VALUES ('admin',2) ;
INSERT INTO member_role(mid,rid) VALUES ('mermaid',2) ;
INSERT INTO member_role(mid,rid) VALUES ('mermaid',2) ;
INSERT INTO member_role(mid,rid) VALUES ('mldn',3) ;
INSERT INTO member_role(mid,rid) VALUES ('mldn',3) ;
-- 6�����ű�����
INSERT INTO dept(dname,maxnum) VALUES ('����',3) ;
INSERT INTO dept(dname,maxnum) VALUES ('���۲�',20) ;
INSERT INTO dept(dname,maxnum) VALUES ('������',10) ;
INSERT INTO dept(dname,maxnum) VALUES ('��Ʒ��',3) ;
INSERT INTO dept(dname,maxnum) VALUES ('���ڲ�',2) ;

-- 7�����ʵȼ�������
INSERT INTO level(losal,hisal,title,flag) VALUES (1500.0,3000.0,'ʵϰ��','T1') ;
INSERT INTO level(losal,hisal,title,flag) VALUES (3001.0,5000.0,'��˾Ա��','T2') ;
INSERT INTO level(losal,hisal,title,flag) VALUES (5001.0,8000.0,'С���鳤','T3') ;
INSERT INTO level(losal,hisal,title,flag) VALUES (8001.0,12000.0,'���Ÿ�����','T4') ;
INSERT INTO level(losal,hisal,title,flag) VALUES (12001.0,18000.0,'���ž���','T5') ;
INSERT INTO level(losal,hisal,title,flag) VALUES (18001.0,25000.0,'�ܼ�','T6') ;
INSERT INTO level(losal,hisal,title,flag) VALUES (25001.0,35000.0,'���ܲ�','T7') ;
INSERT INTO level(losal,hisal,title,flag) VALUES (35001.0,99999.0,'�ܲ�','T8') ;
