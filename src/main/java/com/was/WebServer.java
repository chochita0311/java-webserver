package com.was;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebServer {
  private static final Logger logger = Logger.getLogger(WebServer.class.getCanonicalName()); // com.was.WebServer
  private static final int NUM_THREADS = 50;
  private static final String INDEX_FILE = "index.html";

  private final File rootDirectory;
  private final int port;

//  private static final File configJson = new File(WebServer.class.getResource("config.json").getFile());

  public WebServer(File rootDirectory, int port) {
    this.rootDirectory = rootDirectory;
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

  public static void main(String[] args) throws IOException, URISyntaxException {
    File documentRoot;
    String host = args.length > 0 ? args[0] : "localhost";

    WebServer ws = new WebServer(new File("ab"), 8989);
    ws.parseJson("");



    URL url = WebServer.class.getClassLoader().getResource("a.txt");
    Path p = Paths.get(url.toURI());
    System.out.println(p);

        FileInputStream ins = new FileInputStream(p.toString());
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));
    bufferedReader.lines()
        .forEach(eachLine -> System.out.println(eachLine)
        );

//        FileInputStream ins = new FileInputStream(json);




//    FileInputStream ins = new FileInputStream(
//        String.valueOf());
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));
//
//    //    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));
//    bufferedReader.lines()
//        .forEach(eachLine -> System.out.println(eachLine)
//        );

    if (args.length == 0) {

    }

    int port;
    try {
      port = Integer.parseInt(args[1]);
      if (port < 0 || port > 65535) port = 80;
    }catch (RuntimeException e) {
      port = 80;
    }

//    try {
//      WebServer webServer = new WebServer(documentRoot, 8080);
//      webServer.start();
//    }catch (IOException e) {
//      logger.log(Level.SEVERE, "Server could not start", e);
//    }

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

  private void parseJson(String json) throws FileNotFoundException {
    System.out.println(getClass().getClassLoader().getResourceAsStream(json));
//    FileInputStream ins = new FileInputStream(json);
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));
//    bufferedReader.lines()
//        .forEach(eachLine -> System.out.println(eachLine)
//        );


  }

//  String json = String(Files.readAllBytes(WebServer.class.getResource("config.json").getPath()));


}
