<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Страница для всех сотрудников</title>
</head>
<body>

<h3>Информация для всех</h3>

<security:authorize access="hasAnyRole('ADMIN', 'HR')">
<input type="button" value="Зарплаты" onclick="window.location.href = 'hr_info'">
Только для отдела кадров
</security:authorize>

<br><br>
<security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
<input type="button" value="Производительность" onclick="window.location.href = 'manager_info'">
Только для руководителей
</security:authorize>

</body>
</html>
