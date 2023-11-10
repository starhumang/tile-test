<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation : 메뉴-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">

               <tiles:insertAttribute name="menu"></tiles:insertAttribute>
            </div>
        </nav>
        
        
        
        
        <!-- Header : 헤더-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
               <tiles:insertAttribute name="header"></tiles:insertAttribute>
            </div>
        </header>
        
        
        
        
        
        <!-- Section : 바디-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <!-- 상품목록 -->
                    <tiles:insertAttribute name="body"></tiles:insertAttribute>
                    
                    
                <!-- 상품목록 -->
                </div>
            </div>
        </section>
        
        
        <!-- Footer : 푸터-->
       <tiles:insertAttribute name="footer"></tiles:insertAttribute>
       
       
      
    </body>
</html>
