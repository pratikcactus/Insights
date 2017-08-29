package com.cactus.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtil {
	private static DatabaseUtil instance;

	private String serviceQuery = "select id,name from service";
	private String partnerQuery = "select id,name from partner";

	private String salutationTypeQuery = "select name,partner_id from master where data->>'field_salutation_type' IN ('P')";

	private DatabaseUtil() {
	}

	public static DatabaseUtil getInstance() {
		if (instance == null) {
			instance = new DatabaseUtil();
		}
		return instance;
	}

	public DatabaseClass getDbInstance() {
		return DatabaseClass.getInstance();
	}

	public Map<String, String> getServiceMap(String testEnvironment) {
		Map<String, String> testMap = new HashMap<String, String>();
		try {
			Connection conn = getDbInstance().getConnection(testEnvironment);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(serviceQuery);

			while (rs.next()) {
				testMap.put(rs.getString("name"), rs.getString("id"));
			}

			rs.close();
			stmt.close();
			conn.close();
			return testMap;
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;

	}

	public Map<String, String> getPartnerMap(String testEnvironment) {
		Map<String, String> testMap = new HashMap<String, String>();
		try {
			Connection conn = getDbInstance().getConnection(testEnvironment);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(partnerQuery);

			while (rs.next()) {
				testMap.put(rs.getString("name"), rs.getString("id"));
			}

			rs.close();
			stmt.close();
			conn.close();
			return testMap;
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}

	public Map<String, List<String>> getFieldSalutationTypeMap(String testEnvironment) {
		Map<String, List<String>> testMap = new HashMap<String, List<String>>();
		try {
			Connection conn = getDbInstance().getConnection(testEnvironment);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(salutationTypeQuery);

			while (rs.next()) {
				if (testMap.containsKey(rs.getString("partner_id"))) {
					testMap.get(rs.getString("partner_id")).add(rs.getString("name"));
				} else {
					List<String> newSet = new ArrayList<String>();
					newSet.add(rs.getString("name"));
					testMap.put(rs.getString("partner_id"), newSet);
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return testMap;

	}

	public List<String> getQuestionList(String testEnvironment, String type, String partnerId, String serviceId) {
		List<String> testList = new ArrayList<String>();
		try {
			Connection conn = getDbInstance().getConnection(testEnvironment);
			Statement stmt = conn.createStatement();

			String query = "select name from migration mi join master m on m.id = mi.crm_id and m.active = TRUE "
					+ " where  whiteboard_table = 'enquiry_question_mapping'  and mi.partner_id=" + partnerId
					+ " and crm_table = 'master'  " + "and mi.service_id = " + serviceId
					+ " and m.data->>'field_eqm_enabled'='Yes'  and m.data->>'field_eqm_form_type' = '" + type + "';";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				String[] tempList = rs.getString("name").split("-");
				int pointer = tempList.length - 1;
				testList.add(tempList[pointer]);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return testList;
	}

	public List<String> getInvoiceTemplateList(String testEnvironment, String type, String partnerId,
			String serviceId) {
		List<String> testList = new ArrayList<String>();
		try {
			Connection conn = getDbInstance().getConnection(testEnvironment);
			Statement stmt = conn.createStatement();
			String query = "select name from migration mi join master m on m.id = mi.crm_id and m.active = TRUE "
					+ " where  whiteboard_table = 'partner_specific_invoicetemplate'  and mi.partner_id=" + partnerId
					+ " and crm_table = 'master' ; ";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String[] tempList = rs.getString("name").split(" » | >> ");
				int pointer = tempList.length - 1;
				testList.add(tempList[pointer]);
				// System.out.println(tempList[pointer]);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return testList;
	}

	public List<String> getServiceList(String testEnvironment, String type, String partnerId, String serviceId) {
		List<String> testList = new ArrayList<String>();
		try {
			Connection conn = getDbInstance().getConnection(testEnvironment);
			Statement stmt = conn.createStatement();
			String query = "select name from migration mi join master m on m.id = mi.crm_id and m.active = TRUE "
					+ " where  whiteboard_table = 'partner_service_association'  and mi.partner_id=" + partnerId
					+ " and crm_table = 'master' ; ";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String[] tempList = rs.getString("name").split(" » | >> ");
				int pointer = tempList.length - 1;
				testList.add(tempList[pointer].trim());
				// System.out.println(tempList[pointer]);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return testList;
	}

	public List<String> getPreferredDeliveryPlanList(String testEnvironment, String type, String partnerId,
			String serviceId) {
		List<String> testList = new ArrayList<String>();
		try {
			Connection conn = getDbInstance().getConnection(testEnvironment);
			Statement stmt = conn.createStatement();
			String query = "select mast.name from master mast inner join configuration_setting conSet on conSet.id = mast.config_id where mast.partner_id = '"
					+ partnerId + "' and mast.service_id = '" + serviceId
					+ "' and conSet.machine_name = 'flexible-plan';";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				testList.add(rs.getString("name"));

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return testList;
	}

	public Map<String, String> getEOSFeedbackQuestionMap(String testEnvironment,String partnerId,
			String serviceId, String clientType) {
		Map<String, String> testMap = new HashMap<String, String>();
		try {
			Connection conn = getDbInstance().getConnection(testEnvironment);
			Statement stmt = conn.createStatement();
			String query = "select replace(replace(replace(replace(m.data->'acceptable'->>'field_acceptable_service_dimensions','\"',''''),'[',''),']',''),', ',',') accepatableQ1 , "
					+ "m.data->'acceptable'->>'field_acceptable_service_dimensions_label' accepatableQ2 ,  "
					+ "replace(replace(replace(replace(m.data->'outstanding'->>'field_outstanding_service_dimensions','\"',''''),'[',''),']',''),', ',',') outstandingQ1, "
					+ " m.data->'outstanding'->>'field_outstanding_service_dimensions_label' outstandingQ2, "
					+ " replace(replace(replace(replace(m.data->'not_acceptable'->>'field_not_acceptable_service_dimensions','\"',''''),'[',''),']',''),', ',',') notacceptableQ1 , "
					+ " m.data->'not_acceptable'->>'field_not_acceptable_service_dimensions_label'  notacceptableQ2 "
					+ " from  feedback_master m where partner_id =" + partnerId + " and service_id = " + serviceId + " "
					+ "and client_type = '" + clientType.toLowerCase() + "' and entity_type = 'job'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				testMap.put("accepatableQ1", rs.getString("accepatableQ1"));
				testMap.put("accepatableQ2", rs.getString("accepatableQ2"));
				testMap.put("outstandingQ1", rs.getString("outstandingQ1"));
				testMap.put("outstandingQ2", rs.getString("outstandingQ2"));
				testMap.put("notacceptableQ1", rs.getString("notacceptableQ1"));
				testMap.put("notacceptableQ2", rs.getString("notacceptableQ2"));
			}

			rs.close();
			stmt.close();
			conn.close();
			return testMap;
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;

	}

	public List<String> getFeebackQuestinType(String questionSet1,String testEnvironment) {
		List<String> listQ = new ArrayList<String>();
		try {
			Connection conn = getDbInstance().getConnection(testEnvironment);
			Statement stmt = conn.createStatement();
			String query = "select name FROM question where machine_name in (" + questionSet1 + " )";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				listQ.add(rs.getString("name"));
			}

			rs.close();
			stmt.close();
			conn.close();
			return listQ;
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}
}
