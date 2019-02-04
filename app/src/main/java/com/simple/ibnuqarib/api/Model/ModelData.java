package com.simple.ibnuqarib.api.Model;

import com.google.gson.annotations.SerializedName;

public class ModelData {
    @SerializedName("id_category")
    private Integer idCategory;

    @SerializedName("nama_category")
    private String namaCategory;



    public static final String id_category  = "ID_CATEGORY";
    public static final  String nama_category = "ID_CATEGORY";
    //public static final  String nama_sub = "ID_CATEGORY";
    //public static final  String deskripsi = "ID_CATEGORY";

    public ModelData(Integer id_category, String nama){
        this.idCategory = id_category;
        this.namaCategory = nama ;
      //  this.namaSub = namasub;
        //this.Deskripsi = deskripsi;

    }



    public void setIdCategory(Integer idCategory){
        this.idCategory = idCategory;
    }

    public Integer getIdCategory(){
        return idCategory;
    }

    public void setNamaCategory(String namaCategory){
        this.namaCategory = namaCategory;
    }

    public String getNamaCategory(){
        return namaCategory;
    }

    //public void SetNamaSub(String namaSub){
      //  this.namaSub = namaSub;
    //}

    //public String getNamaSub(){
      //  return namaSub;
    //}

    //public void setDeskripsi(String Deskripsi){
      //  this.Deskripsi = Deskripsi;
    //}

    //public String getDeskripsi(){
      //  return Deskripsi;
    //}

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
