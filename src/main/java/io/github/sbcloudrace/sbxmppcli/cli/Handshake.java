package io.github.sbcloudrace.sbxmppcli.cli;

public class Handshake {

    private XmppTalk xmppTalk;

    public Handshake() {
        String xmppIp = "127.0.0.1";
        int xmppPort = 5222;

        SocketClient socketClient = new SocketClient(xmppIp, xmppPort);
        socketClient.send(
                "<?xml version='1.0' ?><stream:stream to='" + xmppIp + "' xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' version='1.0' xml:lang='en'>");
        String receive = socketClient.receive();
        while (!receive.contains("</stream:features>")) {
            receive = socketClient.receive();
        }
        socketClient.send("<starttls xmlns='urn:ietf:params:xml:ns:xmpp-tls'/>");
        socketClient.receive();
        xmppTalk = new XmppTalk(socketClient.getSocket());
        TlsWrapper.wrapXmppTalk(xmppTalk);
        xmppTalk.write(
                "<?xml version='1.0' ?><stream:stream to='" + xmppIp + "' xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' version='1.0' xml:lang='en'>");
        xmppTalk.write("<iq id='EA-Chat-1' type='get'><query xmlns='jabber:iq:auth'><username>sbrw.engine.engine</username></query></iq>");
        xmppTalk.read();
        xmppTalk.write("<iq xml:lang='en' id='EA-Chat-2' type='set'><query xmlns='jabber:iq:auth'><username>sbrw.engine.engine</username><password>" + "y0gs2EUWSakiz1q5"
                + "</password><resource>EA_Chat</resource><clientlock xmlns='http://www.jabber.com/schemas/clientlocking.xsd' id='900'>57b8914527daff651df93557aef0387e5aa60fae</clientlock></query></iq>");
        xmppTalk.read();
        xmppTalk.write("<presence><show>chat</show><status>Online</status><priority>0</priority></presence>");
        xmppTalk.write(" ");
        xmppTalk.write("<presence to='channel.CMD__1@conference." + xmppIp + "/sbrw.engine.engine'/>");
        xmppTalk.startReader();
    }

    public XmppTalk getXmppTalk() {
        return xmppTalk;
    }

}