package ge.tsu.android.quizz_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QuizzActivity extends AppCompatActivity {
    public static int a=0;
    public static int b=0;
    public static int c=0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

    }

    Storage storage=new StorageSharedPreference();
    public void firstAnswer(View view)
    {
        if( view.getId()==R.id.answer_nile)
        {
           a++;
        }
        else{
            a=0;
        }

    }
    public void secondAnswer(View view)
    {
        if (view.getId() == R.id.answer_tokyo)
        {
             b++;
        }
        else{
            b=0;
        }

    }
    public void thirdAnswer(View view)
    {

       if(view.getId()== R.id.answer_santiago )
          {
             c++;
          }
       else{
           c=0;
       }

   }
    public void calculateButton(View view)
    {
        String d=storage.getSt(this, "username");
        int  e=a+b+c;
        storage.saveIn(this, d, e);
        a=0;
        b=0;
        c=0;
        Intent intent=new Intent(this, ResultActivity.class );
        startActivity(intent);
        finish();

    }


}
