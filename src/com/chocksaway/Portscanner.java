package com.chocksaway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

/**
 * Portscanner class - allows you to check open ports on a localhost
 */
public class Portscanner {
    private final Logger logger = LoggerFactory.getLogger(Portscanner.class);

    public void scanRange() {
        for (int counter=1; counter<=65535; counter++) {
            if (this.portIsOpen("127.0.0.1", counter, 500)) {
                logger.info("port " + counter + " is open");
            }
        }
    }


    public boolean portIsOpen(String ip, int port, int timeout) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    public boolean scan(int port) {
        if (this.portIsOpen("127.0.0.1", port, 500)) {
            logger.info(port + " open " );
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        Portscanner scanner = new Portscanner();

        long lDateTime = new Date().getTime();
        scanner.scanRange();
        System.out.println(new Date().getTime() - lDateTime);
    }
}
