CREATE TABLE Users (
  user_id bigint auto_increment primary key,
  email varchar(100) not null,
  password varchar(100) not null,
  created_at datetime DEFAULT CURRENT_TIMESTAMP,
  updated_at datetime DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Role (
  role_id int primary key,
  role_name varchar(100)
);

CREATE TABLE UsersRole (
  user_id bigint not null,
  role_id int not null,
  created_at datetime DEFAULT CURRENT_TIMESTAMP,
  foreign key (user_id) references Users(user_id),
  foreign key (role_id) references Role(role_id)
);

CREATE TABLE Profiles (
  user_id bigint primary key,
  name varchar(100),
  school varchar(100),
  company varchar(100),
  message text,
  created_at datetime DEFAULT CURRENT_TIMESTAMP,
  updated_at datetime DEFAULT CURRENT_TIMESTAMP,
  foreign key (user_id) references Users(user_id)
);

CREATE TABLE Fallows (
  fallow_id bigint auto_increment primary key,
  user_id bigint not null,
  fallowee_id bigint not null,
  created_at datetime DEFAULT CURRENT_TIMESTAMP,
  foreign key (user_id) references Users(user_id),
  foreign key (fallowee_id) references Users(user_id)
);

CREATE TABLE Articles (
  article_id varchar(100) primary key,
  user_id bigint not null,
  title varchar(100) not null,
  content text not null,
  views int default 0,
  likes int default 0,
  created_at datetime DEFAULT CURRENT_TIMESTAMP,
  updated_at datetime DEFAULT CURRENT_TIMESTAMP,
  foreign key (user_id) references Users(user_id)
);

CREATE TABLE Comments (
  comment_id varchar(100) primary key,
  parent_id varchar(100),
  user_id bigint not null,
  content text not null,
  likes int default 0,
  created_at datetime DEFAULT CURRENT_TIMESTAMP,
  updated_at datetime DEFAULT CURRENT_TIMESTAMP,
  foreign key (user_id) references Users(user_id)
);


