package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʽjdbc:mysql://����IP���˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.192.250:3306/qww?useUniicode=&characterEncoding=utf8";
		String user="root";
		String password="123";
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pre=null;
		String name="input";
		String pwd="input";
		
		try {
			//ѡ��Ҫ�������ݿ������--�������������䣩
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ����IP �˿ں� �û��� ����
		 con = DriverManager.getConnection(url,user,password);
			//ѡ��Ҫ���������ݿ�
			//��������ڣ�дsql��䣩
			 pre = con.prepareStatement("insert into student(name,id,b_id)values(?,?,?)");
			//����sql��䲢�鿴��� �������ɾ���򷵻���Ӱ�������������ǲ�ѯ�����ز�ѯ���
			//ע�����е�ʱ�� �������ɾ�������exexcuteUpdate ����int �����ѯ �����executeQuery ����ResultSet
			 //ע�����
			 pre.setString(1,"����");
			 pre.setInt(2,6);
			 pre.setInt(3,13);
			 //ִ�����
			 int i=pre.executeUpdate();
			 System.out.println(i);
		
			//�鿴�����
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
				rs.close();
				if(pre!=null)
					pre.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
