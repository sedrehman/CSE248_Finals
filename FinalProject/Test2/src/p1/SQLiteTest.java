package p1;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SQLiteTest {
	
	private Map <String, Item> itemList = new HashMap<String, Item>();
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:habitatForHumanity.sqlite");
			System.out.println("coonected to DB");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	
	public void LoadItems() {
		String sql = "SELECT * FROM ItemList";
		try {
			//wont do this before creating an object of this class... so it will create a connection first..
			Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Item temp = new Item(rs.getString("name"), rs.getDouble("price"), rs.getInt("itemNumber"), rs.getString("stockLocation"), rs.getInt("quantity"), rs.getString("otherInfo")
						, rs.getString("brand"), rs.getString("safety"));
				itemList.put(temp.getName(), temp);
				System.out.println(temp.toString());
			}
		} catch (SQLException e) {
			System.out.println("problem at the itemList");
			e.printStackTrace();
		}
	}
	
	
	
}
