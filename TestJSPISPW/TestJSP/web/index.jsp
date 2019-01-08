<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>First JSP Page</title>
</head>

<body>
   <h1>Today's date</h1>
   Date and Time: <%= (new java.util.Date().toString())%>
</body>

</html>