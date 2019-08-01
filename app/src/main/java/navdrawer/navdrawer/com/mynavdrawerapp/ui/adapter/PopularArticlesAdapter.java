package navdrawer.navdrawer.com.mynavdrawerapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import navdrawer.navdrawer.com.mynavdrawerapp.R;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.Result;
import navdrawer.navdrawer.com.mynavdrawerapp.ui.activity.DetailsActivity;

public class PopularArticlesAdapter extends RecyclerView.Adapter<PopularArticlesAdapter.PopularArticlesViewHolder> {

    List<Result> articleList;
    Context context;

    public PopularArticlesAdapter(List<Result> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @Override
    public PopularArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_articles, parent, false);
        PopularArticlesViewHolder mh = new PopularArticlesViewHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(PopularArticlesViewHolder holder, int position) {

        holder.tvTitle.setText(articleList.get(position).getTitle());
        holder.tvByline.setText(articleList.get(position).getByline());
        holder.tvPublishedDate.setText(articleList.get(position).getPublishedDate());
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoDetailsPage(articleList.get(position));
            }
        });
        holder.tvByline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoDetailsPage(articleList.get(position));
            }
        });
    }

    private void gotoDetailsPage(Result result) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("title", result.getTitle());
        intent.putExtra("byline", result.getByline());
        intent.putExtra("abstract", result.getAbstract());
        intent.putExtra("publishedon", result.getPublishedDate());
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class PopularArticlesViewHolder extends RecyclerView.ViewHolder  {

        TextView tvTitle, tvByline, tvPublishedDate;

        public PopularArticlesViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvByline = (TextView) v.findViewById(R.id.tvByline);
            tvPublishedDate = (TextView) v.findViewById(R.id.tvPublishedDate);
        }

    }
}
