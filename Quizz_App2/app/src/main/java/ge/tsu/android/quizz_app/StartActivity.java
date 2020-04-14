package ge.tsu.android.quizz_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    private EditText mUsername;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mUsername=findViewById(R.id.username);
    }

    public void startbutton(View view)
    {
        String username=mUsername.getText().toString().trim();
        if(username.isEmpty())
        {
            Toast.makeText(this, "Please enter credentials", Toast.LENGTH_SHORT).show();
        }
        else
            {
            Storage storage = new StorageSharedPreference();
            String str=storage.getSt(this,username);
            if (str!=null)
            {
                storage.saveSt(this, "username", username);
               Intent intent=new Intent(this, ResultActivity.class);
               startActivity(intent);
            }
            else
                {
                storage.saveSt(this, "username", username);
                Intent intent = new Intent(this, QuizzActivity.class);
                startActivity(intent);
                finish();
                }
            }
    }
}
