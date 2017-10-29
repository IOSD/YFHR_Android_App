package tech.iosd.yfhr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    String str1 = "\n\t\t Youth for Human Rights International (YHRI) is a Los Angeles based nonprofit organization founded in 2001 by Dr. Mary Shuttleworth, an educator born and raised in apartheid South Africa, where she witnessed firsthand the devastating effects of discrimination and the lack of basic human rights.";
    String str2 = "\n\t\t The purpose of YHRI is to teach youth about human rights, specifically the United Nations Universal Declaration of Human Rights, and inspire them to become advocates for tolerance and peace. YHRI has now grown into a global movement, including hundreds of groups, clubs and chapters around the world.";
    String str3 = "\n\t\t Youth for Human Rights International teaches human rights education both in the classroom and in nontraditional educational settings. We aim to reach people from diverse backgrounds, with materials which often appeal across generations. By teaching human rights through all means—from conferences and workshops to hip-hop and dancing—this message has spread around the world.";
    String str4 = "\n\t\t Our materials include the UNITED music video—a street-savvy, multiethnic, anti-bullying message that has captured the imagination of people around the world. Our 30 short public service message videos depict the 30 Articles of the United Nations Universal Declaration of Human Rights. In less than a minute, youth can learn one of their human rights—and all of them in less than half an hour. The videos have garnered media attention as well, airing on television networks in countries worldwide. But it doesn’t end there. The videos are now airing during halftime on stadium screens, within taxicabs, on supermarket screens, in theaters, railway stations, and many other locations. Click to watch >>";
    String str5 = "http://www.youthforhumanrights.org/what-are-human-rights/videos/born-free-and-equal.html";
    String str6 = "\n\t\t We have inspired people to walk, race racecars, paint murals and hold small gatherings with youth groups and orphanages, as well as large open-air concerts.";
    String str7 = "\n\t\t Our human rights videos and curricula fill the schoolrooms and halls of learning with the simple messages of what our human rights are.";
    String str8 = "\n\t\t We realize the importance of collaborating with like-minded individuals and groups to expand our horizons and learn from them their hard-earned lessons, and so expand and reach youth on all continents.";

    TextView tvText1,tvText2,tvText3,tvText4,tvText5,tvText6,tvText7,tvText8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tvText1 = findViewById(R.id.tvText1);
        tvText1.setText(str1);

        tvText2 = findViewById(R.id.tvText2);
        tvText2.setText(str2);

        tvText3 = findViewById(R.id.tvText3);
        tvText3.setText(str3);

        tvText4 = findViewById(R.id.tvText4);
        tvText4.setText(str4);

        tvText5 = findViewById(R.id.tvText5);
        tvText5.setText(str5);
        tvText5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                String url = "http://www.youthforhumanrights.org/what-are-human-rights/videos/born-free-and-equal.html";
                browserIntent.setData(Uri.parse(url));
                startActivity(browserIntent);
            }
        });

        tvText6 = findViewById(R.id.tvText6);
        tvText6.setText(str6);

        tvText7 = findViewById(R.id.tvText7);
        tvText7.setText(str7);

        tvText8 = findViewById(R.id.tvText8);
        tvText8.setText(str8);
    }
}
