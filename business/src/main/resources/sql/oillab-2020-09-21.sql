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

 Date: 21/09/2020 10:53:14
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
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型描述',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_type
-- ----------------------------
INSERT INTO `article_type` VALUES (1, 'news', '新闻资讯', '新闻资讯的文章', 1);
INSERT INTO `article_type` VALUES (2, 'product', '产品介绍', '产品介绍的文章', 1);
INSERT INTO `article_type` VALUES (3, 'article', '普通文章', '普通的文章', 1);
INSERT INTO `article_type` VALUES (4, 'introduce', '公司简介', '公司简介的文章', 1);

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '类型:0:PC，1:H5，2:APP',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '轮播图名字: 区别不同的轮播图',
  `url` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT '' COMMENT '链接地址',
  `coverImg` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面图片',
  `description` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '图片描述',
  `remark` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注信息',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `interval` int(11) NULL DEFAULT NULL COMMENT '轮播图切换停留时间',
  `createTime` datetime(6) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(6) NOT NULL COMMENT '修改时间',
  `operatorId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人ID',
  `status` int(11) NOT NULL COMMENT '状态 0 禁用 1 正常 ',
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
-- Table structure for file_conf
-- ----------------------------
DROP TABLE IF EXISTS `file_conf`;
CREATE TABLE `file_conf`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '自增主键idCOMMENT ',
  `bize_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务类型，不同业务不同的类型COMMENT ',
  `file_type_limit` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '允许上传的文件类型(mine-type标准)，为空时不限制类型COMMENT ',
  `file_size_limit` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '允许上传的文件大小(kb)，为空时不限制大小COMMENT ',
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务器存储文件的路径COMMENT ',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述，如描述该业务类型对应的文件上传业务功能的业务表COMMENT ',
  `resource_realm` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '外部访问文件资源相对根路径COMMENT ',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用(默认1可用，0禁用),用于禁止某个业务上传文件的功能COMMENT ',
  `creat_time` datetime(0) NOT NULL COMMENT '创建时间COMMENT ',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '最近修改时间COMMENT ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for file_info
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '自增主键idCOMMENT ',
  `bize_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务类型COMMENT ',
  `bize_id` int(11) NULL DEFAULT NULL COMMENT '业务idCOMMENT ',
  `original_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件原名称COMMENT ',
  `new_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件新名称(唯一)COMMENT ',
  `file_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件类型COMMENT ',
  `file_size` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件大小(kb)COMMENT ',
  `file_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件服务器存储绝对路径COMMENT ',
  `relative_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件相对路径，域名+此字段为该资源的请求地址COMMENT ',
  `creat_time` datetime(0) NOT NULL COMMENT '创建时间COMMENT ',
  `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '最近修改时间COMMENT ',
  `del_flag` tinyint(1) NOT NULL COMMENT '逻辑删除(默认0正常，1文件已被物理删除)COMMENT ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for file_upload_config
-- ----------------------------
DROP TABLE IF EXISTS `file_upload_config`;
CREATE TABLE `file_upload_config`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `maxSize` int(255) NULL DEFAULT NULL COMMENT '上传文件最大大小（bit）',
  `types` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '允许上传文件类型（用,分割）',
  `mimeTypes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `uploadPath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上传文件路径',
  `nameFormat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件格式',
  `downloadName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '下载时使用的文件名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gen_config
-- ----------------------------
DROP TABLE IF EXISTS `gen_config`;
CREATE TABLE `gen_config`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `description` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '描述',
  `basePackage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'base package',
  `baseModelpackage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'base model package',
  `idConfigId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `fileUploadConfigId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `c` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `d` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(1) NOT NULL COMMENT '状态 0 禁用 1 正常 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_config
-- ----------------------------
INSERT INTO `gen_config` VALUES ('1221', 'commonConfig', '通用配置', 'cn.yudu.museum', 'xyz.common.base.model', NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for gen_config_template
-- ----------------------------
DROP TABLE IF EXISTS `gen_config_template`;
CREATE TABLE `gen_config_template`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `config` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置id',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `template` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '模板',
  `description` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '描述',
  `status` int(11) NOT NULL COMMENT '状态 0 禁用 1 正常 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `name` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `configId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sub_table_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `className` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '实体名称',
  `author` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `type` int(11) NOT NULL COMMENT '生成类型：全部、新增、修改、列表、查询',
  `template` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模板路径',
  `package` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `moduleName` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `businessName` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务名称',
  `functionName` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '功能名称',
  `parentMenuName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父菜单',
  `basePath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码生成的基础路径',
  `genType` int(255) NULL DEFAULT NULL COMMENT '生成代码方式：0：生成压缩包，1：自定义路径',
  `options` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES ('ADBE100540194300B114E446BB1DECDF', 'html_template', '', '1221', NULL, NULL, 'HtmlTemplate', NULL, NULL, 1, '1234', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-07-21 16:45:23', '', '2020-08-12 00:39:16');
INSERT INTO `gen_table` VALUES ('46349DA02F7E4EF5AD298D1BEA0CD4AA', 'carousel', '焦点图管理表', '1221', NULL, NULL, 'Carousel', NULL, NULL, 1, '1234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-07-23 13:45:56', '', NULL);
INSERT INTO `gen_table` VALUES ('17D534555DA0460CAB163A642B53E376', 'modular', '123', '1221', NULL, NULL, 'Modular', 'timor', 'test', 1, '1234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-07-22 15:28:10', '', '2020-08-12 09:47:07');
INSERT INTO `gen_table` VALUES ('4BBEBA66304A49178EE097FA94C87732', 'gen_config_template', '', '1221', NULL, NULL, 'GenConfigTemplate', NULL, NULL, 1, '1234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-19 10:49:00', '', '2020-08-19 10:49:00');

-- ----------------------------
-- Table structure for gen_table_col
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_col`;
CREATE TABLE `gen_table_col`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `tableId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表id',
  `columnName` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段列名',
  `columnComment` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段描述',
  `columnType` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '物理类型',
  `javaType` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Java类型',
  `javaField` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Java属性',
  `comment` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段描述',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序序号',
  `option` int(11) NULL DEFAULT NULL COMMENT '保留属性',
  `isPrimaryKey` tinyint(1) NULL DEFAULT NULL COMMENT '是否为主键',
  `insertType` int(11) NULL DEFAULT NULL,
  `updateType` int(11) NULL DEFAULT NULL,
  `needForDelete` tinyint(1) NULL DEFAULT NULL,
  `needForGet` tinyint(1) NULL DEFAULT NULL,
  `findType` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `findOneType` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ajaxInsertType` int(11) NULL DEFAULT NULL,
  `ajaxUpdateType` int(11) NULL DEFAULT NULL,
  `isRequired` tinyint(1) NULL DEFAULT NULL COMMENT '是否必填',
  `filterForReturn` tinyint(1) NULL DEFAULT NULL COMMENT '返回是否过滤此自动',
  `htmlType` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表单类型',
  `defaultValue` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '默认值',
  `dictType` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型',
  `uploadConfig` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件上传配置',
  `primaryKeyRule` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主键策略',
  `placeholder` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表单提示',
  `isListHide` tinyint(1) NULL DEFAULT NULL COMMENT ' 列表页隐藏',
  `isListDefaultHide` tinyint(1) NULL DEFAULT NULL COMMENT '列表页是否默认隐藏',
  `isInlineEdit` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启行内编辑',
  `listWidth` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格显示列的最小宽度',
  `listFormat` int(11) NULL DEFAULT NULL COMMENT '展示格式',
  `listAlign` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '对齐方式（left：靠左对齐，right：靠右对齐，center：居中对齐）',
  `listSort` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列表页排序（0：不可排序，true：可排序，desc：默认降序，asc：默认升序）',
  `dateFormat` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日期格式（yyyy，yyyy-MM，yyyy-MM-dd，，yyyy-MM-dd HH，，yyyy-MM-dd HH:mm，，yyyy-MM-dd HH:mm:ss）',
  `validateType` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证类型（文本、html文本、数字手机、邮箱、电话、url、ip地址）',
  `validateRegex` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '正则验证表达式',
  `rangeLength` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '长度区间',
  `rangeValue` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '值区间',
  `dateQueryFormat` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日期查询格式（yyyy，yyyy-MM，yyyy-MM-dd，，yyyy-MM-dd HH，，yyyy-MM-dd HH:mm，，yyyy-MM-dd HH:mm:ss）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成器——表字段信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table_col
-- ----------------------------
INSERT INTO `gen_table_col` VALUES ('031D33F33D5C4E629E3AFF0380F49F52', 'A639DA84A42545F5999D449DE2221F9E', 'views', '浏览人数', 'int(11)', 'java.lang.Integer', 'views', '浏览人数', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'number', '0', '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('07F04F1754B44C5F98EC51608EAD262F', '4BBEBA66304A49178EE097FA94C87732', 'template', '模板', 'varchar(2048)', 'java.lang.String', 'template', '模板', 4, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, NULL, NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 2048', '', NULL);
INSERT INTO `gen_table_col` VALUES ('0B32374739DA4242B5646D86F5995727', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'operatorId', '操作人ID', 'varchar(32)', 'java.lang.String', 'operatorid', '操作人ID', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '0, 32', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('0C0B58AF7C174D86988C41565F526D89', '17D534555DA0460CAB163A642B53E376', 'type', '模板类型', 'varchar(32)', 'java.lang.String', 'type', '模板类型', 3, 0, NULL, 1, 1, 1, 1, '', 'EQ', 1, 1, 1, 1, 'textarea', NULL, '', '', '', NULL, 1, 1, 1, NULL, NULL, '', '0', NULL, NULL, NULL, '0, 32', '', NULL);
INSERT INTO `gen_table_col` VALUES ('0F2F2B8D2ABA41B8AE9E2229C24E6CED', 'A639DA84A42545F5999D449DE2221F9E', 'type', '文章类型', 'varchar(32)', 'java.lang.String', 'type', '文章类型', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 32', '', NULL);
INSERT INTO `gen_table_col` VALUES ('15FA020DB0F6445BA4226A2DC156C200', 'CA542E6CC8294EACBA201B8549B618EE', 'id', '主键id', 'int(11) unsigned', 'java.lang.Integer', 'id', '主键id', 1, NULL, NULL, 5, 1, 1, 1, '', 'EQ', 4, 3, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('22665C2D2D9240DEBBE674985833E311', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'interval', '轮播图切换停留时间', 'smallint(255)', 'java.lang.Integer', 'interval', '轮播图切换停留时间', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('2B899940A1534165810F6520D25E5CC0', 'A639DA84A42545F5999D449DE2221F9E', 'author', '文章作者', 'varchar(128)', 'java.lang.String', 'author', '文章作者', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 128', '', NULL);
INSERT INTO `gen_table_col` VALUES ('2CC891D2AC5141E8BE63BEDC796897BF', 'CA542E6CC8294EACBA201B8549B618EE', 'types', '允许上传文件类型（用,分割）', 'varchar(255)', 'java.lang.String', 'types', '允许上传文件类型（用,分割）', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 255', '', NULL);
INSERT INTO `gen_table_col` VALUES ('2F7CF1683AD94A819F70B6DF70D6F248', '4BBEBA66304A49178EE097FA94C87732', 'description', '描述', 'varchar(128)', 'java.lang.String', 'description', '描述', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', '', '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 128', '', NULL);
INSERT INTO `gen_table_col` VALUES ('3000A77469AF457FA2E121E4C3854AB2', 'A639DA84A42545F5999D449DE2221F9E', 'mid', '模块id', 'int(11)', 'java.lang.Integer', 'mid', '模块id', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'number', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('315790623204426CAFC001793862E164', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'description', '图片描述', 'varchar(128)', 'java.lang.String', 'description', '图片描述', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, '', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '0, 128', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('32EDC96B17374ACAABE57F40AE41717F', 'A639DA84A42545F5999D449DE2221F9E', 'status', '状态：禁用：-1；测试：0；启用：1；', 'int(255)', 'java.lang.Integer', 'status', '状态：禁用：-1；测试：0；启用：1；', 8, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'number', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('3AFEB9DA2D654EC3B447E04EB33D9760', '17D534555DA0460CAB163A642B53E376', 'englishTitle', '模块英文标题（部分内容/国际化需要）', 'varchar(64)', 'java.lang.Short', 'englishtitle', '模块英文标题（部分内容/国际化需要）', NULL, 0, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 64', '', NULL);
INSERT INTO `gen_table_col` VALUES ('481B1514F4C94AB59E7C87A9F2EFA130', '4BBEBA66304A49178EE097FA94C87732', 'type', '类型', 'varchar(255)', 'java.lang.String', 'type', '类型', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 255', '', NULL);
INSERT INTO `gen_table_col` VALUES ('4B00BBB16A62445FBB09E4CA22CE6ECA', 'ADBE100540194300B114E446BB1DECDF', 'remark', '备注', 'varchar(256)', 'java.lang.String', 'remark', '备注', 5, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 256', '', NULL);
INSERT INTO `gen_table_col` VALUES ('4EB38AF348EA44B184425CCBE3681A09', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'id', '', 'int(11) unsigned', 'java.lang.Integer', 'id', '', NULL, 0, NULL, 1, 1, 1, 1, '=', 'EQ', 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, '', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('520B07FEF1CA4A55B776A377871D989D', 'CA542E6CC8294EACBA201B8549B618EE', 'maxSize', '上传文件最大大小（bit）', 'int(255)', 'java.lang.Integer', 'maxsize', '上传文件最大大小（bit）', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'number', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('552C3CACE1CD406FA9ED019399F532CD', 'CA542E6CC8294EACBA201B8549B618EE', 'mimeTypes', '', 'varchar(255)', 'java.lang.String', 'mimetypes', '', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 255', '', NULL);
INSERT INTO `gen_table_col` VALUES ('56AAE8337F224DDC9AF021BAD082EEC5', 'CA542E6CC8294EACBA201B8549B618EE', 'name', '模板名称', 'varchar(64)', 'java.lang.String', 'name', '模板名称', 2, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 64', '', NULL);
INSERT INTO `gen_table_col` VALUES ('579CD5F71D2C4EC6989B614FEDCC69D3', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'updateTime', '修改时间', 'datetime(6)', 'java.sql.Timestamp', 'updatetime', '修改时间', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('5A63966CB74345D481873CBE2C7868FD', 'CA542E6CC8294EACBA201B8549B618EE', 'nameFormat', '文件格式', 'varchar(255)', 'java.lang.String', 'nameformat', '文件格式', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 255', '', NULL);
INSERT INTO `gen_table_col` VALUES ('5DCFB1FC481248BB9988F74745794069', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'status', '状态 0 禁用 1 正常 ', 'int(1)', 'java.lang.Integer', 'status', '状态 0 禁用 1 正常 ', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('5DE6DC0783504BC0A6FB94340B02DF3C', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'coverImg', '封面图片', 'varchar(150)', 'java.lang.String', 'coverimg', '封面图片', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '0, 150', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('63B1C27C6AD946EA96CCB34D9FC87284', '4BBEBA66304A49178EE097FA94C87732', 'config', '配置id', 'varchar(32)', 'java.lang.String', 'config', '配置id', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 32', '', NULL);
INSERT INTO `gen_table_col` VALUES ('708F08816D85470A8F8F6BC921AE5B5B', 'ADBE100540194300B114E446BB1DECDF', 'name', '模板名称', 'varchar(64)', 'java.lang.String', 'name', '模板名称', 2, NULL, NULL, 1, 1, 0, 0, 'EQ', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 64', '', NULL);
INSERT INTO `gen_table_col` VALUES ('7264C89625524AA2BD334DFEBB0FBE1D', 'A639DA84A42545F5999D449DE2221F9E', 'uid', '发布文章管理员id', 'char(32)', 'java.lang.String', 'uid', '发布文章管理员id', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 32', '', NULL);
INSERT INTO `gen_table_col` VALUES ('776CAB05F30D47D1BEAF5E037731E5FD', '17D534555DA0460CAB163A642B53E376', 'url', '模块对应页面地址', 'varchar(255)', 'java.lang.Integer', 'url', '模块对应页面地址', NULL, 0, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 255', '', NULL);
INSERT INTO `gen_table_col` VALUES ('7B31E2ED5C714D86826238F8FC8E76D9', 'A639DA84A42545F5999D449DE2221F9E', 'coverImg', '引导（封面）图片', 'varchar(255)', 'java.lang.String', 'coverimg', '引导（封面）图片', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 255', '', NULL);
INSERT INTO `gen_table_col` VALUES ('84197DED312E46B9B1312BAB3E2D302B', '17D534555DA0460CAB163A642B53E376', 'config', '页面渲染需要的配置来源url', 'varchar(128)', 'java.lang.String', 'config', '页面渲染需要的配置来源url', NULL, 0, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 128', '', NULL);
INSERT INTO `gen_table_col` VALUES ('86E4916ABF7B49F58C2DB15502E12A2A', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'type', '类型:0:PC，1:H5，2:APP', 'tinyint(2) unsigned', 'java.lang.Boolean', 'type', '类型:0:PC，1:H5，2:APP', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, '0', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('87B911C5DE4B46EEBDD7F407CDE8325F', 'CA542E6CC8294EACBA201B8549B618EE', 'uploadPath', '上传文件路径', 'varchar(255)', 'java.lang.String', 'uploadpath', '上传文件路径', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 255', '', NULL);
INSERT INTO `gen_table_col` VALUES ('8A0257E9C2134CE6853CD0B8F5F9D5C8', 'A639DA84A42545F5999D449DE2221F9E', 'addTime', '文章入库时间', 'datetime', 'java.sql.Timestamp', 'addtime', '文章入库时间', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'datetime', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '', NULL);
INSERT INTO `gen_table_col` VALUES ('8A2FA5EEEEFD40ABB84CBEC6AFB841EE', 'ADBE100540194300B114E446BB1DECDF', 'template', '模板', 'varchar(2048)', 'java.lang.String', 'template', '模板', 4, NULL, NULL, 1, 1, 0, 0, 'LIKE', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 2048', '', NULL);
INSERT INTO `gen_table_col` VALUES ('8BB9CA2743474FC6AF136FE1C89E5D99', 'A639DA84A42545F5999D449DE2221F9E', 'lastEditTime', '最后编辑时间', 'datetime', 'java.sql.Timestamp', 'lastedittime', '最后编辑时间', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'datetime', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '', NULL);
INSERT INTO `gen_table_col` VALUES ('8C0D13C5E1AC43D98031F036480A117D', '17D534555DA0460CAB163A642B53E376', 'title', '模块标题', 'varchar(64)', 'java.lang.String', 'title', '模块标题', NULL, 0, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', '2131', '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 64', '', NULL);
INSERT INTO `gen_table_col` VALUES ('8D54DE5070D64A43AA56954E3EA90A57', '17D534555DA0460CAB163A642B53E376', 'status', '状态：禁用：-1；测试：0；启用：1；', 'int(11)', 'java.lang.Integer', 'status', '状态：禁用：-1；测试：0；启用：1；', NULL, 0, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'number', '1', '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('8D9CA0EBE9544D1395737E51270F54FC', '17D534555DA0460CAB163A642B53E376', 'name', '模块名（作为id或class等用）', 'varchar(64)', 'java.lang.String', 'name', '模块名（作为id或class等用）', NULL, 0, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 64', '', NULL);
INSERT INTO `gen_table_col` VALUES ('8E31AEECE1E040F3B95B949DD603CF0E', '4BBEBA66304A49178EE097FA94C87732', 'name', '名称', 'varchar(128)', 'java.lang.String', 'name', '名称', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 128', '', NULL);
INSERT INTO `gen_table_col` VALUES ('94191A8F62764523A54AB904C7EEF431', 'ADBE100540194300B114E446BB1DECDF', 'edit_time', '最后变更时间', 'timestamp', 'java.sql.Timestamp', 'editTime', '最后变更时间', 7, NULL, NULL, 1, 1, 0, 0, 'BETWEEN', 'EQ', 1, 1, 0, 0, 'datetime', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '', NULL);
INSERT INTO `gen_table_col` VALUES ('94CBF5B058B64B4AB3C01978542CA4D2', '17D534555DA0460CAB163A642B53E376', 'id', '主键id', 'int(11)', 'java.sql.Timestamp', 'id', 'sdasdafa', NULL, 0, NULL, 2, 2, 1, 1, '', 'EQ', 2, 2, 1, 1, 'month', '123456', '23阿31', '12311', '2131', '312313', 1, 1, 1, '311', 0, 'center', '1', '2', '1', '2131', '21', '1023', '6');
INSERT INTO `gen_table_col` VALUES ('A57A4E90EC544F19A89F5C3C6A509C79', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'remark', '备注信息', 'varchar(32)', 'java.lang.String', 'remark', '备注信息', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, '', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '0, 32', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('AB91ED0D295D408EA108979032FCC772', 'CA542E6CC8294EACBA201B8549B618EE', 'downloadName', '下载时使用的文件名', 'varchar(255)', 'java.lang.String', 'downloadname', '下载时使用的文件名', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 255', '', NULL);
INSERT INTO `gen_table_col` VALUES ('AC5F77341FF74ABC9A4C9DC8C4CF21C1', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'sort', '排序', 'int(1)', 'java.lang.Integer', 'sort', '排序', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('B21269810FD548BAA2F32CFE760DDE34', 'CA542E6CC8294EACBA201B8549B618EE', 'description', '描述', 'varchar(255)', 'java.lang.String', 'description', '描述', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 0, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 255', '', NULL);
INSERT INTO `gen_table_col` VALUES ('B4C0B788A6F340538D5F6EA5895FD271', 'A639DA84A42545F5999D449DE2221F9E', 'description', '概要', 'varchar(512)', 'java.lang.String', 'description', '概要', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 512', '', NULL);
INSERT INTO `gen_table_col` VALUES ('BFAE9A529A7549C8A7E2C3D0C76E0783', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'name', '轮播图名字: 区别不同的轮播图', 'varchar(32)', 'java.lang.String', 'name', '轮播图名字: 区别不同的轮播图', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '0, 32', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('C1E10BBC7FD64F729750B8DEB734BC19', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'url', '链接地址', 'varchar(100)', 'java.lang.String', 'url', '链接地址', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, '', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '0, 100', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('C3E31AB4B2184EBC99DBA56A88BB5179', 'ADBE100540194300B114E446BB1DECDF', 'status', '状态：禁用：-1；测试：0；启用：1；', 'int(255)', 'java.lang.Integer', 'status', '状态：禁用：-1；测试：0；启用：1；', 8, NULL, NULL, 1, 1, 0, 0, 'EQ', 'EQ', 1, 1, 0, 0, 'number', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('C8685E3DA0A24132B2E7A7084A827663', 'ADBE100540194300B114E446BB1DECDF', 'id', '主键id', 'int(11) unsigned', 'java.lang.Integer', 'id', '主键id', 1, NULL, NULL, 5, 1, 1, 1, 'EQ', 'EQ', 4, 3, 1, 0, 'number', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('C9C4A1DBCC684F30B07DD92B371B0879', 'ADBE100540194300B114E446BB1DECDF', 'create_time', '创建时间', 'timestamp', 'java.sql.Timestamp', 'createTime', '创建时间', 6, NULL, NULL, 1, 1, 0, 0, 'BETWEEN', 'EQ', 1, 1, 0, 0, 'datetime', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '', NULL);
INSERT INTO `gen_table_col` VALUES ('CAED63B1B82D4C879D8F7895FD415A74', '46349DA02F7E4EF5AD298D1BEA0CD4AA', 'createTime', '创建时间', 'datetime(6)', 'java.sql.Timestamp', 'createtime', '创建时间', NULL, 0, NULL, 1, 1, 0, 0, '=', 'EQ', 1, 1, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, '0', NULL, NULL, NULL, '', NULL, NULL);
INSERT INTO `gen_table_col` VALUES ('D72770E8B9B44AFEAAFEE5CC8B1CDD33', 'A639DA84A42545F5999D449DE2221F9E', 'content', '文章内容（富文本）', 'text', 'java.lang.String', 'content', '文章内容（富文本）', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'textarea', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 65535', '', NULL);
INSERT INTO `gen_table_col` VALUES ('E54E33EDFF3844B797EF09EC44A0B70C', 'A639DA84A42545F5999D449DE2221F9E', 'id', 'cid', 'int(11)', 'java.lang.Integer', 'id', 'cid', NULL, NULL, NULL, 5, 1, 1, 1, '', 'EQ', 4, 3, 1, 0, 'number', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('E8696DCADF524EBCA7166CC06847F4CE', '4BBEBA66304A49178EE097FA94C87732', 'status', '状态 0 禁用 1 正常 ', 'int(11)', 'java.lang.Integer', 'status', '状态 0 禁用 1 正常 ', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'number', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '-1024, 1023', NULL);
INSERT INTO `gen_table_col` VALUES ('ED28F4DB4EC94014BA7A0E35D3983C4F', '4BBEBA66304A49178EE097FA94C87732', 'id', '主键id', 'varchar(32)', 'java.lang.String', 'id', '主键id', NULL, NULL, NULL, 5, 1, 1, 1, '', 'EQ', 4, 3, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 32', '', NULL);
INSERT INTO `gen_table_col` VALUES ('F8369A884A024D0C8C00A2B08B04FC6C', 'A639DA84A42545F5999D449DE2221F9E', 'title', '标题', 'varchar(128)', 'java.lang.String', 'title', '标题', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 128', '', NULL);
INSERT INTO `gen_table_col` VALUES ('FA21BC06106849E5AA093D03AC5D0CDE', 'ADBE100540194300B114E446BB1DECDF', 'type', '模板类型', 'varchar(32)', 'java.lang.String', 'type', '模板类型', 3, NULL, NULL, 1, 1, 0, 0, 'EQ', 'EQ', 1, 1, 1, 0, 'text', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '0, 32', '', NULL);
INSERT INTO `gen_table_col` VALUES ('FABC894142D6431680343AAEC1895BD0', 'A639DA84A42545F5999D449DE2221F9E', 'pubTime', '发布时间（自定义）', 'datetime', 'java.sql.Timestamp', 'pubtime', '发布时间（自定义）', NULL, NULL, NULL, 1, 1, 0, 0, '', 'EQ', 1, 1, 1, 0, 'datetime', NULL, '', '', '', NULL, 0, NULL, NULL, NULL, 0, '', '0', NULL, NULL, NULL, '', '', NULL);

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
INSERT INTO `html_template` VALUES (25, 'myBtnGroup', 'pageContent', '{{each $data temp index}}\r\n	<a class=\"my-btn {{if index == 0}}selected{{/if}}\" href=\"#show-{{temp.name}}\">{{temp.title}}</a>\r\n{{/each}}', '关于页面的菜单', '2020-07-17 20:50:34', '2020-07-17 20:50:38', 1);
INSERT INTO `html_template` VALUES (26, 'aboutContainer', 'pageContent', '{{each $data temp index}}\r\n	<div id=\"show-{{temp.name}}\">\r\n		<div class=\"about-title\">\r\n			<span>{{temp.title}}</span><i></i><em>{{temp.englishTitle}}</em>\r\n		</div>\r\n\r\n		<div class=\"about-content about-{{temp.name}}\"></div>\r\n	</div>\r\n{{/each}}', '关于页面的详情内容', '2020-07-17 21:21:52', '2020-07-17 21:21:54', 1);
INSERT INTO `html_template` VALUES (27, 'index_showContainer', 'pageContent', '{{each $data temp index}}\r\n	<div id=\"show-{{temp.name}}\">\r\n		<div class=\"show-title\">\r\n			<h2>{{temp.title}}</h2><i>/</i><em>{{temp.englishTitle}}</em>\r\n		</div>\r\n\r\n		<div class=\"show-content show-{{temp.name}}\"></div>\r\n	</div>\r\n{{/each}}', '首页内容', '2020-07-18 22:25:07', '2020-07-18 22:25:09', 1);
INSERT INTO `html_template` VALUES (41, 'gen_table_col', 'pageContent', '<tr>\r\n    <th data-checkbox=\"true\"></th>\r\n    {{each $data item index}}\r\n    <th data-field=\"{{item.name}}\" data-align=\"{{item.align ? item.align : \'center\'}}\" {{if item.formatter}}data-formatter=\"{{item.name}}Fmt\"{{/if}} {{item.sortable ? \'data-sortable=\"true\"\' : \'\'}}>\r\n        <div style=\"min-width: {{item.width}}\">{{item.title}}</div>\r\n    </th>\r\n    {{/each}}\r\n</tr>', '代码生成器的列表', '2020-08-06 03:30:36', '2020-08-06 03:30:39', 1);
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
) ENGINE = MyISAM AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of modular
-- ----------------------------
INSERT INTO `modular` VALUES (1, 'nav', 'index', '首页', 'index', '/', NULL, 1);
INSERT INTO `modular` VALUES (2, 'nav', 'products', '产品中心', 'products', '/product', NULL, 1);
INSERT INTO `modular` VALUES (3, 'nav', 'solution', '应用案例', 'solutions', '/solution', NULL, 0);
INSERT INTO `modular` VALUES (4, 'nav', 'student', '解决方案', 'solutions', '/solution', NULL, 0);
INSERT INTO `modular` VALUES (5, 'nav', 'news', '新闻资讯', 'news', '/news', NULL, 1);
INSERT INTO `modular` VALUES (6, 'nav', 'service', '服务支持', 'service', '/service', NULL, 0);
INSERT INTO `modular` VALUES (7, 'nav', 'about', '关于我们', 'about', '/about', NULL, 1);
INSERT INTO `modular` VALUES (19, 'test-update', 'test-update', 'test-update', '', '/test/url', NULL, 2);
INSERT INTO `modular` VALUES (11, 'index_content', 'product', '产品展示', 'product display', '/template/default/temp/index/product-show.htm', 'hot-product.json', 1);
INSERT INTO `modular` VALUES (20, 'about_content', 'company', '公司简介', 'company profile', '/template/default/temp/about/company-info.htm', NULL, 1);
INSERT INTO `modular` VALUES (21, 'about_content', 'culture', '企业文化', 'enterprise culture', '/template/default/temp/about/company-culture.htm', NULL, 1);
INSERT INTO `modular` VALUES (22, 'about_content', 'advantage', '企业优势', 'company advantages', '/template/default/temp/about/company-advantage.htm', NULL, 1);
INSERT INTO `modular` VALUES (23, 'about_content', 'course', '发展历程', 'development history', '/template/default/temp/about/company-course.htm', 'course-info.json', 1);
INSERT INTO `modular` VALUES (24, 'about_content', 'recruit', '人才招聘', 'recruitment information', '/template/default/temp/about/company-recruitment-info.htm', 'recruitment-info.json', 1);
INSERT INTO `modular` VALUES (25, 'about_content', 'content-us', '联系我们', 'contact us', '/template/default/temp/about/company-contact-info.htm', 'common-info.json', 1);
INSERT INTO `modular` VALUES (26, 'content', '测试2', 'test2222', '', NULL, NULL, 0);
INSERT INTO `modular` VALUES (13, 'index_content', 'news', '新闻资讯', 'news and information', '/template/default/temp/index/news-info.htm', 'news.json', 1);
INSERT INTO `modular` VALUES (12, 'index_content', 'solution', '应用案例', 'application case', '/template/default/temp/index/application-case.htm', 'application-case.json', 1);
INSERT INTO `modular` VALUES (10, 'index_content', 'company', '公司简介', 'company profile', '/template/default/temp/index/company-info.htm', 'common-info.json', 1);

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
  `status` int(11) NOT NULL COMMENT '产品状态（0：暂存， 1：发布，2：屏蔽）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_type`(`type`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('8', 'xxx产品', '4', '8', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '[]', 1);
INSERT INTO `product` VALUES ('9', 'xxx产品', '5', '8', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '[]', 1);
INSERT INTO `product` VALUES ('10', 'xxx产品', '5', '8', 'XXX型yyy产品', '/static/oillab/images/pro1.jpg', '这是产品的简要描述……', '产品详细介绍……', '[]', 1);
INSERT INTO `product` VALUES ('3BCB92340EF24BB29CDBB3A9926DAA52', 'test', '1', '1', 'test', 'http://timor:8080//upload/timor.gif', 'test', 'content: 12345', '[{\"path\":\"http://timor:8080//upload/hello.txt\",\"original\":\"hello.txt\",\"size\":42948620288,\"state\":\"SUCCESS\",\"title\":\"hello.txt\",\"type\":\".plain\",\"url\":\"http://timor:8080//upload/hello.txt\"},{\"path\":\"http://timor:8080//upload/【阿尔法工作室】2020招新策划书.pdf\",\"original\":\"【阿尔法工作室】2020招新策划书.pdf\",\"size\":42948620288,\"state\":\"SUCCESS\",\"title\":\"【阿尔法工作室】2020招新策划书.pdf\",\"type\":\".pdf\",\"url\":\"http://timor:8080//upload/【阿尔法工作室】2020招新策划书.pdf\"}]', 1);
INSERT INTO `product` VALUES ('11E0D7AA19704392913509E8C4E63E4E', '模板', '1', '1', '模板', 'http://timor:8080//upload/timor.gif', 'test', '<h2><b>7322高温高压稠化仪</b></h2>\r\n<h1 style=\"font-size: 12px;\"><br></h1><p style=\"color: rgb(71, 71, 71); font-family: &quot;Microsoft YaHei&quot;; font-size: 12px;\"><img src=\"http://www.qiandele.com/images/cp/header-arrow.gif\" width=\"23\" height=\"23\" align=\"absmiddle\">&nbsp;<strong><span class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; color: rgb(0, 0, 0); line-height: 22px;\">概述</span></strong></p><p style=\"color: rgb(71, 71, 71); font-family: &quot;Microsoft YaHei&quot;; font-size: 12px;\"><strong><span class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; color: rgb(0, 0, 0); line-height: 22px;\"><strong><img src=\"http://www.qiandele.com/images/cp/7322.jpg\" width=\"119\" height=\"323\" align=\"right\"></strong>用于油井水泥的关键性工具</span></strong></p><p class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; color: rgb(0, 0, 0); line-height: 22px;\">基于API 10A规范设计的7322型高温高压稠化仪用于测试在不同井下环境中水泥的稠化性能。仪器设计以拥有实验室效率且操作简便为主要目的，7322的设计中的两大因素最大程度的减小了设备停机时间：试验之间的冷却时间和例行维护时间。这个畅销款型设计用于下列实验室应用：油井水泥的研究，开发水泥添加剂，水泥质量保障以及现场试验。</p><p class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; color: rgb(0, 0, 0); line-height: 22px;\"><strong>基于长期稳定性的工程优化</strong></p><p class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; color: rgb(0, 0, 0); line-height: 22px;\">重新设计的压力系统更易于维护，油雾收集模块大大减少油雾排放。磁耦合传动系统使浆杯驱动可靠性大大提升。由增压泵，压力传感系统和独特的毛细管压力释放系统组成的压力控制系统操作简便且稳定耐用。</p><p class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; color: rgb(0, 0, 0); line-height: 22px;\"><strong>操作简便、功能强大</strong></p><p style=\"color: rgb(71, 71, 71); font-family: &quot;Microsoft YaHei&quot;; font-size: 12px;\"><span class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; color: rgb(0, 0, 0); line-height: 22px;\">7322稠化仪不仅可以用于水泥稠化时间的标准测试，还可以用来为别的测试制备水泥浆，例如测量游离水，失水，粘度等等。7322还能通过接驳外置制冷装置来执行低温试验。</span></p><div><span class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; color: rgb(0, 0, 0); line-height: 22px;\"><p style=\"color: rgb(71, 71, 71); font-family: &quot;Microsoft YaHei&quot;; font-size: 12px;\"><img src=\"http://www.qiandele.com/images/cp/header-arrow.gif\" width=\"23\" height=\"23\" align=\"absmiddle\">&nbsp;<strong class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; color: rgb(0, 0, 0); line-height: 22px;\">性能指标</strong><br></p><p style=\"color: rgb(71, 71, 71); font-family: &quot;Microsoft YaHei&quot;; font-size: 12px;\"><strong>产品特性</strong></p><p class=\"zhengwen\" style=\"font-size: 12px; line-height: 22px;\">&nbsp;&nbsp;•&nbsp; 快速循环冷却<br>&nbsp;&nbsp;•&nbsp; 三笔记录仪<br>&nbsp;&nbsp;•&nbsp; 可编程稠度报警<br>&nbsp;&nbsp;•&nbsp; 模块化液压系统<br>&nbsp;&nbsp;•&nbsp; 高级油压控制系统<br>&nbsp;&nbsp;•&nbsp; 支持5270数据采集与系统控制软件<br>&nbsp;&nbsp;•&nbsp; 通过5270软件控制温度，压力<br>&nbsp;&nbsp;•&nbsp; 通过5270软件模拟间歇挤水泥<br>&nbsp;&nbsp;•&nbsp; 超温、超压自动停机<br>&nbsp;&nbsp;•&nbsp; 坚固耐用<br><br><strong>技术参数</strong></p><p class=\"zhengwen\" style=\"font-size: 12px; line-height: 22px;\">&nbsp;&nbsp;最高温度：400°F/204°C<br>&nbsp;&nbsp;最高压力：22,000 psi/150 MPa<br>&nbsp;&nbsp;加热器功率：2200 Watts<br>&nbsp;&nbsp;浆杯桶转速：150 rpm<br>&nbsp;&nbsp;稠度范围：0-100 Bc (Bearden Units)<br>&nbsp;&nbsp;操作温度：环境温度至120°F/50°C<br>&nbsp;&nbsp;停机再次运行时间：20分钟<br>&nbsp;&nbsp;压力介质：白矿物油<br>&nbsp;&nbsp;数据采集：三色条形记录仪、千德乐5270数据采集与控制系统<br>&nbsp;&nbsp;执行标准：API Spec 10A/ISO 10426-1<br>&nbsp;&nbsp;冷却水：20-80 psi / 150–600 kPa<br>&nbsp;&nbsp;压缩空气：50-100 psi/350 – 700 kPa<br>&nbsp;&nbsp;电源供应：220 VAC ±15% 50/60 Hz<br>&nbsp;&nbsp;设备尺寸：57×71×186 cm (W×D×H)<br>&nbsp;&nbsp;设备重量：259 Kg</p><p style=\"color: rgb(71, 71, 71); font-family: &quot;Microsoft YaHei&quot;; font-size: 12px;\"><img src=\"http://www.qiandele.com/images/cp/header-arrow.gif\" width=\"23\" height=\"23\" align=\"absmiddle\">&nbsp;<b>产品标准</b></p><p style=\"color: rgb(71, 71, 71); font-family: &quot;Microsoft YaHei&quot;; font-size: 12px;\"><span class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; color: rgb(0, 0, 0); line-height: 22px;\">API Spec 10A<br>ISO 10426-1</span></p><p style=\"color: rgb(71, 71, 71); font-family: &quot;Microsoft YaHei&quot;; font-size: 12px;\"><img src=\"http://www.qiandele.com/images/cp/header-arrow.gif\" width=\"23\" height=\"23\" align=\"absmiddle\"><b>资料下载</b>&nbsp; &nbsp; &nbsp; &nbsp;</p><table width=\"400\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-family: &quot;Microsoft YaHei&quot;; background-color: rgb(255, 255, 255);\"><tbody><tr class=\"zhengwen\" style=\"font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; line-height: 22px;\"><td width=\"75\"><img src=\"http://www.qiandele.com/Images/pdf.png\" width=\"50\" height=\"50\" align=\"left\"></td><td width=\"325\" colspan=\"2\" class=\"xz\" style=\"line-height: 15px;\"><a href=\"http://www.qiandele.com/down1/7322%E5%9E%8B%E9%AB%98%E6%B8%A9%E9%AB%98%E5%8E%8B%E7%A8%A0%E5%8C%96%E4%BB%AA.pdf\" style=\"color: rgb(0, 0, 0);\">7322型高温高压稠化仪<br>Model 7322 Single Cell Brochure</a></td></tr></tbody></table></span></div>', '[]', 1);
INSERT INTO `product` VALUES ('6BD769E822754893B82E5CF2D0411B33', 'test', '1', '1', 'test', NULL, 'test', 'content: 123451234567890', '[{\"original\":\"hello.txt\",\"size\":\"42948620KB\",\"name\":\"hello3.txt\",\"state\":\"SUCCESS\",\"lastModified\":\"Tue Aug 11 19:02:53 CST 2020\",\"type\":\".plain\",\"url\":\"http://timor:8080/upload/hello3.txt\"},{\"original\":\"7322型高温高压稠化仪.pdf\",\"size\":\"42948620KB\",\"name\":\"7322型高温高压稠化仪2.pdf\",\"state\":\"SUCCESS\",\"lastModified\":\"Tue Aug 11 19:02:53 CST 2020\",\"type\":\".pdf\",\"url\":\"http://timor:8080/upload/7322型高温高压稠化仪2.pdf\"}]', 1);
INSERT INTO `product` VALUES ('0D22DEEFE106441F8262CA316706A81A', 'test', '1', '1', 'test', NULL, 'test', 'content: 54321', '[{\"original\":\"hello.txt\",\"size\":\"42948620\",\"name\":\"hello3.txt\",\"state\":\"SUCCESS\",\"lastModified\":\"Tue Aug 11 19:02:53 CST 2020\",\"type\":\".plain\",\"url\":\"http://timor:8080/upload/hello3.txt\"},{\"original\":\"7322型高温高压稠化仪.pdf\",\"size\":\"42948620\",\"name\":\"7322型高温高压稠化仪2.pdf\",\"state\":\"SUCCESS\",\"lastModified\":\"Tue Aug 11 19:02:53 CST 2020\",\"type\":\".pdf\",\"url\":\"http://timor:8080/upload/7322型高温高压稠化仪2.pdf\"}]', 1);
INSERT INTO `product` VALUES ('D4EDE9C7246A49EFAF6E9DD240C0F10B', 'test', '1', '1', 'test', NULL, 'test', 'content: 12345', '[]', 1);
INSERT INTO `product` VALUES ('D982B2BE469043F285C270ABCBE3D178', '123', '1', '1', 'test2312313', NULL, 'test213', '<p>content: 12345</p><p><br></p><p><br></p><p><img src=\"http://local.timor.com:8080/upload/处理器信息.png\" style=\"width: 910px;\"><br></p>', '[{\"original\":\"第1章 绪论.doc\",\"size\":75264,\"name\":\"第1章 绪论.doc\",\"state\":\"SUCCESS\",\"lastModified\":\"Sat Aug 15 10:26:57 CST 2020\",\"type\":\".msword\",\"url\":\"http://local.timor.com:8080/upload/第1章 绪论.doc\"}]', 1);
INSERT INTO `product` VALUES ('AA9FF520BB7F4588B6C6D8CF6EF98A31', 'beautiful', '1', '1', 'test', 'http://timor:8080/upload/2531170_184803119000_2.jpg', 'test', 'content: 1234509876', '[{\"original\":\"7322型高温高压稠化仪.pdf\",\"size\":42948620288,\"name\":\"7322型高温高压稠化仪3.pdf\",\"state\":\"SUCCESS\",\"lastModified\":\"Tue Aug 11 19:56:01 CST 2020\",\"type\":\".pdf\",\"url\":\"http://timor:8080/upload/7322型高温高压稠化仪3.pdf\"},{\"original\":\"hello.txt\",\"size\":42948620288,\"name\":\"hello4.txt\",\"state\":\"SUCCESS\",\"lastModified\":\"Tue Aug 11 19:56:01 CST 2020\",\"type\":\".plain\",\"url\":\"http://timor:8080/upload/hello4.txt\"}]', 1);

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
INSERT INTO `product_category` VALUES ('A6E64F68DA464A50B53FC6E8A911BAD0', '321', '321', 1);
INSERT INTO `product_category` VALUES ('034E92FF03B04B8B8A1BD205226F59E4', '123', '123', 1);
INSERT INTO `product_category` VALUES ('3FCC9B34520648CDA0047A16DE5DB1C7', '123', '123', 1);

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
INSERT INTO `product_type` VALUES ('3', 'xxx实验仪3', '2', '这是实验仪描述3', 1);
INSERT INTO `product_type` VALUES ('5', 'xxx实验仪5', '3', '这是实验仪描述5', 1);
INSERT INTO `product_type` VALUES ('C817AC199808466C949E6756CE64E7B0', '321', '034E92FF03B04B8B8A1BD205226F59E4', '1231234', 1);
INSERT INTO `product_type` VALUES ('7', 'xxx实验仪7', '4', '这是实验仪描述7', 1);

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
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) NULL DEFAULT 0 COMMENT '上级机构',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门/11111',
  `code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构编码',
  `sort` int(11) NULL DEFAULT 0 COMMENT '序号',
  `realName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `tel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人电话',
  `remark` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构描述',
  `updateTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `updateId` int(11) NULL DEFAULT 0 COMMENT '更新者',
  `createTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `createId` int(11) NULL DEFAULT 0 COMMENT '创建者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES (1, 0, '深山飞雨', NULL, 99, NULL, NULL, NULL, '2017-11-30 14:45:18', 1, '2016-06-06 06:06:06', 1);
INSERT INTO `sys_department` VALUES (44, 1, '研发部', NULL, 10, NULL, NULL, NULL, '2017-11-30 14:39:22', 1, '2017-11-30 14:39:22', 1);
INSERT INTO `sys_department` VALUES (45, 1, '资源部', NULL, 20, NULL, NULL, NULL, '2017-11-30 14:41:46', 1, '2017-11-30 14:41:46', 1);
INSERT INTO `sys_department` VALUES (46, 1, '行政', NULL, 30, NULL, NULL, NULL, '2017-11-30 14:45:03', 1, '2017-11-30 14:45:03', 1);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典id',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典名',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典值',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序序号',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `fixed` int(255) NOT NULL DEFAULT 0 COMMENT '类型是否可改变（0：可变；1：不可变）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1001', '1221', '暂存', '0', 2, '暂存产品信息', 0);
INSERT INTO `sys_dict` VALUES ('B40915AF73934F90BFFB303ED928B7E1', '1', '1', '1', 1, '1', 1);
INSERT INTO `sys_dict` VALUES ('1002', '1221', '发布', '1', 1, '发布产品', 0);
INSERT INTO `sys_dict` VALUES ('1003', '1221', '禁用', '2', 3, '禁止外界查看资料', 0);
INSERT INTO `sys_dict` VALUES ('B77CE7C938B341FF9C1D7156933789C5', '5FD824215DA0496F9D54A53A50525A22', '1', '1', 1, '1', 1);

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型名',
  `typeName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(1) NULL DEFAULT 0 COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1221', '产品', 'product', '产品……的字典', 0, '', NULL, '', NULL);
INSERT INTO `sys_dict_type` VALUES ('5FD824215DA0496F9D54A53A50525A22', '测试_添加_100', 'test_add_100', '测试字典', 0, '', NULL, '', NULL);
INSERT INTO `sys_dict_type` VALUES ('C7A03C18DD324AE3AEE7C99DD7EC6D6E', '测试_添加_122', '测试_添加_120', '测试222111', 1, '', NULL, '', NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parentId` int(11) NOT NULL DEFAULT 0 COMMENT '父id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '名称/11111',
  `urlKey` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单key',
  `url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `status` int(11) NULL DEFAULT 1 COMMENT '状态//radio/2,隐藏,1,显示',
  `type` int(11) NULL DEFAULT 1 COMMENT '类型//select/1,根目录,2,a标签,3,a标签_blank,4,外部url',
  `sort` int(11) NULL DEFAULT 1 COMMENT '排序',
  `level` int(11) NULL DEFAULT 1 COMMENT '级别',
  `createTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `createId` int(11) NULL DEFAULT 0 COMMENT '创建者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', 'system_root', NULL, 1, 1, 90, 1, '2015-04-27 17:28:06', 1);
INSERT INTO `sys_menu` VALUES (2, 1, '组织机构', 'department', 'system/department', 1, 1, 91, 2, '2015-04-27 17:28:25', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '用户管理', 'user', 'system/user', 1, 1, 92, 2, '2015-04-27 17:28:46', 1);
INSERT INTO `sys_menu` VALUES (4, 1, '角色管理', 'role', 'system/role', 1, 1, 94, 2, '2015-04-27 17:29:13', 1);
INSERT INTO `sys_menu` VALUES (5, 1, '菜单管理', 'menu', 'system/menu', 1, 1, 96, 2, '2015-04-27 17:29:43', 1);
INSERT INTO `sys_menu` VALUES (6, 1, '数据字典', 'dict', 'system/dict', 1, 1, 97, 2, '2015-04-27 17:30:05', 1);
INSERT INTO `sys_menu` VALUES (14, 1, '日志管理', 'log', 'system/log/list', 1, 1, 98, 2, '2016-01-03 18:09:18', 1);
INSERT INTO `sys_menu` VALUES (30, 0, '任务管理', 'job', NULL, 1, 1, 2, 1, '2017-06-01 09:51:36', 1);
INSERT INTO `sys_menu` VALUES (31, 30, '时间规则', 'job_times', 'quartz/times/list', 2, 1, 3, 2, '2017-06-01 09:53:57', 1);
INSERT INTO `sys_menu` VALUES (32, 30, '触发器', 'job_tigger', 'quartz/trigger/list', 2, 1, 4, 2, '2017-06-01 09:54:53', 1);
INSERT INTO `sys_menu` VALUES (33, 30, '执行类', 'job_class', 'quartz/jobclass/list', 1, 1, 5, 2, '2017-06-01 09:55:59', 1);
INSERT INTO `sys_menu` VALUES (34, 30, 'job任务', 'job_jobs', 'quartz/jobs/list', 1, 1, 6, 2, '2017-06-01 09:57:00', 1);
INSERT INTO `sys_menu` VALUES (35, 30, '执行日志', 'job_log', 'quartz/log/list', 1, 1, 7, 2, '2017-07-05 10:45:38', 1);
INSERT INTO `sys_menu` VALUES (36, 0, '一元精品区', 'vpn', 'http://www.yxyun.win', 1, 4, 30, 1, '2017-11-06 14:33:21', 1);
INSERT INTO `sys_menu` VALUES (39, 1, '系统权限', 'auth', 'system/sysauth', 1, 1, 99, 2, '2017-11-29 16:04:17', 1);
INSERT INTO `sys_menu` VALUES (40, 0, '1234', '3124', '1324', 1, 1, 1234, 1, '2018-04-25 15:35:13', 18);
INSERT INTO `sys_menu` VALUES (41, 36, '挨打', '案例库', '啊', 1, 1, 1, 2, '2018-06-02 15:51:31', 18);
INSERT INTO `sys_menu` VALUES (42, 0, '3434', '43343434', '34343434', 1, 1, NULL, 1, '2018-06-02 15:52:10', 18);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
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
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1001', '首页', 1, '首页', '1001', '2020-02-08 20:06:39', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1002', '用户登录', 1, '用户登录', '1002', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1003', '用户注册', 1, '用户注册', '1003', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1004', '获取用户信息', 1, '获取用户信息', '1004', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1005', '获取用户通知', 1, '获取用户通知', '1005', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1006', '获取加入队伍', 1, '获取加入队伍', '1006', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1008', '修改用户信息', 1, '修改用户信息', '1008', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1009', '获取板块信息', 1, '获取板块信息', '1009', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1010', '添加一篇板块', 1, '添加一篇板块', '1010', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1011', '更新一篇板块', 1, '更新一篇板块', '1011', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1012', '删除一篇板块', 1, '删除一篇板块', '1012', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1013', '获取所有板块信息', 1, '获取所有板块信息', '1013', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1014', '获取所有板块的文章', 1, '获取所有板块的文章', '1014', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1015', '获取文章信息', 1, '获取文章信息', '1015', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1016', '添加一篇文章', 1, '添加一篇文章', '1016', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1017', '更新一篇文章', 1, '更新一篇文章', '1017', '2020-02-08 21:56:43', '1122', 1);
INSERT INTO `sys_permission` VALUES ('1018', '删除一篇文章', 1, '删除一篇文章', '1018', '2020-02-08 21:56:43', '1122', 11);
INSERT INTO `sys_permission` VALUES ('1019', '获取板块的文章', 1, '获取板块的文章', '1019', '2020-02-08 21:56:43', '1122', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `sort` int(255) NULL DEFAULT NULL COMMENT '排序',
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `creatorId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者（系统/超级管理员）',
  `status` int(11) NOT NULL COMMENT '角色状态（0：禁用；1：启用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1010 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1001, '游客', '只是谁便看看', NULL, '2020-02-08 18:59:01', '1122', 1);
INSERT INTO `sys_role` VALUES (1002, '用户', '平台基础用户', NULL, '2020-02-08 18:59:30', '1122', 1);
INSERT INTO `sys_role` VALUES (1003, '会员', '平台普通会员', NULL, '2020-02-08 19:01:09', '1122', 1);
INSERT INTO `sys_role` VALUES (1004, '高级会员', '平台高级会员', NULL, '2020-02-08 20:14:44', '1122', 1);
INSERT INTO `sys_role` VALUES (1005, '测试人员', '平台测试人员', NULL, '2020-02-08 19:01:13', '1122', 1);
INSERT INTO `sys_role` VALUES (1006, '运维人员', '平台运维人员', NULL, '2020-02-08 19:01:53', '1122', 1);
INSERT INTO `sys_role` VALUES (1007, '体验账号', '给外界人员使用的体验账号', NULL, '2020-02-08 19:02:56', '1122', 1);
INSERT INTO `sys_role` VALUES (1008, '管理员', '普通管理员', NULL, '2020-02-08 19:03:50', '1122', 1);
INSERT INTO `sys_role` VALUES (1009, '超级管理员', '除了系统老大，我就是皇帝！哈哈哈哈！', NULL, '2020-02-08 19:04:44', '1122', 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  `menuId` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 162 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (133, 12, 30);
INSERT INTO `sys_role_menu` VALUES (134, 12, 33);
INSERT INTO `sys_role_menu` VALUES (135, 12, 34);
INSERT INTO `sys_role_menu` VALUES (136, 12, 35);
INSERT INTO `sys_role_menu` VALUES (137, 12, 36);
INSERT INTO `sys_role_menu` VALUES (138, 12, 1);
INSERT INTO `sys_role_menu` VALUES (139, 12, 2);
INSERT INTO `sys_role_menu` VALUES (140, 12, 3);
INSERT INTO `sys_role_menu` VALUES (141, 12, 4);
INSERT INTO `sys_role_menu` VALUES (142, 12, 5);
INSERT INTO `sys_role_menu` VALUES (143, 12, 6);
INSERT INTO `sys_role_menu` VALUES (144, 12, 14);
INSERT INTO `sys_role_menu` VALUES (145, 12, 39);
INSERT INTO `sys_role_menu` VALUES (146, 11, 30);
INSERT INTO `sys_role_menu` VALUES (147, 11, 33);
INSERT INTO `sys_role_menu` VALUES (148, 11, 34);
INSERT INTO `sys_role_menu` VALUES (149, 11, 35);
INSERT INTO `sys_role_menu` VALUES (150, 11, 36);
INSERT INTO `sys_role_menu` VALUES (151, 11, 1);
INSERT INTO `sys_role_menu` VALUES (152, 11, 3);
INSERT INTO `sys_role_menu` VALUES (153, 11, 5);
INSERT INTO `sys_role_menu` VALUES (154, 11, 14);
INSERT INTO `sys_role_menu` VALUES (155, 10, 30);
INSERT INTO `sys_role_menu` VALUES (156, 10, 33);
INSERT INTO `sys_role_menu` VALUES (157, 10, 34);
INSERT INTO `sys_role_menu` VALUES (158, 10, 35);
INSERT INTO `sys_role_menu` VALUES (159, 10, 36);
INSERT INTO `sys_role_menu` VALUES (160, 10, 1);
INSERT INTO `sys_role_menu` VALUES (161, 10, 14);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `roleId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  `permissionId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, '1009', '1001');
INSERT INTO `sys_role_permission` VALUES (2, '1009', '1002');
INSERT INTO `sys_role_permission` VALUES (3, '1109', '1003');
INSERT INTO `sys_role_permission` VALUES (4, '1009', '1004');
INSERT INTO `sys_role_permission` VALUES (5, '1009', '1014');
INSERT INTO `sys_role_permission` VALUES (6, '1009', '1006');
INSERT INTO `sys_role_permission` VALUES (8, '1009', '1008');
INSERT INTO `sys_role_permission` VALUES (9, '1009', '1009');
INSERT INTO `sys_role_permission` VALUES (10, '1009', '1010');
INSERT INTO `sys_role_permission` VALUES (11, '1009', '1011');
INSERT INTO `sys_role_permission` VALUES (12, '1009', '1012');
INSERT INTO `sys_role_permission` VALUES (13, '1009', '1013');
INSERT INTO `sys_role_permission` VALUES (14, '1009', '1003');
INSERT INTO `sys_role_permission` VALUES (15, '1009', '1015');
INSERT INTO `sys_role_permission` VALUES (16, '1009', '1016');
INSERT INTO `sys_role_permission` VALUES (17, '1009', '1017');
INSERT INTO `sys_role_permission` VALUES (18, '1009', '1018');
INSERT INTO `sys_role_permission` VALUES (28, '1009', '1019');
INSERT INTO `sys_role_permission` VALUES (20, '1001', '1001');
INSERT INTO `sys_role_permission` VALUES (21, '1001', '1002');
INSERT INTO `sys_role_permission` VALUES (22, '1001', '1003');
INSERT INTO `sys_role_permission` VALUES (23, '1001', '1009');
INSERT INTO `sys_role_permission` VALUES (24, '1001', '1013');
INSERT INTO `sys_role_permission` VALUES (25, '1001', '1014');
INSERT INTO `sys_role_permission` VALUES (26, '1001', '1015');
INSERT INTO `sys_role_permission` VALUES (27, '1001', '1019');

-- ----------------------------
-- Table structure for sys_service
-- ----------------------------
DROP TABLE IF EXISTS `sys_service`;
CREATE TABLE `sys_service`  (
  `id` int(11) NOT NULL,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_service
-- ----------------------------
INSERT INTO `sys_service` VALUES (1001, '首页', '/', '访问首页');
INSERT INTO `sys_service` VALUES (1002, '用户登录', '/user/login', '用户登录');
INSERT INTO `sys_service` VALUES (1003, '用户注册', '/user/register', '用户注册');
INSERT INTO `sys_service` VALUES (1004, '获取用户信息', '/user/info', '获取用户信息');
INSERT INTO `sys_service` VALUES (1005, '获取用户通知', '/user/mail', '获取用户通知');
INSERT INTO `sys_service` VALUES (1006, '获取加入队伍', '/user/groups', '获取加入队伍');
INSERT INTO `sys_service` VALUES (1008, '修改用户信息', '/user/modify', '修改用户信息');
INSERT INTO `sys_service` VALUES (1009, '获取板块信息', '/modular/get', '获取板块信息');
INSERT INTO `sys_service` VALUES (1010, '添加一篇板块', '/modular/add', '添加一篇板块');
INSERT INTO `sys_service` VALUES (1011, '更新一篇板块', '/modular/update', '更新一篇板块');
INSERT INTO `sys_service` VALUES (1012, '删除一篇板块', '/modular/delete', '删除一篇板块');
INSERT INTO `sys_service` VALUES (1013, '获取所有板块信息', '/modular/list', '获取所有板块信息');
INSERT INTO `sys_service` VALUES (1014, '获取所有板块的文章', '/modular/getArticles', '获取所有板块的板块');
INSERT INTO `sys_service` VALUES (1015, '获取文章信息', '/article/get', '获取文章信息');
INSERT INTO `sys_service` VALUES (1016, '添加一篇文章', '/article/add', '添加一篇文章');
INSERT INTO `sys_service` VALUES (1017, '更新一篇文章', '/article/update', '更新一篇文章');
INSERT INTO `sys_service` VALUES (1018, '删除一篇文章', '/article/delete', '删除获取板块的文章一篇文章');
INSERT INTO `sys_service` VALUES (1019, '获取板块的文章', '/article/list', '获取板块下的文章');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `username` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `status` int(11) NOT NULL COMMENT '账户状态（0：未激活；1：启用；2：锁定；3：禁用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1221', 'test', '123456', 1);
INSERT INTO `sys_user` VALUES ('1122', 'admin', '123456', 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL,
  `userId` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `roleId` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, '1221', '1009');
INSERT INTO `sys_user_role` VALUES (2, 'visitor', '1001');

-- ----------------------------
-- View structure for view_gen_table_col
-- ----------------------------
DROP VIEW IF EXISTS `view_gen_table_col`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `view_gen_table_col` AS select `gtc`.`javaField` AS `name`,`gtc`.`listWidth` AS `width`,`gtc`.`listFormat` AS `formatter`,`gtc`.`comment` AS `title`,if((`gtc`.`isListDefaultHide` = 1),1,0) AS `visible`,`gtc`.`listAlign` AS `align`,(`gtc`.`listSort` > 0) AS `sortable`,if((`gtc`.`listSort` - 2),'desc','asc') AS `order` from `gen_table_col` `gtc` where ((`gtc`.`tableId` = '46349DA02F7E4EF5AD298D1BEA0CD4AA') and (`gtc`.`isListHide` <> 1));

SET FOREIGN_KEY_CHECKS = 1;
