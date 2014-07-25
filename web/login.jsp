<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <form name='loginForm.do'
              action="/j_spring_security_check" method='POST'>
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type='text' name='j_username' value=''></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='j_password' /></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit"
                                           value="submit" /></td>
                </tr>
                <tr>
                    <input type="checkbox" name="_spring_security_remember_me" value="Remember"/>
                </tr>
            </table>
        </form>
    </body>
</html>
