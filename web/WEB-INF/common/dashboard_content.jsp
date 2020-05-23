<%--
  Created by IntelliJ IDEA.
  User: Michiels Yan
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
            <h1 class="h2 mb-0">Dashboard</h1>
        </div>

        <!-- Content Row -->
        <div class="row row-cols-1 row-cols-md-2">

            <!-- Games Played -->
            <div class="col mb-4">
                <div class="card border-left-info shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-played" class="text-xs font-weight-bold text-info text-uppercase mb-1">Nombre de partie jouée</div>
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
            <div class="col mb-4">
                <div class="card border-left-success shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-win" class="text-xs font-weight-bold text-success text-uppercase mb-1">Nombre de partie gagnée</div>
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
            <div class="col mb-4">
                <div class="card border-left-warning shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-lost" class="text-xs font-weight-bold text-danger text-uppercase mb-1">Nombre de partie perdue</div>
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
            <div class="col mb-4">
                <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-average-win" class="text-xs font-weight-bold text-primary text-uppercase mb-1">Moyenne de partie gagnée</div>
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
            <div class="col mb-5">
                <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div id="game-average-score" class="text-xs font-weight-bold text-primary text-uppercase mb-1">Moyenne de score par partie</div>
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

        <!-- Games Played -->
        <div class="row">
            <div class="col">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h1 class="h6 m-0 font-weight-bold text-primary">Tableau des joueurs connectés</h1>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Pseudo</th>
                                    <th>Nombre de partie jouée</th>
                                    <th>Partie gagné</th>
                                    <th>Partie perdu</th>
                                    <th>Connecté</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Pseudo</th>
                                    <th>Nombre de partie jouée</th>
                                    <th>Partie gagné</th>
                                    <th>Partie perdu</th>
                                    <th>Connecté</th>
                                </tr>
                                <tfoot>
                                <tbody>
                                <tr>
                                    <td>Eric Cariou</td>
                                    <td>14</td>
                                    <td>8</td>
                                    <td>6</td>
                                    <td>oui</td>
                                </tr>
                                <tr>
                                    <td>Emmanuelle Macron</td>
                                    <td>20</td>
                                    <td>4</td>
                                    <td>16</td>
                                    <td>oui</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End of Page Content -->
