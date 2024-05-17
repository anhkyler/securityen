CREATE TABLE user (
    id int,
    username varchar(10),
    password varchar(255),
    roles_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (roles_id) REFERENCES roles(id)
);

CREATE TABLE roles (
    id int,
    name varchar(10),
    PRIMARY KEY (id)
);


CREATE TABLE user_roles (
	id int,
    user_id int,
    role_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id),
	FOREIGN KEY (role_id) REFERENCES roles(id)
);
