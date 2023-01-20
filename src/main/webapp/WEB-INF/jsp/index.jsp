<%--
  Created by IntelliJ IDEA.
  User: tsiry
  Date: 11/10/2022
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String content = "views/"+(request.getAttribute("page") != null ? ((String) request.getAttribute("page")) : request.getParameter("page")) + ".jsp";
//    out.println(content);
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Dashboard - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="./../../assets/img/favicon.png" rel="icon">
    <link href="./../../assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="./../../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./../../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="./../../assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="./../../assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="./../../assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="./../../assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="./../../assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="./../../assets/css/style.css" rel="stylesheet">
</head>
<script src="./../../assets/js/jquery-3.6.0.min.js"></script>

<body>

<!-- ======= Header ======= -->
<%@include file="partials/header.jsp"%>
<!-- ======= Header ======= -->

<!-- ======= Sidebar ======= -->
<%@include file="partials/sidebar.jsp"%>
<!-- End Sidebar-->

<!-- #main -->
<jsp:include page="<%= content %>"></jsp:include>
<%--<%@include file="views/insertion_candidat.jsp"%>--%>
<!-- End #main -->

<!-- ======= Footer ======= -->
<%@include file="partials/footer.jsp"%>
<!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<!-- Vendor JS Files -->
<script src="./../../assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="./../../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="./../../assets/vendor/chart.js/chart.min.js"></script>
<script src="./../../assets/vendor/echarts/echarts.min.js"></script>
<script src="./../../assets/vendor/quill/quill.min.js"></script>
<script src="./../../assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="./../../assets/vendor/tinymce/tinymce.min.js"></script>
<script src="./../../assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="./../../assets/js/main.js"></script>

</body>

</html>