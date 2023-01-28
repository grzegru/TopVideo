package com.example.topvideo.client.home;

import com.example.topvideo.domain.api.CategoryName;
import com.example.topvideo.domain.api.CategoryService;
import com.example.topvideo.domain.api.DiscoveryBasicInfo;
import com.example.topvideo.domain.api.DiscoveryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private DiscoveryService discoveryService = new DiscoveryService();
    private CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DiscoveryBasicInfo> discoveries = discoveryService.findAll();
        List<CategoryName> categories = categoryService.findAllCategoryNames();
        request.setAttribute("discoveries", discoveries);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

}
