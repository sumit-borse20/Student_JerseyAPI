package student_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Student_Repository {
	Connection conn = null;

	public Student_Repository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_data", "Sumit@123", "");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Student> getStudent1() {
		List<Student> students = new ArrayList<>();
		String select = "select * from studentapi";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(select);
			while (rs.next()) {
				Student s = new Student();
				s.setStudent_no(rs.getInt(1));
				s.setStudent_name(rs.getString(2));
				s.setStudent_dob(rs.getDate(3));
				s.setStudent_doj(rs.getDate(4));
				students.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return students;
	}

	public void create(Student std) {
		String insert = "insert into studentapi values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, std.getStudent_no());
			ps.setString(2, std.getStudent_name());
			ps.setDate(3, std.getStudent_dob());
			ps.setDate(4, std.getStudent_doj());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void update(Student std) {
		String update = "update studentapi set no=?,name=?,marks=?,address=?,age=? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(update);

			ps.setInt(1, std.getStudent_no());
			ps.setString(2, std.getStudent_name());
			ps.setDate(3, std.getStudent_dob());
			ps.setDate(4, std.getStudent_doj());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void delete(int id) {
		String delete = "delete from studentapi where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
