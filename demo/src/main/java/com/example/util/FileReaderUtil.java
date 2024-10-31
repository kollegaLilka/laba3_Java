package com.example.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    private static final Logger logger = LogManager.getLogger(FileReaderUtil.class);

    public List<String> readValidLines(String filePath) {
        List<String> validLines = new ArrayList<>();
        
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isValidLine(line)) {
                    validLines.add(line);
                } else {
                    logger.warn("Неверная строка: {}", line);
                }
            }
        } catch (IOException e) {
            logger.error("Ошибка при чтении файла: {}", e.getMessage(), e);
        }

        return validLines;
    }

    private boolean isValidLine(String line) {
        // Проверяем, что строка не null и не пустая после удаления пробелов
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        // Проверяем, что строка содержит только допустимые символы (цифры, пробелы и десятичные точки)
        return line.matches("^[0-9\\s.]+$");
    }
}