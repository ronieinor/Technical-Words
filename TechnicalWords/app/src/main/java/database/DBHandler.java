package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "TWD.db";
    public static final int DB_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String USER_TABLE = "CREATE TABLE" + User.UserWord.TABLE_NAME+" ( "+
                User.UserWord.COL_WORD+"NULL,"+
                User.UserWord.COL_DEFINITION+"NULL )";

        db.execSQL((USER_TABLE));

    }

    public boolean addWord(String word, String define){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(User.UserWord.COL_WORD, word);
        values.put(User.UserWord.COL_DEFINITION, define);

        long sid = db.insert(User.UserWord.TABLE_NAME, null,values);

        if (sid>0)
            return true;
        else
            return false;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
