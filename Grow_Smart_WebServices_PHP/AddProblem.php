<?php
$conn = new mysqli("localhost", "root", "", "growsmart");

//echo "sucess connexion";
if($conn->connect_error)
{
	die("Connection Faild : ".$conn->connect_error);
}

$titre = $_GET['titre'];
$description = $_GET['description'];
$date = $_GET['date'];
$user = $_GET['user'];

$sql = "INSERT INTO article(titreArticle, descriptionArticle, dateArticle, loginuser) values('$titre', '$description', '$date', '$user')";


$result = $conn->query($sql);
$resultJson["result"] = $result;

echo json_encode($resultJson);
?>
