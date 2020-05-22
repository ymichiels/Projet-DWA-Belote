<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 21/05/2020
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Page Content -->
<div id="content">

    <%@include file="topbar.jsp" %>

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0">Dashboard</h1>
        </div>
        <!-- Content Row -->
        <div class="row">

            <!-- Games Played -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-info h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-played" class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                    Nombre de partie jouée
                                </div>
                                <div class="h5 mb-0 font-weight-bold">14</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-gamepad fa-2x"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Games Win -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-success h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-win" class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                    Nombre de partie gagnée
                                </div>
                                <div class="h5 mb-0 font-weight-bold">8</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-check-circle fa-2x"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Games Lost -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-warning h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-lost" class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                    Nombre de partie perdue
                                </div>
                                <div class="h5 mb-0 font-weight-bold">6</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-times-circle fa-2x"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Average Game Win -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-primary h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-average-win"
                                     class="text-xs font-weight-bold text-primary text-uppercase mb-1">Moyenne de partie
                                    gagnée
                                </div>
                                <div class="h5 mb-0 font-weight-bold">6</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-percentage fa-2x"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Average Game Win -->
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-primary h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-average-score"
                                     class="text-xs font-weight-bold text-primary text-uppercase mb-1">Moyenne de score
                                    par partie
                                </div>
                                <div class="h5 mb-0 font-weight-bold">55</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-percentage fa-2x"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End of Page Content -->
