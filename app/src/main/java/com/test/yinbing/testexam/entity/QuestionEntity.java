package com.test.yinbing.testexam.entity;

/**
 * Created by yinbing on 16-3-21.
 */
public class QuestionEntity {
    private int _id; //主键 自增 1
    private int que_id;
    private int type;//试题类型1、单选 2、多选
    private String question="";
    private String opt1="";
    private String opt2="";
    private String opt3="";
    private String opt4="";
    private String answer="";

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQue_id() {
        return que_id;
    }

    public void setQue_id(int que_id) {
        this.que_id = que_id;
    }

    public int get_id() {

        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
