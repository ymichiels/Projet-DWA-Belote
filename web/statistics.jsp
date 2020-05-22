<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 22/05/2020
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h2 mb-2 text-gray-800">Statistiques</h1>
    <p class="mb-4">Les statistiques du joueur sous forme de graphique</p>


    <!-- Pie Chart -->
    <div class="card mb-3">
        <div class="card-header">
            <h6 class="m-0 font-weight-bold text-primary">Diagramme circulaire</h6>
        </div>
        <div class="card-body">
            <div class="chart-area">
                <canvas id="myPieChart"></canvas>
            </div>
        </div>
        <div class="card-footer">
            <small class="text-muted">Réalisé avec l'outil Chart.js qui permet de faire des images et des diagrammes en
                html5.</small>
        </div>
    </div>

    <!-- Bar Chart -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Diagramme à barres</h6>
        </div>
        <div class="card-body">
            <div class="chart-bar">
                <canvas id="myBarChart"></canvas>
            </div>
        </div>

        <div class="card-footer">
            <small class="text-muted">Réalisé avec l'outil Chart.js qui permet de faire des images et des diagrammes en
                html5.</small>
        </div>
    </div>
    <!-- End of Page Content -->
</div>

