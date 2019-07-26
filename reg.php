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
    $fullname = mysqli_real_escape_string($con, $_POST['fullname']);
    $email = mysqli_real_escape_string($con, $_POST['email']);
    $password = mysqli_real_escape_string($con, $_POST['password']);
    $bloodgroup = mysqli_real_escape_string($con, $_POST['bloodgroup']);
    $phoneno = mysqli_real_escape_string($con, $_POST['phoneno']);
    $city = mysqli_real_escape_string($con, $_POST['city']);


    $sql="INSERT INTO user (fullname,email,password,bloodgroup,phoneno,city) VALUES('$fullname','$email','$password','$bloodgroup','$phoneno','$city')";
    if(mysqli_query($con,$sql)) 
    {   $response;
        $response['error']=false;
        $response['message']="Registered successfully";
    }
    else
    {
        $response['error']=true;
        $response['message']="invalid request";
    }

    echo json_encode($response);
   
   ?>
   