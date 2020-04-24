<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>
<%int i= 1; %>
<div align="center">
   		 <br>
        <table>
 			<tr>
 			<th>SlNo</th>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Address</th>
            <th>Vehicle No</th>
            <th>Vehicle Type</th>
            <th>Starting Location</th>
            <th>Destination</th>
            <th>Starting Date</th>
            <th>Ending Date</th>
            <th>Co-Passenger Name</th>
            <th>Relation</th>
            <th>Reason</th>
            <th>Approval</th>
            </tr>
 
            <c:forEach var="listAffidavit" items="${listAffidavit}">
                <tr>
					<td><%out.print(i); %></td>	 
                    <td>${listAffidavit.nameMa}</td>
                    <td>${listAffidavit.phoneNumberMa}</td>
                    <td>${listAffidavit.addressMa}</td>
                    <td>${listAffidavit.vehicleNoMa}</td>
                    <td>${listAffidavit.vehicleTypeMa}</td>
                    <td>${listAffidavit.startingLocationMa}</td>
                    <td>${listAffidavit.destinationMa}</td>
                    <td>${listAffidavit.startDateMa}</td>
                    <td>${listAffidavit.endDateMa}</td>
                    <td>${listAffidavit.coPassengerNameMa}</td>
                    <td>${listAffidavit.relationMa}</td>
                    <td>${listAffidavit.reasonMa}</td>
                    <td>${listAffidavit.rejectMa}</td>
                    <td><a href="approveAffidavit?id=${listAffidavit.idMa}">Approve</a></td>
                    <td><a href="cancelAffidavit?id=${listAffidavit.idMa}">Cancel</a></td>
                </tr>
                <%i++; %>
            </c:forEach>
        </table>
        <form >
        <button formaction="admin" class="button">BACK</button>
        <button formaction="logout">LogOut</button>
    	</form>
    </DIV>
</body>
</html>