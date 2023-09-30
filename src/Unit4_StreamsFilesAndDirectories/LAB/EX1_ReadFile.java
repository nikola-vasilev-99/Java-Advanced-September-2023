package Unit4_StreamsFilesAndDirectories.LAB;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class EX1_ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Никола\\Desktop\\Java Advanced\\Unit 4 Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        // това в скобите ще ми проверява дали съшествува файла от пътя. Ако не съществува ще throw-не exception
        try (FileInputStream inputStream = new FileInputStream(path)){
            int currentByte = inputStream.read();
            while (currentByte >= 0 ) {
                System.out.print(Integer.toBinaryString(currentByte) + " ");
                currentByte = inputStream.read();
            }
            //ако throw-не exception catch-ъра ще го хване
        } catch (IOException e) {
            System.out.println("File with path " + path + " was not found!");

        }
    }
}
