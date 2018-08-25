<%-- 
    Document   : index
    Created on : Apr 13, 2018, 3:32:39 AM
    Author     : jamesbond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LuckySevensJSPServlet</title>

        <style>

            body{
                background-image: url("https://c.pxhere.com/photos/b9/ab/dice_gamble_poker_chips_jackpot_win_chance_gambling-659055.jpg!d"); 
                background-attachment: fixed;
                background-size: cover;
                color:white;
                text-shadow: 1px 1px #6aa50b;
                padding-top: 30px;
            }

            div {
                text-align: center;
            }

            .jumbotron {
                opacity: .9;
                background: linear-gradient(#123a00, #3bb200);
                border: 3px solid black;
            }

            .container{
                color: black;
                font-variant: small-caps;
                font-family: "Arial Black", Gadget, sans-serif;
            }

        </style>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>

    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>Roll The Dice!</h1>

                <h3>Rules of the game:</h3>
                <p>If the sum of the 2 dice is equal to 7, you win $4; otherwise, you lose $1</p>

                <form action="LuckySevensJSPServlet" onsubmit="return buttonValidation()">
                    <label for="inputAmount">How much do you want to bet?</label>
                    <input style="margin: 5px; border-radius: 7px;" type="text" id="userInput" name="inputAmount" placeholder="0" required/></br></br>
                    <button class="btn btn-default" name="submitButton">click to roll your dice!</button>
                </form>
            </div>
        </div>

        <script>

            function buttonValidation() {

                var input = document.getElementById("userInput").value;

                if (isNaN(input)) {
                    alert("Enter valid amount");
                    return false;
                } else {
                    return true;
                }
            }

        </script>

        <div class='footer'>
            <div class='row text-center'>
                <h6 style='padding-top: 20px; color:white'>2018 Copyright &copy Matt Beard, Roll The Dice!</h6>
            </div>
        </div>

    </body>

</html>
