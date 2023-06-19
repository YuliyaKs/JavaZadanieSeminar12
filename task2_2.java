// Дополнительные задания
// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, 
// создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

import java.io.*;

public class task2_2 {
    public static void main(String[] args) throws Exception {
        String [] arrayData = ReadLineFromFile("json_string.txt");
        for(int i = 0; i < arrayData.length; i++) {
            System.out.println(PrintData(arrayData[i]));
        } 
    }
    // Считываем json-строку с файла json_string.txt
    public static String [] ReadLineFromFile(String pathway) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(pathway));
        String str;
        int size = 0;
        while ((str = br.readLine()) != null) {
            size +=1;
            }
        br.close();
        String [] listData = new String [size];
       
        int i = 0;
        BufferedReader br1 = new BufferedReader(new FileReader(pathway));
        while ((str = br1.readLine()) != null) {
            listData[i] = str;
            i += 1;
            }
        br1.close();
        return listData;
    } 
    // Создаем строку вида: Студент [фамилия] получил [оценка] по предмету [предмет].
    public static StringBuilder PrintData(String line) {
        StringBuilder builder = new StringBuilder(line);
            for (int i = 0; i < builder.length(); i++) {
                char ch = builder.charAt(i);
                if (ch == '{'){
                    builder.deleteCharAt(i);
                    i--;
                }
                if (ch == '}'){
                    builder.deleteCharAt(i);
                    i--;
                }
                if (ch == '"'){
                    builder.deleteCharAt(i);
                    i--;
                }
                if (ch == '['){
                    builder.deleteCharAt(i);
                    i--;
                }
                if (ch == ']'){
                    builder.deleteCharAt(i);
                    i--;
                }
            }
        String[] allData = builder.toString().split(",");
        String[] titles = {"Студент ", " получил ", " по предмету "};
        StringBuilder result = new StringBuilder("");
        for (int i =0; i < allData.length; i++) {
            String[] needData = allData[i].split(":");
            result.append(titles[i]);
            result.append(needData[1]);
            }
        result.append(".");            
        return result;
    }
}
