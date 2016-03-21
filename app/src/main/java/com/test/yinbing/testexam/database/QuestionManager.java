package com.test.yinbing.testexam.database;

import android.content.Context;

import com.test.yinbing.testexam.entity.QuestionEntity;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;

import java.util.List;

/**
 * Created by yinbing on 16-3-21.
 */
public class QuestionManager {
    private DatabaseHelper dbHelper;
    private static QuestionManager questionManager;
    private final static String KEY = "yinbing_key";

    private QuestionManager(Context context){
        dbHelper = DatabaseHelper.getInstance(context);
    }

    public QuestionManager getInstance(Context context){
        synchronized (QuestionManager.class){
            if(questionManager == null){
                questionManager = new QuestionManager(context);
            }
        }
        return questionManager;
    }

    public Integer getCount(){
        SQLiteDatabase db = dbHelper.getReadableDatabase(KEY);
        Cursor cursor = null;
        try{
            cursor = db.rawQuery("select count(1) from question ", null);
            if (cursor.moveToNext()) {
                return cursor.getInt(0);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(cursor != null){
                cursor.close();
            }
            db.close();
        }
        return 0;
    }

    public void initQuestions(List<QuestionEntity> questionList){
        String sql = "insert into question(que_id,type,question,opt1,opt2,opt3,opt4,answer) values(?,?,?,?,?,?,?,?)";
        SQLiteDatabase db = dbHelper.getWritableDatabase(KEY);
        SQLiteStatement stat = db.compileStatement(sql);
        db.beginTransaction();
        for(QuestionEntity question : questionList){
            stat.bindLong(1,question.getQue_id());
            stat.bindLong(2,question.getType());
            stat.bindString(3, question.getQuestion());
            stat.bindString(4,question.getOpt1());
            stat.bindString(5,question.getOpt2());
            stat.bindString(6,question.getOpt3());
            stat.bindString(7,question.getOpt4());
            stat.bindString(8,question.getAnswer());
            stat.executeInsert();
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }


}
