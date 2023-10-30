

<nav class="navbar navbar-expand-lg navbar-dark bg-primary text-white">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">AirReserve</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/flight?action=all">Flights</a>
                </li>
                <%-- if you are an admin--%>
                <li class="nav-item">
                    <a class="nav-link" href="/company">Companies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact">Contact us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about">About</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto"> <!-- ml-auto pushes these to the right -->
                <li class="nav-item">
                    <a class="nav-link btn-primary" href="/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
