

    private int id;//主键
	private String username;//账号名
	private String password;//密码
	private String ip;//客户端Ip
	private long date;//最近登录时间
	
	
	create database  bussiness;
	use bussiness;
	create table if not exists account(
	  id         int          primary key auto_increment,
	  username   varchar(20)   not null,
	  password   varchar(20)   not null,
	  ip         varchar(20)   not null,
	  logindate  bigint   
	);
	
	insert into account(username,password,ip,logindate) values("admin","admin","127.0.0.1",now());
	
	
