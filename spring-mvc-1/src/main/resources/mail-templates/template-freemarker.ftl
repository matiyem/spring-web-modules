<#--همانطور که مشاهده می شود، نحو FreeMarker ساده تر است، اما دوباره رشته های محلی را مدیریت نمی کند. بنابراین، این نسخه انگلیسی است:-->
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
    <p>Hi ${recipientName}</p>
    <p>${text}</p>
    <p>Regards,</p>
    <p>
      <em>${senderName} at Baeldung</em> <br />
      <img src="cid:attachment.png" />
    </p>
  </body>
</html>
