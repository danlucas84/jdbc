package controller;

import dao.UserDao;

import java.sql.SQLException;

import model.User;

public class Menu {

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu ();
        menu.wyswietlMenu();
    }

   public void wyswietlMenu() throws SQLException {


       UserDao userDao = new UserDao();

       //userDao.save(
               //new User("Wojciech","Musial","Wojciech@gmail.com")
       //);
switch
   }

}
