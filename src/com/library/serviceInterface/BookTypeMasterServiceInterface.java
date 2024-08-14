package com.library.serviceInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.BookTypeMaster;

public interface BookTypeMasterServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<BookTypeMaster> bookTypeSimpleList();

	void bookSave(BookTypeMaster book);

	void UpdateBookTypeData(int id, String bookType);

	void deleteBookTypeData(int id);

}
