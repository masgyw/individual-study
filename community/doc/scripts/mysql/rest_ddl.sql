/*
Navicat MySQL Data Transfer

Source Server         : win7
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : rest_api

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2020-03-29
*/

CREATE DATABASE community_rest DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use community_rest;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rest_post`
-- ----------------------------
DROP TABLE IF EXISTS `rest_post`;
CREATE TABLE `rest_post` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子编号',
  `post_title` varchar(50) DEFAULT NULL COMMENT '帖子标题',
  `post_resume` varchar(1024) DEFAULT NULL COMMENT '帖子概要',
  `post_content` varchar(1024) DEFAULT NULL COMMENT '帖子内容',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_by_id` int(11) NOT NULL COMMENT '创建人编号',
  `deleted` int(1) DEFAULT 0 COMMENT '是否删除 0:否；1:是；',
  `reading` int(11) NOT NULL DEFAULT 0 COMMENT '访问量',
  `comments` int(11) NOT NULL DEFAULT 0 COMMENT '评论量',
  `likes` int(11) NOT NULL DEFAULT 0 COMMENT '点赞量',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `configuration`
-- ----------------------------
DROP TABLE IF EXISTS `configuration`;
CREATE TABLE `configuration` (
  `section` varchar(255) DEFAULT '' COMMENT '项',
  `parameter_key` varchar(255) DEFAULT '' COMMENT '键',
  `parameter_value` varchar(255) DEFAULT '' COMMENT '值',
  `init_value` varchar(255) DEFAULT '' COMMENT '初始值',
  PRIMARY KEY (`section`, `parameter_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `rest_comment`
-- ----------------------------
DROP TABLE IF EXISTS `rest_comment`;
CREATE TABLE `rest_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `content` text DEFAULT NULL COMMENT '评论内容',
  `like_num` int(11) COMMENT '点赞人数',
  `post_id` varchar(50) DEFAULT NULL COMMENT '帖子编号',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_by_id` int(11) NOT NULL COMMENT '创建人编号',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `rest_reply`
-- ----------------------------
DROP TABLE IF EXISTS `rest_reply`;
CREATE TABLE `rest_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复主键编号',
  `comment_id` int(11) NOT NULL COMMENT '父评论ID',
  `content` text DEFAULT NULL COMMENT '评论内容',
  `to_user_id` int(11) NOT NULL COMMENT '被评论者ID',
  `to_user_name` varchar(50) DEFAULT NULL COMMENT '被评论者名称',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_by_id` int(11) NOT NULL COMMENT '创建人编号',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;