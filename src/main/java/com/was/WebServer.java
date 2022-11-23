package com.was;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;

public class WebServer {

  private int port;

  private static final int DEFAULT_PORT = 8080;

  public WebServer(int port) {
    this.port = port;
  }

  public void start() throws IOException {
    System.out.println(port);
    ServerSocket serverSocket = new ServerSocket(port);

    while (true) {
      Socket socket = serverSocket.accept();
      handleSocket(socket);
    }
  }

  public static void main(String[] args) throws IOException {
    WebServer webServer = new WebServer(DEFAULT_PORT);
    webServer.start();
  }

  private static void handleSocket(Socket socket) throws IOException {
    InputStream in = socket.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    String line = "";
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }

    in.close();
    socket.close();
  }

}
