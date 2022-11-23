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
                    var values="";
                    for (var i=0; i<result.length; i++){

                        // values+="<br>"+Object.values(result[i]);
                        values+="<br>"+result[i]["title"];
                        values+="<br><a href="+result[i]["url"]+">"+result[i]["title"]+"</a>";
                        values+="<br>"+result[i]["description"];
                        values+="<br>";

                    }
                    document.getElementById("ajaxTable").innerHTML=values;
                }else {
                    alert('서버에러');
                }
            }
        };
        httpRequest.open('GET', '/test/test');
        httpRequest.responseType="json";
        httpRequest.send()
    }
</script>



<body>
<h1>SEARCH</h1>
<input class="" id="q" onkeyup="test();" type="text" size="20">
<button class="" onclick="test();" type="button">Search</button>
</body>
<div  id="ajaxTable"></div>
<footer class="main__nav__next">
</footer>
</html>
