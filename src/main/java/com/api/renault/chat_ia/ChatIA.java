package com.api.renault.chat_ia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatIA {

        public static String run(String query) {

            String pythonScriptPath = "ia_chat/chat.py";
            String[] command = {"python", pythonScriptPath, "-q", query};

            ProcessBuilder processBuilder = new ProcessBuilder(command);

            try {

                Process process = processBuilder.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;

//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line);
//                }

                if((line = reader.readLine()) != null) {
                    return line;
                }

                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                while ((line = errorReader.readLine()) != null) {
                    System.err.println(line);
                }

                int exitCode = process.waitFor();
                System.out.println("Exited with code: " + exitCode);

            } catch (IOException | InterruptedException e) {
                return e.toString();
            }

            return "Erro";
        }
}

