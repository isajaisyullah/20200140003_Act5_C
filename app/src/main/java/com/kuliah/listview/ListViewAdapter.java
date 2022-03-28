package com.kuliah.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //Deklarasi variabel dengan jenis data context
    Context mContext;

    //Deklarasi variabel dengan jenis data layout inflater
    LayoutInflater inflater;

    //Deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arraylist;

    //Membuat konstruktor listviewadapter
    public ListViewAdapter(Context context){
        //Memberi nilai mContext dengan context
        mContext = context;

        //Mengatur layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //Memberi nilai arraylist dari class ClassNama
        this.arraylist = new ArrayList<ClassNama>();

        //Menambahkan semua elemen ke arraylist
        this.arraylist.addAll(Home_Activity.classNamaArrayList);
    }

    //Membuat class untuk mendeklarasika tempat untuk meletakkan isi kedalam listview
    public class ViewHolder{
        //Mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }

    //Fungsi getCount() mengembalikan jumlah item yang akan ditampilkan dalam list
    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return Home_Activity.classNamaArrayList.size();
    }

    //Fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    // tertentu dalam kumpulan data untuk mendapatkan data yang sesuai dari lokasi
    // tertentu dalam pengumpulan item
    @Override
    public Object getItem(int i) {
        //mengembalikan nilai berupa objek dari array data
        return Home_Activity.classNamaArrayList.get(i);
    }

    //Fungsi mengembalikan "nilai" dari posisi item ke adaptor.
    @Override
    public long getItemId(int i) {
        return i;
    }

    //Fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk
    //ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel dengan jenis data  ViewHolder
        final  ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if ( view == null){

            //membuat objek view holder
            holder = new ViewHolder();

            //Mengatur Layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);
        }
        else {
            //mengatur holder untuk mengembalikan nilai dari view tag.
            holder = (ViewHolder) view.getTag();
        }
        //Set item keTextViews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

        //Mengembalikan nilai ke variabel view
        return view;
    }


}
