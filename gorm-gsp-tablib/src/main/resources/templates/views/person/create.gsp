<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>New person</title>
</head>

<body>
<a href="#create-person" class="skip" tabindex="-1">Skip to content&hellip;</a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="/">Home</a></li>
        <li><a href="/person/list" class="list">List</a></li>
    </ul>
</div>

<div id="create-person" class="content scaffold-create" role="main">
    <h1>New person</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
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
    <form action="/person/save" method="post">
        <fieldset class="form">
            <g:render template="/views/person/form"/>
        </fieldset>
        <fieldset class="buttons">
            <input type="submit" class="save" value="Save"/>
        </fieldset>
    </form>
</div>
</body>
</html>
