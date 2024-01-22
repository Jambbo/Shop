INSERT INTO users(id, archive,email,name,password,role)
VALUES (1,false, 'mail@mail.ru', 'admin','$2a$10$SE5Egq/xzsseh0SqIHMWQ.XGODeRZXnkav3uzEEV1B7Pl3pQkFNzC','ADMIN');

ALTER SEQUENCE user_seq RESTART WITH 2;