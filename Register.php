<?php 

    $dbhost = "localhost";
    $dbuser = "barnacle";
    $dbpass = "alth1004^^";
    $dbname = "barnacle";

    $con = mysqli_connect($dbhost, $dbuser, $dbpass, $dbuser);
    mysqli_query($con,'SET NAMES utf8');
    
    $UserId = $_POST["UserId"];
    $UserPassword = $_POST["UserPassword"];
    $UserEmail = $_POST["UserEmail"];
    
    $statement = mysqli_prepare($con, "INSERT INTO UserInfo VALUES (?,?,?)");
    mysqli_stmt_bind_param($statement, "sss", $UserId, $UserPassword, $UserEmail);
    mysqli_stmt_execute($statement);
 
 
    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);
?>