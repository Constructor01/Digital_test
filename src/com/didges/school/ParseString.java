package com.didges.school;

import java.util.*;

public class ParseString {
    //проверяет кореектность введенной строки после values
    public static Map<String, Object> InfoRow(String information) throws Exception{
        Map<String, Object> row = new HashMap<>();
        row.put("lastName", null);
        row.put("age", null);
        row.put("cost", null);
        row.put("active", null);
        row.put("id", null);
        //считаем количество вызово для значений
        int count_lastname=0;
        int count_age=0;
        int count_cost=0;
        int count_active=0;
        int count_id=0;
        int i=0;
        while(i!=information.length()){
            //проходим все пробелы если они вообще есть
            while (information.charAt(i) == ' ') {
                i++;
                if(i==information.length()){
                    System.out.println("Invalid request for Insert");
                    throw new Exception();
                }
            }

            //проверка на то что это один из столбцов
            String ValidSt="";
            if(information.charAt(i)=='\''){
                //смотрим следующий символ не '
                i++;
                if(i==information.length()){
                    System.out.println("Invalid request for Insert");
                    throw new Exception();
                }
                //идем пока символы не равны ' и записываем в строку ValidSt
                while(information.charAt(i)!='\''){
                    ValidSt+=information.charAt(i);
                    i++;
                    if(i==information.length()){
                        System.out.println("Invalid request for Insert");
                        throw new Exception();
                    }
                }
                CheckValid(ValidSt);
            }else{
                System.out.println("Invalid request for Insert");
                throw new Exception();
            }
            //переходим дальше
            i++;
            if(i==information.length()){
                System.out.println("Invalid request for Insert");
                throw new Exception();
            }
            //проверка на пробелы между назвванием столбца и знаком равно
            while (information.charAt(i) == ' ') {
                i++;
                if(i==information.length()){
                    System.out.println("Invalid request for Insert");
                    throw new Exception();
                }
            }
            //проверяем знак
            if(information.charAt(i)!='='){
                System.out.println("Invalid symbol");
                throw new Exception();
            }
            i++;
            if(i==information.length()){
                System.out.println("Invalid request for Insert");
                throw new Exception();
            }
            //проверка на пробелы между знаком равно и значением столбца
            while (information.charAt(i) == ' ') {
                i++;
                if(i==information.length()){
                    System.out.println("Invalid request for Insert");
                    throw new Exception();
                }
            }

            //проверка на введенные типы данных после равно
            String word="";
            if(ValidSt.matches("(?i)lastname")){
                count_lastname++;
                if(count_lastname>1){
                    System.out.println("count lastname more 1");
                    throw new Exception();
                }
                if(information.charAt(i)=='\''){
                    //смотрим следующий символ не '
                    i++;
                    if(i==information.length()){
                        System.out.println("Invalid request for Insert");
                        throw new Exception();
                    }
                    //идем пока символы не равны ' и записываем в строку ValidSt
                    while(information.charAt(i)!='\''){
                        word+=information.charAt(i);
                        i++;
                        if(i==information.length()){
                            System.out.println("Invalid request for Insert");
                            throw new Exception();
                        }
                    }
                    i++;
                }else{
                    System.out.println("Invalid type for lastname");
                    throw new Exception();
                }
                row.put("lastName", word);
            }
            else if(ValidSt.matches("(?i)id")){
                count_id++;
                if(count_id>1){
                    System.out.println("count id more 1");
                    throw new Exception();
                }
                String sim="";
                sim+=information.charAt(i);
                while(i!=information.length()){
                    //если конец строки то выходим из цикла
                    i++;
                    if(i==information.length()){
                        break;
                    }
                    //если запятая то идем дальше
                    if(information.charAt(i) == ','){
                        break;
                    }
                    //если пробел то идем дальше
                    if(information.charAt(i) == ' '){
                        break;
                    }
                    //добавляем значение
                    sim+=information.charAt(i);
                    if(!sim.matches("[0-9]*")){
                        System.out.println("Invalid type for id");
                        throw new Exception();
                    }
                }
                word+=sim;
                long id = Long.parseLong(word);
                row.put("id", id);
            }
            else if(ValidSt.matches("(?i)age")){
                count_age++;
                if(count_age>1){
                    System.out.println("count age more 1");
                    throw new Exception();
                }
                String sim="";
                sim+=information.charAt(i);
                while(i!=information.length()){
                    //если конец строки то выходим из цикла
                    i++;
                    if(i==information.length()){
                        break;
                    }
                    //если запятая то идем дальше
                    if(information.charAt(i) == ','){
                        break;
                    }
                    //если пробел то идем дальше
                    if(information.charAt(i) == ' '){
                        break;
                    }
                    //добавляем значение
                    sim+=information.charAt(i);
                    if(!sim.matches("[0-9]*")){
                        System.out.println("Invalid type for age");
                        throw new Exception();
                    }
                }
                word+=sim;
                long age = Long.parseLong(word);
                row.put("age", age);
            }
            else if(ValidSt.matches("(?i)active")){
                count_active++;
                if(count_active>1){
                    System.out.println("count active more 1");
                    throw new Exception();
                }
                String sim="";
                sim+=information.charAt(i);
                while(i!=information.length()){
                    //если конец строки то выходим из цикла
                    i++;
                    if(i==information.length()){
                        break;
                    }
                    //если запятая то идем дальше
                    if(information.charAt(i) == ','){
                        break;
                    }
                    //если пробел то идем дальше
                    if(information.charAt(i) == ' '){
                        break;
                    }
                    //добавляем значение
                    sim+=information.charAt(i);
                }
                if(sim.matches("false")){
                    word+=sim;
                }else if(sim.matches("true")){
                    word+=sim;
                }else{
                    System.out.println("Invalid type active");
                    throw new Exception();
                }
                Boolean active = Boolean.parseBoolean(word);
                row.put("active", active);

            }
            else if(ValidSt.matches("(?i)cost")){
                count_cost++;
                if(count_cost>1){
                    System.out.println("count cost more 1");
                    throw new Exception();
                }
                String sim="";
                sim+=information.charAt(i);
                while(i!=information.length()){
                    //если конец строки то выходим из цикла
                    i++;
                    if(i==information.length()){
                        break;
                    }
                    //если запятая то идем дальше
                    if(information.charAt(i) == ','){
                        break;
                    }
                    //если пробел то идем дальше
                    if(information.charAt(i) == ' '){
                        break;
                    }
                    //добавляем значение
                    sim+=information.charAt(i);
                }
                //если строка состит из чисел и точек
                if(sim.matches("[0-9.]*")){
                    //посчитаем сколько точек в строке
                    int count_point=0;
                    for(int k=0; k<sim.length();k++){
                        if(sim.charAt(k)=='.'){
                            count_point++;
                        }
                    }
                    //если точек количество точек не 1 то ошибка
                    if(count_point!=1){
                        System.out.println("Invalid type cost");
                        throw new Exception();
                    }
                    //если точка первый или последний символ
                    if(sim.charAt(sim.length()-1)=='.' || sim.charAt(0)=='.'){
                        System.out.println("Invalid type cost");
                        throw new Exception();
                    }
                    word+=sim;
                } else{
                    System.out.println("Invalid type cost");
                    throw new Exception();
                }
                Double cost = Double.parseDouble(word);
                row.put("cost", cost);
            }


            //если конец строки то всё
            if(i==information.length()){
                break;
            }
            //проверяем пробелы
            while (information.charAt(i) == ' ') {
                i++;
                if(i==information.length()){
                    break;
                }
            }
            //если после пробелов конец строки то всё
            if(i==information.length()){
                break;
            }
            //если некст знак это запятая то всё норм
            if(information.charAt(i)==','){
                i++;
            }else{
                System.out.println("After information must be ,");//"After , must be next information"
                throw new Exception();
            }
            //если запятая конец строки то ошибка
            if(i==information.length()){
                System.out.println("\"After , must be next information\"");
                throw new Exception();
            }
        }
        //System.out.println(word);
        return row;
    }
    //доп метод к InfoRow
    public static String CheckValid(String column_name) throws Exception {
        if (column_name.matches("(?i)lastname")){
            return "lastName";
        }else if(column_name.matches("(?i)age")){
            return "age";
        }else if(column_name.matches("(?i)cost")){
            return "cost";
        }else if(column_name.matches("(?i)active")){
            return "active";
        }else if(column_name.matches("(?i)id")){
            return "id";
        }else{
            System.out.println("Invalid column name");
            throw new Exception();
        }
    }

    //метод для преобразования все что после where в 0 и 1 для одного контейнера и and or для другого
    public static Boolean TrueFalse(Map<String, Object> row, String information) throws Exception{
        ArrayList<Integer> Number=new ArrayList<>();
        ArrayList<String> AndOr=new ArrayList<>();
        int i=0;
        while(i!=information.length()){
            //проходим все пробелы если они вообще есть
            while (information.charAt(i) == ' ') {
                i++;
                if(i==information.length()){
                    System.out.println("Invalid start length");
                    throw new Exception();
                }
            }

            //проверка на то что это один из столбцов
            String ValidSt="";
            if(information.charAt(i)=='\''){
                //смотрим следующий символ не '
                i++;
                if(i==information.length()){
                    System.out.println("Invalid request for Insert");
                    throw new Exception();
                }
                //идем пока символы не равны ' и записываем в строку ValidSt
                while(information.charAt(i)!='\''){
                    ValidSt+=information.charAt(i);
                    i++;
                    if(i==information.length()){
                        System.out.println("Invalid request for Insert");
                        throw new Exception();
                    }
                }
                CheckValid(ValidSt);
            }else{
                System.out.println("Invalid request for Insert");
                throw new Exception();
            }
            //переходим дальше
            i++;
            if(i==information.length()){
                System.out.println("Invalid request for Insert");
                throw new Exception();
            }

            //проверка на пробелы между назвванием столбца и знаком
            while (information.charAt(i) == ' ') {
                i++;
                if(i==information.length()){
                    System.out.println("Invalid request for Insert");
                    throw new Exception();
                }
            }

            //запоминаем знак
            String znak="";
            znak+=information.charAt(i);
            while(i!=information.length()){
                i++;
                //если за предел вышли
                if(i==information.length()){
                    break;
                }
                znak+=information.charAt(i);
                if(!znak.matches("[!><=like]*")){
                    break;
                }
            }
            if(i==information.length()){
                System.out.println("Invalid request for Insert");
                throw new Exception();
            }
            //так как мы взяли следующий символ то возьмем на 1 меньше
            znak=znak.substring(0,znak.length()-1);
            CheckZnak(znak);
            //System.out.println(znak+" "+znak.length());
            //проверка на пробелы между знаком и значением сравнения
            while (information.charAt(i) == ' ') {
                i++;
                if(i==information.length()){
                    System.out.println("Invalid request for Insert");
                    throw new Exception();
                }
            }

            //проверка на введенные типы данных после знака
            String word="";
            if(ValidSt.matches("(?i)lastname")){
                //если сравнение со строкой
                if(information.charAt(i)=='\''){
                    //смотрим следующий символ не '
                    i++;
                    if(i==information.length()){
                        System.out.println("Invalid request for Insert");
                        throw new Exception();
                    }
                    //идем пока символы не равны ' и записываем в строку ValidSt
                    while(information.charAt(i)!='\''){
                        word+=information.charAt(i);
                        i++;
                        if(i==information.length()){
                            System.out.println("After first ' you need '");
                            throw new Exception();
                        }
                    }
                    i++;
                    //теперь сравниваем
                    if(znak.equals("like")){
                        word=word.replaceAll("%",".*");
                        if(row.get("lastName")!=null){
                            if(row.get("lastName").toString().matches(word)){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }
                    }else if(znak.equals("ilike")){
                        word=word.replaceAll("%",".*");
                        word=word.toLowerCase(Locale.ROOT);
                        if(row.get("lastName")!=null){
                            if(row.get("lastName").toString().matches(word)){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }
                    }else if(znak.equals("=")){
                        if(row.get("lastName")!=null){
                            if(row.get("lastName").toString().equals(word)){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }else if(znak.equals("!=")){
                        if(row.get("lastName")!=null){
                            if(!row.get("lastName").toString().equals(word)){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                        else{
                        System.out.println("Invalid sign for string");
                        throw new Exception();
                    }
                    //сравнение не со строкой
                }else{
                    String sim="";
                    sim+=information.charAt(i);
                    while(i!=information.length()){
                        //если конец строки то выходим из цикла
                        i++;
                        if(i==information.length()){
                            break;
                        }
                        //если пробел то идем дальше
                        if(information.charAt(i) == ' '){
                            break;
                        }
                        //добавляем значение
                        sim+=information.charAt(i);
                    }
                    if(znak.equals("=")){
                        Number.add(0);
                    }else if(znak.equals("!=")){
                        Number.add(1);
                    }else{
                        System.out.println("Invalid type");
                        throw new Exception();
                    }
                }


            }
            else if(ValidSt.matches("(?i)id")){
                String sim="";
                sim+=information.charAt(i);
                while(i!=information.length()){
                    //если конец строки то выходим из цикла
                    i++;
                    if(i==information.length()){
                        break;
                    }
                    //если пробел то идем дальше
                    if(information.charAt(i) == ' '){
                        break;
                    }
                    //добавляем значение
                    sim+=information.charAt(i);
                }
                if(sim.matches("[0-9]*")){
                    word+=sim;
                    long id = Long.parseLong(word);
                    if(znak.equals("=")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())==id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("!=")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())!=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals(">=")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())>=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<=")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())<=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals(">")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())>id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())<id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else{
                        System.out.println("Uncorrect sign");
                        throw new Exception();
                    }
                }
                else if(sim.matches("[0-9.]*")){
                    //посчитаем сколько точек в строке
                    int count_point=0;
                    for(int k=0; k<sim.length();k++){
                        if(sim.charAt(k)=='.'){
                            count_point++;
                        }
                    }
                    //если точек количество точек не 1 то ошибка
                    if(count_point!=1){
                        System.out.println("Invalid type cost");
                        throw new Exception();
                    }
                    //если точка первый или последний символ
                    if(sim.charAt(sim.length()-1)=='.' || sim.charAt(0)=='.'){
                        System.out.println("Invalid type cost");
                        throw new Exception();
                    }
                    Double id = Double.parseDouble(word);
                    if(znak.equals("=")){
                        Number.add(0);
                    }
                    else if(znak.equals("!=")){
                      Number.add(1);
                    }
                    else if(znak.equals(">=")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())>=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<=")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())<=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals(">")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())>id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<")){
                        if(row.get("id")!=null){
                            if(Integer.parseInt(row.get("id").toString())<id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else{
                        System.out.println("Uncorrect sign");
                        throw new Exception();
                    }
                }
                else{
                    if(znak.equals("=")){
                       Number.add(0);
                    }
                    else if(znak.equals("!=")){
                       Number.add(1);
                    }
                    else if(znak.equals(">=")){
                        System.out.println("Error type >=");
                        throw new Exception();
                    }
                    else if(znak.equals("<=")){
                        System.out.println("Error type <=");
                        throw new Exception();
                    }
                    else if(znak.equals(">")){
                        System.out.println("Error type >");
                        throw new Exception();
                    }
                    else if(znak.equals("<")){
                        System.out.println("Error type <");
                        throw new Exception();
                    }
                    else{
                        System.out.println("Uncorrect sign");
                        throw new Exception();
                    }
                }
            }
            else if(ValidSt.matches("(?i)age")){
                String sim="";
                sim+=information.charAt(i);
                while(i!=information.length()){
                    //если конец строки то выходим из цикла
                    i++;
                    if(i==information.length()){
                        break;
                    }
                    //если пробел то идем дальше
                    if(information.charAt(i) == ' '){
                        break;
                    }
                    //добавляем значение
                    sim+=information.charAt(i);
                }
                if(sim.matches("[0-9]*")){
                    word+=sim;
                    long id = Long.parseLong(word);
                    if(znak.equals("=")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())==id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("!=")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())!=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals(">=")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())>=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<=")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())<=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals(">")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())>id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())<id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else{
                        System.out.println("Uncorrect sign");
                        throw new Exception();
                    }
                }
                else if(sim.matches("[0-9.]*")){
                    //посчитаем сколько точек в строке
                    int count_point=0;
                    for(int k=0; k<sim.length();k++){
                        if(sim.charAt(k)=='.'){
                            count_point++;
                        }
                    }
                    //если точек количество точек не 1 то ошибка
                    if(count_point!=1){
                        System.out.println("Invalid type cost");
                        throw new Exception();
                    }
                    //если точка первый или последний символ
                    if(sim.charAt(sim.length()-1)=='.' || sim.charAt(0)=='.'){
                        System.out.println("Invalid type cost");
                        throw new Exception();
                    }
                    Double id = Double.parseDouble(word);
                    if(znak.equals("=")){
                        Number.add(0);
                    }
                    else if(znak.equals("!=")){
                        Number.add(1);
                    }
                    else if(znak.equals(">=")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())>=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<=")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())<=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals(">")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())>id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<")){
                        if(row.get("age")!=null){
                            if(Integer.parseInt(row.get("age").toString())<id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else{
                        System.out.println("Uncorrect sign");
                        throw new Exception();
                    }
                }
                else{
                    if(znak.equals("=")){
                        Number.add(0);
                    }
                    else if(znak.equals("!=")){
                        Number.add(1);
                    }
                    else if(znak.equals(">=")){
                        System.out.println("Error type >=");
                        throw new Exception();
                    }
                    else if(znak.equals("<=")){
                        System.out.println("Error type <=");
                        throw new Exception();
                    }
                    else if(znak.equals(">")){
                        System.out.println("Error type >");
                        throw new Exception();
                    }
                    else if(znak.equals("<")){
                        System.out.println("Error type <");
                        throw new Exception();
                    }
                    else{
                        System.out.println("Uncorrect sign");
                        throw new Exception();
                    }
                }
            }
            else if(ValidSt.matches("(?i)active")){
                String sim="";
                sim+=information.charAt(i);
                while(i!=information.length()){
                    //если конец строки то выходим из цикла
                    i++;
                    if(i==information.length()){
                        break;
                    }
                    //если пробел то идем дальше
                    if(information.charAt(i) == ' '){
                        break;
                    }
                    //добавляем значение
                    sim+=information.charAt(i);
                }
                //если значение false или true то сравниваем
                if(sim.matches("false")){
                    if(row.get("active").toString().equals("false")){
                        Number.add(1);
                    }else{
                        Number.add(0);
                    }
                }else if(sim.matches("true")){
                    if(row.get("active").toString().equals("true")){
                        Number.add(1);
                    }else{
                        Number.add(0);
                    }
                    //иначе это не тот тип данных
                }else{
                    if(znak.equals("=")){
                        Number.add(0);
                    }else if(znak.equals("!=")){
                        Number.add(1);
                    }else{
                        System.out.println("Invalid type");
                        throw new Exception();
                    }
                }
            }
            else if(ValidSt.matches("(?i)cost")){
                String sim="";
                sim+=information.charAt(i);
                while(i!=information.length()){
                    //если конец строки то выходим из цикла
                    i++;
                    if(i==information.length()){
                        break;
                    }
                    //если пробел то идем дальше
                    if(information.charAt(i) == ' '){
                        break;
                    }
                    //добавляем значение
                    sim+=information.charAt(i);
                }
                if(sim.matches("[0-9]*")){
                    word+=sim;
                    long id = Long.parseLong(word);
                    if(znak.equals("=")){
                        Number.add(0);
                    }
                    else if(znak.equals("!=")){
                        Number.add(1);
                    }
                    else if(znak.equals(">=")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())>=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<=")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())<=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals(">")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())>id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())<id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else{
                        System.out.println("Uncorrect sign");
                        throw new Exception();
                    }
                }
                else if(sim.matches("[0-9.]*")){
                    //посчитаем сколько точек в строке
                    int count_point=0;
                    for(int k=0; k<sim.length();k++){
                        if(sim.charAt(k)=='.'){
                            count_point++;
                        }
                    }
                    //если точек количество точек не 1 то ошибка
                    if(count_point!=1){
                        System.out.println("Invalid type cost");
                        throw new Exception();
                    }
                    //если точка первый или последний символ
                    if(sim.charAt(sim.length()-1)=='.' || sim.charAt(0)=='.'){
                        System.out.println("Invalid type cost");
                        throw new Exception();
                    }
                    Double id = Double.parseDouble(word);
                    if(znak.equals("=")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())==id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("!=")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())!=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals(">=")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())>=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<=")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())<=id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals(">")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())>id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else if(znak.equals("<")){
                        if(row.get("cost")!=null){
                            if(Integer.parseInt(row.get("cost").toString())<id){
                                Number.add(1);
                            }else{
                                Number.add(0);
                            }
                        }else{
                            Number.add(0);
                        }
                    }
                    else{
                        System.out.println("Uncorrect sign");
                        throw new Exception();
                    }
                }
                else{
                    if(znak.equals("=")){
                        Number.add(0);
                    }
                    else if(znak.equals("!=")){
                        Number.add(1);
                    }
                    else if(znak.equals(">=")){
                        System.out.println("Error type >=");
                        throw new Exception();
                    }
                    else if(znak.equals("<=")){
                        System.out.println("Error type <=");
                        throw new Exception();
                    }
                    else if(znak.equals(">")){
                        System.out.println("Error type >");
                        throw new Exception();
                    }
                    else if(znak.equals("<")){
                        System.out.println("Error type <");
                        throw new Exception();
                    }
                    else{
                        System.out.println("Uncorrect sign");
                        throw new Exception();
                    }
                }
            }


            //если конец строки то всё
            if(i==information.length()){
                break;
            }
            //проверяем пробелы
            while (information.charAt(i) == ' ') {
                i++;
                if(i==information.length()){
                    break;
                }
            }
            //если после пробелов конец строки то всё
            if(i==information.length()){
                break;
            }
            //проверка на and или or
            String spec_symbol="";
            while(i!=information.length()){
                spec_symbol+=information.charAt(i);
                i++;
                if(information.charAt(i)==' '){
                    break;
                }
                if(information.length()==i){
                    break;
                }
            }
            if(spec_symbol.equals("and")){
                AndOr.add("and");
            }else if(spec_symbol.equals("or")){
                AndOr.add("or");
            }else{
                System.out.println("Uncorrect and or or");
                throw new Exception();
            }
            i++;
            if(i==information.length()){
                System.out.println("You must write information after and or or");
                throw new Exception();
            }
        }
        //System.out.println(AndOr);
        //System.out.println(Number);
        return ParseWhere(Number,AndOr);
    }

    public static String CheckZnak(String sign_type) throws Exception {
        if(sign_type.matches("=")){
            return "=";
        }else if(sign_type.matches("!=")){
            return "!=";
        }else if(sign_type.matches("like")){
            return "like";
        }else if(sign_type.matches("ilike")){
            return "ilike";
        }else if(sign_type.matches(">=")){
            return ">=";
        }else if(sign_type.matches("<=")){
            return "<=";
        }else if(sign_type.matches(">")){
            return ">";
        }else if(sign_type.matches("<")){
            return "<";
        }else{
            System.out.println("Error sign");
            throw new Exception();
        }
    }
    public static void Test1(){
        //тест 1
        ArrayList<Integer> test1=new ArrayList<>();
        test1.add(1);
        test1.add(1);
        test1.add(0);
        test1.add(1);
        test1.add(1);
        ArrayList<String> str=new ArrayList<>();
        str.add("and");
        str.add("and");
        str.add("and");
        str.add("or");
        ParseWhere(test1,str);
    }
    public static void Test2(){
        //тест 1
        ArrayList<Integer> test1=new ArrayList<>();
        test1.add(1);
        test1.add(1);
        ArrayList<String> str=new ArrayList<>();
        str.add("and");
        ParseWhere(test1,str);
    }

    public static void Test3(){
        ArrayList<Integer> test1=new ArrayList<>();
        test1.add(1);
        test1.add(0);
        ArrayList<String> str=new ArrayList<>();
        str.add("and");
        ParseWhere(test1,str);
    }

    public static void Test4(){
        ArrayList<Integer> test1=new ArrayList<>();
        test1.add(1);
        test1.add(0);
        ArrayList<String> str=new ArrayList<>();
        str.add("or");
        ParseWhere(test1,str);
    }

    public static void Test5(){
        ArrayList<Integer> test1=new ArrayList<>();
        test1.add(1);
        test1.add(0);
        test1.add(1);
        ArrayList<String> str=new ArrayList<>();
        str.add("or");
        str.add("and");
        ParseWhere(test1,str);
    }

    public static void Test6(){
        ArrayList<Integer> test1=new ArrayList<>();
        test1.add(1);
        test1.add(1);
        test1.add(1);
        test1.add(0);
        test1.add(1);
        test1.add(1);
        ArrayList<String> str=new ArrayList<>();
        str.add("and");
        str.add("or");
        str.add("and");
        str.add("or");
        str.add("and");
        ParseWhere(test1,str);
    }

    public static void main(String... args) throws Exception{
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        //InfoRow("   'LASTNAME'  =  'Uhhhhh'");
        //InfoRow("   'id'  =  92452");
        //InfoRow("   'active'  =  false ");
        //InfoRow("   'cost'  =  234.2134 , 'lastname' = 'dsfasf','id'=10");
        Map<String,Object> a=InfoRow("'lastName'='Федоров' , 'id'=3  , 'age'=40, 'active'=true");
        System.out.println(a.get("lastName"));
        System.out.println(a.get("id"));
        System.out.println(a.get("age"));
        System.out.println(a.get("active"));
        System.out.println(a.get("cost"));

        //TrueFalse(a,"'lastName' ilike '%О%'");
        TrueFalse(a,"'lastName' != 'оров' and 'id'>=3 or 'active'=false or 'active'=3242");
        //TrueFalse(a,"'active' != 1234");
        //String s="ad1";
        //if(s.matches("[0-9]*")){
         //   System.out.println("YES");
        //}
    }

    public static boolean ParseWhere(ArrayList<Integer> Number,ArrayList<String> AndOr){
        //для and
        //ArrayList<Integer> NumberWithoutAnd=new ArrayList<Integer>();
        for(int i=0; i<AndOr.size();i++){
            if(AndOr.get(i)=="and"){
                if(Number.get(i)==1 && Number.get(i+1)==1){
                    Number.set(i+1,1);
                    Number.remove(i);
                    AndOr.remove(i);
                    i--;
                }else{
                    Number.set(i+1,0);
                    Number.remove(i);
                    AndOr.remove(i);
                    i--;
                }
            }
        }
        //для or
        for(int i=0; i<AndOr.size();i++){
            if(AndOr.get(i)=="or"){
                if(Number.get(i)==0 && Number.get(i+1)==0){
                    Number.set(i+1,0);
                    Number.remove(i);
                    AndOr.remove(i);
                    i--;
                }else{
                    Number.set(i+1,1);
                    Number.remove(i);
                    AndOr.remove(i);
                    i--;
                }
            }
        }

        //System.out.println(Number);
        if(Number.get(0)==1){
            return true;
        }
        return false;
    }

}
