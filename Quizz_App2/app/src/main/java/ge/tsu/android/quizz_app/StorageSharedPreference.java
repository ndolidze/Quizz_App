package ge.tsu.android.quizz_app;

import android.content.Context;
import android.content.SharedPreferences;

public class StorageSharedPreference implements Storage {

    private static final String Start_Quizz= "start_quizz";
    private static final String Save_In="save_in";

    @Override
    public void saveIn(Context context, String key,int value)
    {
        SharedPreferences sharedPref = getInstanceIn(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    @Override
    public void saveSt(Context context, String key, String value)
    {
        SharedPreferences sharedPref = getInstance(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    @Override
    public int getin(Context context, String key)
    {
        SharedPreferences sharedPref = getInstanceIn(context);
        return sharedPref.getInt(key,0);
    }

    @Override
    public String getSt(Context context, String key )
    {
        SharedPreferences sharedPref = getInstance(context);
        return sharedPref.getString(key, null);
    }


    private SharedPreferences getInstance(Context context)
    {
        SharedPreferences sharedPre = context.getSharedPreferences(Start_Quizz, Context.MODE_PRIVATE);
        return sharedPre;

    }
    private SharedPreferences getInstanceIn(Context context)
    {
        SharedPreferences sharedPre = context.getSharedPreferences(Save_In, Context.MODE_PRIVATE);
        return sharedPre;

    }

}