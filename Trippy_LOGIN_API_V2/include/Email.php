<!DOCTYPE HTML>
<html>
    <head>
        <title>
            
        </title>
    </head>
    <body>
        <?php
		public function SendEmailRegistration($EmailAdress, $Name)
		{
require 'PHPMailer-master/PHPmailer-master/PHPMailerAutoload.php';

$mail = new PHPMailer;

//$mail->SMTPDebug = 3;                               // Enable verbose debug output

$mail->isSMTP();                                      // Set mailer to use SMTP
$mail->Host = 'smtp.live.com';                        // LET OP DEZE VERANDERD PER EMAIL SERVER!!!
$mail->SMTPAuth = true;                               // Enable SMTP authentication
$mail->Username = 'inf1e@hotmail.com';                 // SMTP username
$mail->Password = 'Wachtwoord1';                           // SMTP password
$mail->SMTPSecure = 'tls';                            // Enable TLS encryption, `ssl` also accepted
$mail->Port = 587;                                    // TCP port to connect to

$mail->From = 'Trippy@live.nl';
$mail->FromName = 'Trippy';
$mail->addAddress($EmailAdress, $Name);               // Name is optional


$mail->WordWrap = 50;                                 // Set word wrap to 50 characters
$mail->isHTML(true);                                  // Set email format to HTML

$mail->Subject = 'Registration account ' . $name . ;
$mail->Body    = 'Thanks for registering at fuckbois /n/r Regards Trippy';
$mail->AltBody = 'No html faggots can read aswell Regards Trippy';

if(!$mail->send()) {
    echo 'Message could not be sent.';
    echo 'Mailer Error: ' . $mail->ErrorInfo;
} else {
    echo 'Message has been sent';
}
}
public function SendEmailPasswordNew($EmailAdress, $Name)
		{
require 'PHPMailer-master/PHPmailer-master/PHPMailerAutoload.php';

$mail = new PHPMailer;

//$mail->SMTPDebug = 3;                               // Enable verbose debug output

$mail->isSMTP();                                      // Set mailer to use SMTP
$mail->Host = 'smtp.live.com';                        // LET OP DEZE VERANDERD PER EMAIL SERVER!!!
$mail->SMTPAuth = true;                               // Enable SMTP authentication
$mail->Username = 'inf1e@hotmail.com';                 // SMTP username
$mail->Password = 'Wachtwoord1';                           // SMTP password
$mail->SMTPSecure = 'tls';                            // Enable TLS encryption, `ssl` also accepted
$mail->Port = 587;                                    // TCP port to connect to

$mail->From = 'Trippy@live.nl';
$mail->FromName = 'Trippy';
$mail->addAddress($EmailAdress, $Name);               // Name is optional


$mail->WordWrap = 50;                                 // Set word wrap to 50 characters
$mail->isHTML(true);                                  // Set email format to HTML

$mail->Subject = 'Password Change ' . $name . ;
$mail->Body    = 'You requested a password change the new password = ****** /n/r Regards Trippy';
$mail->AltBody = 'You requested a password change the new password = ****** /n/r Regards Trippy';

if(!$mail->send()) {
    echo 'Message could not be sent.';
    echo 'Mailer Error: ' . $mail->ErrorInfo;
} else {
    echo 'Message has been sent';
}
}
?>
        
        
    </body>
</html>