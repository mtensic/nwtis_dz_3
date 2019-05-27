package org.foi.nwtis.mtensic.web.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Monika
 */
@ServerEndpoint("/infoPutnik")
public class InformatorPutnika {

    private static Set<Session> sessions = new LinkedHashSet<>();

    @OnMessage
    public void onMessage(String message) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException ex) {
                Logger.getLogger(InformatorPutnika.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Ostvarena je nova veza: " + session.getId());
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Veza " + session.getId() + " je zatvorena");
        sessions.remove(session);
    }

    public static void saljiPoruku(String poruka) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(poruka);
            } catch (IOException ex) {
                Logger.getLogger(InformatorPutnika.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
