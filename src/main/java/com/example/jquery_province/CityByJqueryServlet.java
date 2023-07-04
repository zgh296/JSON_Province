package com.example.jquery_province;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/CityByJqueryServlet")
public class CityByJqueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        String province = request.getParameter("province"); 
        List<Province> provinces = new ArrayList<Province>();
        
        if("SD".equals(province)) {
            provinces.add(new Province("青岛","QD"));
            provinces.add(new Province("济南","JN"));
            provinces.add(new Province("烟台","YT"));
        }else if("JS".equals(province)) {
            provinces.add(new Province("苏州","SZ"));
            provinces.add(new Province("南通","NT"));
        } else {
            provinces.add(new Province("--请选择--","CHOOSE"));
        }

        Gson gson = new Gson();
        String json = gson.toJson(provinces);
        response.getWriter().println(json);

    }

}
