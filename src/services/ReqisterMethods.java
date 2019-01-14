package services;

public class ReqisterMethods {

	public int returnIdRole(String chooseType) {
		int userType = 0;
		if(chooseType.equals("user")) {
			 userType = 2;
		}
		if(chooseType.equals("foodtruck")) {
			 userType = 3;
		}
		
		return userType;
	}
}
