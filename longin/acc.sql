

    private int id;//����
	private String username;//�˺���
	private String password;//����
	private String ip;//�ͻ���Ip
	private long date;//�����¼ʱ��
	
	
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
	
	
