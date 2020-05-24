<%--
  Created by IntelliJ IDEA.
  User: Michiels Yan
  Date: 21/05/2020
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->
<nav id="sidebar">
    <div class="sidebar-header">
        <h1>Belote</h1>
    </div>
    <ul class="nav flex-column">
        <li class="nav-item">
            <a class="nav-link active" href="#">
                <i class="fas fa-fw fa-home"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="modal" data-target="#infoModal" href="#infoModal">
                <i id="navStatistics" class="fas fa-fw fa-chart-pie"></i>
                <span>Statistiques</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/infos">
                <i id="navInfos" class="fas fa-fw fa-info-circle"></i>
                <span>Informations</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="https://git.univ-pau.fr/the-vikings/web-avance-projet">
                <i class="fab fa-fw fa-gitlab"></i>
                <span>Gitlab</span>
            </a>
        </li>
    </ul>
</nav>
<!-- End of Sidebar -->
