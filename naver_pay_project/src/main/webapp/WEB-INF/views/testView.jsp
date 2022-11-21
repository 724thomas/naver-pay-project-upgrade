<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>
<header>
</header>

<script>
        //testView.jsp
    function test() {

        const searchRequest = new XMLHttpRequest();
        searchRequest.open("POST", "/test?q=" + $("#q").val(), true);
        searchRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf8");
        searchRequest.onreadystatechange = () => {
            if(searchRequest.readyState == 4 && searchRequest.status == 200) {
                console.log("gwew", searchRequest.responseText);

                // 검색된 결과를 table 출력 (ajaxTable)
                const table = $("#ajaxTable")[0]; // dom 반환
                table.innerHTML = "";

                let object = JSON.parse(searchRequest.responseText);
                let array=["<ol>"];
                obj["result_list"].forEach(
                    result => array.push("<li>"+result.userId+"</li>")
                //    https://scoring.tistory.com/entry/AJAX%EB%9E%80-JQuery%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-AJAX%EC%82%AC%EC%9A%A9%EB%B2%95
                )
                $("#result").html(object)
                // console.log(object);
                // obj["member_list"].forEach(
                //     member =>  array.push("<li>"+member.id+"</li>")
                //     //JSON에 있는 member.id의 value를 li태그에 넣어서 array에 넣어줌
                // );
                // array.push("</ol>");
                // $("#result").html(array.join(""));

            }
        };
        searchRequest.send(null);
    }
</script>


<main>
    <h1>SEARCH</h1>
    <div>Hello! ${uId}</div>
    <div class="container" style="margin:20px;">
        <div class="" style="margin:20px; text-align: right;">
            <input class="" id="q" onkeyup="test();" type="text" size="20">
            <button class="" onclick="test();" type="button">Search</button>

            <a href="#" id="listButton">회원리스트</a><br/>
            <div id="result">이곳에 회원 목록을 출력하세요</div>
            <c:forEach items="result" var="dto">
                <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <p>${dto.userId}</p>
                <a href=${dto.url}>${dto.userPassword}</a>
                <p>${dto.description}</p>
                <br/>
                <hr/>
            </c:forEach>
        </div>
        <table class="table" style="width: 500px; text-align: center; border: 1px solid #dddddd">
            <thead>
            <tr>
                <th style="width: 250px; padding:5px; background-color: #fafafa; text-align: center;">UID</th>
                <th style="width: 250px; padding:5px; background-color: #fafafa; text-align: center;">EMAIL</th>
            </tr>
            </thead>
            <tbody id="ajaxTable">
            </tbody>
        </table>
    </div>
</main>

<footer class="main__nav__next">
</footer>
</body>
</html>
