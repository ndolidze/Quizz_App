package ge.tsu.android.quizz_app;

import android.content.Context;
import android.content.SharedPreferences;

public interface Storage  {
    void saveSt(Context context, String key, String value);
    void saveIn(Context context, String key, int value);
    String getSt(Context context, String key);
    int getin(Context context, String key);


}
