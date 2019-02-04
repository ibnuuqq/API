<?php
	require_once 'server.php';

	$query = "SELECT * FROM category";
	$sql = mysqli_query($con,$query);
	$ray = array();

	while ($row = mysqli_fetch_array($sql)) {
		array_push($ray,array(
			"id_category" => $row['id_category'],
			"nama_category" => $row['nama_category']
			
		));
		}
		echo json_encode($ray);

		mysqli_close($con);

?>