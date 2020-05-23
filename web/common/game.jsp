<%--
  Created by IntelliJ IDEA.
  User: Michiels Yan
  Date: 23/05/2020
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h2 mb-0">Jeux</h1>
    </div>

    <!-- Content -->
    <!-- Player North -->
    <div class="row justify-content-center">
        <div class="col-3 mb-4">
            <div class="card">
                <div class="card-header">Joueur 1</div>
                <div class="card-body">
                    <h5 class="card-title">Jeux</h5>
                    <label for="selectPlayPlayer1">Carte à jouer</label>
                    <select class="selectpicker" id="selectPlayPlayer1" multiple data-max-options="1" data-live-search="true">
                        <option>Valley</option>
                        <option>Roi</option>
                        <option>Dame</option>
                    </select>
                </div>
            </div>
        </div>
    </div>

    <div class="row justify-content-between">
        <!-- Player Ouest -->
        <div class="col-3">
            <div class="card">
                <div class="card-header">Joueur 2</div>
                <div class="card-body">
                    <h5 class="card-title">Jeux</h5>
                    <p class="card-text">Carte posée</p>
                </div>
            </div>
        </div>
        <!-- Canvas -->
        <div class="col-6 mb-4 text-center">
            <canvas id="canvas"></canvas>
        </div>
        <!-- Player Est -->
        <div class="col-3">
            <div class="card">
                <div class="card-header">Joueur 3</div>
                <div class="card-body">
                    <h5 class="card-title">Jeux</h5>
                    <p class="card-text">Carte posée</p>
                </div>
            </div>
        </div>
    </div>
    <!-- Player South -->
    <div class="row justify-content-center">
        <div class="col-3">
            <div class="card">
                <div class="card-header">Joueur 4</div>
                <div class="card-body">
                    <h5 class="card-title">Jeux</h5>
                    <p class="card-text">Carte posée</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End of Main Content -->