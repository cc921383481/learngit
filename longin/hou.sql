create database business ;
use business;
-- 商品表
create table product(
   id          int          primary key  auto_increment,-- 商品编号，主键
   pname       varchar(20)  not null,
   cid         int  ,-- 外键，引用自cate表中的cid
   pno         varchar(30)  ,-- 货号
   pic         varchar(100),-- 商品图片
   price       double     , -- 商品价格
   online      int     ,   -- 1:上线  0:下线 
   pdetail     text       -- 商品详情
);

-- 类别表
 create table Cate(
  cid        int           primary key  auto_increment,
  cname      varchar(20)   not null,
  pid        int          
  
 );

-- 规格表
create table rule(

  id            int      primary key  auto_increment ,
  pid           int     ,-- 商品id，引用商品表中的id
  size          varchar(20)  -- 尺寸
);
 

-- 会员表
-- 买家帐号信息
 create table account_consumer(
    id         int       primary key auto_increment,
    loginname   varchar(50)  not null,
    password   varchar(50) ,
    registertime   bigint    ,-- 注册时间
    lastlogintime   bigint,-- 最后登录时间
    ip          varchar(20)-- ip地址
 
 );
-- 买家购物信息
create table  shoppinginfo_consumer(
   id          int      primary key auto_increment,
   aid         int     ,-- 买家帐号id，依赖account_consumer表中的id
   nickname    varchar(20) ,-- 用户昵称
   money       double  ,-- 订单金额
   lasttime        bigint  -- 最近消费  
);
 
 


-- 卖家
  -- 卖家帐号信息
 create table account_product(
    id         int       primary key auto_increment,
    loginname   varchar(50)  not null,
    password   varchar(50) ,
    registertime   bigint    ,-- 注册时间
    lastlogintime   bigint,-- 最后登录时间
    ip          varchar(20)-- ip地址
 );
 
 
 

 
 -- 地址表,供客户选择
 create table  address(
   
    id         int           primary key  auto_increment,
    province   varchar(20)   not null ,-- 省份
    city       varchar(40)   not null ,-- 城市
    area        varchar(40)    not null-- 区/县
   );
 
 
-- 买家收货信息表
create table  consumer_addr(
  
   id       int          primary key  auto_increment,
   name     varchar(20) not null,-- 收货人姓名
   addr     varchar(200)  not null,-- 收货人地址
   phone    varchar(20)   not null ,-- 联系方式
   provice  varchar(20)   ,-- 省份
   city     varchar(20)   ,-- 市
   area     varchar(40)   ,-- 区/县
   adde     varchar(200)  -- 详细信息 
);
 
 -- 订单表
 create table  orderinfo(
   
  id          int        primary key  auto_increment, -- 订单id
  orderno     varchar(50)  not null,-- 订单编号
  orderstatus  int        ,-- 订单状态     1:未付款 2:已付款 3:已发货 4:已完成
  paystatus    int       ,-- 1:线上支付  2：货到付款
  ordertime    bigint    ,-- 下单时间
  paytime      bigint    ,-- 付款时间
  addrinfo     int       ,-- 收货人信息，引用自cosumer_addr表中的id
  mask         varchar(200) -- 备注信息
 );
 
-- 多对多关系  订单和商品
 create table  product_orderinfo(
   orderid     int     ,-- 订单id 值引用自orderinfo表中的id
   productid   int     ,-- 商品id,值引用自product表中的id
   primary key(orderid,productid) -- 联合主键
 );