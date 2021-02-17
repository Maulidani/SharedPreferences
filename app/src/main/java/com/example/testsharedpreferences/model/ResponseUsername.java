package com.example.testsharedpreferences.model;

import com.google.gson.annotations.SerializedName;

public class ResponseUsername{

	@SerializedName("kode")
	private int kode;

	@SerializedName("result_mahasiswa")
	private ResultMahasiswa resultMahasiswa;

	public int getKode(){
		return kode;
	}

	public ResultMahasiswa getResultMahasiswa(){
		return resultMahasiswa;
	}
}