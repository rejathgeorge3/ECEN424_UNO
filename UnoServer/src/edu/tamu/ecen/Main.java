package edu.tamu.ecen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            final ServerSocket serverSocket = new ServerSocket(4571);


            /* Setup threads for each player */
            
            //max of ten players
            ArrayList<Player> players = new ArrayList<>(10);

            // wait until 3 players have joined
            while (players.size() < 3) {
                Socket pSock = serverSocket.accept();

                players.add(new Player(players.size()+1, pSock));
                System.out.println("Player " + players.size() + " has joined.");
            }

            //once three players have joined, we have enough to play. Allow an extra 15 seconds for more players to join

            try {
                serverSocket.setSoTimeout(15000);
                Socket pSock = serverSocket.accept();

                players.add(new Player(players.size()+1, pSock));
                System.out.println("Player " + players.size() + " has joined.");
                // start a timer thread to interrupt accept() method after 15 seconds of no connection
                //Thread timer
            } catch (SocketException e) {
                System.out.println("Game is starting!!");
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
