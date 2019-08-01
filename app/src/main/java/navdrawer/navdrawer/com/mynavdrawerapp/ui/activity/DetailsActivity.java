package navdrawer.navdrawer.com.mynavdrawerapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import navdrawer.navdrawer.com.mynavdrawerapp.R;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.details_tvTitle)
    TextView details_tvTitle;

    @BindView(R.id.details_tvByline)
    TextView details_tvByline;

    @BindView(R.id.details_tvPublishedDate)
    TextView details_tvPublishedDate;

    @BindView(R.id.details_tvDetails)
    TextView details_tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String title = getIntent().getStringExtra("title");
        String byline = getIntent().getStringExtra("byline");
        String details = getIntent().getStringExtra("abstract");
        String publishedon = getIntent().getStringExtra("publishedon");
        ButterKnife.bind(this);

        setDataToView(title, byline, details, publishedon);

    }

    private void setDataToView(String title, String byline, String details, String publishedon) {
        details_tvTitle.setText(title);
        details_tvByline.setText(byline);
        details_tvPublishedDate.setText(publishedon);
        details_tvDetails.setText(details);
    }
}
