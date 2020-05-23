<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Some Random Jsp</title>
</head>
<body>
<h1>Are you ok ? I'm not</h1>
<h2>Got your IP by the way:  <% out.println(request.getRemoteAddr()); %></h2>
You're id is <% out.println(request.getSession().getId()); %>
</body>
</html>
