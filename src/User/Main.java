package User;

import Movie.DB_MovieInfo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DB_userInfo connection = new DB_userInfo();
		DB_MovieInfo con = new DB_MovieInfo();
		connection.updateUserInfo("qwer", "2222", "0192222");
		//con.getMovieInfo("audience", null);
		//System.out.println(connection.addUser("asdfa", "123", "�迵��", "19920506", "����", "010123456", null, null));
		//System.out.println(connection.isUser("kny030303", "kny12345"));
		//System.out.println(connection.getUserInfo("kny030303").getUserID());
		//System.out.println("������ ����:"+coneection.addUser("qwersdru", "555", "�ǳ׼�", 030307, "12346589", "������", "�θǽ�"));
		
	}

}
