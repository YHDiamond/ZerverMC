package com.yhdiamond.common;

import com.yhdiamond.common.console.ConsoleManager;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File jarPathFile = new File("config.json");
        String jarPath;
        String JVMArgs;
        JSONObject jsonConfig;
        if (jarPathFile.exists()) {
            Scanner scanner = new Scanner(jarPathFile);
            String flattenedObject = "";
            while (scanner.hasNextLine()) {
                flattenedObject += scanner.nextLine();
            }
            jsonConfig = new JSONObject(flattenedObject);
            jarPath = jsonConfig.get("path").toString();
            JVMArgs = jsonConfig.get("jvmargs").toString();
        } else {
            try {
                FileWriter writer = new FileWriter(jarPathFile);
                writer.write(
                        "{" + "\n" +
                        "  \"path\": \"\"," + "\n" +
                        "  \"jvmargs\": \"\"," + "\n" +
                        "  \"gui\": false" + "\n" +
                        "}"
                );
                writer.flush();
                writer.close();
                System.out.println("Config file not found. Generating one now. Stopping...");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }


        String command = "java " + JVMArgs + " -jar " + jarPath;

        try {
            String gui = "";

            URI uri = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI();
            File startLocation = new File(uri);
            if (!jsonConfig.getBoolean("gui")) gui = "nogui";
            Process proc = Runtime.getRuntime().exec(command, new String[]{}, startLocation.getParentFile());
            ConsoleManager.setProcess(proc);
            ConsoleManager.init();
        } catch (IOException | URISyntaxException e){
            e.printStackTrace();
        }


    }

}
