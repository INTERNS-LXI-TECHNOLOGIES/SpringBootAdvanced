<%@page import = "com.lxisoft.config.*"%>
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<html>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css" integrity="sha384-G0fIWCsCzJIMAVNQPfjH08cyYaUtMwjJwqiRKxxE/rx96Uroj1BtIQ6MLJuheaO9" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link rel="stylesheet" href="Sample.css"></link>
<body>
  <%
  Internationalization international = new Internationalization();
  session.setAttribute("international",international);
  String language = request.getParameter("language");
  if(language == null)
  {
    language = "en";
  }
  session.setAttribute("language",language);
  String exam = international.localization(language,"IN","Exam");
  String english = international.localization(language,"IN","English");
  String malayalam = international.localization(language,"IN","Malayalam");
  String login = international.localization(language,"IN","LogIn");
  String signUp = international.localization(language,"IN","SignUp");
  String username = international.localization(language,"IN","username");
  String password = international.localization(language,"IN","Password");
  String add = international.localization(language,"IN","Add");
  %>
<div class="wrapper">
  <div class="login-text">
    <button class="cta"><i class="fas fa-chevron-down fa-1x"></i></button>
    <div class="text">
      <a href=""><%out.println(login);%></a>
      <hr>
      <br>
      <form method="POST" action="j_security_check">
      <input  type="text" placeholder="<%out.println(username);%>" name="j_username">
      <br>
      <input type="password" placeholder="<%out.println(password);%>" name="j_password">
      <br>
      <button class="login-btn" type="submit"><%out.println(login);%></button>
      <button formaction="Register.jsp" class="signup-btn"><%out.println(signUp);%></button>
    </form>
    </div>
  </div>
  <div class="call-text">
    <h1>Welcome to <span>MOCK</span> <%out.println(exam);%></h1>
    <button><a href = "?language=en"><%out.println(english);%></a></button> <button><a href = "?language=mal"><%out.println(malayalam);%></a></button>
  </div>
</div>
<script type="text/javascript" src="Sample.js"></script>
</body>
</html>