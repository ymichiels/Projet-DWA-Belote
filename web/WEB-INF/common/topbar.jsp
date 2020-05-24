<%--
  Created by IntelliJ IDEA.
  User: Michiels Yan
  Date: 21/05/2020
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Topbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <button type="button" id="navNewGame" class="btn btn-info">
            <span>Commencer une nouvelle partie</span>
            <i class="fas fa-play"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="nav navbar-nav ml-auto">
                <!-- Nav Item - Alerts -->
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-bell fa-fw fa-2x"></i>
                        <!-- Counter - Alerts -->
                        <span class="badge badge-danger badge-counter">3+</span>
                    </a>
                    <!-- Dropdown - Alerts -->
                    <div class="dropdown-list dropdown-menu dropdown-menu-right shadow" aria-labelledby="alertsDropdown">
                        <h1 class="h4 dropdown-header">
                            Centre de notifications
                        </h1>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="mr-3">
                                <div class="icon-circle bg-warning">
                                    <i class="fas fa-exclamation-triangle text-white"></i>
                                </div>
                            </div>
                            <div>
                                Demande d'invitations de la part de <span class="font-weight-bold" id="player-invite-3">Emmanuelle Macron</span>.
                            </div>
                        </a>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="mr-3">
                                <div class="icon-circle bg-warning">
                                    <i class="fas fa-exclamation-triangle text-white"></i>
                                </div>
                            </div>
                            <div>
                                Demande d'invitations de la part de <span class="font-weight-bold" id="player-invite-2">Emmanuelle Macron</span>.
                            </div>
                        </a>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="mr-3">
                                <div class="icon-circle bg-warning">
                                    <i class="fas fa-exclamation-triangle text-white"></i>
                                </div>
                            </div>
                            <div>
                                Demande d'invitations de la part de <span class="font-weight-bold" id="player-invite-1">Gaio</span>.
                            </div>
                        </a>
                    </div>
                </li>
                <!-- Nav Item - User Information -->
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <span class="">Eric Cariou</span>
                        <i class="fas fa-2x fa-user-circle"></i>
                    </a>
                    <!-- Dropdown - User Information -->
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" id="navEditPlayer" href="/editProfile">
                            <i class="fas fa-cogs fa-sm fa-fw mr-2"></i>
                            Réglages
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                            <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2"></i>
                            Se déconnecter
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- End of Topbar -->
