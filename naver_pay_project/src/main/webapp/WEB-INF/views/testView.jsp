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
        const httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = () =>{
            if (httpRequest.readyState === XMLHttpRequest.DONE){
                if (httpRequest.status===200) {
                    const result = httpRequest.response;
                    for (var i = 0; i < result.length; i++) {
                        console.log(result[i].userId);
                    }
                }
            } else {
                alert('서버에러');
            }
        };
        httpRequest.open('GET', '/test/test');
        httpRequest.responseType="json";
        httpRequest.send()
    }
</script>


<main>
    <h1>SEARCH</h1>
    <div>Hello! ${uId}</div>
    <div class="container" style="margin:20px;">
        <div class="" style="margin:20px; text-align: right;">
            <input class="" id="q" onkeyup="test();" type="text" size="20">
            <button class="" onclick="test();" type="button">Search</button>
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
