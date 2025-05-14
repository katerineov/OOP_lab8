package com.example.laba8.service;

import jakarta.servlet.ServletContext;
import java.io.*;

public class FileService {
    private static final String FILE_NAME = "RentEntries.json";

    public static String readFile(ServletContext context) throws IOException {
        String filePath = context.getRealPath("/WEB-INF/" + FILE_NAME);
        File file = new File(filePath);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("[]");
            }
            return "[]";
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    public static void writeFile(ServletContext context, String content) throws IOException {
        String filePath = context.getRealPath("/WEB-INF/" + FILE_NAME);
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
    }
}