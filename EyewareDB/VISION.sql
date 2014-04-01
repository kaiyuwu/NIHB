SET NAMES utf8mb4;

-- ----------------------------------------------------------------------------
-- Source Schemata: VISION
-- Created: Sat MAR 29 17:56:16 2014
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema VISION
-- ----------------------------------------------------------------------------
DROP DATABASE IF EXISTS `Vision` ;
CREATE DATABASE IF NOT EXISTS `Vision` DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;


	
-- ----------------------------------------------------------------------------
-- Table Vision.User
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Vision`.`User` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL,
	`firstname` VARCHAR(50) NULL,
	`lastname` VARCHAR(50) NULL,
	`type` CHAR(1) NULL,
	`password` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NULL,
	`website` VARCHAR(50) NULL,
	`status` CHAR(1) NULL,
	`workphone` VARCHAR(50) NULL,
	`cellphone` VARCHAR(50) NULL,
	`comments` VARCHAR(200) NULL,
	`mail_addr1` VARCHAR(50) NULL,
	`mail_addr2` VARCHAR(50) NULL,
	`mail_unit` VARCHAR(10) NULL,
	`mail_city` VARCHAR(50) NULL,
	`mail_province` CHAR(2) NULL,
	`mail_country` VARCHAR(50) NULL,
	`mail_postalcode` VARCHAR(10) NULL,
	`mail_phone` VARCHAR(50) NULL,
	`bill_addr1` VARCHAR(50) NULL,
	`bill_addr2` VARCHAR(50) NULL,
	`bill_unit` VARCHAR(10) NULL,
	`bill_city` VARCHAR(50) NULL,
	`bill_province` CHAR(2) NULL,
	`bill_country` VARCHAR(50) NULL,
	`bill_postalcode` VARCHAR(10) NULL,
	`bill_phone` VARCHAR(50) NULL,
	`doctortype` CHAR(1) NULL,
	`doctorlicense` VARCHAR(50) NULL,
	`canNewClaim` TINYINT (1) NULL,
	`canApproveInjury` TINYINT (1) NULL,
	`canExam` TINYINT (1) NULL,
	`canApproveExam` TINYINT (1) NULL,
	`canGlasses` TINYINT (1) NULL,
	`canApproveGlasses` TINYINT (1) NULL,
	`canPayable` TINYINT (1) NULL,
	`canCRUDDoctor` TINYINT (1) NULL,
	`canCRUDProvider` TINYINT (1) NULL,
	`canAddDoctorToProvider` TINYINT (1) NULL,
	`canCRUDNihbUser` TINYINT (1) NULL,
 	`createdby` BIGINT NULL,
 	`createdAt` DATETIME NULL,
 	`lastmodifiedby` BIGINT NULL,
 	`lastmodifiedat` DATETIME NULL,
  PRIMARY KEY (`id`),
   CONSTRAINT `UX_UserName` 
	UNIQUE (`username`),
 
CONSTRAINT `FK_USER_CREATED_BY`
    FOREIGN KEY (`createdby`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_USER_MODIFIED_BY`
    FOREIGN KEY (`lastmodifiedby`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
INDEX IDX_USERNAME (username),
INDEX IDX_NAME(firstname,lastname)	
	);
	
-- ----------------------------------------------------------------------------
-- Table Vision.Provider
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Vision`.`Provider` (
 	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`type` CHAR(1) NULL,
	`email` VARCHAR(50) NULL,
	`website` VARCHAR(50) NULL,
	`status` CHAR(1) NULL,
	`workphone` VARCHAR(50) NULL,
	`cellphone` VARCHAR(50) NULL,
	`comments` VARCHAR(200) NULL,
	`mail_addr1` VARCHAR(50) NULL,
	`mail_addr2` VARCHAR(50) NULL,
	`mail_unit` VARCHAR(10) NULL,
	`mail_city` VARCHAR(50) NULL,
	`mail_province` CHAR(2) NULL,
	`mail_country` VARCHAR(50) NULL,
	`mail_postalcode` VARCHAR(10) NULL,
	`mail_phone` VARCHAR(50) NULL,
	`bill_addr1` VARCHAR(50) NULL,
	`bill_addr2` VARCHAR(50) NULL,
	`bill_unit` VARCHAR(10) NULL,
	`bill_city` VARCHAR(50) NULL,
	`bill_province` CHAR(2) NULL,
	`bill_country` VARCHAR(50) NULL,
	`bill_postalcode` VARCHAR(10) NULL,
	`bill_phone` VARCHAR(50) NULL,
 	`createdby` BIGINT NULL,
 	`createdAt` DATETIME NULL,
 	`lastmodifiedby` BIGINT NULL,
 	`lastmodifiedat` DATETIME NULL,
PRIMARY KEY (`id`),
 CONSTRAINT `UX_providername` 
	UNIQUE (`name`),
 
CONSTRAINT `FK_PROVIDER_CREATED_BY`
    FOREIGN KEY (`createdby`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_PROVIDER_MODIFIED_BY`
    FOREIGN KEY (`lastmodifiedby`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
INDEX IDX_NAME(name));

	
-- ----------------------------------------------------------------------------
-- Table Vision.UserProviderRelation
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Vision`.`UserProviderRelation` (
 	`id` BIGINT NOT NULL AUTO_INCREMENT,
 	`userid` BIGINT NULL,
	`providerid` BIGINT NULL,
	`providername` VARCHAR(50) NULL,
	`userfirstname` VARCHAR(50) NULL,
	`userlastname` VARCHAR(50) NULL,
	`usertype` CHAR(1) NULL,
	`doctortype` CHAR(1) NULL,
	`providertype` CHAR(1) NULL,
	`username` VARCHAR(30) NULL,
 	`createdby` BIGINT NULL,
 	`createdAt` DATETIME NULL,
 	`lastmodifiedby` BIGINT NULL,
 	`lastmodifiedat` DATETIME NULL,
  PRIMARY KEY (`id`),
CONSTRAINT `FK_USER_PROVIER_USERID`
    FOREIGN KEY (`userid`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_USER_PROVIER_PROVIDERID`
    FOREIGN KEY (`providerid`)
    REFERENCES `Vision`.`Provider` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_USER_PROVIER_CREATED_BY`
    FOREIGN KEY (`createdby`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_USER_PROVIDER_MODIFIED_BY`
    FOREIGN KEY (`lastmodifiedby`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
INDEX IDX_USER(userid),
INDEX IDX_PROVIDER(providerid));	
	

-- ----------------------------------------------------------------------------
-- Table VISION.Claim
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Vision`.`Claim` (
 	`id` BIGINT NOT NULL AUTO_INCREMENT,
 	`diand` BIGINT NOT NULL,
 	`isInjury` TINYINT(1)  NULL,
 	`injuryDate` DATETIME NULL,
 	`injuryPlace` VARCHAR(50) NULL,
 	`injuryOther` VARCHAR(50) NULL,
 	`isOtherInjuryPlan` TINYINT(1) NULL,
 	`otherInjuryPlanName` VARCHAR(30) NULL,
 	`otherInjuryClaimNumber` VARCHAR(30) NULL,
 	`otherInjuryClaimAmount` DECIMAL(10, 2) NULL,
 	`injuryApprovalStatus` CHAR(1) NULL,
 	`injuryApprovalBy` BIGINT NULL,
 	`injuryApprovedAt` DATETIME NULL,
 	`injuryApprovalNumber` VARCHAR(30) NULL,
 	`injuryDenialReason` VARCHAR(50) NULL,
 	`examAmount` DECIMAL(10, 2) NULL,
 	`examApprovalStatus` CHAR(1) NULL,
 	`examApprovedBy` BIGINT NULL,
 	`examApprovedAt` DATETIME NULL,
 	`examApprovalNumber` VARCHAR(30) NULL,
 	`examDenialReason` VARCHAR(50) NULL,
 	`examProvider` BIGINT NULL,
 	`examDoctor` BIGINT NULL,
 	`od_prism` DECIMAL(4, 2) NULL,
 	`od_base` DECIMAL(4, 2) NULL,
 	`od_sphere` DECIMAL(4, 2) NULL,
 	`od_cyl` DECIMAL(4, 2) NULL,
 	`od_axis` DECIMAL(4, 2) NULL,
 	`od_add` DECIMAL(4, 2) NULL,
 	`os_prism` DECIMAL(4, 2) NULL,
 	`os_base` DECIMAL(4, 2) NULL,
 	`os_sphere` DECIMAL(4, 2) NULL,
 	`os_cyl` DECIMAL(4, 2) NULL,
 	`os_axis` DECIMAL(4, 2) NULL,
 	`os_add` DECIMAL(4, 2) NULL,
 	`pd` DECIMAL(4, 2) NULL,
 	`exam_gst` DECIMAL(4, 2) NULL,
 	`exam_pst` DECIMAL(4, 2) NULL,
 	`exam_hst` DECIMAL(4, 2) NULL,
 	`exam_copay_amount` DECIMAL(10, 2) NULL,
 	`glassesApprovalStatus` CHAR(1) NULL,
 	`glassesApprovedBy` BIGINT NULL,
 	`glassesApprovedAt` DATETIME NULL,
 	`glassesApprovalNumber` VARCHAR(30) NULL,
 	`glassesDenailReason` VARCHAR(50) NULL,
 	`glassesProvider` BIGINT NULL,
 	`glassesOptician` BIGINT NULL,
 	`glassesframecost` DECIMAL(4, 2) NULL,
 	`glassesrightlenscost` DECIMAL(4, 2) NULL,
 	`glassesleftlenscost` DECIMAL(4, 2) NULL,
 	`glassesscrcost` DECIMAL(4, 2) NULL,
 	`glasseshardexcoatingcost` DECIMAL(4, 2) NULL,
 	`glassesedgingcost` DECIMAL(4, 2) NULL,
 	`glassesnylongrovingcost` DECIMAL(4, 2) NULL,
 	`glassescasecost` DECIMAL(4, 2) NULL,
 	`glassesframefrontcost` DECIMAL(4, 2) NULL,
 	`glassestemplecost` DECIMAL(4, 2) NULL,
 	`glassesothercost1` DECIMAL(4, 2) NULL,
 	`glassesothercost2` DECIMAL(4, 2) NULL,
 	`glassessframedesc` VARCHAR(50) NULL,
 	`glassesrightlensdesc` VARCHAR(50) NULL,
 	`glassesleftlensdesc` VARCHAR(50) NULL,
 	`glassesscrdesc` VARCHAR(50) NULL,
 	`glasseshardexcoatingdesc` VARCHAR(50) NULL,
 	`glassesedgingdesc` VARCHAR(50) NULL,
 	`glassesnylongrovingdesc` VARCHAR(50) NULL,
 	`glassescasedesc` VARCHAR(50) NULL,
 	`glassesframefrontdesc` VARCHAR(50) NULL,
 	`glassestempledesc` VARCHAR(50) NULL,
 	`glassesothercost1desc` VARCHAR(50) NULL,
 	`glassesothercost2desc` VARCHAR(50) NULL,
 	`glassesframenihb` VARCHAR(50) NULL,
 	`glassesrightlensnihb` VARCHAR(50) NULL,
 	`glassesleftlensnihb` VARCHAR(50) NULL,
 	`glassesscrnihb` VARCHAR(50) NULL,
 	`glasseshardexcoatingnihb` VARCHAR(50) NULL,
 	`glassesedgingnihb` VARCHAR(50) NULL,
 	`glassesnylongrovingnihb` VARCHAR(50) NULL,
 	`glassescasenihb` VARCHAR(50) NULL,
 	`glassesframefrontnihb` VARCHAR(50) NULL,
 	`glassestemplenihb` VARCHAR(50) NULL,
 	`glassesothercost1nihb` VARCHAR(50) NULL,
 	`glassesothercost2nihb` VARCHAR(50) NULL,
 	`glassescopay` DECIMAL(4, 2) NULL,
 	`glasses_gst` DECIMAL(4, 2) NULL,
 	`glasses_pst` DECIMAL(4, 2) NULL,
 	`glasses_hst` DECIMAL(4, 2) NULL,
 	`examcomments` VARCHAR(200) NULL,
 	`glassescomments` VARCHAR(200) NULL,
 	`examnihbcomments` VARCHAR(200) NULL,
 	`glassesnihbcomments` VARCHAR(200) NULL,
 	`comments` VARCHAR(200) NULL,
 	`createdby` BIGINT NULL,
 	`createdAt` DATETIME NULL,
 	`status` CHAR(1) NULL,
 	`examPaymentStatus` CHAR(1) NULL,
 	`examPaymentBy` BIGINT NULL,
 	`examPaymentAt` DATETIME NULL,
 	`examInvoiceNumber` VARCHAR(30) NULL,
 	`glassesPaymentStatus` CHAR(1) NULL,
 	`glassesPaymentBy` BIGINT NULL,
 	`glassesPaymentAt` DATETIME NULL,
 	`glassesInvoiceNumber` VARCHAR(30) NULL,
 	`lastmodifiedby` BIGINT NULL,
 	`lastmodifiedat` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_INJURY_APPROVAL`
    FOREIGN KEY (`injuryApprovalBy`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_EXAM_APPROVAL`
    FOREIGN KEY (`examApprovedBy`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_EXAM_DOCTOR`
    FOREIGN KEY (`examDoctor`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_EXAM_PROVIDER`
    FOREIGN KEY (`examProvider`)
    REFERENCES `Vision`.`Provider` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_GLASSES_APPROVAL`
    FOREIGN KEY (`glassesApprovedBy`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_GLASSES_OPTICIAN`
    FOREIGN KEY (`glassesOptician`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_GLASSES_PROVIDER`
    FOREIGN KEY (`glassesProvider`)
    REFERENCES `Vision`.`Provider` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_CLAIM_CREATED_BY`
    FOREIGN KEY (`createdby`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_EXAM_PAYMENT`
    FOREIGN KEY (`examPaymentBy`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_GLASSES_PAYMEN`
    FOREIGN KEY (`glassesPaymentBy`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `FK_CLAIM_MODIFIED_BY`
    FOREIGN KEY (`lastmodifiedby`)
    REFERENCES `Vision`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 INDEX IDX_STATUS(status),
 INDEX IDX_EXAM_PROVIDER(examProvider),
 INDEX IDX_GLASSES_PROVIDER(glassesProvider),
 INDEX IDX_DIAND(diand));
 
 
 -- --------------------------------
 -- SPROC 
 -- ---------------------------------
 
USE Vision;

DELIMITER //




-- Stored procedure to insert user info
DROP PROCEDURE IF EXISTS InsertUserInfo //
CREATE PROCEDURE InsertUserInfo(
		username		 VARCHAR(30),
		firstname		 VARCHAR(50),
		lastname		 VARCHAR(50),
		type		 	 CHAR(1),
		password		 VARCHAR(50),
		email			 VARCHAR(50),
		website			 VARCHAR(50),
		status			 CHAR(1),
		workphone		 VARCHAR(50),
		cellphone		 VARCHAR(50),
		comments		 VARCHAR(200),
		mail_addr1		 VARCHAR(50),
		mail_addr2		 VARCHAR(50),
		mail_unit		 VARCHAR(10),
		mail_city		 VARCHAR(50),
		mail_province	 CHAR(2),
		mail_country	 VARCHAR(50),
		mail_postalcode	 VARCHAR(10),
		mail_phone		 VARCHAR(50),
		bill_addr1		 VARCHAR(50),
		bill_addr2		 VARCHAR(50),
		bill_unit		 VARCHAR(10),
		bill_city		 VARCHAR(50),
		bill_province	 CHAR(2),
		bill_country	 VARCHAR(50),
		bill_postalcode	 VARCHAR(10),
		bill_phone		 VARCHAR(50),
		doctortype		 CHAR(1),
		doctorlicense	 VARCHAR(50),
		canNewClaim		 TINYINT (1),
		canApproveInjury TINYINT (1),
		canExam		 	 TINYINT (1),
		canApproveExam	 TINYINT (1),
		canGlasses		 TINYINT (1),
		canApproveGlasses TINYINT (1),
		canPayable		 TINYINT (1),
		canCRUDDoctor	 TINYINT (1),
		canCRUDProvider	 TINYINT (1),
		canAddDoctorToProvider TINYINT (1),
		canCRUDNihbUser	 TINYINT (1),
		createdby		 BIGINT,
	    OUT id 			 BIGINT)
BEGIN

	SET @Now = NOW();
	
	INSERT INTO User
	(
		username,
		firstname,
		lastname,
		type,
		password,
		email,
		website,
		status,
		workphone,
		cellphone,
		comments,
		mail_addr1,
		mail_addr2,
		mail_unit,
		mail_city,
		mail_province,
		mail_country,
		mail_postalcode,
		mail_phone,
		bill_addr1,
		bill_addr2,
		bill_unit,
		bill_city,
		bill_province,
		bill_country,
		bill_postalcode,
		bill_phone,
		doctortype,
		doctorlicense,
		canNewClaim,
		canApproveInjury,
		canExam,
		canApproveExam,
		canGlasses,
		canApproveGlasses,
		canPayable,
		canCRUDDoctor,
		canCRUDProvider,
		canAddDoctorToProvider,
		canCRUDNihbUser,
		createdby,
		createdAt,
		lastmodifiedby,
		lastmodifiedat
	)
	VALUE
	(
		username,
		firstname,
		lastname,
		type,
		password,
		email,
		website,
		status,
		workphone,
		cellphone,
		comments,
		mail_addr1,
		mail_addr2,
		mail_unit,
		mail_city,
		mail_province,
		mail_country,
		mail_postalcode,
		mail_phone,
		bill_addr1,
		bill_addr2,
		bill_unit,
		bill_city,
		bill_province,
		bill_country,
		bill_postalcode,
		bill_phone,
		doctortype,
		doctorlicense,
		canNewClaim,
		canApproveInjury,
		canExam,
		canApproveExam,
		canGlasses,
		canApproveGlasses,
		canPayable,
		canCRUDDoctor,
		canCRUDProvider,
		canAddDoctorToProvider,
		canCRUDNihbUser,
		createdby,
		@Now,
		createdby,
		@Now

	);

	SELECT LAST_INSERT_ID() INTO id;
END //




-- Stored procedure to get user info
DROP PROCEDURE IF EXISTS GetUserLoginInfo //
CREATE PROCEDURE GetUserLoginInfo(UserName VARCHAR(50))
BEGIN
	SELECT 
		u.id,
		u.type,
		u.username,
		u.password,
		u.status
		
	FROM User u
	WHERE u.username = UserName;
END //



-- Stored procedure to get user info
DROP PROCEDURE IF EXISTS GetUserInfo //
CREATE PROCEDURE GetUserInfo(UserID BIGINT)
BEGIN
	SELECT 
		u.id,
		u.username,
		u.firstname,
		u.lastname,
		u.type,
		u.password,
		u.email,
		u.website,
		u.status,
		u.workphone,
		u.cellphone,
		u.comments,
		u.mail_addr1,
		u.mail_addr2,
		u.mail_unit,
		u.mail_city,
		u.mail_province,
		u.mail_country,
		u.mail_postalcode,
		u.mail_phone,
		u.bill_addr1,
		u.bill_addr2,
		u.bill_unit,
		u.bill_city,
		u.bill_province,
		u.bill_country,
		u.bill_postalcode,
		u.bill_phone,
		u.doctortype,
		u.doctorlicense,
		u.canNewClaim,
		u.canApproveInjury,
		u.canExam,
		u.canApproveExam,
		u.canGlasses,
		u.canApproveGlasses,
		u.canPayable,
		u.canCRUDDoctor,
		u.canCRUDProvider,
		u.canAddDoctorToProvider,
		u.canCRUDNihbUser,
		u.createdby,
		u.createdAt,
		u.lastmodifiedby,
		u.lastmodifiedat
		
	FROM User u
	WHERE u.id = UserID;
END //

-- SPORC to change user password
DROP PROCEDURE IF EXISTS ChangeUserPassword //
CREATE PROCEDURE ChangeUserPassword(
	    id 			BIGINT,
		password	VARCHAR(50),
		modifiedby  BIGINT
	)
BEGIN
	SET @Now = NOW();
	UPDATE User u
	SET 
		u.password=password,
		u.lastmodifiedby=modifiedby,
		u.lastmodifiedat=@Now
	WHERE u.id = id;
END //
 

-- Stored procedure to update user info
DROP PROCEDURE IF EXISTS UpdateUserInfo //
CREATE PROCEDURE UpdateUserInfo(
	    id 				 BIGINT,
		firstname		 VARCHAR(50),
		lastname		 VARCHAR(50),
		type			 CHAR(1),
		password		 VARCHAR(50),
		email			 VARCHAR(50),
		website			 VARCHAR(50),
		status			 CHAR(1),
		workphone		 VARCHAR(50),
		cellphone		 VARCHAR(50),
		comments		 VARCHAR(200),
		mail_addr1		 VARCHAR(50),
		mail_addr2		 VARCHAR(50),
		mail_unit		 VARCHAR(10),
		mail_city		 VARCHAR(50),
		mail_province	 CHAR(2),
		mail_country	 VARCHAR(50),
		mail_postalcode	 VARCHAR(10),
		mail_phone		 VARCHAR(50),
		bill_addr1		 VARCHAR(50),
		bill_addr2		 VARCHAR(50),
		bill_unit		 VARCHAR(10),
		bill_city		 VARCHAR(50),
		bill_province	 CHAR(2),
		bill_country	 VARCHAR(50),
		bill_postalcode	 VARCHAR(10),
		bill_phone		 VARCHAR(50),
		doctortype		 CHAR(1),
		doctorlicense	 VARCHAR(50),
		canNewClaim		 TINYINT (1),
		canApproveInjury TINYINT (1),
		canExam			 TINYINT (1),
		canApproveExam	 TINYINT (1),
		canGlasses		 TINYINT (1),
		canApproveGlasses TINYINT (1),
		canPayable		 TINYINT (1),
		canCRUDDoctor	 TINYINT (1),
		canCRUDProvider	 TINYINT (1),
		canAddDoctorToProvider TINYINT (1),
		canCRUDNihbUser	 TINYINT (1),
		modifiedby		 BIGINT
	)

BEGIN
	SET @Now = NOW();
	UPDATE User u
	SET 
		u.firstname=firstname,
		u.lastname=lastname,
		u.type=type,
		u.password=password,
		u.email=email,
		u.website=website,
		u.status=status,
		u.workphone=workphone,
		u.cellphone=cellphone,
		u.comments=comments,
		u.mail_addr1=mail_addr1,
		u.mail_addr2=mail_addr2,
		u.mail_unit=mail_unit,
		u.mail_city=mail_city,
		u.mail_province=mail_province,
		u.mail_country=mail_country,
		u.mail_postalcode=mail_postalcode,
		u.mail_phone=mail_phone,
		u.bill_addr1=bill_addr1,
		u.bill_addr2=bill_addr2,
		u.bill_unit=bill_unit,
		u.bill_city=bill_city,
		u.bill_province=bill_province,
		u.bill_country=bill_country,
		u.bill_postalcode=bill_postalcode,
		u.bill_phone=bill_phone,
		u.doctortype=doctortype,
		u.doctorlicense=doctorlicense,
		u.canNewClaim=canNewClaim,
		u.canApproveInjury=canApproveInjury,
		u.canExam=canExam,
		u.canApproveExam=canApproveExam,
		u.canGlasses=canGlasses,
		u.canApproveGlasses=canApproveGlasses,
		u.canPayable=canPayable,
		u.canCRUDDoctor=canCRUDDoctor,
		u.canCRUDProvider=canCRUDProvider,
		u.canAddDoctorToProvider=canAddDoctorToProvider,
		u.canCRUDNihbUser=canCRUDNihbUser,
		u.lastmodifiedby = modifiedby,
		u.lastmodifiedat = @Now
	WHERE u.id = id;
END //
 

-- Stored procedure to change user status

DROP PROCEDURE IF EXISTS ChangeUserStatus //
 
CREATE PROCEDURE ChangeUserStatus(
		id	 		BIGINT,
		status		CHAR(1),
		modifiedby  BIGINT
)
BEGIN
	SET @Now = NOW();
	UPDATE User u
	SET u.status =status,
		u.lastmodifiedby = modifiedby,
		u.lastmodifiedat = @Now
	WHERE u.id = id;
END //






-- -------------------------------------
-- SPROC PROVIDER
-- --------------------------------------
-- Stored procedure to insert provider info
DROP PROCEDURE IF EXISTS InsertProviderInfo //
CREATE PROCEDURE InsertProviderInfo(
		 name			 VARCHAR(50),
		 type			 CHAR(1),
		 email			 VARCHAR(50),
		 website		 VARCHAR(50),
		 status			 CHAR(1),
		 workphone		 VARCHAR(50),
		 cellphone		 VARCHAR(50),
		 comments		 VARCHAR(200),
		 mail_addr1		 VARCHAR(50),
		 mail_addr2		 VARCHAR(50),
		 mail_unit		 VARCHAR(10),
		 mail_city		 VARCHAR(50),
		 mail_province	 CHAR(2),
		 mail_country	 VARCHAR(50),
		 mail_postalcode VARCHAR(10),
		 mail_phone		 VARCHAR(50),
		 bill_addr1		 VARCHAR(50),
		 bill_addr2		 VARCHAR(50),
		 bill_unit		 VARCHAR(10),
		 bill_city		 VARCHAR(50),
		 bill_province	 CHAR(2),
		 bill_country	 VARCHAR(50),
		 bill_postalcode VARCHAR(10),
		 bill_phone		 VARCHAR(50),
		createdby		 BIGINT,
	    OUT id 			 BIGINT)
BEGIN

	SET @Now = NOW();
	
	INSERT INTO Provider
	(
		 name		,
		 type		,
		 email		,
		 website	,
		 status		,
		 workphone	,
		 cellphone	,
		 comments	,
		 mail_addr1	,
		 mail_addr2	,
		 mail_unit		,
		 mail_city	,
		 mail_province	,
		 mail_country,
		 mail_postalcode,
		 mail_phone	,
		 bill_addr1	,
		 bill_addr2	,
		 bill_unit		,
		 bill_city	,
		 bill_province	,
		 bill_country,
		 bill_postalcode,
		 bill_phone	,
		 createdby	,
		 createdAt	,
		 lastmodifiedby	,
		 lastmodifiedat	
	)
	VALUE
	(
		 name		,
		 type		,
		 email		,
		 website	,
		 status		,
		 workphone	,
		 cellphone	,
		 comments	,
		 mail_addr1	,
		 mail_addr2	,
		 mail_unit		,
		 mail_city	,
		 mail_province	,
		 mail_country,
		 mail_postalcode,
		 mail_phone	,
		 bill_addr1	,
		 bill_addr2	,
		 bill_unit		,
		 bill_city	,
		 bill_province	,
		 bill_country,
		 bill_postalcode,
		 bill_phone	,
		createdby,
		@Now,
		createdby,
		@Now

	);

	SELECT LAST_INSERT_ID() INTO id;
END //


-- Stored procedure to get provider info
DROP PROCEDURE IF EXISTS GetProviderInfo //
CREATE PROCEDURE GetProviderInfo(id BIGINT)
BEGIN
	SELECT 
		 p.id			,
		 p.name		,
		 p.type		,
		 p.email		,
		 p.website	,
		 p.status		,
		 p.workphone	,
		 p.cellphone	,
		 p.comments	,
		 p.mail_addr1	,
		 p.mail_addr2	,
		 p.mail_unit		,
		 p.mail_city	,
		 p.mail_province	,
		 p.mail_country,
		 p.mail_postalcode,
		 p.mail_phone	,
		 p.bill_addr1	,
		 p.bill_addr2	,
		 p.bill_unit		,
		 p.bill_city	,
		 p.bill_province	,
		 p.bill_country,
		 p.bill_postalcode,
		 p.bill_phone	,
		 p.createdby	,
		 p.createdAt	,
		 p.lastmodifiedby	,
		 p.lastmodifiedat
		
	FROM Provier p
	WHERE p.id = id;
END //


-- Stored procedure to update provider info
DROP PROCEDURE IF EXISTS UpdateProviderInfo //
CREATE PROCEDURE UpdateProviderInfo(
		 id				 BIGINT ,
		 name			 VARCHAR(50),
		 type			 CHAR(1),
		 email			 VARCHAR(50),
		 website		 VARCHAR(50),
		 status			 CHAR(1),
		 workphone		 VARCHAR(50),
		 cellphone		 VARCHAR(50),
		 comments		 VARCHAR(200),
		 mail_addr1		 VARCHAR(50),
		 mail_addr2		 VARCHAR(50),
		 mail_unit		 VARCHAR(10),
		 mail_city		 VARCHAR(50),
		 mail_province	 CHAR(2),
		 mail_country	 VARCHAR(50),
		 mail_postalcode VARCHAR(10),
		 mail_phone		 VARCHAR(50),
		 bill_addr1		 VARCHAR(50),
		 bill_addr2		 VARCHAR(50),
		 bill_unit		 VARCHAR(10),
		 bill_city		 VARCHAR(50),
		 bill_province	 CHAR(2),
		 bill_country	 VARCHAR(50),
		 bill_postalcode VARCHAR(10),
		 bill_phone		 VARCHAR(50),
		modifiedby		 BIGINT
	)

BEGIN
	SET @Now = NOW();
	UPDATE Provier p
	SET 
		p.name	 =name	,
		p.type	=type	,
		p.email =email		,
		p.website=website,
		p.status=status,
		p.workphone=workphone,
		p.cellphone=cellphone,
		p.comments=comments,
		p.mail_addr1=mail_addr1,
		p.mail_addr2=mail_addr2,
		p.mail_unit=mail_unit,
		p.mail_city=mail_city,
		p.mail_province=mail_province,
		p.mail_country=mail_country,
		p.mail_postalcode=mail_postalcode,
		p.mail_phone=mail_phone,
		p.bill_addr1=bill_addr1,
		p.bill_addr2=bill_addr2,
		p.bill_unit=bill_unit,
		p.bill_city=bill_city,
		p.bill_province=bill_province,
		p.bill_country=bill_country,
		p.bill_postalcode=bill_postalcode,
		p.bill_phone=bill_phone,
		p.lastmodifiedby = modifiedby,
		p.lastmodifiedat = @Now

	WHERE p.id = id;
END //
 

-- Stored procedure to change Provider status

DROP PROCEDURE IF EXISTS ChangeProviderStatus //
 
CREATE PROCEDURE ChangeProviderStatus(
		id	 		BIGINT,
		status		CHAR(1),
		modifiedby  BIGINT
)
BEGIN
	SET @Now = NOW();
	UPDATE Provider p
	SET p.status =status,
		p.lastmodifiedby = modifiedby,
		p.lastmodifiedat = @Now
	WHERE p.id = id;
END //


-- -------------------------------------
-- SPROC USER PROVIDER Relation
-- --------------------------------------
-- Stored procedure to insert user provider relation
DROP PROCEDURE IF EXISTS InsertUserProviderRelation //
CREATE PROCEDURE InsertUserProviderRelation(
		userid			BIGINT,
		providerid		BIGINT,
		providername	VARCHAR(50),
		userfirstname	VARCHAR(50),
		userlastname	VARCHAR(50),
		usertype		CHAR(1),
		doctortype		CHAR(1),
		providertype	CHAR(1),
		username		VARCHAR(30),
		createdby		 BIGINT,
	    OUT id 			 BIGINT)
BEGIN

	SET @Now = NOW();
	
	INSERT INTO UserProviderRelation
	(
		userid		,
		providerid	,
		providername,
		userfirstname,
		userlastname,
		usertype	,
		doctortype	,
		providertype,
		username	,
		createdby	,
		createdAt	,
		lastmodifiedby,
		lastmodifiedat
	)
	VALUE
	(
		userid		,
		providerid	,
		providername,
		userfirstname,
		userlastname,
		usertype	,
		doctortype	,
		providertype,
		username	,
		createdby,
		@Now,
		createdby,
		@Now

	);

	SELECT LAST_INSERT_ID() INTO id;
END //


-- Stored procedure to get provider info
DROP PROCEDURE IF EXISTS GetUserProviderRelationByUserId //
CREATE PROCEDURE GetUserProviderRelationByUserId(id BIGINT)
BEGIN
	SELECT 
		up.id	,
		up.userid	,
		up.providerid	,
		up.providername,
		up.userfirstname,
		up.userlastname,
		up.usertype	,
		up.doctortype	,
		up.providertype,
		up.username	,
		up.createdby	,
		up.createdAt	,
		up.lastmodifiedby,
		up.lastmodifiedat
	FROM UserProvierRelation up
	WHERE up.userid = id;
END //

DROP PROCEDURE IF EXISTS GetUserProviderRelationByProviderId //
CREATE PROCEDURE GetUserProviderRelationByProviderId(id BIGINT)
BEGIN
	SELECT 
	
		up.id	,
		up.userid	,
		up.providerid	,
		up.providername,
		up.userfirstname,
		up.userlastname,
		up.usertype	,
		up.doctortype	,
		up.providertype,
		up.username	,
		up.createdby	,
		up.createdAt	,
		up.lastmodifiedby,
		up.lastmodifiedat
	FROM UserProvierRelation up
	WHERE up.providerid = id;
END //

-- Stored procedure to delete User Provider relation

DROP PROCEDURE IF EXISTS DeleteUserProviderRelation //
 
CREATE PROCEDURE DeleteUserProviderRelation(id BIGINT)
BEGIN
	DELETE FROM UserProviderRelation 
	WHERE id = id;
END //








-- -------------------------------------
-- SPROC CLAIM
-- --------------------------------------
-- Stored procedure to insert Claim info
DROP PROCEDURE IF EXISTS InsertClaim //
CREATE PROCEDURE InsertClaim(
		diand			BIGINT,
 		isInjury			TINYINT(1) ,
 		injuryDate			DATETIME,
 		injuryPlace			VARCHAR(50),
 		injuryOther			VARCHAR(50),
 		isOtherInjuryPlan			TINYINT(1),
 		otherInjuryPlanName			VARCHAR(30),
 		otherInjuryClaimNumber			VARCHAR(30),
 		otherInjuryClaimAmount			DECIMAL(10, 2),
 		injuryApprovalStatus			CHAR(1),
 		injuryApprovalBy			BIGINT,
 		injuryApprovedAt			DATETIME,
 		injuryApprovalNumber			VARCHAR(30),
 		injuryDenialReason			VARCHAR(50),
 		examAmount			DECIMAL(10, 2),
 		examApprovalStatus			CHAR(1),
 		examApprovedBy			BIGINT,
 		examApprovedAt			DATETIME,
 		examApprovalNumber			VARCHAR(30),
 		examDenialReason			VARCHAR(50),
 		examProvider			BIGINT,
 		examDoctor			BIGINT,
 		od_prism			DECIMAL(4, 2),
 		od_base			DECIMAL(4, 2),
 		od_sphere			DECIMAL(4, 2),
 		od_cyl			DECIMAL(4, 2),
 		od_axis			DECIMAL(4, 2),
 		od_add			DECIMAL(4, 2),
 		os_prism			DECIMAL(4, 2),
 		os_base			DECIMAL(4, 2),
 		os_sphere			DECIMAL(4, 2),
 		os_cyl			DECIMAL(4, 2),
 		os_axis			DECIMAL(4, 2),
 		os_add			DECIMAL(4, 2),
 		pd			DECIMAL(4, 2),
 		exam_gst			DECIMAL(4, 2),
 		exam_pst			DECIMAL(4, 2),
 		exam_hst			DECIMAL(4, 2),
 		exam_copay_amount			DECIMAL(10, 2),
 		glassesApprovalStatus			CHAR(1),
 		glassesApprovedBy			BIGINT,
 		glassesApprovedAt			DATETIME,
 		glassesApprovalNumber			VARCHAR(30),
 		glassesDenailReason			VARCHAR(50),
 		glassesProvider			BIGINT,
 		glassesOptician			BIGINT,
 		glassesframecost			DECIMAL(4, 2),
 		glassesrightlenscost			DECIMAL(4, 2),
 		glassesleftlenscost			DECIMAL(4, 2),
 		glassesscrcost			DECIMAL(4, 2),
 		glasseshardexcoatingcost			DECIMAL(4, 2),
 		glassesedgingcost			DECIMAL(4, 2),
 		glassesnylongrovingcost			DECIMAL(4, 2),
 		glassescasecost			DECIMAL(4, 2),
 		glassesframefrontcost			DECIMAL(4, 2),
 		glassestemplecost			DECIMAL(4, 2),
 		glassesothercost1			DECIMAL(4, 2),
 		glassesothercost2			DECIMAL(4, 2),
 		glassessframedesc			VARCHAR(50),
 		glassesrightlensdesc			VARCHAR(50),
 		glassesleftlensdesc			VARCHAR(50),
 		glassesscrdesc			VARCHAR(50),
 		glasseshardexcoatingdesc			VARCHAR(50),
 		glassesedgingdesc			VARCHAR(50),
 		glassesnylongrovingdesc			VARCHAR(50),
 		glassescasedesc			VARCHAR(50),
 		glassesframefrontdesc			VARCHAR(50),
 		glassestempledesc			VARCHAR(50),
 		glassesothercost1desc			VARCHAR(50),
 		glassesothercost2desc			VARCHAR(50),
 		glassesframenihb			VARCHAR(50),
 		glassesrightlensnihb			VARCHAR(50),
 		glassesleftlensnihb			VARCHAR(50),
 		glassesscrnihb			VARCHAR(50),
 		glasseshardexcoatingnihb			VARCHAR(50),
 		glassesedgingnihb			VARCHAR(50),
 		glassesnylongrovingnihb			VARCHAR(50),
 		glassescasenihb			VARCHAR(50),
 		glassesframefrontnihb			VARCHAR(50),
 		glassestemplenihb			VARCHAR(50),
 		glassesothercost1nihb			VARCHAR(50),
 		glassesothercost2nihb			VARCHAR(50),
 		glassescopay			DECIMAL(4, 2),
 		glasses_gst			DECIMAL(4, 2),
 		glasses_pst			DECIMAL(4, 2),
 		glasses_hst			DECIMAL(4, 2),
 		examcomments			VARCHAR(200),
 		glassescomments			VARCHAR(200),
 		examnihbcomments			VARCHAR(200),
 		glassesnihbcomments			VARCHAR(200),
 		comments			VARCHAR(200),
 		status			CHAR(1),
 		examPaymentStatus			CHAR(1),
 		examPaymentBy			BIGINT,
 		examPaymentAt			DATETIME,
 		examInvoiceNumber			VARCHAR(30),
 		glassesPaymentStatus			CHAR(1),
 		glassesPaymentBy			BIGINT,
 		glassesPaymentAt			DATETIME,
 		glassesInvoiceNumber			VARCHAR(30),
		createdby		 BIGINT,
	    OUT id 			 BIGINT)
BEGIN

	SET @Now = NOW();
	
	INSERT INTO Claim
	(
 		diand		,
 		isInjury		 ,
 		injuryDate		,
 		injuryPlace		,
 		injuryOther		,
 		isOtherInjuryPlan		,
 		otherInjuryPlanName		,
 		otherInjuryClaimNumber		,
 		otherInjuryClaimAmount		,
 		injuryApprovalStatus		,
 		injuryApprovalBy		,
 		injuryApprovedAt		,
 		injuryApprovalNumber		,
 		injuryDenialReason		,
 		examAmount		,
 		examApprovalStatus		,
 		examApprovedBy		,
 		examApprovedAt		,
 		examApprovalNumber		,
 		examDenialReason		,
 		examProvider		,
 		examDoctor		,
 		od_prism		,
 		od_base		,
 		od_sphere		,
 		od_cyl		,
 		od_axis		,
 		od_add		,
 		os_prism		,
 		os_base		,
 		os_sphere		,
 		os_cyl		,
 		os_axis		,
 		os_add		,
 		pd		,
 		exam_gst		,
 		exam_pst		,
 		exam_hst		,
 		exam_copay_amount		,
 		glassesApprovalStatus		,
 		glassesApprovedBy		,
 		glassesApprovedAt		,
 		glassesApprovalNumber		,
 		glassesDenailReason		,
 		glassesProvider		,
 		glassesOptician		,
 		glassesframecost		,
 		glassesrightlenscost		,
 		glassesleftlenscost		,
 		glassesscrcost		,
 		glasseshardexcoatingcost		,
 		glassesedgingcost		,
 		glassesnylongrovingcost		,
 		glassescasecost		,
 		glassesframefrontcost		,
 		glassestemplecost		,
 		glassesothercost1		,
 		glassesothercost2		,
 		glassessframedesc		,
 		glassesrightlensdesc		,
 		glassesleftlensdesc		,
 		glassesscrdesc		,
 		glasseshardexcoatingdesc		,
 		glassesedgingdesc		,
 		glassesnylongrovingdesc		,
 		glassescasedesc		,
 		glassesframefrontdesc		,
 		glassestempledesc		,
 		glassesothercost1desc		,
 		glassesothercost2desc		,
 		glassesframenihb		,
 		glassesrightlensnihb		,
 		glassesleftlensnihb		,
 		glassesscrnihb		,
 		glasseshardexcoatingnihb		,
 		glassesedgingnihb		,
 		glassesnylongrovingnihb		,
 		glassescasenihb		,
 		glassesframefrontnihb		,
 		glassestemplenihb		,
 		glassesothercost1nihb		,
 		glassesothercost2nihb		,
 		glassescopay		,
 		glasses_gst		,
 		glasses_pst		,
 		glasses_hst		,
 		examcomments		,
 		glassescomments		,
 		examnihbcomments		,
 		glassesnihbcomments		,
 		comments		,
 		createdby		,
 		createdAt		,
 		status		,
 		examPaymentStatus		,
 		examPaymentBy		,
 		examPaymentAt		,
 		examInvoiceNumber		,
 		glassesPaymentStatus		,
 		glassesPaymentBy		,
 		glassesPaymentAt		,
 		glassesInvoiceNumber		,
 		lastmodifiedby		,
 		lastmodifiedat		
	)
	VALUE
	(
 		diand		,
 		isInjury		 ,
 		injuryDate		,
 		injuryPlace		,
 		injuryOther		,
 		isOtherInjuryPlan		,
 		otherInjuryPlanName		,
 		otherInjuryClaimNumber		,
 		otherInjuryClaimAmount		,
 		injuryApprovalStatus		,
 		injuryApprovalBy		,
 		injuryApprovedAt		,
 		injuryApprovalNumber		,
 		injuryDenialReason		,
 		examAmount		,
 		examApprovalStatus		,
 		examApprovedBy		,
 		examApprovedAt		,
 		examApprovalNumber		,
 		examDenialReason		,
 		examProvider		,
 		examDoctor		,
 		od_prism		,
 		od_base		,
 		od_sphere		,
 		od_cyl		,
 		od_axis		,
 		od_add		,
 		os_prism		,
 		os_base		,
 		os_sphere		,
 		os_cyl		,
 		os_axis		,
 		os_add		,
 		pd		,
 		exam_gst		,
 		exam_pst		,
 		exam_hst		,
 		exam_copay_amount		,
 		glassesApprovalStatus		,
 		glassesApprovedBy		,
 		glassesApprovedAt		,
 		glassesApprovalNumber		,
 		glassesDenailReason		,
 		glassesProvider		,
 		glassesOptician		,
 		glassesframecost		,
 		glassesrightlenscost		,
 		glassesleftlenscost		,
 		glassesscrcost		,
 		glasseshardexcoatingcost		,
 		glassesedgingcost		,
 		glassesnylongrovingcost		,
 		glassescasecost		,
 		glassesframefrontcost		,
 		glassestemplecost		,
 		glassesothercost1		,
 		glassesothercost2		,
 		glassessframedesc		,
 		glassesrightlensdesc		,
 		glassesleftlensdesc		,
 		glassesscrdesc		,
 		glasseshardexcoatingdesc		,
 		glassesedgingdesc		,
 		glassesnylongrovingdesc		,
 		glassescasedesc		,
 		glassesframefrontdesc		,
 		glassestempledesc		,
 		glassesothercost1desc		,
 		glassesothercost2desc		,
 		glassesframenihb		,
 		glassesrightlensnihb		,
 		glassesleftlensnihb		,
 		glassesscrnihb		,
 		glasseshardexcoatingnihb		,
 		glassesedgingnihb		,
 		glassesnylongrovingnihb		,
 		glassescasenihb		,
 		glassesframefrontnihb		,
 		glassestemplenihb		,
 		glassesothercost1nihb		,
 		glassesothercost2nihb		,
 		glassescopay		,
 		glasses_gst		,
 		glasses_pst		,
 		glasses_hst		,
 		examcomments		,
 		glassescomments		,
 		examnihbcomments		,
 		glassesnihbcomments		,
 		comments		,
		createdby,
		@Now,
 		status		,
 		examPaymentStatus		,
 		examPaymentBy		,
 		examPaymentAt		,
 		examInvoiceNumber		,
 		glassesPaymentStatus		,
 		glassesPaymentBy		,
 		glassesPaymentAt		,
 		glassesInvoiceNumber		,
		createdby,
		@Now

	);

	SELECT LAST_INSERT_ID() INTO id;
END //


-- Stored procedure to get Claim info
DROP PROCEDURE IF EXISTS GetClaim //
CREATE PROCEDURE GetClaim(id BIGINT)
BEGIN
	SELECT 
 		c.id		,
 		c.diand		,
 		c.isInjury		 ,
 		c.injuryDate		,
 		c.injuryPlace		,
 		c.injuryOther		,
 		c.isOtherInjuryPlan		,
 		c.otherInjuryPlanName		,
 		c.otherInjuryClaimNumber		,
 		c.otherInjuryClaimAmount		,
 		c.injuryApprovalStatus		,
 		c.injuryApprovalBy		,
 		c.injuryApprovedAt		,
 		c.injuryApprovalNumber		,
 		c.injuryDenialReason		,
 		c.examAmount		,
 		c.examApprovalStatus		,
 		c.examApprovedBy		,
 		c.examApprovedAt		,
 		c.examApprovalNumber		,
 		c.examDenialReason		,
 		c.examProvider		,
 		c.examDoctor		,
 		c.od_prism		,
 		c.od_base		,
 		c.od_sphere		,
 		c.od_cyl		,
 		c.od_axis		,
 		c.od_add		,
 		c.os_prism		,
 		c.os_base		,
 		c.os_sphere		,
 		c.os_cyl		,
 		c.os_axis		,
 		c.os_add		,
 		c.pd		,
 		c.exam_gst		,
 		c.exam_pst		,
 		c.exam_hst		,
 		c.exam_copay_amount		,
 		c.glassesApprovalStatus		,
 		c.glassesApprovedBy		,
 		c.glassesApprovedAt		,
 		c.glassesApprovalNumber		,
 		c.glassesDenailReason		,
 		c.glassesProvider		,
 		c.glassesOptician		,
 		c.glassesframecost		,
 		c.glassesrightlenscost		,
 		c.glassesleftlenscost		,
 		c.glassesscrcost		,
 		c.glasseshardexcoatingcost		,
 		c.glassesedgingcost		,
 		c.glassesnylongrovingcost		,
 		c.glassescasecost		,
 		c.glassesframefrontcost		,
 		c.glassestemplecost		,
 		c.glassesothercost1		,
 		c.glassesothercost2		,
 		c.glassessframedesc		,
 		c.glassesrightlensdesc		,
 		c.glassesleftlensdesc		,
 		c.glassesscrdesc		,
 		c.glasseshardexcoatingdesc		,
 		c.glassesedgingdesc		,
 		c.glassesnylongrovingdesc		,
 		c.glassescasedesc		,
 		c.glassesframefrontdesc		,
 		c.glassestempledesc		,
 		c.glassesothercost1desc		,
 		c.glassesothercost2desc		,
 		c.glassesframenihb		,
 		c.glassesrightlensnihb		,
 		c.glassesleftlensnihb		,
 		c.glassesscrnihb		,
 		c.glasseshardexcoatingnihb		,
 		c.glassesedgingnihb		,
 		c.glassesnylongrovingnihb		,
 		c.glassescasenihb		,
 		c.glassesframefrontnihb		,
 		c.glassestemplenihb		,
 		c.glassesothercost1nihb		,
 		c.glassesothercost2nihb		,
 		c.glassescopay		,
 		c.glasses_gst		,
 		c.glasses_pst		,
 		c.glasses_hst		,
 		c.examcomments		,
 		c.glassescomments		,
 		c.examnihbcomments		,
 		c.glassesnihbcomments		,
 		c.comments		,
 		c.createdby		,
 		c.createdAt		,
 		c.status		,
 		c.examPaymentStatus		,
 		c.examPaymentBy		,
 		c.examPaymentAt		,
 		c.examInvoiceNumber		,
 		c.glassesPaymentStatus		,
 		c.glassesPaymentBy		,
 		c.glassesPaymentAt		,
 		c.glassesInvoiceNumber		,
 		c.lastmodifiedby		,
 		c.lastmodifiedat		
	FROM Claim c 
	WHERE c.id = id;
END //


-- Stored procedure to update claim  
DROP PROCEDURE IF EXISTS UpdateClaim //
CREATE PROCEDURE UpdateClaim(
		 id				 BIGINT ,
		diand			BIGINT,
 		isInjury			TINYINT(1) ,
 		injuryDate			DATETIME,
 		injuryPlace			VARCHAR(50),
 		injuryOther			VARCHAR(50),
 		isOtherInjuryPlan			TINYINT(1),
 		otherInjuryPlanName			VARCHAR(30),
 		otherInjuryClaimNumber			VARCHAR(30),
 		otherInjuryClaimAmount			DECIMAL(10, 2),
 		injuryApprovalStatus			CHAR(1),
 		injuryApprovalBy			BIGINT,
 		injuryApprovedAt			DATETIME,
 		injuryApprovalNumber			VARCHAR(30),
 		injuryDenialReason			VARCHAR(50),
 		examAmount			DECIMAL(10, 2),
 		examApprovalStatus			CHAR(1),
 		examApprovedBy			BIGINT,
 		examApprovedAt			DATETIME,
 		examApprovalNumber			VARCHAR(30),
 		examDenialReason			VARCHAR(50),
 		examProvider			BIGINT,
 		examDoctor			BIGINT,
 		od_prism			DECIMAL(4, 2),
 		od_base			DECIMAL(4, 2),
 		od_sphere			DECIMAL(4, 2),
 		od_cyl			DECIMAL(4, 2),
 		od_axis			DECIMAL(4, 2),
 		od_add			DECIMAL(4, 2),
 		os_prism			DECIMAL(4, 2),
 		os_base			DECIMAL(4, 2),
 		os_sphere			DECIMAL(4, 2),
 		os_cyl			DECIMAL(4, 2),
 		os_axis			DECIMAL(4, 2),
 		os_add			DECIMAL(4, 2),
 		pd			DECIMAL(4, 2),
 		exam_gst			DECIMAL(4, 2),
 		exam_pst			DECIMAL(4, 2),
 		exam_hst			DECIMAL(4, 2),
 		exam_copay_amount			DECIMAL(10, 2),
 		glassesApprovalStatus			CHAR(1),
 		glassesApprovedBy			BIGINT,
 		glassesApprovedAt			DATETIME,
 		glassesApprovalNumber			VARCHAR(30),
 		glassesDenailReason			VARCHAR(50),
 		glassesProvider			BIGINT,
 		glassesOptician			BIGINT,
 		glassesframecost			DECIMAL(4, 2),
 		glassesrightlenscost			DECIMAL(4, 2),
 		glassesleftlenscost			DECIMAL(4, 2),
 		glassesscrcost			DECIMAL(4, 2),
 		glasseshardexcoatingcost			DECIMAL(4, 2),
 		glassesedgingcost			DECIMAL(4, 2),
 		glassesnylongrovingcost			DECIMAL(4, 2),
 		glassescasecost			DECIMAL(4, 2),
 		glassesframefrontcost			DECIMAL(4, 2),
 		glassestemplecost			DECIMAL(4, 2),
 		glassesothercost1			DECIMAL(4, 2),
 		glassesothercost2			DECIMAL(4, 2),
 		glassessframedesc			VARCHAR(50),
 		glassesrightlensdesc			VARCHAR(50),
 		glassesleftlensdesc			VARCHAR(50),
 		glassesscrdesc			VARCHAR(50),
 		glasseshardexcoatingdesc			VARCHAR(50),
 		glassesedgingdesc			VARCHAR(50),
 		glassesnylongrovingdesc			VARCHAR(50),
 		glassescasedesc			VARCHAR(50),
 		glassesframefrontdesc			VARCHAR(50),
 		glassestempledesc			VARCHAR(50),
 		glassesothercost1desc			VARCHAR(50),
 		glassesothercost2desc			VARCHAR(50),
 		glassesframenihb			VARCHAR(50),
 		glassesrightlensnihb			VARCHAR(50),
 		glassesleftlensnihb			VARCHAR(50),
 		glassesscrnihb			VARCHAR(50),
 		glasseshardexcoatingnihb			VARCHAR(50),
 		glassesedgingnihb			VARCHAR(50),
 		glassesnylongrovingnihb			VARCHAR(50),
 		glassescasenihb			VARCHAR(50),
 		glassesframefrontnihb			VARCHAR(50),
 		glassestemplenihb			VARCHAR(50),
 		glassesothercost1nihb			VARCHAR(50),
 		glassesothercost2nihb			VARCHAR(50),
 		glassescopay			DECIMAL(4, 2),
 		glasses_gst			DECIMAL(4, 2),
 		glasses_pst			DECIMAL(4, 2),
 		glasses_hst			DECIMAL(4, 2),
 		examcomments			VARCHAR(200),
 		glassescomments			VARCHAR(200),
 		examnihbcomments			VARCHAR(200),
 		glassesnihbcomments			VARCHAR(200),
 		comments			VARCHAR(200),
 		status			CHAR(1),
 		examPaymentStatus			CHAR(1),
 		examPaymentBy			BIGINT,
 		examPaymentAt			DATETIME,
 		examInvoiceNumber			VARCHAR(30),
 		glassesPaymentStatus			CHAR(1),
 		glassesPaymentBy			BIGINT,
 		glassesPaymentAt			DATETIME,
 		glassesInvoiceNumber			VARCHAR(30),
		modifiedby		 BIGINT
	)

BEGIN
	SET @Now = NOW();
	UPDATE Claim c 
	SET 
 		c.diand = diand		,
 		c.isInjury = isInjury		 ,
 		c.injuryDate = 	injuryDate	,
 		c.injuryPlace =injuryPlace		,
 		c.injuryOther = injuryOther		,
 		c.isOtherInjuryPlan = isOtherInjuryPlan		,
 		c.otherInjuryPlanName = otherInjuryPlanName		,
 		c.otherInjuryClaimNumber= otherInjuryClaimNumber		,
 		c.otherInjuryClaimAmount = otherInjuryClaimAmount		,
 		c.injuryApprovalStatus	 =injuryApprovalStatus	,
 		c.injuryApprovalBy	=injuryApprovalBy	,
 		c.injuryApprovedAt	=injuryApprovedAt	,
 		c.injuryApprovedAt	=injuryApprovedAt	,
 		c.injuryDenialReason =injuryDenialReason		,
 		c.examAmount	 = examAmount	,
 		c.examApprovalStatus =examApprovalStatus		,
 		c.examApprovedBy =examApprovedBy		,
 		c.examApprovedAt =examApprovedAt		,
 		c.examApprovalNumber = examApprovalNumber		,
 		c.examDenialReason =examDenialReason		,
 		c.examProvider = examProvider		,
 		c.examDoctor =examDoctor		,
 		c.od_prism=od_prism		,
 		c.od_base =od_base		,
 		c.od_sphere = od_sphere		,
 		c.od_cyl = od_cyl		,
 		c.od_axis = od_axis		,
 		c.od_add = od_add		,
 		c.os_prism = os_prism		,
 		c.os_base = os_base		,
 		c.os_sphere = os_sphere		,
 		c.os_cyl = os_cyl		,
 		c.os_axis = os_axis		,
 		c.os_add = os_add		,
 		c.pd = pd		,
 		c.exam_gst = exam_gst		,
 		c.exam_pst = exam_pst		,
 		c.exam_hst = exam_hst		,
 		c.exam_copay_amount = exam_copay_amount		,
 		c.glassesApprovalStatus = glassesApprovalStatus		,
 		c.glassesApprovedBy = glassesApprovedBy		,
 		c.glassesApprovedAt = glassesApprovedAt		,
 		c.glassesApprovalNumber = glassesApprovalNumber		,
 		c.glassesDenailReason = glassesDenailReason		,
 		c.glassesProvider = glassesProvider		,
 		c.glassesOptician = glassesOptician		,
 		c.glassesframecost = glassesframecost		,
 		c.glassesrightlenscost = glassesrightlenscost		,
 		c.glassesleftlenscost = glassesleftlenscost		,
 		c.glassesscrcost = glassesscrcost		,
 		c.glasseshardexcoatingcost = glasseshardexcoatingcost		,
 		c.glassesedgingcost = glassesedgingcost		,
 		c.glassesnylongrovingcost = glassesnylongrovingcost		,
 		c.glassescasecost = glassescasecost		,
 		c.glassesframefrontcost = glassesframefrontcost		,
 		c.glassestemplecost = glassestemplecost		,
 		c.glassesothercost1 = glassesothercost1		,
 		c.glassesothercost2 = glassesothercost2		,
 		c.glassessframedesc = glassessframedesc		,
 		c.glassesrightlensdesc = glassesrightlensdesc		,
 		c.glassesleftlensdesc = glassesleftlensdesc		,
 		c.glassesscrdesc = glassesscrdesc		,
 		c.glasseshardexcoatingdesc = glasseshardexcoatingdesc		,
 		c.glassesedgingdesc = glassesedgingdesc		,
 		c.glassesnylongrovingdesc = glassesnylongrovingdesc		,
 		c.glassescasedesc = glassescasedesc		,
 		c.glassesframefrontdesc = glassesframefrontdesc		,
 		c.glassestempledesc = glassestempledesc		,
 		c.glassesothercost1desc = glassesothercost1desc		,
 		c.glassesothercost2desc = glassesothercost2desc		,
 		c.glassesframenihb = glassesframenihb		,
 		c.glassesrightlensnihb = glassesrightlensnihb		,
 		c.glassesleftlensnihb = glassesleftlensnihb		,
 		c.glassesscrnihb = glassesscrnihb		,
 		c.glasseshardexcoatingnihb = glasseshardexcoatingnihb		,
 		c.glassesedgingnihb = glassesedgingnihb		,
 		c.glassesnylongrovingnihb = glassesnylongrovingnihb		,
 		c.glassescasenihb = glassescasenihb		,
 		c.glassesframefrontnihb = glassesframefrontnihb		,
 		c.glassestemplenihb = glassestemplenihb		,
 		c.glassesothercost1nihb = glassesothercost1nihb		,
 		c.glassesothercost2nihb = glassesothercost2nihb		, 
 		c.glassescopay = glassescopay		,
 		c.glasses_gst = glasses_gst		,
 		c.glasses_pst = glasses_pst		,
 		c.glasses_hst = glasses_hst		,
 		c.examcomments = examcomments		,
 		c.glassescomments = glassescomments		,
 		c.examnihbcomments = examnihbcomments		,
 		c.glassesnihbcomments = glassesnihbcomments		,
 		c.comments = comments		,
 		c.status = status		,
 		c.examPaymentStatus = examPaymentStatus		,
 		c.examPaymentBy = examPaymentBy		,
 		c.examPaymentAt = examPaymentAt		,
 		c.examInvoiceNumber = examInvoiceNumber		,
 		c.glassesPaymentStatus = glassesPaymentStatus		,
 		c.glassesPaymentBy = glassesPaymentBy		,
 		c.glassesPaymentAt	= glassesPaymentAt	,
 		c.glassesInvoiceNumber	=glassesInvoiceNumber	,
 
		c.lastmodifiedby = modifiedby,
		c.lastmodifiedat = @Now

	WHERE c.id = id;
END //
 

-- Stored procedure to change Claim status

DROP PROCEDURE IF EXISTS ChangeClaimStatus //
 
CREATE PROCEDURE ChangeClaimStatus(
		id	 		BIGINT,
		status		CHAR(1),
		modifiedby  BIGINT
)
BEGIN
	SET @Now = NOW();
	UPDATE Claim c
	SET c.status =status,
		c.lastmodifiedby = modifiedby,
		c.lastmodifiedat = @Now
	WHERE c.id = id;
END //


