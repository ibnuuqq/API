package com.simple.ibnuqarib.api.Model;


import com.google.gson.annotations.SerializedName;


public class Response{

	@SerializedName("id_category")
	private String idCategory;

	@SerializedName("id_sub_category")
	private String idSubCategory;

	@SerializedName("nama_sub_category")
	private String namaSubCategory;

	@SerializedName("deskripsi")
	private String Deskripsi;

	@SerializedName("nama_category")
	private String namaCategory;


	public static final String id_category  = "ID_CATEGORY";
	public static final  String nama_category = "ID_CATEGORY";
	public static final String id_sub = "ID_CATEGORY";
	public static final String nama_sub = "ID_CATEGORY";
	public static final String deskripsi = "ID_CATEGORY";

	public Response(String id_category, String nama , String id_sub_category , String nama_sub_category, String deskripsi){
		this.idCategory = id_category;
		this.namaCategory = nama ;
		this.idSubCategory = id_sub_category;
		this.namaSubCategory = nama_sub_category;
		this.Deskripsi = deskripsi;
	}

	public void setIdCategory(String idCategory){
		this.idCategory = idCategory;
	}

	public String getIdCategory(){
		return idCategory;
	}

	public void setIdSubCategory(String idSubCategory){
		this.idSubCategory = idSubCategory;
	}

	public String getIdSubCategory(){
		return idSubCategory;
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
		return deskripsi;
	}

	public void setNamaCategory(String namaCategory){
		this.namaCategory = namaCategory;
	}

	public String getNamaCategory(){
		return namaCategory;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"id_category = '" + idCategory + '\'' + 
			",id_sub_category = '" + idSubCategory + '\'' + 
			",nama_sub_category = '" + namaSubCategory + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			",nama_category = '" + namaCategory + '\'' + 
			"}";
		}
}