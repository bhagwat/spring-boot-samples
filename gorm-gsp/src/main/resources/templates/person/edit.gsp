<%@ page import="com.person.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Edit person</title>
</head>

<body>
<a href="#edit-person" class="skip" tabindex="-1">Skip to content&hellip;</a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="/">Home</a></li>
        <li><a class="list" href="/person/list">List</a></li>
        <li><a class="create" href="/person/create">New person</a></li>
    </ul>
</div>

<div id="edit-person" class="content scaffold-edit" role="main">
    <h1>Edit person</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:if test="${personInstance?.hasErrors()}">
        <ul class="errors" role="alert">
            <g:each in="${personInstance.errors}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                    ${error}
                </li>
            </g:each>
        </ul>
    </g:if>
    <form action="/person/update/${personInstance.id}" method="post">
        <input type="hidden" name="version" value="${personInstance?.version}"/>
        <fieldset class="form">
            <g:render template="person/form"/>
        </fieldset>
        <fieldset class="buttons">
            <input type="submit" class="save" value="Update"/>
        </fieldset>
    </form>
</div>
</body>
</html>
