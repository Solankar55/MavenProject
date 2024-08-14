package com.library.serviceInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface LibraryHomeServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

}
