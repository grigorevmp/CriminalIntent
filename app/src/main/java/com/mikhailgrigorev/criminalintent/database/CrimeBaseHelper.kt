package com.mikhailgrigorev.criminalintent.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.mikhailgrigorev.criminalintent.database.CrimeDbSchema.CrimeTable

class CrimeBaseHelper(context: Context?) :
    SQLiteOpenHelper(
        context,
        DATABASE_NAME,
        null,
        VERSION
    ) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "create table " + CrimeTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    CrimeTable.Cols.UUID + ", " +
                    CrimeTable.Cols.TITLE + ", " +
                    CrimeTable.Cols.DATE + ", " +
                    CrimeTable.Cols.SOLVED +
                    ")"
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
    }

    companion object {
        private const val VERSION = 1
        private const val DATABASE_NAME = "crimeBase.db"
    }
}