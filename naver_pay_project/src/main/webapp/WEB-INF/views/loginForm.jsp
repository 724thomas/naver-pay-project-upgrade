<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TItle</title>
</head>
<body>
<form action='/login/login' method="post" onsubmit="return formCheck(this);">
    <c:if test="${not empty param.msg}">
        <label>${URLDecoder.decode(param.msg)}</label>
    </c:if>
    <input type="text" name="id" value="${cookie.id.value}" placeholder = "아이디 입력" autofocus value="asdf">
    <input type="password" name="pwd" placeholder = "비밀번호">
    <button type="submit">로그인</button>
    <label><input type="checkbox" name = "rememberId" ${empty cookie.id.value? "":"checked"}> 아이디 기억</label>
    <Script>
        function formCheck(frm){
            var msg = '';
            if (frm.id.value.length==0){
                setMessage('id를 입력해주세요.', frm.id);
                return false;
            }
            if (frm.pwd.value.length==0){
                setMessage('password를 입력해주세요', frm.pwd);
                return false;
            }
            return true;
        }
    </Script>
</form>
</body>
</html>