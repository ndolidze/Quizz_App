package ge.tsu.android.quizz_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private EditText mUsernameResult;
    private EditText mResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mResult=findViewById(R.id.result);
        mUsernameResult=findViewById(R.id.username_result);


        Storage storage=new StorageSharedPreference();
        mUsernameResult.setText(storage.getSt(this, "username"));
        String a=mUsernameResult.getText().toString().trim();
        int c=storage.getin(this, a);
        mResult.setText(""+c);
        storage.saveSt(this, a, a);





    }
      public void tryAgain(View view)
    {
        Intent intent=new Intent(this, QuizzActivity.class);
        startActivity(intent);
    }
    public void logOut(View view)
    {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }


}
