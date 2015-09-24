package com.mcqs.anita.mcqs_android_version1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by david-MCQS on 22/09/2015.
 */
public class ListViewAdapter extends BaseAdapter {


    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Exam> worldpopulationlist = null;

    private ArrayList<Exam> arraylist;

    public ListViewAdapter(Context context,
                           List<Exam> worldpopulationlist) {
        mContext = context;
        this.worldpopulationlist = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Exam>();
        this.arraylist.addAll(worldpopulationlist);

    }

    public class ViewHolder {

        TextView name;

    }

    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }

    @Override
    public Exam getItem(int position) {
        return worldpopulationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, final ViewGroup parent) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_item, null);

            holder.name = (TextView)view.findViewById(R.id.product_name);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(worldpopulationlist.get(position).getName());

        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                // Send single item click data to DownloadExam Class
              Intent intent = new Intent(mContext, DownloadExam.class);
                // Pass all data rank
                intent.putExtra("name",
                        (worldpopulationlist.get(position).getName()));
                // Pass all data country
                intent.putExtra("id",
                        (worldpopulationlist.get(position).getId()));
                intent.putExtra("description", worldpopulationlist.get(position).getDescription());



                // Start DownloadExam Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        } else {
            for (Exam wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
