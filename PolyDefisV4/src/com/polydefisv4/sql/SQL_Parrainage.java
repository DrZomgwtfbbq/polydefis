package com.polydefisv4.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQL_Parrainage extends SQLiteOpenHelper {

	private static final String TABLE_PARRAINAGE = "U_PARRAINAGE";
	private static final String COL_PARRAIN = "Parrain";
	private static final String COL_FILLEUL = "Filleul";
	private static final String COL_ETAT = "Etat";
 
	private static final String CREATE_BDD = 
			"CREATE TABLE " + TABLE_PARRAINAGE + " (" + 
					COL_PARRAIN + " TEXT PRIMARY KEY, " + 
					COL_FILLEUL + " TEXT PRIMARY KEY, " +
					COL_ETAT + " INTEGER NOT NULL);";
 
	public SQL_Parrainage(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		//on cr�e la table � partir de la requ�te �crite dans la variable CREATE_BDD
		db.execSQL(CREATE_BDD);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//On peut faire ce qu'on veut ici moi j'ai d�cid� de supprimer la table et de la recr�er
		//comme �a lorsque je change la version les id repartent de 0
		db.execSQL("DROP TABLE " + TABLE_PARRAINAGE + ";");
		onCreate(db);
	}
	
	
}
