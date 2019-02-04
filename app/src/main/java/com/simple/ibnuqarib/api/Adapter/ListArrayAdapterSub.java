package com.simple.ibnuqarib.api.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.simple.ibnuqarib.api.Model.ModelData;
import com.simple.ibnuqarib.api.Model.ModelDataSub;
import com.simple.ibnuqarib.api.R;

import java.util.ArrayList;

public class ListArrayAdapterSub extends ArrayAdapter<ModelDataSub>{

    private ArrayList<ModelDataSub> list2;
    private LayoutInflater inflater;
    private  int res;

    public ListArrayAdapterSub(@NonNull Context context, int resource, ArrayList<ModelDataSub> list2) {
        super(context, resource, list2);
        this.list2 = list2;
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

            holder.NAMASUB = convertView.findViewById(R.id.nama_sub);
            holder.DESK = convertView.findViewById(R.id.deskripsi);


            convertView.setTag(holder);

             }else {
            holder = (MyHolder) convertView.getTag();

        }

        holder.NAMASUB.setText("Nama Sub Category : "+ list2.get(position).getNamaSubCategory());
        holder.DESK.setText("Deskripsi : "+ list2.get(position).getDeskripsi());

        return convertView;
    }
    @Override
    public int getCount() {
        return  list2.size();
    }

    public void remove(ModelDataSub object ) {
super.remove(object);
    }
        public void clear(){
        super.clear();
    }

        public void notifyDataSetChanged(){
        super.notifyDataSetChanged();
        }

        static class  MyHolder{
            TextView NAMASUB;
            TextView DESK;
        }

}
