<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="fontawesome-5/css/all.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="assets/index.css">
    <link rel="stylesheet"  href="css/font-awesome.min.css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <title>Page de Connexion</title>
    <style>
        h3{
            font-family: 'Dancing Script', cursive;
	        color: black;
            font-size: 2em;
            text-shadow: 1px 3px 2px white
        }
        img{
            border-radius: 20px 0px 0px 20px;
            box-shadow: 0 0 10px #333;
        }
    </style>
</head>
<body>
    <div class="containt">
        <div class="row">
            <div>
                <div class="col-md-offset-1 col-md-5 col-md-offset-5">
                    <img src="css/back.jpg" alt="">
                </div>
                <div class="col-md-offset-6 col-md-5 col-md-offset-1">
                    <div class="form">
                        <h3>Bienvenue à DentistCity</h3>
                        <form class="navbar-form navbar-left" role="search" action="" method="post">
                            <div class="form-group">
                            <p><input type="email" class="form-control"  placeholder="Entrer votre Email" style="width: 370px;" name=""></p>
                            <p><input type="password" class="form-control" value="admin" placeholder="Entrer votre mot de passe "  style="width: 370px;" name=""></p>
                            <p><input type="submit" class="btn btn-primary" value="Se Connecter"></p>
                            </div>
                        <div id="row">
                            <p><a href="Creation.html">Creer un compte</a></p>
                            <p><a href="connexionAdmin.jsp">Se connecter en tant qu'Admin</a></p>
                        </div>
                        </form>
                    </div>
            </div>
            </div>
        </div>
    </div>
</body>
</html>