<%--
  Created by IntelliJ IDEA.
  User: Michiels Yan
  Date: 22/05/2020
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h2 mb-2">Création de la partie</h1>
    <p class="mb-4">La partie se compose de 4 joueurs max. Et pour jouer avec un ami celui-ci doit être connecté
        obligatoirement.</p>

    <!-- Player selection-->
    <h1 class="h4 mb-2">Sélection des joueurs</h1>

    <div class="card-deck mb-4">
        <!-- Team 1 -->
        <div class="card">
            <div class="card-header">Équipe 1</div>
            <div class="card-body">
                <h5 class="card-title">Sélection des joueurs de l'équipe:</h5>
                <label for="selectPlayerTeam1">Joueur</label>
                <select class="selectpicker" id="selectPlayerTeam1" multiple data-max-options="2"
                        data-live-search="true">
                    <option>Test1</option>
                    <option>Test2</option>
                    <option>Test3</option>
                </select>
            </div>
        </div>
        <!-- Team 2 -->
        <div class="card">
            <div class="card-header">Équipe 2</div>
            <div class="card-body">
                <h5 class="card-title">Sélection des joueurs de l'équipe:</h5>
                <div class="form-group">
                    <label for="selectPlayerTeam2">Joueur</label>
                    <select class="selectpicker" id="selectPlayerTeam2" multiple data-max-options="2"
                            data-live-search="true">
                        <option>Test1</option>
                        <option>Test2</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <button type="button" id="start-play" class="btn btn-lg btn-success btn-block">
        <span>Lancer la partie</span>
    </button>
    <!-- End of Page Content -->
</div>

