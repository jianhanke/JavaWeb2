package cn.itcast.jdbc.utils;

public class Business {
	
	public static void main(String[] args) {
		transfer("a","b",200);
	}

	public static void transfer(String sourceAccountName,String toAccountName,float money) {
		try {
			JDBCUtils.startTransaction();
			AccountDao dao=new AccountDao();
			Account accountfrom=dao.find(sourceAccountName);
			Account accountto=dao.find(toAccountName);
			if(money<=accountfrom.getMoney()) {
				accountfrom.setMoney(accountfrom.getMoney()-money);
			}else {
				System.out.println("ת��������");
			}
			accountto.setMoney(accountto.getMoney()+money);
			dao.update(accountfrom);
			dao.update(accountto);
			JDBCUtils.commit();
			System.out.println("�ύ�ɹ�");
			JDBCUtils.rollback();
		}catch(Exception e) {
			System.out.println("�ύʧ��");
			JDBCUtils.rollback();
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
	}
	

}
