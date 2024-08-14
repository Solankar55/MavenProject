package com.library.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.AccessibilityMasterDaoInterface;
import com.library.model.AccessibilityMaster;

@Repository
public class AccessibilityMasterDaoClass implements AccessibilityMasterDaoInterface{

		@Autowired
		private SessionFactory sessionFactory;

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@Override
		public List<AdminRegistrationModel> checkAdmin(String username) {
			// TODO Auto-generated method stub
			List<AdminRegistrationModel> adminList;
			SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT a.Address,a.Email,a.MobileNumber,a.Name,a.Password,a.Type,a.Username from adminregistration a where a.Username='"+username+"'");
			query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));
			adminList=query.list();
			return adminList;
		}

		@Override
		public HashMap<String, String> getYearList() {
			// TODO Auto-generated method stub
			List<HashMap> list = new ArrayList<>();
			HashMap mapOfAcadimicYear = new HashMap();
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
					"SELECT l.labacademicyearid,l.labacademicyear FROM libraryacademicyearmodel l");
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			list = query.list();

			for (HashMap map : list) {

				mapOfAcadimicYear.put(map.get("labacademicyearid"), map.get("labacademicyear"));

			}
			return mapOfAcadimicYear;
		}

		@Override
		public List<AccessibilityMaster> accessibilityList() {
			// TODO Auto-generated method stub
			SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(
					"SELECT a.AccessibilityId,a.CanIssue,a.Category,a.Fine,a.ReturnInDays,l.labacademicyearid,l.labacademicyear FROM Accessibilitymaster a left join libraryacademicyearmodel l on l.labacademicyearid=a.labacademicyearid");
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			List<AccessibilityMaster> amList = query.list();
			return amList;
		}

		@Override
		public List<String> getValueList(int acyear, String category) {
			// TODO Auto-generated method stub
			List<String> getData;

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
					"SELECT a.AccessibilityId,a.CanIssue,a.Fine,a.ReturnInDays FROM Accessibilitymaster a where a.Category='"
							+ category + "' and a.labacademicyearid='" + acyear + "'");
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			getData=query.list();

			return getData;
		}

		@Override
		public void accessibilityDataSave(AccessibilityMaster am) {
			// TODO Auto-generated method stub
			this.sessionFactory.getCurrentSession().save(am);
		}

		@Override
		public void updateValues(int acyear, String category, int canI, int noDayR, int fCharge) {
			// TODO Auto-generated method stub
			SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update Accessibilitymaster a set a.CanIssue='"+canI+"',a.Fine='"+fCharge+"',a.ReturnInDays='"+noDayR+"' where  a.Category='"+category+"' and a.labacademicyearid='"+acyear+"'");
			query.executeUpdate();
		}

		@Override
		public List<String> getFeeData(int acYearID, String category) {
			// TODO Auto-generated method stub
			List<String> getData;

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
					"SELECT a.AccessibilityId,a.CanIssue,a.Fine,a.ReturnInDays FROM Accessibilitymaster a where a.Category='"
							+ category + "' and a.labacademicyearid='" + acYearID + "'");
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			getData=query.list();

			return getData;
		}

		@Override
		public void updateAccessibilityData(int id, String category, int canissue, int returnindays, int fine) {
			// TODO Auto-generated method stub
			SQLQuery quer = sessionFactory.getCurrentSession()
					.createSQLQuery("update accessibilitymaster a set a.Category='" + category + "', a.CanIssue='"
							+ canissue + "', a.ReturnInDays='" + returnindays + "', a.Fine='" + fine
							+ "' where a.AccessibilityId='" + id + "'");
			quer.executeUpdate();
		}
		
		
}
