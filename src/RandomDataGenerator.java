package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomDataGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STRING_LENGTH = 15; // Độ dài của mỗi chuỗi
    private static final int NUMBER_OF_STRINGS = 10000; // Số lượng chuỗi cần tạo
    private static final int NUMBER_OF_DOUBLES = 10000; // Số lượng số double cần tạo
    private static final int NUMBER_OF_LONGS = 10000; // Số lượng số long cần tạo

    // Sinh ra chuỗi ngẫu nhiên và ghi vào file
    public static void generateRandomStringsToFile(String filePath) {
        Set<String> randomStrings = new HashSet<>(); // Đảm bảo không có chuỗi trùng lặp
        Random random = new Random();

        while (randomStrings.size() < NUMBER_OF_STRINGS) {
            StringBuilder sb = new StringBuilder(STRING_LENGTH);
            for (int i = 0; i < STRING_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }
            randomStrings.add(sb.toString());
        }

        // Ghi vào file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String str : randomStrings) {
                writer.write(str);
                writer.newLine(); // Ghi dòng mới sau mỗi chuỗi
            }
            System.out.println("Generated " + randomStrings.size() + " unique random strings to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Sinh ra số double ngẫu nhiên và ghi vào file
    public static void generateRandomDoublesToFile(String filePath) {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < NUMBER_OF_DOUBLES; i++) {
                double randomDouble = random.nextDouble() * 10000; // Giới hạn số từ 0 đến 10000
                writer.write(String.valueOf(randomDouble));
                writer.newLine();
            }
            System.out.println("Generated " + NUMBER_OF_DOUBLES + " random doubles to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Sinh ra số long ngẫu nhiên và ghi vào file
    public static void generateRandomLongsToFile(String filePath) {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < NUMBER_OF_LONGS; i++) {
                long randomLong = random.nextLong(); // Số long có thể âm hoặc dương
                writer.write(String.valueOf(randomLong));
                writer.newLine();
            }
            System.out.println("Generated " + NUMBER_OF_LONGS + " random longs to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
