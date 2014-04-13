/**
 * 
 */
package com.nihb.server.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.mysql.jdbc.NotImplemented;
import com.nihb.common.entity.Claim;
import com.nihb.common.entity.Provider;
import com.nihb.common.entity.User;
import com.nihb.common.helper.ApprovalInfo;
import com.nihb.common.helper.ExamInfo;
import com.nihb.common.helper.EyeCheckInfo;
import com.nihb.common.helper.GlassesDetail;
import com.nihb.common.helper.GlassesInfo;
import com.nihb.common.helper.GlassesItem;
import com.nihb.common.helper.InjuryInfo;
import com.nihb.common.helper.NihbDecimal;
import com.nihb.common.helper.PaymentInfo;
import com.nihb.common.helper.Prescription;
import com.nihb.common.helper.Status;
import com.nihb.common.helper.Tax;
import com.nihb.common.helper.VisionInfo;
import com.nihb.resource.ErrorMessages;

/**
 * @author kaiwu
 *
 */
public class ClaimDao extends AbstractDataAccess<Claim> {

	
		public static final String DIAND = "diand";
		public static final String ISINJURY = "isInjury";
		public static final String INJURYDATE = "injuryDate";
		public static final String INJURYPLACE = "injuryPlace";
		public static final String INJURYOTHER = "injuryOther";
		public static final String ISOTHERINJURYPLAN = "isOtherInjuryPlan";
		public static final String OTHERINJURYPLANNAME = "otherInjuryPlanName";
		public static final String OTHERJNJURYCLAIMNUMBER = "otherInjuryClaimNumber";
		public static final String OTHERINJURYCLAIMAMOUNT = "otherInjuryClaimAmount";
		public static final String INJURYAPPROVALSTATUS = "injuryApprovalStatus";
		public static final String INJURYAPPROVALBY = "injuryApprovalBy";
		public static final String INJURYAPPROVALAT = "injuryApprovedAt";
		public static final String INJURYAPPROVALNUMBER = "injuryApprovalNumber";
		public static final String INJURYDENIALREASON = "injuryDenialReason";
		public static final String EXAMAMOUNT = "examAmount";
		public static final String EXAMAPPROVALSTATUS = "examApprovalStatus";
		public static final String EXAMAPPROVEBY = "examApprovedBy";
		public static final String EXAMAPPROVEAT = "examApprovedAt";
		public static final String EXAMAPPROVALNUMBER = "examApprovalNumber";
		public static final String EXAMDENIALREASON = "examDenialReason";
		public static final String EXAMPROVIDER = "examProvider";
		public static final String EXAMDOCTOR = "examDoctor";
		public static final String OD_PRISM = "od_prism";
		public static final String OD_BASE = "od_base";
		public static final String OD_SPHERE = "od_sphere";
		public static final String OD_CYL = "od_cyl";
		public static final String OD_AXIS = "od_axis";
		public static final String OD_ADD = "od_add";
		public static final String OS_PRISM = "os_prism";
		public static final String OS_BASE= "os_base";
		public static final String OS_SPHERE = "os_sphere";
		public static final String OS_CYL = "os_cyl";
		public static final String OS_AXIS = "os_axis";
		public static final String OS_ADD = "os_add";
		public static final String PD = "pd";
		public static final String EXAM_GST = "exam_gst";
		public static final String EXAM_PST = "exam_pst";
		public static final String EXAM_HST = "exam_hst";
		public static final String EXAM_COPAY_AMOUNT = "exam_copay_amount";
		public static final String GLASSESAPPROVALSTATUS = "glassesApprovalStatus";
		public static final String GLASSESAPPROVEDBY = "glassesApprovedBy";
		public static final String GLASSESAPPROVEAT = "glassesApprovedAt";
		public static final String GLASSESAPPPROVALNUMBER = "glassesApprovalNumber";
		public static final String GLASSESDENIALREASON = "glassesDenailReason";
		public static final String GLASSESPROVIDER = "glassesProvider";
		public static final String GLASSESOPTICIAN = "glassesOptician";
		public static final String GLASSESFRAMECOST = "glassesframecost";
		public static final String GLASSESRIGHTLENCOST = "glassesrightlenscost";
		public static final String GLASSESLEFTLENCOST = "glassesleftlenscost";
		public static final String GLASSESSCRCOST = "glassesscrcost";
		public static final String GLASSESHARDEXCOATINGCOST = "glasseshardexcoatingcost";
		public static final String GLASSESEDGINGCOST = "glassesedgingcost";
		public static final String GLASSESNYLONGROVINGCOST = "glassesnylongrovingcost";
		public static final String GLASSESCASECOST = "glassescasecost";
		public static final String GLASSESFRAMEFRONTCOST = "glassesframefrontcost";
		public static final String GLASSESTEMPLECOST = "glassestemplecost";
		public static final String GLASSESOTHERCOST1 = "glassesothercost1";
		public static final String GLASSESOTHERCOST2 = "glassesothercost2";
		public static final String GLASSESFRAMEDESC = "glassessframedesc";
		public static final String GLASSESRIGHTLENSDESC = "glassesrightlensdesc";
		public static final String GLASSESLEFTLENDESC = "glassesleftlensdesc";
		public static final String GLASSESSCRDESC = "glassesscrdesc";
		public static final String GLASSESHARDEXCOATINGDESC = "glasseshardexcoatingdesc";
		public static final String GLASSESEDGINGDESC = "glassesedgingdesc";
		public static final String GLASSESNYLONGROVINGDESC = "glassesnylongrovingdesc";
		public static final String GLASSESCASEDESC = "glassescasedesc";
		public static final String GLASSESFRAMEFRONTDESC = "glassesframefrontdesc";
		public static final String GLASSESTEMPLEDESC = "glassestempledesc";
		public static final String GLASSESOTHERCOST1DESC = "glassesothercost1desc";
		public static final String GLASSESOTHERCOST2DESC = "glassesothercost2desc";
		public static final String GLASSESFRAMENIHB = "glassesframenihb";
		public static final String GLASSESRIGHTLENSNIHB = "glassesrightlensnihb";
		public static final String GLASSESLEFTLENSNIHB = "glassesleftlensnihb";
		public static final String GLASSESSCRNIHB = "glassesscrnihb";
		public static final String GLASSESHARDEXCOATINGNIHB = "glasseshardexcoatingnihb";
		public static final String GLASSESEDGINGNIHB = "glassesedgingnihb";
		public static final String GLASSESNYLONGROVINGNIHB = "glassesnylongrovingnihb";
		public static final String GLASSESCASENIHB = "glassescasenihb";
		public static final String GLASSESFRAMEFRONTNIHB = "glassesframefrontnihb";
		public static final String GLASSESTEMPLENIHB = "glassestemplenihb";
		public static final String GLASSESOTHERCOST1NIHB = "glassesothercost1nihb";
		public static final String GLASSESOTHERCOST2NIHB = "glassesothercost2nihb";
		public static final String GLASSESCOPAY = "glassescopay";
		public static final String GLASSES_GST = "glasses_gst";
		public static final String GLASSES_PST = "glasses_pst";
		public static final String GLASSES_HST = "glasses_hst";
		public static final String EXAMCOMMENTS = "examcomments";
		public static final String GLASSESCOMMENTS = "glassescomments";
		public static final String EXAMNIHBCOMMENTS = "examnihbcomments";
		public static final String GLASSESNIHBCOMMENTS = "glassesnihbcomments";
		public static final String COMMENTS = "comments";
		public static final String EXAMPAYMENTSTATUS = "examPaymentStatus";
		public static final String EXAMPAYMENTBY = "examPaymentBy";
		public static final String EXAMPAYMENTAT = "examPaymentAt";
		public static final String EXAMINVOICENUMBER = "examInvoiceNumber";
		public static final String GLASSESPAPYMENTSTATUS = "glassesPaymentStatus";
		public static final String GLASSESPAYMENTBY = "glassesPaymentBy";
		public static final String GLASSESPAYMENTAT = "glassesPaymentAt";
		public static final String GLASSESINVOICENUMBER = "glassesInvoiceNumber";

	
		static final String FIND_BY_ID="{call GetClaim(?)}";
		static final String INSERT_CLAIM="{CALL InsertClaim("
				+"?,"//diand		BIGINT,
		 		+"?,"//isInjury		TINYINT(1) ,
		 		+"?,"//injuryDate		DATETIME,
		 		+"?,"//injuryPlace		VARCHAR(50),
		 		+"?,"//injuryOther		VARCHAR(50),
		 		+"?,"//isOtherInjuryPlan		TINYINT(1),
		 		+"?,"//otherInjuryPlanName		VARCHAR(30),
		 		+"?,"//otherInjuryClaimNumber		VARCHAR(30),
		 		+"?,"//otherInjuryClaimAmount		DECIMAL(10, 2),
		 		+"?,"//examAmount		DECIMAL(10, 2),
		 		+"?,"//examApprovalStatus		CHAR(1),
		 		+"?,"//examApprovedBy		BIGINT,
		 		+"?,"//examApprovedAt		DATETIME,
		 		+"?,"//examApprovalNumber		VARCHAR(30),
		 		+"?,"//examDenialReason		VARCHAR(50),
		 		+"?,"//examProvider		BIGINT,
		 		+"?,"//examDoctor		BIGINT,
		 		+"?,"//od_prism		DECIMAL(4, 2),
		 		+"?,"//od_base		DECIMAL(4, 2),
		 		+"?,"//od_sphere		DECIMAL(4, 2),
		 		+"?,"//od_cyl		DECIMAL(4, 2),
		 		+"?,"//od_axis		DECIMAL(4, 2),
		 		+"?,"//od_add		DECIMAL(4, 2),
		 		+"?,"//os_prism		DECIMAL(4, 2),
		 		+"?,"//os_base		DECIMAL(4, 2),
		 		+"?,"//os_sphere		DECIMAL(4, 2),
		 		+"?,"//os_cyl		DECIMAL(4, 2),
		 		+"?,"//os_axis		DECIMAL(4, 2),
		 		+"?,"//os_add		DECIMAL(4, 2),
		 		+"?,"//pd		DECIMAL(4, 2),
		 		+"?,"//exam_gst		DECIMAL(4, 2),
		 		+"?,"//exam_pst		DECIMAL(4, 2),
		 		+"?,"//exam_hst		DECIMAL(4, 2),
		 		+"?,"//exam_copay_amount		DECIMAL(10, 2),
		 		+"?,"//examcomments		VARCHAR(200),
		 		+"?,"//examnihbcomments		VARCHAR(200),
		 		+"?,"//comments		VARCHAR(200),
		 		+"?,"//status		CHAR(1),
				+"?,"//createdby		BIGINT,
				+"?"//OUT id 		 BIGINT)
				+")}";

		static final String UPDATE_CLAIM="{CALL UpdateClaim("
				+"?,"// id 		 BIGINT)
				+"?,"//diand		BIGINT,
		 		+"?,"//isInjury		TINYINT(1) ,
		 		+"?,"//injuryDate		DATETIME,
		 		+"?,"//injuryPlace		VARCHAR(50),
		 		+"?,"//injuryOther		VARCHAR(50),
		 		+"?,"//isOtherInjuryPlan		TINYINT(1),
		 		+"?,"//otherInjuryPlanName		VARCHAR(30),
		 		+"?,"//otherInjuryClaimNumber		VARCHAR(30),
		 		+"?,"//otherInjuryClaimAmount		DECIMAL(10, 2),
		 		+"?,"//injuryApprovalStatus		CHAR(1),
		 		+"?,"//injuryApprovalBy		BIGINT,
		 		+"?,"//injuryApprovedAt		DATETIME,
		 		+"?,"//injuryApprovalNumber		VARCHAR(30),
		 		+"?,"//injuryDenialReason		VARCHAR(50),
		 		+"?,"//examAmount		DECIMAL(10, 2),
		 		+"?,"//examApprovalStatus		CHAR(1),
		 		+"?,"//examApprovedBy		BIGINT,
		 		+"?,"//examApprovedAt		DATETIME,
		 		+"?,"//examApprovalNumber		VARCHAR(30),
		 		+"?,"//examDenialReason		VARCHAR(50),
		 		+"?,"//examProvider		BIGINT,
		 		+"?,"//examDoctor		BIGINT,
		 		+"?,"//od_prism		DECIMAL(4, 2),
		 		+"?,"//od_base		DECIMAL(4, 2),
		 		+"?,"//od_sphere		DECIMAL(4, 2),
		 		+"?,"//od_cyl		DECIMAL(4, 2),
		 		+"?,"//od_axis		DECIMAL(4, 2),
		 		+"?,"//od_add		DECIMAL(4, 2),
		 		+"?,"//os_prism		DECIMAL(4, 2),
		 		+"?,"//os_base		DECIMAL(4, 2),
		 		+"?,"//os_sphere		DECIMAL(4, 2),
		 		+"?,"//os_cyl		DECIMAL(4, 2),
		 		+"?,"//os_axis		DECIMAL(4, 2),
		 		+"?,"//os_add		DECIMAL(4, 2),
		 		+"?,"//pd		DECIMAL(4, 2),
		 		+"?,"//exam_gst		DECIMAL(4, 2),
		 		+"?,"//exam_pst		DECIMAL(4, 2),
		 		+"?,"//exam_hst		DECIMAL(4, 2),
		 		+"?,"//exam_copay_amount		DECIMAL(10, 2),
		 		+"?,"//glassesApprovalStatus		CHAR(1),
		 		+"?,"//glassesApprovedBy		BIGINT,
		 		+"?,"//glassesApprovedAt		DATETIME,
		 		+"?,"//glassesApprovalNumber		VARCHAR(30),
		 		+"?,"//glassesDenailReason		VARCHAR(50),
		 		+"?,"//glassesProvider		BIGINT,
		 		+"?,"//glassesOptician		BIGINT,
		 		+"?,"//glassesframecost		DECIMAL(4, 2),
		 		+"?,"//glassesrightlenscost		DECIMAL(4, 2),
		 		+"?,"//glassesleftlenscost		DECIMAL(4, 2),
		 		+"?,"//glassesscrcost		DECIMAL(4, 2),
		 		+"?,"//glasseshardexcoatingcost		DECIMAL(4, 2),
		 		+"?,"//glassesedgingcost		DECIMAL(4, 2),
		 		+"?,"//glassesnylongrovingcost		DECIMAL(4, 2),
		 		+"?,"//glassescasecost		DECIMAL(4, 2),
		 		+"?,"//glassesframefrontcost		DECIMAL(4, 2),
		 		+"?,"//glassestemplecost		DECIMAL(4, 2),
		 		+"?,"//glassesothercost1		DECIMAL(4, 2),
		 		+"?,"//glassesothercost2		DECIMAL(4, 2),
		 		+"?,"//glassessframedesc		VARCHAR(50),
		 		+"?,"//glassesrightlensdesc		VARCHAR(50),
		 		+"?,"//glassesleftlensdesc		VARCHAR(50),
		 		+"?,"//glassesscrdesc		VARCHAR(50),
		 		+"?,"//glasseshardexcoatingdesc		VARCHAR(50),
		 		+"?,"//glassesedgingdesc		VARCHAR(50),
		 		+"?,"//glassesnylongrovingdesc		VARCHAR(50),
		 		+"?,"//glassescasedesc		VARCHAR(50),
		 		+"?,"//glassesframefrontdesc		VARCHAR(50),
		 		+"?,"//glassestempledesc		VARCHAR(50),
		 		+"?,"//glassesothercost1desc		VARCHAR(50),
		 		+"?,"//glassesothercost2desc		VARCHAR(50),
		 		+"?,"//glassesframenihb		VARCHAR(50),
		 		+"?,"//glassesrightlensnihb		VARCHAR(50),
		 		+"?,"//glassesleftlensnihb		VARCHAR(50),
		 		+"?,"//glassesscrnihb		VARCHAR(50),
		 		+"?,"//glasseshardexcoatingnihb		VARCHAR(50),
		 		+"?,"//glassesedgingnihb		VARCHAR(50),
		 		+"?,"//glassesnylongrovingnihb		VARCHAR(50),
		 		+"?,"//glassescasenihb		VARCHAR(50),
		 		+"?,"//glassesframefrontnihb		VARCHAR(50),
		 		+"?,"//glassestemplenihb		VARCHAR(50),
		 		+"?,"//glassesothercost1nihb		VARCHAR(50),
		 		+"?,"//glassesothercost2nihb		VARCHAR(50),
		 		+"?,"//glassescopay		DECIMAL(4, 2),
		 		+"?,"//glasses_gst		DECIMAL(4, 2),
		 		+"?,"//glasses_pst		DECIMAL(4, 2),
		 		+"?,"//glasses_hst		DECIMAL(4, 2),
		 		+"?,"//examcomments		VARCHAR(200),
		 		+"?,"//glassescomments		VARCHAR(200),
		 		+"?,"//examnihbcomments		VARCHAR(200),
		 		+"?,"//glassesnihbcomments		VARCHAR(200),
		 		+"?,"//comments		VARCHAR(200),
		 		+"?,"//status		CHAR(1),
		 		+"?,"//examPaymentStatus		CHAR(1),
		 		+"?,"//examPaymentBy		BIGINT,
		 		+"?,"//examPaymentAt		DATETIME,
		 		+"?,"//examInvoiceNumber		VARCHAR(30),
		 		+"?,"//glassesPaymentStatus		CHAR(1),
		 		+"?,"//glassesPaymentBy		BIGINT,
		 		+"?,"//glassesPaymentAt		DATETIME,
		 		+"?,"//glassesInvoiceNumber		VARCHAR(30),
				+"?"//modifiedbyby		BIGINT,
				+")}";

	static final String CHANGE_STATUS = "{CALL ChangeClaimStatus("
				+ "?,"//id 			BIGINT,
				+ "?," //status 	CHAR(1),
				+ "?"//modifiedby  BIGINT
				+ ")}";
				

	public ClaimDao(Connection conn) throws SQLException {
		super(conn);
	}

	@Override
	public List<Claim> findAll() throws Exception {
		throw new NotImplemented();
	}

	@Override
	public List<Claim> findAllBy(String queryCondition) throws Exception {
		throw new NotImplemented();
	}

	@Override
	public Claim findById(long id) throws Exception {
		Claim claim = null;
		CallableStatement cs = this.conn.prepareCall(FIND_BY_ID);
		cs.setLong(1, id);
		ResultSet result = cs.executeQuery();
			

		if(result.next()){
			claim = getClaimFromResult(result);
		}else{
			claim = new Claim();
			claim.setId(id);
			List<String> errors = new ArrayList<String>();
			errors.add(String.format(ErrorMessages.NO_RECORD_FOUND_BY_ID, id));
			claim.setErrorList(errors);
		}
		return claim;
	}

	static Claim getClaimFromResult(ResultSet result) throws SQLException{
		
		Claim claim = new Claim();
		
		claim.setId(result.getLong(ID));
		claim.setDiand(result.getLong(DIAND));
		claim.setInjury(result.getBoolean(ISINJURY));
		
		
		InjuryInfo injuryInfo = new InjuryInfo();
		
		injuryInfo.setInjuryDate(LocalDateTime.fromDateFields(result.getDate(INJURYDATE)));
		injuryInfo.setInjuryPlace(result.getString(INJURYPLACE));
		injuryInfo.setInjuryOther(result.getString(INJURYOTHER));
		injuryInfo.setOtherInjuryPlan(result.getBoolean(ISOTHERINJURYPLAN));
		injuryInfo.setOtherInjuryPlanName(result.getString(OTHERINJURYPLANNAME));
		injuryInfo.setOtherInjuryClaimNumber(result.getString(OTHERJNJURYCLAIMNUMBER));
		injuryInfo.setOtherInjuryClaimAmount(new NihbDecimal(result.getBigDecimal(OTHERINJURYPLANNAME)));
		
		ApprovalInfo injuryApprovalInfo = new ApprovalInfo();
		injuryApprovalInfo.setApprovalStatus(Status.getStatus(result.getString(INJURYAPPROVALSTATUS)));
		
		User injuryApprovalUser = new User();
		injuryApprovalUser.setId(result.getLong(INJURYAPPROVALBY));
		injuryApprovalInfo.setApprovalBy(injuryApprovalUser);
		
		injuryApprovalInfo.setApprovedAt(LocalDateTime.fromDateFields(result.getDate(INJURYAPPROVALAT)));
		injuryApprovalInfo.setApprovalNumber(result.getString(INJURYAPPROVALNUMBER));
		injuryApprovalInfo.setDenialReason(result.getString(INJURYDENIALREASON));
		
		injuryInfo.setApprovalInfo(injuryApprovalInfo);
	
		claim.setInjuryInfo(injuryInfo);
 		
 		
		ExamInfo examInfo = new ExamInfo();
		
		PaymentInfo examPaymentInfo = new PaymentInfo();
		examPaymentInfo.setAmount(new NihbDecimal(result.getBigDecimal(EXAMAMOUNT)));
		
		Tax examTax = new Tax();
		examTax.setGst(new NihbDecimal(result.getBigDecimal(EXAM_GST)));
		examTax.setPst(new NihbDecimal(result.getBigDecimal(EXAM_PST)));
		examTax.setHst(new NihbDecimal(result.getBigDecimal(EXAM_HST)));
		examPaymentInfo.setTax(examTax);
		examPaymentInfo.setCopay_amount(new NihbDecimal(result.getBigDecimal(EXAM_COPAY_AMOUNT)));
		examPaymentInfo.setPaymentStatus(Status.getStatus(result.getString(EXAMPAYMENTSTATUS)));
		User examPaymentUser = new User();
		examPaymentUser.setId(result.getLong(EXAMPAYMENTBY));
		examPaymentInfo.setPaymentBy(examPaymentUser);
		examPaymentInfo.setPaymentAt(LocalDateTime.fromDateFields(result.getDate(EXAMPAYMENTAT)));
		examPaymentInfo.setInvoiceNumber(result.getString(EXAMINVOICENUMBER));
		
 		examInfo.setPaymentInfo(examPaymentInfo);
 
 		ApprovalInfo examApprovalInfo = new ApprovalInfo();
 		examApprovalInfo.setApprovalStatus(Status.getStatus(result.getString(EXAMAPPROVALSTATUS)));
 		User examApprovalUser = new User();
 		examApprovalUser.setId(result.getLong(EXAMAPPROVEBY));
 		examApprovalInfo.setApprovalBy(examApprovalUser);
 		examApprovalInfo.setApprovedAt(LocalDateTime.fromDateFields(result.getDate(EXAMAPPROVEAT)));
 		examApprovalInfo.setApprovalNumber(result.getString(EXAMAPPROVALNUMBER));
 		examApprovalInfo.setDenialReason(result.getString(EXAMDENIALREASON));
 
 		examInfo.setApprovalInfo(examApprovalInfo);
 		
 		EyeCheckInfo examDoctorInfo = new EyeCheckInfo();
 		
 		examDoctorInfo.setComments(result.getString(EXAMCOMMENTS));
 		examDoctorInfo.setNihbComments(result.getString(EXAMNIHBCOMMENTS));
 		User examDoctor = new User();
 		examDoctor.setId(result.getLong(EXAMDOCTOR));
 		examDoctorInfo.setDoctor(examDoctor);
 		Provider examProvider = new Provider();
 		examProvider.setId(result.getLong(EXAMPROVIDER));
 		examDoctorInfo.setProvider(examProvider);
 		
 		examInfo.setDoctorInfo(examDoctorInfo);
 		
 		Prescription examRx = new Prescription();
 		
 		VisionInfo odInfo = new VisionInfo();
 		odInfo.setPrism(new NihbDecimal(result.getBigDecimal(OD_PRISM)));
 		odInfo.setBase(new NihbDecimal(result.getBigDecimal(OD_BASE)));
 		odInfo.setSphere(new NihbDecimal(result.getBigDecimal(OD_SPHERE)));
 		odInfo.setCyl(new NihbDecimal(result.getBigDecimal(OD_CYL)));
 		odInfo.setAxis(new NihbDecimal(result.getBigDecimal(OD_AXIS)));
 		odInfo.setAdd(new NihbDecimal(result.getBigDecimal(OD_ADD)));
 		examRx.setOdVisionInfo(odInfo);
 
		VisionInfo osInfo = new VisionInfo();
 		osInfo.setPrism(new NihbDecimal(result.getBigDecimal(OS_PRISM)));
 		osInfo.setBase(new NihbDecimal(result.getBigDecimal(OS_BASE)));
 		osInfo.setSphere(new NihbDecimal(result.getBigDecimal(OS_SPHERE)));
 		osInfo.setCyl(new NihbDecimal(result.getBigDecimal(OS_CYL)));
 		osInfo.setAxis(new NihbDecimal(result.getBigDecimal(OS_AXIS)));
 		osInfo.setAdd(new NihbDecimal(result.getBigDecimal(OS_ADD)));
 		examRx.setOsVisionInfo(osInfo);
 
 		
 		examRx.setPd(new NihbDecimal(result.getBigDecimal(PD)));
 		
 		examInfo.setPrescription(examRx);
 	
 		claim.setExamInfo(examInfo);
 		
 		
 		GlassesInfo glassesInfo = new GlassesInfo();
 		
 		ApprovalInfo glassesApprovalInfo = new ApprovalInfo();
 		
 		glassesApprovalInfo.setApprovalStatus(Status.getStatus(result.getString(GLASSESAPPROVALSTATUS)));
 		User glassesApprovalUser = new User();
 		glassesApprovalUser.setId(result.getLong(GLASSESAPPROVEDBY));
 		glassesApprovalInfo.setApprovalBy(glassesApprovalUser);
 		glassesApprovalInfo.setApprovedAt(LocalDateTime.fromDateFields(result.getDate(GLASSESAPPROVEAT)));
 		glassesApprovalInfo.setApprovalNumber(result.getString(GLASSESAPPPROVALNUMBER));
 		glassesApprovalInfo.setDenialReason(result.getString(GLASSESDENIALREASON));
 
 		glassesInfo.setApprovalInfo(glassesApprovalInfo);
 	
 		
 		GlassesDetail glassesDetail = new GlassesDetail();
 		
 		GlassesItem frame = new GlassesItem();
 		frame.setCost(new NihbDecimal(result.getBigDecimal(GLASSESFRAMECOST)));
 		frame.setDescription(result.getString(GLASSESFRAMEDESC));
 		frame.setNihbComments(result.getString(GLASSESFRAMENIHB));
 		glassesDetail.setFrame(frame);
 		
 		GlassesItem rightlens = new GlassesItem();
 		rightlens.setCost(new NihbDecimal(result.getBigDecimal(GLASSESRIGHTLENCOST)));
 		rightlens.setDescription(result.getString(GLASSESRIGHTLENSDESC));
 		rightlens.setNihbComments(result.getString(GLASSESRIGHTLENSNIHB));
 		glassesDetail.setRightLens(rightlens);
 		
		GlassesItem leftlens = new GlassesItem();
 		leftlens.setCost(new NihbDecimal(result.getBigDecimal(GLASSESLEFTLENCOST)));
 		leftlens.setDescription(result.getString(GLASSESLEFTLENDESC));
 		leftlens.setNihbComments(result.getString(GLASSESLEFTLENSNIHB));
 		glassesDetail.setLeftLens(leftlens);
 		
		GlassesItem scr = new GlassesItem();
		scr.setCost(new NihbDecimal(result.getBigDecimal(GLASSESSCRCOST)));
		scr.setDescription(result.getString(GLASSESSCRDESC));
		scr.setNihbComments(result.getString(GLASSESSCRNIHB));
 		glassesDetail.setScr(scr);
 		
 		GlassesItem hardexcoating = new GlassesItem();
 		hardexcoating.setCost(new NihbDecimal(result.getBigDecimal(GLASSESHARDEXCOATINGCOST)));
 		hardexcoating.setDescription(result.getString(GLASSESHARDEXCOATINGDESC));
 		hardexcoating.setNihbComments(result.getString(GLASSESHARDEXCOATINGNIHB));
 		glassesDetail.setHardexCoating(hardexcoating);
 		
 		GlassesItem edging = new GlassesItem();
 		edging.setCost(new NihbDecimal(result.getBigDecimal(GLASSESEDGINGCOST)));
 		edging.setDescription(result.getString(GLASSESEDGINGDESC));
 		edging.setNihbComments(result.getString(GLASSESEDGINGNIHB));
 		glassesDetail.setEdging(edging);
 		
 		GlassesItem nylongroving = new GlassesItem();
 		nylongroving.setCost(new NihbDecimal(result.getBigDecimal(GLASSESNYLONGROVINGCOST)));
 		nylongroving.setDescription(result.getString(GLASSESNYLONGROVINGDESC));
 		nylongroving.setNihbComments(result.getString(GLASSESNYLONGROVINGNIHB));
 		glassesDetail.setNylongroving(nylongroving);
 		
 		GlassesItem glassescase = new GlassesItem();
 		glassescase.setCost(new NihbDecimal(result.getBigDecimal(GLASSESCASECOST)));
 		glassescase.setDescription(result.getString(GLASSESCASEDESC));
 		glassescase.setNihbComments(result.getString(GLASSESCASENIHB));
 		glassesDetail.setGlassesCase(glassescase);
 		
 		GlassesItem frameFront = new GlassesItem();
 		frameFront.setCost(new NihbDecimal(result.getBigDecimal(GLASSESFRAMEFRONTCOST)));
 		frameFront.setDescription(result.getString(GLASSESFRAMEFRONTDESC));
 		frameFront.setNihbComments(result.getString(GLASSESFRAMEFRONTNIHB));
 		glassesDetail.setFramefront(frameFront);
 		
 		GlassesItem temple = new GlassesItem();
 		temple.setCost(new NihbDecimal(result.getBigDecimal(GLASSESTEMPLECOST)));
 		temple.setDescription(result.getString(GLASSESTEMPLEDESC));
 		temple.setNihbComments(result.getString(GLASSESTEMPLENIHB));
 		glassesDetail.setTemple(temple);
 		
		GlassesItem other1 = new GlassesItem();
 		other1.setCost(new NihbDecimal(result.getBigDecimal(GLASSESOTHERCOST1)));
 		other1.setDescription(result.getString(GLASSESOTHERCOST1DESC));
 		other1.setNihbComments(result.getString(GLASSESOTHERCOST1NIHB));
 		glassesDetail.setOther1(other1);
  		
 		GlassesItem other2 = new GlassesItem();
 		other2.setCost(new NihbDecimal(result.getBigDecimal(GLASSESOTHERCOST2)));
 		other2.setDescription(result.getString(GLASSESOTHERCOST2DESC));
 		other2.setNihbComments(result.getString(GLASSESOTHERCOST2NIHB));
 		glassesDetail.setOther2(other2);
 		
 		
 
 		
 		glassesInfo.setGlassesDetail(glassesDetail);
 		
		PaymentInfo glassesPaymentInfo = new PaymentInfo();
		glassesPaymentInfo.setAmount(glassesDetail.getAmount());
		
		Tax glassesTax = new Tax();
		glassesTax.setGst(new NihbDecimal(result.getBigDecimal(GLASSES_GST)));
		glassesTax.setPst(new NihbDecimal(result.getBigDecimal(GLASSES_PST)));
		glassesTax.setHst(new NihbDecimal(result.getBigDecimal(GLASSES_HST)));
		glassesPaymentInfo.setTax(glassesTax);
		glassesPaymentInfo.setCopay_amount(new NihbDecimal(result.getBigDecimal(GLASSESCOPAY)));
		glassesPaymentInfo.setPaymentStatus(Status.getStatus(result.getString(GLASSESPAPYMENTSTATUS)));
		User glassesPaymentUser = new User();
		glassesPaymentUser.setId(result.getLong(GLASSESPAYMENTBY));
		glassesPaymentInfo.setPaymentBy(glassesPaymentUser);
		glassesPaymentInfo.setPaymentAt(LocalDateTime.fromDateFields(result.getDate(GLASSESPAYMENTAT)));
		glassesPaymentInfo.setInvoiceNumber(result.getString(GLASSESINVOICENUMBER));
		
 		glassesInfo.setPaymentInfo(glassesPaymentInfo);

		EyeCheckInfo glassesOpticianInfo = new EyeCheckInfo();
 		
 		glassesOpticianInfo.setComments(result.getString(GLASSESCOMMENTS));
 		glassesOpticianInfo.setNihbComments(result.getString(GLASSESNIHBCOMMENTS));
 		User glassesOptician = new User();
 		glassesOptician.setId(result.getLong(GLASSESOPTICIAN));
 		glassesOpticianInfo.setDoctor(glassesOptician);
 		Provider glassesProvider = new Provider();
 		glassesProvider.setId(result.getLong(GLASSESPROVIDER));
 		glassesOpticianInfo.setProvider(glassesProvider);
 		
 		glassesInfo.setOpticianCheckInfo(glassesOpticianInfo);
 		
 		claim.setGlassesInfo(glassesInfo);
 		
 		
 		claim.setComments(result.getString(COMMENTS));
 		claim.setStatus(Status.getStatus(result.getString(STATUS)));
 		
 		User createdUser = new User();
		createdUser.setId(result.getLong(CREATEDBY));
		claim.setCreateBy(createdUser);
		claim.setCreateDate(LocalDateTime.fromDateFields(result.getDate(CREATEDAT)));
		User modifiedUser = new User();
		modifiedUser.setId(result.getLong(LASTMODIFIEDBY));
		claim.setLastModifiedBy(modifiedUser);
		claim.setLastModifiedDate(LocalDateTime.fromDateFields(result.getDate(LASTMODIFITEDAT)));

		return claim;
	}
	
	@Override
	public Claim create(Claim entity) throws Exception {
		Claim claim = entity;
		CallableStatement csClaim = this.conn.prepareCall(INSERT_CLAIM);
		int idx=1;
		csClaim.setLong(idx++, claim.getDiand());
		csClaim.setBoolean(idx++, claim.isInjury());
		
		if(claim.isInjury()){
			csClaim.setDate(idx++,  new Date(claim.getInjuryInfo().getInjuryDate().toDate().getTime()));
			csClaim.setString(idx++, claim.getInjuryInfo().getInjuryPlace());
			csClaim.setString(idx++, claim.getInjuryInfo().getInjuryOther());
			csClaim.setBoolean(idx++, claim.getInjuryInfo().isOtherInjuryPlan());
			csClaim.setString(idx++, claim.getInjuryInfo().getOtherInjuryPlanName());
			csClaim.setString(idx++, claim.getInjuryInfo().getOtherInjuryClaimNumber());
			csClaim.setBigDecimal(idx++, claim.getInjuryInfo().getOtherInjuryClaimAmount().getAmount());
			csClaim.setString(idx++, Character.toString(Status.PENDING.Value));
			
			csClaim.setBigDecimal(idx++, null);
			csClaim.setString(idx++, null);
			csClaim.setLong(idx++, 0);
			csClaim.setDate(idx++, null);
			csClaim.setString(idx++, null);
			csClaim.setString(idx++, null);
			csClaim.setLong(idx++, 0);
			csClaim.setLong(idx++, 0);
							
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setBigDecimal(idx++, null);
	 		
	 		
			csClaim.setString(idx++, null);
			csClaim.setString(idx++, null);
			
		}else{
			csClaim.setDate(idx++,  null);
			csClaim.setString(idx++, null);
			csClaim.setString(idx++, null);
			csClaim.setBoolean(idx++, false);
			csClaim.setString(idx++, null);
			csClaim.setString(idx++, null);
			csClaim.setBigDecimal(idx++, null);
			csClaim.setString(idx++, null);

			
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getAmount().getAmount());
			csClaim.setString(idx++, Character.toString(claim.getExamInfo().getApprovalInfo().getApprovalStatus().Value));
			csClaim.setLong(idx++, claim.getExamInfo().getApprovalInfo().getApprovalBy().getId());
			csClaim.setDate(idx++, new Date(claim.getExamInfo().getApprovalInfo().getApprovedAt().toDate().getTime()));
			csClaim.setString(idx++, claim.getExamInfo().getApprovalInfo().getApprovalNumber());
			csClaim.setString(idx++, claim.getExamInfo().getApprovalInfo().getDenialReason());
			csClaim.setLong(idx++, claim.getExamInfo().getDoctorInfo().getProvider().getId());
			csClaim.setLong(idx++, claim.getExamInfo().getDoctorInfo().getDoctor().getId());
							
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getPrism().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getBase().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getSphere().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getCyl().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getAxis().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getAdd().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getPrism().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getBase().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getSphere().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getCyl().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getAxis().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getAdd().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getPd().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getTax().getGst().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getTax().getPst().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getTax().getHst().getAmount());
			csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getCopay_amount().getAmount());
	 		
	 		
			csClaim.setString(idx++, claim.getExamInfo().getDoctorInfo().getComments());
			csClaim.setString(idx++, claim.getExamInfo().getDoctorInfo().getNihbComments());

	 		}
		
		csClaim.setString(idx++,  claim.getComments());
		csClaim.setString(idx++, Character.toString(claim.getStatus().Value));
		csClaim.setLong(idx++, this.getCurrentUserId());
		csClaim.registerOutParameter(idx, java.sql.Types.BIGINT);
		csClaim.execute();
		long id = csClaim.getLong(idx);
		claim.setId(id);
		return claim;
	}

	@Override
	public Claim update(Claim entity) throws Exception {
		Claim claim = entity;
		CallableStatement csClaim= this.conn.prepareCall(UPDATE_CLAIM);
		int idx=1;
		csClaim.setLong(idx++, claim.getId());
		csClaim.setLong(idx++, claim.getDiand());
		csClaim.setBoolean(idx++, claim.isInjury());
		csClaim.setDate(idx++,  new Date(claim.getInjuryInfo().getInjuryDate().toDate().getTime()));
		csClaim.setString(idx++, claim.getInjuryInfo().getInjuryPlace());
		csClaim.setString(idx++, claim.getInjuryInfo().getInjuryOther());
		csClaim.setBoolean(idx++, claim.getInjuryInfo().isOtherInjuryPlan());
		csClaim.setString(idx++, claim.getInjuryInfo().getOtherInjuryPlanName());
		csClaim.setString(idx++, claim.getInjuryInfo().getOtherInjuryClaimNumber());
		csClaim.setBigDecimal(idx++, claim.getInjuryInfo().getOtherInjuryClaimAmount().getAmount());
		csClaim.setString(idx++, Character.toString(claim.getInjuryInfo().getApprovalInfo().getApprovalStatus().Value));
		csClaim.setLong(idx++, claim.getInjuryInfo().getApprovalInfo().getApprovalBy().getId());
		csClaim.setDate(idx++,  new Date(claim.getInjuryInfo().getApprovalInfo().getApprovedAt().toDate().getTime()));
		csClaim.setString(idx++, claim.getInjuryInfo().getApprovalInfo().getApprovalNumber());
		csClaim.setString(idx++,  claim.getInjuryInfo().getApprovalInfo().getDenialReason());

 		
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getAmount().getAmount());
		csClaim.setString(idx++, Character.toString(claim.getExamInfo().getApprovalInfo().getApprovalStatus().Value));
		csClaim.setLong(idx++, claim.getExamInfo().getApprovalInfo().getApprovalBy().getId());
		csClaim.setDate(idx++, new Date(claim.getExamInfo().getApprovalInfo().getApprovedAt().toDate().getTime()));
		csClaim.setString(idx++, claim.getExamInfo().getApprovalInfo().getApprovalNumber());
		csClaim.setString(idx++, claim.getExamInfo().getApprovalInfo().getDenialReason());
		csClaim.setLong(idx++, claim.getExamInfo().getDoctorInfo().getProvider().getId());
		csClaim.setLong(idx++, claim.getExamInfo().getDoctorInfo().getDoctor().getId());
						
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getPrism().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getBase().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getSphere().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getCyl().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getAxis().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOdVisionInfo().getAdd().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getPrism().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getBase().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getSphere().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getCyl().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getAxis().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getOsVisionInfo().getAdd().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPrescription().getPd().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getTax().getGst().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getTax().getPst().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getTax().getHst().getAmount());
		csClaim.setBigDecimal(idx++, claim.getExamInfo().getPaymentInfo().getCopay_amount().getAmount());
 		
	
		csClaim.setString(idx++, Character.toString(claim.getGlassesInfo().getApprovalInfo().getApprovalStatus().Value));
		csClaim.setLong(idx++, claim.getGlassesInfo().getApprovalInfo().getApprovalBy().getId());
		csClaim.setDate(idx++, new Date(claim.getGlassesInfo().getApprovalInfo().getApprovedAt().toDate().getTime()));
		csClaim.setString(idx++, claim.getGlassesInfo().getApprovalInfo().getApprovalNumber());
		csClaim.setString(idx++, claim.getGlassesInfo().getApprovalInfo().getDenialReason());
		csClaim.setLong(idx++, claim.getGlassesInfo().getOpticianCheckInfo().getProvider().getId());
		csClaim.setLong(idx++, claim.getGlassesInfo().getOpticianCheckInfo().getDoctor().getId());
		
 		
 
		
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getFrame().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getRightLens().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getLeftLens().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getScr().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getHardexCoating().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getEdging().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getNylongroving().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getGlassesCase().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getFramefront().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getTemple().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getOther1().getCost().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getGlassesDetail().getOther2().getCost().getAmount());
		
		
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getFrame().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getRightLens().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getLeftLens().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getScr().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getHardexCoating().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getEdging().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getNylongroving().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getGlassesCase().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getFramefront().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getTemple().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getOther1().getDescription());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getOther2().getDescription());
		
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getFrame().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getRightLens().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getLeftLens().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getScr().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getHardexCoating().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getEdging().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getNylongroving().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getGlassesCase().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getFramefront().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getTemple().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getOther1().getNihbComments());
		csClaim.setString(idx++, claim.getGlassesInfo().getGlassesDetail().getOther2().getNihbComments());
		
		
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getPaymentInfo().getCopay_amount().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getPaymentInfo().getTax().getGst().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getPaymentInfo().getTax().getPst().getAmount());
		csClaim.setBigDecimal(idx++, claim.getGlassesInfo().getPaymentInfo().getTax().getHst().getAmount());
 		

		csClaim.setString(idx++,claim.getExamInfo().getDoctorInfo().getComments());
		csClaim.setString(idx++,  claim.getGlassesInfo().getOpticianCheckInfo().getComments());
		csClaim.setString(idx++,claim.getExamInfo().getDoctorInfo().getNihbComments());
		csClaim.setString(idx++,  claim.getGlassesInfo().getOpticianCheckInfo().getNihbComments());
		csClaim.setString(idx++,claim.getComments());
		
	
		csClaim.setString(idx++, Character.toString(claim.getStatus().Value));
	
		csClaim.setString(idx++,  Character.toString(claim.getExamInfo().getPaymentInfo().getPaymentStatus().Value));
		csClaim.setLong(idx++, claim.getExamInfo().getPaymentInfo().getPaymentBy().getId());
		csClaim.setDate(idx++,  new Date(claim.getExamInfo().getPaymentInfo().getPaymentAt().toDate().getTime()));
		csClaim.setString(idx++, claim.getExamInfo().getPaymentInfo().getInvoiceNumber());

		
		csClaim.setString(idx++,  Character.toString(claim.getGlassesInfo().getPaymentInfo().getPaymentStatus().Value));
		csClaim.setLong(idx++, claim.getGlassesInfo().getPaymentInfo().getPaymentBy().getId());
		csClaim.setDate(idx++,  new Date(claim.getGlassesInfo().getPaymentInfo().getPaymentAt().toDate().getTime()));
		csClaim.setString(idx++, claim.getGlassesInfo().getPaymentInfo().getInvoiceNumber());
		
		csClaim.setLong(idx++, this.getCurrentUserId());

		csClaim.execute();
		
		return claim;
	}

	@Override
	public Claim remove(long id) throws Exception {
		Claim claim = findById(id);
		CallableStatement csClaim = this.conn.prepareCall(CHANGE_STATUS);
		int idx=1;
		csClaim.setLong(idx++, id);
		csClaim.setString(idx++, Character.toString(Status.INACTIVE.Value));
		csClaim.setLong(idx,this.currentuserid);
		csClaim.execute();
		claim.setStatus(Status.INACTIVE);
		return claim;
	}

}
