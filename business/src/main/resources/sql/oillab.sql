/*
 Navicat Premium Data Transfer

 Source Server         : local_MySQL_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : oillab

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/07/2020 21:04:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'cid',
  `mid` int(11) NOT NULL COMMENT '模块id',
  `uid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布文章管理员id',
  `views` int(11) NOT NULL DEFAULT 0 COMMENT '浏览人数',
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '标题',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章类型',
  `author` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文章作者',
  `description` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '概要',
  `coverImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '引导（封面）图片',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容（富文本）',
  `addTime` datetime(0) NOT NULL COMMENT '文章入库时间',
  `pubTime` datetime(0) NOT NULL COMMENT '发布时间（自定义）',
  `lastEditTime` datetime(0) NOT NULL COMMENT '最后编辑时间',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态：禁用：-1；测试：0；启用：1；',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 667 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 1, '1', 99, '《中国高等教育》：（夏文斌）制度建设和国家治理的典范', '1', '夏文斌', '这是一段概要', '/static/img/test.jpg', '		<div class=\"article-text\">\r\n			<div id=\"vsb_content\"><style>@font-face{ font-family:\"Times New Roman\";} @font-face{ font-family:\"宋体\";} @font-face{ font-family:\"Wingdings\";} @font-face{ font-family:\"Calibri\";} @font-face{ font-family:\"黑体\";} @font-face{ font-family:\"楷体\";} p.MsoNormal{ mso-style-name:正文; mso-style-parent:\"\"; margin:0pt; margin-bottom:.0001pt; mso-pagination:none; text-align:justify; text-justify:inter-ideograph; font-family:Calibri; mso-fareast-font-family:宋体; mso-bidi-font-family:\'Times New Roman\'; font-size:10.5000pt; mso-font-kerning:1.0000pt;} h1{ mso-style-name:\"标题 1\"; mso-style-next:正文; margin-top:5.0000pt; margin-bottom:5.0000pt; mso-margin-top-alt:auto; mso-margin-bottom-alt:auto; mso-pagination:none; text-align:left; font-family:宋体; font-weight:bold; font-size:24.0000pt; mso-font-kerning:22.0000pt;} h2{ mso-style-name:\"标题 2\"; mso-style-noshow:yes; mso-style-next:正文; margin-top:5.0000pt; margin-bottom:5.0000pt; mso-margin-top-alt:auto; mso-margin-bottom-alt:auto; mso-pagination:none; text-align:left; font-family:宋体; font-weight:bold; font-size:18.0000pt;} h3{ mso-style-name:\"标题 3\"; mso-style-noshow:yes; mso-style-next:正文; margin-top:5.0000pt; margin-bottom:5.0000pt; mso-margin-top-alt:auto; mso-margin-bottom-alt:auto; mso-pagination:none; text-align:left; font-family:宋体; font-weight:bold; font-size:13.5000pt;} span.10{ font-family:\'Times New Roman\';} span.15{ font-family:\'Times New Roman\'; color:rgb(85,126,231);} span.16{ font-family:\'Times New Roman\'; color:rgb(128,0,128);} span.17{ font-family:\'Times New Roman\'; font-weight:bold;} span.18{ font-family:\'Times New Roman\'; font-style:italic;} span.19{ font-family:\'Times New Roman\'; color:rgb(0,0,255); text-decoration:underline; text-underline:single;} p.20{ mso-style-name:shouhang; margin:0pt; margin-bottom:.0001pt; text-indent:21.0000pt; mso-pagination:none; text-align:left; line-height:15.0000pt; font-family:Calibri; mso-fareast-font-family:宋体; mso-bidi-font-family:\'Times New Roman\'; font-size:10.5000pt;} p.p{ mso-style-name:\"普通\\(网站\\)\"; margin-top:5.0000pt; margin-right:0.0000pt; margin-bottom:5.0000pt; margin-left:0.0000pt; mso-margin-top-alt:auto; mso-margin-bottom-alt:auto; mso-pagination:none; text-align:left; font-family:Calibri; mso-fareast-font-family:宋体; mso-bidi-font-family:\'Times New Roman\'; font-size:12.0000pt;} span.msoIns{ mso-style-type:export-only; mso-style-name:\"\"; text-decoration:underline; text-underline:single; color:blue;} span.msoDel{ mso-style-type:export-only; mso-style-name:\"\"; text-decoration:line-through; color:red;} table.MsoNormalTable{ mso-style-name:普通表格; mso-style-parent:\"\"; mso-style-noshow:yes; mso-tstyle-rowband-size:0; mso-tstyle-colband-size:0; mso-padding-alt:0.0000pt 5.4000pt 0.0000pt 5.4000pt; mso-para-margin:0pt; mso-para-margin-bottom:.0001pt; mso-pagination:widow-orphan; font-family:\'Times New Roman\'; font-size:10.0000pt; mso-ansi-language:#0400; mso-fareast-language:#0400; mso-bidi-language:#0400;} @page{mso-page-border-surround-header:no; mso-page-border-surround-footer:no;}@page Section0{ margin-top:72.0000pt; margin-bottom:72.0000pt; margin-left:90.0000pt; margin-right:90.0000pt; size:595.3000pt 841.9000pt; vsb_temp:15.6000pt;} div.Section0{page:Section0;}</style>\r\n<p style=\"padding: 0pt; text-align: center; line-height: 2em; text-indent: 30.1pt; margin-top: 0pt; margin-bottom: 0pt; text-autospace: ideograph-numeric; word-break: break-all; mso-char-indent-count: 2.0000; mso-vsb_temp-align: none; vsb_temp-mode: char; mso-pagination: widow-orphan;\"><strong><span style=\"color: rgb(0, 0, 0); line-height: 200%; font-family: 黑体; font-size: 15pt; font-weight: bold; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"><span style=\"font-family: 黑体;\">制度建设和国家治理的典范</span></span></strong></p>\r\n<p style=\"padding: 0pt; text-align: center; line-height: 2em; text-indent: 24pt; margin-top: 0pt; margin-bottom: 0pt; text-autospace: ideograph-numeric; word-break: break-all; mso-char-indent-count: 2.0000; mso-vsb_temp-align: none; vsb_temp-mode: char; mso-pagination: widow-orphan;\"><span style=\"color: rgb(0, 0, 0); font-family: 楷体; font-size: 12pt; font-weight: normal; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"><span style=\"font-family: 楷体;\">（来源：《中国高等教育》</span> 2019年12月12日）</span></p>\r\n<p style=\"padding: 0pt; text-align: center; line-height: 2em; text-indent: 24pt; margin-top: 0pt; margin-bottom: 0pt; text-autospace: ideograph-numeric; word-break: break-all; mso-char-indent-count: 2.0000; mso-vsb_temp-align: none; vsb_temp-mode: char; mso-pagination: widow-orphan;\"><span style=\"font-family: 楷体,楷体_GB2312, SimKai; font-size: 16px;\"><span style=\"color: rgb(0, 0, 0); font-size: 16px; font-weight: normal; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"></span>&nbsp;夏文斌</span></p>\r\n<p style=\"margin: 0pt; padding: 0pt; text-align: justify; line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; text-justify: inter-ideograph; mso-char-indent-count: 2.0000; mso-pagination: widow-orphan; mso-para-margin-left: 0.0000gd;\"><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"><span style=\"font-family: 宋体;\">党的十九届四中全会审议通过了《中共中央关于坚持和完善中国特色社会主义制度</span> &nbsp;<span style=\"font-family: 宋体;\">推进国家治理体系和治理能力现代化若干重大问题的决定》。全会提出，中国特色社会主义制度是党和人民在长期实践探索中形成的科学制度体系，我国国家治理一切工作和活动都依照中国特色社会主义制度展开，我国国家治理体系和治理能力是中国特色社会主义制度及其执行能力的集中体现。这次全会所取得的系列成果，堪称制度建设和国家治理的典范。</span></span></p>\r\n<p style=\"margin: 0pt; padding: 0pt; text-align: justify; line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; text-justify: inter-ideograph; mso-char-indent-count: 2.0000; mso-pagination: widow-orphan; mso-para-margin-left: 0.0000gd;\"><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"><span style=\"font-family: 宋体;\">制度是一切行为的规范。中国革命、建设、改革所取得的一切成就，得益于我们以马克思列宁主义、毛泽东思想、邓小平理论、</span>“三个代表”重要思想、科学发展观、习近平新时代中国特色社会主义思想为指导，形成了各种制度体系，并在实践中不断完善。特别是改革开放以来，又面临新的国际国内形势，我们党在总结我国改革开放和社会主义现代化实践进程中，形成了比较完整的适合中国国情的科学制度体系。进入新时代，面对世界百年未有之大变局，面对新时代社会主要矛盾的变化，以习近平同志为核心的党中央对实现“两个一百年”奋斗目标作出了全面部署。如何实现这一伟大目标，还有许多艰巨的任务在等待着我们，其中最为重要的就是坚持和完善中国特色社会主义制度，突出坚持和完善支撑中国特色社会主义制度的根本制度、基本制度、重要制度。这是中国的核心竞争力之所在，是中国面向未来破解一切难题的关键之所在，是实现中华民族伟大复兴的制度保障之所在。</span></p>\r\n<p style=\"margin: 0pt; padding: 0pt; text-align: justify; line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; text-justify: inter-ideograph; mso-char-indent-count: 2.0000; mso-pagination: widow-orphan; mso-para-margin-left: 0.0000gd;\"><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"> </span></p>\r\n<p style=\"margin: 0pt; padding: 0pt; text-align: justify; line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; text-justify: inter-ideograph; mso-char-indent-count: 2.0000; mso-pagination: widow-orphan; mso-para-margin-left: 0.0000gd;\"><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"><span style=\"font-family: 宋体;\">制度体系和治理效能是相辅相成的。没有科学系统完备的制度体系，国家的各类治理就可能会停留在经验层面；而如果我们的制度体系不用于提升治理效能，制度体系的科学性就难以真正实现。党的十九届四中全会正是从这两者的辩证关系上破题的。一方面提出，着力固根基、扬优势、补短板、强弱项，构建系统完备、科学规范、运行有效的制度体系。另一方面，要加强系统治理、依法治理、综合治理、源头治理，把我国制度优势更好转化为国家治理效能。进入新时代的中国，我们在看到中国特色社会主义取得了新的巨大成就的同时，还面临着许多新的挑战和问题。这就需要我们以问题为导向，关注中国改革开放和社会主义现代化的重大实践问题，关注广大人民群众的生产生活等民生问题，不断提升国家治理体系和治理能力现代化的水平。</span></span></p>\r\n<p style=\"margin: 0pt; padding: 0pt; text-align: justify; line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; text-justify: inter-ideograph; mso-char-indent-count: 2.0000; mso-pagination: widow-orphan; mso-para-margin-left: 0.0000gd;\"><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"><span style=\"font-family: 宋体;\">充分发挥党的领导制度体系的引领作用。坚持和完善中国特色社会主义制度和治理体系，是一个系统工程，涉及政治、经济、文化、社会、生态、国防军队、外交等方方面面，如何将这一系列制度体系引领好、统筹好，关键还在于坚持和完善好党的领导制度体系。历史和现实都充分证明，没有共产党就没有新中国，就没有中国改革和社会主义现代化建设的伟业。进入新时代，以习近平同志为核心的党中央高瞻远瞩，在不断坚持和完善中国特色社会主义制度，推进国家治理体系和治理能力现代化方面又取得新成就。面向未来，我们要将制度建设和国家治理这一伟大的系统工程持续推进，首先和关键就是要坚持和完善党的领导制度体系。要建立不忘初心、牢记使命的制度，完善坚定维护党中央权威和集中统一领导的各项制度，健全党的全面领导制度，健全为人民执政、靠人民执政各项制度，健全提高党的执政能力和领导水平制度，完善全面从严治党制度。</span></span></p>\r\n<p style=\"margin: 0pt; padding: 0pt; text-align: justify; line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; text-justify: inter-ideograph; mso-char-indent-count: 2.0000; mso-pagination: widow-orphan; mso-para-margin-left: 0.0000gd;\"><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"> </span></p>\r\n<p style=\"margin: 0pt; padding: 0pt; text-align: right; line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; mso-char-indent-count: 2.0000; mso-pagination: widow-orphan; mso-para-margin-left: 0.0000gd;\"><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"><span style=\"font-family: 宋体;\">【作者夏文斌：对外经济贸易大学校长】</span></span></p>\r\n<p style=\"margin: 0pt; padding: 0pt; text-align: right; line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; mso-char-indent-count: 2.0000; mso-pagination: widow-orphan; mso-para-margin-left: 0.0000gd;\"><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"> <span style=\"font-family: 宋体;\">原载</span>2019年第22期《中国高等教育》杂志</span></p>\r\n<p style=\"padding: 0pt; text-align: justify; line-height: 2em; text-indent: 24pt; margin-top: 0pt; margin-bottom: 0pt; margin-left: 0pt; text-autospace: ideograph-numeric; word-break: break-all; text-justify: inter-ideograph; mso-char-indent-count: 2.0000; mso-pagination: widow-orphan;\"><span style=\"color: rgb(34, 34, 34); text-transform: none; letter-spacing: 0pt; font-family: 宋体; font-size: 12pt; font-style: normal; font-weight: normal; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 0.0000pt;\"> </span></p>\r\n<p style=\"line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; mso-char-indent-count: 2.0000; mso-pagination: none;\"><span style=\"color: rgb(34, 34, 34); text-transform: none; line-height: 200%; letter-spacing: 0pt; font-family: 宋体; font-size: 12pt; font-style: normal; font-weight: normal; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 1.0000pt;\"><span style=\"font-family: 宋体;\">附：原文</span></span><span style=\"line-height: 200%; font-family: 宋体; font-size: 12pt; font-weight: normal; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 1.0000pt; mso-bidi-font-family: &quot;Times New Roman&quot;;\"><span style=\"font-family: 宋体;\">链接</span></span><span style=\"color: rgb(0, 0, 0); line-height: 200%; font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 1.0000pt;\"> &nbsp; &nbsp;</span></p>\r\n<p style=\"line-height: 2em; text-indent: 24pt; text-autospace: ideograph-numeric; mso-char-indent-count: 2.0000; mso-pagination: none;\"><a href=\"http://www.jyb.cn/rmtzcg/xwy/wzxw/201912/t20191213_281357.html\"><span style=\"text-decoration: underline;\"><span style=\"color: rgb(0, 0, 0); line-height: 200%; font-family: 宋体; font-size: 12pt; text-decoration: underline; mso-spacerun: &quot;yes&quot;; text-underline: single;\">http://www.jyb.cn/rmtzcg/xwy/wzxw/201912/t20191213_281357.html</span></span></a><span style=\"color: rgb(0, 0, 0); line-height: 200%; font-family: 宋体; font-size: 12pt; mso-spacerun: &quot;yes&quot;; mso-font-kerning: 1.0000pt;\"> </span></p></div>\r\n		</div>', '2019-09-08 00:00:00', '2019-09-09 00:00:00', '2019-09-08 00:00:00', 2);
INSERT INTO `article` VALUES (2, 2, '1', 99, '测试标题', '2', '菜鸡', '一个简介，其实……啥也没有。', '/static/img/test.jpg', '这是……很长很长很长很长的内容', '2019-09-08 00:00:00', '2019-09-09 00:00:00', '2019-09-08 00:00:00', 1);
INSERT INTO `article` VALUES (11, 6, '1', 99, 'test Title', '3', '菜鸡', '这是一段概要', '/static/img/test.jpg', '这是一篇很长很长的文章………………', '2019-09-08 00:00:00', '2019-09-08 00:00:00', '2019-09-08 00:00:00', 1);
INSERT INTO `article` VALUES (12, 5, '1', 99, 'test Title', '4', '菜鸡', '这是一段概要', '/static/img/test.jpg', '这是一篇很长很长的文章………………', '2019-09-08 00:00:00', '2019-09-08 00:00:00', '2019-09-08 00:00:00', 1);
INSERT INTO `article` VALUES (13, 2, '1', 99, 'test Title', '1', '菜鸡', '这是一段概要', '/static/img/test.jpg', '这是一篇很长很长的文章………………', '2019-09-08 00:00:00', '2019-09-08 00:00:00', '2019-09-08 00:00:00', 1);

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型描述',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_type
-- ----------------------------
INSERT INTO `article_type` VALUES (1, '新闻资讯', '新闻资讯的文章', 1);
INSERT INTO `article_type` VALUES (2, '产品介绍', '产品介绍的文章', 1);
INSERT INTO `article_type` VALUES (3, '普通文章', '普通的文章', 1);
INSERT INTO `article_type` VALUES (4, '公司简介', '公司简介的文章', 1);

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` tinyint(2) UNSIGNED NULL DEFAULT 0 COMMENT '类型:0:PC，1:H5，2:APP',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '轮播图名字: 区别不同的轮播图',
  `url` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '链接地址',
  `coverImg` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '封面图片',
  `description` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '图片描述',
  `remark` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注信息',
  `sort` int(1) NULL DEFAULT NULL COMMENT '排序',
  `interval` smallint(255) NULL DEFAULT NULL COMMENT '轮播图切换停留时间',
  `createTime` datetime(6) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(6) NOT NULL COMMENT '修改时间',
  `operatorId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人ID',
  `status` int(1) NOT NULL COMMENT '状态 0 禁用 1 正常 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '焦点图管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES (1, 0, 'index_carousel', '/', '/static/oillab/images/banner1.jpg', '首页xxx产品', '首页轮播图', 1, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 1);
INSERT INTO `carousel` VALUES (2, 0, 'index_carousel', '/', '/static/oillab/images/banner2.jpg', '首页xxx产品', '首页轮播图', 3, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 1);
INSERT INTO `carousel` VALUES (3, 0, 'index_carousel', '/', '/static/oillab/images/banner3.jpg', '首页xxx产品', '首页轮播图', 2, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 1);
INSERT INTO `carousel` VALUES (4, 0, 'index_carousel', '/', '/static/oillab/images/banner4.jpg', '首页xxx产品', '首页轮播图', 4, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 1);
INSERT INTO `carousel` VALUES (5, 0, 'index_carousel', '/', '/static/oillab/images/banner5.jpg', '首页xxx产品', '首页轮播图', 5, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 0);
INSERT INTO `carousel` VALUES (6, 0, 'product_carousel', '/', '/static/oillab/images/banner1.jpg', 'xxx产品', '首页轮播图', 4, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 1);
INSERT INTO `carousel` VALUES (7, 0, 'product_carousel', '/', '/static/oillab/images/banner2.jpg', 'xxx产品', '首页轮播图', 3, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 1);
INSERT INTO `carousel` VALUES (8, 0, 'product_carousel', '/', '/static/oillab/images/banner3.jpg', 'xxx产品', '首页轮播图', 2, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 1);
INSERT INTO `carousel` VALUES (9, 0, 'product_carousel', '/', '/static/oillab/images/banner4.jpg', 'xxx产品', '首页轮播图', 1, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 1);
INSERT INTO `carousel` VALUES (10, 0, 'product_carousel', '/', '/static/oillab/images/banner5.jpg', 'xxx产品', '首页轮播图', 5, NULL, '2020-07-22 14:35:43.000000', '2020-07-22 14:35:40.000000', '1', 0);

-- ----------------------------
-- Table structure for html_template
-- ----------------------------
DROP TABLE IF EXISTS `html_template`;
CREATE TABLE `html_template`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板名称',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板类型',
  `template` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `edit_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后变更时间',
  `status` int(255) NULL DEFAULT NULL COMMENT '状态：禁用：-1；测试：0；启用：1；',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of html_template
-- ----------------------------
INSERT INTO `html_template` VALUES (25, 'myBtnGroup', 'pageContent', '{{each $data temp index}}\r\n	{{if temp.show}}\r\n    	<a class=\"my-btn {{if index == 0}}selected{{/if}}\" href=\"#show-{{temp.name}}\">{{temp.title}}</a>\r\n    {{/if}}\r\n{{/each}}', '关于页面的菜单', '2020-07-17 20:50:34', '2020-07-17 20:50:38', 1);
INSERT INTO `html_template` VALUES (26, 'aboutContainer', 'pageContent', '{{each $data temp index}}\r\n	{{if temp.show}}\r\n	    <div id=\"show-{{temp.name}}\">\r\n	        <div class=\"about-title\">\r\n	            <span>{{temp.title}}</span><i></i><em>{{temp.englishTitle}}</em>\r\n	        </div>\r\n\r\n	        <div class=\"about-content about-{{temp.name}}\"></div>\r\n	    </div>\r\n    {{/if}}\r\n{{/each}}', '关于页面的详情内容', '2020-07-17 21:21:52', '2020-07-17 21:21:54', 1);
INSERT INTO `html_template` VALUES (27, 'index_showContainer', 'pageContent', '{{each $data temp index}}\r\n	<div id=\"show-{{temp.name}}\">\r\n		<div class=\"show-title\">\r\n			<h2>{{temp.title}}</h2><i>/</i><em>{{temp.englishTitle}}</em>\r\n		</div>\r\n\r\n		<div class=\"show-content show-{{temp.name}}\"></div>\r\n	</div>\r\n{{/each}}', '首页内容', '2020-07-18 22:25:07', '2020-07-18 22:25:09', 1);
INSERT INTO `html_template` VALUES (41, 'abc', 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `html_template` VALUES (42, 'abc', 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `html_template` VALUES (43, 'abc', 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `html_template` VALUES (44, 'abc', 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `html_template` VALUES (45, 'test45', '2', NULL, NULL, NULL, NULL, 2);

-- ----------------------------
-- Table structure for modular
-- ----------------------------
DROP TABLE IF EXISTS `modular`;
CREATE TABLE `modular`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块类型（1：导航模块、2：页面模块、3：页面内容模块）',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块名（作为id或class等用）',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块标题',
  `englishTitle` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块英文标题（部分内容/国际化需要）',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块对应页面地址',
  `config` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '页面渲染需要的配置来源url',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态：禁用：-1；测试：0；启用：1；',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of modular
-- ----------------------------
INSERT INTO `modular` VALUES (1, 'nav', 'index', '首页', 'index', '/', NULL, 1);
INSERT INTO `modular` VALUES (2, 'nav', 'products', '产品中心', 'products', 'product.html', NULL, 1);
INSERT INTO `modular` VALUES (3, 'nav', 'solution', '应用案例', 'solutions', 'solution.html', NULL, 0);
INSERT INTO `modular` VALUES (4, 'nav', 'student', '解决方案', 'solutions', 'solution.html', NULL, 0);
INSERT INTO `modular` VALUES (5, 'nav', 'news', '新闻资讯', 'news', 'news.html', NULL, 1);
INSERT INTO `modular` VALUES (6, 'nav', 'service', '服务支持', 'service', 'service.html', NULL, 0);
INSERT INTO `modular` VALUES (7, 'nav', 'about', '关于我们', 'about', 'about.html', NULL, 1);
INSERT INTO `modular` VALUES (9, '0', '测试', '123456', '', NULL, NULL, 0);
INSERT INTO `modular` VALUES (10, 'index_content', 'company', '公司简介', 'company profile', 'temp/index/company-info.htm', 'common-info.json', 1);
INSERT INTO `modular` VALUES (11, 'index_content', 'product', '产品展示', 'product display', 'temp/index/product-show.htm', 'hot-product.json', 1);
INSERT INTO `modular` VALUES (12, 'index_content', 'solution', '应用案例', 'application case', 'temp/index/application-case.htm', 'application-case.json', 1);
INSERT INTO `modular` VALUES (13, 'index_content', 'news', '新闻资讯', 'news and information', 'temp/index/news-info.htm', 'news.json', 1);
INSERT INTO `modular` VALUES (19, 'test-update', 'test-update', 'test-update', '', '/test/url', NULL, 2);
INSERT INTO `modular` VALUES (20, 'about_content', 'company', '公司简介', 'company profile', 'temp/about/company-info.htm', NULL, 1);
INSERT INTO `modular` VALUES (21, 'about_content', 'culture', '企业文化', 'enterprise culture', 'temp/about/company-culture.htm', NULL, 1);
INSERT INTO `modular` VALUES (22, 'about_content', 'advantage', '企业优势', 'company advantages', 'temp/about/company-advantage.htm', NULL, 1);
INSERT INTO `modular` VALUES (23, 'about_content', 'course', '发展历程', 'development history', 'temp/about/company-course.htm', 'course-info.json', 1);
INSERT INTO `modular` VALUES (24, 'about_content', 'recruit', '人才招聘', 'recruitment information', 'temp/about/company-recruitment-info.htm', 'recruitment-info.json', 1);
INSERT INTO `modular` VALUES (25, 'about_content', 'content-us', '联系我们', 'contact us', 'temp/about/company-contact-info.htm', 'common-info.json', 1);
INSERT INTO `modular` VALUES (26, 'content', '测试2', 'test2222', '', NULL, NULL, 0);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品名称',
  `category` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品种类（大类，比如XXX实验仪器）',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品类型（小类，比如XXX实验仪）',
  `model` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品型号（产品具体型号）',
  `coverImg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '这是产品展示图片',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品描述（简要）',
  `introduction` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '产品介绍（详细）',
  `resource` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品资料（提供给客户下载参考）',
  `status` int(11) NOT NULL COMMENT '产品状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_type`(`type`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'xxx产品', '1', '1', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);
INSERT INTO `product` VALUES ('2', 'xxx产品', '1', '2', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);
INSERT INTO `product` VALUES ('3', 'xxx产品', '2', '3', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);
INSERT INTO `product` VALUES ('4', 'xxx产品', '2', '4', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);
INSERT INTO `product` VALUES ('5', 'xxx产品', '3', '5', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);
INSERT INTO `product` VALUES ('6', 'xxx产品', '3', '6', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);
INSERT INTO `product` VALUES ('7', 'xxx产品', '4', '7', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);
INSERT INTO `product` VALUES ('8', 'xxx产品', '4', '8', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);
INSERT INTO `product` VALUES ('9', 'xxx产品', '5', '8', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);
INSERT INTO `product` VALUES ('10', 'xxx产品', '5', '8', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '这是资料下载', 1);

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品类型id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品类型名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型描述',
  `status` int(255) NOT NULL COMMENT '状态（0：不展示；1：展示）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', 'xxx实验仪器1', '这是实验描述1', 1);
INSERT INTO `product_category` VALUES ('2', 'xxx实验仪器2', '这是实验描述2', 1);
INSERT INTO `product_category` VALUES ('3', 'xxx实验仪器3', '这是实验描述3', 1);
INSERT INTO `product_category` VALUES ('4', 'xxx实验仪器4', '这是实验描述4', 1);

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品类型id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品类型名',
  `category` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品种类id',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型描述',
  `status` int(255) NOT NULL COMMENT '状态（0：不展示；1：展示）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', 'xxx实验仪1', '1', '这是实验仪描述1', 1);
INSERT INTO `product_type` VALUES ('2', 'xxx实验仪2', '1', '这是实验仪描述2', 1);
INSERT INTO `product_type` VALUES ('3', 'xxx实验仪3', '2', '这是实验仪描述3', 1);
INSERT INTO `product_type` VALUES ('4', 'xxx实验仪4', '2', '这是实验仪描述4', 1);
INSERT INTO `product_type` VALUES ('5', 'xxx实验仪5', '3', '这是实验仪描述5', 1);
INSERT INTO `product_type` VALUES ('6', 'xxx实验仪6', '3', '这是实验仪描述6', 1);
INSERT INTO `product_type` VALUES ('7', 'xxx实验仪7', '4', '这是实验仪描述7', 1);
INSERT INTO `product_type` VALUES ('8', 'xxx实验仪8', '4', '这是实验仪描述8', 1);

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置项',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '值',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `fixed` int(255) NOT NULL DEFAULT 0 COMMENT '类型是否可改变（0：可变；1：不可变）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'companyName', '奥莱博(武汉)科技有限公司', '公司名称', 0);
INSERT INTO `sys_config` VALUES ('2', 'companyAddress', '武汉市XXX区YYY路ZZZ号', '公司地址（文字）', 0);
INSERT INTO `sys_config` VALUES ('3', 'companyMapAddress', '这是公司的地址', '公司地址（地图）', 0);
INSERT INTO `sys_config` VALUES ('4', 'companyDescription', '这是公司的简要描述', '公司描述（利于搜索引擎收录）', 0);
INSERT INTO `sys_config` VALUES ('5', 'companyEmail', 'BTM9854211@163.com', '公司邮箱', 0);
INSERT INTO `sys_config` VALUES ('6', 'companyOfficialAccount', '/static/img/companyOfficialAccount.png', '公司微信公众号', 0);
INSERT INTO `sys_config` VALUES ('7', 'companyWeChat', '/static/img/companyWeChat.png', '公司微信客服（二维码图片文件名）', 0);
INSERT INTO `sys_config` VALUES ('8', 'companyIcon', '/logo.jpg', '公司图标', 0);
INSERT INTO `sys_config` VALUES ('9', 'websiteIcon', '/favicon.ico', '网站小图标文件名', 0);
INSERT INTO `sys_config` VALUES ('10', 'websiteCopyright', 'Copyright © 2020  奥莱博(武汉)科技有限公司. All Rights Reserved. ', '文章版权信息', 0);
INSERT INTO `sys_config` VALUES ('11', 'websiteKeyWords', '奥莱博(武汉)科技有限公司', '网站seo关键词（利于搜索引擎收录）', 0);
INSERT INTO `sys_config` VALUES ('12', 'websiteAuthor', '奥莱博(武汉)科技有限公司', '网站作者（利于搜索引擎收录）', 0);
INSERT INTO `sys_config` VALUES ('13', 'companyPhone', '0797-3116-3233', '公司联系电话', 0);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典id',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典名',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典值',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `fixed` int(255) NOT NULL DEFAULT 0 COMMENT '类型是否可改变（0：可变；1：不可变）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tm_permission
-- ----------------------------
DROP TABLE IF EXISTS `tm_permission`;
CREATE TABLE `tm_permission`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '功能ID',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能名称',
  `type` int(11) NULL DEFAULT NULL COMMENT '功能类别(系统、模块、菜单、操作)',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '许可描述',
  `serviceId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'webService: url',
  `createTime` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者（系统/超级管理员）',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tm_permission
-- ----------------------------
INSERT INTO `tm_permission` VALUES ('1001', '首页', 1, '首页', '1001', '2020-02-08 20:06:39', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1002', '用户登录', 1, '用户登录', '1002', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1003', '用户注册', 1, '用户注册', '1003', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1004', '获取用户信息', 1, '获取用户信息', '1004', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1005', '获取用户通知', 1, '获取用户通知', '1005', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1006', '获取加入队伍', 1, '获取加入队伍', '1006', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1008', '修改用户信息', 1, '修改用户信息', '1008', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1009', '获取板块信息', 1, '获取板块信息', '1009', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1010', '添加一篇板块', 1, '添加一篇板块', '1010', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1011', '更新一篇板块', 1, '更新一篇板块', '1011', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1012', '删除一篇板块', 1, '删除一篇板块', '1012', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1013', '获取所有板块信息', 1, '获取所有板块信息', '1013', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1014', '获取所有板块的文章', 1, '获取所有板块的文章', '1014', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1015', '获取文章信息', 1, '获取文章信息', '1015', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1016', '添加一篇文章', 1, '添加一篇文章', '1016', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1017', '更新一篇文章', 1, '更新一篇文章', '1017', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `tm_permission` VALUES ('1018', '删除一篇文章', 1, '删除一篇文章', '1018', '2020-02-08 21:56:43', '1122', 11);
INSERT INTO `tm_permission` VALUES ('1019', '获取板块的文章', 1, '获取板块的文章', '1019', '2020-02-08 21:56:43', '1122', 1);

-- ----------------------------
-- Table structure for tm_role
-- ----------------------------
DROP TABLE IF EXISTS `tm_role`;
CREATE TABLE `tm_role`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `descrie` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `creatorId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者（系统/超级管理员）',
  `status` int(11) NOT NULL COMMENT '角色状态（0：禁用；1：启用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tm_role
-- ----------------------------
INSERT INTO `tm_role` VALUES ('1001', '游客', '只是谁便看看', '2020-02-08 18:59:01', '1122', 1);
INSERT INTO `tm_role` VALUES ('1002', '用户', '平台基础用户', '2020-02-08 18:59:30', '1122', 1);
INSERT INTO `tm_role` VALUES ('1003', '会员', '平台普通会员', '2020-02-08 19:01:09', '1122', 1);
INSERT INTO `tm_role` VALUES ('1004', '高级会员', '平台高级会员', '2020-02-08 20:14:44', '1122', 1);
INSERT INTO `tm_role` VALUES ('1005', '测试人员', '平台测试人员', '2020-02-08 19:01:13', '1122', 1);
INSERT INTO `tm_role` VALUES ('1006', '运维人员', '平台运维人员', '2020-02-08 19:01:53', '1122', 1);
INSERT INTO `tm_role` VALUES ('1007', '体验账号', '给外界人员使用的体验账号', '2020-02-08 19:02:56', '1122', 1);
INSERT INTO `tm_role` VALUES ('1008', '管理员', '普通管理员', '2020-02-08 19:03:50', '1122', 1);
INSERT INTO `tm_role` VALUES ('1009', '超级管理员', '除了系统老大，我就是皇帝！哈哈哈哈！', '2020-02-08 19:04:44', '1122', 1);

-- ----------------------------
-- Table structure for tm_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tm_role_permission`;
CREATE TABLE `tm_role_permission`  (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `roleId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  `permissionId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tm_role_permission
-- ----------------------------
INSERT INTO `tm_role_permission` VALUES (1, '1009', '1001');
INSERT INTO `tm_role_permission` VALUES (2, '1009', '1002');
INSERT INTO `tm_role_permission` VALUES (3, '1109', '1003');
INSERT INTO `tm_role_permission` VALUES (4, '1009', '1004');
INSERT INTO `tm_role_permission` VALUES (5, '1009', '1014');
INSERT INTO `tm_role_permission` VALUES (6, '1009', '1006');
INSERT INTO `tm_role_permission` VALUES (8, '1009', '1008');
INSERT INTO `tm_role_permission` VALUES (9, '1009', '1009');
INSERT INTO `tm_role_permission` VALUES (10, '1009', '1010');
INSERT INTO `tm_role_permission` VALUES (11, '1009', '1011');
INSERT INTO `tm_role_permission` VALUES (12, '1009', '1012');
INSERT INTO `tm_role_permission` VALUES (13, '1009', '1013');
INSERT INTO `tm_role_permission` VALUES (14, '1009', '1003');
INSERT INTO `tm_role_permission` VALUES (15, '1009', '1015');
INSERT INTO `tm_role_permission` VALUES (16, '1009', '1016');
INSERT INTO `tm_role_permission` VALUES (17, '1009', '1017');
INSERT INTO `tm_role_permission` VALUES (18, '1009', '1018');
INSERT INTO `tm_role_permission` VALUES (28, '1009', '1019');
INSERT INTO `tm_role_permission` VALUES (20, '1001', '1001');
INSERT INTO `tm_role_permission` VALUES (21, '1001', '1002');
INSERT INTO `tm_role_permission` VALUES (22, '1001', '1003');
INSERT INTO `tm_role_permission` VALUES (23, '1001', '1009');
INSERT INTO `tm_role_permission` VALUES (24, '1001', '1013');
INSERT INTO `tm_role_permission` VALUES (25, '1001', '1014');
INSERT INTO `tm_role_permission` VALUES (26, '1001', '1015');
INSERT INTO `tm_role_permission` VALUES (27, '1001', '1019');

-- ----------------------------
-- Table structure for tm_service
-- ----------------------------
DROP TABLE IF EXISTS `tm_service`;
CREATE TABLE `tm_service`  (
  `id` int(11) NOT NULL,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tm_service
-- ----------------------------
INSERT INTO `tm_service` VALUES (1001, '首页', '/', '访问首页');
INSERT INTO `tm_service` VALUES (1002, '用户登录', '/user/login', '用户登录');
INSERT INTO `tm_service` VALUES (1003, '用户注册', '/user/register', '用户注册');
INSERT INTO `tm_service` VALUES (1004, '获取用户信息', '/user/info', '获取用户信息');
INSERT INTO `tm_service` VALUES (1005, '获取用户通知', '/user/mail', '获取用户通知');
INSERT INTO `tm_service` VALUES (1006, '获取加入队伍', '/user/groups', '获取加入队伍');
INSERT INTO `tm_service` VALUES (1008, '修改用户信息', '/user/modify', '修改用户信息');
INSERT INTO `tm_service` VALUES (1009, '获取板块信息', '/modular/get', '获取板块信息');
INSERT INTO `tm_service` VALUES (1010, '添加一篇板块', '/modular/add', '添加一篇板块');
INSERT INTO `tm_service` VALUES (1011, '更新一篇板块', '/modular/update', '更新一篇板块');
INSERT INTO `tm_service` VALUES (1012, '删除一篇板块', '/modular/delete', '删除一篇板块');
INSERT INTO `tm_service` VALUES (1013, '获取所有板块信息', '/modular/list', '获取所有板块信息');
INSERT INTO `tm_service` VALUES (1014, '获取所有板块的文章', '/modular/getArticles', '获取所有板块的板块');
INSERT INTO `tm_service` VALUES (1015, '获取文章信息', '/article/get', '获取文章信息');
INSERT INTO `tm_service` VALUES (1016, '添加一篇文章', '/article/add', '添加一篇文章');
INSERT INTO `tm_service` VALUES (1017, '更新一篇文章', '/article/update', '更新一篇文章');
INSERT INTO `tm_service` VALUES (1018, '删除一篇文章', '/article/delete', '删除获取板块的文章一篇文章');
INSERT INTO `tm_service` VALUES (1019, '获取板块的文章', '/article/list', '获取板块下的文章');

-- ----------------------------
-- Table structure for tm_user
-- ----------------------------
DROP TABLE IF EXISTS `tm_user`;
CREATE TABLE `tm_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `username` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `status` int(11) NOT NULL COMMENT '账户状态（0：未激活；1：启用；2：锁定；3：禁用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tm_user
-- ----------------------------
INSERT INTO `tm_user` VALUES ('1221', 'test', '123456', 1);
INSERT INTO `tm_user` VALUES ('1122', 'admin', '123456', 1);

-- ----------------------------
-- Table structure for tm_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tm_user_role`;
CREATE TABLE `tm_user_role`  (
  `id` int(11) NOT NULL,
  `userId` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `roleId` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of tm_user_role
-- ----------------------------
INSERT INTO `tm_user_role` VALUES (1, '1221', '1009');
INSERT INTO `tm_user_role` VALUES (2, 'visitor', '1001');

SET FOREIGN_KEY_CHECKS = 1;
