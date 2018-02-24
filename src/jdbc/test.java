package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//格式jdbc:mysql://主机IP：端口号/数据库名
		String url="jdbc:mysql://192.168.192.250:3306/qww?useUniicode=&characterEncoding=utf8";
		String user="root";
		String password="123";
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pre=null;
		String name="input";
		String pwd="input";
		
		try {
			//选择要操作数据库的种类--加载驱动（反射）
			Class.forName("com.mysql.jdbc.Driver");
			//创建链接 主机IP 端口号 用户名 密码
		 con = DriverManager.getConnection(url,user,password);
			//选择要操作的数据库
			//创建命令窗口（写sql语句）
			 pre = con.prepareStatement("insert into student(name,id,b_id)values(?,?,?)");
			//运行sql语句并查看结果 如果是增删改则返回受影响的行数，如果是查询，返回查询结果
			//注意运行的时候 如果是增删改则调用exexcuteUpdate 返回int 如果查询 则调用executeQuery 返回ResultSet
			 //注入参数
			 pre.setString(1,"刘浩");
			 pre.setInt(2,6);
			 pre.setInt(3,13);
			 //执行语句
			 int i=pre.executeUpdate();
			 System.out.println(i);
		
			//查看结果集
			
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
