package org.example.services;

import org.example.model.Question;
import org.example.model.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 Класс, реализует запись/чтение данных в/из файла
*/
public class DataServices {

    private final static String path_toys_list = "toys_lottery_list.txt";
    private final static String path_questions_list = "question.txt";

    /**
        Добавление игрушки в файл
        @param toy игрушка, которую нужно добавить в список
        @param newLine параметр для записи в файл. true: добавление с новой строки, false: перезапись всего файла
    */
    public static void writeData(Toy toy, boolean newLine) {

        try (FileWriter writer = new FileWriter(path_toys_list, newLine)) {
            writer.write(toy.getId() + ",");
            writer.write(toy.getTitle() + ",");
            writer.write(toy.getAmount() + ",");
            writer.write(toy.getPriority() + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     Перезаписывает данные в файле
     @param toysList список игрушек
    */
    public static void reWriteData(List<Toy> toysList) {
        int id = 1;
        for (Toy toy : toysList) {
            if (toy.getId() == 1) {
                toy.setId(id++);
                writeData(toy, false);
                continue;
            }
            toy.setId(id++);
            writeData(toy, true);
        }
    }

    /**
        Получение данных о игрушках из файла
        @return список игрушек
    */
    public static List<Toy> readData() {

        try {
            new File(path_toys_list).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Toy> list = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path_toys_list))) {
            String str;
            while ((str = bf.readLine()) != null) {

                String[] array = str.split(",");

                Toy toy = new Toy(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
                list.add(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
        Добавление вопроса для викторины в файл
        @param question вопрос для викторины
    */
    public static void writeQuestion(Question question) {

        try (FileWriter writer = new FileWriter(path_questions_list, true)) {
            writer.write(question.getId() + ";");
            writer.write(question.getBody() + ";");
            int num = 1;
            for (String str : question.getListAnswer()) {
                writer.write(String.format("%d.%s;", num++, str));
            }
            writer.write(question.getTrueAnswer() + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
        Получение данных о вопросах к викторине из файла
        @return список вопросов
    */
    public static List<Question> getQuestions() {

        try {
            new File(path_questions_list).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Question> list = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path_questions_list))) {
            String str;
            while ((str = bf.readLine()) != null) {

                String[] array = str.split(";");

                Question question = new Question(
                        Integer.parseInt(array[0]), array[1], Integer.parseInt(array[array.length - 1]));

                int num = 1;
                for (String value : array) {
                    if (value.startsWith(num + ".")) {
                        question.getListAnswer().add(value);
                        num++;
                    }
                }

                list.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}



