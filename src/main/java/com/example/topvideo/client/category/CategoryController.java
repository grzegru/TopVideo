package com.example.topvideo.client.category;

import com.example.topvideo.domain.api.CategoryFullInfo;
import com.example.topvideo.domain.api.CategoryService;
import com.example.topvideo.domain.api.DiscoveryBasicInfo;
import com.example.topvideo.domain.api.DiscoveryService;
import com.example.topvideo.domain.discovery.DiscoveryVoteComparator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private final DiscoveryService discoveryService = new DiscoveryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
         CategoryFullInfo category = categoryService.findById(id)
                 .orElseThrow();
         request.setAttribute("category",category);
        List<DiscoveryBasicInfo> discoveries = discoveryService.findByCategory(id);
        discoveries.sort(new DiscoveryVoteComparator());
        request.setAttribute("discoveries",discoveries);
        request.getRequestDispatcher("/WEB-INF/views/category.jsp").forward(request,response);
    }


}
