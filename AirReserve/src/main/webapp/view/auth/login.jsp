<jsp:include page="/includes/header.jsp"/>
<jsp:include page="/includes/nav.jsp"/>
<!-- register.jsp -->
<h1 class="text-center" >Login</h1>
<form action="login" method="post" class="container m-auto w-50">
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <button type="submit" class="btn btn-primary">Log In</button>
</form>
<jsp:include page="../../includes/footer.jsp"/>

