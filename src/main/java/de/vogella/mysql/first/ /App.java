package de.vogella.mysql.first ;

/**
 * Hello world!
 *
 */

import de.vogella.mysql.first.MySQLAccess;

public class App {
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }

}

