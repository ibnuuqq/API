package com.simple.ibnuqarib.api.Model;

import com.google.gson.annotations.SerializedName;

public class ModelDataSub {

    @SerializedName("nama_sub_category")
    private String namaSubCategory;

    @SerializedName("deskripsi")
    private String Deskripsi;




    public static final String nama_sub = "ID_CATEGORY";
    public static final String deskripsi = "ID_CATEGORY";

    public ModelDataSub( String nama_sub_category, String deskripsi){

        this.namaSubCategory = nama_sub_category;
        this.Deskripsi = deskripsi;
    }




    public void setNamaSubCategory(String namaSubCategory){
        this.namaSubCategory = namaSubCategory;
    }

    public String getNamaSubCategory(){
        return namaSubCategory;
    }

    public void setDeskripsi(String deskripsi){
        this.Deskripsi = deskripsi;
    }

    public String getDeskripsi(){
        return Deskripsi;
    }



   // @Override
    //public String toString(){
      //  return
        //        "Response{" +
          //              "id_category = '" + idCategory + '\'' +
            //            ",id_sub_category = '" + idSubCategory + '\'' +
              //          ",nama_sub_category = '" + namaSubCategory + '\'' +
                //        ",deskripsi = '" + deskripsi + '\'' +
                  //      ",nama_category = '" + namaCategory + '\'' +
                    //    "}";
//    }
}
