<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<html>
<head>
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
.button:hover {background-color: tomato}
.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
.wrapper {
     width: 920px;
     height: 680px;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
   }
 .intro{
 padding-left: 80px;
 font-variant: all-small-caps;
 font-size: x-large;
 }
</style>
</head>
<body>
<div class = "wrapper">
    <div  align="center" style="background-color: tomato;">
      <br>
      <br>
    <h1><font style="font-size:50px;" color="white">INSTRUCTIONS</font></h1>
      <br>
      <br>
      </div>
      <div class = "intro">
        <ul>
        
          <li><h1>  Exam has Total 10 Questions. </h1></li>
          <li><h1>  Each Question has 20 sec when you start exam timer will start. </h1></li>
          <li><h1>  No Negative Marks and each question carry 1.</h1></li>
          <li><h1>  Each Question have four Options.</h1></li>
          <li><h1>  Minimum 6 Right Answers For Pass.</h1></li>      
        </ul>

        <c:>
  <form>
    <input type="submit" formaction="exam?id=1" class="button" name="next" value="NEXT" >
  </form>
</c:>

      </div>
<div style="padding-top: 18px;" align="center">
<form>
<input type="hidden" name = "count" value = "0" >
<button formaction = "startExam" class="button">Start Exam</button> 
</form>
</div>
</div>
</body>
</html>