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
           storage.saveIn(this, "1Point", 1);
        }
        else
            {
           storage.saveIn(this, "1Point", 0);
            }
    }
    public void secondAnswer(View view)
    {
        if (view.getId() == R.id.answer_tokyo)
        {
               storage.saveIn(this, "2Point", 1);
        }
        else
            {
               storage.saveIn(this, "2Point", 0);
            }
    }
    public void thirdAnswer(View view)
    {

       if(view.getId()== R.id.answer_santiago )
          {
              storage.saveIn(this, "3Point", 1);
          }
       else
           {
           storage.saveIn(this, "3Point", 0);

           }
   }
    public void calculateButton(View view)
    {
        String d=storage.getSt(this, "username");
        int  a=storage.getin(this, "1Point")+storage.getin(this, "2Point")+storage.getin(this, "3Point");
        storage.saveIn(this, d, a);
        Intent intent=new Intent(this, ResultActivity.class );
        startActivity(intent);
        finish();

    }


}
