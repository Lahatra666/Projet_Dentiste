<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="fontawesome-5/css/all.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="assets/style.css">
    <link rel="stylesheet"  href="css/font-awesome.min.css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <title>Ajout employes</title>
    <style>
        .row{
            background-color: whitesmoke;
            width: 800px;
            margin-left: 150px;
            margin-top: 50px;
            border-radius: 12px 10px 12px 12px;
            box-shadow:  0 4px 12px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        }
        h3{
            font-family: 'Dancing Script', cursive;
	        color: black;
            font-size: 2em;
            text-shadow: 1px 3px 2px white
        }
        .form-group input{
            margin-right: 100px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6 col-md-offset-3">
                <div class="form">
                    <h3>Insertion des nouveaux employes</h3>
                    <form class="navbar-form navbar-left" role="search" action="Employer_controller" method="POST">
                        <div class="form-group">
                            <p>Nom :        <input type="text" class="form-control" placeholder="" style="width: 370px;" name="nom"></p>
                            <p>Prénom :     <input type="text" class="form-control" placeholder="" style="width: 370px;" name="prenom"></p>
                            <p>Date de naissance :     <input type="date" class="form-control"  style="width: 370px;" name="date_naissance"></p>
                            <p>Genre
                                <select name="genre">
                                    <option value="1">Masculin</option>
                                    <option value="2">Feminin</option>
                                </select>
                            </p>
                            <p><input type="submit" class="btn btn-primary" value="Ajouter" style="width: 370px;"></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>