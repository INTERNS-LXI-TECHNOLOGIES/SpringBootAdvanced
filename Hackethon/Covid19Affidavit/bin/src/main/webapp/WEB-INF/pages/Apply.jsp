<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apply</title>
</head>
<body>
<div align = "center">
<form:form action="add" method="GET" modelAttribute="affidavitEntity">
        <table style="width:84%;" >
            <form:hidden path="idMa" />
            <tr>
                <td>Name:</td>
                <td><form:input path="nameMa" /></td>
            </tr>
            <tr>
                <td>PhoneNumber:</td>
                <td><form:input path="phoneNumberMa" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="addressMa" /></td>
            </tr>
            <tr>
                <td>Vehicle No:</td>
                <td><form:input path="vehicleNoMa" /></td>
            </tr>
            <tr>
                <td>VehicleType:</td>
                <td><form:input path="vehicleTypeMa" /></td>
            </tr>
            <tr>
                <td>Starting Location:</td>
                <td><form:input path="startingLocationMa" /></td>
            </tr>
             <tr>
                <td>Destination:</td>
                <td><form:input path="destinationMa" /></td>
            </tr>
             <tr>
                <td>Start Date:</td>
                <td><form:input path="startDateMa" /></td>
            </tr>
             <tr>
                <td>End Date:</td>
                <td><form:input path="endDateMa" /></td>
            </tr>
             <tr>
                <td>Co-Passenger Name:</td>
                <td><form:input path="coPassengerNameMa" /></td>
            </tr>
            
             <tr>
                <td>Relation:</td>
                <td><form:input path="relationMa" /></td>
            </tr>
             <tr>
                <td>Reason:</td>
                <td><form:input path="reasonMa" /></td>
            </tr>
        </table>
        <div align="center">
        <button class="button">SAVE</button> <button formaction="admin" class="button">BACK</button>
        </div>
        </form:form>
        </div>
</body>
</html>