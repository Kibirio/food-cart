package com.palmoncode.foodcart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Haryx_PurpleSoft
 */
@WebServlet(name = "FoodCart", urlPatterns = {"/FoodCart"})
public class FoodCart extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      try {
         List<Food> foodItems = FoodCartDbUtil.getFoodList();
         request.setAttribute("foodItems", foodItems);

         // redirect to a different page(view)
         RequestDispatcher dispatcher = request.getRequestDispatcher("showFood.jsp");
         dispatcher.forward(request, response);
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(FoodCart.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
         Logger.getLogger(FoodCart.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      processRequest(request, response);
   }

   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>

}
