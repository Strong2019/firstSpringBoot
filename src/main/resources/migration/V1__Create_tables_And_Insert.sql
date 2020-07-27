
-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info (
    id int NOT NULL primary key,
    username varchar(32) DEFAULT NULL,
    password varchar(128) DEFAULT NULL,
    role varchar(32) DEFAULT NULL,
    describe varchar(32) DEFAULT NULL
);

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO user_info VALUES ('1', 'admin', '$2a$10$V5iwRgfXKN10XuAuR4lng.uFCQMFmsPu00wa7.YN.9JQJdGH9LAeW', 'ADMIN COMMON', 'Admin user，all powers');
INSERT INTO user_info VALUES ('2', 'user', '$2a$10$CU7Qh78LMsv5cjZ8dvaxC.47fjlWYIWldl2NKlf.ddIIFFSKd0vqu', 'COMMON', 'Common user, the power of visiting home page');
INSERT INTO user_info VALUES ('3', 'test', '$2a$10$9HDPxT93IDRw3WmNezFOzu9W/h0lBEDllTTDtSqMRf6RnB2TReXqW', 'COMMON', 'Common user, the power of visiting home page');
