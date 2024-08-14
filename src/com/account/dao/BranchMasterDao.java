package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.BranchMasterDaoInterface;
import com.account.model.BranchMasterModel;
import com.admin.model.AdminRegistrationModel;

@Repository
public class BranchMasterDao implements BranchMasterDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addNewBranch(BranchMasterModel branchMasterModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(branchMasterModel);
	}

	@Override
	public List<BranchMasterModel> getBranchList() {
		// TODO Auto-generated method stub
		List<BranchMasterModel> BranchList = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"select b.branchId,b.branchName,s.streamName from branchmaster b left join streammaster s on b.streamId =s.streamId where b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList = query.list();
		return BranchList;
	}

	@Override
	public HashMap<String, String> GetBranch() {
		// TODO Auto-generated method stub
		List<HashMap> list = new ArrayList<>();
		HashMap mapOfBranch = new HashMap();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT b.branchId,b.branchName FROM branchMaster b where b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();
		System.out.println("listOfBranch" + list);

		for (HashMap map : list) {

			mapOfBranch.put(map.get("branchId"), map.get("branchName"));

		}
		return mapOfBranch;

	}

	@Override
	public void UpdateBranch(int branchID, String branchName) {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("update branchmaster b set b.branchName='" + branchName
						+ "' where b.branchId='" + branchID + "'");
		query.executeUpdate();
	}

	@Override
	public void DeleteBranch(int branchID) {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("update branchmaster b set b.bstatus='Off' where branchId='" + branchID + "'");
		query.executeUpdate();
	}

	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		List<AdminRegistrationModel> adminList;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT a.RegistrationId, a.Address, a.Date, a.Email, a.MobileNumber, a.Name, a.Password, a.Type, a.Username FROM adminregistration a where a.Username='"
						+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));

		adminList = query.list();

		return adminList;
	}

}
