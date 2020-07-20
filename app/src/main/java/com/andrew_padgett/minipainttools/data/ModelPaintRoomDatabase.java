package com.andrew_padgett.minipainttools.data;

import android.content.Context;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.andrew_padgett.minipainttools.ModelPaint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ModelPaintEntity.class}, version = 1, exportSchema = false)
public abstract class ModelPaintRoomDatabase extends RoomDatabase {

    public abstract ModelPaintDao modelPaintDao();

    private static volatile ModelPaintRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ModelPaintRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ModelPaintRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ModelPaintRoomDatabase.class, "model_paint_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }


    // test data to populate RecyclerView


    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            databaseWriteExecutor.execute(() -> {
                ModelPaintDao dao = INSTANCE.modelPaintDao();
                dao.deleteAll();

                ModelPaintEntity modelPaintPlaceHolder01 = new ModelPaintEntity( "Flash Gitz Yellow", "Citadel", Color.parseColor("#ffee00"), 0, 0);
                ModelPaintEntity modelPaintPlaceHolder02 = new ModelPaintEntity("Bright Orange", "Vallejo", Color.parseColor("#f26833"),0,0);
                ModelPaintEntity modelPaintPlaceHolder03 = new ModelPaintEntity("Khador Red Base", "P3 Formula", Color.parseColor("#ee2824"),0,0);
                ModelPaintEntity modelPaintPlaceHolder04 = new ModelPaintEntity("Screamer Pink", "Citadel", Color.parseColor("#831740"),0,0);
                ModelPaintEntity modelPaintPlaceHolder05 = new ModelPaintEntity("Hexed Lichen", "Vallejo", Color.parseColor("#34274d"),0,0);
                ModelPaintEntity modelPaintPlaceHolder06 = new ModelPaintEntity("Ironhull Grey", "P3 Formula", Color.parseColor("#8e969b"),0,0);
                ModelPaintEntity modelPaintPlaceHolder07 = new ModelPaintEntity("Macragge Blue", "Citadel", Color.parseColor("#14397a"),0,0);
                ModelPaintEntity modelPaintPlaceHolder08 = new ModelPaintEntity("Sotek Green", "Citadel", Color.parseColor("#056976"),0,0);
                ModelPaintEntity modelPaintPlaceHolder09 = new ModelPaintEntity("Sybarite Green", "Citadel", Color.parseColor("#36a062"),0,0);
                ModelPaintEntity modelPaintPlaceHolder10 = new ModelPaintEntity("Waaagh! Flesh", "Citadel", Color.parseColor("#275627"),0,0);
                ModelPaintEntity modelPaintPlaceHolder11 = new ModelPaintEntity("Screaming Skull", "Citadel", Color.parseColor("#d9d8a6"),0,0);
                ModelPaintEntity modelPaintPlaceHolder12 = new ModelPaintEntity("Tallarn Sand", "Citadel", Color.parseColor("#ab7d00"),0,0);
                ModelPaintEntity modelPaintPlaceHolder13 = new ModelPaintEntity("Bestigor Flesh", "Citadel", Color.parseColor("#D38A57"),0,0);
                ModelPaintEntity modelPaintPlaceHolder14 = new ModelPaintEntity("Skrag Brown", "Citadel", Color.parseColor("#954b00"),0,0);
                ModelPaintEntity modelPaintPlaceHolder15 = new ModelPaintEntity("Rhinox Hide", "Citadel", Color.parseColor("#4e3433"),0,0);
                ModelPaintEntity modelPaintPlaceHolder16 = new ModelPaintEntity("Administratum Grey", "Citadel", Color.parseColor("#9da299"),0,0);
                ModelPaintEntity modelPaintPlaceHolder17 = new ModelPaintEntity("Abaddon Black", "Citadel", Color.parseColor("#010100"),0,0);
                ModelPaintEntity modelPaintPlaceHolder18 = new ModelPaintEntity("Baharroth Blue", "Citadel", Color.parseColor("#58C1CD"),0,0);
                ModelPaintEntity modelPaintPlaceHolder19 = new ModelPaintEntity("Blue Horror", "Citadel", Color.parseColor("#A2BAD2"),0,0);
                ModelPaintEntity modelPaintPlaceHolder20 = new ModelPaintEntity("Dechala Lilac", "Citadel", Color.parseColor("#B69FCC"),0,0);
                dao.insert(modelPaintPlaceHolder01);
                dao.insert(modelPaintPlaceHolder02);
                dao.insert(modelPaintPlaceHolder03);
                dao.insert(modelPaintPlaceHolder04);
                dao.insert(modelPaintPlaceHolder05);
                dao.insert(modelPaintPlaceHolder06);
                dao.insert(modelPaintPlaceHolder07);
                dao.insert(modelPaintPlaceHolder08);
                dao.insert(modelPaintPlaceHolder09);
                dao.insert(modelPaintPlaceHolder10);
                dao.insert(modelPaintPlaceHolder11);
                dao.insert(modelPaintPlaceHolder12);
                dao.insert(modelPaintPlaceHolder13);
                dao.insert(modelPaintPlaceHolder14);
                dao.insert(modelPaintPlaceHolder15);
                dao.insert(modelPaintPlaceHolder16);
                dao.insert(modelPaintPlaceHolder17);
                dao.insert(modelPaintPlaceHolder18);
                dao.insert(modelPaintPlaceHolder19);
                dao.insert(modelPaintPlaceHolder20);
            });
        }
    };

}
