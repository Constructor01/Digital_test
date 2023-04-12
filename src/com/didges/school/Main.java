package com.didges.school;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String... args){
        JavaSchoolStarter starter = new JavaSchoolStarter();
        try {
            //Вставка строки в коллекцию
            List<Map<String,Object>> result1 = starter.execute("INSERT VALUES 'lastName' = 'Федоров' , 'id'  =  3  , 'age'=40, 'active'=true");
            //Изменение значения которое выше записывали
            List<Map<String,Object>> result2 = starter.execute("UPDATE VALUES 'active'=false, 'cost'=10.1 where 'id'=3");
            //Получение всех данных из коллекции (т.е. в данном примере вернется 1 запись)
            List<Map<String,Object>> result3 = starter.execute("SELECT");
            //проверки
            //List<Map<String,Object>> result4 = starter.execute("  iNsert VALUES 'lastName' = 'Федоров'");
            List<Map<String,Object>> result5 = starter.execute("  iNsert VALUES 'age' =    40     ");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
