insert into app_user (user_id, username, password, role)
values (0, 'admin1', '$2a$10$FBJBMqWqoPXc2aEKeOZoaechKfjahVlrNi6wFQwoq1KhLnqxCzqy2', 'ROLE_ADMIN')
ON CONFLICT DO NOTHING;

insert into person (person_id, firstname, surname, email, user_id)
values (1, 'admin_fst', 'admin_sur', 'admin@mail.com', 0)
ON CONFLICT DO NOTHING;

insert into app_user (user_id, username, password, role)
values (20, 'user1', '$2a$10$FBJBMqWqoPXc2aEKeOZoaechKfjahVlrNi6wFQwoq1KhLnqxCzqy2', 'ROLE_USER')
ON CONFLICT DO NOTHING;

insert into person (person_id, firstname, surname, email, user_id)
values (21, 'user_fst', 'user_sur', 'admin@mail.com', 20)
ON CONFLICT DO NOTHING;


insert into course (course_id, host_id, course_name, course_summary, course_description,
                    max_participant_count)
values (3, 1, 'baking 1'
        , 'All types of food can be baked, but some require special care and protection from direct heat. Various techniques have been developed to provide this protection.'
        , 'Baking is a method of preparing food that uses dry heat, typically in an oven, but can also be done in hot ashes, or on hot stones. The most common baked item is bread but many other types of foods are baked. Heat is gradually transferred "from the surface of cakes, cookies, and breads to their center. As heat travels through, it transforms batters and doughs into baked goods and more with a firm dry crust and a softer center". Baking can be combined with grilling to produce a hybrid barbecue variant by using both methods simultaneously, or one after the other. Baking is related to barbecuing because the concept of the masonry oven is similar to that of a smoke pit. Because of historical social and familial roles, baking has traditionally been performed at home by women for day-to-day meals and by men in bakeries and restaurants for local consumption. When production was industrialized, baking was automated by machines in large factories. The art of baking remains a fundamental skill and is important for nutrition, as baked goods, especially breads, are a common and important food, both from an economic and cultural point of view. A person who prepares baked goods as a profession is called a baker. On a related note, a pastry chef is someone who is trained in the art of making pastries, desserts, bread and other baked goods.'
        , 4)
ON CONFLICT DO NOTHING;

insert into announcement(announcement_id, title, content, publishing_date, course_id)
values (30, 'announcement1', 'Please make sure to bring your own baking supplies. In the studio
we do not have enought supplies for everyone. If you do not own everything from the description
we can work things out, just write me a personal message.',
        '01-01-2021', 3)
ON CONFLICT DO NOTHING;
