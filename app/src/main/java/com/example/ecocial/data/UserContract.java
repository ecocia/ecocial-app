package com.example.ecocial.data;

import android.net.Uri;
import android.provider.BaseColumns;

public final class UserContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private UserContract() {}


    /* Inner class that defines the table contents */
    public static class UserEntry implements BaseColumns {

        // Column names
        public static final String TABLE_NAME = "user_info";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_LOCATION = "location"; // Can be null if user chooses to not give location
        public static final String COLUMN_PASSWORD = "password";

        // Checks if a location is valid. Implement later.
        public boolean isValidLocation() {
            return true;
        }

        /**
         * The "Content authority" is a name for the entire content provider, similar to the
         * relationship between a domain name and its website.  A convenient string to use for the
         * content authority is the package name for the app, which is guaranteed to be unique on the
         * device.
         */
        public static final String CONTENT_AUTHORITY = "com.example.android.pets";

        /**
         * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
         * the content provider.
         */
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

        /**
         * Possible path (appended to base content URI for possible URI's)
         * For instance, content://com.example.android.pets/pets/ is a valid path for
         * looking at pet data. content://com.example.android.pets/staff/ will fail,
         * as the ContentProvider hasn't been given any information on what to do with "staff".
         */
        //public static final String PATH_USERS = "___";

    }


}