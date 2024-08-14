package com.library.daoInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface LibraryHomeDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

}
