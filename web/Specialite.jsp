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
                    <h3>Insert des specialite</h3>
                    <form class="navbar-form navbar-left" role="search" action="Specialite_controller" method="POST">
                        <div class="form-group">
                        <p>Niveaux:
                                <select name="niveaux" class="form-control">
                                    <option value="1">CEPE</option>
                                    <option value="2">BEPC</option>
                                    <option value="3">BACC</option>
                                    <option value="4">Licence</option>
                                    <option value="5">Master</option>
                                    <option value="6">Doctorat</option>
                                </select>
                            </p>
                            <p>Spécialite : 
                            <p><input type="checkbox" value="1" name="specialite">Détartrage</p>
                            <p><input type="checkbox" value="2" name="specialite">Extraction dentaire</p>
                            <p><input type="checkbox" value="3" name="specialite">Netoyage cavitaire</p>
                            <p><input type="checkbox" value="4" name="specialite">Plombage</p>
                            <p><input type="checkbox" value="5" name="specialite">Appareillage</p>
                            </p>
                            <p>Salaire :    <input type="number" class="form-control" placeholder="Salaire par heure" style="width: 370px;" name="salaire"></p>
                            <p><input type="submit" class="btn btn-primary" value="Ajouter" style="width: 370px;"></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>