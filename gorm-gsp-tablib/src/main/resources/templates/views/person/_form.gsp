<%@ page import="com.person.Person" %>
<div class="fieldcontain required">
    <label for="name">
        Name
        <span class="required-indicator">*</span>
    </label>
    <input type="text" name="name" required="" value="${personInstance?.name}"/>

</div>

<div class="fieldcontain required">
    <label for="age">
        Age
        <span class="required-indicator">*</span>
    </label>
    <input name="age" type="text" value="${personInstance?.age}" required=""/>
</div>