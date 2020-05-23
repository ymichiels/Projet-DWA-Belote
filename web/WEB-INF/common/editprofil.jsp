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
        <h1 class="h2 mb-0">Editer le profil</h1>
    </div>

    <!-- Content Row -->
    <div class="row">
        <!-- left column -->
        <div class="col-md-3">
            <div class="text-center">
                <i class="fas fa-user-circle fa-10x"></i>
                <h6>Eric Cariou</h6>
            </div>
        </div>
        <!-- edit form column -->
        <div class="col">
            <h3>Informations Personnelles</h3>
            <form class="needs-validation">
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="InputPseudo">Pseudo:</label>
                        <input class="form-control" id="InputPseudo" type="text" value="Eric Cariou">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="inputAge">Age</label>
                        <input type="text" class="form-control" id="inputAge" placeholder="Age" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="selectSexe">Sexe</label>
                        <select class="custom-select" id="selectSexe" required>
                            <option value="1">Feminin</option>
                            <option selected value="2">Masculin</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="inputCity">Ville</label>
                        <input type="text" class="form-control" id="inputCity" placeholder="Ville" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="inputPassword">Mot de passe</label>
                        <input type="password" class="form-control" id="inputPassword" value="cariou">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6 mb-4">
                        <label for="inputConfirmPassword">Mot de passe</label>
                        <input type="password" class="form-control" id="inputConfirmPassword" value="cariou">
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Sauvegarder</button>
                <button class="btn btn-secondary" type="reset">Annuler</button>
            </form>
        </div>
    </div>
</div>
<!-- End of Main Content -->