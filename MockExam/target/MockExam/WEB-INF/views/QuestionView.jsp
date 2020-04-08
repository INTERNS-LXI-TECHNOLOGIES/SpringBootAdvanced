<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start Exam</title>
</head>
<body bgcolor="FloralWhite">
<div class="container">
<div class="center">
    <div align="center">
        <font size="6" color="midnightblue"><i><b>Welcome To MockExam</b></i></font><br><br><br>
        <form:form action="saveExam" method="post" >
        <c:>
        
        <h1>${examModel.question}</h1>
        </c:>
        
        </form:form>
         <form action="QuestionView">
       <button  class="button" name="done" >DONE</button>
       </form>
    </div>
    </div>
    </div>
</body>
</html>
