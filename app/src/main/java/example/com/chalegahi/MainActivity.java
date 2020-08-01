package example.com.chalegahi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView tvload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvload = findViewById(R.id.tv_load);
        DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        Log.d("PATH ", String.valueOf(this.getDatabasePath(db.getDatabaseName())));
        db.addContact(new Contact("Kishan", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " \t,Name: " + cn.getName() + " \t,Phone: " +
                    cn.getPhoneNumber()+"\n";
            // Writing Contacts to log
            tvload.append(log);
//            Log.d("Name: ", log);
        }
    }
}