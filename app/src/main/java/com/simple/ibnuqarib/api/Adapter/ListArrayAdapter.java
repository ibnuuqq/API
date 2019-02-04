package com.simple.ibnuqarib.api.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.simple.ibnuqarib.api.Model.ModelData;
import com.simple.ibnuqarib.api.R;

import java.util.ArrayList;

public class ListArrayAdapter extends ArrayAdapter<ModelData>{

    private ArrayList<ModelData> list;
    private LayoutInflater inflater;
    private  int res;

    public ListArrayAdapter(@NonNull Context context, int resource, ArrayList<ModelData> list) {
        super(context, resource, list);
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.res = resource;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MyHolder holder = null;

        if (convertView == null){

            convertView = inflater.inflate(res,parent,false);

            holder = new MyHolder();

            holder.ID = convertView.findViewById(R.id.listID);
            holder.NAMA = convertView.findViewById(R.id.nama_category);
            //holder.NAMASUB = convertView.findViewById(R.id.nama_sub);
            //holder.DESK = convertView.findViewById(R.id.deskripsi);


            convertView.setTag(holder);

             }else {
            holder = (MyHolder) convertView.getTag();

        }

        holder.ID.setText("Id category : "+ list.get(position).getIdCategory());
        holder.NAMA.setText("Nama Category : "+ list.get(position).getNamaCategory());
   //     holder.NAMASUB.setText("Nama Sub : " + list.get(position).getNamaSub());
     //   holder.DESK.setText("Deskripsi : "+ list.get(position).getDeskripsi());
        return convertView;
    }
    @Override
    public int getCount() {
        return  list.size();
    }

    public void remove(ModelData object ) {
super.remove(object);
    }
        public void clear(){
        super.clear();
    }

        public void notifyDataSetChanged(){
        super.notifyDataSetChanged();
        }

        static class  MyHolder{
            TextView ID;
            TextView NAMA;
           // TextView NAMASUB;
            //TextView DESK;
        }

}
