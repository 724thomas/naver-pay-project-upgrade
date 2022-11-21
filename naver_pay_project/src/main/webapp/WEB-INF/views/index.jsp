<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="loginOutLink" value = "${sessionScope.id==null ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value = "${sessionScope.id==null ? 'Login' : 'Logout'}"/>

<html>
  <head>
    <title>Main</title>
  </head>
  <body>
    <h1>메인 화면 입니다.</h1>
    <button type="button" onclick="location.href='${loginOutLink}'">${loginOut}</button>
    <%if (session.getAttribute("id") == null){%>
<%--      <li><a> href="<c:url value = '${loginOutLink}'/>">${loginOut}</a></li>--%>
      <button type="button" onclick="location.href='login/login'">로그인</button>
      <button type="button" onclick="location.href='SignUp'">회원가입</button>
      <button type="button" onclick="location.href='crawling'">크롤링</button>
      <button type="button" onclick="location.href='test'">테스트</button>
    <%}else{%>
      <button type="button" onclick="location.href='shopping/getShoppingList'">주문 목록 확인하기</button>
      <button type="button" onclick="location.href='logout'">로그아웃</button>
    <%}%>
    <form name="LoginInfo" method="get" action="/Search">
      <td><input type="text" id="searchKeyword" name="searchKeyword" maxlength="50"></td>
      <input type="submit" value="keyword"/>
    </form>



  </body>
</html>
