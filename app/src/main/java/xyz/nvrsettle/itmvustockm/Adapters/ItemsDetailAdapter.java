package xyz.nvrsettle.itmvustockm.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import xyz.nvrsettle.itmvustockm.Classes.ItemModel;
import xyz.nvrsettle.itmvustockm.R;


/**
 * Created by saiso on 03-02-2017.
 */
public class ItemsDetailAdapter extends ArrayAdapter<ItemModel> {

    private static final String TAG = "ImageAdapter";

    private final Activity activity;
    List<ItemModel> offerlist = new ArrayList<ItemModel>();
    public ViewHolder holder;
    public ItemsDetailAdapter(Activity activity,
                              List<ItemModel> offerlist) {
        super(activity, R.layout.listview_item, offerlist);
        this.activity = activity;
        this.offerlist = offerlist;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.listview_item, null, true);
            holder = new ViewHolder();
            holder.nameTextView = (TextView) view.findViewById(R.id.tx_name);
            holder.despTextView = (TextView) view.findViewById(R.id.tx_desp);
            holder.stockTextView = (TextView) view.findViewById(R.id.tx_stock);
            holder.priceTextView = (TextView) view.findViewById(R.id.tx_price);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.nameTextView.setText( "Name : " + offerlist.get(position).getNameOfTheItem());
        holder.despTextView.setText("Description : "+offerlist.get(position).getDescriptionOfTheItem());
        holder.stockTextView.setText("Stock in Hand "+ offerlist.get(position).getStockWithUs()+ " ");
        holder.priceTextView.setText(" Price of One Item : "+ "\u20B9 "+offerlist.get(position).getPrice()+ "/-");

        return view;
    }

    static class ViewHolder {
        TextView nameTextView;
        TextView despTextView;
        TextView stockTextView;
        TextView priceTextView;
    }

}
