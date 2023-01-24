<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="fontawesome-5/css/all.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="assets/employe.css">
    <link rel="stylesheet"  href="css/font-awesome.min.css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <title>Liste des employes</title>
    <style>
        body{
	        font-family: 'Advent Pro', sans-serif;
	        padding: 0;
	        margin: 0;
        }
        #logo {
            font-family: 'Dancing Script', cursive;
            font-weight: bold;
            float: left;
            position: relative;
            top: 15px;
            color: white;
            font-size: 20px;
            margin-left: 15px;
        }
        a{
	        text-decoration: none;
	        color: white;
        }

        header li{
            float: right;
            font-size: 1.4em;
        }

        header li a {
            text-decoration: none;
            display: block;
            text-align: center;
            padding: 18px/*haut bas*/ 16px/* gauche droite*/;
        }
        header nav{
            overflow: hidden;
            background-color: #0388c3;
            width: 100%;
            opacity: 0.9;
            padding: 0;
        }
        .container-fluid{
            font-family: Arial, Helvetica, sans-serif;
        }

        .container-fluid a{
            color: blue;
        }
    </style>
</head>
<body>
    <div class="row">
        <header>
            <nav>
                <ul>
                    <li id="logo">DentistCity</li>
                    <li><a href="">Déconnexion</a></li>
                    <li><a href="">Statistiques</a></li>
                    <li><a href="">Bénéfices et Charges</a></li>
                    <li><a href="">Client</a></li>
                    <li><a href="">Rendez-Vous</a></li>
                    <li><a href="Service_controller">Services</a></li>
                    <li><a href="Employer_controller">Employés</a></li>
                </ul>
            </nav>
        </header>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <table class="table">
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Date de naissance</th>
                        <th>Salaire par heure</th>
                        <th>Niveau</th>
                        <th>Action</th>
                        <th>Ajouter spécialité</th>
                    </tr>
	<c:forEach var="user" items="${employer}">
            <tr>
		<td><c:out value="${user.nom}" /></td>
                <td><c:out value="${user.prenom}" /></td>
                <td><c:out value="${user.date_naissance}" /></td>
                <td><c:out value="${user.salaire}" /></td>
                <td><c:out value="${user.nomniveaux}" /></td>
                <td><a href="">Modifier</a></td>
                <td><a href="">Ajouter Spécialité</a></td>
            </tr>
	</c:forEach>
            </table>
          </div>
          <a href="AjoutEmployer.jsp" class="btn btn-primary" style="color: white;">Ajouter des nouveaux employes</a>
    </div>
</body>
</html>