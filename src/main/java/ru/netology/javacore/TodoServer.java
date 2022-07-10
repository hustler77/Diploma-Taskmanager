package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    protected int port;
    protected Todos todos;


    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws RuntimeException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream())) {
                    String json = in.readLine();
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(json);
                    JSONObject jsonObject = (JSONObject) obj;
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    TaskRequest request = gson.fromJson(jsonObject.toString(), TaskRequest.class);

                    switch (request.getType()) {
                        case "ADD":
                            todos.addTask(request.getTask());
                            break;

                        case "REMOVE":
                            todos.removeTask(request.getTask());
                            break;
                    }
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
