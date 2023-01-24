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
                    <li><a href="">Services</a></li>
                    <li><a href="Employer_controller">Employés</a></li>
                </ul>
            </nav>
        </header>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <br>
            <form action="Service_controller" method="POST">
            <div class="container">
                <p> Service
                <select name="service">
                <option value="1">Detartrage</option>
                <option value="2">Extraction dentaire</option>
                <option value="3">Nettoyage cavitaire</option>
                <option value="4">Plombage</option>
                <option value="5">Appareillage</option>               
                </select>
            </p>
            <div class="inputs">
            <p> Employer
                <select name="employer">
                    <c:forEach var="user" items="${employer}">
                        <option value="<c:out value="${user.idEmployer}" />"><c:out value="${user.nom}" /></option>            
                    </c:forEach>
                    </select>
              Duree de travail :<input min="0" placeholder="Heure de travaille " type="number" name="demployer"> heure(s)</p>
            </p>
            </div>
                <button class="btn">D'autre employer</button>
            <p></p>
            <div class="inputs1">
            <p> Materiel : <input type="text" placeholder="nom du materiel" name="materiel"> Prix des materiaux : <input type="number" min="0" placeholder="Prix de materiel" name="prixmateriel"> <input type="number" min="0" placeholder="nombre du materiel" name="nombremateriel"></p>
            </div>
                <button class="btn1">D'autre materiaux</button>
            <p> Marge beneficiere(en %) : <input type="number" min="0" max="100" placeholder="Marge beneficiaire" name="marge"></p>
            <p> Nombre : <input type="number" min="0" max="100" placeholder="Nombre" name="nombre"></p>
            <input type="submit" value="Valider">
        </div>
        </form>
            <p></p>
          <a href="AjoutEmployer.jsp" class="btn btn-primary" style="color: white;">Voir les historiques de services</a>
    </div>
          <script>
                let destination = document.querySelector('.inputs');
                let btn = document.querySelector('.btn');
                btn.addEventListener('click',addChamps);
                
                let destination1 = document.querySelector('.inputs1');
                let btn1 = document.querySelector('.btn1');
                btn1.addEventListener('click',addChamps1);
                
                function addChamps(e){
                    e.preventDefault();
                    destination.innerHTML +='<p> Employer:<select name="employer"><c:forEach var="user" items="${employer}"><option value="<c:out value="${user.idEmployer}" />"><c:out value="${user.nom}" /></option></c:forEach></select> Duree de travail : <input min="0" placeholder="duree de travaille " type="number" name="demployer"> heure(s)</p>'
                }
                
                function addChamps1(e){
                    e.preventDefault();
                    destination1.innerHTML +='<p> Materiel : <input type="text" placeholder="nom du materiel" name="materiel"> Prix des materiaux : <input type="number" min="0" placeholder="Prix de materiel" name="prixmateriel"> <input type="number" min="0" placeholder="nombre du materiel" name="nombremateriel"></p>'
                }
                
            </script>
</body>
</html>