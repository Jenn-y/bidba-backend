BEGIN;
insert into user_account(id, email, first_name, last_name, password, role, status, phone_num, date_of_birth, gender, created_at, updated_at, payment_details_id, shipping_details_id)
values('dee2b360-efee-48cf-bcd8-27bb38b32047', 'austin@gmail.com', 'Jane', 'Austin', crypt('123456', gen_salt('md5')), 'USER', 'ACTIVE', '555-555-555', current_timestamp, 'FEMALE', current_timestamp, current_timestamp, null, null);

insert into category(id, name, subcategory_of)
values('e8eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Paintings', null);

insert into category(id, name, subcategory_of)
values('e1eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Instruments', null);

insert into category(id, name, subcategory_of)
values('e2eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Furniture', null);

insert into category(id, name, subcategory_of)
values('e3eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Books', null);

insert into category(id, name, subcategory_of)
values('e4eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Collectibles', null);

insert into category(id, name, subcategory_of)
values('e5eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Clothes', null);

insert into category(id, name, subcategory_of)
values('e6eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Shoes', null);

insert into category(id, name, subcategory_of)
values('e7eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Jewelry', null);

insert into category(id, name, subcategory_of)
values('e9eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Appliances', null);

insert into item(id, name, color, description, size)
values('e8eebc89-9a0b-4ef9-ba6d-6bb9bd380a16', 'Mona Lisa', 'brown', 'Mona Lisa (also known as La Gioconda or La Joconde) is a 16th-century portrait painted in oil by Leonardo da Vinci during the Renaissance in Florence, Italy.', 20);

insert into item(id, name, color, description, size)
values('e8eebc89-8a0b-4ef9-ba6d-6bb9bd380a16', 'Electric Guitar', 'brown', 'ELECTRIC VINTAGE delivers the iconic sound of one of the most versatile electric guitars, captured from an original, late-50s model built in the USA. It combines a powerful, playable engine with an enormous library of strummed patterns, picked arpeggios, and riffs for practically unlimited creative combinations suited to everything from contemporary pop to rock, funk, dance, hip-hop, and film soundtracks.', 20);

insert into item(id, name, color, description, size)
values('e8eebc89-7a0b-4ef9-ba6d-6bb9bd380a16', 'Vintage Drums', 'brown', 'If drums talked, this one could tell you amazing stories. For more than 30 years it was the “house” drum at the legendary Columbia Records 30th Street Studio in New York City. When the studio closed its doors in 1982, the drum was headed for the dumpster. But one of the engineers, a drummer, asked if he could have it. The studio gave it to him and 38 years later its owner is now ready now find it a new home. It is now for sale on consignment through Vintage Drum Center.', 20);

insert into item(id, name, color, description, size)
values('e8eebc89-6a0b-4ef9-ba6d-6bb9bd380a16', 'Cigar-box Guitar', 'red', 'The cigar box guitar and amp hold a special place in our hearts here at Make:. A cigar box guitar graced the cover of Make: Volume 04 and became one of our early iconic projects. We later followed that up in Volume 09 with a cracker box amp based on the venerable 555 timer chip. Over the years, we have published a number of DIY instrument projects.', 20);

insert into item(id, name, color, description, size)
values('e8eebc89-5a0b-4ef9-ba6d-6bb9bd380a16', 'Ligne Roset Sofa', 'white', 'Detailed conditions: Restored - this vintage item is good condition because it has been refreshed through new upholstery and/ or refinishing. Dimensions sofa H 70cm, seat H 35 cm, D 102 cm , W 87 cm', 20);

insert into item(id, name, color, description, size)
values('e8eebc89-4a0b-4ef9-ba6d-6bb9bd380a16', 'Vintage Mirror', 'brown', 'It is amazing the difference a good decorative mirror can make to a room - not only can they really enhance the decor, but they can also make a space feel bigger and brighter.', 20);

insert into item(id, name, color, description, size)
values('e8eebc89-3a0b-4ef9-ba6d-6bb9bd380a16', 'Decoupaged Sideboard', 'brown', 'Solid wood sideboard made by renowned British maker Strongbow. This is a vintage reproduction piece based on the Georgian style. It is bow - fronted with beautiful curves and has reeded legs A really good size, features large drawers inside for handy storage the top one being a cutlery drawer with dividers; there is also cupboard space to store crockery, linen or anything else that needs a place to hide.', 20);

insert into item(id, name, color, description, size)
values('e8eebc89-2a0b-4ef9-ba6d-6bb9bd380a16', 'Teal Television', 'green', 'Mid Century Original Teal Television Tv Movie Prop Side Table Retro', 20);

insert into category(id, name, subcategory_of)
values('e8eebc99-9c0b-4ef8-ba6d-6bb9bd388a15', 'Acrylic', 'e8eebc89-9c0b-4ef8-ba6d-6bb9bd380a17');

insert into category(id, name, subcategory_of)
values('e8eeba99-9c0b-4ef8-ba6d-6bb9bd388a15', 'Guitare', 'e1eebc89-9c0b-4ef8-ba6d-6bb9bd380a17');

insert into category(id, name, subcategory_of)
values('e8eebb99-9c0b-4ef8-ba6d-6bb9bd388a15', 'Piano', 'e1eebc89-9c0b-4ef8-ba6d-6bb9bd380a17');

insert into category(id, name, subcategory_of)
values('e8eebd99-9c0b-4ef8-ba6d-6bb9bd388a15', 'Drums', 'e1eebc89-9c0b-4ef8-ba6d-6bb9bd380a17');

insert into auction(id, start_date, end_date, status, start_price, category_id, item_id, seller_id)
values('e8eebc89-9c0b-4ef8-ba6d-7bb9bd380a16', current_timestamp, current_date + interval '100 days', 'active', 200, 'e8eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'e8eebc89-9a0b-4ef9-ba6d-6bb9bd380a16', 'dee2b360-efee-48cf-bcd8-27bb38b32047');

insert into auction(id, start_date, end_date, status, start_price, category_id, item_id, seller_id)
values('e8eebc89-9c0b-4ef8-ba6d-7bb9bd380a17', current_timestamp, current_date + interval '100 days', 'active', 360, 'e8eeba99-9c0b-4ef8-ba6d-6bb9bd388a15', 'e8eebc89-8a0b-4ef9-ba6d-6bb9bd380a16', 'dee2b360-efee-48cf-bcd8-27bb38b32047');

insert into auction(id, start_date, end_date, status, start_price, category_id, item_id, seller_id)
values('e8eebc89-9c0b-4ef8-ba6d-7bb9bd380a18', current_timestamp, current_date + interval '100 days', 'active', 500, 'e8eebd99-9c0b-4ef8-ba6d-6bb9bd388a15', 'e8eebc89-7a0b-4ef9-ba6d-6bb9bd380a16', 'dee2b360-efee-48cf-bcd8-27bb38b32047');

insert into auction(id, start_date, end_date, status, start_price, category_id, item_id, seller_id)
values('e8eebc89-9c0b-4ef8-ba6d-7bb9bd380a19', current_timestamp, current_date + interval '50 days', 'active', 250, 'e8eeba99-9c0b-4ef8-ba6d-6bb9bd388a15', 'e8eebc89-6a0b-4ef9-ba6d-6bb9bd380a16', 'dee2b360-efee-48cf-bcd8-27bb38b32047');

insert into auction(id, start_date, end_date, status, start_price, category_id, item_id, seller_id)
values('e8eebc89-9c0b-4ef8-ba6d-7bb9bd380a10', current_timestamp, current_date + interval '50 days', 'active', 70, 'e2eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'e8eebc89-5a0b-4ef9-ba6d-6bb9bd380a16', 'dee2b360-efee-48cf-bcd8-27bb38b32047');

insert into auction(id, start_date, end_date, status, start_price, category_id, item_id, seller_id)
values('e8eebc89-9c0b-4ef8-ba6d-7bb9bd380a11', current_timestamp, current_date + interval '30 days', 'active', 50, 'e2eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'e8eebc89-4a0b-4ef9-ba6d-6bb9bd380a16', 'dee2b360-efee-48cf-bcd8-27bb38b32047');

insert into auction(id, start_date, end_date, status, start_price, category_id, item_id, seller_id)
values('e8eebc89-9c0b-4ef8-ba6d-7bb9bd380a12', current_timestamp, current_date + interval '30 days', 'active', 400, 'e2eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'e8eebc89-3a0b-4ef9-ba6d-6bb9bd380a16', 'dee2b360-efee-48cf-bcd8-27bb38b32047');

insert into auction(id, start_date, end_date, status, start_price, category_id, item_id, seller_id)
values('e8eebc89-9c0b-4ef8-ba6d-7bb9bd380a13', current_timestamp, current_date + interval '30 days', 'active', 120, 'e2eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'e8eebc89-2a0b-4ef9-ba6d-6bb9bd380a16', 'dee2b360-efee-48cf-bcd8-27bb38b32047');
COMMIT;
