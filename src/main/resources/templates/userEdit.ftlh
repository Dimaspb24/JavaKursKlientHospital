<#import "parts/common.ftlh" as c >

<@c.page>
    <form action="/users" method="post">
<#--        нужно сделать поле с почтой неизменяемым-->
        <input type="text" name="email" value="${user.email}">
        <input type="text" name="password" placeholder="Новый пароль">
        <input type="text" name="firstName" value="${user.firstName}">
        <input type="text" name="lastName" value="${user.lastName}">
        <input type="text" name="role" value="${user.role}">
        <input type="text" name="status" value="${user.status}">
        <button type="submit"> Save </button>
    </form>
</@c.page>