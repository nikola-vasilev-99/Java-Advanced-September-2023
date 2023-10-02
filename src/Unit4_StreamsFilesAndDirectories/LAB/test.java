package Unit4_StreamsFilesAndDirectories.LAB;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Никола\\Desktop\\Java Advanced\\Unit 4 Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        try (FileInputStream inputStream = new FileInputStream(path)) {
            int currentByte = inputStream.read();
            //докато има какво да бъде прочетено, чети
            while (currentByte >= 0) {
                System.out.print(Integer.toBinaryString(currentByte) + " ");
                currentByte = inputStream.read();
            }

        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
