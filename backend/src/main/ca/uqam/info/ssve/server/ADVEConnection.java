package ca.uqam.info.ssve.server;

import java.net.*;
import java.io.*;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ADVEConnection {
    //private static HttpURLConnection connection;
    private static Session session;
    private ChannelExec channel;

    public ADVEConnection() {

    }

    public void closeServer() {
        if (session != null) {
            session.disconnect();
        }
        if (channel != null) {
            channel.disconnect();
        }
    }

    public String doRequest(String request) throws JSchException, InterruptedException {
        channel = (ChannelExec) session.openChannel("exec");
        String responseString;
        channel.setCommand("nc -q 1 127.0.0.1 8008 <<< " + "'" + request + "'");
        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
        channel.setOutputStream(responseStream);
        channel.connect();
        while (channel.isConnected()) {
            Thread.sleep(100);
        }
        responseString = responseStream.toString();
        return responseString;
    }

    public void connectServer() throws IOException {
        try {
            session = new JSch().getSession("minimechazawa", "adve.info.uqam.ca", 22);
            session.setPassword("vn-t4=~_fger");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

        } catch (JSchException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
