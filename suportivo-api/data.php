<?php
// include file koneksi
require 'server.php';
// buat QUery perintah untuk menampilkan semua data
// Secara Descending berdasarkan ID
$sql_get_category = "SELECT c.id_category,nama_category,id_sub_category,nama_sub_category,deskripsi FROM category c JOIN sub_category s USING (id_category) ";
$query = $con->query($sql_get_category);

// Variable penampung array sementara
$response_data = null;

while ($data = $query->fetch_assoc()) {
	// tambahkan data yg di seleksi ke dalam array
	$response_data[] = $data;
}

// Cek apakah datanya null ?
if (is_null($response_data)) {
	// jika ya, buat status untuk response jadi false
	$status = false;
} else {
	// jika tidak, buat status untuk response jadi true
	$status = true;
}


// Set type header response ke Json
header('Content-Type: application/json');
// Bungkus data dalam array
$response = ['status' => $status, 'deskripsi' => $response_data];

// tampilkan dan convert ke format json
echo json_encode($response);
