<%--
  Created by IntelliJ IDEA.
  User: Michiels Yan
  Date: 22/05/2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Michiels Yan & Cebollado Johann">
    <link rel="icon" href="medias/img/favicon.png">

    <title>Belote - Inscription</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">

    <!-- Custom CSS -->
    <style>
        html,
        body {
            height: 100%;
        }

        body {
            display: -ms-flexbox;
            display: -webkit-box;
            display: flex;
            -ms-flex-align: center;
            -ms-flex-pack: center;
            -webkit-box-align: center;
            align-items: center;
            -webkit-box-pack: center;
            justify-content: center;
            padding-top: 40px;
            padding-bottom: 40px;
        }

        .bg-gradient-primary {
            background-color: #007bff;
            background-image: linear-gradient(180deg, #007bff 10%, #224abe 100%);
            background-size: cover;
        }
    </style>
</head>

<!-- Register  -->
<body class="bg-gradient-primary">
<div class="container">
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row align-items-center">
                <div class="col-lg-6 d-none d-lg-block">
                    <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" src="medias/img/belote.jpg" alt="">
                </div>
                <div class="col-lg-6">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 mb-4">Créer un nouveau compte !</h1>
                        </div>
                        <hr>
                        <form class="needs-validation" novalidate>
                            <div class="form-row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <label for="inputCity">Ville</label>
                                    <input type="text" class="form-control rounded-pill" id="inputCity"
                                           placeholder="Ville">
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <label for="selectSexe">Sexe</label>
                                    <select class="custom-select rounded-pill" id="selectSexe">
                                        <option selected disabled value="">Choisissez</option>
                                        <option value="1">Feminin</option>
                                        <option value="2">Masculin</option>
                                    </select>
                                </div>
                                <div class="col-sm-2 mb-3">
                                    <label for="inputAge">Age</label>
                                    <input type="text" class="form-control rounded-pill" id="inputAge" placeholder="Age">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPseudo">Pseudo</label>
                                <input type="text" class="form-control rounded-pill" id="inputPseudo"
                                       placeholder="Pseudo" required>
                                <div class="invalid-feedback">
                                    Veuillez écrire un pseudo valide !
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <label for="inputPassword">Mot de passe</label>
                                    <input type="password" class="form-control rounded-pill" id="inputPassword"
                                           placeholder="Mot de¨passe">
                                    <div class="invalid-feedback">
                                        Veuillez écrire un mot de passe valide !
                                    </div>
                                </div>
                                <div class="col-sm-6 mb-3">
                                    <label for="inputConfirmPassword">Mot de passe</label>
                                    <input type="password" class="form-control rounded-pill" id="inputConfirmPassword"
                                           placeholder="Confirmer le mot de passe">
                                    <div class="invalid-feedback">
                                        Veuillez confirmer votre mot de passe !
                                    </div>
                                </div>
                            </div>
                            <button class="btn btn-primary btn-block rounded-pill" type="submit">S'inscrire</button>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="login">J'ai déja un compte ? Se connecter !</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End of Register -->

<!-- Jquery core JavaScript-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap core JavaScript-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- Custom JavaScript-->
<script src="js/main.js"></script>

</body>
</html>
