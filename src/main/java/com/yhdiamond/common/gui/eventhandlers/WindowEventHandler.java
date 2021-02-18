package com.yhdiamond.common.gui.eventhandlers;

import com.yhdiamond.common.console.ConsoleManager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class WindowEventHandler extends WindowAdapter {


    public void windowClosing(WindowEvent evt) {
        try {
            ConsoleManager.sendCommand("stop");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConsoleManager.stop();
        System.exit(0);

    }

}


