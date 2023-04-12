package com.didges.school;

import java.util.*;

public class JavaSchoolStarter {
    //Дефолтный конструктор
    public JavaSchoolStarter() {
    }

    private List<Map<String, Object>> DataBase = new ArrayList<>();

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
        if (req_type.matches("[Ii][Nn][Ss][Ee][Rr][Tt]")) {
            return INSERT(request);
        } else if (req_type.matches("[Uu][Pp][Dd][Aa][Tt][Ee]")) {
            return UPDATE(request);
        } else if (req_type.matches("[Dd][Ee][Ll][Ee][Tt][Ee]")) {
            return DELETE(request);
        } else if (req_type.matches("[Se][Ee][Ll][Ee][Cc][Tt]")) {
            return SELECT(request);
        } else {
            throw new Exception();
        }
    }

    private List<Map<String, Object>> INSERT(String request) throws Exception {
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

        //проходим values
        while (request.charAt(i) == ' ') {
            i++;
        }
        while (request.charAt(i) != ' ') {
            i++;
        }

        //идем до начала 1 запроса
        while (request.charAt(i) == ' ') {
            i++;
        }

        //обрабатываем все значения в цикле
        while (request.length() != i) {
            //находим 1 верхнюю '
            while (request.charAt(i) != '\'') {
                i++;
            }
            int index1 = i;//первая кавычка
            i++;
            //находим 2 верхнюю '
            while (request.charAt(i) != '\'') {
                i++;
            }
            int index2 = i;
            //название столбца
            String column_name = request.substring(index1 + 1, index2);
            while (request.charAt(i) != '=') {
                i++;
            }
            i++;
            if (column_name.matches("[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]")) {//если lastname
                //находим 1 верхнюю '
                while (request.charAt(i) != '\'') {
                    i++;
                }
                int ind1 = i;//первая кавычка
                i++;
                //находим 2 верхнюю '
                while (request.charAt(i) != '\'') {
                    i++;
                }
                int ind2 = i;
                //название столбца
                String stroke_name = request.substring(ind1 + 1, ind2);
                row.put("lastName", stroke_name);
                //верно оформлена
            } else if (column_name.matches("[Aa][Gg][Ee]")) {//если age
                while (request.charAt(i) == ' ') {
                    i++;
                }
                int ind1 = i;
                while (request.charAt(i) != ' ' && request.charAt(i) != ',') {
                    i++;
                    if (i == request.length()) {
                        break;
                    }
                }
                int ind2 = i;
                String stroke_name = request.substring(ind1, ind2);
                long age = Long.parseLong(stroke_name);
                row.put("age", age);

            } else if (column_name.matches("[Cc][Oo][Ss][Tt]")) {//если cost
                while (request.charAt(i) == ' ') {
                    i++;
                }
                int ind1 = i;
                while (request.charAt(i) != ' ' && request.charAt(i) != ',') {
                    i++;
                    if (i == request.length()) {
                        break;
                    }
                }
                int ind2 = i;
                String stroke_name = request.substring(ind1, ind2);
                Double cost = Double.parseDouble(stroke_name);
                row.put("cost", cost);
            } else if (column_name.matches("[Ii][Dd]")) {//если id
                while (request.charAt(i) == ' ') {
                    i++;
                }
                int ind1 = i;
                while (request.charAt(i) != ' ' && request.charAt(i) != ',') {
                    i++;
                    if (i == request.length()) {
                        break;
                    }
                }
                int ind2 = i;
                String stroke_name = request.substring(ind1, ind2);
                long id = Long.parseLong(stroke_name);
                row.put("id", id);
            } else if (column_name.matches("[Aa][Cc][Tt][Ii][Vv][Ee]")) {//если action
                while (request.charAt(i) == ' ') {
                    i++;
                }
                int ind1 = i;
                while (request.charAt(i) != ' ' && request.charAt(i) != ',') {
                    i++;
                    if (i == request.length()) {
                        break;
                    }
                }
                int ind2 = i;
                String stroke_name = request.substring(ind1, ind2);
                Boolean active = Boolean.parseBoolean(stroke_name);
                row.put("active", active);
            } else {//если столбец не соответсвует формату то ошибку
                throw new Exception();
            }
            //конец проверок
            if (i >= request.length()) {
                break;
            }
            while (request.charAt(i) != ',') {
                i++;
                if (i >= request.length()) {
                    break;
                }
            }
        }
        /*Set <String> sss=row.keySet();
        for(String aa:sss){
            System.out.println(aa+" "+row.get(aa));
        }*/
        DataBase.add(row);
        return DataBase;
    }

    private List<Map<String, Object>> UPDATE(String request) throws Exception {
        int i = 0;

        //проходы пишутся с учетом, того что могут быть лишние пробелы где угодно, в начале, в конце или между значениями.
        //проходим insert
        while (request.charAt(i) == ' ') {
            i++;
        }
        while (request.charAt(i) != ' ') {
            i++;
        }

        //проходим values
        while (request.charAt(i) == ' ') {
            i++;
        }
        while (request.charAt(i) != ' ') {
            i++;
        }

        return new ArrayList<>();
    }

    private List<Map<String, Object>> DELETE(String request) throws Exception {

        return new ArrayList<>();
    }

    private List<Map<String, Object>> SELECT(String request) throws Exception {

        return new ArrayList<>();
    }
}
