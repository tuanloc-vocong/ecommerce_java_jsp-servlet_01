package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;

@WebServlet(name = "SearchController", value = "/search")
public class SearchController extends HttpServlet {
    ProductDao productDao = new ProductDao();
    CategoryDao categoryDao = new CategoryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Product> productList = productDao.searchProducts(keyword);
        List<Category> categoryList = categoryDao.getAllCategories();

        request.setAttribute("product_list", productList);
        request.setAttribute("category_list", categoryList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
