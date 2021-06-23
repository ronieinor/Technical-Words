package database;

import android.provider.BaseColumns;

public class User {
    private User() {
    }

    public static final class UserWord implements BaseColumns{

        public static final String TABLE_NAME = "Words";
        public static final String COL_WORD = "Words";
        public static final String COL_DEFINITION = "Definition";
    }
}
