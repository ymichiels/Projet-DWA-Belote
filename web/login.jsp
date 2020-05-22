<%--
  Created by IntelliJ IDEA.
  User: Michiels Yan
  Date: 21/05/2020
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Michiels Yan & Cebollado Johann">
        <link rel="icon" href="src/main/medias/img/favicon/favicon.ico">

        <title>Belote - Connexion</title>

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

    <!-- Login  -->
    <body class="bg-gradient-primary">
        <div class="container ">
            <!-- Outer Row -->
            <div class="card o-hidden border-0 shadow-lg">
                <div class="card-body">
                    <!-- Nested Row within Card Body -->
                    <div class="row align-items-center">
                        <div class="col-lg-6 d-none d-lg-block">
                            <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" src="src/main/resources/medias/img/belote.jpg" alt="">
                        </div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 mb-4">Content de vous voir !</h1>
                                </div>
                                <hr>
                                <form class="needs-validation" novalidate>
                                    <div class="form-group mb-3">
                                        <label for="InputPseudo">Pseudo</label>
                                        <input type="pseudo" class="form-control rounded-pill" id="InputPseudo" aria-describedby="pseudoHelp" placeholder="Saisissez votre pseudo..." required autofocus>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="InputPseudo">Mot de passe</label>
                                        <input type="password" class="form-control rounded-pill" id="InputPassword" placeholder="Mot de passe" required>
                                    </div>
                                    <button id="btn_login" class="btn btn-lg btn-primary btn-block rounded-pill" type="submit">Se connecter</button>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="register.html">Créer un nouveau compte !</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <!-- End of Login -->
</html>
