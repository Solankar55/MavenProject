package com.library.daoInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.BookTypeMaster;

public interface BookTypeMasterDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<BookTypeMaster> bookTypeSimpleList();

	void saveBookType(BookTypeMaster book);

	void updateBookTypeData(int id, String bookType);

	void deleteBookTypeData(int id);

}
