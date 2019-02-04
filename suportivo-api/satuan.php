<?php
	

	$id = @$_GET['id_category'];
	require_once 'server.php';
	$query = "SELECT c.id_category,nama_category,id_sub_category,nama_sub_category,deskripsi FROM category c JOIN sub_category WHERE id_category='$id'";
	$sql = mysqli_query($con,$query);
	$ray = array();

	while ($row = @mysqli_fetch_array($sql)) {
		array_push($ray,array(
			
			"id_category" => $row['id_category'],
			"nama_category" => $row['nama_category'],
			"id_sub_category" => $row['id_category'],
			"nama_sub_category" => $row['nama_sub_category'],
			"deskripsi" => $row['deskripsi']

		));
		}
		echo json_encode($ray);

		mysqli_close($con);

?>