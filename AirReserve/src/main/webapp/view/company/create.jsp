<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container mt-4">
    <h2>Create Company</h2>
    <hr>

    <form action="company/create" method="post">
        <div class="form-group">
            <label for="name">Company Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>

        <div class="form-group">
<%--            <input type="hidden" name="adminId" value="${admin.id}">--%>
        </div>

        <button type="submit" class="btn btn-primary">Create</button>
    </form>

    <a href="company/action=all" class="btn btn-secondary mt-3">Back to Company List</a>
</div>
<jsp:include page="../../includes/footer.jsp"/>

