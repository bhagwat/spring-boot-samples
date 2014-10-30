<%@ page import="com.person.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Show Person</title>
</head>

<body>
<a href="#show-person" class="skip" tabindex="-1">Skip to content&hellip;</a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="/">Home</a></li>
        <li><a class="list" href="/person/list">List</a>
        <li><a class="create" href="/person/create">New person</a></li>
    </ul>
</div>

<div id="show-person" class="content scaffold-show" role="main">
    <h1>Show person</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list person">

        <g:if test="${personInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label">Name</span>

                <span class="property-value" aria-labelledby="name-label">
                    ${personInstance.name}
                </span>

            </li>
        </g:if>

        <g:if test="${personInstance?.age}">
            <li class="fieldcontain">
                <span id="age-label" class="property-label">Age</span>

                <span class="property-value" aria-labelledby="age-label">
                    ${personInstance.age} years
                </span>
            </li>
        </g:if>
    </ol>

    <form action="/person/delete/${personInstance.id}" method="post">
        <fieldset class="buttons">
            <a class="edit" href="/person/edit/${personInstance.id}">
                Edit
            </a>

            <input type="submit" class="delete"
                   value="Delete"
                   onclick="return confirm('Are you sure?');"/>
        </fieldset>
    </form>
</div>
</body>
</html>
