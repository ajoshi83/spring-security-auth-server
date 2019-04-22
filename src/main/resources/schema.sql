SET sql_mode = '';

create table if not exists  oauth_client_details (
  client_id varchar(255) not null PRIMARY KEY,
  client_secret varchar(255) not null,
  web_server_redirect_uri varchar(2048) default null,
  scope varchar(255) default null,
  access_token_validity int(11) default null,
  refresh_token_validity int(11) default null,
  resource_ids varchar(1024) default null,
  authorized_grant_types varchar(1024) default null,
  authorities varchar(1024) default null,
  additional_information varchar(4096) default null,
  autoapprove varchar(255) default null
) engine=innodb ;

create table if not exists  permission (
  id int(11) not null auto_increment PRIMARY KEY,
  name varchar(512) default null UNIQUE KEY
) engine=innodb ;

create table if not exists role (
  id int(11) not null auto_increment PRIMARY KEY,
  name varchar(255) default null UNIQUE KEY
) engine=innodb ;

create table if not exists  user (
  id int(11) not null auto_increment PRIMARY KEY,
  username varchar(100) not null UNIQUE KEY,
  password varchar(1024) not null,
  email varchar(1024) not null,
  enabled tinyint(4) not null,
  accountNonExpired tinyint(4) not null,
  credentialsNonExpired tinyint(4) not null,
  accountNonLocked tinyint(4) not null
) engine=innodb ;


create table if not exists user_role (
  user_id int(11) default null,
  role_id int(11) default null,
  key user_id (user_id),
  key role_id (role_id),
  constraint role_user_ibfk_2 foreign key (user_id) references user (id),
  constraint role_user_ibfk_1 foreign key (role_id) references role (id)
) engine=innodb ;


create table  if not exists role_permission (
  role_id int(11) default null,
  permission_id int(11) default null,
  key role_id (role_id),
  key permission_id (permission_id),
  constraint permission_role_ibfk_2 foreign key (role_id) references role (id),
  constraint permission_role_ibfk_1 foreign key (permission_id) references permission (id)
) engine=innodb ;


-- token store
create table if not exists oauth_client_token (
  token_id VARCHAR(256),
  token LONG VARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table if not exists oauth_access_token (
  token_id VARCHAR(256),
  token LONG VARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONG VARBINARY,
  refresh_token VARCHAR(256)
);

create table if not exists oauth_refresh_token (
  token_id VARCHAR(256),
  token LONG VARBINARY,
  authentication LONG VARBINARY
);

create table if not exists oauth_code (
  code VARCHAR(256), authentication LONG VARBINARY
);

create table if not exists oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);