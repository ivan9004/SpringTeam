<html>
    <head>
        <title>Spring 4 Security Example</title>
    </head>
    <body>
      <h3>No autorizado.</h3>
      <form action="<%=request.getContextPath()%>/appLogout" method="POST">
        <input type="submit" value="Logout"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
      </form> 
    </body>
</html> 