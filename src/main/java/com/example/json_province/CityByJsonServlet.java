package com.example.json_province;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CityByJsonServlet")
public class CityByJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        String province = request.getParameter("province");
        PrintWriter out = response.getWriter();
        String citys;
        if("SD".equals(province)){
            citys = "[{cityname:'--请选择-- ',cityvalue:'choose'}," +
                    "{cityname:'青岛 ',cityvalue:'QD'}," +
                    "{cityname:'济南 ',cityvalue:'JN'}," +
                    "{cityname:'烟台 ',cityvalue:'YT'}]";
        } else {
            citys = "[{cityname:'--请选择-- ',cityvalue:'choose'}," +
                    "{cityname:'苏州 ',cityvalue:'SZ'}," +
                    "{cityname:'南通 ',cityvalue:'NT'}]";
        }
        out.println(citys);

        out.flush();
        out.close();

    }

}
