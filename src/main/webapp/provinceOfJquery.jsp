<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Title</title>
        <script type="text/javascript" src="js/jquery-3.6.4.min.js"></script>
        <script>

            $(function(){
                $("#province").on("change",function(){
                    var p = $("#province option:selected").val();
                    $.ajax({
                        "url":"CityByJqueryServlet",
                        "type":"get",
                        "data":"province="+p,
                        "dataType":"json",
                        "success":function(json){
                            $("#city>option").remove();
                            for(var i=0;i<json.length;i++){
                                var ch = json[i];
                                $("#city").append("<option value='"+ch.cityvalue+"'>"+ch.cityname+"</option>");
                            }
                        },
                        "error":function(){
                            alert("Error!");
                        }
                    })
                })
            })

        </script>
    </head>

    <body>

      省市：<select id ="province">
          <option value="">--请选择--</option>
          <option value="SD">山东省</option>
          <option value="JS">江苏省</option>
      </select>
      城市：<select id="city">
          <option value="">--请选择--</option>
      </select>

    </body>

</html>