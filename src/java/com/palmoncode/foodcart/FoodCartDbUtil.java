package com.palmoncode.foodcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Haryx_PurpleSoft
 */
public class FoodCartDbUtil {

   public static List<Food> getFoodList() throws ClassNotFoundException, SQLException {

      String url = "jdbc:mysql://localhost:3306/mycontact?useSSL =false";
      String username = "root";
      String pass = "root";

      ArrayList<Food> food = new ArrayList<>();

      // load driver
      Class.forName("com.mysql.jdbc.Driver");

      // getConnection
      Connection con = DriverManager.getConnection(url, username, pass);

      // create statement
      Statement stmt = con.createStatement();

      // execute statement
      ResultSet rs = stmt.executeQuery("select * from mycontact.foodcart");

      while (rs.next()) {
         int id = rs.getInt(1);
         String item = rs.getString(2);
         float price = rs.getFloat(3);

         Food f = new Food(id, item, price);

         food.add(f);
      }
      return food;
   }

}
