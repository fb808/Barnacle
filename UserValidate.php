<?php

    $dbhost = "localhost";
    $dbuser = "barnacle";
    $dbpass = "alth1004^^";
    $dbname = "barnacle";

    $con = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname);
    mysqli_query($con,'SET NAMES utf8');

    $UserId = $_POST["UserId"];

    $statement = mysqli_prepare($con, "SELECT UserId FROM UserInfo WHERE UserId = ?");

    mysqli_stmt_bind_param($statement, "s", $UserId);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $UserID);

    $response = array();
    $response["success"] = true;

    while(mysqli_stmt_fetch($statement)){
      $response["success"] = false;
      $response["UserID"] = $UserID;
    }

    echo json_encode($response);
?>