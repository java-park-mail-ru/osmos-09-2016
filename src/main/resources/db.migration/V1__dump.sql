CREATE TABLE Users (
  Users_id  int  not null auto_increment,
  Name varchar(255),
  Login varchar(255) not null,
  Email varchar(255) not null,
  Password varchar(255) not null,
  PRIMARY KEY(Users_id),
  UNIQUE (Login),
  UNIQUE (Email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Sessions(
  Session_id int not null,
  User_id int not null,
  PRIMARY KEY (Session_id),
  FOREIGN KEY (User_id) REFERENCES Users(User_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;