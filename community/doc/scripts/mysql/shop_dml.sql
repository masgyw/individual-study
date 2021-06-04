use `mall_product`;

INSERT INTO product_category
(category_id, category_name, category_code, parent_id, category_level, category_status, modified_time)
VALUES(9, '手机', '1', 0, 1, 1, '2021-01-21 15:06:37.0');
INSERT INTO product_category
(category_id, category_name, category_code, parent_id, category_level, category_status, modified_time)
VALUES(11, '电视机', '3', 0, 1, 1, '2021-01-22 15:41:24.0');
INSERT INTO product_category
(category_id, category_name, category_code, parent_id, category_level, category_status, modified_time)
VALUES(12, '空调', '2', 0, 1, 1, '2021-01-22 16:50:40.0');
INSERT INTO product_category
(category_id, category_name, category_code, parent_id, category_level, category_status, modified_time)
VALUES(13, '洗衣机', '4', 0, 1, 1, '2021-01-22 16:50:56.0');
INSERT INTO product_category
(category_id, category_name, category_code, parent_id, category_level, category_status, modified_time)
VALUES(14, '保护套', '5', 0, 1, 1, '2021-01-22 16:51:08.0');
INSERT INTO product_category
(category_id, category_name, category_code, parent_id, category_level, category_status, modified_time)
VALUES(15, '保护膜', '6', 0, 1, 1, '2021-01-22 16:51:18.0');
INSERT INTO product_category
(category_id, category_name, category_code, parent_id, category_level, category_status, modified_time)
VALUES(16, '充电器', '7', 0, 1, 1, '2021-01-22 16:51:28.0');
INSERT INTO product_category
(category_id, category_name, category_code, parent_id, category_level, category_status, modified_time)
VALUES(17, '充电宝', '8', 0, 1, 1, '2021-01-22 16:51:45.0');

INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status, modified_time) VALUES(1, '1', '/cms_1.jpg', 1, 0, 1, '2021-06-04 15:12:03.0');
INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status, modified_time) VALUES(1, '2', '/cms_2.jpg', 1, 0, 1, '2021-06-04 15:12:52.0');
INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status, modified_time) VALUES(1, '3', '/cms_3.jpg', 1, 0, 1, '2021-06-04 15:12:52.0');
INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status, modified_time) VALUES(1, '4', '/cms_4.jpg', 1, 0, 1, '2021-06-04 15:12:52.0');

INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status) VALUES(322, 'Redmi-8.png', 'Redmi-8.png', 0, 0, 1);
INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status) VALUES(323, 'Redmi-k30', 'Redmi-k30.png', 0, 0, 1);
INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status) VALUES(324, 'Redmi-Note8', 'Redmi-Note8.png', 0, 0, 1);
INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status) VALUES(325, 'Redmi-7A', 'Redmi-7A.png', 0, 0, 1);
INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status) VALUES(326, 'Redmi-8A', 'Redmi-8A.png', 0, 0, 1);
INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status) VALUES(327, 'Redmi-k30-5G', 'Redmi-k30-5G.png', 0, 0, 1);
INSERT INTO product_pic_info (product_id, pic_desc, pic_url, is_master, pic_order, pic_status) VALUES(328, 'Redmi-Note8-pro', 'Redmi-Note8-pro.png', 0, 0, 1);
