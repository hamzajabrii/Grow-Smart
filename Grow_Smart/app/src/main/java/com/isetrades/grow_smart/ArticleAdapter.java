package com.isetrades.grow_smart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Probleme>
{
    private Context context;
    private int resource;

    public ArticleAdapter(Context context, int resource, List<Probleme> problemes)
    {
        super(context, resource, problemes);
        this.context=context;
        this.resource=resource;

    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view=convertView;
        ProblemHolder holder = new ProblemHolder();

        if (view == null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(resource,parent,false);

            holder.imgUser = (ImageView)  view.findViewById(R.id.imgUser);
            holder.tvUserName = (TextView) view.findViewById(R.id.UserName);
            holder.dateTime = (TextView) view.findViewById(R.id.DateTime);
            holder.titreArticle = (TextView) view.findViewById(R.id.txtTitreArticle);
            holder.desArticle = (TextView) view.findViewById(R.id.txtDescriptionArticle);
            holder.nbComments = (TextView) view.findViewById(R.id.txtNbCommentaires);
            //holder.viewMore = (TextView) view.findViewById(R.id.txtViewMore);
            view.setTag(holder);

        }
        else
        {
            holder=(ProblemHolder) view.getTag();
        }
        holder.imgUser.setBackgroundResource(getItem(position).getImgUser());
        holder.tvUserName.setText(getItem(position).getUserName());
        holder.dateTime.setText(getItem(position).getDate());
        holder.titreArticle.setText(getItem(position).getTitreProbleme());
        holder.desArticle.setText(getItem(position).getDesPrombleme());
        holder.nbComments.setText(getItem(position).getNbComments()+" commantaires");

        return view;

    }

    class ProblemHolder
    {
        ImageView imgUser;
        TextView tvUserName;
        TextView dateTime;
        TextView titreArticle;
        TextView desArticle;
        TextView nbComments;
        //TextView viewMore;

    }
}
