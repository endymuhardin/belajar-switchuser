insert into s_role (id, nama) values ('admin', 'Administrator');
insert into s_role (id, nama) values ('pengguna', 'Pengguna');

insert into pengguna (id, id_role, username, hashed_password, nama)
values ('adminuser', 'admin', 'admin', 'adfadsf', 'Administrator');

insert into pengguna (id, id_role, username, hashed_password, nama)
values ('u001', 'pengguna', 'user001', 'adfadsf', 'User 001');

insert into pengguna (id, id_role, username, hashed_password, nama)
values ('u002', 'pengguna', 'user002', 'adfadsf', 'User 002');

insert into pengguna (id, id_role, username, hashed_password, nama)
values ('u003', 'pengguna', 'user003', 'adfadsf', 'User 003');