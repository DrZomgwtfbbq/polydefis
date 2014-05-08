package com.polydefisv4.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQL_Connexion extends SQLiteOpenHelper {

	private static final String TABLE_CONNEXION = "U_CONNEXION";
	private static final String COL_IDENTIFIANT = "Identifiant";
	private static final String COL_MOTDEPASSE = "Motdepasse";
 
	private static final String CREATE_BDD = 
			"CREATE TABLE " + TABLE_CONNEXION + " (" + 
					COL_IDENTIFIANT + " TEXT PRIMARY KEY, " + 
					COL_MOTDEPASSE + " TEXT NOT NULL);";
 
	public SQL_Connexion(Context context, String name, CursorFactory factory, int version) {
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
		db.execSQL("DROP TABLE " + TABLE_CONNEXION + ";");
		onCreate(db);
	}
	
}
