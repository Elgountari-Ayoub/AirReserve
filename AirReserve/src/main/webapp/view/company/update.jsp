<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container mt-4">
    <h2>Update Company</h2>
    <hr>

    <form action="company/action=update" method="post">
        <input type="hidden" name="id" value="${company.id}">
        <div class="form-group">
            <label for="name">Company Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${company.name}">
        </div>

        <div class="form-group">
            <label for="admin">Admin</label>
            <select name="admin" class="form-control" id="admin">
                <c:forEach items="${admins}" var="admin">
                    <option value="${admin.id}" ${admin.id == company.admin.id ? 'selected' : ''}>${admin.username}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form>

    <a href="company/action=all" class="btn btn-secondary mt-3">Back to Company List</a>
</div>
<jsp:include page="../../includes/footer.jsp"/>

