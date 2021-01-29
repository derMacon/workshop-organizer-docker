insert into app_user (user_id, username, password, role)
values (0, 'user1', '$2a$10$FBJBMqWqoPXc2aEKeOZoaechKfjahVlrNi6wFQwoq1KhLnqxCzqy2', 'ROLE_USER')
ON CONFLICT DO NOTHING;

insert into person (person_id, firstname, surname, email, user_id)
values (1, 'admin_fst', 'admin_sur', 'admin@mail.com', 0)
ON CONFLICT DO NOTHING;
