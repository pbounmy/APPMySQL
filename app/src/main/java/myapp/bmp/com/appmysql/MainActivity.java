package myapp.bmp.com.appmysql;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.*;
public class MainActivity extends AppCompatActivity {
      Connection c ;
      private EditText name,surname;
      private TextView tv;
      private Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //c=DB.getConnet();
        tv = (TextView) findViewById(R.id.txtpre);
        name = (EditText) findViewById(R.id.txtname);
        surname = (EditText) findViewById(R.id.txtsurname);
        btnsave = (Button) findViewById(R.id.btnSave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTast().execute("");
                /*try {
                    Toast.makeText(getApplicationContext(),""+c,Toast.LENGTH_SHORT).show();
                    String sql="Insert Into tblog(name,surname) values(?,?)";
                    PreparedStatement pre = c.prepareStatement(sql);
                    pre.setString(1,name.getText().toString());
                    pre.setString(2,surname.getText().toString());
                    int r = pre.executeUpdate();
                    if(r !=0){
                        Toast.makeText(getApplicationContext(),"Save data complete",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Save data complete",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }*/
            }
        });

    }
    private class MyTast extends AsyncTask<String,String,String>{
  String msg="";

        @Override
        protected void onPreExecute() {
           tv.setText("Please wait Inserting data");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                /*Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://192.168.8.104:3306/db1";
                String user="root";
                String pwd="bounmy1234";
                Connection c =DriverManager.getConnection(url,user,pwd);*/
                c =DB.getConnet();
                if(c==null){
                    msg="Connection wrong";

                }else{
                    String sql="Insert Into tblog(name,surname) values(?,?)";
                    PreparedStatement pre = c.prepareStatement(sql);
                    pre.setString(1,name.getText().toString());
                    pre.setString(2,surname.getText().toString());
                    int r = pre.executeUpdate();
                   msg="Insert Data Successful!!!";
                   c.close();
                }

            }catch (Exception e){
                msg="Connectionwrong";
                e.printStackTrace();

            }

            return msg;
        }

        @Override
        protected void onPostExecute(String s) {

           tv.setText(s);
        }
    }
}
