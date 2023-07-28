package org.example.model;
import java.util.ArrayList;
import java.util.List;

/**
    @id - уникальный идентификатор вопроса
    @body - тело вопроса (обычный текст)
    @listAnswer - список вариантов ответов
    @trueAnswer - номер правильного ответа
*/
public class Question {

    private int id;

    private String body;

    private final List<String> listAnswer;

    private int trueAnswer;

    public Question(int id, String body, int trueAnswer) {
        this.id = id;
        this.body = body;
        listAnswer = new ArrayList();
        this.trueAnswer = trueAnswer;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public List<String> getListAnswer() {
        return listAnswer;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTrueAnswer(int trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
