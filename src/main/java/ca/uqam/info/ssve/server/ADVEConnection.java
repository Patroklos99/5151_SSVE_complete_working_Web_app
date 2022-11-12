package ca.uqam.info.ssve.server;

import java.net.*;
import java.io.*;
import ca.uqam.info.ssve.model.Deplacement;

public class ADVEConnection {
    private static HttpURLConnection connection;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String ip;
    private int port;

    public ADVEConnection(String _ip) {
        ip = _ip;
    }

    public void startConnection(int _port) {
        try {
            port = _port;
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public String call(Deplacement deplacement) throws IOException {
        try {
            URL url = new URL("https://adve.info.uqam.ca");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            System.out.println(status);

            String msg;
            String resp;
            ADVEConnection adve = new ADVEConnection("adve.info.uqam.ca");
            adve.startConnection(8009);


            // msg="(45.5254,-73.5555)      (45.6243,-73.7378)      355418  5       0 75" ;
            msg = "(45.5254,-73.5555)      (45.6243,-73.7378)      355418";
            resp = adve.sendMessage(msg);
            System.out.println("Resp : " + resp);
            msg = "(45.3846,-73.7721)      (45.6674,-74.2433)      519837  6       1       100";
            msg = "(45.4264,-73.9179)      (45.4449,-73.6135)      162704  4       14      50";
            msg = "(45.4666,-73.8288)      (45.3105,-73.2945)      117561  6       11      20";
            msg = "(45.4733,-74.3509)      (45.4535,-73.4502)      148809  6       13      30";
            msg = "(45.3711,-73.5302)      (45.4615,-73.8234)      176668  5       11      90";
            msg = "(45.392,-73.4968)       (45.5228,-73.4263)      459166  2       13      95";
            msg = "(45.2733,-74.1085)      (45.3427,-73.2841)      324585  4       0       5";
            msg = "(45.3063,-73.2409)      (45.4419,-73.4492)      295504  2       4       0";
            adve.stopConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
