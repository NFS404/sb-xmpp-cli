package io.github.sbcloudrace.sbxmppcli.cli;

import java.io.*;
import java.net.Socket;

public class XmppTalk {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public XmppTalk(Socket socket) {
        this.socket = socket;
        setReaderWriter();
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
        setReaderWriter();
    }

    public Socket getSocket() {
        return socket;
    }

    private void setReaderWriter() {
        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String read() {
        String msg = null;
        char[] buffer = new char[8192];
        int charsRead = 0;
        try {
            if ((charsRead = reader.read(buffer)) != -1) {
                msg = new String(buffer).substring(0, charsRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("S->C [" + msg + "]");
        if (msg != null && !msg.isEmpty() && msg.contains("<ping xmlns=\"urn:xmpp:ping\"/>")) {
//            XMPP_IQPingType openfirePing = (XMPP_IQPingType) UnmarshalXML.unMarshal(msg, XMPP_IQPingType.class);
//            write(MarshalXML.marshal(new XMPP_IQPongType(openfirePing.getId())));
        }
        return msg;
    }

    public void write(String msg) {
        try {
            char[] cbuf = new char[msg.length()];
            msg.getChars(0, msg.length(), cbuf, 0);
            System.out.println("C->S [" + msg + "]");
            writer.write(cbuf);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startReader() {
        XmppTalkReader xmppTalkReader = new XmppTalkReader(this);
        xmppTalkReader.start();
    }

    private static class XmppTalkReader extends Thread {

        private XmppTalk xmppTalk;

        public XmppTalkReader(XmppTalk xmppTalk) {
            this.xmppTalk = xmppTalk;
        }

        @Override
        public void run() {
            while (true) {
                String read = xmppTalk.read();
                if (read == null) {
                    SbXmppClient.getInstance().disconnect();
                    try {
                        xmppTalk.socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SbXmppClient.getInstance();
                    this.interrupt();
                    break;
                }
            }
        }

    }
}
