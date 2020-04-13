<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Successfully</title>
<style type="text/css">
.button {
  height: 52px;
     width: 186px;
     border: none;
     border-radius: 20px;
     background: linear-gradient(to left, #ab68ca, #de67a3);
     color: #fff;
     font-weight: bolder;
     margin-top: 30px;
     cursor: pointer;
     outline: none;
     font-size: 21px;
}
.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
.wrapper {
     width: 900px;
     height: 600px;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
   }
.deletediv{
    padding-top: 18%;
    font-style: italic;
    font-size: xx-large;
   }
</style>
</head>
<body>
<div class="wrapper">
<div class="deletediv" align="center">
<h1>Question Successfully Deleted</h1>
<form>
<button class="button" formaction="delete">Done</button>
</form>
</div>
</div>
</body>
</html>