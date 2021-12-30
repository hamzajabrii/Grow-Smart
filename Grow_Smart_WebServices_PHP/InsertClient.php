<?php
$conn = new mysqli("localhost", "root", "", "growsmart");

//echo "sucess connexion";
if($conn->connect_error)
{
	die("Connection Faild : ".$conn->connect_error);
}

$login = $_GET['login'];
$nom = $_GET['nom'];
$prenom = $_GET['prenom'];
$sexe = $_GET['sexe'];
$email = $_GET['email'];
$motdepasse = $_GET['motdepasse'];
$imgUser = $_GET['imgUser'];
$sql = "INSERT INTO agriculteur(login, nom, prenom, sexe, email, motdepasse, imgUser) values('$login', '$nom', '$prenom', '$sexe', '$email', '$motdepasse',$imgUser)";

//$sql = "INSERT INTO agriculteur(login, nom, prenom, sexe, email, motdepasse, imgUser) values('login', 'nom', 'prenom', 'sexe', 'email', 'motdepasse',imgUser)";

$result = $conn->query($sql);
$resultJson["result"] = $result;

echo json_encode($resultJson);
?>

