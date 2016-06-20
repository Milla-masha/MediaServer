package application.service;

import application.service.impl.FileServiceImpl;

public class Factory {
	private static Factory instance = null;
	private static IFileService service = null ;
	
	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public static IFileService getEmployeeDAO() {
		if (service == null)
			service = new FileServiceImpl();
		return service;
	}
}
