package com.gabimania.booklikespro.Model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class BaseModel {

    private static final String CONFIG_FILE = "config.properties";
    protected static String URL;
    protected static String USER;
    protected static String PASSWORD;

    static {
        loadConfiguration();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadConfiguration(){
        Properties properties = new Properties();
        try(InputStream input = BaseModel.class.getClassLoader().getResourceAsStream(CONFIG_FILE)){
            properties.load(input);
            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    protected abstract String getNameTable();


    public boolean insert(String query, Object... parameters) {
        query = "insert into " + getNameTable() + " " + query;
        return ejecuteQuery(query, parameters);
    }

    public boolean update(String query, Object... parameters) {
        query = "update " + getNameTable() + " set " + query;
        return ejecuteQuery(query, parameters);
    }

    public boolean delete(String query, Object... parameters) {
        query = "delete from " + getNameTable() + " where " + query;
        return ejecuteQuery(query, parameters);
    }

    protected List<Object> readAll(String query) {
        List<Object> objectList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()){
                Object[] objects = new Object[metaData.getColumnCount()];
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    objects[i] = resultSet.getObject(i+1);
                }
                objectList.add(objects);
            }
            return objectList;
        } catch (SQLException e) {
            return objectList;

        }
    }

    private boolean ejecuteQuery(String sql, Object... parametres) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < parametres.length; i++)
                preparedStatement.setObject(i + 1, parametres[i]);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    protected String dateFormatter(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'at' HH:mm");
        return dateTime.format(formatter);
    }

}
