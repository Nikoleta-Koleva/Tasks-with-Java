package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tasks {
    private int count;

    //Java програма обръщаща низ, без да използва вградена функция reverse().
    public void printReverseWord(String word) {
        char ch;
        String reversedWord = "";
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            reversedWord = ch + reversedWord;
        }
        System.out.println("First task \n" + reversedWord);
    }

    //Java програма, преброяваща броя на думите в низ, използвайки HashMap.
    public void countCharactersInWord(String word) {
        Map<String, Integer> charCount = new HashMap();
        char string[] = word.toCharArray();

        for(int i = 0; i < string.length; i++) {
            count = 1;
            if (charCount.isEmpty()) {
                charCount.putIfAbsent("Number of characters", 1);
            } else {
                charCount.computeIfPresent("Number of characters",(k,v) -> v + 1);
            }
        }
        System.out.println("Second task \n" + charCount);
    }

    //Java програма, обхождаща ArrayList, използвайки for, while.
    public void traverseArray(String firstWord, String secondWord, String thirdWord) {
        ArrayList list = new ArrayList<String>();
        list.add(firstWord);
        list.add(secondWord);
        list.add(thirdWord);

        System.out.println("Third task");
        for (int i = 0; i < list.size(); i++) {
            while (list.isEmpty() == false) {
                System.out.println(list.get(i));
                break;
            }
        }
    }

    //Java програма, намираща дублиращите се символи в низ.
    public void findDuplicateCharacters(String word) {
        char string[] = word.toCharArray();
        for(int i = 0; i < string.length; i++) {
            count = 1;

            for(int j = i+1; j < string.length; j++) {
                if(string[i] == string[j] && string[i] != ' ') {
                    count++;
                    //Символа j се възлага на 0 за да се избегне принтирането на посетен символ
                    string[j] = '0';
                }
            }

            if(count > 1 && string[i] != '0') {
                System.out.println("Fourth task \n" + string[i]);
            }
        }
    }

    //Java програма, четяща Excel файл в конзолата.
    public void readExcelFile() {
        try {
            String filePath = ".\\src\\main\\resources\\TestData.xlsx";
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            // Избира първия лист от книгата
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("Fifth task");

            // Обхожда всички редове на листа
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                // Слага нов ред след всеки ред
                System.out.println();
            }
            // Затваря файловия поток
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
