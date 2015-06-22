<?php

  // array for JSON response
   $response = array();

// check for required fields

if (isset($_POST['name']) && isset($_POST['email']) && isset($_POST['message'])) &&        isset($_POST['time'])) {


$name = $_POST['name'];
$email = $_POST['email'];
$message = $_POST['message']; 
$time = $_POST['time']; 

// include db connect class
require_once __DIR__ . '/blooddbconnect.php';

// connecting to db
$db = new DB_CONNECT();



// mysql inserting a new row
$result = mysql_query("Insert into comments(name,email,message,time) values    ('$name','$email','$message','$time')");

// check if row inserted or not
if ($result) 
  {
    // successfully inserted into database
    $response["success"] = 1;
    $response["message"] = "Message successfully added.";

    // echoing JSON response
    echo json_encode($response);
   } 
   else 
   {
    // failed to insert row
    $response["success"] = 0;
    $response["message"] = mysql_error();  //"Oops! An error occurred."

    // echoing JSON response
    echo json_encode($response);
   }

}
 else
 {
// required field is missing
$response["success"] = 0;
$response["message"] = "Required field(s) is missing";

// echoing JSON response
echo json_encode($response);
}

?>