package ca.uqam.info.ssve.server;

import java.net.*;
import java.io.*;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ADVEConnection {
    private static HttpURLConnection connection;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String ip;
    private int port;

    public String call(String requete) throws IOException {
        //public static void main(String[] args) {
        Session session = null;
        ChannelExec channel = null;
        try {
            session = new JSch().getSession("minimechazawa", "adve.info.uqam.ca", 22);
            session.setPassword("vn-t4=~_fger");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("timeout 2 nc 127.0.0.1 8008 <<< '(45.5254,-73.5555) (45.6243,-73.7378) " +
                    "355418'");
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.connect();

            while (channel.isConnected()) {
                Thread.sleep(100);
                //channel.sendSignal("INT");
            }
            String responseString = responseStream.toString();
            System.out.println(responseString);

        } catch (JSchException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }


//
//            String msg;
//            String resp;
//            ADVEConnection adve = new ADVEConnection("adve.info.uqam.ca");
//            adve.startConnection(8009, adve);
//
//
//            // msg="(45.5254,-73.5555)      (45.6243,-73.7378)      355418  5       0 75" ;
//            msg = "(45.5254,-73.5555)      (45.6243,-73.7378)      355418";
//            resp = adve.sendMessage(msg);
//            System.out.println("Resp : " + resp);
//            msg = "(45.3846,-73.7721)      (45.6674,-74.2433)      519837  6       1       100";
//            msg = "(45.4264,-73.9179)      (45.4449,-73.6135)      162704  4       14      50";
//            msg = "(45.4666,-73.8288)      (45.3105,-73.2945)      117561  6       11      20";
//            msg = "(45.4733,-74.3509)      (45.4535,-73.4502)      148809  6       13      30";
//            msg = "(45.3711,-73.5302)      (45.4615,-73.8234)      176668  5       11      90";
//            msg = "(45.392,-73.4968)       (45.5228,-73.4263)      459166  2       13      95";
//            msg = "(45.2733,-74.1085)      (45.3427,-73.2841)      324585  4       0       5";
//            msg = "(45.3063,-73.2409)      (45.4419,-73.4492)      295504  2       4       0";
//            adve.stopConnection();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSchException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
        }
        return "hi";
    }
}
