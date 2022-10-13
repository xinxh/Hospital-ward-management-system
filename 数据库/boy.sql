/*
 Navicat MySQL Data Transfer

 Source Server         : zh
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : boy

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 13/10/2022 09:50:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed`  (
  `bno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '床位编号',
  `mno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病房编号',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '床位状态',
  PRIMARY KEY (`bno`) USING BTREE,
  INDEX `mno`(`mno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES ('101-1', '101', '未分配');
INSERT INTO `bed` VALUES ('101-2', '101', '未分配');
INSERT INTO `bed` VALUES ('101-3', '101', '未分配');
INSERT INTO `bed` VALUES ('101-4', '101', '未分配');
INSERT INTO `bed` VALUES ('102-1', '102', '未分配');
INSERT INTO `bed` VALUES ('102-2', '102', '已分配');
INSERT INTO `bed` VALUES ('102-3', '102', '未分配');
INSERT INTO `bed` VALUES ('102-4', '102', '未分配');
INSERT INTO `bed` VALUES ('103-1', '103', '已分配');
INSERT INTO `bed` VALUES ('103-2', '103', '未分配');
INSERT INTO `bed` VALUES ('103-3', '103', '未分配');
INSERT INTO `bed` VALUES ('103-4', '103', '已分配');
INSERT INTO `bed` VALUES ('105-1', '105', '未分配');
INSERT INTO `bed` VALUES ('201-1', '201', '未分配');
INSERT INTO `bed` VALUES ('201-2', '201', '未分配');
INSERT INTO `bed` VALUES ('201-3', '201', '已分配');
INSERT INTO `bed` VALUES ('201-4', '201', '未分配');
INSERT INTO `bed` VALUES ('202-2', '202', '已分配');
INSERT INTO `bed` VALUES ('203-1', '203', '未分配');
INSERT INTO `bed` VALUES ('203-2', '203', '未分配');
INSERT INTO `bed` VALUES ('204-1', '204', '未分配');
INSERT INTO `bed` VALUES ('204-2', '204', '已分配');
INSERT INTO `bed` VALUES ('204-3', '204', '未分配');
INSERT INTO `bed` VALUES ('301-1', '301', '未分配');
INSERT INTO `bed` VALUES ('301-2', '301', '已分配');
INSERT INTO `bed` VALUES ('302-1', '302', '未分配');
INSERT INTO `bed` VALUES ('302-2', '302', '未分配');
INSERT INTO `bed` VALUES ('303-1', '303', '未分配');
INSERT INTO `bed` VALUES ('304-1', '304', '未分配');

-- ----------------------------
-- Table structure for cure
-- ----------------------------
DROP TABLE IF EXISTS `cure`;
CREATE TABLE `cure`  (
  `cname` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '治疗方案',
  `pno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病人编号',
  PRIMARY KEY (`pno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cure
-- ----------------------------
INSERT INTO `cure` VALUES ('多喝热水', 'p001');
INSERT INTO `cure` VALUES ('1．减充血剂\r\n\r\n该类药物可以使感冒患者肿胀的 鼻黏膜和鼻窦的血管收缩，有助于缓解感冒引起的鼻塞、流涕和打喷嚏等症状', 'p002');
INSERT INTO `cure` VALUES ('1、化疗\r\n这种强力的药物能阻止癌症扩散，使癌细胞生长缓慢，甚至杀死癌细胞。但是会引起副作用，因为它会杀死体内快速生长的细胞，包括血液、口腔、消化系统和毛囊中的细胞。\r\n目前有超过100种不同类型的化疗药物，你的医生会为你选择最适合你癌症类型的药物。你可以把它当成药片或胶囊，在皮肤上擦成膏状物，或者在家里或医院里注射。', 'p003');
INSERT INTO `cure` VALUES ('一般治疗：主要为卧床休息、禁食，给予水、电解质和热量的 静脉 输入等。', 'p004');
INSERT INTO `cure` VALUES ('二、牵引治疗\r\n\r\n牵引疗法是治疗腰椎间盘突出症的一种传统的治疗方法，也是保守治疗经常使用的方法之一。其治疗机制是通过压力的改变或屈曲旋转受力的作用：a、使突出物还纳或者部分还纳减轻神经根压迫症状；b、松懈粘连的神经根c、缓解肌肉痉挛d、改变突出物与神经根空间的位置。', 'p005');
INSERT INTO `cure` VALUES ('患者可以基于药物治疗，结合发病关节位置、性质，合理选择对应的物理治疗措施，以缓解关节炎症状，促进关节功能的恢复。 免疫及生物治疗 这一治疗措施主要是作用于细胞因子的靶分子治疗、免疫净化/重建、血浆置换等，可用于风湿性关节炎等治疗难度大，且病情发展迅速的关节炎。', 'p006');
INSERT INTO `cure` VALUES ('1．减充血剂\r\n\r\n该类药物可以使感冒患者肿胀的 鼻黏膜和鼻窦的血管收缩，有助于缓解感冒引起的鼻塞、流涕和打喷嚏等症状', 'p007');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `dno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生编号',
  `dname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生姓名',
  `dsex` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生性别',
  `dage` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生年龄',
  `career` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生职称',
  `contact` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生联系方式',
  `ono` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生科室',
  PRIMARY KEY (`dno`) USING BTREE,
  INDEX `i_1ono`(`ono`) USING BTREE,
  INDEX `dname`(`dname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('d000', '李四', '男', '20', '主人', '15265985623', 'k002');
INSERT INTO `doctor` VALUES ('d001', '张昊', '男', '22', '投资人', '15024295686', 'k002');
INSERT INTO `doctor` VALUES ('d002', '王建', '男', '21', '副院长', '15264895566', 'k001');
INSERT INTO `doctor` VALUES ('d003', '王宇然', '男', '21', '院长', '13451335614', 'k002');
INSERT INTO `doctor` VALUES ('d004', '卢振宇', '男', '21', '主任', '15848333345', 'k003');
INSERT INTO `doctor` VALUES ('d005', '王四', '男', '22', '主治大夫', '15848787345', 'k005');
INSERT INTO `doctor` VALUES ('d006', '王五', '男', '68', '副主任', '15847773345', 'k006');
INSERT INTO `doctor` VALUES ('d007', '李三', '男', '46', '主治大夫', '15848333345', 'k007');
INSERT INTO `doctor` VALUES ('d008', '李四', '男', '35', '主治大夫', '15848333345', 'k008');
INSERT INTO `doctor` VALUES ('d009', '李五', '男', '70', '主治大夫', '15848333345', 'k001');
INSERT INTO `doctor` VALUES ('d010', '赵三', '男', '50', '主治大夫', '15848333345', 'k002');
INSERT INTO `doctor` VALUES ('d011', '赵四', '男', '55', '主治大夫', '15848333345', 'k003');
INSERT INTO `doctor` VALUES ('d012', '赵五', '男', '46', '主治大夫', '15848333345', 'k004');
INSERT INTO `doctor` VALUES ('d013', '高三', '男', '78', '主治大夫', '15848333345', 'k005');
INSERT INTO `doctor` VALUES ('d014', '高四', '男', '54', '主治大夫', '15848333345', 'k006');
INSERT INTO `doctor` VALUES ('d015', '高五', '男', '45', '主治大夫', '15848333345', 'k007');

-- ----------------------------
-- Table structure for doctor_scheduling
-- ----------------------------
DROP TABLE IF EXISTS `doctor_scheduling`;
CREATE TABLE `doctor_scheduling`  (
  `dno_scheduling` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生编号',
  `dname_scheduling` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生名字',
  `time` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排班时间',
  PRIMARY KEY (`dno_scheduling`) USING BTREE,
  INDEX `dname_scheduling`(`dname_scheduling`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor_scheduling
-- ----------------------------
INSERT INTO `doctor_scheduling` VALUES ('d001', '张昊', '');
INSERT INTO `doctor_scheduling` VALUES ('d002', '张四', '星期三');
INSERT INTO `doctor_scheduling` VALUES ('d003', '张五', '星期五');
INSERT INTO `doctor_scheduling` VALUES ('d004', '王三', '星期一');
INSERT INTO `doctor_scheduling` VALUES ('d005', '王四', '星期二');
INSERT INTO `doctor_scheduling` VALUES ('d006', '王五', '星期五');
INSERT INTO `doctor_scheduling` VALUES ('d007', '李三', '星期二');
INSERT INTO `doctor_scheduling` VALUES ('d008', '李四', '星期四');
INSERT INTO `doctor_scheduling` VALUES ('d009', '张五', '星期五');
INSERT INTO `doctor_scheduling` VALUES ('d010', '赵三', '星期一');
INSERT INTO `doctor_scheduling` VALUES ('d011', '赵四', '星期三');
INSERT INTO `doctor_scheduling` VALUES ('d012', '赵五', '星期四');
INSERT INTO `doctor_scheduling` VALUES ('d013', '高三', '星期二');
INSERT INTO `doctor_scheduling` VALUES ('d014', '高四', '星期四');
INSERT INTO `doctor_scheduling` VALUES ('d015', '高五', '星期五');

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark`  (
  `mno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病房编号',
  `mname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病房名称',
  PRIMARY KEY (`mno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES ('101', '101');
INSERT INTO `mark` VALUES ('102', '102');
INSERT INTO `mark` VALUES ('103', '103');
INSERT INTO `mark` VALUES ('104', '104');
INSERT INTO `mark` VALUES ('105', '105');
INSERT INTO `mark` VALUES ('201', '201');
INSERT INTO `mark` VALUES ('202', '202');
INSERT INTO `mark` VALUES ('203', '203');
INSERT INTO `mark` VALUES ('204', '204');
INSERT INTO `mark` VALUES ('301', '301');
INSERT INTO `mark` VALUES ('302', '302');
INSERT INTO `mark` VALUES ('303', '303');
INSERT INTO `mark` VALUES ('304', '304');

-- ----------------------------
-- Table structure for nurse
-- ----------------------------
DROP TABLE IF EXISTS `nurse`;
CREATE TABLE `nurse`  (
  `nno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '护士编号',
  `nname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护士姓名',
  `nsex` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护士性别',
  `mno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属病房号',
  `nage` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护士年龄',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护士联系方式',
  `career` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护士职称',
  PRIMARY KEY (`nno`) USING BTREE,
  INDEX `mno`(`mno`) USING BTREE,
  INDEX `nno`(`nno`, `nname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of nurse
-- ----------------------------
INSERT INTO `nurse` VALUES ('n001', '张三', '男', '101', '20', '14984984', '普通护士');
INSERT INTO `nurse` VALUES ('n002', '张二', '女', '101', '20', '12345678901', '普通护士');
INSERT INTO `nurse` VALUES ('n003', '小麦', '男', '102', '20', '12345678900', '普通护士');
INSERT INTO `nurse` VALUES ('n004', '小红', '女', '102', '20', '12345678300', '普通护士');
INSERT INTO `nurse` VALUES ('n005', '小王', '男', '103', '20', '12349678900', '副主任护士');
INSERT INTO `nurse` VALUES ('n006', '小猪', '女', '103', '20', '12545678900', '普通护士');
INSERT INTO `nurse` VALUES ('n007', '小扎', '男', '104', '20', '12345378900', '普通护士');
INSERT INTO `nurse` VALUES ('n008', '小店', '女', '104', '20', '12845678900', '普通护士');
INSERT INTO `nurse` VALUES ('n009', '小明', '男', '201', '20', '12345678980', '普通护士');
INSERT INTO `nurse` VALUES ('n010', '小马', '女', '201', '20', '12345678900', '普通护士');
INSERT INTO `nurse` VALUES ('n011', '小美', '男', '202', '20', '12345678905', '主管护士');
INSERT INTO `nurse` VALUES ('n012', '小猫', '女', '102', '20', '12345678970', '普通护士');
INSERT INTO `nurse` VALUES ('n013', '小东', '男', '203', '20', '12345678980', '普通护士');
INSERT INTO `nurse` VALUES ('n014', '夏普', '女', '203', '20', '12345678950', '普通护士');
INSERT INTO `nurse` VALUES ('n015', '达到', '男', '204', '20', '12345678940', '普通护士');
INSERT INTO `nurse` VALUES ('n016', '张高', '女', '204', '20', '12345678910', '普通护士');
INSERT INTO `nurse` VALUES ('n017', '张发', '男', '301', '20', '12345678920', '普通护士');
INSERT INTO `nurse` VALUES ('n018', '张但', '女', '302', '20', '12345678930', '普通护士');
INSERT INTO `nurse` VALUES ('n019', '张补', '男', '303', '20', '12345678940', '普通护士');
INSERT INTO `nurse` VALUES ('n020', '张胡', '女', '304', '20', '12345678950', '普通护士');

-- ----------------------------
-- Table structure for nurse_scheduling
-- ----------------------------
DROP TABLE IF EXISTS `nurse_scheduling`;
CREATE TABLE `nurse_scheduling`  (
  `nno_scheduling` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '护士编号',
  `nname_scheduling` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '护士名字',
  `time` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排班时间',
  PRIMARY KEY (`nno_scheduling`) USING BTREE,
  INDEX `nno_scheduling`(`nno_scheduling`, `nname_scheduling`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nurse_scheduling
-- ----------------------------
INSERT INTO `nurse_scheduling` VALUES ('n001', '张三', '星期一');
INSERT INTO `nurse_scheduling` VALUES ('n002', '张二', '星期一');
INSERT INTO `nurse_scheduling` VALUES ('n003', '小麦', '星期一');
INSERT INTO `nurse_scheduling` VALUES ('n004', '小红', '星期一');
INSERT INTO `nurse_scheduling` VALUES ('n005', '小王', '星期二');
INSERT INTO `nurse_scheduling` VALUES ('n006', '小猪', '星期二');
INSERT INTO `nurse_scheduling` VALUES ('n007', '小扎', '星期二');
INSERT INTO `nurse_scheduling` VALUES ('n008', '小店', '星期二');
INSERT INTO `nurse_scheduling` VALUES ('n009', '小明', '星期三');
INSERT INTO `nurse_scheduling` VALUES ('n010', '小马', '星期三');
INSERT INTO `nurse_scheduling` VALUES ('n011', '小美', '星期三');
INSERT INTO `nurse_scheduling` VALUES ('n012', '小猫', '星期三');
INSERT INTO `nurse_scheduling` VALUES ('n013', '小东', '星期四');
INSERT INTO `nurse_scheduling` VALUES ('n014', '夏普', '星期四');
INSERT INTO `nurse_scheduling` VALUES ('n015', '达到', '星期五');
INSERT INTO `nurse_scheduling` VALUES ('n016', '张高', '星期五');
INSERT INTO `nurse_scheduling` VALUES ('n017', '张发', '星期六');
INSERT INTO `nurse_scheduling` VALUES ('n018', '张但', '星期六');
INSERT INTO `nurse_scheduling` VALUES ('n019', '张补', '星期日');
INSERT INTO `nurse_scheduling` VALUES ('n020', '张胡', '星期日');

-- ----------------------------
-- Table structure for office
-- ----------------------------
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office`  (
  `ono` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `oname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ono`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of office
-- ----------------------------
INSERT INTO `office` VALUES ('k001', '内科');
INSERT INTO `office` VALUES ('k002', '外科');
INSERT INTO `office` VALUES ('k003', '妇科');
INSERT INTO `office` VALUES ('k004', '儿科');
INSERT INTO `office` VALUES ('k005', '辅助检查科室');
INSERT INTO `office` VALUES ('k006', '精神科');
INSERT INTO `office` VALUES ('k007', '五官科');
INSERT INTO `office` VALUES ('k008', '肛肠科');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `pno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病人编号',
  `pname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病人姓名',
  `psex` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病人性别',
  `mno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病人所住病房',
  `page` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病人年龄',
  `bno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病人的病床编号',
  `dno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主治医生编号',
  `nno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '护士编号',
  `sicken` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '患病',
  PRIMARY KEY (`pno`) USING BTREE,
  INDEX `mno`(`mno`) USING BTREE,
  INDEX `patient_ibfk_2`(`bno`) USING BTREE,
  INDEX `patient_ibfk_3`(`dno`) USING BTREE,
  INDEX `patient_ibfk_4`(`nno`) USING BTREE,
  INDEX `pname`(`pname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('p001', '张楠', '男', '102', '25', '102-2', 'd001', 'n004', '感冒');
INSERT INTO `patient` VALUES ('p002', '莉莉', '女', '103', '26', '103-1', 'd001', 'n004', '重感冒');
INSERT INTO `patient` VALUES ('p003', '李承', '男', '103', '27', '103-4', 'd001', 'n005', '癌症');
INSERT INTO `patient` VALUES ('p004', '张美', '女', '201', '40', '201-3', 'd004', 'n006', '阑尾切除');
INSERT INTO `patient` VALUES ('p005', '李四', '男', '202', '20', '202-2', 'd006', 'n009', '腰椎病');
INSERT INTO `patient` VALUES ('p006', '李来', '男', '204', '30', '204-2', 'd007', 'n012', '关节炎');
INSERT INTO `patient` VALUES ('p007', '王灵', '女', '301', '40', '301-2', 'd008', 'n015', '感冒');

-- ----------------------------
-- Table structure for surplus
-- ----------------------------
DROP TABLE IF EXISTS `surplus`;
CREATE TABLE `surplus`  (
  `pno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `pname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `surplus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前余额',
  `bno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '床位号',
  PRIMARY KEY (`pno`) USING BTREE,
  INDEX `pname`(`pname`) USING BTREE,
  INDEX `bno`(`bno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of surplus
-- ----------------------------
INSERT INTO `surplus` VALUES ('p001', '张楠', '330', '101-3');
INSERT INTO `surplus` VALUES ('p002', '莉莉', '20', '102-2');
INSERT INTO `surplus` VALUES ('p003', '李承', '27', '103-1');
INSERT INTO `surplus` VALUES ('p004', '张美', '40', '103-4');
INSERT INTO `surplus` VALUES ('p005', '李四', '20', '201-3');
INSERT INTO `surplus` VALUES ('p006', '李来', '30', '202-2');
INSERT INTO `surplus` VALUES ('p007', '王灵', '40', '204-2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1');
INSERT INTO `user` VALUES ('d000', '1');
INSERT INTO `user` VALUES ('d001', '1');
INSERT INTO `user` VALUES ('d002', '1');
INSERT INTO `user` VALUES ('d003', '1');
INSERT INTO `user` VALUES ('d004', '1');
INSERT INTO `user` VALUES ('d005', '1');
INSERT INTO `user` VALUES ('d006', '1');
INSERT INTO `user` VALUES ('d007', '1');
INSERT INTO `user` VALUES ('d008', '1');
INSERT INTO `user` VALUES ('d009', '1');
INSERT INTO `user` VALUES ('d010', '1');
INSERT INTO `user` VALUES ('d011', '1');
INSERT INTO `user` VALUES ('d012', '1');
INSERT INTO `user` VALUES ('d013', '1');
INSERT INTO `user` VALUES ('d014', '1');
INSERT INTO `user` VALUES ('d015', '1');
INSERT INTO `user` VALUES ('n000', '1');
INSERT INTO `user` VALUES ('n001', '1');
INSERT INTO `user` VALUES ('n002', '1');
INSERT INTO `user` VALUES ('n003', '1');
INSERT INTO `user` VALUES ('n004', '1');
INSERT INTO `user` VALUES ('n005', '1');
INSERT INTO `user` VALUES ('n006', '1');
INSERT INTO `user` VALUES ('n007', '1');
INSERT INTO `user` VALUES ('n008', '1');
INSERT INTO `user` VALUES ('n009', '1');
INSERT INTO `user` VALUES ('n010', '1');
INSERT INTO `user` VALUES ('n011', '1');
INSERT INTO `user` VALUES ('n012', '1');
INSERT INTO `user` VALUES ('n013', '1');
INSERT INTO `user` VALUES ('n014', '1');
INSERT INTO `user` VALUES ('n015', '1');
INSERT INTO `user` VALUES ('n016', '1');
INSERT INTO `user` VALUES ('n017', '1');
INSERT INTO `user` VALUES ('n018', '1');
INSERT INTO `user` VALUES ('n019', '1');
INSERT INTO `user` VALUES ('n020', '1');
INSERT INTO `user` VALUES ('p000', '1');
INSERT INTO `user` VALUES ('p001', '1');
INSERT INTO `user` VALUES ('p002', '1');
INSERT INTO `user` VALUES ('p003', '1');
INSERT INTO `user` VALUES ('p004', '1');
INSERT INTO `user` VALUES ('p005', '1');
INSERT INTO `user` VALUES ('p006', '1');
INSERT INTO `user` VALUES ('p007', '1');
INSERT INTO `user` VALUES ('root', '123456');

SET FOREIGN_KEY_CHECKS = 1;
