<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Nazjara">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Information</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    User Details
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="userRegisterForm" cssClass="form-horizontal" modelAttribute="user" method="post" action="saveUser">

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="name" >Enter name(2-20 characters, which can be alphanumeric characters, the first character necessarily letter):</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="id" value="${userObject.id}"/>
                            <form:input cssClass="form-control" path="name" value="${userObject.name}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="age" cssClass="control-label col-xs-3">Enter age(6-100):</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="age" value="${userObject.age}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="isAdmin" cssClass="control-label col-xs-3">Is this user Administrator?(1 - yes; 0 - no)</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="isAdmin" value="${userObject.isAdmin}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="saveUser" class="btn btn-primary" value="Save" onclick="return submitUserForm();"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>
    
                </form:form>
            </div>
        </div>
    </div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		function submitUserForm() {

		    var name = $('#name').val().trim();
		    var age = $('#age').val().trim();
		    var isAdmin = $('#isAdmin').val().trim();
            var regForUserName = new RegExp(/^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$/);
            var regForAge = new RegExp(/^(?:1(?:00?|\d)|[2-5]\d|[6-9]\d?)$/);
		    if(!regForUserName.test(name)) {
		        alert('Please enter proper name');
		        $('#name').focus();
		        return false;
		    }
		    if(!regForAge.test(age)) {
		        alert('Please enter proper age');
		        $('#age').focus();
		        return false;
		    }
            if(!/^[01]$/.test(isAdmin) && !/^true$/.test(isAdmin) && !/^false$/.test(isAdmin)) {
                alert('Please enter proper value for the Administrator field');
                $('#isAdmin').focus();
                return false;
            }
		};	
	</script>
</body>
</html>