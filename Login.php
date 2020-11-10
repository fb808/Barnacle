<?php

    $dbhost = "localhost";
    $dbuser = "barnacle";
    $dbpass = "alth1004^^";
    $dbname = "barnacle";

    $con = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname);
    mysqli_query($con,'SET NAMES utf8');
 
    $UserId = $_POST["UserId"];
    $UserPassword = $_POST["UserPassword"];

    $statement = mysqli_prepare($con, "SELECT UserId FROM UserInfo WHERE UserId = ? AND UserPassword = ?");
    mysqli_stmt_bind_param($statement, "ss", $UserId, $UserPassword);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $UserId);
 
    $response = array();
    $response["success"] = false;
 
    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["UserId"] = $UserId;
        $response["UserPassword"] = $UserPassword;      
    }
 
    echo json_encode($response);
?>