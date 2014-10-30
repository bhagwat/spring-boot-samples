<%@ page import="com.person.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Manage person</title>
</head>

<body>
<a href="#list-person" class="skip" tabindex="-1">Skip to content&hellip;</a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="/">Home</a></li>
        <li><a class="create" href="/person/create">New person</a></li>
    </ul>
</div>

<div id="list-person" class="content scaffold-list" role="main">
    <h1>Manage person</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${personInstanceList}" status="i" var="personInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td><a href="/person/show/${personInstance.id}">
                    %{--${g.fieldValue(bean: personInstance, field: "name")}--}%
                    ${personInstance.name}
                </a>
                </td>
                <td>
                    %{--${g.fieldValue(bean: personInstance, field: "age")}--}%
                    ${personInstance.age}
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>

    <app:paginate total="${personInstanceCount ?: 0}"
                  currentPage="${currentPage}"
                  action="/person/list"/>
</div>
</body>
</html>
