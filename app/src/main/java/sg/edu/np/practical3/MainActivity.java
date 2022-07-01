package sg.edu.np.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle receiving = getIntent().getExtras();
        int randomnumber = 0;
        if (receiving != null) {
            randomnumber = receiving.getInt("random");
        }

        User example = new User("John", "Test", 1, false);

        TextView username = (TextView) findViewById(R.id.textView3);
        username.setText(example.getName() + " " + randomnumber);

        Button followbutton = (Button) findViewById(R.id.button3);
        boolean followed = example.getFollowed();
        if (followed == false) {
            followbutton.setText("Follow");
        }

        else if (followed == true) {
            followbutton.setText("Unfollow");
        }

        String name = example.getName();
        String description = example.getDescription();
        int id = example.getId();
        followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean followed = example.getFollowed();
                if (followed == false) {
                    example.setFollowed(true);
                    followbutton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }

                else if (followed == true) {
                    example.setFollowed(false);
                    followbutton.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button message = findViewById(R.id.button4);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageint = new Intent(view.getContext(), MessageGroup.class);
                view.getContext().startActivity(messageint);
            }
        });
    }
}