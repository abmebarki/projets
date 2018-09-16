<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/head.jsp"%>
</head>

<body>
<h2><s:text name="home.welcome" /></h2>

<nav>
    <s:a action="site_list">
        <s:text name="nav.listSite" />
    </s:a>
    <br/>
    <s:a action="topo_list">
        <s:text name="nav.listTopo" />
    </s:a>
</nav>
</body>
</html>