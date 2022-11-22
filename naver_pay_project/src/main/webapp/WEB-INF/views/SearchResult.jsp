<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>

<header>
</header>

<script>
    //testView.jsp
    function test() {
        const httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = () =>{
            if (httpRequest.readyState === XMLHttpRequest.DONE){
                if (httpRequest.status===200) {
                    const result = httpRequest.response;
                    console.log(JSON.stringify(result));
                    var cont="";
                    // for (var i = 0; i < result.length; i++) {
                    //     // console.log(result);
                    //     cont+='<br>'+JSON.stringify(result);
                    //
                    // }
                    var values="";
                    if(result!==null){
                        for (var i=0; i<result.length; i++){

                            // values+="<br>"+Object.values(result[i]);
                            values+="<br>"+result[i]["title"];
                            values+="<br><a href="+result[i]["url"]+">"+result[i]["title"]+"</a>";
                            values+="<br>"+result[i]["description"];
                            values+="<br>";

                        }
                        document.getElementById("ajaxTable").innerHTML=values;
                    }
                }else {
                    alert('서버에러');
                }
            }
        };
        httpRequest.open('POST', '/Searchs');
        httpRequest.responseType="json";
        httpRequest.send()
    }
</script>



<body>
<h1>SEARCH</h1>
<input class="" id="q" name="q" onkeyup="test();" type="text" size="20">
<button onclick="test();" type="button">Search</button>
</body>
<div  id="ajaxTable"></div>
<footer class="main__nav__next">
</footer>
</html>


















<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <h1>검색 : </h1>--%>
<%--    <form name="LoginInfo" method="get" action="/Search">--%>
<%--        <td><input type="text" id="searchKeyword" name="searchKeyword" maxlength="50"></td>--%>
<%--        <input type="submit" value="검색"/>--%>
<%--    </form>--%>
<%--</head>--%>
<%--<body>--%>
<%--<br/>--%>
<%--<h1>${searchKeyword} 에 대한 검색결과.</h1>--%>
<%--<br/>--%>
<%--${test}--%>
<%--<c:forEach items="${theDTOs}" var="dto">--%>
<%--    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--    <p>${dto.url}</p>--%>
<%--    <a href=${dto.url}>${dto.title}</a>--%>
<%--    <p>${dto.description}</p>--%>
<%--    <br/>--%>
<%--    <hr/>--%>
<%--</c:forEach>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
