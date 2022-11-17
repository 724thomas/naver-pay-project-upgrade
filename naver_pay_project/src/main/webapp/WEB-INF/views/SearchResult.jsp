<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>검색 : </h1>
    <form name="LoginInfo" method="get" action="/Search">
        <td><input type="text" id="searchKeyword" name="searchKeyword" maxlength="50"></td>
        <input type="submit" value="검색"/>
    </form>
</head>
<body>
<br/>
<h1>${searchKeyword} 에 대한 검색결과.</h1>
<br/>
${test}
<c:forEach items="${theDTOs}" var="dto">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <p>${dto.url}</p>
    <a href=${dto.url}>${dto.title}</a>
    <p>${dto.description}</p>
    <br/>
    <hr/>
</c:forEach>
</form>
</body>
</html>
