package com.test.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;






    public class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context){
            super(context,"Login.db",null,1);
        }
       private SQLiteDatabase db;
        @Override
        public void onCreate(SQLiteDatabase myDB) {
            myDB.execSQL("create Table users(username Text primary key, password Text)");

            db.execSQL("CREATE TABLE journey (" +
                    "journeyID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "duration BIGINT NOT NULL," +
                    "distance REAL NOT NULL," +
                    "date DATETIME NOT NULL," +
                    "name varchar(256) NOT NULL DEFAULT 'Recorded Journey'," +
                    "rating INTEGER NOT NULL DEFAULT 1," +
                    "comment varchar(256) NOT NULL DEFAULT ''," +
                    "image varchar(256) DEFAULT NULL);");

            db.execSQL("CREATE TABLE location (" +
                    " locationID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    " journeyID INTEGER NOT NULL," +
                    " altitude REAL NOT NULL," +
                    " longitude REAL NOT NULL," +
                    " latitude REAL NOT NULL," +
                    " CONSTRAINT fk1 FOREIGN KEY (journeyID) REFERENCES journey (journeyID) ON DELETE CASCADE);");
        }


        @Override
        public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
            myDB.execSQL("drop Table if exists users");

        }


public Boolean insertData(String username, String password){
        SQLiteDatabase myDB= this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("username", username);
    contentValues.put("password", password);
    long result = myDB.insert("users", null,contentValues);

    if(result== -1){
        return false;

    }
    else {
        return  true;
    }
}
  public  Boolean checkUsername(String username)
  {
      SQLiteDatabase myDB=  this.getWritableDatabase();
      Cursor cursor= myDB.rawQuery("select * from users where username = ?", new String [] {username});

      if(cursor.getCount()>0)
      {
          return true;
      }
      else
      {
          return  false;
      }
  }
  public Boolean checkusernamePassword(String username, String password){
        SQLiteDatabase myDB= this.getWritableDatabase();
      Cursor cursor= myDB.rawQuery("select * from users where username = ? and password = ?", new String [] {username, password});

      if(cursor.getCount()>0)
      {
          return true;
      }
      else
      {
          return  false;
      }


  }




}
