<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <form name="Form1" method="post"
              action="http://localhost:8080/ServletDemo_war_exploded/post-parameters-servlet">
            <table>
                <tr>
                    <td><B>Employee</B></td>
                    <td><input type="text" name="e" size="25" value=""></td>
                </tr>
                <tr>
                    <td><B>Phone</B></td>
                    <td><input type="text" name="e" size="25" value=""></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>