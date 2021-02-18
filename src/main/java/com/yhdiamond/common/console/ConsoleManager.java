package com.yhdiamond.common.console;

import com.yhdiamond.common.gui.ConsoleFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ConsoleManager {

    public static Process process;
    public static BufferedReader br;
    public static ConsoleFrame frame;
    public static boolean go = true;
    public static void sendCommand(String command) throws IOException {
        OutputStream os = process.getOutputStream();
        os.write((command).getBytes());
        os.flush();
        System.out.println(command);
    }

    public static void write(String message) throws IOException {
        frame.jTextArea1.setText(frame.jTextArea1.getText() + "\n" + message);
        System.out.println(message);
    }
    public static void write(char c) throws IOException {
        frame.jTextArea1.setText(frame.jTextArea1.getText() + c);
        System.out.print(c);
    }

    public static void init() {
        frame = new ConsoleFrame();
        frame.setVisible(true);
        br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        char c;
        while (go) {
            try {
                if ((c = (char) br.read()) != '\uFFFF') {
                    write(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void stop() {
        go = false;
    }
    public static void setProcess(Process proc) {
        process = proc;
    }
}
