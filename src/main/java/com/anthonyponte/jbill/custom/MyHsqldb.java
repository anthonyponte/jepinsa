/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbill.custom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;

/**
 * @author anthony
 */
public class MyHsqldb {

  private Server server;
  private Connection connection;
  private final String DATABASE = "jbill";
  private final String ALIAS = "jb";
  private final String USER = "SA";
  private final String PASS = "";
  private final String URL = "jdbc:hsqldb:hsql://localhost/" + ALIAS;

  public void start() {
    try {
      HsqlProperties properties = new HsqlProperties();
      properties.setProperty("server.database.0", "file:./hsqldb/" + DATABASE);
      properties.setProperty("server.dbname.0", ALIAS);

      server = new Server();
      server.setProperties(properties);
      server.setTrace(true);
      server.start();
    } catch (IOException | ServerAcl.AclFormatException ex) {
      JOptionPane.showMessageDialog(
          null, ex.getMessage(), MyHsqldb.class.getName(), JOptionPane.ERROR_MESSAGE);
    }
  }

  public void stop() {
    server.stop();
  }

  public boolean isNotRunning() {
    return server.isNotRunning();
  }

  public void connect() {
    try {
      connection = DriverManager.getConnection(URL, USER, PASS);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(
          null, ex.getMessage(), MyHsqldb.class.getName(), JOptionPane.ERROR_MESSAGE);
    }
  }

  public void disconnect() {
    try {
      connection.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(
          null, ex.getMessage(), MyHsqldb.class.getName(), JOptionPane.ERROR_MESSAGE);
    }
  }

  public Connection getConnection() {
    return connection;
  }
}
