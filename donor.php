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
   
    $email = mysqli_real_escape_string($con, $_POST['email']);
    $date = mysqli_real_escape_string($con, $_POST['date']);
    $unit = mysqli_real_escape_string($con, $_POST['unit']);
    


    $sql="INSERT INTO donor (email,date,unit) VALUES('$email','$date','$unit')";
    if(mysqli_query($con,$sql)) 
    {   $response;
        $response['error']=false;
        $response['message']="submitted successfully";
    }
    else
    {
        $response['error']=true;
        $response['message']="invalid request";
    }

    echo json_encode($response);
   
   ?>
   