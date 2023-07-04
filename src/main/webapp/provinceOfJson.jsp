<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Title</title>

        <script type="text/javascript">

            var xmlHttp;

            function createXMLHttpRequest() {
                if(window.ActiveXObject){
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                } else if(window.XMLHttpRequest){
                    xmlHttp = new XMLHttpRequest();
                }
            }

            function changeProvince() {
                var province = document.getElementById("province").value;
                createXMLHttpRequest();
                xmlHttp.onreadystatechange = showCity;
                xmlHttp.open("GET", "CityByJsonServlet?province=" + province);
                xmlHttp.send();
            }

            function showCity(){
                var result;
                var citys = document.getElementById("city");
                if(xmlHttp.readyState == 4){
                    if(xmlHttp.status == 200) {
                        result = eval(xmlHttp.responseText);
                        while (citys.options.length > 0) {
                            citys.removeChild(citys.childNodes[0]);
                        }
                        for (var i = 0; i < result.length; i++) {
                            var option = document.createElement("OPTION");
                            option.text = result[i].cityname;
                            option.value = result[i].cityvalue;
                            citys.options.add(option);
                        }
                    }
                }
            }

        </script>

    </head>

    <body>

        省市：<select id = "province" onChange="changeProvince()">
            <option value="">--请选择--</option>
            <option value="SD">山东省</option>
            <option value="JS">江苏省</option>
        </select>
        城市：<select id="city">
            <option value="">--请选择--</option>
        </select>

    </body>
</html>
