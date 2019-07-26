<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "bb";


$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error)
 {
   die("Connection failed: " . $conn->connect_error);
} 

$email = $_POST['email'];
$password = $_POST['password'];


$sql="SELECT * FROM user WHERE email = '$email' AND password='$password'";

  
$result = $conn->query($sql);


if ($result->num_rows > 0) 
{
   while($row = $result->fetch_assoc()) 
   {
     
    $response["email"] = $row["email"];
    $response["message"] ="success";

   } 
   echo json_encode($response);
}
else 
{
   $response["message"] = "No person found";
   echo json_encode($response);
}
?>