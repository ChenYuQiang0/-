/** �������ݿ� **/
IF EXISTS(SELECT * FROM sys.databases WHERE name = 'lookz')
BEGIN
	DROP DATABASE lookz;
END
ELSE
BEGIN
	CREATE DATABASE lookz
	ON PRIMARY 
	(
		NAME = 'lookz',
		FILENAME = 'D:\database\lookz.mdf',
		SIZE = 50MB,
		MAXSIZE = UNLIMITED,
		FILEGROWTH = 10%
	)
END
GO
                                                                 
/** ѡ�����ݿ� **/
USE lookz;
GO

--------------------------------------------------------------------------------------------------
/** �û��� **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'users')
BEGIN
	DROP TABLE users;
END
ELSE
BEGIN
	CREATE TABLE users
	(	
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,		--����
		name VARCHAR(50) UNIQUE NOT NULL,					--�˺�
		password VARCHAR(50) NOT NULL,						--����
		sex VARCHAR(32) NOT NULL,							--�Ա�
		email VARCHAR(32) NOT NULL,							--����
		money NUMERIC(13,2),								--���
		shoppingCar_id INT,									--���ﳵID 
		car_flag INT ,										--���ﳵ��ʶ
		u_flag INT											--�û�Ψһ״̬
	)
END


/** ��Ʒ�� **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'goods')
BEGIN
	DROP TABLE goods;
END
ELSE
BEGIN
	CREATE TABLE goods
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,		--����
		name VARCHAR(100) NOT NULL,							--��Ʒ��
		introduce VARCHAR(200),		                        --��Ʒ����
		type VARCHAR(32),									--��Ʒ����
		tasteType VARCHAR(32),								--ζ������
		healthType VARCHAR(32),								--��������
		manufacturer VARCHAR(32),							--���̣���ϵ
		price NUMERIC(9,2) NOT NULL,						--����
		imgUrl VARCHAR(50) NOT NULL,						--ͼƬ��ַ
		evaluate INT CHECK(evaluate >= 0) NOT NULL,			--������
		num INT NOT NULL,									--���
		dicount NUMERIC(3,2),								--�ۿ�
		score INT,											--����
		goods_flag INT										--��Ʒ��ʶ
	)
END


/** ���ﳵ **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'shoppingCar')
BEGIN
	DROP TABLE shoppingCar;
END
ELSE
BEGIN
	CREATE TABLE shoppingCar
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,		--����
		number INT DEFAULT(1) NOT NULL,						--��Ʒ����
		sum_price NUMERIC(9,2) NOT NULL,					--�ܼ�
		time DATETIME DEFAULT(GETDATE()) NOT NULL	,		--����ʱ��
		shoppingCar_flag INT								--���ﳵ��ʶ
	)
END


/** ���� **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'orders')
BEGIN
	DROP TABLE orders;
END
ELSE
BEGIN
	CREATE TABLE orders
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--����
		orderid NUMERIC(13) NOT NULL,					--������
		payWay VARCHAR(50) NOT NULL,					--֧����ʽ
		time DATETIME DEFAULT(GETDATE()) NOT NULL,		--����ʱ��
		orderState VARCHAR(32),							--����״̬
		order_flag INT									--������ʶ
	)
END



/** ������ �û������� **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'users_orders')
BEGIN
	DROP TABLE users_orders;
END
ELSE
BEGIN
	CREATE TABLE users_orders
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,
		users_id INT FOREIGN KEY REFERENCES users(id) on delete cascade,
		orders_id NUMERIC(13) 
	)
END


/** ������ ���ﳵ����Ʒ **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'shoppingCar_goods')
BEGIN
	DROP TABLE shoppingCar_goods;
END
ELSE
BEGIN
	CREATE TABLE shoppingCar_goods
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,
		shoppingCar_id INT FOREIGN KEY REFERENCES shoppingCar(id) on delete cascade,
		goods_id INT FOREIGN KEY REFERENCES goods(id) on delete cascade
	)
END


/** ������ ��������Ʒ **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'orders_goods')
BEGIN
	DROP TABLE orders_goods;
END
ELSE
BEGIN
	CREATE TABLE orders_goods
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,
		orders_id NUMERIC(13) ,
		goods_id INT FOREIGN KEY REFERENCES goods(id) on delete cascade,
		number INT NOT NULL 
	)
END


/** ��ϵ�����Ǳ� **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'contact')
BEGIN
	DROP TABLE contact;
END
ELSE
BEGIN
	CREATE TABLE contact
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--����
		name varchar(50) NOT NULL,								--����
		phone VARCHAR(50) CHECK(phone LIKE '1[3-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,	--�绰
		msg VARCHAR(500) NOT NULL,								--����
		[time] DATETIME DEFAULT(GETDATE()) NOT NULL,				--ʱ��
		contact_flag INT										--��ϵ��ʶ
	)
END


/** passwordProtect�ܱ��� **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'passwordProtect')
BEGIN
	DROP TABLE passwordProtect;
END
ELSE
BEGIN
	CREATE TABLE passwordProtect
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--����
		email VARCHAR(32) NOT NULL,								--����
		ppOne VARCHAR(32) NOT NULL,								--�ܱ�����һ
		ppTwo	VARCHAR(32) NOT NULL,							--�ܱ������
		ppThree	VARCHAR(32) NOT NULL,							--�ܱ�������
		pp_flag INT												--�ܱ���״̬
	)
END


/** comment�û����۱� **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'comment')
BEGIN
	DROP TABLE comment;
END
ELSE
BEGIN
	CREATE TABLE comment
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--����
		users_id INT NOT NULL,									--�û�ID
		users_name VARCHAR(32) NOT NULL,						--�û�����
		time DATETIME DEFAULT(GETDATE()) NOT NULL,				--ʱ��
		content VARCHAR(500) NOT NULL,							--��������
		aritisismType VARCHAR(32) ,								--���ۼ���
		deliveryType VARCHAR(32) ,								--��ݼ���
		serveType VARCHAR(32) ,									--���񼶱�
		comment_flag INT										--����״̬
	)
END


/** deliveryAddress�ջ���ַ�� **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'deliveryAddress')
BEGIN
	DROP TABLE deliveryAddress;
END
ELSE
BEGIN
	CREATE TABLE deliveryAddress
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--����
		users_id INT NOT NULL,									--������ַ���û�ID
		name VARCHAR(32) NOT NULL,								--�ջ�������
		phone VARCHAR(50) CHECK(phone LIKE '1[3-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,	--�绰
		postCode VARCHAR(32) ,									--�ʱ�
		province VARCHAR(32),									--ʡ
		city VARCHAR(32),										--��
		area VARCHAR(32),										--����
		address VARCHAR(32),									--��ϸ��ַ
		address_flag INT										--�ջ���״̬
	)
END


/**admin ����Ա�� 6��������Ա 7��ͨ����Ա **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'admins')
BEGIN
	DROP TABLE admins;
END 
ELSE
BEGIN
	CREATE TABLE admins
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--����
		name VARCHAR(32) NOT NULL,								--����Ա����
		password VARCHAR(32) NOT NULL,							--����
		admins_rank INT,										--����Ա�ȼ�
		admins_flag INT											--����Ա��״̬
	)
END


/**�ղر� **/
/**�Ƽ���**/
----------------------------------------------------------------------------------------------------------
select * from users;
select * from goods;
select * from shoppingCar;
select * from admins;

TRUNCATE TABLE goods;

select top(2) id from goods where type='����' order by id;
select top(2) * from goods where type='����' and id not in (select top(0) id from goods where type='����' order by id) order by id;
select top(2) * from goods where id not in (select top(0) id from goods order by id) order by id;

select e.imgUrl,a.name, b.orders_id,e.name,e.price,d.number,c.[time] from users a,users_orders b,orders c,orders_goods d, goods e where a.id=b.users_id and b.orders_id=c.id and c.id=d.orders_id and d.goods_id=e.id and a.name='һ����';
select e.imgUrl,a.name, b.orders_id,e.name,e.price,d.number,c.time from users a,users_orders b,orders c,orders_goods d, goods e where a.id=b.users_id and b.orders_id=c.orderid and c.orderid=d.orders_id and d.goods_id=e.id and a.name='һ����';