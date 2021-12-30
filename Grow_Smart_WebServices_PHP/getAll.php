<?php
include "db.php";
$query = $bd->prepare("select * from agriculteur");
$query->execute();
if($query->rowCount() >0)
{
	$data = $query->fetchAll(PDO::FETCH_ASSOC);
	echo json_encode($data);
	//var_dump($data);
}
else
{
	$json['success'] = 0;
	$json['message'] = 'no data found';
	$json['myintro'] = '';
	echo json_encode($json);
}