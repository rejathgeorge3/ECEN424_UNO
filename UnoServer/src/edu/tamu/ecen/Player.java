package edu.tamu.ecen;

import java.net.Socket;

public class Player extends Thread {

    private int playerNum;
    private Socket sock;


    public Player(int playerNum, Socket sock) {
        this.playerNum = playerNum;
        this.sock = sock;
    }

    @Override
    public void run() {
        System.out.println("started thread for player "+ playerNum);
    }

}
