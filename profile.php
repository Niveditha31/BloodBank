<?php

define("db_name","bb");
define("mysql_username","root");
define("mysql_password","");
define("server_name","localhost");

$con=mysqli_connect(server_name,mysql_username,mysql_password,db_name);
   if(mysqli_connect_errno())
   {
	   echo "could not connect to the database".mysqli_connect_error();
	  die(); 
   }
   //$email = mysqli_real_escape_string($con, $_POST['email']);
  $sql="select fullname,email,bloodgroup,phoneno,city from user where email = 'pk@gmail.com'" ;
  $result=$con->query($sql);

  if($row=$result->fetch_assoc())
  {
      $product=array();
      $product["fullname"]=$row["fullname"];
      $product["email"]=$row["email"];
      $product["bloodgroup"]=$row["bloodgroup"];
      $product["phoneno"]=$row["phoneno"];
      $product["city"]=$row["city"];
     
    array_push($response["product"],$product);
  $response["success"]=1;
  echo json_encode($response);
  }
else{
    $response["success"]=0;
    $response["message"]="no person found";
    echo json_encode($response);

}
   ?>