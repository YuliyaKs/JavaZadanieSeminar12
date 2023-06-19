// Задание
// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder и/или String. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.util.LinkedHashMap;
import java.util.Map;

public class task2_1 {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"name", "Ivanov"}, {"country", "Russia"}, {"city", "Moscow"}, {"age","null"}};
        Map<String, String> map = new LinkedHashMap<>();
        
        // Заполняем словарь из массива
        for (String[] str : arr) {
                for (int i = 0; i < str.length; i += 2) {
                map.put(str[i], str[i + 1]);
            }
        }
        System.out.println(getRequest(map));
    }

    // Создаем sql-запрос из словаря
    public static String getRequest(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        if (params == null || params.isEmpty())
            return result.toString();

        for (Map.Entry<String, String> item : params.entrySet()) {
            if (item.getKey() == "null" || item.getValue() == "null")
                continue;

            result.append(item.getKey()).append(" = '").append(item.getValue()).append("' and ");
        }

        if (result.length() > 5)
            result.delete(result.length() - 5, result.length()); // удаляем лишнее слово "' and " в конце

        return result.toString();
    }
}        