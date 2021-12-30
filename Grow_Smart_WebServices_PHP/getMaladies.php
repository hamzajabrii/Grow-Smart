<?php
include "db.php";
$query = $bd->prepare("select * from maladie");
$query->execute();

if($query->rowCount() >0)
{
	$data = $query->fetchAll(PDO::FETCH_ASSOC);
	//var_dump($data);
	//echo $query->rowCount();
	echo json_encode($data);
}
else
{
	$json['success'] = 0;
	$json['message'] = 'no data found';
	$json['myintro'] = '';
	echo json_encode($json);
}