insert into s_role (id, nama) values ('admin', 'Administrator');
insert into s_role (id, nama) values ('pengguna', 'Pengguna');

-- password : admin123
insert into pengguna (id, id_role, username, hashed_password, nama)
values ('adminuser', 'admin', 'admin', '$2a$13$i2JE6bqZ1YghFX2RZHUE0O0H4bYeiB.h4zsgiaJ8tg.ejHtdPJ5XW', 'Administrator');

-- password : user00
insert into pengguna (id, id_role, username, hashed_password, nama)
values ('u001', 'pengguna', 'user001', '$2a$13$UHzktQVUWnzI46FqJBMVgunMPKWaxsvuKdHw5LWWsczDCvf.CtoQu', 'User 001');

-- password : user00
insert into pengguna (id, id_role, username, hashed_password, nama)
values ('u002', 'pengguna', 'user002', '$2a$13$UHzktQVUWnzI46FqJBMVgunMPKWaxsvuKdHw5LWWsczDCvf.CtoQu', 'User 002');

-- password : user00
insert into pengguna (id, id_role, username, hashed_password, nama)
values ('u003', 'pengguna', 'user003', '$2a$13$UHzktQVUWnzI46FqJBMVgunMPKWaxsvuKdHw5LWWsczDCvf.CtoQu', 'User 003');