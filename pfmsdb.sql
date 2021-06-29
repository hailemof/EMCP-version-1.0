-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 29, 2021 at 03:19 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pfmsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `coursename` varchar(255) DEFAULT NULL,
  `hour` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `directorate`
--

CREATE TABLE `directorate` (
  `directoratename` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `directorate`
--

INSERT INTO `directorate` (`directoratename`, `email`, `telephone`) VALUES
('Account', 'account@gmail.com', '011-55-44-33'),
('Audit', 'audit@gmail.com', '011-44-33-40'),
('Budget', 'budget@gmail.com', '0911-90-90-97'),
('Cash', 'cash@gmail.com', '011-77-90-899'),
('EMCP', 'EMCP@MOFED.GOV.ET', '011-55-44-33'),
('Minister', 'mot@gmail.com', '011-00-99-66'),
('Property', 'property@gmail.com', '0111-55-88-99'),
('Purchase', 'purchase@gmail.com', '011-77-90-899');

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE `document` (
  `id` varchar(255) NOT NULL,
  `directorname` varchar(255) DEFAULT NULL,
  `reportype` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `document`
--

INSERT INTO `document` (`id`, `directorname`, `reportype`) VALUES
('account-001', 'Account', 'first quarter Account report'),
('audit-001', 'Audit', 'audit first quarter report'),
('audit-002', 'Audit', 'Audit 2nd Quarter Report'),
('audit-003', 'Audit', 'Audit third Quarter Report'),
('budget-001', 'Budget', 'Budget 1st Quarter Report'),
('budget-002', 'Budget', 'Budget 2nd Quarter Report'),
('cash-001', 'Cash', ' Cash Report First Quarter'),
('cash-002', 'Cash', ' Cash Report 2nd Quarter'),
('property-001', 'Property', 'property report 1st quarter'),
('purchase-001', 'Purchase', 'purchase report 1st  quarter'),
('purchase-002', 'Purchase', 'purchase report 2nd Quarter');

-- --------------------------------------------------------

--
-- Table structure for table `master_transaction`
--

CREATE TABLE `master_transaction` (
  `id` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `assigned_expert_user_id` bigint(20) NOT NULL,
  `docname` varchar(255) DEFAULT NULL,
  `organizaid` varchar(255) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `reportstatus` varchar(255) DEFAULT NULL,
  `transactiondocumentid` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `master_transaction`
--

INSERT INTO `master_transaction` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `assigned_expert_user_id`, `docname`, `organizaid`, `remarks`, `reportstatus`, `transactiondocumentid`, `user_id`) VALUES
(2, 'org2@org2.com', '2021-01-04 00:00:00', 'audit', '2021-06-29 07:14:17', 16, 'Audit managment system.docx', 'ORG-01', 'somebody', 'Complete', 'audit-001', 15),
(4, 'org2@org2.com', '2021-01-04 00:00:00', 'expert2', '2021-06-28 15:08:55', 20, '1Ethiopian attractions tourists.rtf', 'ORG-01', ' &#4633;&#4635;&#4636;&#4638;         ', 'Incomplete', 'account-001', 15),
(5, 'org2@org2.com', '2021-06-28 11:06:10', 'org2@org2.com', '2021-06-28 11:06:10', 16, 'Unops Trainee Feedback (Haile).docx', 'ORG-01', ' ሙማሜሞ         ', 'pending', 'audit-002', 15),
(6, 'org2@org2.com', '2021-01-04 00:00:00', 'expert2', '2021-06-28 15:07:11', 20, '&#4840;&#4662;&#4941;&#4725;&#4812;&#4653;  &#4621;&#4635;&#4725;  &#4707;&#4616;&#4633;&#4843;  III.docx', 'ORG-01', ' &#4633;&#4635;&#4636;&#4638;         ', 'Pending', 'account-001', 15),
(7, 'org2@org2.com', '2021-06-28 11:13:33', 'org2@org2.com', '2021-06-28 11:13:33', 20, 'Unops Trainee Feedback (Haile).docx', 'ORG-01', ' ሙማሜሞ         ', 'pending', 'account-001', 15),
(8, 'org2@org2.com', '2021-01-04 00:00:00', 'account', '2021-06-28 11:40:53', 20, 'OneUNOPS Supplier Form_Hailemickael Gebru Legese.docx', 'ORG-01', 'somening', 'Complete', 'account-001', 15),
(9, 'org2@org2.com', '2021-01-04 00:00:00', 'budget', '2021-06-28 14:27:23', 26, '1Ethiopian attractions tourists.rtf', 'ORG-01', ' &#4633;&#4635;&#4636;&#4638;         ', 'Pending', 'budget-001', 15),
(10, 'org2@org2.com', '2021-06-28 12:18:52', 'org2@org2.com', '2021-06-28 12:18:52', 24, 'postal.txt', 'ORG-01', ' ሙማሜሞ         ', 'pending', 'cash-001', 15),
(11, 'org2@org2.com', '2021-01-04 00:00:00', 'purchase', '2021-06-28 12:57:24', 23, 'hailecv.docx', 'ORG-01', ' &#4633;&#4635;&#4636;&#4638;         ', 'Complete', 'purchase-001', 15),
(12, 'org2@org2.com', '2021-01-04 00:00:00', 'property', '2021-06-28 12:49:58', 22, '&#4840;&#4662;&#4941;&#4725;&#4812;&#4653;  &#4621;&#4635;&#4725;  &#4707;&#4616;&#4633;&#4843;  III.docx', 'ORG-01', ' &#4633;&#4635;&#4636;&#4638;         ', 'Pending', 'property-001', 15),
(13, 'org2@org2.com', '2021-06-28 13:41:19', 'org2@org2.com', '2021-06-28 13:41:19', 16, '1Ethiopian attractions tourists.rtf', 'ORG-01', ' ሙማሜሞ         ', 'pending', 'audit-003', 15),
(14, 'org2@org2.com', '2021-06-28 19:50:50', 'org2@org2.com', '2021-06-28 19:50:50', 16, 'hailecv.docx', 'ORG-01', ' ሙማሜሞ         ', 'pending', 'purchase-001', 15),
(15, 'org2@org2.com', '2021-01-04 00:00:00', 'audit', '2021-06-29 07:31:42', 16, 'Audit managment system.docx', 'ORG-01', 'comeon', 'Pending', 'audit-003', 15),
(16, 'org2@org2.com', '2021-01-04 00:00:00', 'default', '2021-06-29 09:07:22', 16, 'Audit managment system.docx', 'ORG-01', 'setrhgf', 'Complete', 'audit-003', 15),
(17, 'org2@org2.com', '2021-01-04 00:00:00', 'audit', '2021-06-29 09:05:50', 16, 'DS_CHAP_5_LEC_1_.pdf', 'ORG-01', 'this is fantastic', 'Pending', 'audit-001', 15),
(18, 'org2@org2.com', '2021-06-29 09:33:26', 'org2@org2.com', '2021-06-29 09:33:26', 16, 'Audit managment system.docx', 'ORG-01', ' ሙማሜሞ         ', 'pending', 'cash-002', 15);

-- --------------------------------------------------------

--
-- Table structure for table `organization`
--

CREATE TABLE `organization` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `organizationhead` varchar(255) DEFAULT NULL,
  `orgname` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `organization`
--

INSERT INTO `organization` (`id`, `email`, `organizationhead`, `orgname`, `telephone`) VALUES
('MOF-01', 'mof@gmail.com', 'tsenaa', 'Ministry of finance', '011-66-77-90'),
('ORG-002', 'aMHA@gmail.com', 'Amha Belachew', 'Ministry of Water', '011-77-90-899'),
('ORG-01', 'haileman1051@gmail.com', 'Jemal Tasewe', 'Ministry of Agriculture', '011-00-99-77');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `description`, `name`) VALUES
(1, 'ROLE_ADMIN', 'ADMIN'),
(2, 'ROLE_AUDIT', 'AUDIT'),
(3, 'ROLE_USER', 'USER'),
(4, 'ROLE_BUDGET', 'BUDGET'),
(5, 'ROLE_CASH', 'CASH'),
(6, 'ROLE_PROPERTY', 'PROPERTY'),
(7, 'ROLE_PURCHASE', 'PURCHASE'),
(8, 'ROLE_EXPERT', 'EXPERT'),
(9, 'ROLE_SYSADMIN', 'SYSADMIN'),
(10, 'ROLE_MINISTER', 'MINISTER'),
(11, 'ROLE_ACCOUNT', 'ACCOUNT');

-- --------------------------------------------------------

--
-- Table structure for table `trainee`
--

CREATE TABLE `trainee` (
  `id` int(11) NOT NULL,
  `enddate` datetime DEFAULT NULL,
  `examscore` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `traineecourseid` int(11) DEFAULT NULL,
  `traineeorgid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `org_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `user_dir_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `org_id`, `password`, `status`, `user_dir_name`, `username`) VALUES
(1, 'admin', 'admin', 'admin', 'MOF-01', '$2a$10$xQHh/ww4W86BMt8CitBrrexj3eMjVEHdcotWnYX5xRDnTgjBteGne', b'1', 'EMCP', 'admin'),
(13, 'auditmanager@gmail.com', 'Audit Manager', 'Audit Manager ', 'MOF-01', '$2a$04$mCEP0y4HN.Yrtxhe9P7MaeCfTN06qEr5LgzpADt9QSR9qpoeirqkO', b'1', 'Audit', 'audit'),
(15, 'gfxg@gmail.com', 'getachew', 'assefa', 'ORG-01', '$2a$04$b.5egws5WZSE3QBG6QJq2eK7ChzuJB/f5eB0R6o72t348E53iOjva', b'1', 'Budget', 'org2@org2.com'),
(16, 'haileman1051@gmail.com', 'Audit-default-expert', 'Audit-default-expert', 'MOF-01', '$2a$04$4NuayJY5wR4jG2x9ZI1ft.Vx0/JDxl4w9j1peTUpo3FNXDQCKcs0G', b'1', 'Audit', 'default'),
(17, 'super@gmail.com', 'super user', 'super user', 'MOF-01', '$2a$04$By2no8lqGi54tel4OjsyHug9LhuRyfSajYOfYnaD0cUqyj2qfJz/2', b'1', 'EMCP', 'superuser'),
(18, 'mot@gmail.com', 'minister', 'minister', 'ORG-002', '$2a$04$Hi5cjJahWoSmBtLcuHa4keHt.82kZkDsnaqDGuF2QY7OQscfXf8We', b'1', 'Minister', 'minister'),
(19, 'acc@gmail.com', 'account manager', 'account manager', 'MOF-01', '$2a$04$rWCId/MMx4QzgQvZ24lVtOf8Loec7.0EgknuK5EBJtWRVPO4k61tu', b'1', 'Account', 'account'),
(20, 'heg@gmail.com', 'default-account-expert', 'default-account-expert', 'MOF-01', '$2a$04$/fGLxmMSnnwUY2nuK8uQ.u.oVpbnt3ge6yA8vUUFuLVj8myTKvxje', b'1', 'Account', 'expert2'),
(21, 'dbe@gmail.com', 'default-budget-expert', 'default-budget-expert', 'MOF-01', '$2a$04$KTC8Mjp8WfGWcQEvQW1TWeIbL5k.U9EKAk/UoXMVPIjjJIhucnmHu', b'1', 'Budget', 'expert3'),
(22, 'mok@gmail.com', 'default-property-expert', 'default-property-expert', 'MOF-01', '$2a$04$hOwbCnj0QmL2gABOG4EeMuOyYYMbMgItINyl7saJQk6yljecjnEvu', b'1', 'Property', 'expert4'),
(23, 'defg@gmail.com', 'default-purchase-expert', 'default-purchase-expert', 'MOF-01', '$2a$04$nQZGawW4cJuB8RWf4r2m8eZYOxjQmTTtUAhWL47k0.k43fJcyKaw6', b'1', 'Purchase', 'expert5'),
(24, 'decash@gmail.com', 'default-cash-expert', 'default-cash-expert', 'MOF-01', '$2a$04$IQGIqt.I9XqV8.v/HS8LMu2xioSOP0UG4Ec9lwMyv93PI8ZyOdvUK', b'1', 'Cash', 'expert6'),
(25, 'budget@gmail.com', 'budget', 'budget', 'MOF-01', '$2a$04$HotcrYN62i7pYT8mBPvESOWmrM..vv8yFpaI7UU7bN1h4rXawadVO', b'1', 'Budget', 'budget'),
(26, 'astu@gmail.com', 'asterexpert', 'belay', 'MOF-01', '$2a$04$fnhwegC.q89CUYQtMNruTeuwnVo1xYhkyeg2EAW/VI0z9lOa3qG3a', b'1', 'Budget', 'aster'),
(27, 'ethionile12@gmail.com', 'expert account', 'expert account', 'MOF-01', '$2a$04$4Iz8IQLRXlm5PxIO/nCOuOeb41RwweheQlLPo8SjFHUJQJtiSEAeK', b'1', 'Account', 'miki'),
(28, 'cash@gmail.com', 'cash manager', 'cash manager', 'MOF-01', '$2a$04$OoXqgA5pGsSSQkdRcHDzwekD24Vv7rVpedizuOv8KZZDK55Pjc63C', b'1', 'Cash', 'cash'),
(29, 'property@gmail.com', 'property manager', 'property manager', 'MOF-01', '$2a$04$lcaFlKFbGcMk7bbkO2KRQeF5rtRHid8PCVCaRtWMf4TyNgbRBqC3q', b'1', 'Property', 'property'),
(30, 'purchase@gmail.com', 'purchase manager', 'purchase manager', 'MOF-01', '$2a$04$qjVQoKt2s7F69YJiMqVrXuSsmhGcck8NZX2WMELBRxn7hdGGFw0Eu', b'1', 'Purchase', 'purchase');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(13, 2),
(15, 3),
(16, 8),
(17, 9),
(18, 10),
(19, 11),
(20, 8),
(21, 8),
(22, 8),
(23, 7),
(24, 5),
(25, 4),
(26, 8),
(27, 8),
(28, 5),
(29, 6),
(30, 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `directorate`
--
ALTER TABLE `directorate`
  ADD PRIMARY KEY (`directoratename`);

--
-- Indexes for table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKro4dpm5wi0hokcsbk9rhqrjbi` (`directorname`);

--
-- Indexes for table `master_transaction`
--
ALTER TABLE `master_transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKo53fd6qw0rrrw2nj3tmq1m9id` (`organizaid`),
  ADD KEY `FK9mb1cp07re34ew8me8umjwwjl` (`transactiondocumentid`),
  ADD KEY `FKhos5iuycrxqe78q0u8f0xhrf0` (`user_id`),
  ADD KEY `FK9hrc8w8jjukutbi2f3ulcdjen` (`assigned_expert_user_id`);

--
-- Indexes for table `organization`
--
ALTER TABLE `organization`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trainee`
--
ALTER TABLE `trainee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5ocdvsvxscomd8vmrcxul5bct` (`traineecourseid`),
  ADD KEY `FKcm2kgoiti45lcekae6pscova2` (`traineeorgid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4051xtqn73l9ijrk1okdkdvn4` (`user_dir_name`),
  ADD KEY `FKhulr6qu116k1dd68w3itppg15` (`org_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `master_transaction`
--
ALTER TABLE `master_transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `trainee`
--
ALTER TABLE `trainee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `FKro4dpm5wi0hokcsbk9rhqrjbi` FOREIGN KEY (`directorname`) REFERENCES `directorate` (`directoratename`);

--
-- Constraints for table `master_transaction`
--
ALTER TABLE `master_transaction`
  ADD CONSTRAINT `FK9hrc8w8jjukutbi2f3ulcdjen` FOREIGN KEY (`assigned_expert_user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK9mb1cp07re34ew8me8umjwwjl` FOREIGN KEY (`transactiondocumentid`) REFERENCES `document` (`id`),
  ADD CONSTRAINT `FKhos5iuycrxqe78q0u8f0xhrf0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKo53fd6qw0rrrw2nj3tmq1m9id` FOREIGN KEY (`organizaid`) REFERENCES `organization` (`id`);

--
-- Constraints for table `trainee`
--
ALTER TABLE `trainee`
  ADD CONSTRAINT `FK5ocdvsvxscomd8vmrcxul5bct` FOREIGN KEY (`traineecourseid`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `FKcm2kgoiti45lcekae6pscova2` FOREIGN KEY (`traineeorgid`) REFERENCES `organization` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK4051xtqn73l9ijrk1okdkdvn4` FOREIGN KEY (`user_dir_name`) REFERENCES `directorate` (`directoratename`),
  ADD CONSTRAINT `FKhulr6qu116k1dd68w3itppg15` FOREIGN KEY (`org_id`) REFERENCES `organization` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
