package com.hms.constants;

public class QueryConstant {

	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	public static final String URL = "jdbc:mysql://localhost:3306/hospital_management_system";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String GET_USER = "select adminpassword from admin_login where adminusername=?";

	public static final String GET_PATIENT = "SELECT`patient_details`.`firstname`,`patient_details`.`lastname`,`patient_details`.`fathername`,`patient_details`.`mothername` FROM `hospital_management_system`.`patient_details`where firstname=? AND lastname=? AND fathername=? AND mothername=?";
	public static final String GET_PATIENTID = "select  ifnull(max(id),1000)+1 pid from patient_details";

	public static final String GET_PHYSICIANID = "select  ifnull(max(id),'PR000') as pid from physician_details";
	public static final String GET_PHYSICIAN = "select firstname,lastname,department from physician_details where firstname=? AND lastname=? AND department=?";

	public static final String INSERT_PATIENT = "INSERT INTO `hospital_management_system`.`patient_details`(`id`,`firstname`,`lastname`,`patientpassword`,`dob`,`email`,`phone`,`state`,`plan`,`fathername`,`mothername`,`weight`,`maritalstatus`,`spousename`,`spouseage`,`noofchildren`,`childrenname1`,`childrenname2`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_PHYSICIAN = "INSERT INTO `hospital_management_system`.`physician_details`	(`id`,	`firstname`,	`lastname`,	`department`,	`education`,	`yop`,	`state`,	`plan`,	`shift`)	VALUES	(	?,	?,	?,	?,	?,	?,	?,	?,	?	)";

	public static final String SEARCH_PATIENT = "SELECT	`diagnospatient_details`.`id`,	`diagnospatient_details`.`patient_id`,	`diagnospatient_details`.`symptoms`,	`diagnospatient_details`.`diagnosis`,	`diagnospatient_details`.`administered_by`,	`diagnospatient_details`.`date_of_diagnosis`,	`diagnospatient_details`.`follow_up_req`,	`diagnospatient_details`.`date_of_follow_up`,	`diagnospatient_details`.`bill_amount`,`diagnospatient_details`.`card_number`,`diagnospatient_details`.`payment_mode`	FROM `hospital_management_system`.`diagnospatient_details` where patient_id=?";
	public static final String SEARCH_PHYSICIAN = "SELECT	`physician_details`.`id`,	`physician_details`.`firstname`,	`physician_details`.`lastname`,	`physician_details`.`department`,	`physician_details`.`education`,	`physician_details`.`yop`,	`physician_details`.`state`,	`physician_details`.`plan`,	`physician_details`.`shift`	FROM `hospital_management_system`.`physician_details` where state=? OR plan=? OR department=? OR shift=?";
	public static final String SEARCH_PHYSICIAN_SORT_FN = "SELECT	`physician_details`.`id`,	`physician_details`.`firstname`,	`physician_details`.`lastname`,	`physician_details`.`department`,	`physician_details`.`education`,	`physician_details`.`yop`,	`physician_details`.`state`,	`physician_details`.`plan`,	`physician_details`.`shift`	FROM `hospital_management_system`.`physician_details` where state=? OR plan=? OR department=? OR shift=? order by firstname";
	public static final String SEARCH_PHYSICIAN_SORT_LN = "SELECT	`physician_details`.`id`,	`physician_details`.`firstname`,	`physician_details`.`lastname`,	`physician_details`.`department`,	`physician_details`.`education`,	`physician_details`.`yop`,	`physician_details`.`state`,	`physician_details`.`plan`,	`physician_details`.`shift`	FROM `hospital_management_system`.`physician_details` where state=? OR plan=? OR department=? OR shift=? order by lastname";

	public static final String GET_STATES = "SELECT`states`.`name`FROM `hospital_management_system`.`states`";
	public static final String GET_INSURANCE = "SELECT`insurance_plan`.`name`FROM `hospital_management_system`.`insurance_plan`";

	public static final String INSERT_DIAGNOSIS_DETAILS = "INSERT INTO `hospital_management_system`.`diagnospatient_details`(`id`,`patient_id`,`symptoms`,`diagnosis`,`administered_by`,`date_of_diagnosis`,`follow_up_req`,`date_of_follow_up`,`bill_amount`,`card_number`,`payment_mode`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_PATIENT_DIAGNOSIS = "	SELECT`patient_details`.`id` as pid FROM `hospital_management_system`.`patient_details` where id=?";

	public static final String GET_DIAGNOSIS_ID = "select ifnull(max(id),0)+1 pid from diagnospatient_details";
	public static final String GET_DEPARTMENT = "SELECT`department`.`name`FROM `hospital_management_system`.`department`";
	public static final String VERIFY_PATIENT = "SELECT`patient_details`.`id` as pid FROM `hospital_management_system`.`patient_details` where id=?";
	public static final String SEARCH_PATIENT_FNLN = "SELECT`patient_details`.`id` as pid FROM `hospital_management_system`.`patient_details` where firstname=? AND lastname=?";

}