package org.example;

import Ihm.IhmGlobal;

import java.rmi.ConnectException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ConnectException {
        IhmGlobal ihmGlobal = new IhmGlobal();

        ihmGlobal.SelectMenu();
    }
}