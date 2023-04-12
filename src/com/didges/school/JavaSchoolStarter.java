package com.didges.school;

import java.util.*;

public class JavaSchoolStarter {
    //Дефолтный конструктор
    public JavaSchoolStarter() {
    }


    public List<Map<String, Object>> DataBase = new ArrayList<>();

    //На вход запрос, на выход результат выполнения запроса
    public List<Map<String, Object>> execute(String request) throws Exception {
        //проходим до первого символа не являющимся пробелом
        int i = 0;
        while (request.charAt(i) == ' ') {
            i++;
        }
        //считываем тип запроса
        StringBuilder req = new StringBuilder();
        for (int j = 0; request.charAt(i) != ' '; j++) {
            req.insert(j, request.charAt(i));
            i++;
            if (j == request.length() - 1) {
                break;
            }
        }
        //String sssss="(?i)insert";
        //находим нужный нам запрос
        String req_type = new String(req);
        if (req_type.matches("(?i)insert")) {
            return INSERT2(request);
        } else if (req_type.matches("(?i)update")) {
            return UPDATE(request);
        } else if (req_type.matches("(?i)delete")) {
            return DELETE(request);
        } else if (req_type.matches("(?i)select")) {
            return SELECT(request);
        } else {
            throw new Exception();
        }
    }



    private List<Map<String, Object>> INSERT2(String request) throws Exception{
        Map<String, Object> row = new HashMap<>();
        int i = 0;

        //проходы пишутся с учетом, того что могут быть лишние пробелы где угодно, в начале, в конце или между значениями.
        //проходим insert
        while (request.charAt(i) == ' ') {
            i++;
        }
        while (request.charAt(i) != ' ') {
            i++;
        }
        while (request.charAt(i) == ' ') {
            i++;
        }
        //проверяем что слово VALUES
        StringBuilder req = new StringBuilder();
        for (int j = 0; request.charAt(i) != ' '; j++) {
            req.insert(j, request.charAt(i));
            i++;
            if (j == request.length() - 1) {
                break;
            }
        }
        String s_val=new String(req);
        if(!s_val.matches("(?i)values")){
            throw new Exception();
        }
        row=ParseString.InfoRow(request.substring(i));
        DataBase.add(row);
        List<Map<String, Object>> DB = new ArrayList<>();
        DB.add(row);
        return DB;
    }
    private List<Map<String, Object>> UPDATE(String request) throws Exception {
        int i = 0;
        //проходы пишутся с учетом, того что могут быть лишние пробелы где угодно, в начале, в конце или между значениями.
        while (request.charAt(i) == ' ') {
            i++;
        }
        while (request.charAt(i) != ' ') {
            i++;
        }
        while (request.charAt(i) == ' ') {
            i++;
        }
        //проверяем что слово VALUES
        StringBuilder req = new StringBuilder();
        for (int j = 0; request.charAt(i) != ' '; j++) {
            req.insert(j, request.charAt(i));
            i++;
            if (j == request.length() - 1) {
                break;
            }
        }
        String s_val=new String(req);
        if(!s_val.matches("(?i)values")){
            throw new Exception();
        }
        int start=i;
        boolean have_where=false;
        // where
        while(i+5!=request.length()){
            if(request.substring(i,i+5).matches("(?i)where")){
                have_where=true;
                break;
            }
            i++;
        }

        if(have_where){

            List<Map<String, Object>> DB = new ArrayList<>();
            String after_where=request.substring(i+5);
            String befor_where=request.substring(start,i);
            for(int k=0; k<DataBase.size();k++){
                if(ParseString.TrueFalse(DataBase.get(k),after_where)){
                    Map<String, Object> row = new HashMap<>();
                    row=ParseString.InfoRow(befor_where);
                    if(row.get("lastName")!=null){
                        DataBase.get(k).put("lastName",row.get("lastName"));
                    }
                    if(row.get("id")!=null){
                        DataBase.get(k).put("id",row.get("id"));
                    }
                    if(row.get("age")!=null){
                        DataBase.get(k).put("age",row.get("age"));
                    }
                    if(row.get("cost")!=null){
                        DataBase.get(k).put("cost",row.get("cost"));
                    }
                    if(row.get("active")!=null){
                        DataBase.get(k).put("active",row.get("active"));
                    }
                    DB.add(row);
                }
            }
            return DB;
        }else{
            String befor_where=request.substring(start);
            for(int k=0; k<DataBase.size();i++){
                Map<String, Object> row = new HashMap<>();
                row=ParseString.InfoRow(befor_where);
                if(row.get("lastName")!=null){
                    DataBase.get(k).put("lastName",row.get("lastName"));
                }
                if(row.get("id")!=null){
                    DataBase.get(k).put("id",row.get("id"));
                }
                if(row.get("age")!=null){
                    DataBase.get(k).put("age",row.get("age"));
                }
                if(row.get("cost")!=null){
                    DataBase.get(k).put("cost",row.get("cost"));
                }
                if(row.get("active")!=null){
                    DataBase.get(k).put("active",row.get("active"));
                }
            }
            return DataBase;
        }
    }

    private List<Map<String, Object>> DELETE(String request) throws Exception {
        List<Map<String, Object>> result=new ArrayList<>();
        int i = 0;
        //проходы пишутся с учетом, того что могут быть лишние пробелы где угодно, в начале, в конце или между значениями.
        while (request.charAt(i) == ' ') {
            i++;
        }
        while (request.charAt(i) != ' ') {
            i++;
        }
        while (request.charAt(i) == ' ') {
            i++;
            if(request.length()==i){
                break;
            }
        }
        //если нет where
        if(request.length()==i){
            List<Map<String, Object>> DB=new ArrayList<>();
            Collections.copy(DB,DataBase);
            DataBase.clear();
            return DB;
        }
        //проверяем что слово WHERE
        StringBuilder req = new StringBuilder();
        for (int j = 0; request.charAt(i) != ' '; j++) {
            req.insert(j, request.charAt(i));
            i++;
            if (j == request.length() - 1) {
                break;
            }
        }
        String s_val=new String(req);
        if(!s_val.matches("(?i)WHERE")){
            throw new Exception();
        }
        String inform=request.substring(i);
        //System.out.println(inform);
        for(int k=0; k<DataBase.size();k++){
            if(ParseString.TrueFalse(DataBase.get(k),inform)){
                //System.out.println(ParseString.TrueFalse(DataBase.get(k),inform));
                result.add(DataBase.get(k));
                DataBase.remove(k);
                k--;
            }
        }
        return result;
    }

    private List<Map<String, Object>> SELECT(String request) throws Exception {
        List<Map<String, Object>> result=new ArrayList<>();
        int i = 0;
        //проходы пишутся с учетом, того что могут быть лишние пробелы где угодно, в начале, в конце или между значениями.
        while (request.charAt(i) == ' ') {
            i++;
        }
        while (request.charAt(i) != ' ') {
            i++;
            if(request.length()==i){
                break;
            }
        }
        if(request.length()==i){
            return DataBase;
        }
        while (request.charAt(i) == ' ') {
            i++;
            if(request.length()==i){
                break;
            }
        }
        //если нет where
        if(request.length()==i){
            return DataBase;
        }
        //проверяем что слово WHERE
        StringBuilder req = new StringBuilder();
        for (int j = 0; request.charAt(i) != ' '; j++) {
            req.insert(j, request.charAt(i));
            i++;
            if (j == request.length() - 1) {
                break;
            }
        }
        String s_val=new String(req);
        if(!s_val.matches("(?i)WHERE")){
            throw new Exception();
        }
        String inform=request.substring(i);
        for(int k=0; k<DataBase.size();k++){
            if(ParseString.TrueFalse(DataBase.get(k),inform)){
                result.add(DataBase.get(k));
            }
        }
        return result;
    }
}
