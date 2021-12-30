<?php

try
{
	//$bd = new PDO("mysql:host=localhost;dbname=growsmart","root","");
	$bd=new PDO('mysql:host=localhost;dbname=growsmart','root', '', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8'));
	//echo "sucess connexion";
}catch (PDOException $e)
{
	echo "Not connected"+$e->getMessage();
	die();
}