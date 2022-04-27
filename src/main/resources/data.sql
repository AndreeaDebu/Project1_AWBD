INSERT INTO db.users (username, password, enabled)
    values ('user','user', true);

INSERT INTO db.users (username, password, enabled)
        values ('admin','admin', true);

INSERT INTO db.authorities (username, authority)
        values ('user','ROLE_USER');

INSERT INTO db.authorities (username, authority)
        values ('admin','ROLE_ADMIN');

